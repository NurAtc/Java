public class Karabatak extends OyunNesnesi
{
	//deðiþkenler
    private static int kacHamsiYedi;
   
    //constructor
    public Karabatak(String eAd, int eXKoordinati, int eYKoordinati, int eXHizi, int eYHizi, int kacYedi)
    {
       super(eAd,eXKoordinati,eYKoordinati,eXHizi,eYHizi);

       kacHamsiYedi = kacYedi;
      
    }

	//nesneleri istenen formatta yazdýrmak için
    public String toString()
    {
       String result = super.toString();

       result += "\tKaç tane hamsi yediði: " + kacHamsiYedi + "\n";

       return result;
    }
   
    //karabataðýn yediði hamsi sayýsýný bir artýrýr
    public static void Yemek()
	{
	   kacHamsiYedi++;
    }

	//karabatak nesnesini soruda verilen sýnýrlara göre hareket ettirir , sýnýrý aþacaðý zaman ters yönde hareket etmesini saðlar(hýzý tersyöne çevirerek)
	public void hareketEt()
    {
	    if((xKoordinati + xHizi)< 0 || (xKoordinati + xHizi) > 20)
			xHizi = (-1) * xHizi;
		    
		if((yKoordinati + yHizi) < 5 ||(yKoordinati + yHizi) > 20)
			yHizi = (-1) * yHizi;
		
		//koordinatlarý günceller
		xKoordinati = xKoordinati + xHizi;
		yKoordinati = yKoordinati + yHizi;		
	}	
}