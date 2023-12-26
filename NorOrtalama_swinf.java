package notOrtalamaFinal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotOrtalama {
    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JButton defaultButton = new JButton("NOT 58 İÇİN HESAPLA");
        JTextField field = new JTextField(3);

        defaultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String butonDefault = "58";
                int defaultValue = Integer.parseInt(butonDefault);
                hesaplama(Integer.toString(defaultValue));
            }
        });

        panel.add(new JLabel("ORTALAMA GİRİNİZ: "));
        panel.add(field);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(defaultButton);

        int result = JOptionPane.showOptionDialog(null, panel,
                "NOT DURUMU HESAPLAMA", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"HESAPLA", "ÇIKIŞ"}, "default");

        if (result == JOptionPane.OK_OPTION) {
            String veri = field.getText();
            hesaplama(veri);
        } else {
            System.out.println("Kullanıcı İptal etti.");
        }
    }

    private static void hesaplama(String veri) {
        try {
            int not = Integer.parseInt(veri);

            if (not <= 44) {
                System.out.println("KALDINIZ! HARF ARALIĞI: FF");
            } else if ((not > 44) && (not <= 49)) {
                System.out.println("ORTALAMA 1.00 HARF ARALIĞI: DD");
            } else if ((not > 49) && (not <= 59)) {
                System.out.println("ORTALAMA 1.50 HARF ARALIĞI: DC");
            } else if ((not > 59) && (not <= 69)) {
                System.out.println("ORTALAMA 2.00 HARF ARALIĞI CC");
            } else if ((not > 69) && (not <= 79)) {
                System.out.println("ORTALAMA 2.50 HARF ARALIĞI CB");
            } else if ((not > 79) && (not <= 84)) {
                System.out.println("ORTALAMA 3.00 HARF ARALIĞI BB");
            } else if ((not > 84) && (not <= 89)) {
                System.out.println("ORTALAMA 3.50 HARF ARALIĞI BA");
            } else if ((not > 89) && (not <= 100)) {
                System.out.println("ORTALAMA 4.00 HARF ARALIĞI AA");
            } else {
                System.out.println("Geçersiz not girişi.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Geçersiz not girişi. Sayı bekleniyor.");
        }
    }
}
