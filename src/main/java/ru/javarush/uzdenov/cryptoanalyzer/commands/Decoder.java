package ru.javarush.uzdenov.cryptoanalyzer.commands;

import ru.javarush.uzdenov.cryptoanalyzer.commands.tools.CaesarConvertor;
import ru.javarush.uzdenov.cryptoanalyzer.entity.Result;
import ru.javarush.uzdenov.cryptoanalyzer.entity.ResultCode;

import static ru.javarush.uzdenov.cryptoanalyzer.constants.Constants.ALPHABET;
import static ru.javarush.uzdenov.cryptoanalyzer.constants.Constants.TXT_FOLDER;

public class Decoder implements Action{
    String alphabetFrom;
    private void makeAlphabet(int key){
        alphabetFrom= ALPHABET.substring(key) + ALPHABET.substring(0, key);
        System.out.println("Decode:makeAlphabet");
        System.out.println(ALPHABET);
        System.out.println(alphabetFrom);
    }

    @Override
    public Result execute(String[] parameters) {
        Result ret;
        makeAlphabet(Integer.parseInt(parameters[2]));
        ret = CaesarConvertor.Execute(TXT_FOLDER+parameters[0],
                                TXT_FOLDER+parameters[1],
                                 alphabetFrom,
                                 ALPHABET);
        return new Result("decode all right", ret.getResultCode());
    }
}
