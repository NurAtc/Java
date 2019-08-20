//gerekli java paketlerini import ediyoruz
import java.util.ArrayList;

/**
 * Created by manager on 24.5.2016.
 */
public class Bilgiler {
    //değişkenler
    private String bolge_adi;
    private String il_adi;
    private String tarih;
    private String minSicaklik;
    private String maxSicaklik;
    private String hava_durumu;
    public static ArrayList<Bilgiler> tahminListesi = new ArrayList<Bilgiler>();

    //constructor
    public Bilgiler(String bolge_adi ,String il_adi , String tarih , String minSicaklik ,String maxSicaklik , String hava_durumu){
        this.bolge_adi= bolge_adi;
        this.il_adi= il_adi;
        this.tarih= tarih;
        this.minSicaklik=minSicaklik;
        this.maxSicaklik=maxSicaklik;
        this.hava_durumu=hava_durumu;

    }

    //getters:

    public String getBolge_adi(){
        return bolge_adi;
    }

    public String getIl_adi(){
        return il_adi;
    }

    public String getTarih(){
        return tarih;
    }

    public String getMinSicaklik(){
        return minSicaklik;
    }

    public String  getMaxSicaklik(){
        return maxSicaklik;
    }

    public String getHava_durumu(){
        return hava_durumu;
    }

}

