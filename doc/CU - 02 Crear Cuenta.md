# Iniciar Sesión

### ID y Nombre:

CU - 02 Crear Cuenta

### Actor

Usuario

### Descripcion:

En este caso de uso, un nuevo Usuario puede registrarse en el sistema.

### Precondiciones

- El Usuario no está registrado previamente en la Base de Datos del sistema

### Flujo Normal:

1. El sistema muestra la pantalla de Registro, solicitando sus datos (nombre, apellidoPaterno, apellidoMaterno, CURP, fechaNacimiento, genero, usuario y contrasena) así como una confirmación de su contraseña.
2. El Usuario introduce los datos solicitados y da click en "Registrar".
3. El sistema valida que no haya ningún campo vacío (ver FA-2.1).
4. El sistema valida que no haya otro USUARIO registrado previamente con el nombreUsuario introducido (ver FA-2.2)(ver Ex-2.1).
5. El sistema valida que la contrasena y su confirmación introducida coincidan (ver FA-2.3).
6. El sistema almacena en la Base de Datos los datos del nuevo USUARIO (ver Ex-2.1).
7. El sistema envía un mensaje de confirmación "Cuenta registrada con éxito".
8. El sistema muestra la pantalla principal.
9. Fin del CU.

### Flujos Alternos

**FA-2.1: Campos incompletos**

1. El Sistema muestra un mensaje: “Campos incompletos”.
2. Regresa al punto 2 del Flujo Normal.

**FA-2.2: Nombre de Usuario ya registrado**

1. El Sistema muestra un mensaje: “Ya hay un usuario con ese nombre”.
2. Regresa al punto 2 del Flujo Normal.

**FA-2.3: Las contraseñas no coinciden**

1. El sistema muestra un mensaje: "Las contraseñas ingresadas no coinciden"
2. Regresa al punto 2 del Flujo Normal

### Excepciones

**Ex-2.1: Error con la conexión a la base de datos**

1. El Sistema muestra un mensaje: “Error con la conexión a la base de datos”.
2. Fin de CU.

### Postcondiciones

- El Usuario queda registrado en la Base de Datos.
- El Usuario accede a su pantalla principal.