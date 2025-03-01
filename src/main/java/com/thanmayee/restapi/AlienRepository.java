package com.thanmayee.restapi;

import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

	private static AlienRepository instance;
	private List<Alien> aliens;

	private AlienRepository() {
		aliens = new ArrayList<>();

		// Sample data
		Alien alien = new Alien();
		alien.setId(1);
		alien.setName("Sai");
		alien.setColour("Green");

		Alien alien1 = new Alien();
		alien1.setId(2);
		alien1.setName("Thanmayee");
		alien1.setColour("Yellow");

		aliens.add(alien);
		aliens.add(alien1);
	}

	// Singleton method
	public static AlienRepository getInstance() {
		if (instance == null) {
			instance = new AlienRepository();
		}
		return instance;
	}

	public List<Alien> getAliens() {
		return aliens;
	}

	public Alien getAlien(int id) {
		return aliens.stream().filter(alien -> alien.getId() == id).findAny().orElse(new Alien());
	}

	public void addAlien(Alien alien) {
		aliens.add(alien);
	}

	public void updateAlien(Alien alien) {
        for (Alien value : aliens) {
            if (value.getId() == alien.getId()) {
                value.setName(alien.getName());
                value.setColour(alien.getColour());
                return;
            }
        }
	}
	public void deleteAlien(int id) {
		aliens.removeIf(alien -> alien.getId() == id);
	}

}
