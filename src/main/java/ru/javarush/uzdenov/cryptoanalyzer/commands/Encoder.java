package ru.javarush.uzdenov.cryptoanalyzer.commands;

import ru.javarush.uzdenov.cryptoanalyzer.commands.tools.CaesarConvertor;
import ru.javarush.uzdenov.cryptoanalyzer.entity.Result;
import ru.javarush.uzdenov.cryptoanalyzer.entity.ResultCode;

import java.io.*;

import static ru.javarush.uzdenov.cryptoanalyzer.constants.Constants.ALPHABET;
import static ru.javarush.uzdenov.cryptoanalyzer.constants.Constants.TXT_FOLDER;

public class Encoder implements Action{
    private String alphabetTo= "";

    private void makeAlphabet(int key){
        alphabetTo= ALPHABET.substring(key) + ALPHABET.substring(0, key);
        System.out.println("Encode:makeAlphabet");
        System.out.println(ALPHABET);
        System.out.println(alphabetTo);
    }

    @Override
    public Result execute(String[] parameters) {
        makeAlphabet(Integer.parseInt(parameters[2]));
        Result ret;
        ret = CaesarConvertor.Execute(TXT_FOLDER+parameters[0],
                TXT_FOLDER+parameters[1],
                ALPHABET,
                alphabetTo);
        return new Result("encode all right", ret.getResultCode());

    }
}
