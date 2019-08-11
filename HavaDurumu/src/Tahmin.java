import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by nuria on 29.05.2016.private String bolge;

 */


public class Tahmin // Kaydet butonuna basıldığında tüm bilgileri almak için böyle bir class oluşturdum. Tahmin Ekleme Formundaki tüm bilgileri bu sınıftan türeyen bir nesnede tutup o nesneyi ArrayList'e ekledim.
{
    private static String bolge;         // Tahmin Ekleme Formunda comboBox1'in değeri bolgeye tekabül ediyor.
    private static String sehir;         // Tahmin Ekleme Formunda list1'in değeri bolgeye tekabül ediyor.
    private static String tarih;         // Tahmin Ekleme Formunda textField1'in değeri bolgeye tekabül ediyor.
    private static String havaDurumu;    // Tahmin Ekleme Formunda comboBox2'nin değeri bolgeye tekabül ediyor.
    private static int minSicaklik;      // Tahmin Ekleme Formunda textField2'nin değeri bolgeye tekabül ediyor.
    private static int maxSicaklik;      // Tahmin Ekleme Formunda textField3'ün değeri bolgeye tekabül ediyor.
    public static ArrayList<Tahmin> aList = new ArrayList<>();      // Tahmin tipinde static bir ArrayList oluşturdum böylece diğer 2 class'ta bu ArrayList'i kullanabilcem.

    public Tahmin(String bolge, String sehir, String tarih, String havaDurumu, int minSicaklik, int maxSicaklik)
    {

        this.bolge = bolge;
        this.sehir = sehir;
        this.tarih = tarih;
        this.havaDurumu = havaDurumu;
        this.minSicaklik = minSicaklik;
        this.maxSicaklik = maxSicaklik;

    }


    // Form elemanlarındaki değerleri yani bölge, şehir vs. gibi değerleri alabilmek için static get Metodları yaptım çünkü bölge, şehir vs. private'dı.Bu metodlar sayesinde bu değerlere ulaşabiliyoruz.

    public static String getBolge() {
        return bolge;
    }

    public static String getSehir()
    {
        return sehir;
    }

    public static String getTarih()
    {
        return tarih;
    }

    public static String getHavaDurumu()
    {
        return havaDurumu;
    }

    public static int getMinSicaklik()
    {
        return minSicaklik;
    }

    public static int getMaxSicaklik()
    {
        return maxSicaklik;
    }

    public String toString()
    {
        return bolge + " " + sehir + " " + tarih + " " + havaDurumu + " " + minSicaklik + " " + maxSicaklik;
    }
}