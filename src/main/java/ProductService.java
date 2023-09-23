import java.util.*;

public class ProductService {

    Scanner scan = new Scanner(System.in);
    static int idCounter = 1000;
    HashMap<String, Product> products = new HashMap<>();


    public void describeProduct() {
        System.out.println();
        String id, urunAdi, uretici, birimAdi, secim;

        do {

            System.out.println("Ürün Adını Giriniz");
            urunAdi = scan.nextLine();
            System.out.println("Ürün Üreticisini Giriniz");
            uretici = scan.nextLine();


            int birim = 0;
            try {

                System.out.println("Ürün Birimini Giriniz");
                System.out.println("1. Adet");
                System.out.println("2. Kg");
                System.out.println("3. Çuval");
                System.out.println("4. Palet");
                System.out.println("5. Koli");
                birim = scan.nextInt();

            } catch (InputMismatchException exception) {
                System.out.println("Adet Girildi !!!");
            }

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


            id = String.valueOf(idCounter);
            Product product = new Product(id, urunAdi, uretici, 0, birimAdi, "-");
            products.put(id, product);
            System.out.println("Ürün Kaydeildi...\nYeni ürün eklemek istiyor musunuz? (E/H)");
            secim = scan.nextLine().toUpperCase();
            idCounter++;
        } while (secim.equals("E"));
        this.printProducts();
        ProductsRunner.start();

    }

    public void addProduct() {
        System.out.println();
        System.out.println("Ürün id'sini giriniz");
        String id = scan.nextLine();
        Product product = this.products.get(id);
        if (product != null) {
            System.out.println("Miktarı giriniz:");
            int miktar = scan.nextInt();
            miktar += product.getAmount();
            product.setAmount(miktar);
            String dummy = scan.nextLine();
        } else
            System.out.println("Ürün Bulunamadı!");
        this.printProducts();
    }

    public void printProducts() {
        System.out.printf("%-8s %-15s %-15s %-15s %-15s %-15s\n", "Ürün ID", "Ürün Adı", "Üretici", "Miktar", "Birim", "Raf");
        System.out.printf("-------------------------------------------------------------------------------------\n");
        Set<String> sorted = products.keySet();
        List<String> productIdsAsList = new ArrayList<>(sorted);
        Collections.sort(productIdsAsList);
        for (String w : productIdsAsList) {
            Product p = this.products.get(w);
            System.out.printf("%-8s %-15s %-15s %-15s %-15s %-15s\n",
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
        if (product != null) {
            System.out.println("Çıkarmak istediğiniz miktarı giriniz:");
            int miktar = scan.nextInt();
            String dummy = scan.nextLine();
            if (miktar > product.getAmount()) {
                System.out.println("Stokta girdiğiniz kadar ürün bulunmamaktadır");
                product.setAmount(0);
            } else {

                miktar = product.getAmount() - miktar;
                product.setAmount(miktar);
            }
        } else
            System.out.println("Ürün Bulunamadı !");
        this.printProducts();
    }

    public void putToShelf() {
        System.out.println("Ürün id'sini giriniz");
        String id = scan.nextLine();
        Product product = this.products.get(id);
        if (product != null) {
            System.out.println("Raf Bilgisini Giriniz");
            String raf = scan.nextLine();
            product.setShelf(raf);
        } else
            System.out.println("Ürün Bulunamadı !");
        this.printProducts();

    }
}
