## Prerrequisitos

- Java 21 o superior
- Maven 3.9 o superior
- Node.js 20 o superior (incluye npm)
- PostgreSQL

## Configuración de la Base de Datos

1.  Tener PostgreSQL instalado y corriendo.
2.  Crea una base de datos llamada `interview`.
3.  Configura las credenciales de la base de datos en el archivo del backend `backend/src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/interview?useSSL=false&allowPublicKeyRetrieval=true
    spring.datasource.username=postgres
    spring.datasource.password=password
    ```
    Cambia `spring.datasource.username` y `spring.datasource.password` según tu usuario de PostgreSQL.

## Ejecución del Backend

1.  Navega al directorio `backend`:
    ```bash
    cd backend
    ```
2.  Ejecuta la aplicación Spring Boot:
    ```bash
    mvn spring-boot:run
    ```
    El backend correrá en el puerto 8080.

## Ejecución del Frontend

1.  Navega al directorio `frontend`:
    ```bash
    cd frontend
    ```
2.  Instala las dependencias:
    ```bash
    npm install
    ```
3.  Inicia el servidor de desarrollo:
    ```bash
    npm run dev
    ```
    El frontend correrá en el puerto 5173 por defecto.

## Acceso a la Aplicación

- Backend API: `http://localhost:8080`
- Frontend: `http://localhost:5173`