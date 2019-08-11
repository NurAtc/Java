
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.lang.String;


/**
 * Created by nuria on 29.05.2016.
 */
public class TahminEklemePanel
{
    public JPanel panel2;
    private JComboBox comboBox1;
    private JList list1;
    private JTextField textField1;
    private JComboBox comboBox2;
    private JTextField textField2;
    private JTextField textField3;
    private JButton kaydet;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel imageLabel2;
    private JLabel label6;
    private JLabel label7;
    private JPanel tPanel1;
    private JPanel tPanel2;
    private String[] array1 = {"Ankara", "Konya", "Eskişehir", "Çankırı", "Kırıkkale", "Kırşehir", "Aksaray","Niğde", "Karaman", "Yozgat", "Kayseri" };
    private String[] array2 = {"Sinop", "Samsun", "Ordu", "Giresun", "Trabzon", "Rize", "Artvin", "Amasya", "Bartın", "Bayburt", "Bolu", "Gümüşhane", "Kastamonu", "Zonguldak" };
    private String[] array3 = {"Antalya", "Mersin", "Burdur", "Isparta", "Hatay", "Kahramanmaraş", "Karaman", "Adana", "Osmaniye"};
    private String[] array4 = {"İzmir", "Muğla", "Uşak", "Manisa", "Aydın", "Denizli", "Kütahya", "Afyon"};
    private String[] array5 = {"İstanbul", "Edirne", "Kırklareli", "Tekirdağ", "Çanakkale", "Kocaeli", "Yalova", "Sakarya", "Bilecik", "Bursa", "Balıkesir"};
    private String[] array6 = {"Ağrı", "Bingöl", "Bitlis", "Elazığ", "Erzincan", "Erzurum", "Hakkari", "Kars", "Malatya", "Muş", "Tunceli", "Van", "Ardahan", "Iğdır"};
    private String[] array7 = {"Adıyaman", "Diyarbakır", "Gaziantep", "Mardin", "Siirt", "Şanlıurfa", "Batman", "Şırnak", "Kilis"};

    public TahminEklemePanel()
    {
        panel2.setPreferredSize(new Dimension(690, 600));


        list1.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent)
            {
                String sehir = list1.getSelectedValue().toString();
                label4.setText(sehir.toUpperCase());

            }
        });

        comboBox1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

                String bolge = comboBox1.getSelectedItem().toString();

                if(bolge.equals("İç Anadolu"))
                    list1 .setListData(array1);

                else if(bolge.equals("Karadeniz"))
                    list1.setListData(array2);

                else if(bolge.equals("Akdeniz"))
                    list1.setListData(array3);

                else if(bolge.equals(("Ege")))
                    list1.setListData(array4);

                else if(bolge.equals("Marmara"))
                    list1.setListData(array5);

                else if(bolge.equals("Doğu Anadolu"))
                    list1.setListData(array6);

                else if(bolge.equals("Güneydoğu Anadolu"))
                    list1.setListData(array7);

            }
        });




        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String durum = comboBox2.getSelectedItem().toString();
                if(durum.equals("Bulutlu"))
                {
                    ImageIcon icon1 = new ImageIcon("cloudy.png");
                    imageLabel2.setIcon(icon1);

                }

                else if(durum.equals("Güneşli"))
                {
                    ImageIcon icon2 = new ImageIcon("sunny.png");
                    imageLabel2.setIcon(icon2);
                }

                else if(durum.equals("Rüzgarlı"))
                {
                    ImageIcon icon3 = new ImageIcon("wind.png");
                    imageLabel2.setIcon(icon3);
                }

                else if(durum.equals("Kar Yağışlı"))
                {
                    ImageIcon icon4 = new ImageIcon("snow.png");
                    imageLabel2.setIcon(icon4);
                }

                else if(durum.equals("Yağmurlu"))
                {
                    ImageIcon icon5 = new ImageIcon("rainy.png");
                    imageLabel2.setIcon(icon5);
                }

                else if(durum.equals("Parçalı Bulutlu"))
                {
                    ImageIcon icon6 = new ImageIcon("m-cloudy.png");
                    imageLabel2.setIcon(icon6);
                }

                else if(durum.equals("Yağmurlu ve Karlı"))
                {
                    ImageIcon icon7 = new ImageIcon("rainy-snow.png");
                    imageLabel2.setIcon(icon7);
                }

                else if(durum.equals("Yağmurlu ve Rüzgarlı"))
                {
                    ImageIcon icon8 = new ImageIcon("t-storm-rain.png");
                    imageLabel2.setIcon(icon8);
                }

            }
        });


        kaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Tahmin tahmin = new Tahmin( (comboBox1.getSelectedItem()).toString(), (list1.getSelectedValue()).toString(), textField1.getText().toString(), (comboBox2.getSelectedItem()).toString(), Integer.parseInt(textField2.getText().toString()),    Integer.parseInt(textField3.getText().toString()) );
                Tahmin.aList.add(tahmin);

                AnaEkranPanel.frame.setVisible(false);
            }
        });

        System.out.println(Tahmin.aList);
    }


}

