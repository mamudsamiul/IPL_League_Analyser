package com.capgemini.iplleagueanalyser;

public class IPLLeagueAnalyserException extends Exception {
	public enum ExceptionType {
		INVALID_FILE_PATH, INVALID_FILE_TYPE, UNABLE_TO_PARSE, NO_DATA, INVALID_CLASS_TYPE, INVALID_PLAYER_TYPE;
	}

	ExceptionType type;

	public IPLLeagueAnalyserException(ExceptionType type, String message) {
		super(message);
		this.type = type;
	}
}
