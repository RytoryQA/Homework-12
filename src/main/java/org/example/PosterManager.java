package org.example;

public class PosterManager {
    private PosterItem[] films = new PosterItem[0];
    private int limitFilm;

    public PosterManager() {
        limitFilm = 5;
    }

    public PosterManager(int limit) {
        limitFilm = limit;
    }

    public void addNewFilm(PosterItem film) {
        PosterItem[] tmp = new PosterItem[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    public PosterItem[] findAll() {
        return films;
    }

    public PosterItem[] findLast() {
        int resultLength;
        if (films.length < limitFilm) {
            resultLength = films.length;
        } else {
            resultLength = limitFilm;
        }
        PosterItem[] reversed = new PosterItem[resultLength];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = films[films.length - 1 - i];
        }
        return reversed;
    }


}

