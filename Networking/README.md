# Networking

Todos estos fuentes los he estado viendo/ejecutando en VSCode.

Se ejecutan en el mismo ordenador, aunque en la vida real se ejecutarían en ordenadores diferentes.

## Simple Socket Example

Ver los fuentes `SimpleServer.java` y `SimpleClient.java` en el package `src/Examples`.

El protocolo que se ha usado es el protocolo TCP.

TCP (Transmission Control Protocol) es un protocolo orientado a conexión, lo que significa que antes de enviar datos, el emisor y el receptor deben establecer una conexión.

Se usa TCP en aplicaciones que requieren una conexión estable y fiable, como por ejemplo, la navegación web, correo electrónico, transferencia de archivos, etc.

Ejecutar primero el servidor y luego el cliente.

## Echo Server

Ver los fuentes `EchoServer.java` y `EchoClient.java` en el package `src/Examples`.

La diferencia con `Simple Socket Example` es que el cliente tiene un bucle para enviar mensajes hasta que se escribe `end` y el servidor tiene un bucle para recibir mensajes hasta que recibe `end`.

Ejecutar el servidor y luego el cliente.

## Client and Server (Multiple Clients)

Ver los fuentes `Client.java`, `Server.java` y `ServerApp.java` en el package `src/Examples`.

Ejecutar `Server.java`.

Vamos a probar más de un cliente. Ejecutar `Client.java` varias veces en terminales con el siguiente comando:

```
java -cp ./bin Examples.Client 
```

Vemos que nuestro server es capaz de manejar múltiples clients.

Esto es porque nuestro fuente `Server.java` crea un nuevo hilo para cada cliente que se conecta, en concreto, se crea un nuevo Thread de `ServerApp.java`, el cual, su clase extiende de `Thread`.

## UDP Sender Receiver

Ver los fuentes `Sender.java` y `Receiver.java` en el package `src/udp`.

A diferencia de TCP, UDP (User Datagram Packet) es un protocolo sin conexión, lo que significa que no hay una conexión establecida entre el emisor y el receptor antes de enviar datos y no se garantiza que los datos lleguen al receptor, ni en el orden en el que se enviaron.

De hecho, a UDP se le llama también "fire and forget" porque el emisor envía los datos y no espera confirmación de que el receptor los ha recibido.

Ejemplos de uso de UDP serían videoconferencias, juegos online, streaming de video, etc.

Ejecutamos primero el `Receiver.java` y luego el `Sender.java`.

Veremos que en el `Receiver.java` se imprime el mensaje que envía el `Sender.java`.

## UDP Multicast

Ver los fuentes `MulticastingSender.java` y `MulticastingReceiver.java` en el package `src/udp`.

En este caso se envía el mensaje a una dirección multicast, que es una dirección IP especial que permite enviar datos a múltiples receptores.

**Prueba 1**
Ejecutar primero, en varias terminales, `MulticastingReceiver.java` con el siguiente comando:

```
java -cp ./bin udp.MulticastingReceiver 226.4.5.6
```

La IP es la misma que tenemos en `MulticastingSender.java`.

Ejecutar `MulticastingSender.java`.

Veremos que el mensaje se envía a todos los receptores que estén escuchando en la dirección multicast.

**Prueba 2**
Ejecutar primero, en una terminal, `MulticastingReceiver.java` con el siguiente comando:

```
java -cp ./bin udp.MulticastingReceiver 226.4.5.10
```

Esta IP no la tenemos en `MulticastingSender.java`.

Volver a ejecutar, en una segunda terminal, `MulticastingReceiver.java` con el siguiente comando:

```
java -cp ./bin udp.MulticastingReceiver 226.4.5.6
```

Esta IP es la misma que tenemos en `MulticastingSender.java`.

Ejecutar `MulticastingSender.java`.

Veremos que el mensaje se envía solo a la segunda terminal.

## URL

Ver fuente `URLExample.java` en el package `src/url`.

URL (Uniform Resource Locator) es una dirección que se utiliza para localizar un recurso en la web.

Indicamos un protocolo, una dirección IP o un nombre de dominio, un puerto y una ruta.

En el fuente hay dos ejemplos, uno debe estar comentado y el otro descomentado, listo para ejecutar.

Se pide explorar la clase `java.net`, aunque no es muy usada por desarrolladores, más bien por administradores de redes.
