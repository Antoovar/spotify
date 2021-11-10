package com.spotify.spotify.controller.request;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data

public class Artistrequest {
        @NotNull
        private Long idArtist;
        private String name;
        private String genre;
        private String image;
    }



