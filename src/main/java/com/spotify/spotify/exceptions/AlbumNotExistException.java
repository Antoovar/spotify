package com.spotify.spotify.exceptions;

public class AlbumNotExistException extends RuntimeException{

    public AlbumNotExistException(String mensaje){
        super(mensaje);
    }

}
