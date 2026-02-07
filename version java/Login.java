import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.security.MessageDigest;
import org.jasypt.util.text.BasicTextEncryptor;

public class Login extends JFrame {

    private JTextField txtSis;
    private JButton btnIngresar;

    // --- CONFIGURACIÓN DE SUPABASE (¡EDITAR ESTO!) ---
    // Copia el URI de tu foto, pero asegúrate de que empiece con "jdbc:postgresql://"
    // Ejemplo: jdbc:postgresql://db.vj...supabase.co:5432/postgres
    private static final String DB_URL = "jdbc:postgresql://db.ahtuagpnpsmycuhtoxmj.supabase.co:5432/postgres"; 
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "dracarysUMSS2026@";

    private String rutaConf = System.getenv("LOCALAPPDATA") + "\\Wconf\\conf.txt";
    private String rutaSand = System.getenv("LOCALAPPDATA") + "\\Sand\\sand.txt";

    public Login() {
        super("Verificación SIS - WebSISS Flow");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Componentes
        JLabel lblInstruccion = new JLabel("Ingresa tu Código SIS:", SwingConstants.CENTER);
        lblInstruccion.setFont(new Font("Arial", Font.BOLD, 14));
        
        txtSis = new JTextField();
        txtSis.setFont(new Font("Arial", Font.PLAIN, 16));
        txtSis.setHorizontalAlignment(JTextField.CENTER);

        btnIngresar = new JButton("VERIFICAR E INGRESAR");
        btnIngresar.setFont(new Font("Arial", Font.BOLD, 12));
        btnIngresar.setBackground(new Color(70, 130, 180));
        btnIngresar.setForeground(Color.WHITE);

        // Acción del Botón
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarAcceso();
            }
        });

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
        btnIngresar.setText("Verificando...");

        // Usamos un hilo aparte para no congelar la ventana mientras conecta a internet
        new Thread(() -> {
            try {
                // 1. CONEXIÓN A SUPABASE
                // Nota: Supabase requiere SSL, el driver lo maneja si la URL es correcta.
                try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                    
                    String sql = "SELECT enabled FROM \"Usuarios\" WHERE sis = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, sisInput);
                    
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        // --- CASO 1: EL USUARIO EXISTE ---
                        boolean isEnabled = rs.getBoolean("enabled");

                        if (isEnabled) {
                            // --- CASO 2: ESTÁ HABILITADO (ENABLED = TRUE) ---
                            // Ahora verificamos el archivo local conf.txt
                            if (verificarArchivoLocal(sisInput)) {
                                // --- FINAL: TODO CORRECTO ---
                                abrirProgramaPrincipal();
                            } else {
                                mostrarError("El código SIS no coincide con la configuración local (conf.txt).\nPor favor ejecuta el configurador nuevamente.");
                            }
                        } else {
                            // --- CASO 3: CUENTA BLOQUEADA (ENABLED = FALSE) ---
                            mostrarError("Tu cuenta está bloqueada.\nAcceso denegado.");
                        }

                    } else {
                        // --- CASO 4: NO EXISTE EN SUPABASE ---
                        mostrarError("Usuario no encontrado.\nContacte con el administrador.");
                    }
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                mostrarError("Error de conexión con la base de datos:\n" + ex.getMessage());
            } finally {
                SwingUtilities.invokeLater(() -> {
                    btnIngresar.setEnabled(true);
                    btnIngresar.setText("VERIFICAR E INGRESAR");
                });
            }
        }).start();
    }

    public String calcularHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] archivoBytes = Files.readAllBytes(Paths.get(this.rutaConf, new String[0]));
            byte[] hashBytes = digest.digest(archivoBytes);
            String hashContenido = bytesToHex(hashBytes);
            File file = new File(this.rutaConf);
            long lastModified = file.lastModified();
            String hashModificacion = bytesToHex(digest.digest(String.valueOf(lastModified).getBytes(StandardCharsets.UTF_8)));
            return hashContenido + ":" + hashModificacion;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, licencia no encontrada", "Error lost lic", 0);
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
        } catch (Exception e) {
            return null;
        }
    }


    public void guardarHash(String hash) {
        try {
            Path rutaArchivo = Paths.get(this.rutaSand, new String[0]);
            Path rutaCarpeta = rutaArchivo.getParent();
            if (!Files.exists(rutaCarpeta, new LinkOption[0])) {
                Files.createDirectories(rutaCarpeta, new FileAttribute[0]);
            }
            Files.write(rutaArchivo, hash.getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, escritura denegada", "Error save hash", 0);
            System.exit(0);
        }
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
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private boolean verificarArchivoLocal(String sisInput) {
        if(verificarIntegridad()){
            System.out.println("Integridad del archivo conf.txt verificada.");
            File archivo = new File(rutaConf);

            if (!archivo.exists()) {
                mostrarError("No se encuentra el archivo de configuración:\n" + rutaConf);
                return false;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                //System.out.println("Archivo conf.txt encontrado. Leyendo contenido...");
                String linea1 = br.readLine(); 
                //System.out.println("Contenido leído (encriptado): '" + linea1 + "'");
                BasicTextEncryptor textEncryptor;
                textEncryptor=new BasicTextEncryptor();
                textEncryptor.setPassword("SIA");
                //System.out.println("Desencriptando contenido...");
                try {
                    // Intentamos desencriptar, si falla es porque el formato no es correcto
                    linea1=textEncryptor.decrypt(linea1).trim();
                } catch (Exception e) {
                    mostrarError("El formato del archivo conf.txt es incorrecto o la contraseña de encriptación no coincide.\nPor favor ejecuta el configurador nuevamente.");
                    linea1 = ""; // Para evitar que el programa siga con un valor no válido
                }
                //System.out.println("Contenido desencriptado: '" + linea1 + "'");
                if (linea1 != null && linea1.trim().equals(sisInput)) {
                    return true;
                } else {
                    if(linea1.equals("".trim())){
                        return true;
                    }else{
                        System.out.println("Conflicto: Archivo dice '" + linea1 + "' vs Input '" + sisInput + "'");
                        return false;
                    }
                    
                }

            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else{
            return false;
        }
        
    }

    private void abrirProgramaPrincipal() {
        SwingUtilities.invokeLater(() -> {
            this.dispose(); // Cierra la ventana de Login
            
            // Instancia y muestra la ventana principal
            // Asegúrate de que tu clase Ventana tenga un constructor visible o método main
            try {
                new Ventana().setVisible(true); 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al abrir Ventana.java: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }

    private void mostrarError(String mensaje) {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(this, mensaje, "Acceso Denegado", JOptionPane.ERROR_MESSAGE);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}