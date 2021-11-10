package com.spotify.spotify.exceptions;

public class AlbumExistsException extends  RuntimeException{

    public AlbumExistsException(String mensaje){
        super (mensaje);
    }

}
