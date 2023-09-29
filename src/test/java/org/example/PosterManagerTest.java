package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    PosterManager manager = new PosterManager();
    PosterManager managerLimit = new PosterManager(3);

    PosterItem film1 = new PosterItem("Бладшот", "боевик", "image1");
    PosterItem film2 = new PosterItem("Вперед", "мультфильм", "image2");
    PosterItem film3 = new PosterItem("Отель 'Белград'", "комедия", "image3");
    PosterItem film4 = new PosterItem("Джентельмены", "боевик", "image4");

    PosterItem film5 = new PosterItem("Человек-невидимка", "ужасы", "image5");
    PosterItem film6 = new PosterItem("Тролли. Мировой тур", "мультфильм", "image6");
    PosterItem film7 = new PosterItem("Номер один", "комедия", "image7");

    @Test
    public void addOneFilm() {
        manager.addNewFilm(film1);

        PosterItem[] expected = {film1};
        PosterItem[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addZeroFilm() {

        PosterItem[] expected = {};
        PosterItem[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addFiveFilm() {

        manager.addNewFilm(film1);
        manager.addNewFilm(film2);
        manager.addNewFilm(film3);
        manager.addNewFilm(film4);
        manager.addNewFilm(film5);

        PosterItem[] expected = {film1, film2, film3, film4, film5};
        PosterItem[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findLastFilmsReverseOrderDefaultLimitAddZero() {

        PosterItem[] expected = {};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findLastFilmsReverseOrderDefaultLimitAddOne() {

        manager.addNewFilm(film1);

        PosterItem[] expected = {film1};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsReverseOrderDefaultLimitAddThree() {
        manager.addNewFilm(film1);
        manager.addNewFilm(film2);
        manager.addNewFilm(film3);

        PosterItem[] expected = {film3, film2, film1};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsReverseOrderDefaultLimitAddAboveLimit() {

        manager.addNewFilm(film1);
        manager.addNewFilm(film2);
        manager.addNewFilm(film3);
        manager.addNewFilm(film4);
        manager.addNewFilm(film5);
        manager.addNewFilm(film6);

        PosterItem[] expected = {film6, film5, film4, film3, film2};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsReverseOrderLimitAddZero() {
        PosterItem[] expected = {};
        PosterItem[] actual = managerLimit.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsReverseOrderLimitAddOne() {

        managerLimit.addNewFilm(film1);

        PosterItem[] expected = {film1};
        PosterItem[] actual = managerLimit.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsReverseOrderLimitAddEqualLimit() {
        managerLimit.addNewFilm(film1);
        managerLimit.addNewFilm(film2);
        managerLimit.addNewFilm(film3);

        PosterItem[] expected = {film3, film2, film1};
        PosterItem[] actual = managerLimit.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsReverseOrderLimitAddAboveLimit() {

        managerLimit.addNewFilm(film1);
        managerLimit.addNewFilm(film2);
        managerLimit.addNewFilm(film3);
        managerLimit.addNewFilm(film4);
        managerLimit.addNewFilm(film5);
        managerLimit.addNewFilm(film6);
        managerLimit.addNewFilm(film7);

        PosterItem[] expected = {film7, film6, film5};
        PosterItem[] actual = managerLimit.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
