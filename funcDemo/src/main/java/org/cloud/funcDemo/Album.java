package org.cloud.funcDemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Album {
    private List<Track> trackList;

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }
    
    public Album() {
        // TODO Auto-generated constructor stub
    }
    
    public Album(List<Track> trackList) {
        this.trackList = trackList;
    }
    
    public static void main(String[] args) {
        System.out.println(findLongTracks(allArtists));
        System.out.println(findLongTracks2(allArtists));
    }
    
    private static final List<Album> allArtists = Stream
            .of(new Album(Arrays.asList(
                    new Track("Bakai", 10), 
                    new Track("Violets for Your Furs", 378),
                    new Track("Time Was", 451))),
                new Album(Arrays.asList(
                    new Track("Cakai", 30),
                    new Track("Furs", 378), 
                    new Track("Was", 40))),
                new Album(Arrays.asList(
                    new Track("Aakai", 52),
                    new Track("Your Furs", 378), 
                    new Track("Time", 50))))
            .collect(Collectors.toList());
    
    public static Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                if (track.getLength() > 60) {
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }
    
    public static Set<String> findLongTracks1(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream().forEach(album -> {
            album.getTrackList().forEach(track -> {
                if (track.getLength() > 60) {
                    String name = track.getName();
                    trackNames.add(name);
                }
            });
        });
        return trackNames;
    }
    
    public static Set<String> findLongTracks2(List<Album> albums) {          
        return albums.stream()
                .flatMap(album -> album.getTrackList().stream())
                .filter(track -> track.getLength() > 60)
                .map(Track::getName)
                .collect(Collectors.toSet());
    }
    
}
