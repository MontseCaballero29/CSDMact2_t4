<div align="center">

# MANOS DE OAXACA

## API REST CON SPRING BOOT

### Actividad 1 — Tema 4

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

**Manos de Oaxaca** es una API REST desarrollada con Java y Spring Boot para consultar información relacionada con talleres artesanales del estado de Oaxaca.

La aplicación permite identificar el proyecto, consultar una lista de talleres obtenida desde una API externa y mostrar el nombre y la ubicación de uno de los talleres disponibles.

El proyecto fue probado localmente y desplegado en un VPS mediante un archivo ejecutable `.jar`.

---

## Tecnologías utilizadas

- Java 25
- Spring Boot
- Spring Web
- Maven
- RestClient
- MockAPI
- Git y GitHub
- Visual Studio Code
- VPS con Ubuntu

---

## API externa utilizada

La información de los talleres se obtiene desde la siguiente API:

```text
https://6a545ff38547b9f7111c26d6.mockapi.io/talleres
```

---

## Controladores

El proyecto cuenta con dos controladores:

- `ProyectoController.java`: identifica el proyecto y a la estudiante.
- `TallerController.java`: consulta y devuelve la información de los talleres.

---

## Endpoints

### Identificación del proyecto

```http
GET /proyecto
```

Enlace:

```text
http://54.83.75.25:8082/proyecto
```

Respuesta:

```text
Manos de Oaxaca - Dalia Montserrat
```

### Lista de talleres

```http
GET /talleres
```

Enlace:

```text
http://54.83.75.25:8082/talleres
```

Devuelve la lista de talleres en formato JSON.

### Ubicación de un taller

```http
GET /talleres/ubicacion
```

Enlace:

```text
http://54.83.75.25:8082/talleres/ubicacion
```

Devuelve el nombre y la ubicación de uno de los talleres.

---

## Ejecución local

Para ejecutar el proyecto en Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

La aplicación utiliza el puerto `8082`.

---

```

**Proyecto funcionando en el VPS:**

```text
http://54.83.75.25:8082/proyecto
```

