package com.spotify.SpotifyService.exception;

public class ArtistExistException extends RuntimeException{

    public ArtistExistException(String messege){
        super(messege);
    }
}
