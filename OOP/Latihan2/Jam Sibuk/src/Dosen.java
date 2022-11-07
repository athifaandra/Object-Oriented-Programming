public class Dosen extends Elemen {

    public int jumlahHariKerja;
    private int jamSibuk;

    public Dosen (String nama, int jumlahHariKerja)
    {
        super(nama); //DownCasting
        jamSibuk = jumlahHariKerja * 8; 
    } 

    public void mailCheck()
    {
        System.out.println(getNama() + " adalah seorang dosen dengan jam sibuk " + getJamSibuk());
    }

    public int getJamSibuk() //Polymorphism
    {
        return jamSibuk;
    }
    
}
