import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ManagerDetal {
    private Connection connection;
    public ManagerDetal(){
        try {
            String url = "jdbc:mysql:localhost:3306/lab_5";
            String user = "root";
            String pass = "Nikita Kreshtanovych";


            this.connection = DriverManager.getConnection(url, user, pass);

        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }
    }


    public void addDetalToTable(Detal detal) throws  SQLException{
        PreparedStatement statement = connection.prepareStatement("INSERT INTO detals VALUES(?;?;?;?;?);");
        statement.setInt(1,detal.getId());
        statement.setInt(2,detal.getIdProivoditel());
        statement.setString(3, detal.getName());
        statement.setInt(4,detal.getArticul());
        statement.setFloat(5,detal.getPrice());
        statement.execute();
        System.out.println("Add 1 detal");
    }
    public void removeInTable(int id) throws  SQLException{
        PreparedStatement statement = connection.prepareStatement("DELETE FROM detals WHERE id=?;");
        statement.setInt(1, id);
        statement.executeUpdate();
    }
    public void createTable() throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE detals(id INT(15) PRIMARY KEY, idDetal INT(15),Name VARCHAR(30),idArticul INT(15),price FLOAT(10));");
    }
    public void deleteTable() throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP TABLE detals");
    }
    public Collection<Detal> selectAll() throws SQLException{
        Collection<Detal> detals = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("SELECT  * FROM detals");
        while (set.next()){
            detals.add(new Detal(
                    set.getInt("id"),
                    set.getInt("idDetal"),
                    set.getString("Name"),
                    set.getInt("IdArticul"),
                    set.getFloat("Price")));
        }
        return detals;
    }


}
