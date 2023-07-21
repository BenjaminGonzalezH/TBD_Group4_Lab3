from pymongo import MongoClient
from datetime import datetime

# Conexión (versión con autenticación)
client = MongoClient('localhost', port = 27017, username = 'Admin', password = 'Mangos', authSource='admin')
# Conexión (versión sin autenticación)
# client = MongoClient('localhost', port = 27017)

# Se crea base de datos o se traslada a esta.
db = client['Voluntarios_Desastres']

# Creación de colecciones u generar
# objetos para operarlas.
voluntario = db['voluntario']
vol_habilidad = db['vol_habilidad']
ranking = db['ranking']
institucion = db['institucion']
emergencia = db['emergencia']
eme_habilidad = db['eme_habilidad']
habilidad = db['habilidad']
tarea = db['tarea']
tarea_habilidad = db['tarea_habilidad']
estado_tarea = db['estado_tarea']

# Inserción de documentos en las colecciones.

################################################################## VOLUNTARIOS.
voluntario.insert_many([
{
    "nombre": "Ricardo Martinez"
},
{
    "nombre": "Juan Gomez Perez"
},
{
    "nombre": "Belen Soto"
},
{
    "nombre": "Monica Villanueva"
},
{
    "nombre": "Pablo Gonzalez"
},
{
    "nombre": "Francisca Vergara"
},
{
    "nombre": "Elsa Pato"
},
{
    "nombre": "Armando Mocha"
},
{
    "nombre": "Miguel Conde"
},
{
    "nombre": "Alma Marin"
}])
###############################################################################

################################################################ VOL_HABILIDAD.
vol_habilidad.insert_many([{
    "voluntario": "Ricardo Martinez",
    "habilidad": "Mover objetos pesados"
},
{
    "voluntario": "Ricardo Martinez",
    "habilidad": "Nadar en aguas profundas"
},
{
    "voluntario": "Ricardo Martinez",
    "habilidad": "Conduccion de vehiculos todoterreno"
},
{
    "voluntario": "Juan Gomez Perez",
    "habilidad": "Mover objetos pesados"
},
{
    "voluntario": "Juan Gomez Perez",
    "habilidad": "Construccion con concreto"
},
{
    "voluntario": "Belen Soto",
    "habilidad": "Carpinteria"
},
{
    "voluntario": "Monica Villanueva",
    "habilidad": "Conduccion de vehiculos acuaticos"
},
{
    "voluntario": "Pablo Gonzalez",
    "habilidad": "Nadar en aguas profundas"
},
{
    "voluntario": "Francisca Vergara",
    "habilidad": ""
},
{
    "voluntario": "Francisca Vergara",
    "habilidad": "Capacidad de usar mangueras de incendio"
},
{
    "voluntario": "Elsa Pato",
    "habilidad": "Mover objetos pesados"
},
{
    "voluntario": "Armando Mocha",
    "habilidad": "Cocinar"
},
{
    "voluntario": "Miguel Conde",
    "habilidad": "Practicar primeros auxilios"
},
{
    "voluntario": "Alma Marin",
    "habilidad": "Cocinar"
},
{
    "voluntario": "Alma Marin",
    "habilidad": "Practicar primeros auxilios"
}])
###############################################################################

####################################################################### RANKING.
ranking.insert_many([
{
    "voluntario": "Ricardo Martinez",
    "tarea": "Recoleccion de escombros",
    "puntaje": 10,
    "flg_invitado": 0,
    "flg_participa": 1
},
{
    "voluntario": "Ricardo Martinez",
    "tarea": "Desplazamiento de agua",
    "puntaje": 12,
    "flg_invitado": 1,
    "flg_participa": 0
},
{
    "voluntario": "Belen Soto",
    "tarea": "Recoleccion de basura (cristales)",
    "puntaje": 2,
    "flg_invitado": 1,
    "flg_participa": 0
},
{
    "voluntario": "Monica Villanueva",
    "tarea": "Cocina de alimentos a afectados",
    "puntaje": 23,
    "flg_invitado": 0,
    "flg_participa": 1
},
{
    "voluntario": "Monica Villanueva",
    "tarea": "Examinacion medica",
    "puntaje": 22,
    "flg_invitado": 0,
    "flg_participa": 1
},
{
    "voluntario": "Pablo Gonzalez",
    "tarea": "Reforestacion",
    "puntaje": 32,
    "flg_invitado": 1,
    "flg_participa": 0
}])
###############################################################################

################################################################## INSTITUCION.
institucion.insert_many([
{
    "nombre": "Earthquake response team",
    "descrip": "A"
},
{
    "nombre": "FireFigthers para Chile",
    "descrip": "B"
},
{
    "nombre": "EADE (Equipo anti disturbios escolares)",
    "descrip": "C"
},
{
    "nombre": "Organizacion de contencion maritima",
    "descrip": "E"
},
{
    "nombre": "iCE climbers Chile",
    "descrip": "F"
},
{
    "nombre": "Sand Help",
    "descrip": "G"
},
{
    "nombre": "Organización de recuperacion del concreto",
    "descrip": "H"
}
])
###############################################################################

################################################################### EMERGENCIA.
emergencia.insert_many([
{
    "nombre": "Terremoto Grado 9.5 Puerto Williams",
    "descrip": "En la región de puerto Williams se produjo un terremoto de grado 9.5 (Richter) que causo estragos en la infraestructura.",
    "fecha_inicio": datetime(2022,6,20),
    "fecha_fin": datetime(2022,6,21),
    "institucion": "Earthquake response team"
},
{
    "nombre": "Incendio en Santiago Centro",
    "descrip": "Un incendio en la zona poblacional de la comuna de Santiago",
    "fecha_inicio": datetime(2021,5,14),
    "fecha_fin": datetime(2021,5,17),
    "institucion": "FireFigthers para Chile"
},
{
    "nombre": "Tiroteo en Instituto Nacional",
    "descrip": "Una protesta dentro de la institucion termino en un tiroteo",
    "fecha_inicio": datetime(2023,8,1),
    "fecha_fin": datetime(2023,8,1),
    "institucion": "EADE (Equipo anti disturbios escolares)"
},
{
    "nombre": "Inundacion en Puerto Varas",
    "descrip": "Una fuerte lluvia realizo desborde en los rios que genero inundaciones en el pueblo",
    "fecha_inicio": datetime(2013,9,10),
    "fecha_fin": datetime(2013,9,17),
    "institucion": "Organizacion de contencion maritima"
},
{
    "nombre": "Incendio Forestal en Temuco",
    "descrip": "Se produjo un incendio forestal en los alrededores boscozos de temuco",
    "fecha_inicio": datetime(2022,11,12),
    "fecha_fin": datetime(2022,11,22),
    "institucion": "FireFigthers para Chile"
},
{
    "nombre": "Avalancha en la cordillera",
    "descrip": "Un terrmoto de poco poder y ademas de gritos a lo largo de la cordillera genero avalancha atrapando civiles",
    "fecha_inicio": datetime(2001,1,1),
    "fecha_fin": datetime(2001,1,1),
    "institucion": "iCE climbers Chile"
},
{
    "nombre": "Tsunami en Concon",
    "descrip": "El titulo es bastante concisp ¿Verdad?",
    "fecha_inicio": datetime(2012,6,5),
    "fecha_fin": datetime(2012,6,5),
    "institucion": "Organizacion de contencion maritima"
},
{
    "nombre": "Tormenta de arena en atacama",
    "descrip": "Esto es una descripcion",
    "fecha_inicio": datetime(2000,3,2),
    "fecha_fin": datetime(2000,3,6),
    "institucion": "Sand Help"
},
{
    "nombre": "Huracan en Puerto Williams",
    "descrip": "Dios tiene caprichos raros",
    "fecha_inicio": datetime(2000,10,12),
    "fecha_fin": datetime(2000,10,12),
    "institucion": "Equipo de contencion maritima"
},
{
    "nombre": "Derrumbe de complejo de apartamentos Quilicura se expande",
    "descrip": "Momento Quilicura",
    "fecha_inicio": datetime(2007,4,10),
    "fecha_fin": datetime(2007,4,10),
    "institucion": "Organización de recuperacion del concreto"
}
])
###############################################################################

################################################################ EME_HABILIDAD.
eme_habilidad.insert_many([
{
    "emergencia": "Terremoto Grado 9.5 Puerto Williams",
    "habilidad": "Mover objetos pesados"
},
{
    "emergencia": "Terremoto Grado 9.5 Puerto Williams",
    "habilidad": "Cocinar"
},
{
    "emergencia": "Terremoto Grado 9.5 Puerto Williams",
    "habilidad": "Practicar primeros auxilios"
},
{
    "emergencia": "Incendio en Santiago Centro",
    "habilidad": "Carpinteria"
},
{
    "emergencia": "Incendio en Santiago Centro",
    "habilidad": "Capacidad de usar mangueras de incendio"
},
{
    "emergencia": "Tiroteo en Instituto Nacional",
    "habilidad": "Carpinteria"
},
{
    "emergencia": "Tiroteo en Instituto Nacional",
    "habilidad": "Construccion con concreto"
},
{
    "emergencia": "Tiroteo en Instituto Nacional",
    "habilidad": "Practicar primeros auxilios"
},
{
    "emergencia": "Inundacion en Puerto Varas",
    "habilidad": "Cocinar"
},
{
    "emergencia": "Inundacion en Puerto Varas",
    "habilidad": "Construccion con concreto"
},
{
    "emergencia": "Inundacion en Puerto Varas",
    "habilidad": "Carpinteria"
},
{
    "emergencia": "Incendio Forestal en Temuco",
    "habilidad": "Capacidad de usar mangueras de incendio"
},
{
    "emergencia": "Avalancha en la cordillera",
    "habilidad": "Escalado de montañas"
},
{
    "emergencia": "Tsunami en Concon",
    "habilidad": "Construccion con concreto"
},
{
    "emergencia": "Huracan en Puerto Williams",
    "habilidad": "Conduccion de vehiculos acuaticos"
}
])
###############################################################################

#################################################################### HABILIDAD.
habilidad.insert_many([
{
    "descrip": "Mover objetos pesados"
},
{
    "descrip": "Cocinar"
},
{
    "descrip": "Nadar en aguas profundas"
},
{
    "descrip": "Practicar primeros auxilios"
},
{
    "descrip": "Conduccion de vehiculos todoterreno"
},
{
    "descrip": "Construccion con concreto"
},
{
    "descrip": "Carpinteria"
},
{
    "descrip": "Conduccion de vehiculos acuaticos"
},
{
    "descrip": "Capacidad de usar mangueras de incendio"
},
{
    "descrip": "Escalado de montañas"
}
])
###############################################################################

######################################################################## TAREA.
tarea.insert_many([
{
    "name": "Recoleccion de escombros",
    "descrip": "Se debe de recoger y reunir escombros resultantes de la emergencia",
    "cant_vol_requeridos": 100,
    "cant_vol_inscritos": 20,
    "fecha_inicio": datetime(2022,7,10),
    "fecha_fin": datetime(2022,9,30),
    "estado": {
        "descrip": "No iniciado"
    },
    "emergencia": "Terremoto Grado 9.5 Puerto Williams"
},
{
    "name": "Cocinar alimentos a damnificados",
    "descrip": "Se necesita cocinar un menu de 3 tiempos saludable para 200 personas",
    "cant_vol_requeridos": 20,
    "cant_vol_inscritos": 20,
    "fecha_inicio": datetime(2021,5,24),
    "fecha_fin": datetime(2021,5,25),
    "estado": {
        "descrip": "Preparado para iniciar"
    },
    "emergencia": "Incendio en Santiago Centro"
},
{
    "name": "Tratamientos medicos a heridos",
    "descrip": "Se requiere en realizar tratamientos medicos post-operacion a heridos por balas",
    "cant_vol_requeridos": 25,
    "cant_vol_inscritos": 5,
    "fecha_inicio": datetime(2023,8,12),
    "fecha_fin": datetime(2023,8,25),
    "estado": {
        "descrip": "No iniciado"
    },
    "emergencia": "Tiroteo en Instituto Nacional"
},
{
    "name": "Desplazamiento de agua",
    "descrip": "Se pide recolectar y transportar agua de lugares inundados a los bosques",
    "cant_vol_requeridos": 25,
    "cant_vol_inscritos": 5,
    "fecha_inicio": datetime(2013,9,12),
    "fecha_fin": datetime(2013,9,18),
    "estado": {
        "descrip": "Cancelado"
    },
    "emergencia": "Inundacion en Puerto Varas"
},
{
    "name": "Recoleccion de basura (cristales)",
    "descrip": "Se pide recolectar la basura (priorizando cristales)",
    "cant_vol_requeridos": 50,
    "cant_vol_inscritos": 50,
    "fecha_inicio": datetime(2019,12,12),
    "fecha_fin": datetime(2020,1,20),
    "estado": {
        "descrip": "Preparado para iniciar"
    },
    "emergencia": "Incendio Forestal en Temuco"
},
{
    "name": "Recoleccion de ropa donada",
    "descrip": "Se pide recoger la ropa donada por ciudadanos de los centros determinados",
    "cant_vol_requeridos": 37,
    "cant_vol_inscritos": 12,
    "fecha_inicio": datetime(2021,6,1),
    "fecha_fin": datetime(2021,6,20),
    "estado": {
        "descrip": "Cancelado"
    },
    "emergencia": "Incendio Santiago Centro"
},
{
    "name": "Cocina de alimentos a afectados",
    "descrip": "Cocinar alimentos a 900 personas damnificadas por terremoto",
    "cant_vol_requeridos": 200,
    "cant_vol_inscritos": 200,
    "fecha_inicio": datetime(2022,7,5),
    "fecha_fin": datetime(2022,7,6),
    "estado": {
        "descrip": "Preparado para iniciar"
    },
    "emergencia": "Terremoto Grado 9.5 Puerto Williams"
},
{
    "name": "Reparacion de infraestructura",
    "descrip": "Se procede a realizar la reparacion de los elementos afectados",
    "cant_vol_requeridos": 50,
    "cant_vol_inscritos": 50,
    "fecha_inicio": datetime(2023,10,10),
    "fecha_fin": datetime(2023,12,10),
    "estado": {
        "descrip": "Preparado para iniciar"
    },
    "emergencia": "Tiroteo en Instituto Nacional"
},
{
    "name": "Recuperacion de objetos",
    "descrip": "Se requiere de recuperar objetos en buen estado de los escombros",
    "cant_vol_requeridos": 100,
    "cant_vol_inscritos": 100,
    "fecha_inicio": datetime(2022,7,10),
    "fecha_fin": datetime(2022,9,30),
    "estado": {
        "descrip": "En desarrollo"
    },
    "emergencia": "Terremoto Grado 9.5 Puerto Williams"
},
{
    "name": "Examinacion medica",
    "descrip": "Se pide examinar estado de salud de los damnificados",
    "cant_vol_requeridos": 120,
    "cant_vol_inscritos": 120,
    "fecha_inicio": datetime(2021,2,24),
    "fecha_fin": datetime(2021,3,12),
    "estado": {
        "descrip": "Finalizado"
    },
    "emergencia": "Incendio en Santiago Centro"
},
{
    "name": "Examinacion medica",
    "descrip": "Se pide examinar estado de salud de los damnificados",
    "cant_vol_requeridos": 57,
    "cant_vol_inscritos": 57,
    "fecha_inicio": datetime(2022,9,10),
    "fecha_fin": datetime(2022,10,15),
    "estado": {
        "descrip": "En desarrollo"
    },
    "emergencia": "Terremoto Grado 9.5 Puerto Williams"
},
{
    "name": "Limpieza de infraestructura",
    "descrip": "Se debe de realizar una limpieza de la infraestructura",
    "cant_vol_requeridos": 20,
    "cant_vol_inscritos": 20,
    "fecha_inicio": datetime(2023,10,10),
    "fecha_fin": datetime(2023,12,10),
    "estado": {
        "descrip": "Finalizado"
    },
    "emergencia": "Tiroteo en Instituto Nacional"
},
{
    "name": "Recoleccion de insumos medicos",
    "descrip": "Recoleccion de recursos medicos donados por el estado en los puntos determinados",
    "cant_vol_requeridos": 40,
    "cant_vol_inscritos": 38,
    "fecha_inicio": datetime(2022,9,10),
    "fecha_fin": datetime(2022,10,15),
    "estado": {
        "descrip": "En desarrollo"
    },
    "emergencia": "Incendio en Santiago Centro"
},
{
    "name": "Recoleccion de ropa donada",
    "descrip": "Recoleccion de ropa donada por ciudadanos de otras regiones",
    "cant_vol_requeridos": 20,
    "cant_vol_inscritos": 10,
    "fecha_inicio": datetime(2013,9,20),
    "fecha_fin": datetime(2013,9,30),
    "estado": {
        "descrip": "No iniciado"
    },
    "emergencia": "Inundacion en Puerto Varas"
},
{
    "name": "Reparticion de almuerzos a damnificados",
    "descrip": "Repartir alimentos donados por privados a los afectados por inundacion",
    "cant_vol_requeridos": 38,
    "cant_vol_inscritos": 37,
    "fecha_inicio": datetime(2013,9,1),
    "fecha_fin": datetime(2013,9,18),
    "estado": {
        "descrip": "En desarrollo"
    },
    "emergencia": "Inundacion en Puerto Varas"
},
{
    "name": "Recoleccion de basura",
    "descrip": "Recolectar basura arrastrada o transportada por inundacion",
    "cant_vol_requeridos": 35,
    "cant_vol_inscritos": 35,
    "fecha_inicio": datetime(2013,8,11),
    "fecha_fin": datetime(2013,8,28),
    "estado": {
        "descrip": "Finalizado"
    },
    "emergencia": "Inundacion en Puerto Varas"
},
{
    "name": "Reparticion de almuerzos a voluntarios",
    "descrip": "Repartir alimentos donados por privados",
    "cant_vol_requeridos": 35,
    "cant_vol_inscritos": 4,
    "fecha_inicio": datetime(2019,12,12),
    "fecha_fin": datetime(2020,1,20),
    "estado": {
        "descrip": "Cancelado"
    },
    "emergencia": "Incendio Forestal en Temuco"
},
{
    "name": "Recuperacion de objetos",
    "descrip": "Recuperar objetos que no hayan sido destruidos por desastre",
    "cant_vol_requeridos": 20,
    "cant_vol_inscritos": 4,
    "fecha_inicio": datetime(2013,9,12),
    "fecha_fin": datetime(2013,9,18),
    "estado": {
        "descrip": "Cancelado"
    },
    "emergencia": "Inundacion en Puerto Varas"
},
{
    "name": "Reforestacion",
    "descrip": "Plantacion de nuevos arboles en reemplazo de los destruidos",
    "cant_vol_requeridos": 400,
    "cant_vol_inscritos": 250,
    "fecha_inicio": datetime(2020,12,12),
    "fecha_fin": datetime(2021,3,20),
    "estado": {
        "descrip": "No iniciado"
    },
    "emergencia": "Incendio Forestal en Temuco"
},
{
    "name": "Examinacion medica",
    "descrip": "Se pide examinar estado de salud de los afectados",
    "cant_vol_requeridos": 12,
    "cant_vol_inscritos": 12,
    "fecha_inicio": datetime(2019,11,1),
    "fecha_fin": datetime(2019,12,1),
    "estado": {
        "descrip": "Preparado para iniciar"
    },
    "emergencia": "Incendio Forestal en Temuco"
}
])
###############################################################################

############################################################## TAREA_HABILIDAD.
tarea_habilidad.insert_many([
{
    "Par": ["Terremoto Grado 9.5 Puerto Williams", "Mover objetos pesados"],
    "Tarea": "Recoleccion de escombros",
},
{
    "Par": ["Terremoto Grado 9.5 Puerto Williams", "Cocinar"],
    "Tarea": "Cocina de alimentos a afectados",
},
{
    "Par": ["Terremoto Grado 9.5 Puerto Williams", "Practicar primeros auxilios"],
    "Tarea": "Examinacion medica",
},
{
    "Par": ["Incendio en Santiago Centro", "Cocinar"],
    "Tarea": "Cocinar alimentos a damnificados",
},
{
    "Par": ["Incendio en Santiago Centro", "Practicar primeros auxilios"],
    "Tarea": "Examinacion medica",
},
{
    "Par": ["Tiroteo en Instituto Nacional", "Practicar primeros auxilios"],
    "Tarea": "Recoleccion de insumos medicos",
},
{
    "Par": ["Tiroteo en Instituto Nacional", "Construccion con concreto"],
    "Tarea": "Reparacion de infraestructura",
},
{
    "Par": ["Tiroteo en Instituto Nacional", "Practicar primeros auxilios"],
    "Tarea": "Tratamientos medicos a heridos",
},
{
    "Par": ["Inundacion en Puerto Varas", "Cocinar"],
    "Tarea": "Reparticion de almuerzos a damnificados",
},
{
    "Par": ["Inundacion en Puerto Varas", "Mover objetos pesados"],
    "Tarea": "Recoleccion de basura",
},
{
    "Par": ["Inundacion en Puerto Varas", "Carpinteria"],
    "Tarea": "Recuperacion de objetos",
},
{
    "Par": ["Incendio Forestal en Temuco", "Capacidad de usar mangueras de incendio"],
    "Tarea": "Control de Fuego",
},
{
    "Par": ["Avalancha en la cordillera", "Escalado de montañas"],
    "Tarea": "Rescate de heridos",
},
{
    "Par": ["Tsunami en Concon", "Construccion con concreto"],
    "Tarea": "Reparacion de hogares",
},
{
    "Par": ["Huracan en Puerto Williams", "Conduccion de vehiculos acuaticos"],
    "Tarea": "Busqueda de sobrevivientes",
}
])
###############################################################################

################################################################# ESTADO_TAREA.
estado_tarea.insert_many([
{
    "descrip": "No iniciado"
},
{
    "descrip": "Cancelado"
},
{
    "descrip": "Preparado para iniciar"
},
{
    "descrip": "En desarrollo"
},
{
    "descrip": "Finalizado"
}
])
###############################################################################