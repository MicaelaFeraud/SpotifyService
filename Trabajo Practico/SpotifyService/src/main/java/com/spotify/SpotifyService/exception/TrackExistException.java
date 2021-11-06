package com.spotify.SpotifyService.exception;

public class TrackExistException extends RuntimeException{
    public TrackExistException(String messege){
        super(messege);
    }
}
