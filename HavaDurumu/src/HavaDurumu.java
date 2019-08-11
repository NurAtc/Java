import javax.swing.*;

public class HavaDurumu //Main fonksiyonunun bulunduğu class
{
    public static void main(String[] args) //Main çalıştığında Meteoroloji Form ekranı açılır.
    {
        //JFrame frame = new JFrame("MeteorolojiForm");
        JFrame frame = new JFrame("MeteorolojiForm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //frame.getContentPane().add(new AnaEkranPanel());
        frame.getContentPane().add(new AnaEkranPanel().panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
