package ru.javarush.uzdenov.cryptoanalyzer.commands;

import ru.javarush.uzdenov.cryptoanalyzer.commands.tools.CaesarConvertor;
import ru.javarush.uzdenov.cryptoanalyzer.commands.tools.CharTable;
import ru.javarush.uzdenov.cryptoanalyzer.commands.tools.CharTableTools;
import ru.javarush.uzdenov.cryptoanalyzer.entity.Result;

import static ru.javarush.uzdenov.cryptoanalyzer.constants.Constants.ALPHABET;
import static ru.javarush.uzdenov.cryptoanalyzer.constants.Constants.TXT_FOLDER;


public class BruteForce implements Action{

    @Override
    public Result execute(String[] parameters) {
        long startProcess = System.currentTimeMillis();
        //TODO BrudeForce
        //нужны 2-е таблицы с частотой возникновения символов по 10 символов.
        CharTable charTablesDict = CharTableTools.getMaxFrequencyChar(TXT_FOLDER+"dict.txt");
        CharTable charTablesCodedFile;
        int iKey = 0;
        Result ret;
        do {
            iKey++;
            ret = CaesarConvertor.Execute(TXT_FOLDER + "encoded.txt",
                    TXT_FOLDER + "bruteForced.txt",
                    CaesarConvertor.makeAlphabet(iKey),
                    ALPHABET);
            charTablesCodedFile = CharTableTools.getMaxFrequencyChar(TXT_FOLDER + "bruteForced.txt");
            if (iKey == ALPHABET.length()){
                break;
            }
        } while (charTablesDict.ch != charTablesCodedFile.ch);
        System.out.println("iKey="+iKey);
        System.out.println("Working time:"+(System.currentTimeMillis()-startProcess));
        return new Result("BruteForce complete", ret.getResultCode());
    }
}
