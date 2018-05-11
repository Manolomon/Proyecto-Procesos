# Inscribir Curso

### ID y Nombre:

CU - 03 Inscribir Curso

### Actor

Usuario

### Descripcion:

En este caso de uso, el Usuario se enrola en alguno de los cursos ofertados en el sistema

### Precondiciones

- El Usuario inició sesión
- Hay Cursos registrados en la Base de Datos

### Flujo Normal:

1. El sistema obtiene de la base de daos los CURSO disponibles y los muestra ordenados por su categoría (ver Ex-3.1).
2. El Usuario da click en una categoría
3. El sistema muestra los CURSO asociados a esa categoría, ordenados por su nombre en otra lista.
4. El Usuario da click en un

### Flujos Alternos

**FA-3.1**

1. 

### Excepciones

**Ex-3.1: Error con la conexión a la base de datos**

1. El Sistema muestra un mensaje: “Error con la conexión a la base de datos”.
2. Fin de CU.

### Postcondiciones

- El sistema envía una solicitud de compra
- El sistema registra al usuario en un grupo

### Include 

- CU 04 - Procesar Pago de Curso