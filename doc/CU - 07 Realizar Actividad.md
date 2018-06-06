# Realizar Actividad

### ID y Nombre:

CU - 07 Realizar Actividad

### Actor

Usuario

### Descripción:

En este caso de uso, el Usuario accede a las actividades y las visualiza

### Precondiciones

- El Usuario inició sesión
- Hay Cursos registrados en la Base de Datos
- El Usuario tiene Cursos comprados
- Hay actividades registradas al Curso
- 
### Flujo Normal:

1. El sistema obtiene de la base de datos todas las ACTIVIDAD del Curso (ver Ex-7.1)
2. El sistema muestra una lista con los nombre del MATERIAL
3. El Usuario selecciona algún elemento de la lista
4. El sistema muestra los datos de la ACTIVIDAD seleccionada (nombre, archivoAdjunto, descripcion, fechaInicio, fechaFin)
5. Fin del CU

### Flujos Alternos

### Excepciones

**Ex-7.1: Error con la conexión a la base de datos**

1. El Sistema muestra un mensaje: “Error con la conexión a la base de datos”.
2. Fin de CU.

### Postcondiciones

- El sistema muestra los datos de alguna Actividad del Curso