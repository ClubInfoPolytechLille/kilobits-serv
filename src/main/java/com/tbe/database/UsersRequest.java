package com.tbe.database;


import com.tbe.json.User;

import java.sql.PreparedStatement;
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
}
