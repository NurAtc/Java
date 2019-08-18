public class Yunus extends OyunNesnesi
{
	//de�i�kenler
    private static int kacHamsiYedi;
    
    //constructor	
    public Yunus(String eAd, int eXKoordinati, int eYKoordinati, int eXHizi, int eYHizi, int kacYedi)
    {
       super(eAd,eXKoordinati,eYKoordinati,eXHizi,eYHizi);

       kacHamsiYedi = kacYedi; 
    }

	//nesneleri istenen formatta yazd�rmak i�in
    public String toString()
    {
       String result = super.toString();

       result += "\tKa� tane hamsi yedi�i: " + kacHamsiYedi + "\n";

       return result;
    }
   
    //yunusun yedi�i hamsi say�s�n� bir art�r�r
    public static void Yemek()
	{
	   kacHamsiYedi++;
    }
 
    //yunus nesnesini soruda verilen s�n�rlara g�re hareket ettirir , s�n�r� a�aca�� zaman ters y�nde hareket etmesini sa�lar(h�z� tersy�ne �evirerek)
    public void hareketEt()
    {
	    if((xKoordinati + xHizi)< 0 || (xKoordinati + xHizi) > 20 )
			xHizi = (-1) * xHizi;
		    
		if((yKoordinati + yHizi) < 0 || (yKoordinati + yHizi) > 12)
			yHizi = (-1) * yHizi;
		
		//koordinatlar� g�nceller
		xKoordinati = xKoordinati + xHizi;
		yKoordinati = yKoordinati + yHizi;			
	}
}