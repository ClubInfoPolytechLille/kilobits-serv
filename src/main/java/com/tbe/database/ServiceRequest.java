package com.tbe.database;

import com.tbe.json.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRequest {

    public static List<Service> getAllService() {
        ArrayList<Service> services = new ArrayList<Service>();
        try {
            Statement stmt = DataBase.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("Select * from service");
            while (rs.next()) {
                services.add(new Service(
                        rs.getInt("id"),
                        rs.getString("idcategorie"),
                        rs.getString("idutilisateur")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return services;
    }

    public static int addService(String idcategorie, String idutilisateur) {
        String sql = "insert into service (service) values (?, ?);";
        try {
            PreparedStatement stmt = DataBase.getConnection().prepareStatement(sql);
            stmt.setString(1, idcategorie);
            stmt.setString(2, idutilisateur);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(sql);
            return -1;
        }
    }
}
