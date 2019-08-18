abstract public class OyunNesnesi
{
   //de�i�kenler	
   protected String ad;
   protected int xKoordinati;
   protected int yKoordinati;
   protected int xHizi;
   protected int yHizi;
   
   //constructor
   public OyunNesnesi(String eAd, int eXKoordinati, int eYKoordinati, int eXHizi, int eYHizi)
   {
      ad = eAd;
      xKoordinati = eXKoordinati;
      yKoordinati = eYKoordinati;
	  xHizi = eXHizi;
	  yHizi = eYHizi;
   }

   //istenen formatta nesneleri yazd�rmak i�in toString metodu
   public String toString()
   {
      String result = "Name: " + ad + "\t";

      result += "Konum: (" + xKoordinati + " , " + xKoordinati + ")" + "\t";
      result += "H�zlar�: (" + xHizi + " , " + yHizi + ")\n";

      return result;
   }
   
   //bu class dan t�reyen her class i�in farkl� �al��acak olan abstract fonksiyon
   public abstract void hareketEt();
}
