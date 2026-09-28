def adaptar_resultado(resultado, nombre_archivo):
    """
    Convierte diferentes estructuras de respuesta de Gemini
    al formato estándar que espera el backend de MediFlow.
    """

    # -----------------------------------------
    # 1. Datos del paciente
    # -----------------------------------------

    datos_extraidos = resultado.get(
        "datos_extraidos",
        {}
    )

    paciente = datos_extraidos.get(
        "paciente"
    )

    if paciente is None:
        paciente = resultado.get(
            "datos_paciente",
            {}
        )

    if not paciente:
        paciente = resultado.get(
            "paciente",
            {}
        )

    # -----------------------------------------
    # 2. Datos del médico
    # -----------------------------------------

    medico = datos_extraidos.get(
        "medico"
    )

    if medico is None:
        medico = resultado.get(
            "datos_medico",
            {}
        )

    if not medico:
        medico = resultado.get(
            "medico",
            {}
        )

    # -----------------------------------------
    # 3. Tipo de documento
    # -----------------------------------------

    tipo_documento = resultado.get(
        "tipo_documento"
    )

    if tipo_documento is None:
        tipo_documento = resultado.get(
            "clasificacion"
        )

    if tipo_documento is None:
        tipo_documento = resultado.get(
            "categoria"
        )

    # -----------------------------------------
    # 4. Confianza
    # -----------------------------------------

    score_confianza = resultado.get(
        "confianza_clasificacion"
    )

    if score_confianza is None:
        score_confianza = resultado.get(
            "score_confianza"
        )

    # -----------------------------------------
    # 5. Normalizar edad
    # -----------------------------------------

    edad = paciente.get(
        "edad"
    )

    if isinstance(edad, str):

        edad = (
            edad
            .replace("años", "")
            .replace("año", "")
            .strip()
        )

        try:
            edad = int(edad)

        except ValueError:
            edad = None

    # -----------------------------------------
    # 6. Resultado estándar de MediFlow
    # -----------------------------------------

    return {
        "status": "procesado",

        "documento_id": nombre_archivo,

        "clasificacion": {
            "tipo_documento": tipo_documento,

            "especialidad": medico.get(
                "especialidad"
            ),

            "nivel_prioridad": resultado.get(
                "prioridad"
            ),

            "score_confianza_clasificacion": score_confianza
        },

        "datos_extraidos": {

            "paciente": {
                "nombre": paciente.get(
                    "nombre_completo",
                    paciente.get("nombre")
                ),

                "rut": paciente.get(
                    "rut"
                ),

                "edad": edad
            },

            "medico_solicitante": {
                "nombre": medico.get(
                    "nombre_completo",
                    medico.get("nombre")
                ),

                "matricula": medico.get(
                    "matricula",
                    medico.get("rut")
                )
            },

            "estudio_realizado": resultado.get(
                "estudio_realizado"
            ),

            "diagnostico_principal": resultado.get(
                "diagnostico_principal"
            ),

            "cie10_sugerido": resultado.get(
                "cie10_sugerido"
            )
        }
    }