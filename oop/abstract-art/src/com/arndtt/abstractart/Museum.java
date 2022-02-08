package com.arndtt.abstractart;

import java.util.ArrayList;
import java.util.Random;

public class Museum {

	public static void main(String[] args) {
		ArrayList<Art> museum = new ArrayList<Art>();;
		museum.add(new Painting("Mona Lisa", "Leonnardo DaVinci", "Very small painting with a very big reputation", "Oils"));
		museum.add(new Painting("Starry Night", "Vincent Van Gogh", "Striking color contrast and brush technique", "Oils"));
		museum.add(new Painting("Selfie", "Thomas Arndt", "Now you see me", "Photography"));
		museum.add(new Sculpture("Leaves On Water", "Andy Goldsworthy", "Vibrant natural hues floating serenly on a slow moving stream", "Leaves and Water"));
		museum.add(new Sculpture("Winged Victory", "Some Dead Dude", "Woman with wings and no head", "Marble"));
		Random randomGenerator = new Random();
		for(int i = 0; i < museum.size(); i++) {
			int randomIndex1 = randomGenerator.nextInt(museum.size());
			int randomIndex2 = randomGenerator.nextInt(museum.size());
			Art temp = museum.get(randomIndex1);
			museum.set(randomIndex1, museum.get(randomIndex2));
			museum.set(randomIndex2, temp);
		}
		for(int i = 0; i < museum.size(); i++) {
			museum.get(i).viewArt();
		}
	}

}
