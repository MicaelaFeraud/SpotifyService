package com.spotify.SpotifyService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpotifyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotifyServiceApplication.class, args);
		/*Incrementar en uno la reproduccion
		* funcion reproducir{
		* Track.reproduccion ++}
		*
		* Deberia hacer una matriz con toda la informacion?
		*
		*
		* / - Cancion - Artista - Album - Reproducciones
		* 1 - Cancion1 - Artista1 - Album1 - 100.000
		* 2 - Cancion2 - Artista1 - Album2 - 200.000
		* 3 - Cancion3 - Artista2 - Album3 - 150.000
		* 4 - Cancion4 - Artista3 - Album3 - 100.000
		*
		*
		/* Devolver las 5 canciones mas escuchadas del artista
		* si artista[1] == artista [2] agregar track[2] a una lista.
		* comparar Track.reproduccion de la lista.
		* meter los 5 mas grandes en un array llamado rankSongs y mostrarlo
		*
		*
		/* Devolver los 5 artistas mas escuchados
		*
		* si artista[1] == artista[2]
		*
		* comparar las reproducciones
		* meter los 5 mas grandes en un array llamado rankArtista
		*
		*
		/* Devolver las 5 canciones mas escuchadas de todos los artistas
		*  */

	}


}
