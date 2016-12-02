package com.tbe.database;

import com.tbe.json.Participe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipeRequest {

    public static List<Participe> getAllParticipe() {
        ArrayList<Participe> participes = new ArrayList<Participe>();
        try {
            Statement stmt = DataBase.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("Select * from participe");
            while (rs.next()) {
                participes.add(new Participe(
                        rs.getInt("id"),
                        rs.getInt("nombre"),
                        rs.getString("evenement"),
                        rs.getString("utiliisateur")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return participes;
    }

    public static int addParticipe(Int nombre, String evenement, String utilisateur ) {
        String sql = "insert into participe (participe) values (?, ?, ?);";
        try {
            PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);
            stmt.setInt(1, nombre);
            stmt.setString(2, evenement);
            stmt.setString(3, utilisateur);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(sql);
            return -1;
        }
    }
}
