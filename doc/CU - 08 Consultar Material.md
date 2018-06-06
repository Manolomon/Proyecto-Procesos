# Consultar Material

### ID y Nombre:

CU - 08 Consultar Material

### Actor

Usuario

### Descripción:

En este caso de uso, el Usuario visualiza los materiales del curso

### Precondiciones

- El Usuario inició sesión
- Hay Cursos registrados en la Base de Datos
- El Usuario tiene Cursos comprados
- Hay materiales registrados al Curso

### Flujo Normal:

1. El sistema obtiene de la base de datos todos los MATERIAL del Curso (ver Ex-6.1)
2. El sistema muestra una lista con los nombre del MATERIAL
3. El Usuario selecciona algún elemento de la lista
4. El sistema muestra los datos del MATERIAL (nombre, archivo, descripcion)
5. Fin del CU

### Flujos Alternos

### Excepciones

**Ex-6.1: Error con la conexión a la base de datos**

1. El Sistema muestra un mensaje: “Error con la conexión a la base de datos”.
2. Fin de CU.

### Postcondiciones

- El sistema muestra los datos de algún Material del Curso