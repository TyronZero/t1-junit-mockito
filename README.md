# T1 - Pruebas con JUnit y Mockito

Proyecto Maven con Java 22, JUnit 5 y Mockito 5.

Ejercicios:
- Ejercicio 1 (productos): Jonathan Garayar Gálvez
- Ejercicio 2 (libros): Américo Cornelio Baltazar
- Ejercicio 3 (clientes): Jhaser Alexander Campos Castañeda
- Video: Sunming Xiomara Rosado Quispe

Cada uno trabaja en su rama (ejercicio-1, ejercicio-2 o ejercicio-3) y solo toca su paquete. Nadie sube directo a main, todo va por Pull Request. Antes del PR hay que correr `mvn test`.

Cada ejercicio tiene su entidad, su Repository, su Service y sus tests: éxito, ID inválido y no encontrado. El 3 tiene uno más para cliente inactivo.

Orden de validación: campo vacío, ID inválido (no numérico o menor o igual a 0) y después buscar en el repositorio.

Mensajes:
- Campo vacío (los tres): Debe ingresar los datos requeridos
- ID inválido (1 y 2): Ingrese un ID válido
- ID inválido (3): Ingrese un ID correcto
- No encontrado: Producto no encontrado / Libro no encontrado / Cliente no registrado
- Inactivo (solo 3): Cliente inactivo
- Éxito: nombre del producto, título del libro, o "nombre apellido - correo" en el caso del cliente

Se entrega el zip del proyecto y el video explicando los tests, por Blackboard.
