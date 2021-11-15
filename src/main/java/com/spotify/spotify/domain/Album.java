package com.spotify.spotify.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAlbum;
    private Long idArtist;
    private String name;
}
