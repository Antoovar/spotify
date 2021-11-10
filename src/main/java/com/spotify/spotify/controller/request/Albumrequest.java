package com.spotify.spotify.controller.request;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data

public class Albumrequest {
     @NotNull
    private Long idAlbum;
    private Long idArtist;
    private String name;

}
