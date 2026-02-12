import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.security.MessageDigest;
import org.jasypt.util.text.BasicTextEncryptor;
import org.openqa.selenium.support.Color;

import java.util.Scanner;

public class Login extends JFrame {

    private JTextField txtSis;
    private JButton btnIngresar;

    // --- CONFIGURACIÓN DE LA API BACKEND ---
    private static final String API_URL = "https://dracarys.onrender.com/usuarios/buscar/json/";
    private static final String API_KEY = "dracarys-secret-key-2026-xYz-99"; // La que definimos en Django

    private String rutaConf = System.getenv("LOCALAPPDATA") + "\\Wconf\\conf.txt";
    private String rutaSand = System.getenv("LOCALAPPDATA") + "\\Sand\\sand.txt";

    public Login() {
        super("Verificación SIS - Dracarys System");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblInstruccion = new JLabel("Ingresa tu Código SIS:", SwingConstants.CENTER);
        lblInstruccion.setFont(new Font("Arial", Font.BOLD, 14));
        
        txtSis = new JTextField();
        txtSis.setFont(new Font("Arial", Font.PLAIN, 16));
        txtSis.setHorizontalAlignment(JTextField.CENTER);

        btnIngresar = new JButton("VERIFICAR E INGRESAR");
        btnIngresar.setFont(new Font("Arial", Font.BOLD, 12));

        // Forzamos el uso de java.awt.Color
        btnIngresar.setBackground(new java.awt.Color(180, 40, 40)); 
        btnIngresar.setForeground(java.awt.Color.WHITE);

        btnIngresar.addActionListener(e -> verificarAcceso());

        panel.add(lblInstruccion);
        panel.add(txtSis);
        panel.add(btnIngresar);

        add(panel, BorderLayout.CENTER);
    }

    private void verificarAcceso() {
        String sisInput = txtSis.getText().trim();

        if (sisInput.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor escribe un código.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        btnIngresar.setEnabled(false);
        btnIngresar.setText("Conectando con Backend...");

        new Thread(() -> {
            try {
                // 1. PETICIÓN HTTP A LA API
                URL url = new URL(API_URL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("X-API-KEY", API_KEY); // Seguridad
                conn.setDoOutput(true);

                // Enviar el JSON {"sis": "valor"}
                String jsonInputString = "{\"sis\": \"" + sisInput + "\"}";
                try (OutputStream os = conn.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }
                //System.out.println("Solicitud enviada al backend.");
                int code = conn.getResponseCode();

                if (code == 200) {
                    // Leer respuesta
                    String response = leerRespuesta(conn.getInputStream());
                    response = response.replace(" ", "").replace("\n", "").replace("\r", "");
                    // Verificamos si existe y está habilitado (Parseo manual simple)
                    if (response.contains("\"exists\":true") && response.contains("\"enabled\":true")) {

                        if(response.contains("\"nrointentos\":0")){
                            int nroDeApi = extraerValorInt(response, "nromaterias");
                            configurarSistemaNuevoUsuario(sisInput, nroDeApi); 
                            abrirProgramaPrincipal(sisInput);
                        }else{
                            if (verificarArchivoLocal(sisInput)) {
                                abrirProgramaPrincipal(sisInput);
                            } else {
                                mostrarError("Archivos de configuración locales corruptos.");
                            }
                        }
                    } else if (response.contains("\"enabled\":false")) {
                        mostrarError("Tu cuenta está bloqueada en el sistema.");
                    } else {
                        mostrarError("Acceso denegado o usuario no configurado.");
                    }
                } else if (code == 404) {
                    mostrarError("Usuario no encontrado en la base de datos central.");
                } else if (code == 403 || code == 401) {
                    mostrarError("Error de autenticación con la API (Key inválida).");
                } else {
                    mostrarError("Error del servidor: " + code);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                mostrarError("No se pudo conectar con el Backend.\n¿Está encendido el servidor Django?");
            } finally {
                SwingUtilities.invokeLater(() -> {
                    btnIngresar.setEnabled(true);
                    btnIngresar.setText("VERIFICAR E INGRESAR");
                });
            }
        }).start();
    }

    // Método auxiliar para leer el flujo de entrada
    private String leerRespuesta(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    // --- MÉTODOS DE INTEGRIDAD (SE MANTIENEN IGUAL) ---

    public String calcularHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] archivoBytes = Files.readAllBytes(Paths.get(this.rutaConf));
            byte[] hashBytes = digest.digest(archivoBytes);
            String hashContenido = bytesToHex(hashBytes);
            File file = new File(this.rutaConf);
            long lastModified = file.lastModified();
            String hashModificacion = bytesToHex(digest.digest(String.valueOf(lastModified).getBytes(StandardCharsets.UTF_8)));
            return hashContenido + ":" + hashModificacion;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Licencia no encontrada", "Error", 0);
            System.exit(0);
            return null;
        }
    }

    public String leerHashGuardado() {
        try {
            File archivoHash = new File(this.rutaSand);
            if (!archivoHash.exists()) {
                return null;
            }
            return new String(Files.readAllBytes(archivoHash.toPath()), StandardCharsets.UTF_8).trim();
        } catch (Exception e) { return null; }
    }

    public void guardarHash(String hash) {
        try {
            Path rutaArchivo = Paths.get(this.rutaSand);
            if (!Files.exists(rutaArchivo.getParent())) Files.createDirectories(rutaArchivo.getParent());
            Files.write(rutaArchivo, hash.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) { System.exit(0); }
    }

    public boolean verificarIntegridad() {
        String hashActual = this.calcularHash();
        String hashGuardado = this.leerHashGuardado();
        if (hashGuardado == null) {
            this.guardarHash(hashActual);
            return true;
        }
        return hashActual.equals(hashGuardado);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private boolean verificarArchivoLocal(String sisInput) {
        if (!verificarIntegridad()) return false;
        
        File archivo = new File(rutaConf);
        if (!archivo.exists()) return false;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea1 = br.readLine(); 
            
            // --- VALIDACIÓN DE NULOS (EL ESCUDO) ---
            if (linea1 == null) {
                //System.out.println("El archivo está vacío.");
                return false;
            }

            BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
            textEncryptor.setPassword("SIA");

            try {
                // Intentamos desencriptar
                String desencriptado = textEncryptor.decrypt(linea1);
                
                if (desencriptado == null) return false;
                
                linea1 = desencriptado.trim();
            } catch (Exception e) { 
                // Si falla la desencriptación, verificamos si al menos no era nulo antes de hacer trim
                if (linea1 != null && linea1.trim().equals("")) {
                    return true;
                }
                return false;
            }
        
            return linea1.equals(sisInput) || linea1.isEmpty();

        } catch (IOException e) { 
            //System.out.println("Error al leer el archivo: " + e.getMessage());
            return false; 
        }
    }

    private void abrirProgramaPrincipal(String sisCadena) {
        SwingUtilities.invokeLater(() -> {
            this.dispose();
            try {
                new Ventana(sisCadena).setVisible(true);
                //ventana.setVisible(true);
            } catch (Exception e) { 
                JOptionPane.showMessageDialog(null, "Error al abrir el programa principal ", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void mostrarError(String mensaje) {
        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(this, mensaje, "Acceso Denegado", JOptionPane.ERROR_MESSAGE));
    }


    private void configurarSistemaNuevoUsuario(String sis, int nroMateriasBackend) {
        try {
            //System.out.println("--- Configurando archivos para SIS: " + sis + " ---");
            
            Path pSand = Paths.get(rutaSand);
            Path pConf = Paths.get(rutaConf);
            
            // 1. Limpieza inicial
            Files.deleteIfExists(pSand);
            
            // 2. Asegurar que existan las carpetas
            if (!Files.exists(pConf.getParent())) {
                Files.createDirectories(pConf.getParent());
            }

            // 3. Construir el archivo conf.txt (22 líneas + nro + pass)
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 22; i++) {
                sb.append("\n");
            }
            
            // Escribimos el número que definió el Admin en el Backend
            sb.append(nroMateriasBackend).append("\n");
            
            // Contraseña hardcoded según tu script de Python
            sb.append("vtvrEAFtCQLGH0mq3YzkCQ==");

            Files.write(pConf, sb.toString().getBytes(StandardCharsets.UTF_8));
            
            // 4. Notificar al Backend que el usuario ya realizó su primera configuración
            notificarPrimerIntentoExitoso(sis);
            
            //System.out.println("Configuración automática completada exitosamente.");
            
        } catch (Exception e) {
            mostrarError("Error crítico en configuración inicial: " + e.getMessage());
        }
    }

    private void notificarPrimerIntentoExitoso(String sis) {
        try {
            URL url = new URL("https://dracarys.onrender.com/usuarios/incrementar/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("X-API-KEY", API_KEY);
            conn.setDoOutput(true);
            
            String json = "{\"sis\": \"" + sis + "\"}";
            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes(StandardCharsets.UTF_8));
            }
            conn.getResponseCode(); // Disparamos la petición
        } catch (Exception e) { e.printStackTrace(); }
    }

    private int extraerValorInt(String response, String llave) {
        try {
            // Buscamos algo como "nromaterias":4
            String pattern = "\"" + llave + "\":";
            int inicio = response.indexOf(pattern) + pattern.length();
            int fin = response.indexOf(",", inicio);
            
            // Si es el último elemento del objeto JSON
            if (fin == -1) {
                fin = response.indexOf("}", inicio);
            }
            
            return Integer.parseInt(response.substring(inicio, fin).trim());
        } catch (Exception e) {
            return 3; // Valor por defecto por seguridad
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}