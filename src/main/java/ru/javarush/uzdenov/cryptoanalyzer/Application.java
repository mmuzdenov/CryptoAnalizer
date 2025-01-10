package ru.javarush.uzdenov.cryptoanalyzer;

import ru.javarush.uzdenov.cryptoanalyzer.controllers.MainController;
import ru.javarush.uzdenov.cryptoanalyzer.entity.Result;
import ru.javarush.uzdenov.cryptoanalyzer.excetions.AppExeption;

import java.util.Arrays;

public class Application {

    private final MainController mainController;
    private final String[] args;

    public Application(String[] args) {
        this.args = args;
        mainController = new MainController();
    }

    public Result run() {
        if (args.length>0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            mainController.doAction(action,parameters);
        }
        throw new AppExeption();
    }
}
