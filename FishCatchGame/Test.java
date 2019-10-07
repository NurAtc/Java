import java.util.Random;

public class Test
{
   public static void main(String[] args)
   {
      OyunMotoru nesne = new OyunMotoru(12,10); //oyun motoru tipinde bir nesne oluşturduk ve parametre olarak liste boyutunu ve oyun süresini verdik
	  
	  Random generator = new Random(); //random sayı üretmek için
	  
	  int random , random2 , random3 , random4 , random5 , random6 , rand6 , random7 , random8 , random9 , random10 , random11 , random12; //????????????????????????????????????????? maindeyiz diye mi private yok
	  //listede tutulacak olan oyunNesnesinden türeyen hamsi , yunus veya karabatak nesnelerini oluşturup listeye ekledik
	  for(int i= 0 ; i<10 ; i++){
	  
		//konum ve hızlar için random sayı atama
		random = generator.nextInt(21);
		random2 = generator.nextInt(11);
		random7 = generator.nextInt(5);
		random8 = generator.nextInt(5); 
		
		Hamsi h = new Hamsi("Hamsi" + (i+1) ,random , random2 , random7 , random8);
		nesne.oyunNesnesiEkle(h); 
	  }
	  
	  //konum ve hızlar için random sayı atama
	  random3 = generator.nextInt(21);
	  random4 = generator.nextInt(13);
	  random9 = generator.nextInt(5);
	  random10 = generator.nextInt(5);
	  
	  Yunus y = new Yunus("Yunus", random3 , random4 , random9 , random10 , 0);
	  nesne.oyunNesnesiEkle(y);
	  
	  //konum ve hızlar için random sayı atama
	  random5 = generator.nextInt(21);
	  random6 = generator.nextInt(16); 
	  rand6 = random6 + 5;
	  random11 = generator.nextInt(5);
	  random12 = generator.nextInt(5);
	  
	  Karabatak k = new Karabatak("Karabatak", random5 , rand6 , random11 , random12 ,0);
	  nesne.oyunNesnesiEkle(k);
	  
	  //oyunu başlatmak için oyunuBaşlat fonksiyonunu çağırdık
	  nesne.oyunuBaslat();	 
   }
}
