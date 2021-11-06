package com.spotify.SpotifyService.exception;

public class ArtistNotExistException extends RuntimeException{

    public ArtistNotExistException(String messege){
        super(messege);
    }
}
