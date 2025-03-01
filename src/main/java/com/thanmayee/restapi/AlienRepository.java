package com.thanmayee.restapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

	private static AlienRepository instance;
	private Connection conn;

	private AlienRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static AlienRepository getInstance() {
		if (instance == null) {
			instance = new AlienRepository();
		}
		return instance;
	}

	public List<Alien> getAliens() {
		List<Alien> aliens = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM aliens");

			while (rs.next()) {
				Alien alien = new Alien();
				alien.setId(rs.getInt("id"));
				alien.setName(rs.getString("name"));
				alien.setColour(rs.getString("colour"));
				aliens.add(alien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aliens;
	}

	public Alien getAlien(int id) {
		Alien alien = new Alien();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM aliens WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				alien.setId(rs.getInt("id"));
				alien.setName(rs.getString("name"));
				alien.setColour(rs.getString("colour"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alien;
	}

	public void addAlien(Alien alien) {
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO aliens (name, colour) VALUES (?, ?)");
			stmt.setString(1, alien.getName());
			stmt.setString(2, alien.getColour());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateAlien(Alien alien) {
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE aliens SET name = ?, colour = ? WHERE id = ?");
			stmt.setString(1, alien.getName());
			stmt.setString(2, alien.getColour());
			stmt.setInt(3, alien.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAlien(int id) {
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM aliens WHERE id = ?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
