package ru.javarush.uzdenov.cryptoanalyzer.commands;

import ru.javarush.uzdenov.cryptoanalyzer.entity.Result;
import ru.javarush.uzdenov.cryptoanalyzer.entity.ResultCode;

public class Encoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        //TODO something do
        return new Result("encode all right", ResultCode.OK);
    }
}
