# JSP (Java Server Pages)

## JSP Quick Understanding

Uno de los problemas que tienen los servlets es que se mezclan dos tecnologías distintas.

Por un lado, el HTML que se devuelve pertenece a tecnología del cliente, mientras que todo lo demás es código Java, perteneciente a tecnología del servidor.

Ni a un programador backend ni a uno de frontend les va a gustar trabajar con servlets. Un programador frontend va a encontrar muy tedioso escribir el HTML como una cadena de texto.

JSP es una tecnología que surge para solucionar esto.

En servlets, lo que tenemos es código HTML dentro de código Java, mientras que en JSP, lo que tenemos es código Java dentro de código HTML, pero de una manera separada, usando `<% %>`.

Sin embargo, JSP no es un reemplazo de los servlets, sino que se usa un mix de estas tecnologías para desarrollar nuestras aplicaciones. Por ejemplo, usaremos servlets cuando no se devuelva código HTML.

Ver proyecto `jspexample`.

**Testing**

Esto que se indica aquí es una forma manual de hacer las cosas, no recomendada pero interesante de conocer.

- Yo ya tengo un servidor Tomcat externo en el directorio `/Users/jmmm/Programacion/tools/apache-tomcat-11.0.2`
- Copio en la ruta `/Users/jmmm/Programacion/tools/apache-tomcat-11.0.2/webapps` el directorio `jspexample`, que contiene los dos ficheros `jspexample.html` y `jspexample.jsp`
- Abro una terminal y accedo a ruta `/Users/jmmm/Programacion/tools/apache-tomcat-11.0.2/bin`
  - En la terminal ejecuto el comando `sudo bash catalina.sh run`
- En el navegador indico la URL `http://localhost:8080/jspexample/jspexample.html`
  - Indico los dos números, por ejemplo `1` y `5` y pulso el botón `Add`
  - Debe irse automáticamente a la ruta `http://localhost:8080/jspexample/jspexample.jsp?number1=1&number2=5` y el resultado `And the result is... 6`

## Let's Go Deep

Vamos a ver el ciclo de vida de JSP.

Volviendo al proyecto `jspexample`, al fuente `jspexample.jsp`, ¿de dónde viene `request` y `out`?

Cuando se manda la request al fichero JSP, el servidor Tomcat hace una traducción del fichero JSP a un servlet Java equivalente, y el servlet y su compilado .class, Tomcat los mantiene en un directorio donde puede ir a buscarlo.

Este directorio de Tomcat es `work/Catalina/localhost/jspexample/org/apace/jsp/` y dentro de este directorio podemos ver los ficheros `jspexample_jsp.class` y `jspexample_jsp.java`.

Si vemos el archivo `jspexample_jsp.java` vemos que la clase extiende de `HttpJspBase`, que a su vez extiende de `HttpServlet` e implementa `HttpJspPage`. Esta última interface extiende `JspPage` que, por último, extiende `Servlet`.

Esto significa que el ciclo de vida de JSP, una vez hecha la traducción antes indicada, es el mismo que el ciclo de vida de un servlet.

En vez del método `init()` tenemos el método `jspinit()` y en vez de `destroy()` tenemos `jspDestroy()`, que son implementaciones realizadas por la clase `HttpJspBase`. Podemos sobreescribir dichos métodos en nuestras clases.

Por tanto, `request` y `out` están disponibles gracias al container de las clases del servlet. En concreto, `out` está disponible gracias a la clase `JspWrite`.

¿Qué objetos podemos usar en nuestro JSP, gracias a que el servlet autogenerado nos lo permite?

- request
- response
- out
- session
- application
- config
- page

## Elements and Directives

Ver proyecto `jspelements` que contiene el JSP `jspelements.jsp` y el html `test.html`. Se sube manualmente a Tomcat, tal y como hemos visto un poco más arriba.

Y la ruta para ejecutar el JSP es `http://localhost:8080/jspelements/jspelements.jsp`

Vamos a ver varios elementos que podemos incluir como parte de un fichero JSP (ver jspelements.jsp y su traducción dentro de Tomcat).

**Comentarios**

`<%-- JSP Comments --%>`

**Scriplet**

Es lo que hemos visto hasta ahora

```
<%
  int a = 10;
  int b = 20;

  out.print(a + b);
%>
```

**Expresiones**

Es una sola línea incrustada entre un tag HTML.

`<p>Current Date info: <%= new java.util.Date() %></p>`

En la traducción al servlet, vemos que se envía automáticamente al método out.print() de la siguiente manera: `out.print(new java.util.Date());`

**Declaraciones**

Se pueden declarar variables y métodos

```
<%! private int pageviews; %>
<%! public void incrementPageviews() {
  ++pageviews;
}
%>
```

Las variables se posicionan en el servlet autogenerado a nivel de clase.

**JSP Page Directives**

Sirven para varias cosas.

Usadas con el atributo import, nos permite importar clases externas o packages.

Usadas con el atributo session con valor false, nuestra webapp no va a querer mantener sesiones.

```
<%@page import="java.sql.*" %>

<%@page session="false" %>
```

**JSP Include Directives**

Nos permite importar contenido externo, como ficheros html o imágenes, por ejemplo.

Se suele usar para contenido que es el mismo a lo largo de toda nuestra app, como por ejemplo un footer o un header con nuestro logo.

`<%@include file="text.html" %>`

## Elements and Directives Part 2

Ver fichero [Elements and Directives](directives.txt).

## Action Elements

Ver fichero [Action Elements](actionelements.txt).

Los JSP action elements nos ayudan a hacer acciones cuando el servlet se está ejecutando.

A diferencia de los elementos y directivas que aparecen cuando el JSP se traduce a un servlet, los action elements aparecen cuando el servlet está en ejecución.

Ver también el proyecto `jspinclude`, que contiene los fuentes `jspexample.html`, `jspexample.jsp`, `include.jsp` y `test.jsp`. Ver las explicaciones en el código.

**Testing**

Se sube manualmente a Tomcat, tal y como hemos visto más arriba y vamos a la ruta `http://localhost:8080/jspinclude/jspexample.html`

## NOTA

Aunque el curso tiene algunas clases más de JSP y JSTL, la verdad es que no me importa mucho.

Este curso lo hice para aprender un poco de la parte de Networking (TCP, UDP) y la parte de los Servlets, porque luego se usa por debajo en Spring.
