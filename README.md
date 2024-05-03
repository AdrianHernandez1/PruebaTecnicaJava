# Instrucciones para ejecutar el proyecto

Este documento proporciona instrucciones detalladas sobre cómo configurar y ejecutar el proyecto de Spring Boot.

## Requisitos previos

Antes de comenzar, asegúrate de tener instalado lo siguiente en tu sistema:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) versión 11 o superior
- [Apache Maven](https://maven.apache.org/) (para compilar y construir el proyecto)
- [MySQL](https://www.mysql.com/) u otro sistema de gestión de bases de datos compatible

## Configuración del proyecto

1. Clona este repositorio en tu máquina local:

    ```
    git clone <URL_del_repositorio>
    ```

2. Accede al directorio del proyecto:

    ```
    cd nombre_del_proyecto
    ```

3. Configura la base de datos:

    - Crea una base de datos MySQL con el nombre `BD_Productos`.
    - Actualiza la configuración de conexión a la base de datos en el archivo `application.properties` en el directorio `src/main/resources`.

4. Compila y construye el proyecto utilizando Maven:

    ```
    mvn clean install
    ```
    ```
    mvn spring-boot:run
    ```
## Ejecución del proyecto

Una vez completada la configuración, puedes ejecutar el proyecto utilizando el siguiente comando:

