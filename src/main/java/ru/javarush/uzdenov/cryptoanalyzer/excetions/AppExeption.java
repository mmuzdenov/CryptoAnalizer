package ru.javarush.uzdenov.cryptoanalyzer.excetions;

public class AppExeption extends RuntimeException {

    public AppExeption(String message) {
        super(message);
    }

    public AppExeption(String message, Throwable cause) {
        super(message, cause);
    }


}
