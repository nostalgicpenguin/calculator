package com.example.rhb75.calculator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by rhb75 on 14/12/2017.
 */

public class BufferTest {

    @Test
    public void testSetFromString() throws Exception{
        Buffer b = new Buffer();

        b.set(987);
        assertEquals(987.0, b.asNumber());
        assertEquals("987", b.asString());

        b.set("1234567.89");
        assertEquals(1234567.89, b.asNumber());
        assertEquals("1234567.89", b.asString());
    }

    @Test
    public void testSetFromNumber() throws Exception{
        Buffer b = new Buffer();

        b.set(987);
        assertEquals(987.0, b.asNumber());
        assertEquals("987", b.asString());

        b.set(1234567.89);
        assertEquals(1234567.89, b.asNumber());
        assertEquals("1234567.89", b.asString());
    }

    @Test
    public void testPushAndPop() throws Exception {
        Buffer b = new Buffer();

        assertEquals("0", b.asString());
        b.pop();
        assertEquals("", b.asString());
        b.pop();
        assertEquals("", b.asString());
        b.push("1");
        assertEquals("1", b.asString());
        b.push("2");
        assertEquals("12", b.asString());
        b.push("345");
        assertEquals("12345", b.asString());
        b.pop();
        assertEquals("1234", b.asString());
        b.pop();
        assertEquals("123", b.asString());
        b.pop();
        assertEquals("12", b.asString());
        b.pop();
        assertEquals("1", b.asString());
        b.pop();
        assertEquals("", b.asString());
        b.pop();
        assertEquals("", b.asString());
    }

    @Test
    public void testNegate() {
        Buffer b = new Buffer();

        b.negate();
        assertEquals("-", b.asString());

        b.negate();
        assertEquals("", b.asString());

        b.set(123456.78);
        b.negate();
        assertEquals("-123456.78", b.asString());

        b.negate();
        assertEquals("123456.78", b.asString());
    }

    @Test
    public void testNormalise() throws Exception {
        Buffer b = new Buffer();

        b.set("0.");
        assertEquals("0.", b.asString());
        b.normalise();
        assertEquals("0", b.asString());

        b.set("12345.000");
        assertEquals("12345.000", b.asString());
        b.normalise();
        assertEquals("12345", b.asString());
    }
}
