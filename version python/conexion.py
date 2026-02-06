import os
from supabase import create_client, Client


url: str = os.environ.get("https://ahtuagpnpsmycuhtoxmj.supabase.co")
key: str = os.environ.get("sb_publishable_mr3VmuQgTl7oo0T6Q5rrlA_DC3KscKr")

supabase: Client = create_client(url, key)
conexion_activa: bool = True
response = (
    supabase.table("Usuarios")
    .select("*")
    .execute()
)