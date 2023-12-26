import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class Main {
    private int ayHesap, gunhesap;
    private String sonuc, status;
    private JTextField text1;
    private JTextField text2;
    private JTextField field;
    private JPanel panel1;



    public Main() {
        text1 = new JTextField(5);
        text2 = new JTextField(5);
        field = new JTextField(3);
        panel1 = new JPanel();
    }

    public void AnaPanel(String tarih, String saat) {
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(new JLabel(tarih));
        panel1.add(new JLabel(saat));
        panel1.add(new JLabel("ISTENILEN TARIH GUNU"));
        panel1.add(field);

        int result = JOptionPane.showOptionDialog(
                null,
                panel1,
                "TAKVIM UYGULAMASI",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"ONCE", "SONRA"},
                "default"
        );
        String veri = field.getText();

        if (result == JOptionPane.OK_OPTION) {
            OncekiGun(veri);
        } else if (result == 1) {
            SonrakiGun();
        }
    }

    private void OncekiGun(String veri) {
        Calendar takvim1 = Calendar.getInstance();
        int gun = takvim1.get(Calendar.DATE);
        int ay = takvim1.get(Calendar.MONTH) + 1;
        int yil = takvim1.get(Calendar.YEAR);


        List<Integer> degerler = new ArrayList<>();
        int verim = Integer.parseInt(veri);

        if((verim>0)&&(verim<=365)){
            int hesapAy = verim / 30;
            System.out.println("AY DONUSUMU: "+ hesapAy + " AY");
            int hesapGun = verim % 30;
            System.out.println("GUN DONUSUMU: " + hesapGun + " GUN" );

            degerler.add(hesapGun);
            degerler.add(hesapAy);

            int gunToplam = gun - degerler.get(0);
            int ayToplam = ay - degerler.get(1) ;

            if(gunToplam <=0){
                System.out.println("KONTROL ETME BLOGU");
                gunToplam +=30;
                ayToplam = ayToplam - 1;
                sonuc = verim +" GÜN ÖNCE TARİH: "+ gunToplam+ "-"+ ayToplam+"-"+yil;
                System.out.println(sonuc);

                if(ayToplam <= 0){
                    System.out.println("2. KONTROL ETME BLOĞU");
                    ayToplam += 12;
                    yil = yil-1;
                    System.out.println("yil degeri : " + yil);
                }

            }

            System.out.println("GUN DEGERİ: "+ gunToplam);
            System.out.println("AY DEGERİ: "+ ayToplam);
            sonuc = verim +" GÜN ÖNCE TARİH: "+ gunToplam+ "-"+ ayToplam+"-"+yil;
            Panel2(sonuc, status);

        }
        else if(verim>365){
            int hesapYil = verim /365;
            System.out.println("YIL DONUSUMU: " + hesapYil +" YIL");
            int hesapAy = (verim % 365);
            System.out.println("AY DONUSUMU: "+ hesapAy /30 + " AY");
            int hesapGun = (hesapAy) ;
            System.out.println("GUN DONUSUMU: "+ hesapAy % 30 + " GUN");

            degerler.add(hesapAy % 30);
            degerler.add(hesapAy /30);
            degerler.add(hesapYil);

            int gunToplam = gun -  degerler.get(0)  ;
            int ayToplam =  ay - degerler.get(1)  ;
            int yilToplam = yil - degerler.get(2) ;

            if(gunToplam <=0){
                System.out.println("KONTROL ETME BLOGU");
                gunToplam +=30;
                ayToplam = ayToplam - 1;
                sonuc = verim +" GÜN ÖNCE TARİH: "+ gunToplam+ "-"+ ayToplam+"-"+yil;
                System.out.println(sonuc);

                if(ayToplam <= 0){
                    System.out.println("2. KONTROL ETME BLOĞU");
                    ayToplam += 12;
                    yil = yil-1;
                    System.out.println("yil degeri : " + yil);
                }

            }
            sonuc = verim +" GÜN ÖNCE TARİH: "+ gunToplam+ "-"+ ayToplam+"-"+yilToplam;
            status = Integer.toString(verim);
            Panel2(sonuc, status);
        }


    }

    private void SonrakiGun() {
        Calendar takvim1 = Calendar.getInstance();

        int gun = takvim1.get(Calendar.DATE);
        int ay = takvim1.get(Calendar.MONTH) ;

        String status = field.getText();
        int gunhesap = Integer.parseInt(status);

        takvim1.set(Calendar.MONTH, ay + ayHesap);
        takvim1.set(Calendar.DATE, gun + gunhesap);

        int yeniGun = takvim1.get(Calendar.DATE);
        int yeniAy = takvim1.get(Calendar.MONTH)+1 ;
        int yeniYil = takvim1.get(Calendar.YEAR);

        System.out.println("Yeni Gun: " + yeniGun);
        System.out.println("Yeni Ay: " + yeniAy);
        System.out.println("Yeni Yil: " + yeniYil);



        sonuc = status+ " GUN SONRA TARİH: " + yeniGun + "-" + yeniAy + "-" + yeniYil;
        Panel3(sonuc);


    }

    public void Panel2(String sonuc, String status) {
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel( sonuc));

        int result2 = JOptionPane.showConfirmDialog(
                null,
                panel2,
                "TAKVIM UYGULAMASI",
                JOptionPane.OK_CANCEL_OPTION
        );
    }

    public void Panel3(String sonuc) {
        JPanel panel3 = new JPanel();
        panel3.add(new JLabel(sonuc));

        int result3 = JOptionPane.showConfirmDialog(
                null,
                panel3,
                "TAKVIM UYGULAMASI",
                JOptionPane.OK_CANCEL_OPTION
        );
    }

    public static void main(String[] args) {
        Main panelim = new Main();

        Calendar zaman = Calendar.getInstance();

        int gun = zaman.get(Calendar.DATE);
        int ay = zaman.get(Calendar.MONTH) + 1;
        int yil = zaman.get(Calendar.YEAR);
        int saat = zaman.get(Calendar.HOUR);
        int dakika = zaman.get(Calendar.MINUTE);

        String strgun = Integer.toString(gun);
        String strAy = Integer.toString(ay);
        String strYil = Integer.toString(yil);
        String strSaat = Integer.toString(saat);
        String strDakika = Integer.toString(dakika);

        String tarih = "GUNCEL TARIH: " + strgun + "-" + strAy + "-" + strYil;
        String Saat = "GUNCEL SAAT: " + strSaat + ":" + strDakika;

        panelim.AnaPanel(tarih, Saat);
    }
}
