package ru.javarush.uzdenov.cryptoanalyzer.controllers;

import ru.javarush.uzdenov.cryptoanalyzer.commands.Action;
import ru.javarush.uzdenov.cryptoanalyzer.entity.Result;

public class MainController{
    public Result doAction(String actionName, String[] parameters){
        Action action = Actions.find(actionName);
        return action.execute(parameters);
    }
}
