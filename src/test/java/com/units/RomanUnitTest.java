package com.units;

import org.junit.Test;

/**
 * Created by marcos on 06/05/15.
 */
public class RomanUnitTest {

    @Test
    public void testRomanNumerals() throws Exception {
        String a = "glob is I";
        String b = "prok is V";
        String c = "pish is X";
        String d = "tegj is L";
        String e = "glob glob Silver is 34 Credits";
        String f = "glob prok Gold is 57800 Credits";
        String g = "pish pish Iron is 3910 Credits";
        String h = "how much is pish tegj glob glob ?";
        String i = "how many Credits is glob prok Silver ?";
        String j = "how many Credits is glob prok Gold ?";
        String k = "how many Credits is glob prok Iron ?";
        String l= "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
        Parser p = new Parser();
        p.parse();
    }

    @Test
    public void testRoman() throws Exception {
    }
}