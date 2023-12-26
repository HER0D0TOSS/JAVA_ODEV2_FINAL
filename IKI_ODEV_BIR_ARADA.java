import java.util.Calendar;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JTextField field = new JTextField(3);

        panel.add(new JLabel("1- TAKVIM UYGULAMASI(GUNCEL TARIH)"));
        panel.add(new JLabel("2- NOT HARF DURUMU"));

        panel.add(new JLabel("YAPILACAK ISLEMI SECIN: "));
        panel.add(field);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        int result = JOptionPane.showOptionDialog(null, panel,
                "NOT DURUMU HESAPLAMA", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"SEÇ", "ÇIKIŞ"}, "default");

        if (result == JOptionPane.OK_OPTION) {
            String veri = field.getText();
            if ("1".equals(veri)) {

                Takvim();
            } else if ("2".equals(veri)) {

                NotHesapla();
            } else {
                System.out.println("Geçersiz seçenek!");
            }
        }
        else{
            System.out.println("İSLEM İPTAL EDİLDİ");
        }
    }
    private static void Takvim() {

        Calendar calendar = Calendar.getInstance();
        int yil = calendar.get(Calendar.YEAR);
        int ay = calendar.get(Calendar.MONTH) + 1;
        int gun = calendar.get(Calendar.DAY_OF_MONTH);

        String Tarihim = "Güncel Tarih: " + gun + "-" + ay + "-" + yil;

        System.out.println(Tarihim);

        JPanel Takvim = new JPanel();
        Takvim.add(new JLabel(Tarihim));
        int result1 = JOptionPane.showOptionDialog(null, Takvim,
                "NOT DURUMU HESAPLAMA", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"CIKIS"}, "default");

    }
    private static void NotHesapla(){
        int not = 58;
        String Notum = null;

        if(not <= 44){
            System.out.println("KALDINIZ! HARF ARALIĞI: FF");
            Notum = "KALDINIZ! HARF ARALIĞI: FF";
        }
        else if ((not > 44)&&(not <= 49)) {
            System.out.println("ORTALAMA 1.00 HARF ARALIĞI: DD");
            Notum = "ORTALAMA 1.00 HARF ARALIĞI: DD";
        }
        else if ((not > 49)&&(not <= 59)) {
            System.out.println("ORTALAMA 1.50 HARF ARALIĞI: DC");
            Notum = "ORTALAMA 1.50 HARF ARALIĞI: DC";
        } else if ((not > 59)&&(not <= 69)) {
            System.out.println("ORTALAMA 2.00 HARF ARALIĞI CC");
            Notum = "ORTALAMA 2.00 HARF ARALIĞI: CC";
        }
        else if((not > 69)&&(not<= 79)){
            System.out.println("ORTALAMA 2.50 HARF ARALIĞI CB");
            Notum = "ORTALAMA 2.50 HARF ARALIĞI: CB";
        }
        else if ((not > 79)&&(not <= 84)) {
            System.out.println("ORTALAMA 3.00 HARF ARALIĞI BB");
            Notum = "ORTALAMA 3.00 HARF ARALIĞI: BB";
        }
        else if((not > 84)&&(not <= 89)){
            System.out.println("ORTALAMA 3.50 HARF ARALIĞI BA");
            Notum = "ORTALAMA 3.50 HARF ARALIĞI: BA";
        }
        else if((not >89)&&(not<=100)){
            System.out.println("ORTALAMA 4.OO HARF ARALIĞI AA");
            Notum = "ORTALAMA 4.00 HARF ARALIĞI: AA";
        }
        else{
            System.out.println("KALDINIZ...");

        }
        JPanel Not= new JPanel();
        Not.add(new JLabel(Notum));
        int result1 = JOptionPane.showOptionDialog(null, Not,
                "NOT DURUMU HESAPLAMA", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"CIKIS"}, "default");

    }
