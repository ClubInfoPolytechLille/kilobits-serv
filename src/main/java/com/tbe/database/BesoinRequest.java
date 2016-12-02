package com.tbe.database;

import com.tbe.json.Besoin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BesoinRequest {

    public static List<Besoin> getAllBesoin() {
        ArrayList<Besoin> besoins = new ArrayList<Besoin>();
        try {
            Statement stmt = DataBase.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("Select * from besoin");
            while (rs.next()) {
                besoins.add(new Besoin(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return besoins;
    }

    public static int addBesoin(String titre, String description) {
        String sql = "insert into besoin (besoin) values (?, ?);";
        try {
            PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);
            stmt.setString(1, titre);
            stmt.setString(2, description);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(sql);
            return -1;
        }
    }
}
