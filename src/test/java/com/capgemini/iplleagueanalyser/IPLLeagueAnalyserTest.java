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
	public List<IPLLeagueAllRounder> allRounderList = null;

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

	@Test
	public void givenBowlingCSVfileReturnTopAverageBowler() {
		try {
			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		bowlerList = choice.sortBychoice(Choice.BOWL_AVG, bowlers);
		Assert.assertEquals("11", bowlerList.get(0).avg);
	}

	@Test
	public void givenBowlingCSVfileReturnTopSRBowler() {
		try {
			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		bowlerList = choice.sortBychoice(Choice.BOWL_STRIKE_RATE, bowlers);
		Assert.assertEquals("Alzarri Joseph", bowlerList.get(0).player);
	}

	@Test
	public void givenBowlingCSVfileReturnTopEconomyRateBowler() {
		try {
			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		bowlerList = choice.sortBychoice(Choice.BOWL_ECON, bowlers);
		Assert.assertEquals("Shivam Dube", bowlerList.get(0).player);
	}

	@Test
	public void givenBowlingCSVfileReturnTopStrikeRateBowlerWithMaximumWickets() {
		try {
			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		bowlerList = choice.sortBychoice(Choice.BEST_SR_AND_WKTS, bowlers);
		Assert.assertEquals("Alzarri Joseph", bowlerList.get(0).player);
	}

	@Test
	public void givenBowlingCSVfileReturnTopStrikeRateBowlerWithBestAverage() {
		try {
			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		bowlerList = choice.sortBychoice(Choice.BEST_SR_AND_AVG_BOWL, bowlers);
		Assert.assertEquals("Anukul Roy", bowlerList.get(0).player);
	}

	@Test
	public void givenBowlingCSVfileReturnTopStrikeRateBowlerWithMaximumWickets_() {
		try {
			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		bowlerList = choice.sortBychoice(Choice.MAX_WKTS_AND_BEST_AVG, bowlers);
		Assert.assertEquals("Imran Tahir", bowlerList.get(0).player);
	}

	@Test
	public void givenBattingandbowlingfileReturnBestBattingAndBowlingAverages() {
		try {
			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		bowlerList = choice.getAllRounderPlayers(batsmen, bowlers);
		List<IPLLeagueAllRounder> allRounderList = choice.sortBychoice(Choice.MAX_BAT_AND_BOWL_AVG, bowlerList);
		Assert.assertEquals("Krishnappa Gowtham", allRounderList.get(0).Player());
	}

	@Test
	public void givenBattingandbowlingfileReturnBestAllRounder() {
		try {
			bowlers = obj.readData(BOWLERS_CSV_FILE, "BOWLERS");
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		bowlerList = choice.getAllRounderPlayers(batsmen, bowlers);
		List<IPLLeagueAllRounder> l4 = choice.sortBychoice(Choice.BEST_ALL_ROUNDER, bowlerList);
		Assert.assertEquals("Andre Russell", l4.get(0).Player());
	}

	@Test
	public void givenBattingCSVfile_ShouldReturnPlayerWithMaximum100AndBestBattingAvg() {
		try {
			batsmen = obj.readData(BATSMEN_CSV_FILE, "BATSMEN");
		} catch (IPLLeagueAnalyserException e) {
			e.printStackTrace();
		}
		batsManList = choice.sortBychoice(Choice.MAX_100_AND_BEST_BAT_AVG, batsmen);
		Assert.assertEquals("David Warner ", batsManList.get(0).player);
	}
}