package com.spotify.spotify.controller.request;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data

public class Artistrequest {

        private Long idArtist;

        @NotBlank(message = "No puede ser nulo")
        private String name;
        private String genre;
        private String image;
    }



