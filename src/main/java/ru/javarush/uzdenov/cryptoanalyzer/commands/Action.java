package ru.javarush.uzdenov.cryptoanalyzer.commands;

import ru.javarush.uzdenov.cryptoanalyzer.entity.Result;

public interface Action {
    Result execute (String[] parameters);
}
