package org.cloud.funcDemo;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    private static final List<Artist> allArtists = Stream
            .of(new Artist(1, "John Lennon", "beijing"),
                    new Artist(2, "Paul McCartney", "shanghai"),
                    new Artist(3, "George Harrison", "jilin"),
                    new Artist(4, "Ringo Starr", "London"))
            .collect(Collectors.toList());

    private static void func1() {
        int count = 0;
        for (Artist artist : allArtists) {
            if (artist.isFrom("London")) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void func2() {
        int count = 0;
        Iterator<Artist> iterator = allArtists.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.isFrom("London")) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void func3() {
        long count = allArtists.stream()
                .filter(artist -> artist.isFrom("London")).count();
        System.out.println(count);
    }

    private static void func4() {
        long count = allArtists.stream().filter(artist -> {
            System.out.println(artist.getName());
            return artist.isFrom("London");
        }).count();
        System.out.println(count);
    }
    
    private static void func5() {
        allArtists.stream().filter(artist -> {
            System.out.println(artist.getName());
            return artist.isFrom("London");
        });
    }

    public static void main(String[] args) {
        func1();
        func2();
        func3();
        func4();
        func5();
    }
}
