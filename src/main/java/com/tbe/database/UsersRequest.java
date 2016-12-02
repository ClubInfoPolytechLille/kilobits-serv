package com.tbe.database;


import com.tbe.json.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRequest {


	public static String addUser(User user) {
        System.out.println(user);
        String sql = "Insert into utilisateur(pseudo, nom, prenom, mdp, ville, EstMobile, Typ, Divers, Dispo) " +
                "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);
            stmt.setString(1, user.getPseudo());
            stmt.setString(2, user.getNom());
            stmt.setString(3, user.getPrenom());
            stmt.setString(4, user.getMdp());
            stmt.setString(5, user.getVille());
            stmt.setBoolean(6, user.isEstMobile());
            stmt.setBoolean(7, user.isTyp());
            stmt.setString(8, user.getDivers());
            stmt.setBoolean(9, user.isDispo());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();

            System.err.println(sql);
            return null;
        }
        return "ok";
	}

	public static User connectUser(User user) {
        String sql = "SELECT pseudo, Typ FROM utilisateur WHERE pseudo = ? AND mdp = ? ;";
        try {
            PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);
            stmt.setString(1, user.getPseudo());
            stmt.setString(2, user.getMdp());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Yep");
                user = new User();
                user.setPseudo(rs.getString("pseudo"));
                user.setTyp(rs.getBoolean("Typ"));
                return user;
            } else {
                System.out.println("Nop");
                user = new User();
                return user;
            }
        } catch (SQLException e) {
            System.out.println("Oops");
            e.printStackTrace();
            return null;
        }
    }
}
