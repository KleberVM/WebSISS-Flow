/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.jasypt.util.text.BasicTextEncryptor;


import oshi.SystemInfo;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;

public class Ventana
extends JFrame {
    private Inscripcion materia1;
    private Inscripcion materia2;
    private Inscripcion materia3;
    private Inscripcion materia4;
    private Inscripcion materia5;
    private Inscripcion materia6;
    private Inscripcion materia7;
    private Inscripcion materia8;
    private Inscripcion materia9;
    private Inscripcion websis;
    public static List<String> datos = new ArrayList<String>();
    private static final int PORT = 58029;
    private String rutaConf = System.getenv("LOCALAPPDATA") + "\\Wconf\\conf.txt";
    private String rutaSand = System.getenv("LOCALAPPDATA") + "\\Sand\\sand.txt";
    private ServerSocket serverSocket;
    private String serialNumber;
    JButton boton = new JButton();
    JTextField texto = new JTextField();
    JPanel panel = new JPanel();
    public static boolean verifyProcess = false;
    public static boolean apertura = false;
    public boolean colapse = false;
    private Color rojo = new Color(255, 163, 114);
    private String rutaMateria = System.getProperty("user.dir") + "\\Archivos\\";
    private BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
    public static List<String> listaMaterias = new ArrayList<String>();
    private JButton AbrirMateria1;
    private JButton AbrirMateria2;
    private JButton AbrirMateria3;
    private JButton AbrirMateria4;
    private JButton AbrirMateria5;
    private JButton AbrirMateria6;
    private JButton AbrirMateria7;
    private JButton AbrirMateria8;
    private JButton AbrirMateria9;
    private JButton InsMateria1;
    private JButton InsMateria2;
    private JButton InsMateria3;
    private JButton InsMateria4;
    private JButton InsMateria5;
    private JButton InsMateria6;
    private JButton InsMateria7;
    private JButton InsMateria8;
    private JButton InsMateria9;
    private JButton jButtonGuardar;
    private JButton jButtonSalir;
    private JButton jButtonStop1;
    private JButton jButtonStop2;
    private JButton jButtonStop3;
    private JButton jButtonStop4;
    private JButton jButtonStop5;
    private JButton jButtonStop6;
    private JButton jButtonStop7;
    private JButton jButtonStop8;
    private JButton jButtonStop9;
    private JButton jButtonWebsis;
    private JComboBox<String> jComboBoxAnio;
    private JComboBox<String> jComboBoxCambiar1;
    private JComboBox<String> jComboBoxCambiar2;
    private JComboBox<String> jComboBoxCambiar3;
    private JComboBox<String> jComboBoxCambiar4;
    private JComboBox<String> jComboBoxCambiar5;
    private JComboBox<String> jComboBoxCambiar6;
    private JComboBox<String> jComboBoxCambiar7;
    private JComboBox<String> jComboBoxCambiar8;
    private JComboBox<String> jComboBoxCambiar9;
    private JComboBox<String> jComboBoxDia;
    private JComboBox<String> jComboBoxManual;
    private JComboBox<String> jComboBoxMes;
    private JComboBox<String> jComboBoxMesa1;
    private JComboBox<String> jComboBoxMesa2;
    private JComboBox<String> jComboBoxMesa3;
    private JComboBox<String> jComboBoxMesa4;
    private JComboBox<String> jComboBoxMesa5;
    private JComboBox<String> jComboBoxMesa6;
    private JComboBox<String> jComboBoxMesa7;
    private JComboBox<String> jComboBoxMesa8;
    private JComboBox<String> jComboBoxMesa9;
    private JComboBox<String> jComboBoxSelectFacultad;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel15;
    private JLabel jLabel17;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel23;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel34;
    private JLabel jLabel35;
    private JLabel jLabel37;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanelBotones;
    private JPanel jPanelDatos;
    private JPanel jPanelM1;
    private JPanel jPanelM2;
    private JPanel jPanelM3;
    private JPanel jPanelM4;
    private JPanel jPanelM5;
    private JPanel jPanelM6;
    private JPanel jPanelM7;
    private JPanel jPanelM8;
    private JPanel jPanelM9;
    private JPasswordField jPasswordFieldPass;
    private JPasswordField jPasswordFieldSis;
    private JScrollPane jScrollPane1;
    private JTextField jTextFieldCod1;
    private JTextField jTextFieldCod2;
    private JTextField jTextFieldCod3;
    private JTextField jTextFieldCod4;
    private JTextField jTextFieldCod5;
    private JTextField jTextFieldDocente1;
    private JTextField jTextFieldDocente2;
    private JTextField jTextFieldDocente3;
    private JTextField jTextFieldDocente4;
    private JTextField jTextFieldDocente5;
    private JTextField jTextFieldDocente6;
    private JTextField jTextFieldDocente7;
    private JTextField jTextFieldDocente8;
    private JTextField jTextFieldDocente9;
    private JComboBox<String> jTextFieldMateria1;
    private JComboBox<String> jTextFieldMateria2;
    private JComboBox<String> jTextFieldMateria3;
    private JComboBox<String> jTextFieldMateria4;
    private JComboBox<String> jTextFieldMateria5;
    private JComboBox<String> jTextFieldMateria6;
    private JComboBox<String> jTextFieldMateria7;
    private JComboBox<String> jTextFieldMateria8;
    private JComboBox<String> jTextFieldMateria9;
    private JTextField jTextFieldPractica1;
    private JTextField jTextFieldPractica2;
    private JTextField jTextFieldPractica3;
    private JTextField jTextFieldPractica4;
    private JTextField jTextFieldPractica5;
    private JTextField jTextFieldPractica6;
    private JTextField jTextFieldPractica7;
    private JTextField jTextFieldPractica8;
    private JTextField jTextFieldPractica9;
    private String siscodgallo;

    public Ventana(String siscodgallo) {
        int i;
        this.siscodgallo = siscodgallo;
        System.out.println("este es codi sis: "+ siscodgallo);

        this.textEncryptor.setPassword("SIA");
        JDialog loadingDialog = new JDialog((Frame)null, "CARGANDO...", true);
        loadingDialog.setSize(300, 100);
        loadingDialog.setLocationRelativeTo(null);
        new Thread(() -> loadingDialog.setVisible(true)).start();
        new Thread(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            loadingDialog.dispose();
        }).start();
        try {
            this.serverSocket = new ServerSocket(58029);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "El programa ya se esta ejecutando", "Error", 0);
            System.exit(0);
        }
        this.initComponents();
        if (!this.verificarIntegridad()) {
            JOptionPane.showMessageDialog(null, "Error, archivo corrupto", "File change verify", 0);
            System.exit(0);
        }
        this.addWindowListener(new WindowAdapter(){

            @Override
            public void windowOpened(WindowEvent e) {
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int width = screenSize.width / 2;
                int height = screenSize.height;
                Ventana.this.setSize(width, height - height / 16);
                Ventana.this.setLocation(0, 0);
            }
        });
        this.jPasswordFieldSis.setEnabled(false);
        this.animacionCombobox(this.jComboBoxMesa1);
        this.animacionCombobox(this.jComboBoxMesa2);
        this.animacionCombobox(this.jComboBoxMesa3);
        this.animacionCombobox(this.jComboBoxMesa4);
        this.animacionCombobox(this.jComboBoxMesa5);
        this.animacionCombobox(this.jComboBoxMesa6);
        this.animacionCombobox(this.jComboBoxCambiar1);
        this.animacionCombobox(this.jComboBoxCambiar2);
        this.animacionCombobox(this.jComboBoxCambiar3);
        this.animacionCombobox(this.jComboBoxCambiar4);
        this.animacionCombobox(this.jComboBoxCambiar5);
        this.animacionCombobox(this.jComboBoxCambiar6);
        this.jComboBoxDia.removeAllItems();
        for (i = 1; i < 32; ++i) {
            this.jComboBoxDia.addItem("" + i);
        }
        this.jComboBoxDia.setSelectedItem("15");
        this.jComboBoxAnio.removeAllItems();
        for (i = 2030; i > 1960; --i) {
            this.jComboBoxAnio.addItem("" + i);
        }
        this.jComboBoxAnio.setSelectedItem("2010");
        this.jComboBoxMes.removeAllItems();
        this.jComboBoxMes.addItem("Enero");
        this.jComboBoxMes.addItem("Febrero");
        this.jComboBoxMes.addItem("Marzo");
        this.jComboBoxMes.addItem("Abril");
        this.jComboBoxMes.addItem("Mayo");
        this.jComboBoxMes.addItem("Junio");
        this.jComboBoxMes.addItem("Julio");
        this.jComboBoxMes.addItem("Agosto");
        this.jComboBoxMes.addItem("Septiembre");
        this.jComboBoxMes.addItem("Octubre");
        this.jComboBoxMes.addItem("Noviembre");
        this.jComboBoxMes.addItem("Diciembre");
        this.leerDatos();
        loadingDialog.dispose();
        if (Ventana.esMaquinaVirtual()) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el programa, el sistema no es compatible", "VM", 0);
            System.exit(0);
        }
        try {
            String linea;
            URL url = new URL("https://raw.githubusercontent.com/siatechbolivia/SiaUmss/refs/heads/main/list.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((linea = reader.readLine()) != null) {
                if (!this.serialNumber.equals(linea.trim())) continue;
                JOptionPane.showMessageDialog(null, "Error al ejecutar el programa, licencia removida del equipo.", "Licencia removida.", 0);
                System.exit(0);
            }
            reader.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a internet, verifique su conexi\u00f3n a internet e intente abrir el programa nuevamente.", "Error conexion internet", 0);
            System.exit(0);
        }
        this.InsMateria1.setEnabled(false);
        this.InsMateria2.setEnabled(false);
        this.InsMateria3.setEnabled(false);
        this.InsMateria4.setEnabled(false);
        this.InsMateria5.setEnabled(false);
        this.InsMateria6.setEnabled(false);
        this.InsMateria7.setEnabled(false);
        this.InsMateria8.setEnabled(false);
        this.InsMateria9.setEnabled(false);
        this.jButtonStop1.setEnabled(false);
        this.jButtonStop2.setEnabled(false);
        this.jButtonStop3.setEnabled(false);
        this.jButtonStop4.setEnabled(false);
        this.jButtonStop5.setEnabled(false);
        this.jButtonStop6.setEnabled(false);
        this.jButtonStop7.setEnabled(false);
        this.jButtonStop8.setEnabled(false);
        this.jButtonStop9.setEnabled(false);
        this.jPasswordFieldSis.setEchoChar('\u0000');
        this.websis = new Inscripcion(this.boton, this.boton, this.texto, this.jComboBoxMesa1, this.boton, this.panel, this.texto, this.jComboBoxMesa1, this.jComboBoxCambiar1);
        this.materia1 = new Inscripcion(this.InsMateria1, this.jButtonStop1, this.jTextFieldDocente1, this.jTextFieldMateria1, this.AbrirMateria1, this.jPanelM1, this.jTextFieldPractica1, this.jComboBoxMesa1, this.jComboBoxCambiar1);
        this.materia2 = new Inscripcion(this.InsMateria2, this.jButtonStop2, this.jTextFieldDocente2, this.jTextFieldMateria2, this.AbrirMateria2, this.jPanelM2, this.jTextFieldPractica2, this.jComboBoxMesa2, this.jComboBoxCambiar2);
        this.materia3 = new Inscripcion(this.InsMateria3, this.jButtonStop3, this.jTextFieldDocente3, this.jTextFieldMateria3, this.AbrirMateria3, this.jPanelM3, this.jTextFieldPractica3, this.jComboBoxMesa3, this.jComboBoxCambiar3);
        this.materia4 = new Inscripcion(this.InsMateria4, this.jButtonStop4, this.jTextFieldDocente4, this.jTextFieldMateria4, this.AbrirMateria4, this.jPanelM4, this.jTextFieldPractica4, this.jComboBoxMesa4, this.jComboBoxCambiar4);
        this.materia5 = new Inscripcion(this.InsMateria5, this.jButtonStop5, this.jTextFieldDocente5, this.jTextFieldMateria5, this.AbrirMateria5, this.jPanelM5, this.jTextFieldPractica5, this.jComboBoxMesa5, this.jComboBoxCambiar5);
        this.materia6 = new Inscripcion(this.InsMateria6, this.jButtonStop6, this.jTextFieldDocente6, this.jTextFieldMateria6, this.AbrirMateria6, this.jPanelM6, this.jTextFieldPractica6, this.jComboBoxMesa6, this.jComboBoxCambiar6);
        this.jPasswordFieldPass.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 27) {
                    Ventana.this.jPasswordFieldPass.setEchoChar('\u0000');
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Ventana.this.jPasswordFieldPass.setEchoChar('*');
            }
        });
        this.cargarItemsDesdeArchivo("facultades.txt", this.jComboBoxSelectFacultad);
        this.jComboBoxSelectFacultad.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String)Ventana.this.jComboBoxSelectFacultad.getSelectedItem()) {
                    case "FAC. CIENCIAS ECONOMICAS": {
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS ECONOMICAS.txt", Ventana.this.jTextFieldMateria1);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS ECONOMICAS.txt", Ventana.this.jTextFieldMateria2);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS ECONOMICAS.txt", Ventana.this.jTextFieldMateria3);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS ECONOMICAS.txt", Ventana.this.jTextFieldMateria4);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS ECONOMICAS.txt", Ventana.this.jTextFieldMateria5);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS ECONOMICAS.txt", Ventana.this.jTextFieldMateria6);
                        break;
                    }
                    case "FAC. DESARROLLO RURAL Y TERRITORIAL": {
                        Ventana.this.cargarItemsDesdeArchivo("FAC. DESARROLLO RURAL Y TERRITORIAL.txt", Ventana.this.jTextFieldMateria1);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. DESARROLLO RURAL Y TERRITORIAL.txt", Ventana.this.jTextFieldMateria2);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. DESARROLLO RURAL Y TERRITORIAL.txt", Ventana.this.jTextFieldMateria3);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. DESARROLLO RURAL Y TERRITORIAL.txt", Ventana.this.jTextFieldMateria4);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. DESARROLLO RURAL Y TERRITORIAL.txt", Ventana.this.jTextFieldMateria5);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. DESARROLLO RURAL Y TERRITORIAL.txt", Ventana.this.jTextFieldMateria6);
                        break;
                    }
                    case "FAC. ODONTOLOGIA": {
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ODONTOLOGIA.txt", Ventana.this.jTextFieldMateria1);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ODONTOLOGIA.txt", Ventana.this.jTextFieldMateria2);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ODONTOLOGIA.txt", Ventana.this.jTextFieldMateria3);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ODONTOLOGIA.txt", Ventana.this.jTextFieldMateria4);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ODONTOLOGIA.txt", Ventana.this.jTextFieldMateria5);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ODONTOLOGIA.txt", Ventana.this.jTextFieldMateria6);
                        break;
                    }
                    case "FAC. MEDICINA": {
                        Ventana.this.cargarItemsDesdeArchivo("FAC. MEDICINA.txt", Ventana.this.jTextFieldMateria1);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. MEDICINA.txt", Ventana.this.jTextFieldMateria2);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. MEDICINA.txt", Ventana.this.jTextFieldMateria3);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. MEDICINA.txt", Ventana.this.jTextFieldMateria4);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. MEDICINA.txt", Ventana.this.jTextFieldMateria5);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. MEDICINA.txt", Ventana.this.jTextFieldMateria6);
                        break;
                    }
                    case "FAC. ARQUITECTURA Y CIENCIAS DEL HA": {
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ARQUITECTURA Y CIENCIAS DEL HA.txt", Ventana.this.jTextFieldMateria1);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ARQUITECTURA Y CIENCIAS DEL HA.txt", Ventana.this.jTextFieldMateria2);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ARQUITECTURA Y CIENCIAS DEL HA.txt", Ventana.this.jTextFieldMateria3);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ARQUITECTURA Y CIENCIAS DEL HA.txt", Ventana.this.jTextFieldMateria4);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ARQUITECTURA Y CIENCIAS DEL HA.txt", Ventana.this.jTextFieldMateria5);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ARQUITECTURA Y CIENCIAS DEL HA.txt", Ventana.this.jTextFieldMateria6);
                        break;
                    }
                    case "FAC. HUMANIDADES Y CS. DE EDUCACION": {
                        Ventana.this.cargarItemsDesdeArchivo("FAC. HUMANIDADES Y CS. DE EDUCACION.txt", Ventana.this.jTextFieldMateria1);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. HUMANIDADES Y CS. DE EDUCACION.txt", Ventana.this.jTextFieldMateria2);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. HUMANIDADES Y CS. DE EDUCACION.txt", Ventana.this.jTextFieldMateria3);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. HUMANIDADES Y CS. DE EDUCACION.txt", Ventana.this.jTextFieldMateria4);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. HUMANIDADES Y CS. DE EDUCACION.txt", Ventana.this.jTextFieldMateria5);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. HUMANIDADES Y CS. DE EDUCACION.txt", Ventana.this.jTextFieldMateria6);
                        break;
                    }
                    case "FAC. CIENCIAS JURIDICAS Y POLITICAS": {
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS JURIDICAS Y POLITICAS.txt", Ventana.this.jTextFieldMateria1);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS JURIDICAS Y POLITICAS.txt", Ventana.this.jTextFieldMateria2);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS JURIDICAS Y POLITICAS.txt", Ventana.this.jTextFieldMateria3);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS JURIDICAS Y POLITICAS.txt", Ventana.this.jTextFieldMateria4);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS JURIDICAS Y POLITICAS.txt", Ventana.this.jTextFieldMateria5);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS JURIDICAS Y POLITICAS.txt", Ventana.this.jTextFieldMateria6);
                        break;
                    }
                    case "FAC. CIENCIAS Y TECNOLOGIA": {
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS Y TECNOLOGIA.txt", Ventana.this.jTextFieldMateria1);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS Y TECNOLOGIA.txt", Ventana.this.jTextFieldMateria2);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS Y TECNOLOGIA.txt", Ventana.this.jTextFieldMateria3);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS Y TECNOLOGIA.txt", Ventana.this.jTextFieldMateria4);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS Y TECNOLOGIA.txt", Ventana.this.jTextFieldMateria5);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS Y TECNOLOGIA.txt", Ventana.this.jTextFieldMateria6);
                        break;
                    }
                    case "FAC. CIENCIAS VETERINARIAS": {
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS VETERINARIAS.txt", Ventana.this.jTextFieldMateria1);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS VETERINARIAS.txt", Ventana.this.jTextFieldMateria2);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS VETERINARIAS.txt", Ventana.this.jTextFieldMateria3);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS VETERINARIAS.txt", Ventana.this.jTextFieldMateria4);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS VETERINARIAS.txt", Ventana.this.jTextFieldMateria5);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. CIENCIAS VETERINARIAS.txt", Ventana.this.jTextFieldMateria6);
                        break;
                    }
                    case "FAC. ENFERMERIA": {
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ENFERMERIA.txt", Ventana.this.jTextFieldMateria1);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ENFERMERIA.txt", Ventana.this.jTextFieldMateria2);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ENFERMERIA.txt", Ventana.this.jTextFieldMateria3);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ENFERMERIA.txt", Ventana.this.jTextFieldMateria4);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ENFERMERIA.txt", Ventana.this.jTextFieldMateria5);
                        Ventana.this.cargarItemsDesdeArchivo("FAC. ENFERMERIA.txt", Ventana.this.jTextFieldMateria6);
                        break;
                    }
                }
            }
        });
        this.jComboBoxManual.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if (Ventana.this.jComboBoxManual.getSelectedItem().equals("MANUAL")) {
                    Ventana.this.jTextFieldMateria1.setEditable(true);
                    Ventana.this.jTextFieldMateria2.setEditable(true);
                    Ventana.this.jTextFieldMateria3.setEditable(true);
                    Ventana.this.jTextFieldMateria4.setEditable(true);
                    Ventana.this.jTextFieldMateria5.setEditable(true);
                    Ventana.this.jTextFieldMateria6.setEditable(true);
                } else {
                    Ventana.this.jTextFieldMateria1.setEditable(false);
                    Ventana.this.jTextFieldMateria2.setEditable(false);
                    Ventana.this.jTextFieldMateria3.setEditable(false);
                    Ventana.this.jTextFieldMateria4.setEditable(false);
                    Ventana.this.jTextFieldMateria5.setEditable(false);
                    Ventana.this.jTextFieldMateria6.setEditable(false);
                }
            }
        });
        
    }

    public boolean agregarCadena(String cadena) {
        int frecuencia = Collections.frequency(listaMaterias, cadena);
        if (frecuencia >= 2) {
            return false;
        }
        listaMaterias.add(cadena);
        return true;
    }

    private void cargarItemsDesdeArchivo(String facultad, JComboBox box) {
        File archivo;
        String contenido = (String)box.getSelectedItem();
        box.removeAllItems();
        if (contenido != null && !contenido.isBlank()) {
            box.addItem(contenido);
        }
        if (!(archivo = new File(this.rutaMateria + facultad)).exists()) {
            JOptionPane.showMessageDialog(this, "El archivo con la lista de maeterias no existe, copie el nombre de la materia desde el PDF de la oferta academica de su carrera manualmente", "Error", 0);
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo));){
            String linea;
            while ((linea = br.readLine()) != null) {
                box.addItem(linea);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar materias de facultad, copie el nombre de la materia desde PDF de la oferta academica de su carrera manualmente", "Error", 0);
        }
    }

    public String calcularHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] archivoBytes = Files.readAllBytes(Paths.get(this.rutaConf, new String[0]));
            byte[] hashBytes = digest.digest(archivoBytes);
            String hashContenido = Ventana.bytesToHex(hashBytes);
            File file = new File(this.rutaConf);
            long lastModified = file.lastModified();
            String hashModificacion = Ventana.bytesToHex(digest.digest(String.valueOf(lastModified).getBytes(StandardCharsets.UTF_8)));
            return hashContenido + ":" + hashModificacion;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, licencia no encontrada", "Error lost lic", 0);
            System.exit(0);
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

    public void animacionCombobox(final JComboBox combo) {
        combo.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (combo.getSelectedIndex() == 1) {
                    combo.setBackground(Color.CYAN);
                } else {
                    combo.setBackground(Color.GRAY);
                }
            }
        });
    }

    public void cargarDatos() {
        datos.clear();
        String nombreArchivo = this.rutaConf;
        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            for (int fila = 0; fila < 24; ++fila) {
                datos.add(lector.readLine());
            }
            lector.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la licencia", "Licencia no encontrada", 0);
            System.exit(0);
        }
    }

    public void leerDatos() {
        String[] dat;
        this.cargarDatos();
        String sis = "", pas = "", mat = "";
        if (datos.get(23) == null || datos.get(23).isBlank()) {
            JOptionPane.showMessageDialog(null, "Error, archivo corrupto", "SN delete", 0);
            System.exit(0);
        }
        try {
            SystemInfo systemInfo = new SystemInfo();
            HardwareAbstractionLayer hal = systemInfo.getHardware();
            File unidadC = new File("C:\\");
            if (unidadC.exists() && unidadC.isDirectory()) {
                for (HWDiskStore disk : hal.getDiskStores()) {
                    if (!disk.getPartitions().stream().anyMatch(p -> p.getMountPoint().equalsIgnoreCase("C:\\"))) continue;
                    this.serialNumber = disk.getSerial().trim() + "AIS";
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener informaci\u00f3n de licencia", "SerialNumber not", 0);
            System.exit(0);
        }
        this.jComboBoxDia.setSelectedItem(datos.get(2));
        this.jComboBoxMes.setSelectedItem(datos.get(3));
        this.jComboBoxAnio.setSelectedItem(datos.get(4));
        this.jTextFieldCod1.setText(datos.get(5));
        this.jTextFieldCod2.setText(datos.get(6));
        this.jTextFieldCod3.setText(datos.get(7));
        this.jTextFieldCod4.setText(datos.get(8));
        this.jTextFieldCod5.setText(datos.get(9));
        if (datos.get(10).split(",").length > 2) {
            dat = datos.get(10).split(",");
            this.jTextFieldMateria1.addItem(dat[0]);
            this.jComboBoxCambiar1.setSelectedItem(dat[1]);
            this.jComboBoxMesa1.setSelectedItem(dat[2]);
        } else {
            this.jTextFieldMateria1.addItem(datos.get(10));
        }
        if (datos.get(11).split(",").length > 1) {
            dat = datos.get(11).split(",");
            this.jTextFieldDocente1.setText(dat[0]);
            this.jTextFieldPractica1.setText(dat[1]);
        } else {
            this.jTextFieldDocente1.setText(datos.get(11));
        }
        if (datos.get(12).split(",").length > 2) {
            dat = datos.get(12).split(",");
            this.jTextFieldMateria2.addItem(dat[0]);
            this.jComboBoxCambiar2.setSelectedItem(dat[1]);
            this.jComboBoxMesa2.setSelectedItem(dat[2]);
        } else {
            this.jTextFieldMateria2.addItem(datos.get(12));
        }
        if (datos.get(13).split(",").length > 1) {
            dat = datos.get(13).split(",");
            this.jTextFieldDocente2.setText(dat[0]);
            this.jTextFieldPractica2.setText(dat[1]);
        } else {
            this.jTextFieldDocente2.setText(datos.get(13));
        }
        if (datos.get(14).split(",").length > 2) {
            dat = datos.get(14).split(",");
            this.jTextFieldMateria3.addItem(dat[0]);
            this.jComboBoxCambiar3.setSelectedItem(dat[1]);
            this.jComboBoxMesa3.setSelectedItem(dat[2]);
        } else {
            this.jTextFieldMateria3.addItem(datos.get(14));
        }
        if (datos.get(15).split(",").length > 1) {
            dat = datos.get(15).split(",");
            this.jTextFieldDocente3.setText(dat[0]);
            this.jTextFieldPractica3.setText(dat[1]);
        } else {
            this.jTextFieldDocente3.setText(datos.get(15));
        }
        if (datos.get(16).split(",").length > 2) {
            dat = datos.get(16).split(",");
            this.jTextFieldMateria4.addItem(dat[0]);
            this.jComboBoxCambiar4.setSelectedItem(dat[1]);
            this.jComboBoxMesa4.setSelectedItem(dat[2]);
        } else {
            this.jTextFieldMateria4.addItem(datos.get(16));
        }
        if (datos.get(17).split(",").length > 1) {
            dat = datos.get(17).split(",");
            this.jTextFieldDocente4.setText(dat[0]);
            this.jTextFieldPractica4.setText(dat[1]);
        } else {
            this.jTextFieldDocente4.setText(datos.get(17));
        }
        if (datos.get(18).split(",").length > 2) {
            dat = datos.get(18).split(",");
            this.jTextFieldMateria5.addItem(dat[0]);
            this.jComboBoxCambiar5.setSelectedItem(dat[1]);
            this.jComboBoxMesa5.setSelectedItem(dat[2]);
        } else {
            this.jTextFieldMateria5.addItem(datos.get(18));
        }
        if (datos.get(19).split(",").length > 1) {
            dat = datos.get(19).split(",");
            this.jTextFieldDocente5.setText(dat[0]);
            this.jTextFieldPractica5.setText(dat[1]);
        } else {
            this.jTextFieldDocente5.setText(datos.get(19));
        }
        if (datos.get(20).split(",").length > 2) {
            dat = datos.get(20).split(",");
            this.jTextFieldMateria6.addItem(dat[0]);
            this.jComboBoxCambiar6.setSelectedItem(dat[1]);
            this.jComboBoxMesa6.setSelectedItem(dat[2]);
        } else {
            this.jTextFieldMateria6.addItem(datos.get(20));
        }
        if (datos.get(21).split(",").length > 1) {
            dat = datos.get(21).split(",");
            this.jTextFieldDocente6.setText(dat[0]);
            this.jTextFieldPractica6.setText(dat[1]);
        } else {
            this.jTextFieldDocente6.setText(datos.get(21));
        }
        String serialNew = datos.get(23) + "AIS";
        if (serialNew.equals(this.serialNumber + "AIS")) {
            sis= this.siscodgallo;
            //is = this.desencriptarCadena(datos.get(0));
            datos.set(0, sis);
            mat = this.desencriptarCadena(datos.get(22));
            datos.set(22, mat);
            this.jPasswordFieldSis.setText(datos.get(0));
            this.jPasswordFieldPass.setText(datos.get(1));
            this.escribirDatos(false);
            this.cargarDatos();
            String sisA = this.desencriptarCadena(datos.get(0));
            datos.set(0, sisA);
            String pasA = this.desencriptarCadena(datos.get(1));
            datos.set(1, pasA);
            String matA = this.desencriptarCadena(datos.get(22));
            datos.set(22, matA);
            this.jPasswordFieldSis.setEnabled(false);
        } else if (serialNew.equals(this.serialNumber)) {
            this.jPasswordFieldSis.setText(datos.get(0));
            this.jPasswordFieldPass.setText(datos.get(1));
            this.escribirDatos(false);
            this.cargarDatos();
            sis = this.desencriptarCadena(datos.get(0));
            datos.set(0, sis);
            pas = this.desencriptarCadena(datos.get(1));
            datos.set(1, pas);
            mat = this.desencriptarCadena(datos.get(22));
            datos.set(22, mat);
            this.jPasswordFieldSis.setEnabled(false);
        } else if (this.desencriptarCadena(datos.get(23)) != null) {
            String sn = this.desencriptarCadena(datos.get(23));
            if (sn.equals("SERIAL")) {
                this.escribirDatos(false);
                this.cargarDatos();
                sis =this.siscodgallo;
                //sis = this.desencriptarCadena(datos.get(0));
                datos.set(0, sis);
                pas = this.desencriptarCadena(datos.get(1));
                datos.set(1, pas);
                mat = this.desencriptarCadena(datos.get(22));
                datos.set(22, mat);//datos.get(0)
                System.out.println("este es codi sis: "+ this.siscodgallo);
                this.jPasswordFieldSis.setText(datos.get(0));
                this.jPasswordFieldPass.setText(datos.get(1));
                this.jPasswordFieldSis.setEnabled(false);
            } else if (sn.equals(this.serialNumber)) {
                sis =this.siscodgallo;
                //sis = this.desencriptarCadena(datos.get(0));
                datos.set(0, sis);

                System.out.println("Serial desencriptado: " + sis);
                if (sis.isEmpty()) {
                    this.jPasswordFieldSis.setEnabled(true);
                } else {
                    this.jPasswordFieldSis.setEnabled(false);
                }
                pas = this.desencriptarCadena(datos.get(1));
                datos.set(1, pas);
                mat = this.desencriptarCadena(datos.get(22));
                datos.set(22, mat);
                this.jPasswordFieldSis.setText(datos.get(0));
                this.jPasswordFieldPass.setText(datos.get(1));
            } else if (!sn.equals(this.serialNumber)) {
                JOptionPane.showMessageDialog(null, "Error, Licencia no v\u00e1lida", "CloneDisk", 0);
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error, archivo corrupto", "SN change or delete", 0);
            System.exit(0);
        }
        if (datos.get(0).equals("202103580")) {
            JOptionPane.showMessageDialog(null, "Error, no se puede ejecutar el programa", "Error block", 0);
            System.exit(0);
        }
        switch (datos.get(22)) {
            case "1": {
                this.jPanelM2.setVisible(false);
                this.jPanelM3.setVisible(false);
                this.jPanelM4.setVisible(false);
                this.jPanelM5.setVisible(false);
                this.jPanelM6.setVisible(false);
                this.jPanelM7.setVisible(false);
                this.jPanelM8.setVisible(false);
                this.jPanelM9.setVisible(false);
                break;
            }
            case "2": {
                this.jPanelM3.setVisible(false);
                this.jPanelM4.setVisible(false);
                this.jPanelM5.setVisible(false);
                this.jPanelM6.setVisible(false);
                this.jPanelM7.setVisible(false);
                this.jPanelM8.setVisible(false);
                this.jPanelM9.setVisible(false);
                break;
            }
            case "3": {
                this.jPanelM4.setVisible(false);
                this.jPanelM5.setVisible(false);
                this.jPanelM6.setVisible(false);
                this.jPanelM7.setVisible(false);
                this.jPanelM8.setVisible(false);
                this.jPanelM9.setVisible(false);
                break;
            }
            case "4": {
                this.jPanelM5.setVisible(false);
                this.jPanelM6.setVisible(false);
                this.jPanelM7.setVisible(false);
                this.jPanelM8.setVisible(false);
                this.jPanelM9.setVisible(false);
                break;
            }
            case "5": {
                this.jPanelM6.setVisible(false);
                this.jPanelM7.setVisible(false);
                this.jPanelM8.setVisible(false);
                this.jPanelM9.setVisible(false);
                break;
            }
            case "6": {
                this.jPanelM7.setVisible(false);
                this.jPanelM8.setVisible(false);
                this.jPanelM9.setVisible(false);
                break;
            }
            case "7": {
                this.jPanelM8.setVisible(false);
                this.jPanelM9.setVisible(false);
                break;
            }
            case "8": {
                this.jPanelM9.setVisible(false);
                break;
            }
            case "9": {
                break;
            }
            default: {
                this.jPanelM1.setVisible(false);
                this.jPanelM2.setVisible(false);
                this.jPanelM3.setVisible(false);
                this.jPanelM4.setVisible(false);
                this.jPanelM5.setVisible(false);
                this.jPanelM6.setVisible(false);
                this.jPanelM7.setVisible(false);
                this.jPanelM8.setVisible(false);
                this.jPanelM9.setVisible(false);
            }
        }
        this.guardarHash(this.calcularHash());
    }

    public void escribirDatos(boolean serial) {
        String nombreArchivo = this.rutaConf;
        String grupo1 = this.jTextFieldPractica1.getText().trim().isEmpty() ? this.jTextFieldDocente1.getText().trim().toUpperCase() : this.jTextFieldDocente1.getText().trim().toUpperCase() + "," + this.jTextFieldPractica1.getText().trim().toUpperCase();
        String grupo2 = this.jTextFieldPractica2.getText().trim().isEmpty() ? this.jTextFieldDocente2.getText().trim().toUpperCase() : this.jTextFieldDocente2.getText().trim().toUpperCase() + "," + this.jTextFieldPractica2.getText().trim().toUpperCase();
        String grupo3 = this.jTextFieldPractica3.getText().trim().isEmpty() ? this.jTextFieldDocente3.getText().trim().toUpperCase() : this.jTextFieldDocente3.getText().trim().toUpperCase() + "," + this.jTextFieldPractica3.getText().trim().toUpperCase();
        String grupo4 = this.jTextFieldPractica4.getText().trim().isEmpty() ? this.jTextFieldDocente4.getText().trim().toUpperCase() : this.jTextFieldDocente4.getText().trim().toUpperCase() + "," + this.jTextFieldPractica4.getText().trim().toUpperCase();
        String grupo5 = this.jTextFieldPractica5.getText().trim().isEmpty() ? this.jTextFieldDocente5.getText().trim().toUpperCase() : this.jTextFieldDocente5.getText().trim().toUpperCase() + "," + this.jTextFieldPractica5.getText().trim().toUpperCase();
        String grupo6 = this.jTextFieldPractica6.getText().trim().isEmpty() ? this.jTextFieldDocente6.getText().trim().toUpperCase() : this.jTextFieldDocente6.getText().trim().toUpperCase() + "," + this.jTextFieldPractica6.getText().trim().toUpperCase();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));){
            String[] nuevosDatos;
            for (String linea : nuevosDatos = new String[]{this.textEncryptor.encrypt(this.jPasswordFieldSis.getText().trim()),
                 this.textEncryptor.encrypt(this.jPasswordFieldPass.getText().trim()),
                  (String)this.jComboBoxDia.getSelectedItem()
                  , (String)this.jComboBoxMes.getSelectedItem()
                  , (String)this.jComboBoxAnio.getSelectedItem()
                  , this.jTextFieldCod1.getText().trim().toUpperCase()
                  , this.jTextFieldCod2.getText().trim().toUpperCase()
                  , this.jTextFieldCod3.getText().trim().toUpperCase()
                  , this.jTextFieldCod4.getText().trim().toUpperCase()
                  , this.jTextFieldCod5.getText().trim().toUpperCase()
                  , ((String)this.jTextFieldMateria1.getSelectedItem()).trim().toUpperCase() + "," + String.valueOf(this.jComboBoxCambiar1.getSelectedItem()) + "," + String.valueOf(this.jComboBoxMesa1.getSelectedItem()), grupo1, ((String)this.jTextFieldMateria2.getSelectedItem()).trim().toUpperCase() + "," + String.valueOf(this.jComboBoxCambiar2.getSelectedItem()) + "," + String.valueOf(this.jComboBoxMesa2.getSelectedItem()), grupo2, ((String)this.jTextFieldMateria3.getSelectedItem()).trim().toUpperCase() + "," + String.valueOf(this.jComboBoxCambiar3.getSelectedItem()) + "," + String.valueOf(this.jComboBoxMesa3.getSelectedItem()), grupo3, ((String)this.jTextFieldMateria4.getSelectedItem()).trim().toUpperCase() + "," + String.valueOf(this.jComboBoxCambiar4.getSelectedItem()) + "," + String.valueOf(this.jComboBoxMesa4.getSelectedItem()), grupo4, ((String)this.jTextFieldMateria5.getSelectedItem()).trim().toUpperCase() + "," + String.valueOf(this.jComboBoxCambiar5.getSelectedItem()) + "," + String.valueOf(this.jComboBoxMesa5.getSelectedItem()), grupo5, ((String)this.jTextFieldMateria6.getSelectedItem()).trim().toUpperCase() + "," + String.valueOf(this.jComboBoxCambiar6.getSelectedItem()) + "," + String.valueOf(this.jComboBoxMesa6.getSelectedItem()), grupo6, this.textEncryptor.encrypt(datos.get(22)), this.textEncryptor.encrypt(this.serialNumber)}) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (serial) {
            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente!!!!");
        }
    }

    public String desencriptarCadena(String cadena) {
        try {
            return this.textEncryptor.decrypt(cadena);
        } catch (EncryptionOperationNotPossibleException e) {
            return null;
        }
    }

    public static boolean esMaquinaVirtual() {
        SystemInfo systemInfo = new SystemInfo();
        ComputerSystem cs = systemInfo.getHardware().getComputerSystem();
        String fabricante = cs.getManufacturer().toLowerCase();
        String modelo = cs.getModel().toLowerCase();
        String bios = cs.getFirmware().getManufacturer().toLowerCase();
        String[] vmFabricantes = new String[]{"vmware", "virtualbox", "qemu", "xen", "microsoft", "parallels"};
        String[] vmModelos = new String[]{"virtual", "vmware", "kvm", "hyper-v", "parallels"};
        for (String vm : vmFabricantes) {
            if (!fabricante.contains(vm) && !bios.contains(vm)) continue;
            return true;
        }
        for (String vm : vmModelos) {
            if (!modelo.contains(vm)) continue;
            return true;
        }
        List<NetworkIF> interfaces = systemInfo.getHardware().getNetworkIFs();
        for (NetworkIF net : interfaces) {
            String mac = net.getMacaddr();
            if (!mac.startsWith("00:05:69") && !mac.startsWith("00:0C:29") && !mac.startsWith("00:1C:14") && !mac.startsWith("08:00:27") && !mac.startsWith("52:54:00")) continue;
            return true;
        }
        return false;
    }

    private void initComponents() {
        this.jPanel3 = new JPanel();
        this.jPanel1 = new JPanel();
        this.jPanelDatos = new JPanel();
        this.jPasswordFieldPass = new JPasswordField();
        this.jLabel8 = new JLabel();
        this.jComboBoxAnio = new JComboBox();
        this.jTextFieldCod4 = new JTextField();
        this.jLabel9 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jPasswordFieldSis = new JPasswordField();
        this.jComboBoxMes = new JComboBox();
        this.jTextFieldCod2 = new JTextField();
        this.jLabel10 = new JLabel();
        this.jComboBoxDia = new JComboBox();
        this.jTextFieldCod3 = new JTextField();
        this.jTextFieldCod5 = new JTextField();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jTextFieldCod1 = new JTextField();
        this.jComboBoxSelectFacultad = new JComboBox();
        this.jComboBoxManual = new JComboBox();
        this.jPanel4 = new JPanel();
        this.jButtonSalir = new JButton();
        this.jPanelBotones = new JPanel();
        this.jButtonWebsis = new JButton();
        this.jButtonGuardar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.jPanel2 = new JPanel();
        this.jPanelM1 = new JPanel();
        this.jTextFieldDocente1 = new JTextField();
        this.AbrirMateria1 = new JButton();
        this.InsMateria1 = new JButton();
        this.jButtonStop1 = new JButton();
        this.jTextFieldPractica1 = new JTextField();
        this.jLabel1 = new JLabel();
        this.jComboBoxMesa1 = new JComboBox();
        this.jComboBoxCambiar1 = new JComboBox();
        this.jLabel15 = new JLabel();
        this.jTextFieldMateria1 = new JComboBox();
        this.jPanelM2 = new JPanel();
        this.jTextFieldDocente2 = new JTextField();
        this.AbrirMateria2 = new JButton();
        this.InsMateria2 = new JButton();
        this.jButtonStop2 = new JButton();
        this.jTextFieldPractica2 = new JTextField();
        this.jLabel7 = new JLabel();
        this.jComboBoxMesa2 = new JComboBox();
        this.jComboBoxCambiar2 = new JComboBox();
        this.jLabel17 = new JLabel();
        this.jTextFieldMateria2 = new JComboBox();
        this.jPanelM3 = new JPanel();
        this.jTextFieldDocente3 = new JTextField();
        this.AbrirMateria3 = new JButton();
        this.InsMateria3 = new JButton();
        this.jButtonStop3 = new JButton();
        this.jTextFieldPractica3 = new JTextField();
        this.jLabel13 = new JLabel();
        this.jComboBoxMesa3 = new JComboBox();
        this.jComboBoxCambiar3 = new JComboBox();
        this.jLabel19 = new JLabel();
        this.jTextFieldMateria3 = new JComboBox();
        this.jPanelM4 = new JPanel();
        this.jTextFieldDocente4 = new JTextField();
        this.AbrirMateria4 = new JButton();
        this.InsMateria4 = new JButton();
        this.jButtonStop4 = new JButton();
        this.jTextFieldPractica4 = new JTextField();
        this.jLabel20 = new JLabel();
        this.jComboBoxMesa4 = new JComboBox();
        this.jComboBoxCambiar4 = new JComboBox();
        this.jLabel23 = new JLabel();
        this.jTextFieldMateria4 = new JComboBox();
        this.jPanelM5 = new JPanel();
        this.jTextFieldDocente5 = new JTextField();
        this.AbrirMateria5 = new JButton();
        this.InsMateria5 = new JButton();
        this.jButtonStop5 = new JButton();
        this.jTextFieldPractica5 = new JTextField();
        this.jLabel21 = new JLabel();
        this.jComboBoxMesa5 = new JComboBox();
        this.jComboBoxCambiar5 = new JComboBox();
        this.jLabel25 = new JLabel();
        this.jTextFieldMateria5 = new JComboBox();
        this.jPanelM6 = new JPanel();
        this.jTextFieldDocente6 = new JTextField();
        this.AbrirMateria6 = new JButton();
        this.InsMateria6 = new JButton();
        this.jButtonStop6 = new JButton();
        this.jTextFieldPractica6 = new JTextField();
        this.jLabel26 = new JLabel();
        this.jComboBoxMesa6 = new JComboBox();
        this.jComboBoxCambiar6 = new JComboBox();
        this.jLabel28 = new JLabel();
        this.jTextFieldMateria6 = new JComboBox();
        this.jPanelM7 = new JPanel();
        this.jTextFieldDocente7 = new JTextField();
        this.AbrirMateria7 = new JButton();
        this.InsMateria7 = new JButton();
        this.jButtonStop7 = new JButton();
        this.jTextFieldPractica7 = new JTextField();
        this.jLabel29 = new JLabel();
        this.jComboBoxMesa7 = new JComboBox();
        this.jComboBoxCambiar7 = new JComboBox();
        this.jLabel31 = new JLabel();
        this.jTextFieldMateria7 = new JComboBox();
        this.jPanelM8 = new JPanel();
        this.jTextFieldDocente8 = new JTextField();
        this.AbrirMateria8 = new JButton();
        this.InsMateria8 = new JButton();
        this.jButtonStop8 = new JButton();
        this.jTextFieldPractica8 = new JTextField();
        this.jLabel32 = new JLabel();
        this.jComboBoxMesa8 = new JComboBox();
        this.jComboBoxCambiar8 = new JComboBox();
        this.jLabel34 = new JLabel();
        this.jTextFieldMateria8 = new JComboBox();
        this.jPanelM9 = new JPanel();
        this.jTextFieldDocente9 = new JTextField();
        this.AbrirMateria9 = new JButton();
        this.InsMateria9 = new JButton();
        this.jButtonStop9 = new JButton();
        this.jTextFieldPractica9 = new JTextField();
        this.jLabel35 = new JLabel();
        this.jComboBoxMesa9 = new JComboBox();
        this.jComboBoxCambiar9 = new JComboBox();
        this.jLabel37 = new JLabel();
        this.jTextFieldMateria9 = new JComboBox();
        this.setDefaultCloseOperation(3);
        this.setSize(this.size());
        this.jPanel3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 499, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 12, Short.MAX_VALUE));
        this.jLabel8.setText("Cod 1");
        this.jComboBoxAnio.setModel(new DefaultComboBoxModel<String>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        this.jComboBoxAnio.setCursor(new Cursor(12));
        this.jLabel9.setText("Cod 2");
        this.jLabel12.setText("Cod 5");
        this.jLabel11.setText("Cod 4");
        this.jComboBoxMes.setModel(new DefaultComboBoxModel<String>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        this.jComboBoxMes.setCursor(new Cursor(12));
        this.jLabel10.setText("Cod 3");
        this.jComboBoxDia.setModel(new DefaultComboBoxModel<String>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        this.jComboBoxDia.setCursor(new Cursor(12));
        this.jLabel2.setText("C\u00f3digo SIS");
        this.jLabel3.setText("Contrase\u00f1a");
        this.jComboBoxSelectFacultad.setModel(new DefaultComboBoxModel<String>(new String[]{"Selecione AQU\u00cd una facultad para tener la lista de materias"}));
        this.jComboBoxSelectFacultad.setPreferredSize(new Dimension(368, 26));
        this.jComboBoxManual.setModel(new DefaultComboBoxModel<String>(new String[]{"Si no encuentra su materia, elija \"MANUAL\" para escribirla", "MANUAL"}));
        this.jComboBoxManual.setPreferredSize(new Dimension(368, 26));
        GroupLayout jPanelDatosLayout = new GroupLayout(this.jPanelDatos);
        this.jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(jPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelDatosLayout.createSequentialGroup().addContainerGap().addGroup(jPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanelDatosLayout.createSequentialGroup().addGroup(jPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel3)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPasswordFieldSis, -1, 291, Short.MAX_VALUE).addComponent(this.jPasswordFieldPass)).addGap(12, 12, 12)).addGroup(jPanelDatosLayout.createSequentialGroup().addComponent(this.jComboBoxDia, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jComboBoxMes, 0, 152, Short.MAX_VALUE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jComboBoxAnio, -2, 99, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))).addGroup(jPanelDatosLayout.createSequentialGroup().addGroup(jPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jComboBoxSelectFacultad, 0, -1, Short.MAX_VALUE).addComponent(this.jComboBoxManual, 0, -1, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(jPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel11).addComponent(this.jLabel12).addComponent(this.jLabel10).addComponent(this.jLabel9).addComponent(this.jLabel8)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jTextFieldCod5, -1, 80, Short.MAX_VALUE).addComponent(this.jTextFieldCod4).addComponent(this.jTextFieldCod3).addComponent(this.jTextFieldCod2).addComponent(this.jTextFieldCod1)).addContainerGap(-1, Short.MAX_VALUE)));
        jPanelDatosLayout.setVerticalGroup(jPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelDatosLayout.createSequentialGroup().addContainerGap().addGroup(jPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jPasswordFieldSis, -2, -1, -2).addComponent(this.jLabel2).addComponent(this.jLabel8).addComponent(this.jTextFieldCod1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jPasswordFieldPass, -2, -1, -2).addComponent(this.jLabel3).addComponent(this.jLabel9).addComponent(this.jTextFieldCod2, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jComboBoxDia, -2, -1, -2).addComponent(this.jLabel10).addComponent(this.jTextFieldCod3, -2, -1, -2).addComponent(this.jComboBoxMes, -2, -1, -2).addComponent(this.jComboBoxAnio, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.jTextFieldCod4, -2, -1, -2).addComponent(this.jComboBoxSelectFacultad, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.jTextFieldCod5, -2, -1, -2).addComponent(this.jComboBoxManual, -2, -1, -2)).addGap(12, 12, 12)));
        this.jButtonSalir.setBackground(SystemColor.activeCaption);
        this.jButtonSalir.setFont(new Font("Dialog", 0, 24));
        this.jButtonSalir.setIcon(new ImageIcon(this.getClass().getResource("/Images/hide-keyboard.png")));
        this.jButtonSalir.setCursor(new Cursor(12));
        this.jButtonSalir.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.jButtonSalirActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jButtonSalir, -2, 64, -2).addContainerGap(-1, Short.MAX_VALUE)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButtonSalir));
        this.jButtonWebsis.setBackground(SystemColor.activeCaption);
        this.jButtonWebsis.setFont(new Font("Dialog", 1, 12));
        this.jButtonWebsis.setIcon(new ImageIcon(this.getClass().getResource("/Images/chrome.png")));
        this.jButtonWebsis.setText("WEBSIS");
        this.jButtonWebsis.setToolTipText("");
        this.jButtonWebsis.setCursor(new Cursor(12));
        this.jButtonWebsis.setHorizontalTextPosition(0);
        this.jButtonWebsis.setVerticalTextPosition(3);
        this.jButtonWebsis.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.jButtonWebsisActionPerformed(evt);
            }
        });
        this.jButtonGuardar.setBackground(SystemColor.activeCaption);
        this.jButtonGuardar.setFont(new Font("Dialog", 1, 12));
        this.jButtonGuardar.setIcon(new ImageIcon(this.getClass().getResource("/Images/saveico.png")));
        this.jButtonGuardar.setText("GUARDAR");
        this.jButtonGuardar.setCursor(new Cursor(12));
        this.jButtonGuardar.setHorizontalTextPosition(0);
        this.jButtonGuardar.setVerticalTextPosition(3);
        this.jButtonGuardar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.jButtonGuardarActionPerformed(evt);
            }
        });
        GroupLayout jPanelBotonesLayout = new GroupLayout(this.jPanelBotones);
        this.jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(jPanelBotonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelBotonesLayout.createSequentialGroup().addContainerGap().addGroup(jPanelBotonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButtonGuardar, -1, -1, Short.MAX_VALUE).addComponent(this.jButtonWebsis, -1, -1, Short.MAX_VALUE)).addContainerGap(-1, Short.MAX_VALUE)));
        jPanelBotonesLayout.setVerticalGroup(jPanelBotonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelBotonesLayout.createSequentialGroup().addContainerGap().addComponent(this.jButtonGuardar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButtonWebsis).addContainerGap()));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanelDatos, -1, -1, Short.MAX_VALUE).addComponent(this.jPanel1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanelBotones, -1, -1, Short.MAX_VALUE).addComponent(this.jPanel4, -1, -1, Short.MAX_VALUE)).addGap(22, 22, 22)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel3Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanelBotones, -1, -1, Short.MAX_VALUE)).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanelDatos, -1, -1, Short.MAX_VALUE)));
        this.jScrollPane1.setHorizontalScrollBarPolicy(31);
        this.jScrollPane1.setVerticalScrollBarPolicy(22);
        this.jScrollPane1.setCursor(new Cursor(0));
        this.jScrollPane1.setWheelScrollingEnabled(false);
        this.jPanel2.setBackground(new Color(153, 153, 153));
        this.jPanelM1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.AbrirMateria1.setBackground(SystemColor.activeCaption);
        this.AbrirMateria1.setFont(new Font("Dialog", 1, 12));
        this.AbrirMateria1.setText("PASO 1");
        this.AbrirMateria1.setCursor(new Cursor(12));
        this.AbrirMateria1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.AbrirMateria1ActionPerformed(evt);
            }
        });
        this.InsMateria1.setBackground(SystemColor.activeCaption);
        this.InsMateria1.setFont(new Font("Dialog", 1, 12));
        this.InsMateria1.setText("PASO 3");
        this.InsMateria1.setCursor(new Cursor(12));
        this.InsMateria1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.InsMateria1ActionPerformed(evt);
            }
        });
        this.jButtonStop1.setBackground(new Color(244, 67, 54));
        this.jButtonStop1.setFont(new Font("Dialog", 1, 12));
        this.jButtonStop1.setForeground(new Color(255, 255, 255));
        this.jButtonStop1.setText("X");
        this.jButtonStop1.setCursor(new Cursor(12));
        this.jButtonStop1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.jButtonStop1ActionPerformed(evt);
            }
        });
        this.jLabel1.setText("GrPr\u00e1ct");
        this.jComboBoxMesa1.setModel(new DefaultComboBoxModel<String>(new String[]{"Normal", "Mesa"}));
        this.jComboBoxCambiar1.setModel(new DefaultComboBoxModel<String>(new String[]{"Inscribir", "Cambiar"}));
        this.jLabel15.setText("Grupo");
        this.jTextFieldMateria1.setPreferredSize(new Dimension(381, 26));
        GroupLayout jPanelM1Layout = new GroupLayout(this.jPanelM1);
        this.jPanelM1.setLayout(jPanelM1Layout);
        jPanelM1Layout.setHorizontalGroup(jPanelM1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM1Layout.createSequentialGroup().addGroup(jPanelM1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jComboBoxMesa1, 0, -1, Short.MAX_VALUE).addComponent(this.jComboBoxCambiar1, 0, 82, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanelM1Layout.createSequentialGroup().addComponent(this.jLabel15).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldDocente1, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldPractica1)).addComponent(this.jTextFieldMateria1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanelM1Layout.createSequentialGroup().addComponent(this.InsMateria1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonStop1)).addComponent(this.AbrirMateria1, -1, -1, Short.MAX_VALUE)).addGap(75, 75, 75)));
        jPanelM1Layout.setVerticalGroup(jPanelM1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM1Layout.createSequentialGroup().addContainerGap().addGroup(jPanelM1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AbrirMateria1).addComponent(this.jComboBoxCambiar1, -2, -1, -2).addComponent(this.jTextFieldMateria1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextFieldPractica1, -2, -1, -2).addComponent(this.jLabel1).addComponent(this.jTextFieldDocente1, -2, -1, -2).addComponent(this.jComboBoxMesa1, -2, -1, -2).addComponent(this.InsMateria1).addComponent(this.jLabel15).addComponent(this.jButtonStop1)).addContainerGap(7, Short.MAX_VALUE)));
        this.jPanelM2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.AbrirMateria2.setBackground(SystemColor.activeCaption);
        this.AbrirMateria2.setFont(new Font("Dialog", 1, 12));
        this.AbrirMateria2.setText("PASO 1");
        this.AbrirMateria2.setCursor(new Cursor(12));
        this.AbrirMateria2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.AbrirMateria2ActionPerformed(evt);
            }
        });
        this.InsMateria2.setBackground(SystemColor.activeCaption);
        this.InsMateria2.setFont(new Font("Dialog", 1, 12));
        this.InsMateria2.setText("PASO 3");
        this.InsMateria2.setCursor(new Cursor(12));
        this.InsMateria2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.InsMateria2ActionPerformed(evt);
            }
        });
        this.jButtonStop2.setBackground(new Color(244, 67, 54));
        this.jButtonStop2.setFont(new Font("Dialog", 1, 12));
        this.jButtonStop2.setForeground(new Color(255, 255, 255));
        this.jButtonStop2.setText("X");
        this.jButtonStop2.setCursor(new Cursor(12));
        this.jButtonStop2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.jButtonStop2ActionPerformed(evt);
            }
        });
        this.jLabel7.setText("GrPr\u00e1ct");
        this.jComboBoxMesa2.setModel(new DefaultComboBoxModel<String>(new String[]{"Normal", "Mesa"}));
        this.jComboBoxCambiar2.setModel(new DefaultComboBoxModel<String>(new String[]{"Inscribir", "Cambiar"}));
        this.jLabel17.setText("Grupo");
        this.jTextFieldMateria2.setPreferredSize(new Dimension(381, 26));
        GroupLayout jPanelM2Layout = new GroupLayout(this.jPanelM2);
        this.jPanelM2.setLayout(jPanelM2Layout);
        jPanelM2Layout.setHorizontalGroup(jPanelM2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM2Layout.createSequentialGroup().addGroup(jPanelM2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jComboBoxMesa2, 0, -1, Short.MAX_VALUE).addComponent(this.jComboBoxCambiar2, 0, 82, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM2Layout.createSequentialGroup().addComponent(this.jLabel17).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldDocente2, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldPractica2)).addComponent(this.jTextFieldMateria2, 0, -1, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanelM2Layout.createSequentialGroup().addComponent(this.InsMateria2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonStop2)).addComponent(this.AbrirMateria2, -1, -1, Short.MAX_VALUE)).addGap(75, 75, 75)));
        jPanelM2Layout.setVerticalGroup(jPanelM2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM2Layout.createSequentialGroup().addContainerGap().addGroup(jPanelM2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AbrirMateria2).addComponent(this.jComboBoxCambiar2, -2, -1, -2).addComponent(this.jTextFieldMateria2, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextFieldDocente2, -2, -1, -2).addComponent(this.jTextFieldPractica2, -2, -1, -2).addComponent(this.jLabel7).addComponent(this.InsMateria2).addComponent(this.jComboBoxMesa2, -2, -1, -2).addComponent(this.jLabel17).addComponent(this.jButtonStop2)).addContainerGap(7, Short.MAX_VALUE)));
        this.jPanelM3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.AbrirMateria3.setBackground(SystemColor.activeCaption);
        this.AbrirMateria3.setFont(new Font("Dialog", 1, 12));
        this.AbrirMateria3.setText("PASO 1");
        this.AbrirMateria3.setCursor(new Cursor(12));
        this.AbrirMateria3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.AbrirMateria3ActionPerformed(evt);
            }
        });
        this.InsMateria3.setBackground(SystemColor.activeCaption);
        this.InsMateria3.setFont(new Font("Dialog", 1, 12));
        this.InsMateria3.setText("PASO 3");
        this.InsMateria3.setCursor(new Cursor(12));
        this.InsMateria3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.InsMateria3ActionPerformed(evt);
            }
        });
        this.jButtonStop3.setBackground(new Color(244, 67, 54));
        this.jButtonStop3.setFont(new Font("Dialog", 1, 12));
        this.jButtonStop3.setForeground(new Color(255, 255, 255));
        this.jButtonStop3.setText("X");
        this.jButtonStop3.setCursor(new Cursor(12));
        this.jButtonStop3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.jButtonStop3ActionPerformed(evt);
            }
        });
        this.jLabel13.setText("GrPr\u00e1ct");
        this.jComboBoxMesa3.setModel(new DefaultComboBoxModel<String>(new String[]{"Normal", "Mesa"}));
        this.jComboBoxCambiar3.setModel(new DefaultComboBoxModel<String>(new String[]{"Inscribir", "Cambiar"}));
        this.jLabel19.setText("Grupo");
        this.jTextFieldMateria3.setMinimumSize(new Dimension(352, 26));
        this.jTextFieldMateria3.setPreferredSize(new Dimension(381, 26));
        GroupLayout jPanelM3Layout = new GroupLayout(this.jPanelM3);
        this.jPanelM3.setLayout(jPanelM3Layout);
        jPanelM3Layout.setHorizontalGroup(jPanelM3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM3Layout.createSequentialGroup().addGroup(jPanelM3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jComboBoxMesa3, 0, -1, Short.MAX_VALUE).addComponent(this.jComboBoxCambiar3, 0, 82, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM3Layout.createSequentialGroup().addComponent(this.jLabel19).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldDocente3, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel13).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldPractica3)).addComponent(this.jTextFieldMateria3, 0, -1, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanelM3Layout.createSequentialGroup().addComponent(this.InsMateria3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonStop3)).addComponent(this.AbrirMateria3, -1, -1, Short.MAX_VALUE)).addGap(75, 75, 75)));
        jPanelM3Layout.setVerticalGroup(jPanelM3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM3Layout.createSequentialGroup().addContainerGap().addGroup(jPanelM3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AbrirMateria3).addComponent(this.jComboBoxCambiar3, -2, -1, -2).addComponent(this.jTextFieldMateria3, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextFieldDocente3, -2, -1, -2).addComponent(this.jTextFieldPractica3, -2, -1, -2).addComponent(this.jLabel13).addComponent(this.jComboBoxMesa3, -2, -1, -2).addComponent(this.jLabel19)).addGroup(jPanelM3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.InsMateria3).addComponent(this.jButtonStop3))).addContainerGap(7, Short.MAX_VALUE)));
        this.jPanelM4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.AbrirMateria4.setBackground(SystemColor.activeCaption);
        this.AbrirMateria4.setFont(new Font("Dialog", 1, 12));
        this.AbrirMateria4.setText("PASO 1");
        this.AbrirMateria4.setCursor(new Cursor(12));
        this.AbrirMateria4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.AbrirMateria4ActionPerformed(evt);
            }
        });
        this.InsMateria4.setBackground(SystemColor.activeCaption);
        this.InsMateria4.setFont(new Font("Dialog", 1, 12));
        this.InsMateria4.setText("PASO 3");
        this.InsMateria4.setCursor(new Cursor(12));
        this.InsMateria4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.InsMateria4ActionPerformed(evt);
            }
        });
        this.jButtonStop4.setBackground(new Color(244, 67, 54));
        this.jButtonStop4.setFont(new Font("Dialog", 1, 12));
        this.jButtonStop4.setForeground(new Color(255, 255, 255));
        this.jButtonStop4.setText("X");
        this.jButtonStop4.setCursor(new Cursor(12));
        this.jButtonStop4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.jButtonStop4ActionPerformed(evt);
            }
        });
        this.jLabel20.setText("GrPr\u00e1ct");
        this.jComboBoxMesa4.setModel(new DefaultComboBoxModel<String>(new String[]{"Normal", "Mesa"}));
        this.jComboBoxCambiar4.setModel(new DefaultComboBoxModel<String>(new String[]{"Inscribir", "Cambiar"}));
        this.jLabel23.setText("Grupo");
        this.jTextFieldMateria4.setMinimumSize(new Dimension(352, 26));
        this.jTextFieldMateria4.setPreferredSize(new Dimension(381, 26));
        GroupLayout jPanelM4Layout = new GroupLayout(this.jPanelM4);
        this.jPanelM4.setLayout(jPanelM4Layout);
        jPanelM4Layout.setHorizontalGroup(jPanelM4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM4Layout.createSequentialGroup().addGroup(jPanelM4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jComboBoxMesa4, 0, -1, Short.MAX_VALUE).addComponent(this.jComboBoxCambiar4, 0, 82, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM4Layout.createSequentialGroup().addComponent(this.jLabel23).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldDocente4, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel20).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldPractica4)).addComponent(this.jTextFieldMateria4, 0, -1, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanelM4Layout.createSequentialGroup().addComponent(this.InsMateria4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonStop4)).addComponent(this.AbrirMateria4, -1, -1, Short.MAX_VALUE)).addGap(75, 75, 75)));
        jPanelM4Layout.setVerticalGroup(jPanelM4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM4Layout.createSequentialGroup().addContainerGap().addGroup(jPanelM4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AbrirMateria4).addComponent(this.jComboBoxCambiar4, -2, -1, -2).addComponent(this.jTextFieldMateria4, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextFieldDocente4, -2, -1, -2).addComponent(this.jTextFieldPractica4, -2, -1, -2).addComponent(this.jLabel20).addComponent(this.jComboBoxMesa4, -2, -1, -2).addComponent(this.jLabel23)).addGroup(jPanelM4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.InsMateria4).addComponent(this.jButtonStop4))).addContainerGap(7, Short.MAX_VALUE)));
        this.jPanelM5.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.AbrirMateria5.setBackground(SystemColor.activeCaption);
        this.AbrirMateria5.setFont(new Font("Dialog", 1, 12));
        this.AbrirMateria5.setText("PASO 1");
        this.AbrirMateria5.setCursor(new Cursor(12));
        this.AbrirMateria5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.AbrirMateria5ActionPerformed(evt);
            }
        });
        this.InsMateria5.setBackground(SystemColor.activeCaption);
        this.InsMateria5.setFont(new Font("Dialog", 1, 12));
        this.InsMateria5.setText("PASO 3");
        this.InsMateria5.setCursor(new Cursor(12));
        this.InsMateria5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.InsMateria5ActionPerformed(evt);
            }
        });
        this.jButtonStop5.setBackground(new Color(244, 67, 54));
        this.jButtonStop5.setFont(new Font("Dialog", 1, 12));
        this.jButtonStop5.setForeground(new Color(255, 255, 255));
        this.jButtonStop5.setText("X");
        this.jButtonStop5.setCursor(new Cursor(12));
        this.jButtonStop5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.jButtonStop5ActionPerformed(evt);
            }
        });
        this.jLabel21.setText("GrPr\u00e1ct");
        this.jComboBoxMesa5.setModel(new DefaultComboBoxModel<String>(new String[]{"Normal", "Mesa"}));
        this.jComboBoxCambiar5.setModel(new DefaultComboBoxModel<String>(new String[]{"Inscribir", "Cambiar"}));
        this.jLabel25.setText("Grupo");
        this.jTextFieldMateria5.setMinimumSize(new Dimension(352, 26));
        this.jTextFieldMateria5.setPreferredSize(new Dimension(381, 26));
        GroupLayout jPanelM5Layout = new GroupLayout(this.jPanelM5);
        this.jPanelM5.setLayout(jPanelM5Layout);
        jPanelM5Layout.setHorizontalGroup(jPanelM5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM5Layout.createSequentialGroup().addGroup(jPanelM5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jComboBoxMesa5, 0, -1, Short.MAX_VALUE).addComponent(this.jComboBoxCambiar5, 0, 82, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM5Layout.createSequentialGroup().addComponent(this.jLabel25).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldDocente5, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel21).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldPractica5)).addComponent(this.jTextFieldMateria5, 0, -1, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanelM5Layout.createSequentialGroup().addComponent(this.InsMateria5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonStop5)).addComponent(this.AbrirMateria5, -1, -1, Short.MAX_VALUE)).addGap(75, 75, 75)));
        jPanelM5Layout.setVerticalGroup(jPanelM5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM5Layout.createSequentialGroup().addContainerGap().addGroup(jPanelM5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AbrirMateria5).addComponent(this.jComboBoxCambiar5, -2, -1, -2).addComponent(this.jTextFieldMateria5, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextFieldDocente5, -2, -1, -2).addComponent(this.jTextFieldPractica5, -2, -1, -2).addComponent(this.jLabel21).addComponent(this.jComboBoxMesa5, -2, -1, -2).addComponent(this.jLabel25)).addGroup(jPanelM5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.InsMateria5).addComponent(this.jButtonStop5))).addContainerGap(7, Short.MAX_VALUE)));
        this.jPanelM6.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.AbrirMateria6.setBackground(SystemColor.activeCaption);
        this.AbrirMateria6.setFont(new Font("Dialog", 1, 12));
        this.AbrirMateria6.setText("PASO 1");
        this.AbrirMateria6.setCursor(new Cursor(12));
        this.AbrirMateria6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.AbrirMateria6ActionPerformed(evt);
            }
        });
        this.InsMateria6.setBackground(SystemColor.activeCaption);
        this.InsMateria6.setFont(new Font("Dialog", 1, 12));
        this.InsMateria6.setText("PASO 3");
        this.InsMateria6.setCursor(new Cursor(12));
        this.InsMateria6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.InsMateria6ActionPerformed(evt);
            }
        });
        this.jButtonStop6.setBackground(new Color(244, 67, 54));
        this.jButtonStop6.setFont(new Font("Dialog", 1, 12));
        this.jButtonStop6.setForeground(new Color(255, 255, 255));
        this.jButtonStop6.setText("X");
        this.jButtonStop6.setCursor(new Cursor(12));
        this.jButtonStop6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.jButtonStop6ActionPerformed(evt);
            }
        });
        this.jLabel26.setText("GrPr\u00e1ct");
        this.jComboBoxMesa6.setModel(new DefaultComboBoxModel<String>(new String[]{"Normal", "Mesa"}));
        this.jComboBoxCambiar6.setModel(new DefaultComboBoxModel<String>(new String[]{"Inscribir", "Cambiar"}));
        this.jLabel28.setText("Grupo");
        this.jTextFieldMateria6.setPreferredSize(new Dimension(381, 26));
        GroupLayout jPanelM6Layout = new GroupLayout(this.jPanelM6);
        this.jPanelM6.setLayout(jPanelM6Layout);
        jPanelM6Layout.setHorizontalGroup(jPanelM6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM6Layout.createSequentialGroup().addGroup(jPanelM6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jComboBoxMesa6, 0, -1, Short.MAX_VALUE).addComponent(this.jComboBoxCambiar6, 0, 82, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM6Layout.createSequentialGroup().addComponent(this.jLabel28).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldDocente6, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel26).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldPractica6)).addComponent(this.jTextFieldMateria6, 0, -1, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanelM6Layout.createSequentialGroup().addComponent(this.InsMateria6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonStop6)).addComponent(this.AbrirMateria6, -1, -1, Short.MAX_VALUE)).addGap(75, 75, 75)));
        jPanelM6Layout.setVerticalGroup(jPanelM6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM6Layout.createSequentialGroup().addContainerGap().addGroup(jPanelM6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AbrirMateria6).addComponent(this.jComboBoxCambiar6, -2, -1, -2).addComponent(this.jTextFieldMateria6, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextFieldDocente6, -2, -1, -2).addComponent(this.jTextFieldPractica6, -2, -1, -2).addComponent(this.jLabel26).addComponent(this.jComboBoxMesa6, -2, -1, -2).addComponent(this.jLabel28)).addGroup(jPanelM6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.InsMateria6).addComponent(this.jButtonStop6))).addContainerGap(7, Short.MAX_VALUE)));
        this.jPanelM7.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.AbrirMateria7.setBackground(SystemColor.activeCaption);
        this.AbrirMateria7.setFont(new Font("Dialog", 1, 12));
        this.AbrirMateria7.setText("PASO 1");
        this.AbrirMateria7.setCursor(new Cursor(12));
        this.AbrirMateria7.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.AbrirMateria7ActionPerformed(evt);
            }
        });
        this.InsMateria7.setBackground(SystemColor.activeCaption);
        this.InsMateria7.setFont(new Font("Dialog", 1, 12));
        this.InsMateria7.setText("PASO 3");
        this.InsMateria7.setCursor(new Cursor(12));
        this.InsMateria7.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.InsMateria7ActionPerformed(evt);
            }
        });
        this.jButtonStop7.setBackground(new Color(244, 67, 54));
        this.jButtonStop7.setFont(new Font("Dialog", 1, 12));
        this.jButtonStop7.setForeground(new Color(255, 255, 255));
        this.jButtonStop7.setText("X");
        this.jButtonStop7.setCursor(new Cursor(12));
        this.jButtonStop7.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.jButtonStop7ActionPerformed(evt);
            }
        });
        this.jLabel29.setText("GrPr\u00e1ct");
        this.jComboBoxMesa7.setModel(new DefaultComboBoxModel<String>(new String[]{"Normal", "Mesa"}));
        this.jComboBoxCambiar7.setModel(new DefaultComboBoxModel<String>(new String[]{"Inscribir", "Cambiar"}));
        this.jLabel31.setText("Grupo");
        this.jTextFieldMateria7.setPreferredSize(new Dimension(381, 26));
        GroupLayout jPanelM7Layout = new GroupLayout(this.jPanelM7);
        this.jPanelM7.setLayout(jPanelM7Layout);
        jPanelM7Layout.setHorizontalGroup(jPanelM7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM7Layout.createSequentialGroup().addGroup(jPanelM7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jComboBoxMesa7, 0, -1, Short.MAX_VALUE).addComponent(this.jComboBoxCambiar7, 0, 82, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM7Layout.createSequentialGroup().addComponent(this.jLabel31).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldDocente7, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel29).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldPractica7)).addComponent(this.jTextFieldMateria7, 0, -1, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanelM7Layout.createSequentialGroup().addComponent(this.InsMateria7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonStop7)).addComponent(this.AbrirMateria7, -1, -1, Short.MAX_VALUE)).addGap(75, 75, 75)));
        jPanelM7Layout.setVerticalGroup(jPanelM7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM7Layout.createSequentialGroup().addContainerGap().addGroup(jPanelM7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AbrirMateria7).addComponent(this.jComboBoxCambiar7, -2, -1, -2).addComponent(this.jTextFieldMateria7, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextFieldDocente7, -2, -1, -2).addComponent(this.jTextFieldPractica7, -2, -1, -2).addComponent(this.jLabel29).addComponent(this.jComboBoxMesa7, -2, -1, -2).addComponent(this.jLabel31)).addGroup(jPanelM7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.InsMateria7).addComponent(this.jButtonStop7))).addContainerGap(7, Short.MAX_VALUE)));
        this.jPanelM8.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.AbrirMateria8.setBackground(SystemColor.activeCaption);
        this.AbrirMateria8.setFont(new Font("Dialog", 1, 12));
        this.AbrirMateria8.setText("PASO 1");
        this.AbrirMateria8.setCursor(new Cursor(12));
        this.AbrirMateria8.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.AbrirMateria8ActionPerformed(evt);
            }
        });
        this.InsMateria8.setBackground(SystemColor.activeCaption);
        this.InsMateria8.setFont(new Font("Dialog", 1, 12));
        this.InsMateria8.setText("PASO 3");
        this.InsMateria8.setCursor(new Cursor(12));
        this.InsMateria8.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.InsMateria8ActionPerformed(evt);
            }
        });
        this.jButtonStop8.setBackground(new Color(244, 67, 54));
        this.jButtonStop8.setFont(new Font("Dialog", 1, 12));
        this.jButtonStop8.setForeground(new Color(255, 255, 255));
        this.jButtonStop8.setText("X");
        this.jButtonStop8.setCursor(new Cursor(12));
        this.jButtonStop8.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.jButtonStop8ActionPerformed(evt);
            }
        });
        this.jLabel32.setText("GrPr\u00e1ct");
        this.jComboBoxMesa8.setModel(new DefaultComboBoxModel<String>(new String[]{"Normal", "Mesa"}));
        this.jComboBoxCambiar8.setModel(new DefaultComboBoxModel<String>(new String[]{"Inscribir", "Cambiar"}));
        this.jLabel34.setText("Grupo");
        this.jTextFieldMateria8.setPreferredSize(new Dimension(381, 26));
        GroupLayout jPanelM8Layout = new GroupLayout(this.jPanelM8);
        this.jPanelM8.setLayout(jPanelM8Layout);
        jPanelM8Layout.setHorizontalGroup(jPanelM8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM8Layout.createSequentialGroup().addGroup(jPanelM8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jComboBoxCambiar8, 0, 82, Short.MAX_VALUE).addComponent(this.jComboBoxMesa8, 0, -1, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, Short.MAX_VALUE).addGroup(jPanelM8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, jPanelM8Layout.createSequentialGroup().addComponent(this.jLabel34).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldDocente8, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel32).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldPractica8)).addComponent(this.jTextFieldMateria8, -2, 381, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanelM8Layout.createSequentialGroup().addComponent(this.InsMateria8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonStop8)).addComponent(this.AbrirMateria8, -1, -1, Short.MAX_VALUE)).addGap(75, 75, 75)));
        jPanelM8Layout.setVerticalGroup(jPanelM8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM8Layout.createSequentialGroup().addContainerGap().addGroup(jPanelM8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AbrirMateria8).addComponent(this.jComboBoxCambiar8, -2, -1, -2).addComponent(this.jTextFieldMateria8, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextFieldDocente8, -2, -1, -2).addComponent(this.jTextFieldPractica8, -2, -1, -2).addComponent(this.jLabel32).addComponent(this.jComboBoxMesa8, -2, -1, -2).addComponent(this.jLabel34)).addGroup(jPanelM8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.InsMateria8).addComponent(this.jButtonStop8))).addContainerGap(7, Short.MAX_VALUE)));
        this.jPanelM9.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.AbrirMateria9.setBackground(SystemColor.activeCaption);
        this.AbrirMateria9.setFont(new Font("Dialog", 1, 12));
        this.AbrirMateria9.setText("PASO 1");
        this.AbrirMateria9.setCursor(new Cursor(12));
        this.AbrirMateria9.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.AbrirMateria9ActionPerformed(evt);
            }
        });
        this.InsMateria9.setBackground(SystemColor.activeCaption);
        this.InsMateria9.setFont(new Font("Dialog", 1, 12));
        this.InsMateria9.setText("PASO 3");
        this.InsMateria9.setCursor(new Cursor(12));
        this.InsMateria9.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.InsMateria9ActionPerformed(evt);
            }
        });
        this.jButtonStop9.setBackground(new Color(244, 67, 54));
        this.jButtonStop9.setFont(new Font("Dialog", 1, 12));
        this.jButtonStop9.setForeground(new Color(255, 255, 255));
        this.jButtonStop9.setText("X");
        this.jButtonStop9.setCursor(new Cursor(12));
        this.jButtonStop9.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Ventana.this.jButtonStop9ActionPerformed(evt);
            }
        });
        this.jLabel35.setText("GrPr\u00e1ct");
        this.jComboBoxMesa9.setModel(new DefaultComboBoxModel<String>(new String[]{"Normal", "Mesa"}));
        this.jComboBoxCambiar9.setModel(new DefaultComboBoxModel<String>(new String[]{"Inscribir", "Cambiar"}));
        this.jLabel37.setText("Grupo");
        this.jTextFieldMateria9.setPreferredSize(new Dimension(381, 26));
        GroupLayout jPanelM9Layout = new GroupLayout(this.jPanelM9);
        this.jPanelM9.setLayout(jPanelM9Layout);
        jPanelM9Layout.setHorizontalGroup(jPanelM9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM9Layout.createSequentialGroup().addGroup(jPanelM9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jComboBoxMesa9, 0, -1, Short.MAX_VALUE).addComponent(this.jComboBoxCambiar9, 0, 82, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM9Layout.createSequentialGroup().addComponent(this.jLabel37).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldDocente9, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel35).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFieldPractica9)).addComponent(this.jTextFieldMateria9, 0, -1, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanelM9Layout.createSequentialGroup().addComponent(this.InsMateria9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonStop9)).addComponent(this.AbrirMateria9, -1, -1, Short.MAX_VALUE)).addGap(75, 75, 75)));
        jPanelM9Layout.setVerticalGroup(jPanelM9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM9Layout.createSequentialGroup().addContainerGap().addGroup(jPanelM9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AbrirMateria9).addComponent(this.jComboBoxCambiar9, -2, -1, -2).addComponent(this.jTextFieldMateria9, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelM9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelM9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextFieldDocente9, -2, -1, -2).addComponent(this.jTextFieldPractica9, -2, -1, -2).addComponent(this.jLabel35).addComponent(this.jComboBoxMesa9, -2, -1, -2).addComponent(this.jLabel37)).addGroup(jPanelM9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.InsMateria9).addComponent(this.jButtonStop9))).addContainerGap(7, Short.MAX_VALUE)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanelM9, GroupLayout.Alignment.LEADING, -1, -1, Short.MAX_VALUE).addComponent(this.jPanelM8, GroupLayout.Alignment.LEADING, -1, -1, Short.MAX_VALUE).addComponent(this.jPanelM7, GroupLayout.Alignment.LEADING, -1, -1, Short.MAX_VALUE).addComponent(this.jPanelM1, GroupLayout.Alignment.LEADING, -1, -1, Short.MAX_VALUE).addComponent(this.jPanelM3, -1, -1, Short.MAX_VALUE).addComponent(this.jPanelM4, GroupLayout.Alignment.LEADING, -1, -1, Short.MAX_VALUE).addComponent(this.jPanelM5, GroupLayout.Alignment.LEADING, -1, -1, Short.MAX_VALUE).addComponent(this.jPanelM6, GroupLayout.Alignment.LEADING, -1, -1, Short.MAX_VALUE).addComponent(this.jPanelM2, GroupLayout.Alignment.LEADING, -1, -1, Short.MAX_VALUE)).addGap(0, 213, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanelM1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanelM2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanelM3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanelM4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanelM5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanelM6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanelM7, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanelM8, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanelM9, -2, -1, -2).addContainerGap(69, Short.MAX_VALUE)));
        this.jScrollPane1.setViewportView(this.jPanel2);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 631, -2).addComponent(this.jPanel3, -2, -1, -2)).addContainerGap(-1, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1).addContainerGap()));
        this.pack();
    }

    private void AbrirMateria1ActionPerformed(ActionEvent evt) {
        if (this.agregarCadena((String)this.jTextFieldMateria1.getSelectedItem())) {
            this.materia1.AbrirMateria();
        } else {
            JOptionPane.showMessageDialog(null, "Se recomienda solo abrir hasta 2 veces la misma materia para un mejor rendimiento del programa.");
        }
    }

    private void InsMateria1ActionPerformed(ActionEvent evt) {
        this.materia1.iniciarSesion();
    }

    private void AbrirMateria3ActionPerformed(ActionEvent evt) {
        if (this.agregarCadena((String)this.jTextFieldMateria3.getSelectedItem())) {
            this.materia3.AbrirMateria();
        } else {
            JOptionPane.showMessageDialog(null, "Se recomienda solo abrir hasta 2 veces la misma materia para un mejor rendimiento del programa.");
        }
    }

    private void InsMateria3ActionPerformed(ActionEvent evt) {
        this.materia3.iniciarSesion();
    }

    private void AbrirMateria4ActionPerformed(ActionEvent evt) {
        if (this.agregarCadena((String)this.jTextFieldMateria4.getSelectedItem())) {
            this.materia4.AbrirMateria();
        } else {
            JOptionPane.showMessageDialog(null, "Se recomienda solo abrir hasta 2 veces la misma materia para un mejor rendimiento del programa.");
        }
    }

    private void InsMateria4ActionPerformed(ActionEvent evt) {
        this.materia4.iniciarSesion();
    }

    private void jButtonStop1ActionPerformed(ActionEvent evt) {
        this.materia1.cerrarDriver(this.rojo);
    }

    private void jButtonStop3ActionPerformed(ActionEvent evt) {
        this.materia3.cerrarDriver(this.rojo);
    }

    private void jButtonStop4ActionPerformed(ActionEvent evt) {
        this.materia4.cerrarDriver(this.rojo);
    }

    private void AbrirMateria5ActionPerformed(ActionEvent evt) {
        if (this.agregarCadena((String)this.jTextFieldMateria5.getSelectedItem())) {
            this.materia5.AbrirMateria();
        } else {
            JOptionPane.showMessageDialog(null, "Se recomienda solo abrir hasta 2 veces la misma materia para un mejor rendimiento del programa.");
        }
    }

    private void InsMateria5ActionPerformed(ActionEvent evt) {
        this.materia5.iniciarSesion();
    }

    private void jButtonStop5ActionPerformed(ActionEvent evt) {
        this.materia5.cerrarDriver(this.rojo);
    }

    private void AbrirMateria6ActionPerformed(ActionEvent evt) {
        if (this.agregarCadena((String)this.jTextFieldMateria6.getSelectedItem())) {
            this.materia6.AbrirMateria();
        } else {
            JOptionPane.showMessageDialog(null, "Se recomienda solo abrir hasta 2 veces la misma materia para un mejor rendimiento del programa.");
        }
    }

    private void InsMateria6ActionPerformed(ActionEvent evt) {
        this.materia6.iniciarSesion();
    }

    private void jButtonStop6ActionPerformed(ActionEvent evt) {
        this.materia6.cerrarDriver(this.rojo);
    }

    private void jButtonGuardarActionPerformed(ActionEvent evt) {
        this.escribirDatos(true);
        this.leerDatos();
    }

    private void jButtonSalirActionPerformed(ActionEvent evt) {
        if (this.colapse) {
            this.colapse = false;
            this.jPanelDatos.setVisible(true);
            this.jPanelBotones.setVisible(true);
        } else {
            this.colapse = true;
            this.jPanelDatos.setVisible(false);
            this.jPanelBotones.setVisible(false);
        }
    }

    private void jButtonWebsisActionPerformed(ActionEvent evt) {
        this.websis.abrirWebsis();
    }

    private void jButtonStop2ActionPerformed(ActionEvent evt) {
        this.materia2.cerrarDriver(this.rojo);
    }

    private void InsMateria2ActionPerformed(ActionEvent evt) {
        this.materia2.iniciarSesion();
    }

    private void AbrirMateria2ActionPerformed(ActionEvent evt) {
        if (this.agregarCadena((String)this.jTextFieldMateria2.getSelectedItem())) {
            this.materia2.AbrirMateria();
        } else {
            JOptionPane.showMessageDialog(null, "Se recomienda solo abrir hasta 2 veces la misma materia para un mejor rendimiento del programa.");
        }
    }

    private void AbrirMateria7ActionPerformed(ActionEvent evt) {
        if (this.agregarCadena((String)this.jTextFieldMateria7.getSelectedItem())) {
            this.materia7.AbrirMateria();
        } else {
            JOptionPane.showMessageDialog(null, "Se recomienda solo abrir hasta 2 veces la misma materia para un mejor rendimiento del programa.");
        }
    }

    private void InsMateria7ActionPerformed(ActionEvent evt) {
        this.materia7.iniciarSesion();
    }

    private void jButtonStop7ActionPerformed(ActionEvent evt) {
        this.materia7.cerrarDriver(this.rojo);
    }

    private void AbrirMateria8ActionPerformed(ActionEvent evt) {
        if (this.agregarCadena((String)this.jTextFieldMateria8.getSelectedItem())) {
            this.materia8.AbrirMateria();
        } else {
            JOptionPane.showMessageDialog(null, "Se recomienda solo abrir hasta 2 veces la misma materia para un mejor rendimiento del programa.");
        }
    }

    private void InsMateria8ActionPerformed(ActionEvent evt) {
        this.materia8.iniciarSesion();
    }

    private void jButtonStop8ActionPerformed(ActionEvent evt) {
        this.materia8.cerrarDriver(this.rojo);
    }

    private void AbrirMateria9ActionPerformed(ActionEvent evt) {
        if (this.agregarCadena((String)this.jTextFieldMateria9.getSelectedItem())) {
            this.materia9.AbrirMateria();
        } else {
            JOptionPane.showMessageDialog(null, "Se recomienda solo abrir hasta 2 veces la misma materia para un mejor rendimiento del programa.");
        }
    }

    private void InsMateria9ActionPerformed(ActionEvent evt) {
        this.materia9.iniciarSesion();
    }

    private void jButtonStop9ActionPerformed(ActionEvent evt) {
        this.materia9.cerrarDriver(this.rojo);
    }

    public static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
/* 
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (!"Nimbus".equals(info.getName())) continue;
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }*/

    @Override
    public void dispose() {
        super.dispose();
        try {
            if (this.serverSocket != null && !this.serverSocket.isClosed()) {
                this.serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

