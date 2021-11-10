package com.spotify.spotify.exceptions;

public class ArtistExistsException extends  RuntimeException {

    public ArtistExistsException(String mensaje){
        super (mensaje);
    }
}
