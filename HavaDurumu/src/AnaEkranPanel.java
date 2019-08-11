import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Created by nuria on 29.05.2016.
 */
public class AnaEkranPanel {
    public JPanel panel1;
    private JButton havaTahminiEkleButton;
    private JButton havaTahminiAraButton;
    private JLabel label1;
    private JLabel imageLabel;
    public static JFrame frame;

    public AnaEkranPanel()
    {
        panel1.setPreferredSize(new Dimension(500, 500)); //Açılacak form'un size'ını belirledik.

        ImageIcon icon = new ImageIcon("m-cloudy.png"); //Yeni bir icon oluşturduk.
        imageLabel.setIcon(icon);                       //Bu ikonu imageLabel'a ekledik.

        ButtonListener listener = new ButtonListener();     //Button için listener oluşturduk.
        havaTahminiEkleButton.addActionListener(listener);      //Bu iki butona listener ekledik.
        havaTahminiAraButton.addActionListener(listener);
    }

    public class ButtonListener implements ActionListener {    //Listener oluşturmak için oluşturduğumuz class'lar.
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == havaTahminiEkleButton) {  //Eğer Hava Tahmini Ekleme Butonuna basılırsa Hava Tahmini Ekleme Formu açılsın.

                frame = new JFrame("Hava Tahmini Ekleme Ekranı");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.getContentPane().add(new TahminEklemePanel().panel2);

                frame.pack();
                frame.setVisible(true);
            }

            else        //Değilse Hava Tahmini Arama Formu açılsın.
            {
                JFrame frame = new JFrame("HavaTahminiAramaForm");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.getContentPane().add(new TahminAramaPanel().panel1);

                frame.pack();
                frame.setVisible(true);
            }

        }
    }
}
