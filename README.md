# Üretim Hattı Dinamik Programlama

Bu proje, bir üretim hattında işleri ve makineleri optimize ederek **minimum toplam tamamlama süresini** hesaplayan bir Java uygulamasıdır.

## İçerik
- Problem tanımı ve matris zinciri çarpımı ile ilişkilendirme
- Dinamik programlama yaklaşımı ile minimum süre hesaplama
- Süre tablosunun adım adım yazdırılması
- Zaman ve uzay karmaşıklığı analizi

---

## Problem Tanımı

- Bir üretim hattında birden fazla **iş** ve birden fazla **makine** bulunmaktadır.
- Her iş, her makinede farklı sürelerde tamamlanmaktadır.
- Ayrıca işler, bir makineden başka bir makineye geçerken **geçiş maliyetlerine (sürelerine)** sahiptir.
- **Amaç:** Seçilen işler ve makineler için toplam tamamlama süresinin **minimum** olması.

Her iş sırasıyla yapılmak zorundadır. Bir iş tamamlandıktan sonra sıradaki iş yapılır, işlerin sırası değiştirilemez.

---

## Matris Zinciri Çarpımı ile İlişkisi

Bu problem yapısal olarak **Matris Zinciri Çarpımı (Matrix Chain Multiplication)** problemine çok benzerdir.

Benzerlikler:
- **Alt problemler** tanımlanır ve çözülür.
- Daha küçük alt yapıların en iyi (minimum) çözümü bulunur.
- **Geçişler** (bir makineden diğerine) tıpkı matris çarpmalarında ara sonuçların hesaplanması gibidir.
- Her adımda **önceki adımlardan gelen minimum sonuçlar** kullanılarak sonraki adım çözülür.

İkisi de **dinamik programlama** ile çözülür çünkü her karar, gelecekteki adımları etkiler.

---

## Kullanım

Projede iki ana Java dosyası bulunmaktadır:
- `UretimHatti.java` → Üretim hattı algoritmasını içerir.
- `Main.java` → Programın başlangıç noktasıdır.

---

## Örnek

Verilen işlem süreleri ve geçiş maliyetlerine göre:

```java
int[][] islemSuresi = {
    {4, 5},
    {3, 6},
    {7, 2}
};

int[][] gecisMaliyeti = {
    {0, 2},
    {3, 0}
};


0. iş sonrası süre tablosu:
İş 0: 4 5 
-----------------------------
1. iş sonrası süre tablosu:
İş 0: 4 5 
İş 1: 7 11 
-----------------------------
2. iş sonrası süre tablosu:
İş 0: 4 5 
İş 1: 7 11 
İş 2: 14 11 
-----------------------------
Minimum toplam tamamlama süresi: 11
```
---


## Zaman ve Uzay (Alan) Karmaşıklığı

### Zaman Karmaşıklığı (Time Complexity)

Bu algoritmanın zaman karmaşıklığı, her iş için her makineyi incelememize ve her makine için önceki makineler arasındaki geçişleri kontrol etmemize dayanır. Bu nedenle, zaman karmaşıklığı şu şekilde hesaplanır:

Zaman karmaşıklığı = O(isSayisi × makineSayisi²)

**Açıklama:**
- `isSayisi`: Toplam iş sayısını belirtir.
- `makineSayisi`: Kullanılan makine sayısını belirtir.

Her iş için, her makineyi ve her makine için geçiş maliyetlerini kontrol ediyoruz. Yani, her iş için tüm makineler üzerinden geçişler yapılır. Bu da zaman karmaşıklığını **karesel** bir şekilde artırır. Bu nedenle, iş ve makine sayısı büyüdükçe işlem süresi de önemli ölçüde artacaktır. Eğer `isSayisi` ve `makineSayisi` büyükse, algoritma çok daha uzun sürede çalışabilir.

### Uzay Karmaşıklığı (Space Complexity)

Uzay karmaşıklığı, kullanılan veri yapılarının boyutuna bağlıdır. Bu algoritmada, tüm işlerin ve makinelerin sürelerini saklamak için bir 2D dizi (matris) kullanılır. Bu matrisin boyutu `isSayisi` × `makineSayisi`'dir.

Uzay karmaşıklığı = O(isSayisi × makineSayisi)

**Açıklama:**
- `isSayisi`: Toplam iş sayısını belirtir.
- `makineSayisi`: Kullanılan makine sayısını belirtir.

Bu matris, her iş için her makinenin en kısa süresini depolar. Bu nedenle, toplam hafıza kullanımı iş sayısı ve makine sayısının çarpımı kadar olur.

---

## Yazar

- [AYÇA ALBAYRAK](https://github.com/aycaalbayrak)

---

## Teşekkür

Bu projeyi geliştirme sürecinde destek olan herkese teşekkür ederim.Projenin bu noktaya gelmesinde emeği geçen herkese teşekkürlerimi sunuyorum!

