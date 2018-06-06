# Iniciar Sesión

### ID y Nombre:

CU - 01 Iniciar Sesión

### Actor

Usuario

### Descripción:

En este caso de uso, el Usuario ingresa sus datos de identificación para ingresar al sistema.

### Precondiciones

- El Usuario ya está registrado dentro de la Base de Datos del sistema.

### Flujo Normal:

1. El Sistema muestra la pantalla de Inicio de Sesión. 
2. El Usuario introduce su correo y contraseña. De otra manera da clic en “Registrarse” [Extiende al CU 02 – “Crear Cuenta”].
3. El Usuario da clic en "Iniciar Sesión", si falta algún campo sin llenar (ver FA-1.1).
4. El Sistema verifica la autenticidad de los datos (ver Ex-1.1), si algún dato es incorrecto (ver FA-1.2).
5. El Sistema accede con la cuenta del usuario correspondiente.
6. El Sistema muestra la pantalla principal.
7. Fin del CU.


### Flujos Alternos

**FA-1.1: Campos incompletos**

1. El Sistema muestra un mensaje: “Campos incompletos”.
2. Regresa al punto 2 del Flujo Normal.

**FA-1.2: Los datos no corresponden**

1. El Sistema muestra un mensaje: “Los datos no son correctos”.
2. Regresa al punto 2 del Flujo Normal.

### Excepciones

**Ex-1.1: Error con la conexión a la base de datos**

1. El Sistema muestra un mensaje: “Error con la conexión a la base de datos”.
2. Fin de CU.

### Postcondiciones

- El Usuario accede a su pantalla principal.

### Extensiones

- CU02 – Crear Cuenta