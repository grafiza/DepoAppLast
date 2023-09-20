import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ProductService {

    Scanner scan = new Scanner(System.in);
    HashMap<String, Product> products = new HashMap<>();

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
            this.products.put(id, prod);
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
        Product product = this.products.get(id);
        miktar += product.getAmount();
        product.setAmount(miktar);
        this.printProducts();
    }

    public void printProducts() {
        System.out.printf("%-8s %-10s %-10s %-10s %-10s %-10s\n", "Ürün ID", "Ürün Adı", "Üretici", "Miktar", "Birim", "Raf");
        System.out.printf("----------------------------------------------------------------\n");
        for (Product p : this.products.values()) {
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
        Product product = this.products.get(id);
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
        Product product = this.products.get(id);
        System.out.println("Raf Bilgisini Giriniz");
        String raf = scan.nextLine();
        product.setShelf(raf);
        this.printProducts();

    }
}
