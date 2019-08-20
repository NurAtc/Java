//gerekli java paketlerini import ediyoruz
import javax.swing.*;

/**
 * Created by manager on 22.5.2016.
 */
public class mainClass {
    public static void main(String[] args){
        //ana sayfa için frame oluşturup görüntüleme işini yapıyoruz
        JFrame frame = new JFrame("Meteroloji Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new anaSayfa().anaPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
