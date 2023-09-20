import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    /*
    basit bir depo projesi*
Calisan bir fabrikada uygulanan bir sistem olan depo uygulamasidir.*
1-) burada oncelikle urunun tanimlamasi  yapilir.  //pojoUrun
id
urunIsmi
uretici
miktar
birim ve
raf (6 adet fields mevcut)*
2-) methodlar olusturacagiz.
urunTanimlama   ==>  urunun ismi, ureticisi ve birimi girilecek. id  alınacak.  //MAP<id,pojoUrun>   RAF="-"ve Miktar=0 //arraylist
*
urunListele     ==> tanimlanan urunler listelenecek. urunun adeti ve raf numarasi tanimlama yapilmadiysa default deger gorunsun.
///  printf(%10)
urunGirisi      ==> giris yapmak istedigimiz urnunun id numarasi ile girecegiz.
*
urunuRafaKoy    ==> listeden urunu sececegiz ve id numarasina gore urunu rafa koyacagiz.
*
urunCikisi      ==> listeden urunu sececegiz ve urunun cikis yapcagiz. burada urun listesinden sadece miktarda degisiklik yapilacak.
urun aded i 0 dan az olamaz. 0 olunca urun tanimlamasi silinmesin. sadece miktari 0 olsun.  ///exception
===> yaptigimiz tum degisiklikler listede de gorunsun.
**
id      ismi    ureticisi   miktari     birimi      raf
---------------------------------------------------------------
or: 1000     un     hekimoglu   0           cuval       null
*
urunGirisi      ==> id:1000  urun girisi :5
urunListele     ==>
*
id      ismi    ureticisi   miktari     birimi      raf
---------------------------------------------------------------
or: 1000     un     hekimoglu   5           cuval       null
*
urunuRafaKoy    ==> id:1000 raf : raf1
urunListele     ==>
id      ismi    ureticisi   miktari     birimi      raf
---------------------------------------------------------------
or: 1000     un     hekimoglu   5           cuval       raf1
*
urunCikisi      ==> id 1000: urun cikis : 3 (kalan 2 cuval un)
urunListele     ==>
id      ismi    ureticisi   miktari     birimi      raf
---------------------------------------------------------------
or: 1000     un     hekimoglu   2           cuval       raf


Depo Projesi
Bu projede, bir fabrikada kullanılan bir depo sistemi olan Depo Uygulaması Java programlama dili kullanılarak gerçekleştirilecektir. Proje, aşağıdaki 3 sınıftan oluşacaktır:

1. PojoUrun Sınıfı
PojoUrun sınıfı aşağıdaki özelliklere sahip olacaktır:

id

urunIsmi

uretici

miktar

birim

raf

Bu sınıfın getter ve setter metotları bulunacaktır.

2. DepoSistemi Sınıfı
Bu sınıf, depo işlemlerinin gerçekleştirileceği metodları içerecektir. DepoSistemi sınıfında aşağıdaki metodlar yer alacaktır:

urunTanimlama(): Bu metot, kullanıcıdan ürün adı, üretici ve birim bilgilerini alarak yeni bir ürün tanımlayacaktır. Her ürün için bir id oluşturulacak ve
 bu id ile birlikte ürün bilgileri bir Map veri yapısında saklanacaktır. Ürünün miktarı başlangıçta 0 olacak ve raf bilgisi "-" olarak atanacaktır.

urunListele(): Bu metot, tanımlanan ürünleri listelemek için kullanılacaktır. Ürünlerin id, isim, üretici, miktar, birim ve raf bilgileri görüntülenecektir.
Eğer ürünün miktarı veya raf bilgisi tanımlanmamışsa, varsayılan değerler kullanılacaktır.

urunGirisi(): Bu metot, depoya ürün girişi yapmak için kullanılacaktır. Kullanıcıdan ürünün id numarası ve giriş miktarı alınacaktır. Bu bilgilere göre, ilgili ürünün miktarı güncellenecektir.

urunuRafaKoy(): Bu metot, bir ürünü rafa yerleştirmek için kullanılacaktır. Kullanıcıdan ürünün id numarası ve raf bilgisi alınacaktır. İlgili ürün, verilen raf numarasına göre güncellenecektir.

urunCikisi(): Bu metot, depodan ürün çıkışı yapmak için kullanılacaktır. Kullanıcıdan ürünün id numarası ve çıkış miktarı alınacaktır.
Ürün miktarı güncellenecek ve eğer miktar 0'dan küçük olursa, sadece miktarın 0 olduğu görüntülenecektir. Ürün tanımı silinmeyecektir.

3. Runner Sınıfı
Bu sınıf, projenin çalıştırılmasını sağlayacak bir Runner sınıfıdır. Bu sınıf içinde DepoSistemi sınıfının nesnesi oluşturulacak ve ilgili metotlar çağrılacaktır.

Proje Senaryosu
Aşağıda, projenin senaryosu ve örnek bir kullanımı verilmiştir:

DepoSistemi depo = new DepoSistemi();

depo.urunTanimlama("1000", "Un", "Hekimoğlu", "Cuval");
depo.urunListele();

// Çıktı:
// id     ismi    ureticisi   miktari    birimi    raf
// --------------------------------------------------
// 1000   Un      Hekimoğlu   0          Cuval     -

depo.urunGirisi("1000", 5);
depo.urunListele();

// Çıktı:
// id     ismi    ureticisi   miktari    birimi    raf
// --------------------------------------------------
// 1000   Un      Hekimoğlu   5          Cuval     -
     */
    static Product prod = new Product();
    static Scanner scan = new Scanner(System.in);
    static HashMap<String, Product> products = new HashMap<>();

    public void describeProduct() {
        System.out.println();
        String id, urunAdi, uretici, birimAdi, secim;

        do {
            System.out.println("Ürün id'sini Giriniz");
            id = scan.nextLine();
            System.out.println("Ürün Adını Giriniz");
            urunAdi = scan.nextLine();
            System.out.println("Ürün Üreticisini Giriniz");
            uretici = scan.nextLine();
            System.out.println("Ürün Birimini Giriniz");
            System.out.println("1. Adet");
            System.out.println("2. Kg");
            System.out.println("3. Çuval");
            System.out.println("4. Palet");
            System.out.println("5. Koli");
            int birim = scan.nextInt();
            String dummy = scan.nextLine();
            switch (birim) {
                case 1:
                    birimAdi = "Adet";
                    break;
                case 2:
                    birimAdi = "Kg";
                    break;
                case 3:
                    birimAdi = "Çuval";
                    break;
                case 4:
                    birimAdi = "Palet";
                    break;
                case 5:
                    birimAdi = "Koli";
                    break;
                default:
                    birimAdi = "Adet";
            }


            Product prod = new Product(id, urunAdi, uretici, 0, birimAdi, "-");
            products.put(id, prod);
            System.out.println("Yeni ürün eklemek istiyor musunuz? (E/H");
            secim = scan.nextLine();
        } while (secim.equals("E") || secim.equals("e"));
        this.printProducts();
        ProductsRunner.start();

    }

    public void addProduct() {

        System.out.println("Ürün id'sini giriniz");
        String id = scan.nextLine();
        System.out.println("Miktarı giriniz:");
        int miktar = scan.nextInt();
        String dummy = scan.nextLine();
        Product product = products.get(id);
        miktar += product.getAmount();
        product.setAmount(miktar);
        this.printProducts();
    }

    public void printProducts() {
        System.out.printf("%-8s %-10s %-10s %-10s %-10s %-10s\n", "Ürün ID", "Ürün Adı", "Üretici", "Miktar", "Birim", "Raf");
        System.out.printf("----------------------------------------------------------------\n");
        for (Product p : products.values()) {
            System.out.printf("%-8s %-10s %-10s %-10s %-10s %-10s\n",
                    p.getProductId(),
                    p.getProductName(),
                    p.getProducer(),
                    p.getAmount(),
                    p.getUnit(),
                    p.getShelf());
        }
        ProductsRunner.start();
    }

    public void removeProduct() {
        System.out.println("Ürün id'sini giriniz");
        String id = scan.nextLine();
        Product product = products.get(id);
        System.out.println("Çıkarmak istediğiniz miktarı giriniz:");
        int miktar = scan.nextInt();
        String dummy = scan.nextLine();
        if (miktar > product.getAmount()) {
            System.out.println("Stokta girdiğiniz kadar ürün bulunmamaktadır");
        } else {

            miktar = product.getAmount() - miktar;
            product.setAmount(miktar);
        }
        this.printProducts();
    }

    public void putToShelf() {
        System.out.println("Ürün id'sini giriniz");
        String id = scan.nextLine();
        Product product = products.get(id);
        System.out.println("Raf Bilgisini Giriniz");
        String raf = scan.nextLine();
        product.setShelf(raf);
        this.printProducts();

    }
}
