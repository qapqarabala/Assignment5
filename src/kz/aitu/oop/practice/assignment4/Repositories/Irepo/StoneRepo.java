package kz.aitu.oop.practice.assignment4.Repositories.Irepo;
import kz.aitu.oop.practice.assignment4.Entities.Stone;
import kz.aitu.oop.practice.assignment4.FrontEnd;
import kz.aitu.oop.practice.assignment4.Postgres.IIDB.IDB;
import kz.aitu.oop.practice.assignment4.Repositories.Irepo.Interface.IRepo;
import kz.aitu.oop.practice.assignment4.Repositories.Irepo.Interface.Zhandos;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StoneRepo implements IRepo {
    private final IDB db;

    public StoneRepo(IDB db) {
        this.db = db;
    }


    @Override
    public boolean createStones(Stone employee) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO stone(id,name,value,cost,weight) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, Stone.getId());
            st.setString(2, Stone.getName());
            st.setString(3, Stone.getValue());
            st.setInt(4, Stone.getCost());
            st.setInt(5, Stone.getWeight());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
        public List<Stone> seeStones(){
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "1234");
                c.setAutoCommit(false);

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM STONE ORDER BY cost ASC;" );
                while ( rs.next() ) {
                    int id = rs.getInt("id");
                    String  name = rs.getString("name");
                    String value  = rs.getString("value");
                    int  cost = rs.getInt("cost");
                    int weight = rs.getInt("weight");
                    System.out.println( "ID = " + id );
                    System.out.println( "NAME = " + name );
                    System.out.println( "VALUE = " + value );
                    System.out.println( "COST = " + cost );
                    Zhandos lambda = (salmaq) -> salmaq * 5;
                    System.out.println( "WEIGHT(in carats) = " + lambda.weightString(weight));
                    System.out.println();
                }
                rs.close();
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName()+": "+ e.getMessage() );
                System.exit(0);
            }
            return null;
        }



    @Override
    public Stone deleteStones(int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "1234");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "DELETE from Stone where ID = " + id + ";";//sql query to delete the employee by id
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("ID " + id + " was deleted");
        return null;
    }




    @Override
    public int jewelryCost() {
        Connection con = null;
        int digit = 0;
        try {
            con = db.getConnection();
            String sql = "SELECT cost FROM stone"; // it is query
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                digit=digit+rs.getInt("cost");

            }return digit;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }return 0;
    }

    @Override
    public int jewelryWeight() {
        Connection con = null;
        int weight = 0;
        try {
            con = db.getConnection();
            String sql = "SELECT weight FROM stone"; // it is query
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                weight=weight+rs.getInt("weight")*5;

            }return weight;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }return 0;
    }
}
