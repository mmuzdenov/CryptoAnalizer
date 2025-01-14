package ru.javarush.uzdenov.cryptoanalyzer.commands.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class CharTableTools {

    public static CharTable getMaxFrequencyChar(String fileName) {
        // TreeMap 408
        // HashMap 385
        Map<Character, Double> charMap = new HashMap<>();
        long totalChars = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int inpChar;

            Double info;

            while ((inpChar = br.read()) > -1) {
                totalChars++;
                if ((info = charMap.get((char) inpChar)) != null) {
                    charMap.put((char) inpChar, info + 1D);
                } else {
                    charMap.put((char) inpChar, 1D);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        CharTable maxFrequencyChar=new CharTable();
        maxFrequencyChar.freq=0;
        for (Map.Entry<Character, Double> entry : charMap.entrySet()) {
            if(maxFrequencyChar.freq<entry.getValue()){
                maxFrequencyChar.freq = entry.getValue();
                maxFrequencyChar.ch   = entry.getKey();
            }
        }
        maxFrequencyChar.freq/=totalChars;

        return maxFrequencyChar;
    }

}
