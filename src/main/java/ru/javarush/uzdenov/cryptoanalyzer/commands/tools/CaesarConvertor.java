package ru.javarush.uzdenov.cryptoanalyzer.commands.tools;

import ru.javarush.uzdenov.cryptoanalyzer.entity.Result;
import ru.javarush.uzdenov.cryptoanalyzer.entity.ResultCode;

import java.io.*;

import static ru.javarush.uzdenov.cryptoanalyzer.constants.Constants.ALPHABET;


public class CaesarConvertor {

    public static String makeAlphabet(int key){
        String toAalphabet= ALPHABET.substring(key) + ALPHABET.substring(0, key);
        System.out.println("Encode:makeAlphabet");
        System.out.println(ALPHABET);
        System.out.println(toAalphabet);
        return toAalphabet;
    }

    public static Result Execute(String fileFrom,String fileTo, String alphabetFrom,String alphabetTo){
        try(
                BufferedReader br = new BufferedReader(new FileReader(fileFrom));
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileTo))
        ){
            char inpChar;
            int inpInt;
            int  intCharIndex;
            while ((inpInt = br.read()) > -1){
                inpChar = Character.toLowerCase((char) inpInt);
                // если находим считанный символ в алфавите то его транслируем
                // если его в алфавите нет - то передаем в выходной файл
                if ((intCharIndex = alphabetFrom.indexOf(inpChar)) >= 0){
                    inpChar = alphabetTo.charAt(intCharIndex);
                }
                bw.write(inpChar);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Result("convert: Ok", ResultCode.OK);
    }

}
