
package odevhafta12;

import java.util.Scanner;

/**
 *
 * @author kdrerdemci
 */
public class OdevHafta12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String sayilar;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sayi Dizisini Giriniz");
        sayilar = scanner.nextLine();
        String[] sayi = sayilar.split(",");

        int[] dizi = new int[sayi.length];
        int[] siralanmisDizi = new int[sayi.length];

        for (int i = 0; i < sayi.length; i++) {
            dizi[i] = Integer.parseInt(sayi[i]);
        }
        int n = dizi.length;
        siralanmisDizi = SıralanmısDizi(dizi);
        for (int i = (n - 1) / 3; i >= 0; i--) {
            sırala(dizi, n, i);
        }
        
        if (dizi == siralanmisDizi) {
            System.out.println("Dizi üçlü min heap sıralamada");
        } else {
            System.out.println("Dizi üçlü min heap sıralamaya getirildi");
        }

        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + ",");
        }

    }

    public static int[] SıralanmısDizi(int[] sıralanacakDizi) {

        int n = sıralanacakDizi.length;
        for (int i = (n - 1) / 3; i >= 0; i--) {
            sırala(sıralanacakDizi, n, i);
        }
        return sıralanacakDizi;

    }

    public static void sırala(int[] array, int n, int i) {
        int ilkdeger = i;
        int sol = 3 * i + 1;
        int orta = 3 * i + 2;
        int sag = 3 * i + 3;

        if (sol < n && array[sol] < array[ilkdeger]) {
            ilkdeger = sol;
        }
        if (orta < n && array[orta] < array[ilkdeger]) {
            ilkdeger = orta;
        }
        if (sag < n && array[sag] < array[ilkdeger]) {
            ilkdeger = sag;
        }

        if (ilkdeger != i) {
            int temp = array[i];
            array[i] = array[ilkdeger];
            array[ilkdeger] = temp;
            sırala(array, n, ilkdeger);
        }
    }
    
}

