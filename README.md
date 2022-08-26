# EL OTHELLO. CÓMO JUGAR

El Othello es un juego para dos personas. Se juega sobre un tablero semejante al del ajedrez, de 8*8, aunque sin distinción de colores entre cuadros, y se utilizan fichas circulares, con una cara blanca y otra negra.

Cada jugador elige un color, y mediante unas reglas que ahora veremos, van poniendo una ficha cada uno alternativamente. La partida acaba cuando el tablero está completo, o cuando ningún jugador puede poner. Gana aquel que al final de la partida, tiene más fichas de su color en el tablero.

La situación inicial en el tablero se ve en la Figura 1. Empiezan las negras.

![Figura 1](/Imagen1.png)
Figura 1.

Como hemos dicho, se juega por turnos alternados. En cada turno, el jugador debe poner una ficha en una posición del tablero en la que se “coma” al menos una ficha del jugador contrario.

Veamos cuando un jugador come una ficha y cuando no.

Supongamos que ponemos una ficha negra. Recorreremos el tablero por ejemplo hacia la derecha a partir de su posición, hasta encontrar otra ficha negra. Si entre estas dos fichas TODAS las casillas tienen una ficha blanca, se las da la vuelta, pasando a ser negras. Esto es lo que nosotros llamamos “comer” fichas blancas. La acción se repite en las ocho posibles direcciones: arriba, abajo, izquierda, derecha, y las cuatro diagonales.

En la Figura 2 se observa la colocación de una ficha negra de forma incorrecta. El jugador no puede poner en esa posición, pues no come ninguna ficha blanca. Esto es así porque en ninguna dirección hay otra ficha negra que está separada de la nueva ficha solo por fichas blancas (hay casillas vacías en medio).

![Figura 2](/Imagen2.png)
Figura 2

Sin embargo, en la Figura 3 aparece la ficha negra en otra situación. En este caso, el movimiento es legal, ya que a la izquierda hay una ficha blanca que puede ser comida, y luego una negra.

![Figura 3](/Imagen3.png)
Figura 3

Al poner ahí, el jugador daría la vuelta a la ficha blanca que come, para convertir esa ficha a negra. El resultado de este volteo se muestra en la Figura 4.

![Figura 4](/Imagen4.png) 
Figura 4.


Algunas veces, el jugador que posee el turno no puede poner en ninguna casilla, y debe ceder el turno al otro jugador. En caso de que ninguno de los dos jugadores pueda poner ficha, se da la partida por finalizada, y ganará el que más fichas de su color tenga en el tablero en ese momento.

# Objetivo
Se debe entregar un programa que permita Jugar Otello con Interfaz Gráfica, el programa posee unos requerimientos funcionales y otros no funcionales que se enuncian a continuación

## Requerimientos funcionales:

1. El Juego debe ser en modo multiusuario.
2. El ingreso de datos debe ser por Interfaz Grafica
3. El juego debe respetar las reglas del Othello.
4. Existen 2 modos para jugar:
  + Dos usuarios
  + Contra la maquina.
5. El juego se desarrollara en una matriz de 8 X 8.

## Requerimientos no funcionales:

1. El programa debe utilizar por lo menos 4 clases.
2. El programa de utilizar por lo menos 1 paquete.
3. El programa debe validar que no se juegue en posiciones inválidas.
4. Cada una de las clases debe hacer tareas relacionadas con su que hacer. Una clase no puede ser una clase todera.
5. Los atributos de cada clase deben ser privados, contando con sus respectivos métodos set y get que permitan el acceso a los mismos.
6. Se debe jugar por la interfaz gráfica.
 

## Modo de Entrega y Calificación

La aplicación puede ser desarrollada en grupos sin límite de integrantes.

El código fuente de la aplicación debe estar aquí en Replit.

El requerimiento  esencial para entregar la aplicación es su funcionalidad. En otras palabras, el programa como mínimo debe funcionar para ser entregado, una vez se supere esta etapa se procede a la sustentación.

El profesor seleccionarán a una persona del grupo para realizar la sustentación. Éste proceso consiste en dos pasos:

+ Explicación sobre cómo está hecho el programa
+ Modificación al código fuente: Esta modificación consistirá en agregar una nueva funcionalidad a la aplicación. Esta nueva funcionalidad se entregará en su momento. La persona que sustente tiene el tiempo de la sesión de clase para hacer y presentar la modificación solicitada. Sobre este proceso se calificará el proyecto para el grupo.
 