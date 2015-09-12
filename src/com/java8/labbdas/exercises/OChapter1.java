/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.java8.labbdas.exercises;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author richard
 */
public class OChapter1 extends MusicChapter {

    public List<String> getNamesOfArtists_Lambda() {
        return artists.stream()
                      .map(artist -> artist.getName())
                      .collect(Collectors.toList());
    }
    
    public List<String> getNamesOfArtists_MethodReference() {
        return artists.stream()
                      .map(Artist::getName)
                      .collect(Collectors.toList());
    }

    public List<Artist> artistsLivingInLondon() {
        return artists.stream()
                      .filter(artist -> "London".equals(artist.getNationality()))
                      .collect(Collectors.toList());
    }

}
