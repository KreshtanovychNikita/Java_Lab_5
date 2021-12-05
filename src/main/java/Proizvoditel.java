
import java.sql.*;
import java.util.*;

public class Proizvoditel {

    private int id;
    private String Name;
    private String PhoneNumber;
    private String Country;



    public Proizvoditel(int id, String Name, String PhoneNumber, String Country){
        this.id = id;
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.Country = Country;




    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @Override
    public String toString() {
        return "Proizvoditel{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }


    public static void main(String[] args) throws SQLException{

        Proizvoditel p1 = new Proizvoditel(5,"AVTO-MOTO","0992504925","UK");
        Proizvoditel p2 = new Proizvoditel(6,"SUPER_AVTO","099854896","UA");
        Proizvoditel p3 = new Proizvoditel(7,"DEtALJB","098546525","Canada");
        Proizvoditel p4 = new Proizvoditel(8,"100Point","085648931","USA");

        Proizvoditel proizvoditel = new Manager();

        Proizvoditel.createTableProivoditel();

        proizvoditel.addProizvoditel(p1);
        proizvoditel.addProizvoditel(p2);
        proizvoditel.addProizvoditel(p3);
        proizvoditel.addProizvoditel(p4);



        /**
         * Select all Proizvoditels
         *
         *
         * */
        Collection<Proizvoditel> proizvoditels = manager.selectAll();
        for(Proizvoditel proizvoditel: proizvoditels){

            System.out.println(proizvoditel);
        }


        manager.closeConn();
    }


}

