package com.capgemini.iplleagueanalyser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByChoice<T> {
	public enum Choice {
		BAT_AVG, STRIKE_RATE;
	}

	public Choice choice;

	@SuppressWarnings("unchecked")
	public List<T> sortBychoice(Choice choice, List<T> list) {
		String choice1 = choice.toString();
		List<IPLLeagueBatsman> list1 = (List<IPLLeagueBatsman>) list;
		switch (choice1) {
		case "BAT_AVG": {
			Collections.sort(list1, Comparator.comparing(batsman -> ((IPLLeagueBatsman) batsman).Average()).reversed());
			return (List<T>) list1;
		}
		case "STRIKE_RATE": {
			for (IPLLeagueBatsman b1 : list1) {
				if (b1.strikeRate.equals("-"))
					b1.strikeRate = "0";
			}
			Collections.sort(list1,
					Comparator.comparing(batsman -> ((IPLLeagueBatsman) batsman).StrikeRate()).reversed());
			return (List<T>) list1;
		}
		default: {
			System.out.println("Wrong choice entered!");
			return null;
		}
		}
	}
}
