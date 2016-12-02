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
			ResultSet rs = stmt.executeQuery("Select * from langue");
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

    public static int addLangue(String langue) {
        String sql = "insert into langue (langue) values (?);";
        try {
            PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);
            stmt.setString(1, langue);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(sql);
            return -1;
        }
    }
}
