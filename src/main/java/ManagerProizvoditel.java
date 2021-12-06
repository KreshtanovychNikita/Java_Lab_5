import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ManagerProizvoditel {
    private Connection connection;

    public ManagerProizvoditel() {
        try {
            String url = "jdbc:mysql:localhost:3306/lab_5";
            String user = "root";
            String pass = "Nikita Kreshtanovych";


            this.connection = DriverManager.getConnection(url, user, pass);

        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }
    }
//+добавлять таблицу, +удалять таблицу, +добавить в таблицу, +удалить из таблицы, +изменить номер телефона,
    //+выбрать всех производителей, +выбрать производителей по стране, +выбрать производителей по имени,
    //+выбрать производеля по ид



    public void addTable() throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE proizvoditels( id INT(15) PRIMARY KEY,Name VARCHAR(30),PhoneNumber VARCHAR(15),Country VARCHAR(15));");
    }
    public void removeTable() throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP TABLE proizvoditels");
    }
    public void addToTable(Proizvoditel proizvoditel) throws SQLException{
        PreparedStatement statement = connection.prepareStatement("INSERT INTO proizvoditels VALUES(?;?;?;?;?);");
        statement.setInt(1,proizvoditel.getId());
        statement.setString(2,proizvoditel.getName());
        statement.setString(3,proizvoditel.getPhoneNumber());
        statement.setString(4,proizvoditel.getCountry());
        statement.execute();
        System.out.println("Add 1 proizvoditel");
    }

    public void deleteFromTable(int id) throws SQLException{
        PreparedStatement statement = connection.prepareStatement("DELETE FROM proizvoditels WHERE id=?;");
        statement.setInt(1, id);
        statement.executeUpdate();

    }


    public  void updatePhoneNumber(Proizvoditel proizvoditel) throws SQLException{
        PreparedStatement statement = connection.prepareStatement("CHANGE FROM proizvoditels WHERE PhoneNumber = ?;");
        statement.setString(1, proizvoditel.getPhoneNumber());
        statement.execute();

    }

    public Collection<Proizvoditel> selectAll() throws SQLException{
        Collection<Proizvoditel> proizvoditels = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("SELECT  * FROM proizvoditels");
        while (set.next()){
            proizvoditels.add(new Proizvoditel(
                    set.getInt("id"),
                    set.getString("Name"),
                    set.getString("PhoneNumber"),
                    set.getString("Country")));
        }
        return proizvoditels;
    }

    public Collection<Proizvoditel> selectProizvAtCountry(String country) throws SQLException{
        Collection<Proizvoditel> proizvoditels = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT proizvoditels FROM proizvoditels WHERE Country = ?;");
        statement.setString(1, country);
        ResultSet set = statement.executeQuery();

        while (set.next()){
            proizvoditels.add(new Proizvoditel(
                    set.getInt("id"),
                    set.getString("Name"),
                    set.getString("PhoneNumber"),
                    set.getString("Country")));
        }
        return proizvoditels;
    }

    public Collection<Proizvoditel> selectProizvAtName(String name) throws SQLException{
        Collection<Proizvoditel> proizvoditels = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT proizvoditels FROM proizvoditels WHERE Name = ?; ");
        statement.setString(1, name);

        ResultSet set = statement.executeQuery();
        while (set.next()){
            proizvoditels.add(new Proizvoditel(
                    set.getInt("id"),
                    set.getString("Name"),
                    set.getString("PhoneNumber"),
                    set.getString("Country")));
        }
        return proizvoditels;
    }

    public Collection<Proizvoditel> selectProizvAtId(int id) throws SQLException{
        Collection<Proizvoditel> proizvoditels = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT proizvoditels FROM proizvoditels WHERE id = ?; ");
        statement.setInt(1, id);

        ResultSet set = statement.executeQuery();
        while (set.next()){
            proizvoditels.add(new Proizvoditel(
                    set.getInt("id"),
                    set.getString("Name"),
                    set.getString("PhoneNumber"),
                    set.getString("Country")));
        }
        return proizvoditels;
    }
}

