package com.capgemini.iplleagueanalyser;

public class IPLLeagueAllRounder {

	private String player;
	private String runs;
	private String wickets;
	private String avgRuns;
	private String avgWickets;

	public IPLLeagueAllRounder(String player, String runs, String wickets, String avgRuns, String avgWickets) {
		this.player = player;
		this.runs = runs;
		this.wickets = wickets;
		this.avgRuns = avgRuns;
		this.avgWickets = avgWickets;
	}

	public String Player() {
		return player;
	}

	public int Runs() {
		if (runs.equals("-") || runs == "")
			runs = "0";
		int run = Integer.parseInt(runs);
		return run;
	}

	public int Wickets() {
		if (wickets.equals("-") || wickets == "")
			wickets = "0";
		int wkts = Integer.parseInt(wickets);
		return wkts;
	}

	public double AverageRuns() {
		if (avgRuns.equals("-") || avgRuns == "")
			avgRuns = "0";
		double avgR = Double.parseDouble(avgRuns);
		return avgR;
	}

	public double AverageWickets() {
		if (avgWickets.equals("-") || avgWickets == "")
			avgWickets = "0";
		double avgW = Double.parseDouble(avgWickets);
		return avgW;
	}

}
