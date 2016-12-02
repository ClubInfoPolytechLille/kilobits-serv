package com.tbe.database;

import com.tbe.json.Categorie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieRequest {

    public static List<Categorie> getAllCategorie() {
        ArrayList<Categorie> categories = new ArrayList<Categorie>();
        try {
            Statement stmt = DataBase.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("Select * from categorie");
            while (rs.next()) {
                categories.add(new Categorie(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getDate("description"),
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return categories;
    }

    public static int addCategorie(String nom, String description) {
        String sql = "insert into categorie (categorie) values (?, ?);";
        try {
            PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, description);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(sql);
            return -1;
        }
    }
}
