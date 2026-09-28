from adaptador import adaptar_resultado


resultado_gemini = {
    "clasificacion": "Receta",
    "score_confianza": 0.98,
    "requiere_auditoria_humana": False,
    "prioridad": "Rutina",
    "cola_enrutamiento": "cola_rutina",

    "datos_extraidos": {
        "paciente": {
            "nombre_completo": "ANDREA JACQUELINE ALVAREZ ATENSIO",
            "rut": "10962059-9",
            "edad": "47 años",
            "domicilio": "SANTIAGO MAIPÚ",
            "ciudad": "SANTIAGO"
        },

        "medico": {
            "nombre_completo": "CARLOS MARCEL MORALES CONCEPCION",
            "rut": "14655050-9",
            "especialidad": (
                "OBESIDAD Y NUTRICION ADULTO - "
                "MEDICINA GENERAL"
            )
        },

        "documento": {
            "tipo_especifico": "Receta Retenida (Copia)",
            "fecha_emision": "2026-09-21",
            "institucion": "IntegraMédica",
            "medicamentos": [
                {
                    "nombre": "KITADOL (PARACETAMOL)",
                    "dosis": "1 GR",
                    "posologia": (
                        "1 comp cada 8 hrs "
                        "en caso de cefalea"
                    )
                },
                {
                    "nombre": "FLEMEX JAT",
                    "dosis": "10 ml",
                    "posologia": "cada 8 hrs por 5 dias"
                },
                {
                    "nombre": "FESEMA C/AEROCAMARA",
                    "dosis": "2 puff",
                    "posologia": (
                        "sos (tos y/o sensación "
                        "de ahogo) INH"
                    )
                },
                {
                    "nombre": "FISIOLIMP SPRAY NASAL",
                    "dosis": "Aseo nasal frecuente",
                    "posologia": "frecuente"
                }
            ]
        }
    }
}


resultado_adaptado = adaptar_resultado(
    resultado_gemini,
    "prueba.pdf"
)


print("\n--- RESULTADO ADAPTADO ---")
print(resultado_adaptado)