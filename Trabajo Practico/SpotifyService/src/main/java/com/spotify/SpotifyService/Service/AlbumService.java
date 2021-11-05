package com.spotify.SpotifyService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    
    //Ojo con esto, estas haciendo una inyeccion a si misma, deberias remover   -->
    //@Autowired
    //private AlbumService albumService; <--
    
    @Autowired
    private AlbumService albumService;

}
