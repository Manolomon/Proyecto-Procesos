# Procesar Pago de Curso

### ID y Nombre:

CU - 04 Procesar Pago de Curso

### Actor

Usuario y Administrador

### Descripción:

En este caso de uso, el Usuario ingresa sus datos de cuenta para realizar el pago de un curso y el Administrador lo aprueba o rechaza.

### Precondiciones

- El Usuario inició sesión
- Hay Cursos registrados en la Base de Datos
- El Usuario seleccionó un Curso para pagar 

### Flujo Normal:

1. El Sistema solicita los datos bancarios USUARIO
2. El Usuario selecciona una forma de pago e ingresa su numero de referencia bancaria y su folio
3. El Sistema valida los datos ingresados (ver FA-4.1)
4. El Sistema registra el CURSO con un estatus de "pendiente" (ver Ex-4.1)
5. El Administrador selecciona el pago pendiente
6. El Administrador selecciona "Aceptar" (ver FA-4.2)
7. El Sistema guarda el CURSO con un estatus de "aprobado" (ver Ex-4.1)
8. Fin del CU

### Flujos Alternos

**FA-4.1: Campos incompletos**

1. El Sistema muestra un mensaje: "Por favor llene todos los campos necesarios"
2. Regresa al punto 2 del Flujo Normal

**FA-4.2: Selecciona "Rechazar"**

1. El Sistema guarda el CURSO con un estatus de "rechazado" (ver Ex-4.1)
2. Fin del CU

### Excepciones

**Ex-4.1: Error con la conexión a la base de datos**

1. El Sistema muestra un mensaje: “Error con la conexión a la base de datos”.
2. Fin de CU.

### Postcondiciones

- El sistema almacena un curso con estado de "Aprobado"
