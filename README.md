<div align="center">

# MANOS DE OAXACA

## APLICACIÓN MVC CON SPRING BOOT Y THYMELEAF

### Actividad 2 — Tema 4

<br>

**Tecnológico Nacional de México**
**Instituto Tecnológico de Oaxaca**

<br>

**Carrera:** Ingeniería en Sistemas Computacionales
**Materia:** Programación Web
**Docente:** Adelina Martínez Nieto
**Estudiante:** Dalia Montserrat Caballero Silva

<br>

**Oaxaca de Juárez, Oaxaca — 2026**

</div>

---

## Descripción del proyecto

**Manos de Oaxaca** es una aplicación web desarrollada con Java, Spring Boot y Thymeleaf que implementa el patrón de arquitectura Modelo-Vista-Controlador, también conocido como MVC, la aplicación permite consultar una lista de talleres artesanales de Oaxaca, filtrar los talleres por especialidad, visualizar el detalle de un taller mediante su identificador y registrar nuevos talleres utilizando un formulario HTML.

También incluye un endpoint REST de tipo POST que recibe información en formato JSON mediante una clase DTO y que puede probarse desde Postman o Bruno.


---


Se implementaron clases DTO y las siguientes anotaciones:

* `@Controller`
* `@RestController`
* `@RequestMapping`
* `@GetMapping`
* `@PostMapping`
* `@ModelAttribute`
* `@RequestParam`
* `@PathVariable`
* `@RequestBody`
* `@Value`

---

## Tecnologías utilizadas

* Java 25
* Spring Boot 4.1.0
* Spring Web MVC
* Thymeleaf
* Maven
* HTML5
* CSS3
* Postman
* Git
* GitHub
* Visual Studio Code
* VPS con Ubuntu

--

### Modelo

El modelo está representado principalmente por la clase:

```text
TallerDTO.java
```

Esta clase contiene los datos de cada taller:

* ID
* Nombre del taller
* Nombre del artesano
* Especialidad
* Ubicación

### Vista

Las vistas fueron desarrolladas con HTML y Thymeleaf.

Se encuentran en:

```text
src/main/resources/templates/talleres
```

Las vistas implementadas son:

* `lista.html`
* `formulario.html`
* `detalle.html`

### Controlador

El controlador MVC es:

```text
TallerMvcController.java
```

Este controlador recibe las solicitudes del navegador, procesa los datos y los envía a las vistas utilizando el objeto `Model`.

También existe un controlador REST:

```text
TallerController.java
```
Este controlador devuelve información en formato JSON y contiene el endpoint POST probado desde Postman.


---

## Clase DTO

La clase `TallerDTO` se utiliza para transportar la información de un taller entre los formularios, los controladores y los endpoints REST.

Sus atributos son:

```java
private Long id;
private String nombreTaller;
private String artesano;
private String especialidad;
private String ubicacion;
```

El DTO se utiliza en:

* La lista de talleres.
* El formulario Thymeleaf.
* El detalle de un taller.
* El endpoint POST REST.
* La petición JSON enviada desde Postman.

---

## Funcionalidades implementadas

### Lista de talleres

La aplicación muestra una lista de talleres utilizando el objeto `Model` y la directiva `th:each` de Thymeleaf.

```http
GET /mvc/talleres
```

URL local:

```text
http://localhost:8084/mvc/talleres
```

![Lista de talleres](capturas/lista-talleres.png)

---

### Formulario con `@ModelAttribute`

La aplicación contiene un formulario para registrar talleres.

El formulario se abre mediante:

```http
GET /mvc/talleres/nuevo
```

URL local:

```text
http://localhost:8084/mvc/talleres/nuevo
```

Cuando el formulario se envía, sus campos se reciben mediante:

```java
@ModelAttribute("taller") TallerDTO taller
```

Endpoint que procesa el formulario:

```http
POST /mvc/talleres/guardar
```

![Formulario de talleres](capturas/formulario.png)

---

### Filtro con `@RequestParam`

La lista puede filtrarse por especialidad utilizando un parámetro en la URL.

Ejemplo:

```http
GET /mvc/talleres?especialidad=Textiles
```

URL local:

```text
http://localhost:8084/mvc/talleres?especialidad=Textiles
```

El controlador recibe el parámetro mediante:

```java
@RequestParam(required = false) String especialidad
```

![Filtro con RequestParam](capturas/request-param.png)

---

### Detalle con `@PathVariable`

La aplicación permite consultar un taller específico utilizando su ID.

Ejemplo:

```http
GET /mvc/talleres/1
```

URL local:

```text
http://localhost:8084/mvc/talleres/1
```

El ID se recibe mediante:

```java
@PathVariable Long id
```

![Detalle con PathVariable](capturas/path-variable.png)

---

### Propiedad personalizada con `@Value`

En el archivo `application.properties` se configuró la propiedad:

```properties
proyecto.nombre=Manos de Oaxaca - Actividad 2
```

La propiedad es leída desde el controlador mediante:

```java
@Value("${proyecto.nombre}")
private String nombreProyecto;
```

Posteriormente, el nombre del proyecto es enviado a las vistas mediante el objeto `Model`.

---

### Endpoint POST REST

Se creó un endpoint REST que recibe un objeto `TallerDTO` en formato JSON.

```http
POST /talleres/crear
```

URL local:

```text
http://localhost:8084/talleres/crear
```

El objeto se recibe mediante:

```java
@RequestBody TallerDTO taller
```

JSON utilizado en Postman:

```json
{
  "id": 5,
  "nombreTaller": "Taller Artesanal Monte Albán",
  "artesano": "Elena Martínez",
  "especialidad": "Textiles",
  "ubicacion": "Oaxaca de Juárez"
}
```

![Petición POST en Postman](capturas/post-postman.png)

---

## Otros endpoints REST

### Identificación del proyecto

```http
GET /proyecto
```

URL local:

```text
http://localhost:8084/proyecto
```

### Lista obtenida desde la API externa

```http
GET /talleres
```

URL local:

```text
http://localhost:8084/talleres
```

### Nombre y ubicación de un taller

```http
GET /talleres/ubicacion
```

URL local:

```text
http://localhost:8084/talleres/ubicacion
```

---

## API externa utilizada

La información del controlador REST se obtiene desde MockAPI:

```text
https://6a545ff38547b9f7111c26d6.mockapi.io/talleres
```

---

## Ejecución local

Para ejecutar el proyecto en Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

La aplicación se ejecuta en el puerto:

```text
8084
```

Vista principal:

```text
http://localhost:8084/mvc/talleres
```

---

## Compilación del proyecto

Para generar el archivo `.jar` se utiliza:

```powershell
.\mvnw.cmd clean package
```

El archivo generado se encuentra en:

```text
target/CSDMact2_t4-0.0.1-SNAPSHOT.jar
```

---

## Despliegue en el VPS

La Actividad 2 se despliega en una carpeta diferente a la Actividad 1.

La Actividad 2 utiliza el puerto:

```text
8084
```

Vista principal desplegada:

```text
http://54.83.75.25:8084/mvc/talleres
```

![Actividad 2 en el VPS](capturas/actividad2-vps.png)

---

## Actividad 1

La Actividad 1 se mantiene en su repositorio, carpeta y puerto original.

Enlace:

```text
http://54.83.75.25:8082/proyecto
```

![Actividad 1 en el VPS](capturas/actividad1-vps.png)

De esta manera, ambas actividades pueden ejecutarse al mismo tiempo sin sobrescribirse.

---

## Repositorios

### Actividad 2

```text
https://github.com/MontseCaballero29/CSDMact2_t4
```

### Actividad 1

```text
https://github.com/MontseCaballero29/CSDMact1_t4
```

---

