package com.tbe.database;

import com.tbe.json.Organise;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrganiseRequest {

    public static List<Organise> getAllOrganise() {
        ArrayList<Organise> organises = new ArrayList<Organise>();
        try {
            Statement stmt = DataBase.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("Select * from organise");
            while (rs.next()) {
                organises.add(new Organise(
                        rs.getInt("id"),
                        rs.getString("evenement"),
                        rs.getDate("utilisateur")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return organises;
    }

    public static int addOrganise(String evenement, String utilisateur) {
        String sql = "insert into organise (organise) values (?, ?);";
        try {
            PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);
            stmt.setString(1, evenement);
            stmt.setString(2, utilisateur);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(sql);
            return -1;
        }
    }
}
