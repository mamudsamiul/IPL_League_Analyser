package com.capgemini.iplleagueanalyser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByChoice<T> {
	public enum Choice {
		BAT_AVG, STRIKE_RATE, MAX_FOURS, MAX_SIXES, MAX_BOUNDARIES_AND_SR, MAX_AVG_AND_SR, MAX_RUNS_AND_BEST_AVG,
		BOWL_AVG, BOWL_STRIKE_RATE, BOWL_ECON, BEST_SR_AND_WKTS, BEST_SR_AND_AVG_BOWL, MAX_WKTS_AND_BEST_AVG,
		MAX_BAT_AND_BOWL_AVG, BEST_ALL_ROUNDER, MAX_100_AND_BEST_BAT_AVG, ZERO_100S_AND_50S_BUT_BEST_BAT_AVG;
	}

	public Choice choice;

	public List<T> sortBychoice(Choice choice, List<T> list) {
		String choice1 = choice.toString();
		String type = list.get(0).getClass().toString();
		List<IPLLeagueBatsman> batsmanList = null;
		List<IPLLeagueBowler> bowlerList = null;
		List<IPLLeagueAllRounder> allRounderList = null;
		if (type.contains("IPLLeagueBatsman")) {
			batsmanList = (List<IPLLeagueBatsman>) list;
		} else if (type.contains("IPLLeagueBowler")) {
			bowlerList = (List<IPLLeagueBowler>) list;
		} else if (type.contains("IPLLeagueAllRounder")) {
			allRounderList = (List<IPLLeagueAllRounder>) list;
		}
		switch (choice1) {
		case "BAT_AVG": {
			Collections.sort(batsmanList,
					Comparator.comparing(batsman -> ((IPLLeagueBatsman) batsman).Average()).reversed());
			return (List<T>) batsmanList;
		}
		case "STRIKE_RATE": {
			for (IPLLeagueBatsman b1 : batsmanList) {
				if (b1.strikeRate.equals("-"))
					b1.strikeRate = "0";
			}
			Collections.sort(batsmanList,
					Comparator.comparing(batsman -> ((IPLLeagueBatsman) batsman).StrikeRate()).reversed());
			return (List<T>) batsmanList;
		}
		case "MAX_FOURS": {
			Collections.sort(batsmanList,
					Comparator.comparing(batsman -> ((IPLLeagueBatsman) batsman).noOfFours()).reversed());
			return (List<T>) batsmanList;
		}
		case "MAX_SIXES": {
			Collections.sort(batsmanList,
					Comparator.comparing(batsman -> ((IPLLeagueBatsman) batsman).noOfSixes()).reversed());
			return (List<T>) batsmanList;
		}
		case "MAX_BOUNDARIES_AND_SR": {
			Comparator<IPLLeagueBatsman> compareBy = Comparator.comparing(IPLLeagueBatsman::StrikeRate)
					.thenComparing(IPLLeagueBatsman::noOfBoundaries);
			Collections.sort(batsmanList, compareBy.reversed());
			return (List<T>) batsmanList;
		}
		case "MAX_AVG_AND_SR": {
			Comparator<IPLLeagueBatsman> compareBy = Comparator.comparing(IPLLeagueBatsman::Average)
					.thenComparing(IPLLeagueBatsman::StrikeRate);
			Collections.sort(batsmanList, compareBy.reversed());
			return (List<T>) batsmanList;
		}
		case "MAX_RUNS_AND_BEST_AVG": {
			Comparator<IPLLeagueBatsman> compareBy = Comparator.comparing(IPLLeagueBatsman::Runs)
					.thenComparing(IPLLeagueBatsman::Average);
			Collections.sort(batsmanList, compareBy.reversed());
			return (List<T>) batsmanList;
		}
		case "BOWL_AVG": {
			Collections.sort(bowlerList, Comparator.comparing(bowler -> ((IPLLeagueBowler) bowler).Average()));
			return (List<T>) bowlerList;
		}
		case "BOWL_STRIKE_RATE": {
			Collections.sort(bowlerList, Comparator.comparing(bowler -> ((IPLLeagueBowler) bowler).StrikeRate()));
			return (List<T>) bowlerList;
		}
		case "BOWL_ECON": {
			Collections.sort(bowlerList, Comparator.comparing(bowler -> ((IPLLeagueBowler) bowler).EconomyRate()));
			return (List<T>) bowlerList;
		}
		case "BEST_SR_AND_WKTS": {
			Comparator<IPLLeagueBowler> compareBy = Comparator.comparing(IPLLeagueBowler::StrikeRate)
					.thenComparing(IPLLeagueBowler::Total4wsAnd5ws);
			Collections.sort(bowlerList, compareBy);
			return (List<T>) bowlerList;
		}
		case "BEST_SR_AND_AVG_BOWL": {
			Comparator<IPLLeagueBowler> compareBy = Comparator.comparing(IPLLeagueBowler::Average)
					.thenComparing(IPLLeagueBowler::StrikeRate);
			Collections.sort(bowlerList, compareBy);
			return (List<T>) bowlerList;
		}
		case "MAX_WKTS_AND_BEST_AVG": {
			Comparator<IPLLeagueBowler> compareBy = Comparator.comparing(IPLLeagueBowler::Wickets)
					.thenComparing(IPLLeagueBowler::Average);
			Collections.sort(bowlerList, compareBy.reversed());
			return (List<T>) bowlerList;
		}
		case "MAX_BAT_AND_BOWL_AVG": {
			Comparator<IPLLeagueAllRounder> compareBy = Comparator.comparing(IPLLeagueAllRounder::AverageWickets)
					.thenComparing(IPLLeagueAllRounder::AverageRuns).reversed();
			Collections.sort(allRounderList, compareBy);
			return (List<T>) allRounderList;
		}
		case "BEST_ALL_ROUNDER": {
			Comparator<IPLLeagueAllRounder> compareBy = Comparator.comparing(IPLLeagueAllRounder::Runs)
					.thenComparing(IPLLeagueAllRounder::Wickets).reversed();
			Collections.sort(allRounderList, compareBy);
			return (List<T>) allRounderList;
		}
		case "MAX_100_AND_BEST_BAT_AVG": {
			Comparator<IPLLeagueBatsman> compareBy = Comparator.comparing(IPLLeagueBatsman::Hundreds)
					.thenComparing(IPLLeagueBatsman::Average);
			Collections.sort(batsmanList, compareBy.reversed());
			return (List<T>) batsmanList;
		}
		case "ZERO_100S_AND_50S_BUT_BEST_BAT_AVG": {
			List<IPLLeagueBatsman> batsManList = new ArrayList<IPLLeagueBatsman>();
			for (IPLLeagueBatsman b : batsmanList) {
				if (b.Hundreds() == 0 && b.Fifties() == 0) {
					batsManList.add(b);
				}
			}
			Collections.sort(batsManList,
					Comparator.comparing(batsman -> ((IPLLeagueBatsman) batsman).Average()).reversed());
			return (List<T>) batsManList;
		}

		default: {
			System.out.println("Wrong choice entered!");
			return null;
		}
		}
	}

	public List<IPLLeagueAllRounder> getAllRounderPlayers(List<IPLLeagueBatsman> batsmenList,
			List<IPLLeagueBowler> bowlersList) {
		List<IPLLeagueAllRounder> allRounderList = new ArrayList<>();
		for (IPLLeagueBatsman b1 : batsmenList) {
			IPLLeagueBowler bowlers = bowlersList.stream().filter(bowler -> bowler.player.equalsIgnoreCase(b1.player))
					.findFirst().orElse(null);
			if (bowlers != null) {
				allRounderList.add(new IPLLeagueAllRounder(b1.player, b1.runs, bowlers.wickets, b1.avg, bowlers.avg));
			}
		}
		return allRounderList;
	}
}
