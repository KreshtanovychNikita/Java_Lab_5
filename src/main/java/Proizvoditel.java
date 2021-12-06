
import java.util.*;
import java.util.Objects;

public class Proizvoditel implements Comparable <Proizvoditel>{

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proizvoditel)) return false;
        Proizvoditel that = (Proizvoditel) o;
        return id == that.id && Objects.equals(Name, that.Name) && Objects.equals(PhoneNumber, that.PhoneNumber) && Objects.equals(Country, that.Country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name, PhoneNumber, Country);
    }

    /*public static void main(String[] args) throws SQLException{

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
        /*Collection<Proizvoditel> proizvoditels = manager.selectAll();
        for(Proizvoditel proizvoditel: proizvoditels){

            System.out.println(proizvoditel);
        }


        manager.closeConn();
    }*/

    public void sortByPrice(List<Proizvoditel> list){
        Collections.sort(list, new NewComparableProizvoditel());
    }

    public Detal MaxDetalPrice(List<Detal> list){
        Detal res = null;
        float temp = list.get(0).getPrice();
        for(int i=1;i<list.size();i++){
            if(list.get(i).getPrice() > temp){
                res = list.get(i);
            }
        }

        return res;
    }
    public List<Detal> viewProizvoditel(List<Detal> list, int idProizvoditel){
        List<Detal> result = new ArrayList<Detal>();

        for(int i = 0; i < list.size();i++){
            if(list.get(i).getIdProivoditel() == idProizvoditel){
                result.add(list.get(i));
            }
        }

        return result;
    }

    //вивід списку працівників
    public void printList(List<Detal> list){

        for(int i = 0; i < list.size();i++){
            System.out.println(list.get(i));
        }
    }

    @Override
    public int compareTo(Proizvoditel o) {
        if(id>o.id){
            return 1;
        }else if(id<o.id){
            return -1;
        }
        else return 0;
    }
    //вивід списку деталей
    public void printfList(List<Detal> list){

        for(int i = 0; i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}

