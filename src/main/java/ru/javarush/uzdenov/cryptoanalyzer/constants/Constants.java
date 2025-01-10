package ru.javarush.uzdenov.cryptoanalyzer.constants;

public class Constants {
    private static final String rus = "ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ";
    private static final String eng = "QWERTYUIOPLKJHGFDSAZXCVBNM";
    private static final String num = "0123456789";
    private static final String znp = ",./!@#$%^&*()_+{}[];'<>?:\"";
    public  static final String ALPHABET = rus +
                                           rus.toLowerCase() +
                                           eng +
                                           eng.toLowerCase()+
                                           num +
                                           znp;
}
