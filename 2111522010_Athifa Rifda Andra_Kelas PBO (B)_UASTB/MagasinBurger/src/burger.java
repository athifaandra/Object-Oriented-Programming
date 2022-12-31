import java.util.Scanner;
import java.sql.*;

public class burger implements magasinBurger{ //interface
    static Connection con;
    String url = "jdbc:mysql://localhost:3306/magasinburger";
    String varian,ukuran,status;
    Integer id,harga;
    Scanner input = new Scanner(System.in);

    public burger(Integer id, String varian, String ukuran, Integer harga, String status){
        this.id = id;
        this.varian = varian;
        this.ukuran = ukuran;
        this.harga = harga;
        this.status = status;
    } //constructor
    
    @Override
    public void idBurger(){
        System.out.print("Masukan ID Burger\t:");
        id = input.nextInt();
    }

    @Override
    public void varianBurger(){
        System.out.print("Masukan Varian Burger\t:");
        varian = input.next();
    }

    @Override
    public void ukuranBurger(){
        System.out.print("Masukan Ukuran Burger\t:");
        ukuran = input.next();
    }
    
    @Override
    public void Harga(){
        System.out.print("Masukan Harga Burger\t:");
        harga = input.nextInt();
    }

    @Override
    public void statusBurger(){
        System.out.print("Status Burger adalah\t:");
        status = input.next();
    }

    public void totalharga(){}

    public void pelanggan(){}

    public void InsertDbBurger() throws SQLException{
        String sql = "INSERT INTO data_mobil (id_burger,varian,ukuran,harga,status) VALUES ('"+id+"', '"+varian+"','"+ukuran+"','"+harga+"','"+status+"')";
        con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        statement.execute(sql);   
        System.out.println("\nDATA BERHASIL DI INPUT !!!"); 
    }
}
