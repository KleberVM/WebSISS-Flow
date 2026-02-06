# WebSISS Flow - Versión Java (Escritorio)

Esta es la versión de escritorio de WebSISS Flow, desarrollada en Java. Permite la automatización de procesos de inscripción mediante una interfaz gráfica (Swing) y automatización de navegador (Selenium).

##  Requisitos Previos

* **Java JDK:** Necesitas tener instalado el JDK version 25 o superior.
* **Python 3:** Necesario para ejecutar el script de configuración inicial.
* **Google Chrome:** El navegador debe estar instalado para que la automatización funcione.

## Instalación y Configuración

Sigue estos pasos en orden para preparar el entorno antes de ejecutar el programa.

### 1. Estructura del Proyecto
Asegúrate de que estás ubicado en la carpeta `version java`. Tu directorio debe verse así:

```text
version java/
├── Archivos/
├── Images/
├── Inscripcion.java
├── Ventana.java
├── conf.py            <-- Script de configuración
└── libs/              <-- (Carpeta vacía o inexistente al principio)
```

### 2. Descarga de Librerías (Dependencias)
Las librerías necesarias (Selenium, Drivers, etc.) no están incluidas en el repositorio para ahorrar espacio.
1. Descarga la carpeta libs desde el siguiente [Google Drive](https://drive.google.com/drive/folders/1QUIytLSWGY7lx4YZWJc2RHkx9baZ_6Np?usp=drive_link).
2. Descomprime o copia el contenido para que tengas una carpeta llamada libs al mismo nivel que tus archivos .java.

### 3. Generar Archivo de Configuración

El sistema requiere un archivo conf.txt con parámetros específicos. Hemos incluido un script de Python para descargarlo y colocarlo automáticamente.

Ejecuta el siguiente comando en tu terminal:

```bash
python conf.py
```
Esto descargará el archivo conf.txt y lo ubicará en la carpeta designada automáticamente.

## Compilación y Ejecución

Una vez que tengas la carpeta libs y el archivo de configuración listo, utiliza los siguientes comandos en tu terminal (CMD o PowerShell) dentro de la carpeta del proyecto.

Paso 1: Compilar
Este comando compila las clases Java incluyendo las librerías externas.

```bash
javac -cp ".;libs/*" Inscripcion.java Ventana.java
```

Paso 2: Ejecutar
Este comando inicia la aplicación.

```bash
java -cp ".;libs/*" Ventana
```

