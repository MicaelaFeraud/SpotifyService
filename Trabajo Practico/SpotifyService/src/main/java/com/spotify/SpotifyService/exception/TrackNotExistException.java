package com.spotify.SpotifyService.exception;

public class TrackNotExistException extends RuntimeException{

    public TrackNotExistException(String messege){
        super(messege);
    }
}
