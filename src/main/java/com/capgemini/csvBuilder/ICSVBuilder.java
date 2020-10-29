package com.capgemini.csvBuilder;

import java.io.Reader;
import java.util.List;

import com.opencsv.exceptions.CsvException;

public interface ICSVBuilder<E> {
	public <E> List<E> getCsvFileList(Reader reader, Class csvClass) throws CsvException;
}
