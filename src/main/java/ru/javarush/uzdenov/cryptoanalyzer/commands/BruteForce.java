package ru.javarush.uzdenov.cryptoanalyzer.commands;

import ru.javarush.uzdenov.cryptoanalyzer.commands.tools.CharTable;
import ru.javarush.uzdenov.cryptoanalyzer.commands.tools.CharTableTools;
import ru.javarush.uzdenov.cryptoanalyzer.entity.Result;
import ru.javarush.uzdenov.cryptoanalyzer.entity.ResultCode;

import static ru.javarush.uzdenov.cryptoanalyzer.constants.Constants.ALPHABET;
import static ru.javarush.uzdenov.cryptoanalyzer.constants.Constants.TXT_FOLDER;


public class BruteForce implements Action{

    @Override
    public Result execute(String[] parameters) {
        long startProcess = System.currentTimeMillis();
        //TODO BrudeForce
        //нужны 2-е таблицы с частотой возникновения символов по 10 символов.
        CharTable charTablesDict = CharTableTools.getMaxFrequencyChar(TXT_FOLDER+"dict.txt");
        CharTable charTablesCodedFile = CharTableTools.getMaxFrequencyChar(TXT_FOLDER+parameters[0]);
        System.out.println("Working time:"+(System.currentTimeMillis()-startProcess));

        System.out.println(charTablesCodedFile);
        System.out.println(ALPHABET.indexOf(charTablesCodedFile.ch));
        System.out.println(charTablesDict);
        System.out.println(ALPHABET.indexOf(charTablesDict.ch));
        System.out.println(ALPHABET);
        int key = ALPHABET.indexOf(charTablesCodedFile.ch)-
                  ALPHABET.indexOf(charTablesDict.ch);
        if (key < 0){
            int dictCharPos = ALPHABET.indexOf(charTablesDict.ch);
            String newAlphabet = ALPHABET.substring(dictCharPos)+ALPHABET.substring(0,dictCharPos);
            key = newAlphabet.indexOf(charTablesCodedFile.ch)-
                  newAlphabet.indexOf(charTablesDict.ch);
        }
        System.out.println("Key="+Math.abs(key));

        return new Result("BruteForce complete", ResultCode.OK);
    }
}
