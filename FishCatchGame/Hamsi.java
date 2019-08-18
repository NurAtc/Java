public class Hamsi extends OyunNesnesi
{
	//constructor
    public Hamsi(String eAd, int eXKoordinati, int eYKoordinati, int eXHizi, int eYHizi)
    {
       super(eAd,eXKoordinati,eYKoordinati,eXHizi,eYHizi);
    }

	//hamsi nesnesini soruda verilen sınırlara göre hareket ettirir , sınırı aşacağı zaman ters yönde hareket etmesini sağlar(hızı tersyöne çevirerek)
    public void hareketEt()
    {
	    if((xKoordinati + xHizi)< 0 || (xKoordinati + xHizi) > 2)
			xHizi = (-1) * xHizi;
		    
		if((yKoordinati + yHizi) < 0 || (yKoordinati + yHizi) > 10)
			yHizi = (-1) * yHizi;
		
		//koordinatları günceller
		xKoordinati = xKoordinati + xHizi;
		yKoordinati = yKoordinati + yHizi;			
	}
}
