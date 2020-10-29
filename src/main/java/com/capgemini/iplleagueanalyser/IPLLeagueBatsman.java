package com.capgemini.iplleagueanalyser;

import com.opencsv.bean.CsvBindByName;

public class IPLLeagueBatsman {
	@CsvBindByName(column = "POS")
	public String pos;
	@CsvBindByName(column = "PLAYER")
	public String player;
	@CsvBindByName(column = "Mat")
	public String matches;
	@CsvBindByName(column = "inns")
	public String innings;
	@CsvBindByName(column = "NO")
	public String notOuts;
	@CsvBindByName(column = "Runs")
	public String runs;
	@CsvBindByName(column = "HS")
	public String highestScore;
	@CsvBindByName(column = "Avg")
	public String avg;
	@CsvBindByName(column = "BF")
	public String ballsFaced;
	@CsvBindByName(column = "SR")
	public String strikeRate;
	@CsvBindByName(column = "100")
	public String hundreds;
	@CsvBindByName(column = "50")
	public String fifties;
	@CsvBindByName(column = "4s")
	public String fours;
	@CsvBindByName(column = "6s")
	public String sixes;

	public double Average() {
		if (avg.equals("-") || avg == "")
			this.avg = "0";
		double average = Double.parseDouble(this.avg);
		return average;
	}

	public double StrikeRate() {
		if (strikeRate.equals("-") || strikeRate == "")
			this.strikeRate = "0";
		double sr = Double.parseDouble(this.strikeRate);
		return sr;
	}

	public int noOfFours() {
		if (fours.equals("-") || fours == "")
			fours = "0";
		int four = Integer.parseInt(fours);
		return four;
	}

	public int noOfSixes() {
		if (sixes.equals("-") || sixes == "")
			sixes = "0";
		int six = Integer.parseInt(sixes);
		return six;
	}

	@Override
	public String toString() {
		return "Batsman-- \nPosition: " + pos + " Player :" + player + " Matches: " + matches + " Innings: " + innings
				+ " Not Outs: " + notOuts + " Runs: " + runs + " Highest Score: " + highestScore + " Average: " + avg
				+ " Balls Faced: " + ballsFaced + " Strike Rate: " + strikeRate + " No. of 100s: " + hundreds
				+ " No. of 50s: " + fifties + " No. of 4s: " + fours + " No. of 6s: " + sixes;
	}
}
