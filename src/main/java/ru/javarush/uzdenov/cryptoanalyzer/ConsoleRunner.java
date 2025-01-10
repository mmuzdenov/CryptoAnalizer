package ru.javarush.uzdenov.cryptoanalyzer;

import ru.javarush.uzdenov.cryptoanalyzer.entity.Result;

public class ConsoleRunner {
    public static void main(String[] args) {
        // encode  text.txt encode.txt 12
        Application application = new Application(args);
        Result result = application.run();
        System.out.println(result);
    }
}
