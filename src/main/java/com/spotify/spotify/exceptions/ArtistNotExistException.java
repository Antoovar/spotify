package com.spotify.spotify.exceptions;

public class ArtistNotExistException extends RuntimeException{

    public ArtistNotExistException(String mensaje){
        super(mensaje);
    }
}
