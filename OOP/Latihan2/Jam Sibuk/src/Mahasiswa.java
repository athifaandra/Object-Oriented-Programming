public class Mahasiswa extends Elemen {
    public int SKS;
    public int jamSibuk;

    public Mahasiswa (String nama, int SKS){
       super(nama); //DownCasting
       jamSibuk = SKS * 3;
    } 

    public void mailCheck(){
        System.out.println(getNama() + " adalah seorang mahasiswa dengan jam sibuk " + getJamSibuk());
    }

    public int getJamSibuk(){ //Polymorphism
        return jamSibuk;
    }
}
