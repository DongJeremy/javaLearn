package org.cloud.funcDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class AppTest extends TestCase {

    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testApp() {
        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
        assertEquals(Arrays.asList("a", "b", "c"), collected);
    }

    public void testFunc1() {
        List<String> collected = new ArrayList<>();
        for (String string : Arrays.asList("a", "b", "hello")) {
            String uppercaseString = string.toUpperCase();
            collected.add(uppercaseString);
        }
        assertEquals(Arrays.asList("A", "B", "HELLO"), collected);
    }

    public void testFunc2() {
        List<String> collected = Stream.of("a", "b", "hello").map(string -> string.toUpperCase())
                .collect(Collectors.toList());
        assertEquals(Arrays.asList("A", "B", "HELLO"), collected);
    }

    public void testFunc3() {
        List<String> beginningWithNumbers = new ArrayList<>();
        for (String value : Arrays.asList("a", "1abc", "abc1")) {
            if (Character.isDigit(value.charAt(0))) {
                beginningWithNumbers.add(value);
            }
        }
        assertEquals(Arrays.asList("1abc"), beginningWithNumbers);
    }

    public void testFunc4() {
        List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
                .filter(value -> Character.isDigit(value.charAt(0))).collect(Collectors.toList());
        assertEquals(Arrays.asList("1abc"), beginningWithNumbers);
    }

    public void testFunc5() {
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream()).collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 2, 3, 4), together);
    }

    public void testFunc6() {
        List<Track> tracks = Arrays.asList(new Track("Bakai", 524), new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));
        Track shortestTrack = tracks.stream().min(Comparator.comparing(track -> track.getLength())).get();
        assertEquals(tracks.get(1), shortestTrack);
    }

    public void testFunc7() {
        List<Track> tracks = Arrays.asList(new Track("Bakai", 524), new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));
        Track shortestTrack = tracks.get(0);
        for (Track track : tracks) {
            if (track.getLength() < shortestTrack.getLength()) {
                shortestTrack = track;
            }
        }
        assertEquals(tracks.get(1), shortestTrack);
    }

    public void testFunc8() {
        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        assertEquals(6, count);
    }

    public void testFunc9() {
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        int count = accumulator.apply(accumulator.apply(accumulator.apply(0, 1), 2), 3);
        assertEquals(6, count);
    }

    public void testFunc10() {
    }

    public void testFunc11() {
    }

    public void testFunc12() {
    }

    public void testFunc13() {
    }

    public void testFunc14() {
    }

}
