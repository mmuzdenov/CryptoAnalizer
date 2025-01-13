package ru.javarush.uzdenov.cryptoanalyzer.commands;

import ru.javarush.uzdenov.cryptoanalyzer.commands.tools.CaesarConvertor;
import ru.javarush.uzdenov.cryptoanalyzer.entity.Result;

import static ru.javarush.uzdenov.cryptoanalyzer.constants.Constants.ALPHABET;
import static ru.javarush.uzdenov.cryptoanalyzer.constants.Constants.TXT_FOLDER;

public class Encoder implements Action{

    @Override
    public Result execute(String[] parameters) {
        Result ret;
        ret = CaesarConvertor.Execute(TXT_FOLDER+parameters[0],
                TXT_FOLDER+parameters[1],
                ALPHABET,
                CaesarConvertor.makeAlphabet(Integer.parseInt(parameters[2])));
        return new Result("encode all right", ret.getResultCode());

    }
}
