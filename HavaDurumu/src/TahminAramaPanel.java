import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * Created by nuria on 29.05.2016.
 */
public class TahminAramaPanel {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private String[] array1 = {"Ankara", "Konya", "Eskişehir", "Çankırı", "Kırıkkale", "Kırşehir", "Aksaray","Niğde", "Karaman", "Yozgat", "Kayseri" };
    private String[] array2 = {"Sinop", "Samsun", "Ordu", "Giresun", "Trabzon", "Rize", "Artvin", "Amasya", "Bartın", "Bayburt", "Bolu", "Gümüşhane", "Kastamonu", "Zonguldak" };
    private String[] array3 = {"Antalya", "Mersin", "Burdur", "Isparta", "Hatay", "Kahramanmaraş", "Karaman", "Adana", "Osmaniye"};
    private String[] array4 = {"İzmir", "Muğla", "Uşak", "Manisa", "Aydın", "Denizli", "Kütahya", "Afyon"};
    private String[] array5 = {"İstanbul", "Edirne", "Kırklareli", "Tekirdağ", "Çanakkale", "Kocaeli", "Yalova", "Sakarya", "Bilecik", "Bursa", "Balıkesir"};
    private String[] array6 = {"Ağrı", "Bingöl", "Bitlis", "Elazığ", "Erzincan", "Erzurum", "Hakkari", "Kars", "Malatya", "Muş", "Tunceli", "Van", "Ardahan", "Iğdır"};
    private String[] array7 = {"Adıyaman", "Diyarbakır", "Gaziantep", "Mardin", "Siirt", "Şanlıurfa", "Batman", "Şırnak", "Kilis"};
    public JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton araButton;
    private JTable table1;
    private JScrollPane scrollPane;
    private  ImageIcon icon=null;

    public TahminAramaPanel()
    {


        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if( (comboBox1.getSelectedItem().toString()).equals("Karadeniz") )
                    comboBox2.setModel(new javax.swing.DefaultComboBoxModel(array2));

                else if( (comboBox1.getSelectedItem().toString()).equals("Akdeniz") )
                    comboBox2.setModel(new javax.swing.DefaultComboBoxModel(array3));

                else if( (comboBox1.getSelectedItem().toString()).equals("Ege") )
                    comboBox2.setModel(new javax.swing.DefaultComboBoxModel(array4));

                else if( (comboBox1.getSelectedItem().toString()).equals("Marmara") )
                    comboBox2.setModel(new javax.swing.DefaultComboBoxModel(array5));

                else if( (comboBox1.getSelectedItem().toString()).equals("İç Anadolu") )
                    comboBox2.setModel(new javax.swing.DefaultComboBoxModel(array1));

                else if( (comboBox1.getSelectedItem().toString()).equals("Doğu Anadolu") )
                    comboBox2.setModel(new javax.swing.DefaultComboBoxModel(array6));

                else if( (comboBox1.getSelectedItem().toString()).equals("Güneydoğu Anadolu") )
                    comboBox2.setModel(new javax.swing.DefaultComboBoxModel(array2));

            }
        });

        araButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                DefaultTableModel model = new DefaultTableModel() {
                    public Class getColumnClass(int column) {
                        if (column == 1)
                            return ImageIcon.class;

                        return Object.class;
                    }

                };
                table1.setModel( model );

                scrollPane.getViewport().add(table1);

                model.addColumn("Tarih");
                model.addColumn("Hava Durumu");
                model.addColumn("En Düşük Sıcaklık");
                model.addColumn("En Yüksek Sıcaklık");



                for(int i = 0; i<Tahmin.aList.size(); i++)
                {
                    String durum = Tahmin.getHavaDurumu();
                    if(durum.equals("Bulutlu"))
                    {
                        icon = new ImageIcon("cloudy.png");

                    }

                    else if(durum.equals("Güneşli"))
                    {
                        icon = new ImageIcon("sunny.png");
                    }

                    else if(durum.equals("Rüzgarlı"))
                    {
                        icon = new ImageIcon("wind.png");;
                    }

                    else if(durum.equals("Kar Yağışlı"))
                    {
                        icon = new ImageIcon("snow.png");
                    }

                    else if(durum.equals("Yağmurlu"))
                    {
                        icon = new ImageIcon("rainy.png");
                    }

                    else if(durum.equals("Parçalı Bulutlu"))
                    {
                        icon = new ImageIcon("m-cloudy.png");
                    }

                    else if(durum.equals("Yağmurlu ve Karlı"))
                    {
                        icon = new ImageIcon("rainy-snow.png");
                    }

                    else if(durum.equals("Yağmurlu ve Rüzgarlı"))
                    {
                        icon = new ImageIcon("t-storm-rain.png");
                    }



                    if( (Tahmin.aList.get(i).getBolge()).equals(comboBox1.getSelectedItem().toString()) && (Tahmin.aList.get(i).getSehir().toString()).equals(comboBox2.getSelectedItem().toString()) && (((textField1.getText()).compareTo(Tahmin.aList.get(i).getTarih())) <= 0 )  &&  (((textField2.getText()).compareTo(Tahmin.aList.get(i).getTarih())) >= 0 ))
                        model.addRow ( new Object[]{ Tahmin.aList.get(i).getTarih(), icon, Tahmin.aList.get(i).getMinSicaklik(),  Tahmin.aList.get(i).getMaxSicaklik() } );

                }




            }
        });
    }
}

