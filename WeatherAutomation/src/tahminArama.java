//gerekli java paketlerini import ediyoruz
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by manager on 22.5.2016.
 */
public class tahminArama {
    //değişkenler
    public JPanel aramaPaneli;
    private JComboBox bolgeCB;
    private JComboBox sehirCB;
    private JTextField basTF;
    private JTextField bitisTF;
    private JButton arama;
    private JTable h_d_tablosu;
    private JPanel secimPaneli;
    private JLabel bolge;
    private JLabel sehir;
    private JLabel baslangıc_tarihi;
    private JLabel bitis_tarihi;
    private JScrollPane scrollPane1;

    //constructor
    public tahminArama() {

        //bölgelere ait illerin tutulduğu string tipindeki arrayler
        String[] marmara_iller = {"Edirne", "Kırklareli", "Tekirdağ", "İstanbul", "Kocaeli", "Yalova",
                "Sakarya", "Bilecik", "Bursa", "Balıkesir", "Çanakkale"};
        String[] ege_iller = {"İzmir", "Manisa", "Aydın", "Denizli", "Kütahya", "Afyonkarahisar", "Uşak", "Muğla"};
        String[] ic_anadolu_iller = {"Aksaray", "Ankara", "Çankırı", "Eskişehir", "Karaman", "Kırıkkale",
                "Kırşehir", "Konya", "Nevşehir", "Niğde", "Sivas", "Yozgat", "Kayseri"};
        String[] akdeniz_iller = {"Adana", "Osmaniye", "Antalya", "Burdur", "Hatay", "Isparta", "İçel", "Kahramanmaraş"};
        String[] guney_d_a_iller = {"Adıyaman", "Batman", "Diyarbakır", "Gaziantep"};
        String[] dogu_a_iller = {"Ağrı", "Ardahan", "Bingöl", "Bitlis", "Elazığ", "Erzincan", "Erzurum",
                "Hakkari", "Iğdır", "Kars", "Malatya", "Muş", "Tunceli", "Van", "Şırnak"};
        String[] karadeniz_iller = {"Rize", "Trabzon", "Artvin", "Sinop", "Tokat", "Çorum", "Amasya", "Samsun", "Zonguldak",
                "Bolu", "Düzce", "Karabük", "Bartın", "Kastamonu", "Bayburt", "Giresun", "Gümüşhane", "Ordu"};

        //form ilk açıldıgında combo box'da marmara bölgesi default olarak gözüktüğünden
        // illeri tutan combobox ' da da default olarak marmara bölgesinin illlerinin gözükmesi için
        DefaultComboBoxModel comboboxmodel = new DefaultComboBoxModel(marmara_iller);
        sehirCB.setModel(comboboxmodel);
        sehirCB.setVisible(true);

        //tablo için model oluşturduk
        DefaultTableModel dtm = new DefaultTableModel(){
            //tablodaki 1. column da image görüntüleyebilmek için getColumnClass ını override ettik
        @Override
        public Class getColumnClass(int column)
        {
            if (column == 1) return ImageIcon.class;
            return Object.class;
        }};

        //tablo başlıklarını ekledik
        dtm.addColumn("Tarih");
        dtm.addColumn("Hava Durumu");
        dtm.addColumn("En Düşük Sıcaklık");
        dtm.addColumn("En Yüksek Sıcaklık");

        //tabloya oluşturduğumuz modeli set ettik
        h_d_tablosu.setModel(dtm);

        //bölgelerin tutulduğu combo box için action listener ekledik
        bolgeCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //combobox da seçilen bölgeyi string bir değişkene atadık
                String secilenBolge = (String) bolgeCB.getSelectedItem();

                //seçilen bölge Marmara Bölgesi ise illeri tutan combobox ' a Marmara bölgesinin arrayini set ettik
                if (secilenBolge.equals("Marmara Bölgesi")) {
                    ComboBoxModel illermodel = new DefaultComboBoxModel(marmara_iller);
                    sehirCB.setModel(illermodel);
                }

                //seçilen bölge Ege Bölgesi ise illeri tutan combobox ' a Ege bölgesinin arrayini set ettik
                else if (secilenBolge.equals("Ege Bölgesi")) {
                    ComboBoxModel illermodel = new DefaultComboBoxModel(ege_iller);
                    sehirCB.setModel(illermodel);
                }

                //seçilen bölge İç Anadolu Bölgesi ise illeri tutan combobox ' a İç Anadolu bölgesinin arrayini set ettik
                else if (secilenBolge.equals("İç Anadolu Bölgesi")) {
                    ComboBoxModel illermodel = new DefaultComboBoxModel(ic_anadolu_iller);
                    sehirCB.setModel(illermodel);
                }

                //seçilen bölge Akdeniz Bölgesi ise illeri tutan combobox ' a Akdeniz bölgesinin arrayini set ettik
                else if (secilenBolge.equals("Akdeniz Bölgesi")) {
                    ComboBoxModel illermodel = new DefaultComboBoxModel(akdeniz_iller);
                    sehirCB.setModel(illermodel);
                }

                //seçilen bölge Güneydoğu Anadolu Bölgesi ise illeri tutan combobox ' a Güneydoğu Anadolu bölgesinin arrayini set ettik
                else if (secilenBolge.equals("Güneydoğu Anadolu Bölgesi")) {
                    ComboBoxModel illermodel = new DefaultComboBoxModel(guney_d_a_iller);
                    sehirCB.setModel(illermodel);
                }

                //seçilen bölge Doğu Anadolu Bölgesi ise illeri tutan combobox ' a Doğu Anadolu bölgesinin arrayini set ettik
                else if (secilenBolge.equals("Doğu Anadolu Bölgesi")) {
                    ComboBoxModel illermodel = new DefaultComboBoxModel(dogu_a_iller);
                    sehirCB.setModel(illermodel);
                }

                //seçilen bölge Karadeniz Bölgesi ise illeri tutan combobox ' a Karadeniz bölgesinin arrayini set ettik
                else {
                    ComboBoxModel illermodel = new DefaultComboBoxModel(karadeniz_iller);
                    sehirCB.setModel(illermodel);
                }
            }
        });

        //arama butonu için action listener oluşturduk
        arama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //aranmak istenen bilgileri alıp değişkenlere atadık
                String aranan_bolge = (String) bolgeCB.getSelectedItem();
                String aranan_sehir = (String) sehirCB.getSelectedItem();
                String baslangıc_tarihi = basTF.getText();
                String bitis_tarihi = bitisTF.getText();

                //yukarda oluşturduğumuz tablonun modelini get ile aldık
                DefaultTableModel model = (DefaultTableModel) h_d_tablosu.getModel();

                //arama butnuna her basıldığında tablo içinde kalan eski rowları silme işi:
                int rows = model.getRowCount();
                for (int i = rows - 1; i >= 0; i--) {
                    model.removeRow(i);
                }

                //yukarda aldığımız değişkenler ile eklenen bilgieri tutan arraylist imizde eşleşen bir hava durumu tahmini var mı diye bakıyoruz
                for (Bilgiler item : Bilgiler.tahminListesi)
                    if (item.getBolge_adi().equals(aranan_bolge) && item.getIl_adi().equals(aranan_sehir) &&
                            (item.getTarih().compareTo(baslangıc_tarihi) >= 0) && (item.getTarih().compareTo(bitis_tarihi) <= 0)) {

                        //bulunan hava durumu tahmini bulutlu ise ona uygun iconu tabloya eklemek için
                        if (item.getHava_durumu().equals("Bulutlu")) {
                            ImageIcon icon = new ImageIcon("small-cloudy.png");
                            //tabloya row'u ekliyoruz
                            model.addRow(new Object[]{item.getTarih(), icon, item.getMinSicaklik(), item.getMaxSicaklik()});
                            h_d_tablosu.setModel(model);
                            updateRowHeights();//icon boyutuna göre tablo row boyutunu ayarlamak için
                        }

                        //bulunan hava durumu tahmini güneşli ise ona uygun iconu tabloya eklemek için
                        if (item.getHava_durumu().equals("Güneşli")) {
                            ImageIcon icon = new ImageIcon("small-sunny.png");
                            //tabloya row'u ekliyoruz
                            model.addRow(new Object[]{item.getTarih(), icon, item.getMinSicaklik(), item.getMaxSicaklik()});
                            h_d_tablosu.setModel(model);
                            updateRowHeights();//icon boyutuna göre tablo row boyutunu ayarlamak için
                        }

                        //bulunan hava durumu tahmini karla karışık yağmurlu ise ona uygun iconu tabloya eklemek için
                        if (item.getHava_durumu().equals("Karla Karışık Yağmurlu")) {
                            ImageIcon icon = new ImageIcon("small-rainy-snow.png");
                            //tabloya row'u ekliyoruz
                            model.addRow(new Object[]{item.getTarih(), icon, item.getMinSicaklik(), item.getMaxSicaklik()});
                            h_d_tablosu.setModel(model);
                            updateRowHeights();//icon boyutuna göre tablo row boyutunu ayarlamak için
                        }

                        //bulunan hava durumu tahmini kar yağışlı ise ona uygun iconu tabloya eklemek için
                        if (item.getHava_durumu().equals("Kar Yağışlı")) {
                            ImageIcon icon = new ImageIcon("small-snow.png");
                            //tabloya row'u ekliyoruz
                            model.addRow(new Object[]{item.getTarih(), icon, item.getMinSicaklik(), item.getMaxSicaklik()});
                            h_d_tablosu.setModel(model);
                            updateRowHeights();//icon boyutuna göre tablo row boyutunu ayarlamak için
                        }

                        //bulunan hava durumu tahmini parçalı bulutlu ise ona uygun iconu tabloya eklemek için
                        if (item.getHava_durumu().equals("Parçalı Bulutlu")) {
                            ImageIcon icon = new ImageIcon("small-m-cloudy.png");
                            //tabloya row'u ekliyoruz
                            model.addRow(new Object[]{item.getTarih(), icon, item.getMinSicaklik(), item.getMaxSicaklik()});
                            h_d_tablosu.setModel(model);
                            updateRowHeights();//icon boyutuna göre tablo row boyutunu ayarlamak için
                        }

                        //bulunan hava durumu tahmini rüzgarlı ise ona uygun iconu tabloya eklemek için
                        if (item.getHava_durumu().equals("Rüzgarlı")) {
                            ImageIcon icon = new ImageIcon("small-wind.png");
                            //tabloya row'u ekliyoruz
                            model.addRow(new Object[]{item.getTarih(), icon, item.getMinSicaklik(), item.getMaxSicaklik()});
                            h_d_tablosu.setModel(model);
                            updateRowHeights();//icon boyutuna göre tablo row boyutunu ayarlamak için
                        }

                        //bulunan hava durumu tahmini bulutlu ise ona uygun iconu tabloya eklemek için
                        if (item.getHava_durumu().equals("Sağanak Yağmurlu")) {
                            ImageIcon icon = new ImageIcon("small-t-storm-rain.png");
                            //tabloya row'u ekliyoruz
                            model.addRow(new Object[]{item.getTarih(), icon, item.getMinSicaklik(), item.getMaxSicaklik()});
                            h_d_tablosu.setModel(model);
                            updateRowHeights();//icon boyutuna göre tablo row boyutunu ayarlamak için
                        }

                        //bulunan hava durumu tahmini yağmurlu ise ona uygun iconu tabloya eklemek için
                        if (item.getHava_durumu().equals("Yağmurlu")) {
                            ImageIcon icon = new ImageIcon("small-rainy.png");
                            //tabloya row'u ekliyoruz
                            model.addRow(new Object[]{item.getTarih(), icon, item.getMinSicaklik(), item.getMaxSicaklik()});
                            h_d_tablosu.setModel(model);
                            updateRowHeights();//icon boyutuna göre tablo row boyutunu ayarlamak için
                        }

                    }
            }

        });
    }
    //tabloya eklenen icon boyutuna göre tablo row boyutunu ayarlamak için
    private void updateRowHeights()
    {
        try
        {
            for (int row = 0; row < h_d_tablosu.getRowCount(); row++)
            {
                int rowHeight = h_d_tablosu.getRowHeight();

                for (int column = 0; column < h_d_tablosu.getColumnCount(); column++)
                {
                    Component comp = h_d_tablosu.prepareRenderer(h_d_tablosu.getCellRenderer(row, column), row, column);
                    rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
                }
                h_d_tablosu.setRowHeight(row, rowHeight);
            }
        }
        catch(ClassCastException e) {}
    }

}
