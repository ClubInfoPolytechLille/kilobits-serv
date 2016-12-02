package com.tbe.database;

import com.tbe.json.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageRequest {

    public static List<Message> getAllMessage() {
        ArrayList<Message> messages = new ArrayList<Message>();
        try {
            Statement stmt = DataBase.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("Select * from message");
            while (rs.next()) {
                messages.add(new Message(
                        rs.getInt("id"),
                        rs.getString("texte"),
                        rs.getInt("idutilisateur")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return messages;
    }

    public static int addMessage(String texte, String idutilisateur) {
        String sql = "insert into message (message) values (?, ?);";
        try {
            PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);
            stmt.setString(1, texte);
            stmt.setString(2, idutilisateur);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(sql);
            return -1;
        }
    }
}
