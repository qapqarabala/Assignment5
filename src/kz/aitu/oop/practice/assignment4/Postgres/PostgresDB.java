package kz.aitu.oop.practice.assignment4.Postgres;

import kz.aitu.oop.practice.assignment4.Postgres.IIDB.IDB;

import java.sql.*;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "1234");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}