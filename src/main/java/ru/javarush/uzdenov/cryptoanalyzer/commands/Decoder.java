package ru.javarush.uzdenov.cryptoanalyzer.commands;

import ru.javarush.uzdenov.cryptoanalyzer.commands.tools.CaesarConvertor;
import ru.javarush.uzdenov.cryptoanalyzer.entity.Result;

import static ru.javarush.uzdenov.cryptoanalyzer.constants.Constants.ALPHABET;
import static ru.javarush.uzdenov.cryptoanalyzer.constants.Constants.TXT_FOLDER;

public class Decoder implements Action{

    @Override
    public Result execute(String[] parameters) {
        Result ret;
        ret = CaesarConvertor.Execute(TXT_FOLDER+parameters[0],
                                TXT_FOLDER+parameters[1],
                                 CaesarConvertor.makeAlphabet(Integer.parseInt(parameters[2])),
                                 ALPHABET);
        return new Result("decode all right", ret.getResultCode());
    }
}
