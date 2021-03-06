package com.ya.grupp5b.skirace.tools;

import java.time.format.DateTimeFormatter;
import java.util.Collections;

import com.ya.grupp5b.skirace.race.Race;
import com.ya.grupp5b.skirace.skier.CompareGoalTime;
import com.ya.grupp5b.skirace.skier.CompareTempTime;
import com.ya.grupp5b.skirace.skier.Skier;

/**
 * Klass som hanterar metoder för all utmatning
 */

public class Output {

	// METOD: Skriver ut skierList
	public void printSkierList(Race race) {
		for (Skier newSkier : race.getSkierList()) {
			System.out.println(newSkier);
		}
	}

	// METOD: Sorterar och skriver ut listan efter målgångstider
	public void printSkierGoalTime(Race race) {

		// Extern jämförare
		CompareGoalTime goalCheck = new CompareGoalTime();
		Collections.sort(race.getSkierList(), goalCheck);

		System.out.println("Målgångstid\t\t#Startnr\t\tPlacering\t\tNamn");
		int placeAdjustment = 0;
		for (int i = 0; i < race.getSkierList().size(); i++) {
			DateTimeFormatter formatPattern = DateTimeFormatter.ofPattern("HH:mm:ss:SSSSSS"); // formatting options

			String formattedGoalTime = race.getSkierList().get(i).getGoalTime() == null ? formattedGoalTime = "--\t"
					: race.getSkierList().get(i).getGoalTime().format(formatPattern);

			// Justera placeringsindex ifall inte alla är registrerade
			placeAdjustment = race.getSkierList().get(i).getGoalTime() == null ? placeAdjustment + 1
					: placeAdjustment + 0;
			String place = race.getSkierList().get(i).getGoalTime() == null ? place = "--"
					: "" + ((i + 1) - placeAdjustment);

			System.out.println(formattedGoalTime + "\t\t#" + race.getSkierList().get(i).getSkierNumber() + "\t\t\t"
					+ place + "\t\t\t" + race.getSkierList().get(i).getFirstName() + " "
					+ race.getSkierList().get(i).getLastName());
		}
	}

	// METOD: Sorterar och skriver ut listan efter mellantider
	public void printSkierTempTime(Race race) {

		// Extern jämförare
		CompareTempTime tempCheck = new CompareTempTime();
		Collections.sort(race.getSkierList(), tempCheck);
		race.getSkierList().get(0);
		System.out.println("Mellantid\t\t#Startnr\t\tPlacering\t\tNamn");
		int placeAdjustment = 0;

		for (int i = 0; i < race.getSkierList().size(); i++) {
			DateTimeFormatter formatPattern = DateTimeFormatter.ofPattern("HH:mm:ss:SSSSSS");

			String formattedTempTime = race.getSkierList().get(i).getTempTime() == null ? formattedTempTime = "--\t"
					: race.getSkierList().get(i).getTempTime().format(formatPattern);

			// Justera placeringsindex ifall inte alla är registrerade
			placeAdjustment = race.getSkierList().get(i).getTempTime() == null ? placeAdjustment + 1
					: placeAdjustment + 0;
			String place = race.getSkierList().get(i).getTempTime() == null ? place = "--"
					: "" + ((i + 1) - placeAdjustment);

			System.out.println(formattedTempTime + "\t\t#" + race.getSkierList().get(i).getSkierNumber() + "\t\t\t"
					+ place + "\t\t\t" + race.getSkierList().get(i).getFirstName() + " "
					+ race.getSkierList().get(i).getLastName());

		}
	}

	// METOD: Skriver ut mellantid för vald åkare och felhanterar null
	public void printChosenTempTime(int currentIndex, Race race) {

		if (race.getSkierList().get(currentIndex).getTempTime() == null) {
			System.out.println("Ingen mellantid kan registreras ännu");
		} else {
			System.out.println("Mellantiden " + race.getSkierList().get(currentIndex).getTempTime()
					+ " är tagen för åkare med startnummer #"
					+ race.getSkierList().get(currentIndex).getSkierNumber() + ", "
					+ race.getSkierList().get(currentIndex).getFirstName() + " "
					+ race.getSkierList().get(currentIndex).getLastName() + ", placering: " + (currentIndex + 1)
					+ "\n");
		}

	}

	// METOD: Skriver ut målgångstid för vald åkare och felhanterar null
	public void printChosenGoalTime(int currentIndex, Race race) {

		if (race.getSkierList().get(currentIndex).getGoalTime() == null) {
			System.out.println("Ingen målgångstid kan registreras ännu");
		} else {
			System.out.println("Målgångstiden " + race.getSkierList().get(currentIndex).getGoalTime()
					+ " är registrerad för åkare med startnummer #"
					+ race.getSkierList().get(currentIndex).getSkierNumber() + ", "
					+ race.getSkierList().get(currentIndex).getFirstName() + " "
					+ race.getSkierList().get(currentIndex).getLastName() + "\n");
		}

	}
}
