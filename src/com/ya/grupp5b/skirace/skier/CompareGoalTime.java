package com.ya.grupp5b.skirace.skier;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Comparator;

public class CompareGoalTime implements Comparator<Skier> {

	@Override
	public int compare(Skier skier1, Skier skier2) {

		// Låt stå, testar detta vid tillfälle /Osama
		// possible solution for handling nulls:
		// ternary condition; Example:
		// boolean noDur1 = false;
		// Duration duration1 = skier1.getGoalTime() == null ? noDur1 = true :
		// Duration.between(testTime, skier1.getGoalTime());

		LocalTime testTime = LocalTime.of(0, 0, 0, 0);
		Duration duration1 = Duration.between(testTime, skier1.getGoalTime());
		int durationInSec1 = (int) duration1.toSeconds();
		Duration duration2 = Duration.between(testTime, skier2.getGoalTime());
		int durationInSec2 = (int) duration2.toSeconds();

		if (durationInSec1 < durationInSec2) { // || noDur1 (== true)
			return -1;
		} else if (durationInSec1 > durationInSec2) {
			return 1;
		} else {
			return 0;
		}

	}

}
