package main.java;

/*
 * Take a number and give the equivalent number in British English words e.g.
 * 1 = one
 * 21 = twenty one
 * 105 = one hundred and five
 * 56945781 = fifty six million nine hundred and forty five thousand seven hundred and eighty one
 * etc.. up to 999,999,999 without any external libraries (except testing libraries)
 */
public class IntegerConverter implements Convertable<Integer, String> {

	private final String[] digits = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	private final String[] teens = { "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	private final String[] tens = { "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
	private final String[] bigs = { "", "thousand", "million" };

	/**
	 * Convert numbers in the range -999,999,999 to 999,999,999 to their English
	 * word equivalents. If a null or a number outside this range is passed in
	 * then this method throws a ConverterException.
	 */
	public String convert(final Integer input) throws ConverterException {
		if (input == null) {
			throw new ConverterException("Input is null cannot continue");
		} else if (input == 0) {
			return "zero";
		} else if (input < 0) {
			return "negative " + convert(input * -1);
		} else if (input > 999999999) {
			throw new ConverterException("Number is more than 999,999,999 and cannot be converted");
		}

		// copy the input as we will be modifying it
		int number = input;
		int count = 0;
		String str = "";
		while (number > 0) {
			if (number % 1000 != 0) {
				str = numToString(number % 1000) + bigs[count] + " " + str;
			}
			number /= 1000;
			count++;
		}

		return str.trim();
	}

	private String numToString(int number) {
		String str = "";

		// Convert the hundreds place
		if (number >= 100) {
			str += digits[number / 100 - 1] + " hundred ";
			number %= 100;
		}

		if (!str.isEmpty()) {
			str += "and ";
		}

		// Convert the tens place
		if (number >= 11 && number <= 19) {
			return str + teens[number - 11] + " ";
		} else if (number == 10 || number >= 20) {
			str += tens[number / 10 - 1] + " ";
			number %= 10;
		}

		// Convert the ones place
		if (number >= 1 && number <= 9) {
			str += digits[number - 1] + " ";
		}
		return str;
	}
}
