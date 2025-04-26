public class Main{
    public static void main(String[] args) {

        int[][] islemSuresi = {
                {4, 5},
                {3, 6},
                {7, 2}
        };


        int[][] gecisMaliyeti = {
                {0, 2},
                {3, 0}
        };


        UretimHatti uretimHatti = new UretimHatti(3, 2, islemSuresi, gecisMaliyeti);

        System.out.println("Minimum toplam tamamlama süresi: " + uretimHatti.minimumTamamlamaSuresiBul());
    }
}
