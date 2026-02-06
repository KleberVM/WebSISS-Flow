import customtkinter as ctk

# Configuración global
ctk.set_appearance_mode("Dark")
ctk.set_default_color_theme("blue")

class AppInscripcion(ctk.CTk):
    def __init__(self):
        super().__init__()

        # Ventana principal un poco más ancha para las 3 columnas
        self.title("Sistema de Inscripción Automática - Panel Técnico")
        self.geometry("1100x750")
        
        # TÍTULO PRINCIPAL
        self.lbl_main = ctk.CTkLabel(self, text="Panel de Control - Inscripción 2026", font=("Roboto", 22, "bold"))
        self.lbl_main.pack(pady=(15, 10))

        # ============================================================
        # SECCIÓN SUPERIOR: 3 COLUMNAS (Datos | Códigos | Técnico)
        # ============================================================
        self.frame_top = ctk.CTkFrame(self)
        self.frame_top.pack(pady=10, padx=20, fill="x")
        
        # Configuración de la grilla (33% cada una)
        self.frame_top.grid_columnconfigure(0, weight=1) 
        self.frame_top.grid_columnconfigure(1, weight=1)
        self.frame_top.grid_columnconfigure(2, weight=1)

        # ------------------------------------------------------------
        # COLUMNA 1 (IZQUIERDA): DATOS DEL ESTUDIANTE
        # ------------------------------------------------------------
        self.col_datos = ctk.CTkFrame(self.frame_top, fg_color="transparent")
        self.col_datos.grid(row=0, column=0, sticky="nsew", padx=10, pady=10)

        ctk.CTkLabel(self.col_datos, text="👤 Datos Estudiante", font=("Roboto", 15, "bold"), text_color="#3B8ED0").pack(anchor="w", pady=5)

        self.entry_sis = ctk.CTkEntry(self.col_datos, placeholder_text="Código SIS")
        self.entry_sis.pack(fill="x", pady=5)
        
        self.entry_pass = ctk.CTkEntry(self.col_datos, placeholder_text="Contraseña WebSIS", show="*")
        self.entry_pass.pack(fill="x", pady=5)

        ctk.CTkLabel(self.col_datos, text="Fecha de Nacimiento:", font=("Roboto", 12)).pack(anchor="w", pady=(5,0))
        self.frame_fecha = ctk.CTkFrame(self.col_datos, fg_color="transparent")
        self.frame_fecha.pack(fill="x", pady=2)
        
        self.combo_dia = ctk.CTkComboBox(self.frame_fecha, values=[str(i) for i in range(1, 32)], width=55)
        self.combo_dia.pack(side="left", padx=(0, 2))
        self.combo_mes = ctk.CTkComboBox(self.frame_fecha, values=["Ene", "Feb", "Mar", "Abr", "May"], width=70) # Abreviado por espacio
        self.combo_mes.pack(side="left", padx=2)
        self.combo_anio = ctk.CTkComboBox(self.frame_fecha, values=[str(i) for i in range(1995, 2010)], width=65)
        self.combo_anio.pack(side="left", padx=2)

        ctk.CTkLabel(self.col_datos, text="Facultad:", font=("Roboto", 12)).pack(anchor="w", pady=(5,0))
        self.combo_facultad = ctk.CTkComboBox(self.col_datos, values=["Ciencias y Tecnología", "Economía", "Humanidades"])
        self.combo_facultad.pack(fill="x", pady=2)

        # ------------------------------------------------------------
        # COLUMNA 2 (MEDIO): CÓDIGOS DE INSCRIPCIÓN
        # ------------------------------------------------------------
        self.col_codigos = ctk.CTkFrame(self.frame_top, fg_color="transparent")
        self.col_codigos.grid(row=0, column=1, sticky="nsew", padx=10, pady=10)
        
        # Borde decorativo para separar visualmente
        self.col_codigos.configure(border_width=1, border_color="#404040") 

        ctk.CTkLabel(self.col_codigos, text="🔑 Códigos Captcha", font=("Roboto", 15, "bold"), text_color="#3B8ED0").pack(pady=5)

        self.codigos_inputs = []
        for i in range(5):
            f_cod = ctk.CTkFrame(self.col_codigos, fg_color="transparent")
            f_cod.pack(fill="x", pady=3, padx=15)
            ctk.CTkLabel(f_cod, text=f"C{i+1}:", width=30).pack(side="left")
            entry = ctk.CTkEntry(f_cod, placeholder_text="---", justify="center")
            entry.pack(side="left", fill="x", expand=True)
            self.codigos_inputs.append(entry)

        # ------------------------------------------------------------
        # COLUMNA 3 (DERECHA): PRUEBAS Y TÉCNICO
        # ------------------------------------------------------------
        self.col_tech = ctk.CTkFrame(self.frame_top, fg_color="transparent")
        self.col_tech.grid(row=0, column=2, sticky="nsew", padx=10, pady=10)

        ctk.CTkLabel(self.col_tech, text="🛠️ Controles Técnicos", font=("Roboto", 15, "bold"), text_color="#3B8ED0").pack(anchor="w", pady=5)

        # Botón Probar Chrome (Color Naranja/Amarillo para resaltar alerta/prueba)
        self.btn_test = ctk.CTkButton(self.col_tech, text="🧪 Probar Chrome", 
                                      fg_color="#E59110", hover_color="#B57005",
                                      command=self.accion_test_chrome)
        self.btn_test.pack(fill="x", pady=5)

        # Botón Guardar BD (Color Verde fuerte)
        self.btn_save = ctk.CTkButton(self.col_tech, text="💾 Guardar en BD", 
                                      fg_color="#1F6AA5", # O un verde #2CC985 si prefieres
                                      command=self.accion_guardar_bd)
        self.btn_save.pack(fill="x", pady=5)

        # Interruptor manual movido aquí (tiene más sentido como configuración técnica)
        self.var_manual = ctk.BooleanVar(value=False)
        self.switch_manual = ctk.CTkSwitch(self.col_tech, text="Modo Manual", 
                                           variable=self.var_manual, command=self.actualizar_modo_materias)
        self.switch_manual.pack(pady=15, anchor="w")

        # Un pequeño log visual para que parezca "Hacker/Técnico"
        self.log_box = ctk.CTkTextbox(self.col_tech, height=80, text_color="green", font=("Consolas", 11))
        self.log_box.pack(fill="x", pady=5)
        self.log_box.insert("0.0", "> Sistema listo...\n> Esperando conexión DB...\n")

        # ============================================================
        # SECCIÓN INFERIOR: MATERIAS
        # ============================================================
        self.frame_titulo_materias = ctk.CTkFrame(self, fg_color="transparent")
        self.frame_titulo_materias.pack(fill="x", padx=20, pady=(10,0))
        
        ctk.CTkLabel(self.frame_titulo_materias, text="📚 Lista de Materias", font=("Roboto", 18, "bold")).pack(side="left")
        self.btn_add = ctk.CTkButton(self.frame_titulo_materias, text="+ Agregar", width=100, command=self.agregar_fila_materia)
        self.btn_add.pack(side="right")

        self.scroll_materias = ctk.CTkScrollableFrame(self, height=300)
        self.scroll_materias.pack(pady=10, padx=20, fill="both", expand=True)

        self.filas_materias = []
        self.agregar_fila_materia() # Agregar una por defecto

    # --- FUNCIONES DUMMY PARA LOS BOTONES ---
    def accion_test_chrome(self):
        self.log_box.insert("end", "> Abriendo Chrome Driver...\n> Error: No driver found.\n")
        self.log_box.see("end") # Auto-scroll al final

    def accion_guardar_bd(self):
        self.log_box.insert("end", "> Guardando configuración...\n> Datos guardados en public.Usuarios\n")
        self.log_box.see("end")

    def agregar_fila_materia(self):
        fila = ctk.CTkFrame(self.scroll_materias)
        fila.pack(pady=5, fill="x")

        ctk.CTkComboBox(fila, values=["Inscribir", "Cambiar"], width=90).pack(side="left", padx=5, pady=5)
        ctk.CTkComboBox(fila, values=["Normal", "Mesa"], width=90).pack(side="left", padx=5, pady=5)

        container_materia = ctk.CTkFrame(fila, fg_color="transparent", width=220, height=30)
        container_materia.pack(side="left", padx=5)
        container_materia.pack_propagate(False)

        if self.var_manual.get():
            widget_materia = ctk.CTkEntry(container_materia, placeholder_text="Escribe materia...", width=210)
        else:
            widget_materia = ctk.CTkComboBox(container_materia, values=["Cálculo I", "Física I", "Inglés"], width=210)
        
        widget_materia.pack(fill="both", expand=True)

        ctk.CTkEntry(fila, placeholder_text="Gr", width=40).pack(side="left", padx=5)
        ctk.CTkEntry(fila, placeholder_text="Pr", width=40).pack(side="left", padx=5)
        ctk.CTkButton(fila, text="▶", width=40, fg_color="#2CC985").pack(side="left", padx=10)

        self.filas_materias.append({"container": container_materia, "widget": widget_materia})

    def actualizar_modo_materias(self):
        es_manual = self.var_manual.get()
        estado = "ACTIVADO" if es_manual else "DESACTIVADO"
        self.log_box.insert("end", f"> Modo Manual: {estado}\n")
        self.log_box.see("end")

        for fila_data in self.filas_materias:
            fila_data["widget"].destroy()
            padre = fila_data["container"]
            if es_manual:
                nuevo_widget = ctk.CTkEntry(padre, placeholder_text="Escribe materia...", width=210)
            else:
                nuevo_widget = ctk.CTkComboBox(padre, values=["Cálculo I", "Física I", "Inglés"], width=210)
            nuevo_widget.pack(fill="both", expand=True)
            fila_data["widget"] = nuevo_widget

if __name__ == "__main__":
    app = AppInscripcion()
    app.mainloop()