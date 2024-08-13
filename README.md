
# Locales API

Este proyecto es una API para gestionar locales, gerentes, clientes y órdenes, desarrollada con Spring Boot. La API permite manejar de manera eficiente la información de locales, incluyendo gerentes asociados, clientes y las órdenes realizadas en cada local.


## Requisitos

-   Java 17 o superior
-   Maven 3.6.3 o superior

## Instalación

Sigue estos pasos para instalar y configurar el proyecto:
1. Clona el repositorio:
```
	git clone https://github.com/tu-usuario/locales-api.git
```
2. Navega al directorio del proyecto::
```
	cd locales-api
```
3. Compila el proyecto:
```
	mvn clean install
```
## Configuración

El archivo de configuración principal se encuentra en `src/main/resources/application.yml`. Puedes modificar este archivo para cambiar la configuración de la base de datos y otros ajustes de la aplicación.
```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/apiLocals
    username: postgres
    password: tu_contraseña
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  springdoc:
    api-docs:
      enabled: true
    swagger-ui:
      enabled: true
      path: /swagger-ui.html
```
### Perfiles de configuración

El proyecto soporta múltiples perfiles para diferentes entornos:

-   **dev**: Configuración para desarrollo.
-   **qa**: Configuración para calidad.
-   **prod**: Configuración para producción.
-   **test**: Configuración para pruebas.

Cada perfil se encuentra en un archivo de configuración específico (`application-dev.yml`, `application-qa.yml`, etc.).


## Funcionalidades

La API permite realizar las siguientes operaciones:

-   **Locales**: Crear, actualizar, eliminar y consultar locales.
-   **Gerentes**: Asociar gerentes a locales.
-   **Clientes**: Gestionar la información de los clientes.
-   **Órdenes**: Crear, actualizar y consultar órdenes asociadas a locales.
- 
## Documentación de la API con Swagger

La API incluye Swagger para la documentación interactiva. Una vez que la aplicación esté en funcionamiento, puedes acceder a la documentación completa de la API en `http://localhost:8080/swagger-ui.html`.


## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para obtener más información.
