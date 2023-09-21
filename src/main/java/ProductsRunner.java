import java.sql.SQLOutput;
import java.util.Scanner;

public class ProductsRunner {
    static Scanner scan = new Scanner(System.in);
    static ProductService ps = new ProductService();

    public static void main(String[] args) {

        start();
    }

    public static void start() {
        int select = -1;

        System.out.println("-".repeat(50));
        System.out.println("                 Depo Sistemi v1.0");
        System.out.println("-".repeat(50));
        System.out.println("\t\t1. Ürün Tanımlama");
        System.out.println("\t\t2. Ürün Listeleme");
        System.out.println("\t\t3. Ürün Girişi");
        System.out.println("\t\t4. Ürün Çıkışı");
        System.out.println("\t\t5. Rafa Koy");
        System.out.println("\t\t0. Çıkış");
        select = scan.nextInt();
        switch (select) {
            case 1:
                ps.describeProduct();
                break;
            case 2:
                ps.printProducts();
                break;
            case 3:
                ps.addProduct();
                break;
            case 4:
                ps.removeProduct();
                break;
            case 5:
                ps.putToShelf();
                break;
            case 0:
                System.out.println("İyi günler");
                break;
        }

    }


}
