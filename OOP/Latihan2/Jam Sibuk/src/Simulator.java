public class Simulator {
    public static void main(String[] args){
    
        int totalJamSibuk;
        Asdos a = new Asdos(" Fairuzikun ", 21, 10 ); 
        Elemen b = new Asdos(" Angel-chan ", 20, 4); //Upcasting
        Dosen c = new Dosen(" Raja OP Damanik ", 5); 
        Elemen d = new Dosen(" Nivotko ", 3); //Upcasting
        Mahasiswa e = new Mahasiswa(" Firman ", 20); 
        Elemen f = new Mahasiswa(" Nid to pass this sem ", 23); //Upcasting
        
        a.mailCheck();
        c.mailCheck();
        b.mailCheck();
        e.mailCheck();
        f.mailCheck();
        d.mailCheck();

        totalJamSibuk = a.getJamSibuk() + b.getJamSibuk() + c.getJamSibuk() + d.getJamSibuk() + e.getJamSibuk() + f.getJamSibuk();
        System.out.println(" Total jam sibuk elemen Fasilkom adalah " + totalJamSibuk);

    } 
        
}
