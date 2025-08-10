# Conversor de Monedas

## Descripción

Este proyecto es un conversor de monedas desarrollado en Java que consume una API pública para obtener las tasas de cambio actualizadas en tiempo real. Permite convertir entre varias monedas seleccionadas mediante una interfaz textual sencilla en consola.

---

## Tecnologías utilizadas

- Java 11+
- Biblioteca Gson para parseo JSON
- API ExchangeRate-API para obtener tasas de cambio
- Cliente HTTP nativo de Java (`HttpClient`)

---

## Funcionalidades principales

- Obtención dinámica de tasas de cambio vía API REST.
- Conversión entre dólares, pesos mexicanos, pesos brasileños, pesos colombianos, y más.
- Menú interactivo en consola para seleccionar monedas y realizar conversiones.
- Manejo de errores básicos para respuestas inválidas o monedas no soportadas.

---

## Cómo ejecutar el proyecto

1. Clonar el repositorio
2. Abrir el proyecto en IntelliJ IDEA o tu IDE favorito.
3. Insertar tu API key válida en la constante `API_KEY` dentro de la clase `ConversorApp`.
4. Ejecutar la clase principal `ConversorApp`.
5. Seguir las instrucciones en consola para realizar conversiones.

---

## Estructura del proyecto

- `ConversorApp.java`: contiene la lógica para llamar a la API y obtener tasas de cambio.
- `Conversor.java`: presenta el menú de usuario y controla el flujo de interacción y conversión.
- `README.md`: documentación del proyecto.

---

## Próximos pasos / Mejoras

- Agregar manejo avanzado de errores e inputs inválidos.
- Soportar más monedas y conversiones.
- Implementar interfaz gráfica.
- Tests automatizados para validar funcionalidades.

---

## Autor

Ricardo Cervantes Vergara  
[LinkedIn](https://www.linkedin.com/in/ricardo-cervantes-vergara/)  
[GitHub](https://github.com/ricardocervantesv)

---

## Referencias

- [ExchangeRate-API](https://www.exchangerate-api.com/)
- [Documentación Gson](https://github.com/google/gson)
- [Documentación HttpClient Java](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html)

