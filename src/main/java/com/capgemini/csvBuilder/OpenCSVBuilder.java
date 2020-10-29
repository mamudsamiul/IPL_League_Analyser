package com.capgemini.csvBuilder;

import java.io.Reader;
import java.util.List;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvException;

public class OpenCSVBuilder<E> implements ICSVBuilder {

	public List getCsvFileList(Reader reader, Class csvClass) throws CsvException {
		return this.getCSVBean(reader, csvClass).parse();
	}

	private CsvToBean<E> getCSVBean(Reader reader, Class csvClass) throws CsvException {
		try {
			CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<E>(reader);
			csvToBeanBuilder.withType(csvClass);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true).withThrowExceptions(false).withSeparator(',');
			return csvToBeanBuilder.build();
		} catch (IllegalStateException e) {
			throw new CsvException();
		}
	}
}
