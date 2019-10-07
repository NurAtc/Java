public class OyunMotoru
{
	//deðiþkenler
    private OyunNesnesi[] nesneList; //oyunNesnelerini tutacak olan array
    private int oyunSuresi;
    private int nesneSayisi;
    private static int count = 0; //array boyutunu tutuyor
   
    //constructor
    public OyunMotoru( int nesneSayisi , int oyunSuresi )
	{
	    this.nesneSayisi = nesneSayisi;
	    this.oyunSuresi = oyunSuresi;
	    nesneList = new OyunNesnesi[nesneSayisi];
    }
   
    //arraye nesne eklemek için , her girildiðinde count bir artar
    public void oyunNesnesiEkle(Object nesne)
	{
	    nesneList[count] = (OyunNesnesi)nesne; 
	    count++;
    }
	
	//arrayden gelen indexdeki nesneyi silmek için
	private void nesneSil(int index , OyunNesnesi list[])  
	{
		for(int i = index ; i < count-1 ; i++){ 
			list[i] = list[i+1]; // gelen indexden baþlayýp birer sola kaydýrýr
		}
		
		list[count-1] = null; // son elemaný null yapar	
	}
    
	//arraydeki nesnelerin konumlarýna göre nesnelerin çarpýþýp çarpýþmadýðýný kontrol etmek için
    public void carpismaKontrol(OyunNesnesi liste[]) 
	{		
		for(int i = 0 ; i < count ; i++)
		{   
			for(int j = i+1 ; j < count ; j++){
			
			    //arraydeki iki elmenýn konum koordinatlarý eþitse ve biri yunus nesnesi diðeri de hamsi nesnesi ise yunus nesnesinin Yemek metodu çaðýrýlýr
				if((liste[i].xKoordinati == liste[j].xKoordinati) && (liste[i].yKoordinati == liste[j].yKoordinati) && (liste[i].ad != liste[j].ad)){
					if(((liste[i] instanceof Hamsi) && (liste[j] instanceof Yunus)) || ((liste[i] instanceof Yunus) && (liste[j] instanceof Hamsi))){ //???????????????????????????????? hem ad hem class adını kontrol etmeye çok gerek var mıydı
						Yunus.Yemek();
						
						//iki nesneden hangisi hamsi nesnesi ise onun için nesneSil metodu çaðýrýlýr
						if(liste[i] instanceof Hamsi){ 
							nesneSil(i,nesneList);   
							count--;
						}
						if(liste[j] instanceof Hamsi){ 
							nesneSil(j,nesneList); 
							count--;
						}
					}
					
					//arraydeki iki elmenýn konum koordinatlarý eþitse ve biri karabatak nesnesi diðeri de hamsi nesnesi ise karabatak nesnesinin Yemek metodu çaðýrýlýr
					if(((liste[i] instanceof Hamsi) && (liste[j] instanceof Karabatak)) || ((liste[i] instanceof Karabatak) && (liste[j] instanceof Hamsi))){
						Karabatak.Yemek();
						
						//iki nesneden hangisi hamsi nesnesi ise onun için nesneSil metodu çaðýrýlýr
						if(liste[i] instanceof Hamsi){
							nesneSil(i,nesneList); 
							count--;                 
						}
						if(liste[j] instanceof Hamsi){
							nesneSil(j,nesneList); 
							count--;
						}
					}				
				}
			}				
		}	
    }
	
    //oyun süresi kadar nesneleri hareket ettirir ve çarpýþma kontrolü yapar. Her saniye için nesneleri tutan arrayi yazdýrýr
	public void oyunuBaslat()
	{
		for(int i = 0 ; i < oyunSuresi ; i++)
		{
			for(int j=0; j < count; j++){
				nesneList[j].hareketEt();
			}

			carpismaKontrol(nesneList);
				
			for(int j=0; j < count; j++){	
				System.out.println(nesneList[j]);  
			}
		}
	}
   
   //arraydeki nesneleri istenen formatta yazdýrmak için
   public String toString()                                 
   { 
		String result="";
			for(int j=0; j < nesneList.length; j++)
				result = nesneList[j].toString() + "\n";
		return result;
   }   
}
