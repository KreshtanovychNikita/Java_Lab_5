import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

public class Detal{

    private int id;
    private int idProivoditel;
    private String Name;
    private int Articul;
    private float Price;


    public  Detal(int id,int idProivoditel,String Name,int Articul, float Price){

        this.id = id;

        this.idProivoditel = idProivoditel;

        this.Name = Name;

        this.Articul = Articul;

        this.Price = Price;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProivoditel() {
        return idProivoditel;
    }

    public void setIdProivoditel(int idProivoditel) {
        this.idProivoditel = idProivoditel;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getArticul() {
        return Articul;
    }

    public void setArticul(int articul) {
        Articul = articul;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    @override

    @Override
    public String toString() {
        return "Detal{" +
                "id=" + id +
                ", idProivoditel=" + idProivoditel +
                ", Name='" + Name + '\'' +
                ", Articul=" + Articul +
                ", Price=" + Price +
                '}';
    }

    public static void main(String[] args) throws SQLException{

        Detal a1 = new Detal(1,5,"Koleso",11,8525);
        Detal a2 = new Detal(2,6,"Porshen",12,6823);
        Detal a3 = new Detal(3,7,"Dvygun",13,4580);
        Detal a4 = new Detal(4,5,"Tormoz",14,8570);
        Detal a5 = new Detal(5,7,"Valx1",15,1260);
        Detal a6 = new Detal(6,6,"KolennVan",16,9000);
        Detal a7 = new Detal(7,8,"Svechi",17,4852);
        Detal a8 = new Detal(8,8,"Radiator",18,8595);


        ManagerDetal managerDetal = new ManagerDetal();

        managerDetal.addDetalToTable(a1);
        managerDetal.addDetalToTable(a2);
        managerDetal.addDetalToTable(a3);
        managerDetal.addDetalToTable(a4);
        managerDetal.addDetalToTable(a5);
        managerDetal.addDetalToTable(a6);
        managerDetal.addDetalToTable(a7);
        managerDetal.addDetalToTable(a8);


    //OPERATIONS

        /**
         * Select all Detals
         *
         * */

        Collection<Detal> detals = new ArrayList<Detal>();

        detals = manageDetal.selectAll();
            for (Detal detal: detals){

                System.out.println(detal);

            }

        /**
         * Detal  price more than 8000
         * */

        Collection<Detal> detals = new ArrayList<Detal>();

        detals = managerDetal.selectMorePrice(8000);
            for (Detal detal: detals){
                System.out.println(detal);

            }


        /**
         * Update Detal Price
         *
         * */

        managerDetal.UpdatePrice(5000,3);
        Collection<Detal> detals = new ArrayList<Detal>();

        detals = managerDetal.selectAll();
            for (Detal detal: detals){

                System.out.println(detal);
            }




            managerDetal.closeConn();
    }


}