# Acceder a Curso

### ID y Nombre:

CU - 05 Acceder a Curso

### Actor

Usuario

### Descripción:

En este caso de uso, el Usuario ingresa a alguno de sus cursos comprados

### Precondiciones

- El Usuario inició sesión
- Hay Cursos registrados en la Base de Datos

### Flujo Normal:

1. El Sistema muestra una lista con los nombre e imagen de los CURSO comprados por el Usuario (ver Ex-4.1)
2. El Usuario selecciona un CURSO
3. El sistema obtiene la información del CURSO y la despliega (ver Ex-4.1)
4. Si el Usuario selecciona "Consultar Calificaciones" (ver FA-4.1)
5. Si el Usuario selecciona "Ver actividades" (ver FA-4.2)
6. Si el Usuario selecciona "Ver material" (ver FA-4.3)
7. Fin del CU

### Flujos Alternos

**FA-5.1: Consultar Calificaciones**

1. El Sistema consulta calificaciones [Extiende al CU - 06 Consultar Calificaciones]
2. Fin del CU

**FA-5.2: Ver Calificaciones**

1. El Sistema accede a las actividades del CURSO [Extiende al CU - 07 Realizar Actividad]
2. Fin del CU

**FA-5.3: Ver Material**

1. El Sistema accede a los materiales del CURSO [Extiende al CU - 08 Consultar Materiales]
2. Fin del CU

### Excepciones

**Ex-5.1: Error con la conexión a la base de datos**

1. El Sistema muestra un mensaje: “Error con la conexión a la base de datos”.
2. Fin de CU.

### Postcondiciones

- El Usuario accede a sus cursos comprados

### Extends 

- CU - 06 Consultar Calificaciones
- CU - 07 Realizar Actividad
- CU - 08 Consultar Materiales