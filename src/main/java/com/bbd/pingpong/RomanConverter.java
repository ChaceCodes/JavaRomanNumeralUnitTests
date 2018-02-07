package com.bbd.pingpong;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanConverter {
    private static Pattern reFour = Pattern.compile("IV");
    private static Pattern reFive = Pattern.compile("V");
    private static Pattern reNine = Pattern.compile("IX");
    private static Pattern reFourty = Pattern.compile("XL");
    private static Pattern reFifty = Pattern.compile("L");
    private static Pattern reNinety = Pattern.compile("XC");
    private static Pattern reFourHundred = Pattern.compile("CD");
    private static Pattern reFiveHundred = Pattern.compile("D");
    private static Pattern reNineHundred = Pattern.compile("CM");
    private static Pattern reTooManyRepeats = Pattern.compile("([M]{4,})|([D]{2,})|([C]{4,})|([L]{2,})|([X]{4,})|([V]{2,})|([I]{4,})");
    private static Pattern reValidOrder = Pattern.compile("^M*C*X*I*$");

    private static String SimplifyRomanNumeral(String s)
    {
        String simple;

        simple = reFour.matcher(s).replaceAll("IIII");
        simple = reFive.matcher(simple).replaceAll("IIIII");
        simple = reNine.matcher(simple).replaceAll("IIIIIIIII");
        simple = reFourty.matcher(simple).replaceAll("XXXX");
        simple = reFifty.matcher(simple).replaceAll("XXXXX");
        simple = reNinety.matcher(simple).replaceAll("XXXXXXXXX");
        simple = reFourHundred.matcher(simple).replaceAll("CCCC");
        simple = reFiveHundred.matcher(simple).replaceAll("CCCCC");
        simple = reNineHundred.matcher(simple).replaceAll("CCCCCCCCC");

        return (simple);
    }

    public static int Convert(String s)
    {
        int num = 0;


        if (reTooManyRepeats.matcher(s).find() == true)
            throw new RuntimeException("Numeral contains too many repeats");
        s = SimplifyRomanNumeral(s);
        if (reValidOrder.matcher(s).find() == false)
            throw new RuntimeException("Invalid numeral");
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == 'I')
                num += 1;
            else if (s.charAt(i) == 'X')
                num += 10;
            else if (s.charAt(i) == 'C')
                num += 100;
            else if (s.charAt(i) == 'M')
                num += 1000;
        }
        return (num);
    }
}