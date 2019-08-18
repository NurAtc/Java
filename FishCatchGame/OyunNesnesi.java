abstract public class OyunNesnesi
{
   //deðiþkenler	
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

   //istenen formatta nesneleri yazdýrmak için toString metodu
   public String toString()
   {
      String result = "Name: " + ad + "\t";

      result += "Konum: (" + xKoordinati + " , " + xKoordinati + ")" + "\t";
      result += "Hýzlarý: (" + xHizi + " , " + yHizi + ")\n";

      return result;
   }
   
   //bu class dan türeyen her class için farklý çalýþacak olan abstract fonksiyon
   public abstract void hareketEt();
}
