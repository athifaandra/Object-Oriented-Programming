import java.sql.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class program {
    static Connection con;
    public static void main(String[] args) throws Exception {
        pelanggan beli = new pelanggan(0, null, null, 0, null, null, 0); //panggil class dan constructor
        Scanner input = new Scanner(System.in);
        boolean lanjutkan = true;
        int pilihan;
        int a = 0;

        Date datenow = new Date(); //String and date
		SimpleDateFormat tgl = new SimpleDateFormat("E, dd/MM/yyyy");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss zzz");

        String url = "jdbc:mysql://localhost:3306/magasinburger";
        try {
            
			System.out.println("Tanggal \t: " + tgl.format(datenow));
			System.out.println("Waktu \t\t: " + time.format(datenow));
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","");
            System.out.println("Database Berhasil Terhubung!");


            while (lanjutkan){
                System.out.println("");
                System.out.println("========================================");
                System.out.println("    PROGRAM KASIR MAGASIN BURGER        ");
                System.out.println("=========================================");
                System.out.println("1. Antrian Pelanggan");
                System.out.println("2. Cek Menu Burger"); 
                System.out.println("3. Pembelian Burger");
                System.out.println("4. Edit Burger");
                System.out.println("5. Cek Data Pembelian"); 
                System.out.println("6. Hapus Data Burger");
                System.out.println("7. Cari Burger");
                System.out.println("8. Exit Program");
                System.out.println("=========================================");
                System.out.println("");
                System.out.print("Masukkan Pilihan : ");
                pilihan = input.nextInt();

            switch (pilihan){ //percabangan
                case 1 : 
                antrian antrian = new antrian(5);
                antrian.CreateQueue();
                antrian.displayQue();
                a++;
                break;

                case 2 : 
                beli.Show1();
                break;

                case 3 : 
                beli.pelanggan();
                beli.totalharga();
                beli.tglPembelian();
                beli.insertDBPelanggan();
                break;   

                case 4 :
                beli.Show1();
                beli.ubah();
                break;

                case 5 :
                beli.Show2();
                break;

                case 6 :
                beli.Show1();
                beli.delete();
                break;

                case 7 :
                beli.search();
                break;

                case 8 :
                System.exit(0);
                break;

                default :
                System.out.println("Inputan Salah!!");
                break;
                    
            }

            }

        }catch(ClassNotFoundException ex) {
            System.err.println("Driver eror");
            System.exit(0);
        }
        catch(SQLException e){ //exception
            System.err.println("Tidak berhasil Terkoneksi");
        }
        
                
       }
    }
