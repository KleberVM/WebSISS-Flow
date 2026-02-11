import os
import sys
import socket
import platform
import subprocess
import hashlib
import requests 
from tkinter import messagebox

class Seguridad:
    def __init__(self):
        
    def ya_se_esta_ejecutando(self):
        verificar que no haya otra instancia del programa corriendo
        por ejemplo, usando un archivo lock o verificando procesos activos
    def es_maquina_virtual(self):
        verificar indicadores comunes de máquinas virtuales, debe devolver True o False para saber si es VM o no
    def verificar_integridad_archivos(self):
        existen 2 archivos sand.txt y conf.txt sand verifica integridad de conf.txt tanto el contenido como la ultima ves que se modifico
        ahora en el caso que no existan estos archivos significa que el usuario puede ser nuevo
        entonces en supabase debe verificar en la tabla Usuarios si el sis 
    def obtener_sis_local(self):
        
    def verificar_usuario_supabase(self, sis_local):
    

    def ejecutar_chequeo_completo(self):
    