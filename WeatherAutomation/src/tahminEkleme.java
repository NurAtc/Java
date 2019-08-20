//gerekli java paketlerini import ediyoruz
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by manager on 22.5.2016.
 */
public class tahminEkleme {
    //değişkenler
    public JPanel eklemePaneli;
    private JComboBox bolgelerCB;
    private JTextField tarih;
    private JTextField iller;
    private JPanel bolgePaneli;
    private JLabel bolgeLabel;
    private JPanel tarihPaneli;
    private JLabel tarihLabel;
    private JPanel ilPaneli;
    private JLabel ilLabel;
    private JPanel hava_durumuPaneli;
    private JPanel tahminEklePaneli;
    private JPanel kaydetPaneli;
    private JComboBox tahminCB;
    private JTextField minSic;
    private JTextField maxSic;
    private JButton kaydet;
    private JLabel secilen_il;
    private JLabel hava_durumu;
    private JLabel h_d_image;
    private JLabel minSicaklik;
    private JLabel maxSicaklik;
    private JList ilList;

    //constructor
    public tahminEkleme() {

        //illeri tutan string tipindeki diziler
        String[] marmara_iller = {"Edirne","Kırklareli","Tekirdağ","İstanbul","Kocaeli","Yalova",
                "Sakarya","Bilecik","Bursa","Balıkesir","Çanakkale"};
        String[] ege_iller = {"İzmir", "Manisa", "Aydın","Denizli","Kütahya","Afyonkarahisar","Uşak","Muğla"};
        String[] iç_anadolu_iller = {"Aksaray", "Ankara", "Çankırı" , "Eskişehir","Karaman","Kırıkkale",
                "Kırşehir","Konya","Nevşehir","Niğde","Sivas","Yozgat","Kayseri"};
        String[] akdeniz_iller = {"Adana", "Osmaniye", "Antalya","Burdur","Hatay","Isparta","İçel","Kahramanmaraş"};
        String[] guney_d_a_iller = {"Adıyaman", "Batman", "Diyarbakır","Gaziantep"};
        String[] dogu_a_iller = {"Ağrı", "Ardahan", "Bingöl","Bitlis","Elazığ","Erzincan","Erzurum",
                "Hakkari","Iğdır","Kars","Malatya","Muş","Tunceli","Van","Şırnak"};
        String[] karadeniz_iller = {"Rize", "Trabzon", "Artvin", "Sinop", "Tokat", "Çorum", "Amasya", "Samsun", "Zonguldak",
                "Bolu", "Düzce", "Karabük", "Bartın", "Kastamonu", "Bayburt", "Giresun", "Gümüşhane", "Ordu"};

        //form ilk açıldıgında combo box'da marmara bölgesi default olarak gözüktüğünden
        // illeri tutan Jlist ' de da default olarak marmara bölgesinin illlerinin gözükmesi için
        ilList.setListData(marmara_iller);
        ilList.setVisible(true);

        //resmler için icon oluşturduk
        ImageIcon icon1 = new ImageIcon("cloudy.png");
        ImageIcon icon2 = new ImageIcon("m-cloudy.png");
        ImageIcon icon3 = new ImageIcon("rainy.png");
        ImageIcon icon4 = new ImageIcon("rainy-snow.png");
        ImageIcon icon5 = new ImageIcon("snow.png");
        ImageIcon icon6 = new ImageIcon("t-storm-rain.png");
        ImageIcon icon7 = new ImageIcon("wind.png");
        ImageIcon icon8 = new ImageIcon("sunny.png");
        h_d_image.setIcon(icon1);//form ilk açıldıgında bulutlu hava durumu iconu görüntülenmesi için

        //bölgelerin tutulduğu combo box için action listener ekledik
        bolgelerCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String secilenBolge  = (String) bolgelerCB.getSelectedItem();//combobox da seçilen bölgeyi string bir değişkene atadık

                //seçilen bölge Marmara Bölgesi ise illeri tutan Jlist ' e Marmara bölgesinin arrayini set ettik
                if(secilenBolge.equals("Marmara Bölgesi")){
                    ilList.setListData(marmara_iller);
                    ilList.setVisible(true);
                }
                //seçilen bölge Ege Bölgesi ise illeri tutan Jlist ' e Ege bölgesinin arrayini set ettik
                else if(secilenBolge.equals("Ege Bölgesi")){
                    ilList.setListData(ege_iller);
                    ilList.setVisible(true);
                }
                //seçilen bölge İç Anadolu Bölgesi ise illeri tutan Jlist ' e İç Anadolu bölgesinin arrayini set ettik
                else if(secilenBolge.equals("İç Anadolu Bölgesi")){
                    ilList.setListData(iç_anadolu_iller);
                    ilList.setVisible(true);
                }
                //seçilen bölge Akdeniz Bölgesi ise illeri tutan Jlist ' e Akdeniz bölgesinin arrayini set ettik
                else if(secilenBolge.equals("Akdeniz Bölgesi")){
                    ilList.setListData(akdeniz_iller);
                    ilList.setVisible(true);
                }
                //seçilen bölge Güney Doğu Anadolu Bölgesi ise illeri tutan Jlist ' e Güney doğu anadolu bölgesinin arrayini set ettik
                else if(secilenBolge.equals("Güneydoğu Anadolu Bölgesi")){
                    ilList.setListData(guney_d_a_iller);
                    ilList.setVisible(true);
                }
                //seçilen bölge Doğu Anadolu Bölgesi ise illeri tutan Jlist ' e doğu anadolu bölgesinin arrayini set ettik
                else if(secilenBolge.equals("Doğu Anadolu Bölgesi")){
                    ilList.setListData(dogu_a_iller);
                    ilList.setVisible(true);
                }
                //seçilen bölge Karadeniz Bölgesi ise illeri tutan Jlist ' e Karadeniz bölgesinin arrayini set ettik
                else{
                    ilList.setListData(karadeniz_iller);
                    ilList.setVisible(true);
                }

            }
        });

        //seçtiğimiz hava durumunu tutan combobox için action listener ekledik
        tahminCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String secilen = (String) tahminCB.getSelectedItem();//seçilen hava durumunu string bir değişkene atadık

                //hava durumu bulutlu olarak seçildiyse buna uygun olan resmi h_d_image labelına set ettik
                if(secilen.equals("Bulutlu")){
                    h_d_image.setIcon(icon1);
                }
                //hava durumu parçalı bulutlu olarak seçildiyse buna uygun olan resmi h_d_image labelına set ettik
                if(secilen.equals("Parçalı Bulutlu")){
                    h_d_image.setIcon(icon2);
                }
                //hava durumu yağmurlu olarak seçildiyse buna uygun olan resmi h_d_image labelına set ettik
                if(secilen.equals("Yağmurlu")){
                    h_d_image.setIcon(icon3);
                }
                //hava durumu karla karışık yağmurlu olarak seçildiyse buna uygun olan resmi h_d_image labelına set ettik
                if(secilen.equals("Karla Karışık Yağmurlu")){
                    h_d_image.setIcon(icon4);
                }
                //hava durumu kar yağışlı olarak seçildiyse buna uygun olan resmi h_d_image labelına set ettik
                if(secilen.equals("Kar Yağışlı")){
                    h_d_image.setIcon(icon5);
                }
                //hava durumu sağanak yağmurlu olarak seçildiyse buna uygun olan resmi h_d_image labelına set ettik
                if(secilen.equals("Sağanak Yağmurlu")){
                    h_d_image.setIcon(icon6);
                }
                //hava durumu rüzgarlı olarak seçildiyse buna uygun olan resmi h_d_image labelına set ettik
                if(secilen.equals("Rüzgarlı")){
                    h_d_image.setIcon(icon7);
                }
                //hava durumu güneşli olarak seçildiyse buna uygun olan resmi h_d_image labelına set ettik
                if(secilen.equals("Güneşli")){
                    h_d_image.setIcon(icon8);
                }
            }
        });

        //kaydet butonu için action listener ekledik
        kaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //seçilen degerlere sahip yeni bir bilgiler nesnesi oluşturduk
                Bilgiler yeni_bolge =  new Bilgiler((String) bolgelerCB.getSelectedItem() , (String)ilList.getSelectedValue() ,
                        tarih.getText() ,minSic.getText() ,maxSic.getText() , (String)tahminCB.getSelectedItem());
                //oluşturduğumuz nesneyi bilgiler tipinde nesne tutan tahminListesi arraylist ine ekledik
                Bilgiler.tahminListesi.add(yeni_bolge);
                //ekle butonuna basıldıktan sonra tahmin ekleme formunun kapanması için
                anaSayfa.frameTahminEkleme.setVisible(false);
            }
        });

        //illeri tutan jlist için list selection listener ekledik
        ilList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) //seçili olan bir il varsa
                {
                    //seçili olan ili secilen_il label'ında büyük harflerle yazacak şekilde gösteriyoruz
                    secilen_il.setText((ilList.getSelectedValue().toString()).toUpperCase());
                }
            }
        });

    }
}
