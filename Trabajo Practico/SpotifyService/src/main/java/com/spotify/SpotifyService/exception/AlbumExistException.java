package com.spotify.SpotifyService.exception;

public class AlbumExistException extends RuntimeException{

    public AlbumExistException(String messege){
        super(messege);
    }
}
