import os
import sys

def configurar_sistema():
    local_app_data = os.getenv('LOCALAPPDATA')
    
    if not local_app_data:
        print("Error: No se pudo obtener la variable de entorno LOCALAPPDATA.")
        return

    dir_sand = os.path.join(local_app_data, "Sand")
    ruta_sand = os.path.join(dir_sand, "sand.txt")
    
    dir_conf = os.path.join(local_app_data, "Wconf")
    ruta_conf = os.path.join(dir_conf, "conf.txt")

    print(f"--- Iniciando Configuración ---")
    print(f"Ruta Sand: {ruta_sand}")
    print(f"Ruta Conf: {ruta_conf}")
    print("-" * 30)

    if os.path.exists(ruta_sand):
        try:
            os.remove(ruta_sand)
            print(f"Archivo 'sand.txt' detectado y ELIMINADO correctamente.")
        except Exception as e:
            print(f"Error al intentar eliminar 'sand.txt': {e}")
    else:
        print(f"El archivo 'sand.txt' no existe, no es necesario eliminar nada.")

    while True:
        try:
            entrada = input("\n¿Cuántas materias deseas inscribir? (Mínimo 1 - Máximo 7): ")
            num_materias = int(entrada)
            if 1 <= num_materias <= 7:
                break
            else:
                print("Por favor, ingresa un número entre 1 y 7.")
        except ValueError:
            print("Entrada inválida. Debes ingresar un número entero.")

    contrasena = "vtvrEAFtCQLGH0mq3YzkCQ=="
    
    if not os.path.exists(dir_conf):
        print(f"Creando carpeta '{dir_conf}'...")
        os.makedirs(dir_conf)

    if os.path.exists(ruta_conf):
        print(f"El archivo 'conf.txt' ya existe. Se borrará su contenido y se actualizará.")
    else:
        print(f"Creando nuevo archivo 'conf.txt'...")

    try:
        with open(ruta_conf, "w", encoding="utf-8") as f:
            for _ in range(22):
                f.write("\n")
            
            f.write(f"{num_materias}\n")
            
            f.write(f"{contrasena}")
            
        print(f"¡Éxito! Archivo configurado.")
        print(f"   -> Línea 23: {num_materias} materias")
        print(f"   -> Línea 24: Contraseña guardada")

    except Exception as e:
        print(f"Error al escribir en 'conf.txt': {e}")

if __name__ == "__main__":
    configurar_sistema()
    input("\nPresiona ENTER para salir...")