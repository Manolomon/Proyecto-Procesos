# Inscribir Curso

### ID y Nombre:

CU - 03 Inscribir Curso

### Actor

Usuario

### Descripción:

En este caso de uso, el Usuario se enrola en alguno de los cursos ofertados en el sistema

### Precondiciones

- El Usuario inició sesión
- Hay Cursos registrados en la Base de Datos

### Flujo Normal:

1. El sistema obtiene de la base de datos los CURSO disponibles y los muestra ordenados por su categoría (ver Ex-3.1).
2. El Usuario da click en una categoría
3. El sistema muestra los CURSO asociados a esa categoría, ordenados por su nombre en otra lista (ver Ex-3.1).
4. El Usuario da click en un CURSO
5. El Usuario realiza el PAGO del CURSO [Incluye CU - 04 Realizar Pago de Curso]
6. El Sistema asigna al USUARIO a un GRUPO para el CURSO (ver Ex-3.1).
7. Fin del CU

### Flujos Alternos

### Excepciones

**Ex-3.1: Error con la conexión a la base de datos**

1. El Sistema muestra un mensaje: “Error con la conexión a la base de datos”.
2. Fin de CU.

### Postcondiciones

- El sistema envía una solicitud de compra
- El sistema registra al usuario en un grupo

### Include 

- CU 04 - Procesar Pago de Curso