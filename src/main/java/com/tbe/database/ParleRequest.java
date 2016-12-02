package com.tbe.database;

import com.tbe.json.Parle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParleRequest {

    public static List<Parle> getAllParle() {
        ArrayList<Parle> parles = new ArrayList<Parle>();
        try {
            Statement stmt = DataBase.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("Select * from parle");
            while (rs.next()) {
                parles.add(new Parle(
                        rs.getInt("id"),
                        rs.getString("nom")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return parles;
    }

    public static int addParle(String nom) {
        String sql = "insert into parle (parle) values (?);";
        try {
            PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);
            stmt.setString(1, nom);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(sql);
            return -1;
        }
    }
}
