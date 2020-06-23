package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class ChallengesMain {
    public static void main (String[] args){
        MovieStore store = new MovieStore();

        String titles = store.getMovies().entrySet().stream()
                .map(movie -> movie.getValue().get(0) + " (ang. " + movie.getValue().get(1) + ")")
                .collect(Collectors.joining(" ! "));

        System.out.println(titles);
    }
}
