package com.tbe.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author badetitou
 *
 */
public class DataBaseedit {

	private static Connection c;
	/* STATICS */
	private static final int MAX_USERNAME_SIZE = 20;

	private static String strCreateLangueTable = "Create table if not exists Langue ("
			+ "Id Integer primary key autoincrement, "
			+ "Langue varchar(20) NOT NULL DEFAULT 'FR')";

	private static String strCreateCategorieTable = "Create table if not exists Categorie ("
			+ "Id Integer primary key autoincrement,"
			+ "Nom varchar(20) NOT NULL, "
			+ "Description text )";

	private static String strCreateUtilisateurTable= "Create table if not exists Utilisateur ("
			+ "Id Integer primary key autoincrement,"
			+ "Nom varchar(30) NOT NULL, "
			+ "Prenom varchar(30) NOT NULL, "
			+ "Mdp varchar(30) NOT NULL DEFAULT '0000', "
			+ "Ville varchar(30), "
			+ "EstMobile BOOL NOT NULL DEFAULT 'false', "
			+ "Type BOOL NOT NULL DEFAULT 'false', " // Par default t'es migrant en false
			+ "Divers VARCHAR(30), "
			+ "Dispo BOOL DEFAULT 'false');";

	private static String strCreateEvenementTable = "Create table if not exists Evenement ("
			+ "Id integer primary key autoincrement,"
			+ "Lieu varchar(20) NOT NULL,"
			+ "Date varchar(20) NOT NULL,"
			+ "Description varchar(500) NOT NULL);";

	private static String strCreateBesoinTable = "Create table if not exists Besoin ("
			+ "Id integer primary key autoincrement,"
			+ "Titre varchar(20) NOT NULL,"
			+ "Description varchar(500) NOT NULL);";

	private static String strCreateForumAIdeesTable = "Create table if not exists members ("
					+ "Id integer primary key autoincrement,"
					+ "Nom varchar(20) NOT NULL,"
					+ "Description varchar(500) NOT NULL);";

	private static String strCreateParticipeTable = "Create table if not exists Participe ("
					+ "Id integer primary key autoincrement,"
					+ "Nombre int,"
					+ "FOREIGN KEY (Evenement) REFERENCES Evenement(Id)"
					+ "FOREIGN KEY (Utilisateur) REFERENCES Utilisateur(Id));";

    private static String strCreateOrganiseTable =
            "Create table if not exists members ("
                    + "Id varchar(20) primary key,"
                    + "FOREIGN KEY (Evenement) REFERENCES Evenement(Id)"
                    + "FOREIGN KEY (Utilisateur) REFERENCES Utilisateur(Id)";

	public DataBaseedit() {
		System.out.println("Init BDD...");
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("java.io.tmpdir")
							+System.getProperty("file.separator")+"prolab.db");
			DataBaseedit.c = c;
			createTable();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}

	private void createTable() throws SQLException {
		System.out.println("Init Table");
		Statement stmt;

		stmt = DataBaseedit.c.createStatement();

		stmt.executeUpdate(strCreateOrganiseTable);
		stmt.executeUpdate(strCreateUtilisateurTable);
		stmt.executeUpdate(strCreateLangueTable);
		stmt.executeUpdate(strCreateCategorieTable);
		stmt.executeUpdate(strCreateEvenementTable);
		stmt.executeUpdate(strCreateParticipeTable);
		stmt.executeUpdate(strCreateBesoinTable);
		System.out.println("Init Table Done");
	}

	public static Connection getConnection() {
		return c;
	}
}
