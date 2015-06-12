package test.java;

import static org.junit.Assert.*;
import main.java.Convertable;
import main.java.ConverterException;
import main.java.IntegerConverter;

import org.junit.Test;

public class TestIntegerConverter {

	private Convertable<Integer,String> conv = new IntegerConverter();
	
	@Test
	public void testLongNumberToString() throws ConverterException {
		assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one",conv.convert(56945781));
	}
	
	@Test
	public void testOneToString() throws ConverterException {
		assertEquals("one",conv.convert(1));
	}
	
	@Test
	public void testTwentyOneToString() throws ConverterException {
		assertEquals("twenty one",conv.convert(21));
	}
	
	@Test
	public void testOneHundredAndFiveToString() throws ConverterException {
		assertEquals("one hundred and five",conv.convert(105));
	}
	
	@Test(expected=ConverterException.class)
	public void testNullNumberToString() throws ConverterException {
		conv.convert(null);
	}
	
	@Test(expected=ConverterException.class)
	public void testOverflowNumberToString() throws ConverterException {
		conv.convert(1000000000);
	}

	@Test
	public void testNegativeNumberToString() throws ConverterException {
		assertEquals("negative ten",conv.convert(-10));
	}
	
	@Test
	public void testZeroNumberToString() throws ConverterException {
		assertEquals("zero",conv.convert(0));
	}
}
