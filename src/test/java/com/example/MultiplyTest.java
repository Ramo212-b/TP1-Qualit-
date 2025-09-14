package com.example;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MultiplyTest {

    @Test
    public void multiplieDeuxPositifs() {
        assertEquals(12, Multiply.multiply(3, 4));
    }

    @Test
    public void multiplieParZero() {
        assertEquals(0, Multiply.multiply(5, 0));
    }

    @Test
    public void multiplieAvecNegatifs() {
        assertEquals(-6, Multiply.multiply(-2, 3));
        assertEquals(6, Multiply.multiply(-2, -3));
    }
}

