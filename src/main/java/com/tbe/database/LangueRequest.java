package com.tbe.database;

import com.tbe.json.Langue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LangueRequest {

	public static List<Langue> getAllLangue() {
		ArrayList<Langue> langues = new ArrayList<Langue>();
		try {
			Statement stmt = DataBase.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("Select * from langues");
			while (rs.next()) {
				langues.add(new Langue(
						rs.getInt("id"),
						rs.getString("langue")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return langues;
	}
}
