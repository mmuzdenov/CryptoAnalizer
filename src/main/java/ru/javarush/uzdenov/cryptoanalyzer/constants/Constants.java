package ru.javarush.uzdenov.cryptoanalyzer.constants;

import java.io.File;

public class Constants {
    private static final String rus = "ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ";
    private static final String eng = "QWERTYUIOPLKJHGFDSAZXCVBNM";
    private static final String num = "0123456789";
    private static final String znp = ",./!@#$%^&*() _-+{}[];'<>?:\"";
    private static final String specChars = "\n\t\r";
    public  static final String ALPHABET = //rus +
                                           rus.toLowerCase() +
                                           //eng +
                                           eng.toLowerCase()+
                                           num +
                                           // specChars +
                                           znp;

    public static final String TXT_FOLDER = System.getProperty("user.dir")+ File.separator +
                                            "text" + File.separator;
}
