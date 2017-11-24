# poke-vleague
this is an http REST pokemon virtual league project

Proyecto poke liga
Introducción:

El objetivo del proyecto es crear una aplicación web basado en el uso de microservicios REST con fines didácticos. La finalidad del software es extraer datos de la pokeapi para generar equipos de pokemon y gestionar una liga virtual.
Alcance:
El proyecto intentará alcanzar los siguientes puntos:
1. Obtener equipos aleatorios de pokemon para el pickeo inicial de la liga.
2. Gestionar un sistema de “monedas” por cada jugador que le permitirá hacer cambios en su alineación.
3. Combates entre dos entrenadores, se utilizará un sistema de puntos basado en las muertes de cada combate.
OPCIONALES:
4. Integrar el servicio en un bot de telegram para gestionar la liga desde la aplicación.
5. Extraer datos de tiers de smogon para cada pokemon.

Desarrollo: 
1. Obtener equipos aleatorios de pokemon para el pickeo inicial de la liga:
	Se habilitará un endpoint mediante HTTP GET para extraer un pokemon aleatorio, para ello, se generará un número de pokedex aleatorio y se extraerán los datos del poke asociado a ese id de la pokedex. Los pokemon de cada jugador tendrán un nivel aleatorio del 0 al 5, el equipo de cada entrenador se guardará en la base de datos del servicio.

2. Gestionar un sistema de “monedas” por cada jugador que le permitirá hacer cambios en su alineación.
	Durante la selección de fichajes, cada jugador dispondrá de un número de monedas por determinar, las monedas sirven para comprar pokemon con los siguientes costes provisionales:
	-1 moneda, renuncias a 1 pokemon y obtienes 1 aleatorio.
	-2 monedas, renuncias a 1 pokemon y elijes un pokemon que no esté pillado por otro jugador de tier baja (está por analizar cómo se clasificarán las tier).
	- 3 monedas, renuncias a 2 pokemon y elijes un pokemon que no esté pillado por otro jugador de tier alto.

3. Combates entre dos entrenadores, se utilizará un sistema de puntos basado en las muertes de cada combate.
	El combate funcionará de la siguiente manera, cada pokemon tiene un nivel aleatorio y desconocido para el entrenador que varía del 0 al 5, cuando dos pokemon luchan, el que tenga el nivel más alto gana el combate. Los combates son 1 vs 1 y los combatientes se elijen de forma aleatoria, siendo un total de 6 batallas por combate (si un pokemon gana no puede seguir participando en la siguiente batalla). Cada entrenador gana 1 punto por batalla ganada y 0,5 por empate. 
	
	BONIFICADORES:
Si el pokemon tiene un tipo fuerte contra el rival, sube un nivel durante esa batalla (en caso de tener dos tipos, el tipo se elije de forma aleatoria).
Bonificador de suerte, existe un bonificador +1 de suerte inversamente proporcional al nivel del pokemon siguiendo la siguiente tabla:

lvl 5: 10%
lvl 4: 20%
lvl 3: 30%
lvl 2: 40%
lvl 1: 50%
lvl 0: 55%
