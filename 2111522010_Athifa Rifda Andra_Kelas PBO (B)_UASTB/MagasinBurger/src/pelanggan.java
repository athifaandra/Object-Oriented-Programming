import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.zip.DataFormatException;
import java.sql.*;

public class pelanggan extends burger{ //inhiritance

    String url = "jdbc:mysql://localhost:3306/magasinburger"; //koneksi ke database
    String namaPelanggan;
    Integer nomorPembelian,hargatotal;

     public pelanggan(Integer id, String varian, String ukuran, Integer harga, String status, String namaPelanggan, Integer nomorPembelian) { //constructor
        super(id, varian, ukuran, harga, status); //super
        this.namaPelanggan = namaPelanggan;
        this.nomorPembelian = nomorPembelian;
    }


    @Override
    public void pelanggan(){
        System.out.print("Masukan Nama Pembeli\t:");
        namaPelanggan = input.next();
        System.out.print("Masukan Nomor Pembelian\t:");
        nomorPembelian = input.nextInt();
    }

    @Override
    public void totalharga(){
        System.out.println("NOTE : Ada diskon khusus Burger dengan ID 1-4 mendapatkan diskon 10%");
        System.out.println("Masukan ID Burger yang akan dibeli :");
        id = input.nextInt();
        switch(id){ //percabangan
        case 1 :
        hargatotal = (int) (harga*0.90); //proses matematika
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        case 2 :
        hargatotal = (int) (harga*0.90); //proses matematika
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        case 3 :
        hargatotal = (int) (harga*0.90);
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        case 4 :
        hargatotal = (int) (harga*0.90);
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        case 5 :
        hargatotal = harga;
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        case 6 :
        hargatotal = harga;
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        case 7 :
        hargatotal = harga;
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        case 8 :
        hargatotal = harga;
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        default :
        System.out.println("Stok Burger saat ini hanya 8!");
        break;
        }

    }

    public String tglPembelian() { //method string and date
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public void insertDBPelanggan() throws SQLException{ //CRUD
        String sql = "INSERT INTO pembeli (no_pembelian,nama_pembeli,id_burger,varian,ukuran,hargatotal,tgl) VALUES ('"+nomorPembelian+"','"+namaPelanggan+"', '"+id+"','"+varian+"','"+ukuran+"','"+hargatotal+"','"+tglPembelian()+"')";
        con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        statement.execute(sql);
        System.out.println("\nDATA BERHASIL DI INPUT !!!");
    }
    
    public void Show1() throws SQLException{ //CRUD
        String sql = "SELECT id_burger, varian, ukuran, harga, status FROM data_mobil";
        con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while(result.next()){ //perulangan
            System.out.println("\n");
            System.out.print("Id Burger\t :\t");
            System.out.print(result.getInt("id_burger"));
            System.out.print("\nVarian Burger\t:\t");
            System.out.print(result.getString("varian"));
            System.out.print("\nUkuran Burger\t:\t");
            System.out.print(result.getString("ukuran"));
            System.out.print("\nHarga Burger\t:\t");
            System.out.print(result.getInt("harga"));
            System.out.print("\nStatus Burger\t:\t");
            System.out.print(result.getString("status"));
           
        }
    }

    public void Show2() throws SQLException{ //CRUD
        String sql = "SELECT no_pembelian, nama_pembeli, id_burger, ukuran, hargatotal, tgl FROM pembeli";
        con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while(result.next()){ //perulangan
            System.out.println("\n");
            System.out.print("Nomor Pembelian\t:\t");
            System.out.print(result.getInt("no_pembelian"));
            System.out.print("\nNama Pembeli\t:\t");
            System.out.print(result.getString("nama_pembeli"));
            System.out.print("\nID Burger\t:\t");
            System.out.print(result.getInt("id_burger"));
            System.out.print("\nUkuran Burger\t:\t");
            System.out.print(result.getString("ukuran"));
            System.out.print("\nHarga total\t:\t");
            System.out.print(result.getString("hargatotal"));
            System.out.print("\nTanggal Pembelian\t:\t");
            System.out.print(result.getString("tgl"));
        }
    }

    public void ubah() throws SQLException{ //CRUD
        try {
            System.out.print("\nMasukkan ID Burger untuk mengubah data burger: ");
            id = 0;
            id = input.nextInt();
            input.nextLine();

            String sql = "SELECT id_burger, varian, ukuran, harga, status FROM data_mobil  WHERE id_mobil = '"+id+"'"; //menampilkan 
            con = DriverManager.getConnection(url,"root","");
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
        
            if (result.next()){
                System.out.print("Id burger ["+result.getInt("id_burger")+"]\t :");
                id = input.nextInt();

                System.out.print("Varian Burger ["+result.getString("varian")+"]\t :");
                varian = input.next();

                System.out.print("Ukuran Burger["+result.getString("ukuran")+"]\t :");
                ukuran = input.next();

                System.out.print("Harga ["+result.getString("harga")+"]\t :");
                harga = input.nextInt();

                System.out.print("Status Burger ["+result.getString("status")+"]\t :");
                status = input.next();

                sql = "UPDATE data_mobil SET id_burger ='"+id+"', varian='"+varian+"', ukuran='"+ukuran+"', harga='"+harga+"', status='"+status+"' WHERE id_burger='"+id+"'";
                
                if(statement.executeUpdate(sql) > 0){ //nilai menjadi = 1 berarti  sudah berhasil diubah
                    System.out.println("Berhasil memperbaharui data ");
                }
            }
            statement.close();        //menutup statement
        } catch (SQLException e) { //exception untuk kesalahan dalam database
            System.err.println("Terjadi kesalahan dalam mengedit data");
            System.err.println(e.getMessage());
        }

    }

    public void search() throws SQLException{ //CRUD
        System.out.println("Mencari data burger berdasarkan ukuran");
				
		System.out.print("\nMasukkan Ukuran burger yang ingin di cek : ");    
		String keyword = input.nextLine();
		
		String sql = "SELECT * FROM data_mobil WHERE merk LIKE '%"+keyword+"%'";
		con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql); 
                
        while(result.next()){ //perulangan
        	System.out.print("\nID Burger\t  : ");
            System.out.print(result.getInt("id_burger"));
            System.out.print("\nVarian Burger\t  : ");
            System.out.print(result.getString("varian"));
            System.out.print("\nUkuran Burger\t : ");
            System.out.print(result.getString("ukuran"));
            System.out.print("\nHarga Burger\t : ");
            System.out.print(result.getInt("harga"));
            System.out.print("\nStatus\t  : ");
            System.out.print(result.getString("status"));
            System.out.print("\n");
        }
	}   
    

    public void delete() { //CRUD
		String text4 = "\nHapus Daftar Burger yang telah dibeli";
		System.out.println(text4.toUpperCase());
		
		try{
	        System.out.print("\nMasukan ID Burger yang akan dihapus : ");
	        Integer id = Integer.parseInt(input.nextLine());
	        
	        String sql = "DELETE FROM data_mobil WHERE id_burger = "+id;
	        con = DriverManager.getConnection(url,"root","");
	        Statement statement = con.createStatement();
	        
	        if(statement.executeUpdate(sql) > 0){
	            System.out.println("Berhasil menghapus data");
	        }
	   }
		catch(SQLException e){ //exception saat data gagal disambungkan
	        System.out.println("Terjadi kesalahan dalam menghapus data");
	    }
        catch(Exception e){ //exception errorhandling
            System.out.println("masukan data yang benar");
        }
	}

}
