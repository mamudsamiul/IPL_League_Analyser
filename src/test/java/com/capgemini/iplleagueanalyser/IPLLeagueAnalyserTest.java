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

	@Test
	public void givenBattingCSVfile_ShouldReturnPlayerWithMaximumFours() {
		try {
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		batsManList = choice.sortBychoice(Choice.MAX_FOURS, batsmen);
		Assert.assertEquals("Shikhar Dhawan", batsManList.get(0).player);
	}

	@Test
	public void givenBattingCSVfile_ShouldReturnPlayerWithMaximumSixes() {
		try {
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		batsManList = choice.sortBychoice(Choice.MAX_SIXES, batsmen);
		Assert.assertEquals("Andre Russell", batsManList.get(0).player);
	}

	@Test
	public void givenBattingCSVfile_ShouldReturnPlayerWithMaximumBoundariesAndBestSR() {
		try {
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		batsManList = choice.sortBychoice(Choice.MAX_BOUNDARIES_AND_SR, batsmen);
		Assert.assertEquals("Ishant Sharma", batsManList.get(0).player);
	}

	@Test
	public void givenBattingCSVfile_ShouldReturnPlayerWithMaximumAverageAndSR() {
		try {
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		batsManList = choice.sortBychoice(Choice.MAX_AVG_AND_SR, batsmen);
		Assert.assertEquals("MS Dhoni", batsManList.get(0).player);
	}

	@Test
	public void givenBattingCSVfile_ShouldReturnPlayerWithMaximumrunsAndBestAverage() {
		try {
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		batsManList = choice.sortBychoice(Choice.MAX_RUNS_AND_BEST_AVG, batsmen);
		Assert.assertEquals("David Warner ", batsManList.get(0).player);
	}

}