//gerekli java paketlerini import ediyoruz
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by manager on 22.5.2016.
 */
public class anaSayfa {
    //değişkenler
    private JButton tahminEkle;
    private JButton tahminAra;
    private JLabel baslıkLabel;
    private JLabel imageLabel;
    public JPanel anaPanel;
    public static JFrame frameTahminEkleme;
    public static JFrame frameTahminArama;

    //constructor
    public anaSayfa() {

        //ana sayfada kullanılacak resim için imageİcon oluşturup label içine koyduk
        ImageIcon icon = new ImageIcon("hava_durumu.jpg");
        imageLabel.setIcon(icon);

        //hava tahmini ekle butonu için action listener oluşturduk
        tahminEkle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //bu butona basıldığında hava tahmini ekleme ekranı formunun görüntülenmesi için
                frameTahminEkleme = new JFrame("Hava Tahmini Ekleme Ekranı");
                frameTahminEkleme.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameTahminEkleme.getContentPane().add(new tahminEkleme().eklemePaneli);
                frameTahminEkleme.pack();
                frameTahminEkleme.setVisible(true);
            }
        });
        //hava tahmini ara butonu için action listener oluşturduk
        tahminAra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //bu butona basıldığında hava tahmini arama ekranı formunun görüntülenmesi için
                frameTahminArama = new JFrame("HavaTahminiAramaForm");
                frameTahminArama.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameTahminArama.getContentPane().add(new tahminArama().aramaPaneli);
                frameTahminArama.pack();
                frameTahminArama.setVisible(true);
            }
        });
    }
}
