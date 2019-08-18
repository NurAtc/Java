public class Karabatak extends OyunNesnesi
{
	//de�i�kenler
    private static int kacHamsiYedi;
   
    //constructor
    public Karabatak(String eAd, int eXKoordinati, int eYKoordinati, int eXHizi, int eYHizi, int kacYedi)
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
   
    //karabata��n yedi�i hamsi say�s�n� bir art�r�r
    public static void Yemek()
	{
	   kacHamsiYedi++;
    }

	//karabatak nesnesini soruda verilen s�n�rlara g�re hareket ettirir , s�n�r� a�aca�� zaman ters y�nde hareket etmesini sa�lar(h�z� tersy�ne �evirerek)
	public void hareketEt()
    {
	    if((xKoordinati + xHizi)< 0 || (xKoordinati + xHizi) > 20)
			xHizi = (-1) * xHizi;
		    
		if((yKoordinati + yHizi) < 5 ||(yKoordinati + yHizi) > 20)
			yHizi = (-1) * yHizi;
		
		//koordinatlar� g�nceller
		xKoordinati = xKoordinati + xHizi;
		yKoordinati = yKoordinati + yHizi;		
	}	
}