# Consultar Calificaciones

### ID y Nombre:

CU - 06 Consultar Calificaciones

### Actor

Usuario

### Descripción:

En este caso de uso, el Usuario visualiza la calificación de su curso

### Precondiciones

- El Usuario inició sesión
- Hay Cursos registrados en la Base de Datos
- El Usuario tiene Cursos comprados

### Flujo Normal:

1. El sistema obtiene de la base de datos todos los EVALUABLE del Curso (ver Ex-6.1)
2. El sistema calcula el promedio de la calificacionTotal y la calificacionObtenida y lo muestra
3. Fin del CU

### Flujos Alternos

### Excepciones

**Ex-6.1: Error con la conexión a la base de datos**

1. El Sistema muestra un mensaje: “Error con la conexión a la base de datos”.
2. Fin de CU.

### Postcondiciones

- El sistema calcula el promedio de todos los evaluables del Curso