/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
import java.awt.Color;
import java.awt.Robot;
import java.awt.Toolkit;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Inscripcion {
    private String materia = null;
    private String normalMesa = null;
    private String inscribirCambiar = null;
    private String[] grupo = null;
    private String[] cambiarGrupo = null;
    private String[] practica = null;
    private WebDriver driver;
    private JButton iniciar;
    private JButton detener;
    private JButton abrirMateria;
    private JPanel panel;
    private JTextField JGrupo;
    private JTextField JPractica;
    private JComboBox JMateria;
    private Color rojo = new Color(255, 163, 114);
    private Color verde = new Color(132, 255, 0);
    private Color amarillo = new Color(253, 253, 150);
    private int urlEspera = 10;
    private JComboBox comboNormalMesa;
    private JComboBox comboInscribirCambiar;
    private static final Object lock = new Object();
    private String chromeDriverPath = "C:\\ProgramData\\selenium\\chromedriver\\win64\\120.0.6099.109\\chromedriver.exe";
    private String chromeBinaryPath = "C:\\ProgramData\\selenium\\chrome\\win64\\120.0.6099.109\\chrome.exe";
    private String urlWebsis = "https://websis.umss.edu.bo/serv_estudiantes.asp";
    private String urlWebsisOferta = "https://websis.umss.edu.bo/stud_AnadirMaterias.asp?servicio=s&codSer=STUD&idCat=39";
    private String urlMateriasInscritas = "https://websis.umss.edu.bo/stud_inscripcion.asp?codSer=STUD&idCat=39";
    private String urlCod = "https://websis.umss.edu.bo/stud_loginInscripcion.asp?codser=STUD&idcat=39";
    private Wait<WebDriver> wait10;
    private Wait<WebDriver> wait3;
    private Wait<WebDriver> wait2;
    private Wait<WebDriver> wait4;
    private boolean insOk = false;
    private Exception error;
    private By rutaEnlaceInscripcion = By.xpath("/html/body/div[5]/div/div[2]/table[2]/tbody/tr[3]/td/a");
    private By rutaTablaMateriasIns = By.xpath("/html/body/div[5]/div[1]/div[1]/form/div/table");
    private By rutaCod1 = By.xpath("/html/body/div[5]/div/div[1]/table/tbody/tr/td/form/table/tbody/tr[1]/td[1]/span");
    private By rutaCod2 = By.xpath("/html/body/div[5]/div/div[1]/table/tbody/tr/td/form/table/tbody/tr[2]/td[1]/span");
    private By rutaInputCod1 = By.id("idInput1");
    private By rutaInputCod2 = By.id("idInput2");
    private By rutaBotonIngresar = By.id("idBtnSubmit");
    private By rutaBotonA\u00f1adirMateria = By.id("idBtnAnadir");
    private By rutaTablaMaterias = By.xpath("/html/body/div[5]/div[2]/table");
    private By rutaTablaBotonInsMateria = By.tagName("button");
    private By rutaBotonInsMateria = By.id("idBtnAnadir");
    private By rutaTablaBotonVolverIns = By.xpath("/html/body/div[5]/div[1]/div/form/button");
    private By rutaRetornarOferta = By.xpath("/html/body/div[5]/div/div[1]/form/button");
    private By rutaGrupo = By.name("grupo");
    private By rutaGrupoPractica = By.name("grupoPractica");
    private By rutaTipoModalidad = By.name("tipo");
    private By rutaModalidad = By.tagName("select");
    private By rutaBotonModificar = By.id("idBtnModificar");
    private By rutaBotonCambiar = By.className("idBtnCambiar");
    private By rutaSelectCambiar = By.name("modocambiar");
    private WebElement idCuenta = null;
    private WebElement enlaceInscripcion = null;
    private WebElement tablaMateriasIns = null;
    private WebElement cod1 = null;
    private WebElement cod2 = null;
    private WebElement inputCod1 = null;
    private WebElement inputCod2 = null;
    private WebElement botonIngresar = null;
    private WebElement botonA\u00f1adirMateria = null;
    private WebElement tablaMaterias = null;
    private WebElement tablaBotonInsMateria = null;
    private WebElement botonInsMateria = null;
    private WebElement tablaBotonVolverIns = null;
    private WebElement botonRetornarOferta = null;
    private WebElement selectGrupo = null;
    private WebElement selectGrupoPractica = null;
    private WebElement selectNormalMesa = null;
    private WebElement selectModalidad = null;
    private WebElement botonModificar = null;
    private WebElement botonCambiar = null;
    private WebElement selectCambiar = null;

    public Inscripcion(JButton boton, JButton stop, JTextField JDocente, JComboBox JMateria, JButton abrirMateria, JPanel panel, JTextField JPractica, JComboBox modalidadCombo, JComboBox modoCombo) {
        this.iniciar = boton;
        this.detener = stop;
        this.abrirMateria = abrirMateria;
        this.panel = panel;
        this.JGrupo = JDocente;
        this.JMateria = JMateria;
        this.JPractica = JPractica;
        this.comboNormalMesa = modalidadCombo;
        this.comboInscribirCambiar = modoCombo;
    }

    public void setGrupo(String docente) {
        this.grupo = docente.split("-");
        for (int i = 0; i < docente.split("-").length; ++i) {
            this.grupo[i] = this.grupo[i].trim();
        }
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setPractica(String practica) {
        this.practica = practica.split("-");
        for (int i = 0; i < practica.split("-").length; ++i) {
            this.practica[i] = this.practica[i].trim();
        }
    }

    public void setNormalMesa(String modalidad) {
        this.normalMesa = modalidad;
    }

    public void setInscribirCambiar(String modo) {
        this.inscribirCambiar = modo;
    }

    public void setCambiarGrupo(String grupo, String grupoPractica) {
        if (grupoPractica.isEmpty()) {
            this.cambiarGrupo = grupo.split("-");
            for (int i = 0; i < grupo.split("-").length; ++i) {
                this.cambiarGrupo[i] = this.cambiarGrupo[i].trim();
            }
        } else {
            String[] gr = grupo.split("-");
            String[] grPract = grupoPractica.split("-");
            this.cambiarGrupo = new String[gr.length * grPract.length];
            int cantidad = 0;
            for (int i = 0; i < gr.length; ++i) {
                for (int j = 0; j < grPract.length; ++j) {
                    this.cambiarGrupo[cantidad] = gr[i].trim() + "/" + grPract[j].trim();
                    ++cantidad;
                }
            }
        }
    }

public void abrirNavegador() {
    this.insOk = false;

    // 1. CONFIGURACIÓN DEL DRIVER
    // COMENTAMOS la ruta manual para evitar el error "must exist". 
    // Deja que Selenium lo gestione automáticamente.
    // System.setProperty("webdriver.chrome.driver", this.chromeDriverPath);

    ChromeOptions opciones = new ChromeOptions();
    
    // Si realmente necesitas el binario específico de Chrome, descomenta la siguiente línea, 
    // pero asegúrate de que la ruta sea 100% real. Si usas el Chrome normal, déjala comentada.
    // opciones.setBinary(this.chromeBinaryPath);

    // COMENTAMOS la versión fija para evitar errores cuando Chrome se actualice
    // opciones.setBrowserVersion("120");

    opciones.addArguments("--incognito");
    opciones.addArguments("--remote-allow-origins=*"); // Importante para versiones nuevas
    opciones.addArguments("--disable-blink-features=AutomationControlled");
    opciones.addArguments("--disable-features=VizDisplayCompositor");
    opciones.setExperimentalOption("useAutomationExtension", false);
    opciones.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

    try {
        this.driver = new ChromeDriver(opciones);

        // 2. CONFIGURACIÓN DE TIEMPOS (AUMENTADOS)
        // 2 segundos es imposible para Websis. Ponemos 60.
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60L));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));

        // Inicializamos los Waits
        this.wait3 = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        this.wait2 = new WebDriverWait(this.driver, Duration.ofSeconds(5L));
        this.wait10 = new WebDriverWait(this.driver, Duration.ofSeconds(15L));

        // 3. POSICIÓN DE LA VENTANA (Tu código original)
        int anchoPantalla = Toolkit.getDefaultToolkit().getScreenSize().width;
        int altoPantalla = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.driver.manage().window().setPosition(new Point(anchoPantalla / 2, 0));
        this.driver.manage().window().setSize(new Dimension(anchoPantalla / 2, altoPantalla - altoPantalla / 16));

        // 4. NAVEGACIÓN
        this.driver.get("about:blank");
        Inscripcion.esperar(500);

        // Intentamos cargar la página una sola vez con buen tiempo de espera
        try {
            System.out.println("Cargando URL: " + this.urlWebsis);
            this.driver.get(this.urlWebsis);
        } catch (Exception e) {
            System.out.println("La página tardó en cargar, pero intentamos continuar...");
        }

        // 5. INTERACCIÓN CON ELEMENTOS (CÓDIGO / PASO 2)
        try {
            // Esperamos a que aparezca el input del código
            WebElement codigo = (WebElement) this.wait3.until(ExpectedConditions.presenceOfElementLocated(By.id("idCodigo")));
            
            // Intentamos buscar el texto del paso 2 (XPath original)
            try {
                WebElement codigoTexto = (WebElement) this.wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div/div[1]/table/tbody/tr/td/form/table/tbody/tr[7]/td[2]")));
                ((JavascriptExecutor) this.driver).executeScript("arguments[0].innerText = 'PASO 2';arguments[0].style.fontSize = '20px';arguments[0].style.color = 'black';", codigoTexto);
            } catch (Exception ex) {
                System.out.println("No se encontró el texto 'Código', pero seguimos.");
            }

            // Ejecutamos tu JS visual
            ((JavascriptExecutor) this.driver).executeScript(
                "arguments[0].scrollIntoView({ block: 'center', inline: 'nearest' });" +
                "arguments[0].style.border='4px solid red';" +
                "arguments[0].value = 'Escribir';" +
                "arguments[0].focus();" +
                "arguments[0].select();", codigo);

            this.abrirMateria.setEnabled(false);

        } catch (TimeoutException e) {
            System.err.println("No se encontró el elemento idCodigo. La página no cargó correctamente.");
            // Opcional: this.cerrarDriver(this.rojo);
        }

    } catch (Exception e) {
        System.err.println("ERROR FATAL al abrir navegador: " + e.getMessage());
        e.printStackTrace(); // Esto te dirá exactamente qué pasó en la consola
        this.cerrarDriver(this.rojo);
    }
}

    public void abrirWebsis() {
    // --- TRUCO DE SEGURIDAD ---
    // Esta línea BORRA cualquier ruta antigua que esté molestando en memoria.
    System.clearProperty("webdriver.chrome.driver"); 
    // --------------------------

    ChromeOptions opciones = new ChromeOptions();
    
    // OJO: Si tu Chrome está instalado en la ruta normal, comenta esta línea también con //
    // opciones.setBinary(this.chromeBinaryPath); 

    opciones.addArguments("--incognito");
    opciones.addArguments("--remote-allow-origins=*");
    opciones.addArguments("--disable-blink-features=AutomationControlled");
    opciones.setExperimentalOption("useAutomationExtension", false);
    opciones.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

    try {
        // Ahora Selenium buscará el driver automáticamente sin dar error de ruta
        this.driver = new ChromeDriver(opciones);
        
        this.driver.manage().window().maximize();
        
        // Tiempos de espera aumentados (Websis es lento)
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60L));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        this.wait4 = new WebDriverWait(this.driver, Duration.ofSeconds(10L));

        // Navegación segura
        try {
            this.driver.get(this.urlWebsis);
        } catch (Exception e) {
            System.out.println("Primer intento falló, reintentando...");
            this.driver.get(this.urlWebsis);
        }

        // --- LLENADO DE DATOS ---
        this.idCuenta = (WebElement) this.wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("idCuenta")));
        this.idCuenta.clear();
        this.idCuenta.sendKeys(Ventana.datos.get(0));

        this.driver.findElement(By.id("idContrasena")).sendKeys(Ventana.datos.get(1));

        // Fechas
        WebElement dia = this.driver.findElement(By.id("idDia"));
        new Select(dia).selectByVisibleText(Ventana.datos.get(2));

        WebElement mes = this.driver.findElement(By.id("idMes"));
        // Asegúrate que Inscripcion.selectPartialText existe, si no usa selectByVisibleText
        Inscripcion.selectPartialText(new Select(mes), Ventana.datos.get(3));

        WebElement anio = this.driver.findElement(By.id("idAnio"));
        new Select(anio).selectByVisibleText(Ventana.datos.get(4));

        // --- CLIC EN CÓDIGO ---
        try {
            WebElement codigo = (WebElement) this.wait4.until(ExpectedConditions.elementToBeClickable(By.id("idCodigo")));
            ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'nearest' });", codigo);
            codigo.click();
        } catch (Exception e) {
            System.out.println("No se pudo hacer click en el código: " + e.getMessage());
        }

    } catch (Exception e) {
        System.err.println("ERROR: " + e.getMessage());
        e.printStackTrace();
        // this.cerrarDriver(this.rojo); // Comenta esto si quieres ver el error antes de que se cierre
    }
}
    public void iniciarSesion() {
        try {
            Alert alert = this.driver.switchTo().alert();
            alert.accept();
        } catch (Exception alert) {
            // empty catch block
        }
        WebElement idCodigo = this.driver.findElement(By.id("idCodigo"));
        if (!idCodigo.getAttribute("value").isEmpty()) {
            this.driver.findElement(By.id("idCuenta")).clear();
            Inscripcion.esperar(100);
            this.driver.findElement(By.id("idCuenta")).sendKeys(Ventana.datos.get(0));
            this.driver.findElement(By.id("idContrasena")).clear();
            Inscripcion.esperar(100);
            this.driver.findElement(By.id("idContrasena")).sendKeys(Ventana.datos.get(1));
            WebElement dia = this.driver.findElement(By.id("idDia"));
            Select selectDia = new Select(dia);
            selectDia.selectByVisibleText(Ventana.datos.get(2));
            WebElement mes = this.driver.findElement(By.id("idMes"));
            Select selectMes = new Select(mes);
            Inscripcion.selectPartialText(selectMes, Ventana.datos.get(3));
            WebElement anio = this.driver.findElement(By.id("idAnio"));
            Select selectAnio = new Select(anio);
            selectAnio.selectByVisibleText(Ventana.datos.get(4));
            WebElement inicioSesion = this.driver.findElement(By.id("idBtnSubmit"));
            inicioSesion.click();
            try {
                this.enlaceInscripcion = (WebElement)this.wait3.until(ExpectedConditions.presenceOfElementLocated(this.rutaEnlaceInscripcion));
            } catch (TimeoutException timeoutException) {
                // empty catch block
            }
            if (this.enlaceInscripcion != null) {
                this.iniciar.setEnabled(false);
                this.detener.setEnabled(true);
                if (Ventana.apertura) {
                    this.iniciarInscripcion(false);
                } else {
                    this.iniciarInscripcion(Ventana.verifyProcess);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al iniciar sesi\u00f3n, verifique que sus datos o el codigo de verificaci\u00f3n de la WEBSIS sean correctos, intente de nuevo");
                this.driver.get(this.urlWebsis);
                WebElement codigo = (WebElement)this.wait3.until(ExpectedConditions.presenceOfElementLocated(By.id("idCodigo")));
                try {
                    ((JavascriptExecutor)((Object)this.driver)).executeScript("arguments[0].scrollIntoView({ block: 'center', inline: 'nearest' });arguments[0].style.border='4px solid red';arguments[0].value = 'Escribir';arguments[0].focus();arguments[0].select();", codigo);
                } catch (Exception exception) {
                    // empty catch block
                }
                try {
                    Robot robot = new Robot();
                    robot.keyPress(18);
                    robot.keyPress(9);
                    robot.keyRelease(9);
                    robot.keyRelease(18);
                } catch (Exception exception) {}
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el c\u00f3digo de verificaci\u00f3n");
            try {
                Robot robot = new Robot();
                robot.keyPress(18);
                robot.keyPress(9);
                robot.keyRelease(9);
                robot.keyRelease(18);
            } catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public void iniciarInscripcion(final boolean usarLock) {
        this.procesando();
        Runnable miFuncion = new Runnable(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public void run() {
                int intentos = 0;
                while (!Inscripcion.this.insOk) {
                    if (intentos == 0) {
                        try {
                            Inscripcion.this.enlaceInscripcion = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaEnlaceInscripcion));
                            Inscripcion.this.enlaceInscripcion.click();
                        } catch (TimeoutException e) {
                            try {
                                Inscripcion.this.enlaceInscripcion = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaEnlaceInscripcion));
                                Inscripcion.this.enlaceInscripcion.click();
                            } catch (TimeoutException e2) {
                                Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                return;
                            }
                        } catch (Exception e) {
                            Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                            return;
                        }
                    }
                    if (usarLock && intentos == 0) {
                        Object e = lock;
                        synchronized (e) {
                            while (!Ventana.apertura && Ventana.verifyProcess) {
                                try {
                                    lock.wait(120000L);
                                    try {
                                        Inscripcion.this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Inscripcion.this.urlEspera));
                                        Inscripcion.this.driver.get(Inscripcion.this.urlCod);
                                        Inscripcion.this.botonIngresar = (WebElement)Inscripcion.this.wait2.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaBotonIngresar));
                                    } catch (TimeoutException e2) {
                                        Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                        return;
                                    }
                                } catch (InterruptedException e3) {
                                    Thread.currentThread().interrupt();
                                } catch (Exception e4) {
                                    Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                    return;
                                }
                            }
                        }
                    }
                    boolean apertura = false;
                    if (intentos == 0 && !apertura) {
                        while (!apertura) {
                            Ventana.verifyProcess = true;
                            boolean bloqueCod = false;
                            for (int i = 0; i < 3; ++i) {
                                try {
                                    Inscripcion.this.cod1 = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaCod1));
                                    Inscripcion.this.cod2 = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaCod2));
                                    Inscripcion.this.inputCod1 = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaInputCod1));
                                    Inscripcion.this.inputCod2 = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaInputCod2));
                                    bloqueCod = true;
                                    break;
                                } catch (TimeoutException e) {
                                    try {
                                        Inscripcion.this.error = e;
                                        Inscripcion.this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Inscripcion.this.urlEspera));
                                        Inscripcion.this.driver.get(Inscripcion.this.urlCod);
                                    } catch (TimeoutException timeoutException) {}
                                    continue;
                                } catch (Exception e) {
                                    System.out.println("bloqueCod Exception" + String.valueOf(e));
                                    Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                    return;
                                }
                            }
                            if (!bloqueCod) {
                                System.out.println("bloqueCod" + String.valueOf(Inscripcion.this.error));
                                Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                return;
                            }
                            String codigo1 = Inscripcion.this.cod1.getText();
                            String codigo2 = Inscripcion.this.cod2.getText();
                            switch (codigo1) {
                                case "1:": {
                                    Inscripcion.this.inputCod1.sendKeys(Ventana.datos.get(5));
                                    break;
                                }
                                case "2:": {
                                    Inscripcion.this.inputCod1.sendKeys(Ventana.datos.get(6));
                                    break;
                                }
                                case "3:": {
                                    Inscripcion.this.inputCod1.sendKeys(Ventana.datos.get(7));
                                    break;
                                }
                                case "4:": {
                                    Inscripcion.this.inputCod1.sendKeys(Ventana.datos.get(8));
                                    break;
                                }
                                case "5:": {
                                    Inscripcion.this.inputCod1.sendKeys(Ventana.datos.get(9));
                                }
                            }
                            switch (codigo2) {
                                case "1:": {
                                    Inscripcion.this.inputCod2.sendKeys(Ventana.datos.get(5));
                                    break;
                                }
                                case "2:": {
                                    Inscripcion.this.inputCod2.sendKeys(Ventana.datos.get(6));
                                    break;
                                }
                                case "3:": {
                                    Inscripcion.this.inputCod2.sendKeys(Ventana.datos.get(7));
                                    break;
                                }
                                case "4:": {
                                    Inscripcion.this.inputCod2.sendKeys(Ventana.datos.get(8));
                                    break;
                                }
                                case "5:": {
                                    Inscripcion.this.inputCod2.sendKeys(Ventana.datos.get(9));
                                }
                            }
                            boolean bloqueBI = false;
                            for (int i = 0; i < 3; ++i) {
                                try {
                                    Inscripcion.this.botonIngresar = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaBotonIngresar));
                                    Inscripcion.this.botonIngresar.click();
                                    bloqueBI = true;
                                    break;
                                } catch (TimeoutException e) {
                                    Inscripcion.this.error = e;
                                    continue;
                                } catch (Exception e) {
                                    System.out.println("bloqueBI Exception" + String.valueOf(e));
                                    Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                    return;
                                }
                            }
                            if (!bloqueBI) {
                                System.out.println("bloqueBI" + String.valueOf(Inscripcion.this.error));
                                Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                return;
                            }
                            try {
                                Inscripcion.this.botonA\u00f1adirMateria = (WebElement)Inscripcion.this.wait10.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaBotonA\u00f1adirMateria));
                            } catch (TimeoutException i) {
                                // empty catch block
                            }
                            if (Inscripcion.this.botonA\u00f1adirMateria != null) {
                                apertura = true;
                                Ventana.apertura = true;
                                Object i = lock;
                                synchronized (i) {
                                    lock.notifyAll();
                                }
                                if (Inscripcion.this.inscribirCambiar.equals("Cambiar")) continue;
                                boolean bloque1 = false;
                                for (int i2 = 0; i2 < 3; ++i2) {
                                    try {
                                        Inscripcion.this.tablaMateriasIns = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaTablaMateriasIns));
                                        WebElement filaDeseada = null;
                                        for (WebElement fila : Inscripcion.this.tablaMateriasIns.findElements(By.tagName("tr"))) {
                                            if (!fila.getText().contains(Inscripcion.this.materia + " ")) continue;
                                            filaDeseada = fila;
                                            break;
                                        }
                                        if (filaDeseada != null) {
                                            JOptionPane.showMessageDialog(null, "Ya esta inscrito en la materia " + Inscripcion.this.materia + " si quiere cambiar de grupo elija la opci\u00f3n cambiar");
                                            Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                            return;
                                        }
                                        bloque1 = true;
                                        break;
                                    } catch (TimeoutException e) {
                                        try {
                                            Inscripcion.this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Inscripcion.this.urlEspera));
                                            Inscripcion.this.driver.get(Inscripcion.this.urlMateriasInscritas);
                                        } catch (TimeoutException timeoutException) {}
                                        continue;
                                    } catch (Exception e) {
                                        Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                        return;
                                    }
                                }
                                if (!bloque1) {
                                    Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                    return;
                                }
                                boolean bloqueM = false;
                                for (int i3 = 0; i3 < 3; ++i3) {
                                    try {
                                        Inscripcion.this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Inscripcion.this.urlEspera));
                                        Inscripcion.this.driver.get(Inscripcion.this.urlWebsisOferta);
                                        bloqueM = true;
                                        break;
                                    } catch (TimeoutException timeoutException) {
                                        continue;
                                    } catch (Exception e) {
                                        Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                        return;
                                    }
                                }
                                if (bloqueM) continue;
                                Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                return;
                            }
                            boolean bloqueINS = false;
                            for (int i = 0; i < 3; ++i) {
                                try {
                                    Inscripcion.this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Inscripcion.this.urlEspera));
                                    Inscripcion.this.driver.get(Inscripcion.this.urlCod);
                                    bloqueINS = true;
                                    break;
                                } catch (TimeoutException e) {
                                    Inscripcion.this.error = e;
                                    continue;
                                } catch (Exception e) {
                                    System.out.println("bloqueINS Exception" + String.valueOf(e));
                                    Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                    return;
                                }
                            }
                            if (bloqueINS) continue;
                            System.out.println("bloqueINS" + String.valueOf(Inscripcion.this.error));
                            Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                            return;
                        }
                    }
                    block119: for (int i = 0; i < 12; ++i) {
                        block182: {
                            if (Inscripcion.this.inscribirCambiar.equals("Cambiar")) {
                                boolean bloque2 = false;
                                for (int j = 0; j < 3; ++j) {
                                    try {
                                        Inscripcion.this.tablaMateriasIns = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaTablaMateriasIns));
                                        WebElement filaDeseada = null;
                                        for (WebElement fila : Inscripcion.this.tablaMateriasIns.findElements(By.tagName("tr"))) {
                                            if (!fila.getText().contains(Inscripcion.this.materia + " ")) continue;
                                            filaDeseada = fila;
                                            break;
                                        }
                                        if (filaDeseada != null) {
                                            Inscripcion.this.botonCambiar = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.elementToBeClickable(filaDeseada.findElement(Inscripcion.this.rutaBotonCambiar)));
                                            try {
                                                Inscripcion.this.selectCambiar = filaDeseada.findElement(Inscripcion.this.rutaSelectCambiar);
                                                Select selectCambia = new Select(Inscripcion.this.selectCambiar);
                                                for (WebElement option : selectCambia.getOptions()) {
                                                    if (!option.getText().toLowerCase().contains("ambos")) continue;
                                                    selectCambia.selectByVisibleText(option.getText());
                                                    break;
                                                }
                                            } catch (Exception selectCambia) {
                                                // empty catch block
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No se puede cambiar de grupo, ya que no esta inscrito en la materia " + Inscripcion.this.materia);
                                            Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                            return;
                                        }
                                        Inscripcion.this.botonCambiar.click();
                                        bloque2 = true;
                                        break;
                                    } catch (TimeoutException e) {
                                        Inscripcion.this.error = e;
                                        try {
                                            Inscripcion.this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Inscripcion.this.urlEspera));
                                            Inscripcion.this.driver.get(Inscripcion.this.urlMateriasInscritas);
                                        } catch (TimeoutException e2) {
                                            Inscripcion.this.error = e2;
                                        }
                                    } catch (Exception e) {
                                        System.out.println("bloque2 Exception" + String.valueOf(e));
                                        Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                        return;
                                    }
                                    if (bloque2) continue;
                                    System.out.println("bloque2" + String.valueOf(Inscripcion.this.error));
                                    Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                    return;
                                }
                            } else {
                                boolean bloque3 = false;
                                for (int j = 0; j < 3; ++j) {
                                    try {
                                        Inscripcion.this.tablaMaterias = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaTablaMaterias));
                                        WebElement filaDeseada = null;
                                        for (WebElement fila : Inscripcion.this.tablaMaterias.findElements(By.tagName("tr"))) {
                                            if (!fila.getText().contains(Inscripcion.this.materia + " ")) continue;
                                            filaDeseada = fila;
                                            break;
                                        }
                                        if (filaDeseada != null) {
                                            if (Inscripcion.this.normalMesa.equals("Mesa")) {
                                                boolean mesa = false;
                                                Inscripcion.this.selectModalidad = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.elementToBeClickable(filaDeseada.findElement(Inscripcion.this.rutaModalidad)));
                                                Select select = new Select(Inscripcion.this.selectModalidad);
                                                for (WebElement option : select.getOptions()) {
                                                    if (!option.getText().toLowerCase().contains("mesa") && !option.getText().toLowerCase().contains("me")) continue;
                                                    select.selectByVisibleText(option.getText());
                                                    mesa = true;
                                                    break;
                                                }
                                                if (!mesa) {
                                                    JOptionPane.showMessageDialog(null, "La materia " + Inscripcion.this.materia + " no tiene la opci\u00f3n para inscribirse a Mesa.");
                                                    Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                                    return;
                                                }
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "La materia " + Inscripcion.this.materia + " no esta habilitada para inscribirse. Revise tambien no tenga errores el nombre de la materia");
                                            Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                            return;
                                        }
                                        Inscripcion.this.tablaBotonInsMateria = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.elementToBeClickable(filaDeseada.findElement(Inscripcion.this.rutaTablaBotonInsMateria)));
                                        Inscripcion.this.tablaBotonInsMateria.click();
                                        bloque3 = true;
                                        break;
                                    } catch (TimeoutException e) {
                                        Inscripcion.this.error = e;
                                        try {
                                            Inscripcion.this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Inscripcion.this.urlEspera));
                                            Inscripcion.this.driver.get(Inscripcion.this.urlWebsisOferta);
                                        } catch (TimeoutException e2) {
                                            Inscripcion.this.error = e;
                                        }
                                        continue;
                                    } catch (Exception e) {
                                        System.out.println("bloque3 Exception" + String.valueOf(e));
                                        Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                        return;
                                    }
                                }
                                if (!bloque3) {
                                    System.out.println("bloque3" + String.valueOf(Inscripcion.this.error));
                                    Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                    return;
                                }
                            }
                            try {
                                if (Inscripcion.this.normalMesa.equals("Mesa") && Inscripcion.this.inscribirCambiar.equals("Cambiar")) {
                                    boolean MesaCambiar = false;
                                    Inscripcion.this.selectNormalMesa = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaTipoModalidad));
                                    Select selectTipo = new Select(Inscripcion.this.selectNormalMesa);
                                    for (WebElement option : selectTipo.getOptions()) {
                                        if (!option.getText().toLowerCase().contains("mesa") && !option.getText().toLowerCase().contains("me")) continue;
                                        selectTipo.selectByVisibleText(option.getText());
                                        MesaCambiar = true;
                                        break;
                                    }
                                    if (!MesaCambiar) {
                                        JOptionPane.showMessageDialog(null, "La materia " + Inscripcion.this.materia + " no tiene la opci\u00f3n para cambiar a Mesa.");
                                        Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                        return;
                                    }
                                    Inscripcion.esperar(200);
                                }
                                Inscripcion.this.selectGrupo = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaGrupo));
                                Select selectDocente = new Select(Inscripcion.this.selectGrupo);
                                boolean buscarDocente = false;
                                block127: for (WebElement option : selectDocente.getOptions()) {
                                    for (String grup : Inscripcion.this.grupo) {
                                        if (option.getText().trim().length() < 3) {
                                            if (!option.getText().trim().equals(grup)) continue;
                                            selectDocente.selectByVisibleText(option.getText());
                                            buscarDocente = true;
                                            break block127;
                                        }
                                        if (option.getText().trim().startsWith(grup + " -")) {
                                            selectDocente.selectByVisibleText(option.getText());
                                            buscarDocente = true;
                                            break block127;
                                        }
                                        if (grup.length() <= 4 || !option.getText().trim().contains(grup)) continue;
                                        selectDocente.selectByVisibleText(option.getText());
                                        buscarDocente = true;
                                        break block127;
                                    }
                                }
                                boolean buscarDocentePractica = false;
                                if (!Inscripcion.this.practica[0].isEmpty()) {
                                    try {
                                        Inscripcion.esperar(200);
                                        Inscripcion.this.selectGrupoPractica = (WebElement)Inscripcion.this.wait2.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaGrupoPractica));
                                        Select selectDocentePractica = new Select(Inscripcion.this.selectGrupoPractica);
                                        for (WebElement option : selectDocentePractica.getOptions()) {
                                            for (String grupoPractica : Inscripcion.this.practica) {
                                                if (!option.getText().trim().startsWith(grupoPractica)) continue;
                                                selectDocentePractica.selectByVisibleText(option.getText());
                                                buscarDocentePractica = true;
                                            }
                                        }
                                    } catch (TimeoutException e) {
                                        JOptionPane.showMessageDialog(null, "La materia " + Inscripcion.this.materia + " no tiene grupo de practica, borre el contenido del campo GrPr\u00e1ct y dejelo vacio");
                                        Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                        return;
                                    }
                                } else {
                                    buscarDocentePractica = true;
                                }
                                if (buscarDocente && buscarDocentePractica) {
                                    if (Inscripcion.this.inscribirCambiar.equals("Cambiar")) {
                                        Inscripcion.this.botonModificar = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaBotonModificar));
                                        Inscripcion.this.botonModificar.click();
                                        try {
                                            Alert alert = Inscripcion.this.driver.switchTo().alert();
                                            String alertText = alert.getText().trim();
                                            if (alertText.toLowerCase().contains("grupo de practica")) {
                                                JOptionPane.showMessageDialog(null, "La materia " + Inscripcion.this.materia + " tiene grupo practico, debe llenar el campo GrPr\u00e1ct con el grupo practico que desea tomar");
                                                Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                                return;
                                            }
                                            alert.accept();
                                        } catch (NoAlertPresentException alert) {
                                            // empty catch block
                                        }
                                        Inscripcion.esperar(3000);
                                    } else {
                                        Inscripcion.this.botonInsMateria = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaBotonInsMateria));
                                        Inscripcion.this.botonInsMateria.click();
                                        Inscripcion.esperar(2000);
                                        try {
                                            Alert alert = Inscripcion.this.driver.switchTo().alert();
                                            JOptionPane.showMessageDialog(null, "La materia " + Inscripcion.this.materia + " tiene grupo practico, debe llenar el campo GrPr\u00e1ct con el grupo practico que desea tomar");
                                            Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                            return;
                                        } catch (NoAlertPresentException alert) {
                                            // empty catch block
                                        }
                                    }
                                    boolean bloqueV = false;
                                    for (int j = 0; j < 3; ++j) {
                                        try {
                                            Inscripcion.this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Inscripcion.this.urlEspera));
                                            Inscripcion.this.driver.get(Inscripcion.this.urlMateriasInscritas);
                                            bloqueV = true;
                                            break;
                                        } catch (TimeoutException e) {
                                            Inscripcion.this.error = e;
                                            continue;
                                        } catch (Exception e) {
                                            System.out.println("bloqueV Exception" + String.valueOf(e));
                                            Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                            return;
                                        }
                                    }
                                    if (!bloqueV) {
                                        System.out.println("bloqueV Exception" + String.valueOf(Inscripcion.this.error));
                                        Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                        return;
                                    }
                                    boolean bloque4 = false;
                                    for (int j = 0; j < 3; ++j) {
                                        try {
                                            Inscripcion.this.tablaMateriasIns = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaTablaMateriasIns));
                                            WebElement filaDeseada = null;
                                            for (WebElement fila : Inscripcion.this.tablaMateriasIns.findElements(By.tagName("tr"))) {
                                                if (!fila.getText().contains(Inscripcion.this.materia + " ")) continue;
                                                filaDeseada = fila;
                                                break;
                                            }
                                            if (filaDeseada != null) {
                                                if (!Inscripcion.this.inscribirCambiar.equals("Cambiar")) {
                                                    Inscripcion.this.cerrarDriver(Inscripcion.this.verde);
                                                    Inscripcion.this.insOk = true;
                                                    break block119;
                                                }
                                                List<WebElement> columnas = filaDeseada.findElements(By.cssSelector(":scope > td"));
                                                String textoQuintaColumna = columnas.get(4).getText().trim();
                                                String textoSextaColumna = columnas.get(5).getText().trim();
                                                for (String string : Inscripcion.this.cambiarGrupo) {
                                                    if (Inscripcion.this.normalMesa.equals("Normal") && textoQuintaColumna.trim().equals(string) && (textoSextaColumna.trim().toLowerCase().contains("normal") || textoSextaColumna.trim().toLowerCase().contains("n"))) {
                                                        Inscripcion.this.cerrarDriver(Inscripcion.this.verde);
                                                        Inscripcion.this.insOk = true;
                                                        break block119;
                                                    }
                                                    if (!Inscripcion.this.normalMesa.equals("Mesa") || !textoQuintaColumna.trim().equals(string) || !textoSextaColumna.trim().toLowerCase().contains("me") && !textoSextaColumna.trim().toLowerCase().contains("mesa")) continue;
                                                    Inscripcion.this.cerrarDriver(Inscripcion.this.verde);
                                                    Inscripcion.this.insOk = true;
                                                    break block119;
                                                }
                                            } else if (!Inscripcion.this.inscribirCambiar.equals("Cambiar")) {
                                                boolean bloqueOF = false;
                                                for (int k = 0; k < 3; ++k) {
                                                    try {
                                                        Inscripcion.this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Inscripcion.this.urlEspera));
                                                        Inscripcion.this.driver.get(Inscripcion.this.urlWebsisOferta);
                                                        bloqueOF = true;
                                                        break;
                                                    } catch (TimeoutException e) {
                                                        Inscripcion.this.error = e;
                                                        continue;
                                                    } catch (Exception e) {
                                                        System.out.println("bloqueOF Exception" + String.valueOf(e));
                                                        Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                                        return;
                                                    }
                                                }
                                                if (!bloqueOF) {
                                                    System.out.println("bloqueOF" + String.valueOf(Inscripcion.this.error));
                                                    Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                                    return;
                                                }
                                            }
                                            bloque4 = true;
                                            break;
                                        } catch (TimeoutException e) {
                                            Inscripcion.this.error = e;
                                            try {
                                                Inscripcion.this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Inscripcion.this.urlEspera));
                                                Inscripcion.this.driver.get(Inscripcion.this.urlMateriasInscritas);
                                            } catch (TimeoutException e2) {
                                                Inscripcion.this.error = e2;
                                            }
                                            continue;
                                        } catch (Exception e) {
                                            System.out.println("bloque4 Exception" + String.valueOf(e));
                                            Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                            return;
                                        }
                                    }
                                    if (!bloque4) {
                                        System.out.println("bloque4" + String.valueOf(Inscripcion.this.error));
                                        Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                        return;
                                    }
                                    break block182;
                                }
                                JavascriptExecutor js = (JavascriptExecutor)((Object)Inscripcion.this.driver);
                                js.executeScript("window.scrollTo(0, 0);", new Object[0]);
                                if (!Inscripcion.this.inscribirCambiar.equals("Cambiar")) {
                                    Inscripcion.this.botonRetornarOferta = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaRetornarOferta));
                                    Inscripcion.this.botonRetornarOferta.click();
                                } else {
                                    Inscripcion.this.tablaBotonVolverIns = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaTablaBotonVolverIns));
                                    Inscripcion.this.tablaBotonVolverIns.click();
                                }
                            } catch (TimeoutException e) {
                                boolean bloque5 = false;
                                for (int j = 0; j < 3; ++j) {
                                    try {
                                        if (Inscripcion.this.inscribirCambiar.equals("Cambiar")) {
                                            Inscripcion.this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Inscripcion.this.urlEspera));
                                            Inscripcion.this.driver.get(Inscripcion.this.urlMateriasInscritas);
                                            bloque5 = true;
                                            break;
                                        }
                                        Inscripcion.this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Inscripcion.this.urlEspera));
                                        Inscripcion.this.driver.get(Inscripcion.this.urlWebsisOferta);
                                        bloque5 = true;
                                        break;
                                    } catch (TimeoutException e2) {
                                        Inscripcion.this.error = e2;
                                        continue;
                                    } catch (Exception e2) {
                                        System.out.println("bloque5 Exception" + String.valueOf(e));
                                        Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                        return;
                                    }
                                }
                                if (!bloque5) {
                                    System.out.println("bloque5" + String.valueOf(Inscripcion.this.error));
                                    Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                    return;
                                }
                            } catch (Exception e) {
                                System.out.println("bloqueBig Exception" + String.valueOf(e));
                                Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                                return;
                            }
                        }
                        if (intentos < 2) {
                            ++intentos;
                        }
                        Inscripcion.esperar(500);
                    }
                    if (Inscripcion.this.inscribirCambiar.equals("Cambiar") || Inscripcion.this.insOk) continue;
                    boolean bloque6 = false;
                    for (int i = 0; i < 3; ++i) {
                        try {
                            Inscripcion.this.tablaBotonVolverIns = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaTablaBotonVolverIns));
                            Inscripcion.this.tablaBotonVolverIns.click();
                            bloque6 = true;
                            break;
                        } catch (TimeoutException e) {
                            Inscripcion.this.error = e;
                            try {
                                Inscripcion.this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Inscripcion.this.urlEspera));
                                Inscripcion.this.driver.get(Inscripcion.this.urlWebsisOferta);
                            } catch (TimeoutException e2) {
                                Inscripcion.this.error = e2;
                            }
                            continue;
                        } catch (Exception e) {
                            System.out.println("bloque6 Exception" + String.valueOf(e));
                            Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                            return;
                        }
                    }
                    if (!bloque6) {
                        System.out.println("bloque6" + String.valueOf(Inscripcion.this.error));
                        Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                        return;
                    }
                    boolean bloque7 = false;
                    for (int i = 0; i < 3; ++i) {
                        try {
                            Inscripcion.this.botonA\u00f1adirMateria = (WebElement)Inscripcion.this.wait3.until(ExpectedConditions.presenceOfElementLocated(Inscripcion.this.rutaBotonA\u00f1adirMateria));
                            Inscripcion.this.botonA\u00f1adirMateria.click();
                            bloque7 = true;
                            break;
                        } catch (TimeoutException e) {
                            Inscripcion.this.error = e;
                            try {
                                Inscripcion.this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Inscripcion.this.urlEspera));
                                Inscripcion.this.driver.get(Inscripcion.this.urlMateriasInscritas);
                            } catch (TimeoutException e2) {
                                Inscripcion.this.error = e2;
                            }
                            continue;
                        } catch (Exception e) {
                            System.out.println("bloque7 Exception" + String.valueOf(e));
                            Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                            return;
                        }
                    }
                    if (bloque7) continue;
                    System.out.println("bloque7" + String.valueOf(Inscripcion.this.error));
                    Inscripcion.this.cerrarDriver(Inscripcion.this.rojo);
                    return;
                }
            }
        };
        Thread hilo = new Thread(miFuncion);
        hilo.start();
    }

    public void procesando() {
        this.panel.setBackground(this.amarillo);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cerrarDriver(Color color) {
        this.insOk = true;
        this.enlaceInscripcion = null;
        this.cod1 = null;
        this.cod2 = null;
        this.inputCod1 = null;
        this.inputCod2 = null;
        this.botonIngresar = null;
        this.botonA\u00f1adirMateria = null;
        this.tablaMaterias = null;
        this.tablaBotonInsMateria = null;
        this.botonInsMateria = null;
        this.tablaBotonVolverIns = null;
        this.botonRetornarOferta = null;
        this.selectGrupo = null;
        this.tablaMateriasIns = null;
        this.botonModificar = null;
        this.botonCambiar = null;
        this.selectGrupoPractica = null;
        this.selectModalidad = null;
        this.selectNormalMesa = null;
        this.idCuenta = null;
        this.selectCambiar = null;
        this.JGrupo.setEnabled(true);
        this.JMateria.setEnabled(true);
        this.JPractica.setEnabled(true);
        this.iniciar.setEnabled(false);
        this.detener.setEnabled(false);
        this.abrirMateria.setEnabled(true);
        Ventana.verifyProcess = false;
        Object object = lock;
        synchronized (object) {
            lock.notify();
        }
        Ventana.listaMaterias.remove(this.materia);
        this.panel.setBackground(color);
        this.driver.quit();
    }

    public void AbrirMateria() {
        if (!((String)this.JMateria.getSelectedItem()).trim().isEmpty()) {
            if (!this.JGrupo.getText().trim().isEmpty()) {
                this.JMateria.setEnabled(false);
                this.JGrupo.setEnabled(false);
                this.JPractica.setEnabled(false);
                this.iniciar.setEnabled(true);
                this.detener.setEnabled(true);
                this.setMateria(((String)this.JMateria.getSelectedItem()).trim().toUpperCase());
                this.setGrupo(this.JGrupo.getText().trim().toUpperCase());
                this.setPractica(this.JPractica.getText().trim().toUpperCase());
                this.setNormalMesa((String)this.comboNormalMesa.getSelectedItem());
                this.setInscribirCambiar((String)this.comboInscribirCambiar.getSelectedItem());
                this.setCambiarGrupo(this.JGrupo.getText().trim().toUpperCase(), this.JPractica.getText().trim().toUpperCase());
                this.abrirNavegador();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el nombre del docente o grupo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la materia");
        }
    }

    public static void esperar(int segundos) {
        try {
            Thread.sleep(segundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void selectPartialText(Select select, String partialText) {
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (!option.getText().contains(partialText)) continue;
            option.click();
            return;
        }
    }
}

