package com.spotify.SpotifyService.exception;

public class AlbumNotExistException extends RuntimeException{

    public AlbumNotExistException(String messege){
        super(messege);
    }
}
