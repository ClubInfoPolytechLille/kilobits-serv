package com.tbe.database;

import com.tbe.json.ForumAIdees;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ForumAIdeesRequest {

    public static List<ForumAIdees> getAllForumAIdees() {
        ArrayList<ForumAIdees> forumAIdeess = new ArrayList<ForumAIdees>();
        try {
            Statement stmt = DataBase.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("Select * from forumAIdees");
            while (rs.next()) {
                forumAIdeess.add(new ForumAIdees(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return forumAIdeess;
    }

    public static int addForumAIdees(String nom, String description) {
        String sql = "insert into forumAIdees (forumAIdees) values (?, ?);";
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
