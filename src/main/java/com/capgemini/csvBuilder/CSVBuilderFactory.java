package com.capgemini.csvBuilder;

public class CSVBuilderFactory<E> {
	public static ICSVBuilder createCSVBuilder() {
		return new OpenCSVBuilder();
	}
}
