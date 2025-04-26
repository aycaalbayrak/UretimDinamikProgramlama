public class UretimHatti {
    private int isSayisi;
    private int makineSayisi;
    private int[][] islemSuresi;
    private int[][] gecisMaliyeti;

    public UretimHatti(int isSayisi, int makineSayisi, int[][] islemSuresi, int[][] gecisMaliyeti) {
        this.isSayisi = isSayisi;
        this.makineSayisi = makineSayisi;
        this.islemSuresi = islemSuresi;
        this.gecisMaliyeti = gecisMaliyeti;
    }

    public int minimumTamamlamaSuresiBul() {
        int[][] enKisaSure = new int[isSayisi][makineSayisi];

        for (int makine = 0; makine < makineSayisi; makine++) {
            enKisaSure[0][makine] = islemSuresi[0][makine];
        }

        System.out.println("0. iş sonrası süre tablosu:");
        tabloyuYazdir(enKisaSure, 0);

        for (int is = 1; is < isSayisi; is++) {
            for (int makine = 0; makine < makineSayisi; makine++) {
                enKisaSure[is][makine] = Integer.MAX_VALUE;
                for (int oncekiMakine = 0; oncekiMakine < makineSayisi; oncekiMakine++) {
                    int toplamSure = enKisaSure[is-1][oncekiMakine] + gecisMaliyeti[oncekiMakine][makine] + islemSuresi[is][makine];
                    if (toplamSure < enKisaSure[is][makine]) {
                        enKisaSure[is][makine] = toplamSure;
                    }
                }
            }

            System.out.println(is + ". iş sonrası süre tablosu:");
            tabloyuYazdir(enKisaSure, is);
        }

        int minimumSure = Integer.MAX_VALUE;
        for (int makine = 0; makine < makineSayisi; makine++) {
            if (enKisaSure[isSayisi-1][makine] < minimumSure) {
                minimumSure = enKisaSure[isSayisi-1][makine];
            }
        }

        return minimumSure;
    }

    private void tabloyuYazdir(int[][] tablo, int sonIs) {
        for (int is = 0; is <= sonIs; is++) {
            System.out.print("İş " + is + ": ");
            for (int makine = 0; makine < makineSayisi; makine++) {
                if (tablo[is][makine] == Integer.MAX_VALUE) {
                    System.out.print("∞ ");
                } else {
                    System.out.print(tablo[is][makine] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }
}
