package com.java8.labbdas.exercises;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;


public class Chapter3 {

    /**
     * 3.1.a
     */
    public static int add(Stream<Integer> numbers){
//        int acc ;
        return numbers.reduce(0, (acc, x) -> acc + x);
    }

    /**
     * 3.1.b
     */
    public static List<String> getNameandOrigion(List<Artist> artists){
        return artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(Collectors.toList()) ;
    }

    /**
     * 3.1.c
     */
    public static List<Album> getTracks(List<Album> albums){
        return albums.stream()
                .filter(album -> album.getTrackList().size() <= 3)
                .collect(Collectors.toList()) ;
    }


    /**
     * 找出某张专辑上的所有乐队的国籍
     *
     * 1.找出专辑上的所有表演者
     * 2.分辨出哪些是乐队
     * 3.找出每个乐队的国籍
     * 4.将找出的国籍放入一个集合
     */

    public static List<String> getOrigins(Album album){
        return album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(Artist::getNationality)
                .collect(Collectors.toList()) ;

    }

    /**
     * 找出长度大于1分钟的曲目 V1.0
     *
     */
    public Set<String> findLongTracks(List<Album> albums){

        Set<String> trackNames = new HashSet<>() ;
        for (Album album: albums){
            for (Track track:album.getTrackList()){
                if (track.getLength()>60){
                    String name = track.getName() ;
                    trackNames.add(name) ;
                }
            }
        }
        return trackNames ;
    }

    /**
     * V2.0
     *
     */

    public Set<String> findLongTracks_2(List<Album> albums){

        //filter(track -> track.getLength() >60)
         //       .map(name -> track.getName()).collect(toList())
        return albums.stream()
                .flatMap(Album::getTracks)
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .collect(toSet()) ;
    }


    /**
     * 3.6
     *
     */
    public static int countLow(String string){
        return (int)string.chars().
                filter(Character::isLowerCase)
                .count();
    }

    /**
     * 3.7
     *
     */

    public static Optional<String> mostLowerString(List<String> strings){

        return strings.stream()
                .max(Comparator.comparing(Chapter3::countLow));
    }
    

        public static void main(String[] args) {


            Instant start = Instant.now();
            //usage of filter
        long count = SampleData.membersOfTheBeatles
                .stream().filter(artist -> {
                    System.out.println(artist);
                    return artist.getNationality().equals("UK");
                }).count();
            System.out.println(count);

            Instant end = Instant.now() ;
            Duration dur = Duration.between(start,end) ;
            System.out.println("Time: "+dur.toMillis());

        List<Track> tracks = asList(new Track("Bakai", 524),
                new Track("Violets for Your Fur", 378));

        //usage of min
        Track shortestTrack = tracks.stream()
                                    .min(Comparator.comparing(track -> track.getLength()))
                                    .get();
        List<Album> print = getTracks(SampleData.albums.collect(Collectors.toList())) ;
        System.out.println(print);

            /**
             * 3.2
             */

                  SampleData.threeArtists()
                    .map(artist -> artist.getMembers().count())
                    .reduce(0L,(acc,element)->acc+element)
                    .intValue() ;

    }
}
