
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;



public class Manager {



    private Connection conn;


    public Manager(){

        try {
            String url = "jdbc:mysql:localhost:3306/lab_5";
            String user = "root";
            String pass = "Nikita Kreshtanovych";


            this.conn = DriverManager.getConnection(url, user, pass);

        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }
    }

    public  void closeConn() throws  SQLException{

        conn.close();
    }



    //TABLE OPERATIONS
    public void createTableProizvoditel() throws SQLException{
            String t="Create Table Proizvoditel (id INT(15) PRIMARY KEY, Name VARCHAR(30) NOT NULL," +
                    "PhoneNumber VARCHAR (30) NOT NULL, Country INT(30)";

            Statement stmt = this.conn.createStatement();
            stmt.executeUpdate(t);

    }

    public void deleteTableProizvoditel() throws SQLException{

        Statement stmt = this.conn.createStatement();

    }


}
