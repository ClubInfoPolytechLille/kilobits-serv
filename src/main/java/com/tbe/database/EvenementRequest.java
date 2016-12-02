package com.tbe.database;

import com.tbe.json.Evenement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EvenementRequest {

	public static List<Evenement> getAllEvenement() {
		ArrayList<Evenement> evenements = new ArrayList<Evenement>();
		try {
			Statement stmt = DataBase.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("Select * from evenement");
			while (rs.next()) {
				evenements.add(new Evenement(
						rs.getInt("id"),
						rs.getString("lieu"),
						rs.getDate("dat"),
						rs.getString("description")
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return evenements;
	}

    public static int addEvenement(String lieu, Date dat, String description) {
        String sql = "insert into evenement (evenement) values (?, ?, ?);";
        try {
            PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);
            stmt.setString(1, lieu);
			stmt.setDate(2, dat);
			stmt.setString(3, description);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(sql);
            return -1;
        }
    }
}
