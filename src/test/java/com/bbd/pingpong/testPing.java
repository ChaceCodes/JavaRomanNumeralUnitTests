package com.bbd.pingpong;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPing {
    @Test
    public void testNumber1() {
        assertEquals(1,RomanConverter.Convert("I"));
    }
    @Test
    public void testNumber2() {
        assertEquals(2,RomanConverter.Convert("II"));
    }
    @Test
    public void testNumber5() {
        assertEquals(5,RomanConverter.Convert("V"));
    }
    @Test
    public void testNumber4() {
        assertEquals(4,RomanConverter.Convert("IV"));
    }
    @Test
    public void testNumber6() {
        assertEquals(6,RomanConverter.Convert("VI"));
    }
    @Test
    public void testNumber9() {
        assertEquals(9,RomanConverter.Convert("IX"));
    }
    @Test
    public void testNumber14() {
        assertEquals(14,RomanConverter.Convert("XIV"));
    }
    @Test
    public void testNumber29() {
        assertEquals(29,RomanConverter.Convert("XXIX"));
    }
    @Test
    public void testNumber49() {
        assertEquals(49,RomanConverter.Convert("XLIX"));
    }
    @Test
    public void testNumber90() {
        assertEquals(90,RomanConverter.Convert("XC"));
    }
    @Test
    public void testNumber100() {
        assertEquals(100,RomanConverter.Convert("C"));
    }
    @Test
    public void testNumber129() {
        assertEquals(129,RomanConverter.Convert("CXXIX"));
    }
    @Test
    public void testNumber400() {
        assertEquals(400,RomanConverter.Convert("CD"));
    }
    @Test
    public void testNumber500() {
        assertEquals(500,RomanConverter.Convert("D"));
    }
    @Test
    public void testNumber999() {
        assertEquals(999,RomanConverter.Convert("CMXCIX"));
    }
    @Test
    public void testNumber1999() {
        assertEquals(1999,RomanConverter.Convert("MCMXCIX"));
    }
    @Test
    void testInvalidChar()
    {
        assertThrows(RuntimeException.class, () -> RomanConverter.Convert("abc"));
    }
    @Test
    void testInvalidRomanNumeral()
    {
        assertThrows(RuntimeException.class, () -> RomanConverter.Convert("IVXM"));
    }
    @Test
    void testInvalidRomanNumeral2()
    {
        assertThrows(RuntimeException.class, () -> RomanConverter.Convert("XIIII"));
    }@Test
    void testInvalidRomanNumeral3()
    {
        assertThrows(RuntimeException.class, () -> RomanConverter.Convert("XVV"));
    }
}