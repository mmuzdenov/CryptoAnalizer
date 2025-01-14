package ru.javarush.uzdenov.cryptoanalyzer.controllers;

import ru.javarush.uzdenov.cryptoanalyzer.commands.Action;
import ru.javarush.uzdenov.cryptoanalyzer.commands.BruteForce;
import ru.javarush.uzdenov.cryptoanalyzer.commands.Decoder;
import ru.javarush.uzdenov.cryptoanalyzer.commands.Encoder;
import ru.javarush.uzdenov.cryptoanalyzer.excetions.AppExeption;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTEFORCE(new BruteForce());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String actionName){
        try {
            Actions value = Actions.valueOf(actionName.toUpperCase());
            return value.action;
        } catch (IllegalArgumentException e){
            throw new AppExeption("not found " + actionName, e);
        }
    }
}
