package ru.javarush.uzdenov.cryptoanalyzer.commands;

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
        try(
                BufferedReader br = new BufferedReader(new FileReader(TXT_FOLDER+parameters[0]));
                BufferedWriter bw = new BufferedWriter(new FileWriter(TXT_FOLDER+parameters[1]))
        ){
            char inpChar;
            int inpInt;
            int  intCharIndex;
            while ((inpInt = br.read()) > -1){
                inpChar = Character.toLowerCase((char) inpInt);
                // если находим считанный символ в алфавите то его транслируем
                // если его в алфавите нет - то передаем в выходной файл
                if ((intCharIndex = ALPHABET.indexOf(inpChar)) >= 0){
                   inpChar = alphabetTo.charAt(intCharIndex);
                }
                bw.write(inpChar);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Result("encode all right", ResultCode.OK);
    }
}
