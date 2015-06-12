package main.java;

public interface Convertable<T, V> {

	/**
	 * Converts input of type T to an output of type V
	 * 
	 * @param input
	 * @return
	 * @throws ConverterException
	 */
	public V convert(T input) throws ConverterException;
}