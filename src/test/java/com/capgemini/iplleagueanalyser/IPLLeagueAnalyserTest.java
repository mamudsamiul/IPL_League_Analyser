package com.capgemini.iplleagueanalyser;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.capgemini.iplleagueanalyser.SortByChoice.Choice;

import junit.framework.Assert;

public class IPLLeagueAnalyserTest {

	public String BOWLERS_CSV_FILE = "./FactsheetMostWkts.csv";
	public String BATSMEN_CSV_FILE = "./FactsheetMostRuns.csv";
	public List<IPLLeagueBatsman> batsmen = null;
	public List<IPLLeagueBowler> bowlers = null;
	public IPLLeagueAnalyserExecuter obj;
	public SortByChoice choice;
	public List<IPLLeagueBatsman> batsManList = null;
	public List<IPLLeagueBowler> bowlerList = null;

	public IPLLeagueAnalyserTest() {
		obj = new IPLLeagueAnalyserExecuter();
		choice = new SortByChoice();
	}

	@Test
	public void givenNumberOfEntriesInCSVFile_ShouldReturnExactlytheSameWhileReading()
			throws IPLLeagueAnalyserException {
		try {
			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
			Assert.assertEquals(101, bowlers.size());
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
			Assert.assertEquals(101, batsmen.size());
		} catch (IPLLeagueAnalyserException e) {
		}

	}

	@Test
	public void givenBattingCSVfileReturnTopAverageBatsmen() {
		try {
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		batsManList = choice.sortBychoice(Choice.BAT_AVG, batsmen);
		Assert.assertEquals("83.2", batsManList.get(0).avg);
	}

	@Test
	public void givenBattingCSVfileReturnTopStrikingRateBatsman() {
		try {
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		batsManList = choice.sortBychoice(Choice.STRIKE_RATE, batsmen);
		Assert.assertEquals("333.33", batsManList.get(0).strikeRate);
	}

}