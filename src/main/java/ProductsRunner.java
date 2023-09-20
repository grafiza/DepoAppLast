import java.util.Scanner;

public class ProductsRunner {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        start();
    }

    public static void start() {
        Scanner scan = new Scanner(System.in);
        int select = -1;
        ProductService ps = new ProductService();
        System.out.println("---- Depo Sistemi ----");
        System.out.println("1. Ürün Tanımlama");
        System.out.println("2. Ürün Listeleme");
        System.out.println("3. Ürün Girişi");
        System.out.println("4. Ürün Çıkışı");
        System.out.println("5. Rafa Koy");
        System.out.println("0. Çıkış");
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

                break;
        }

    }


}
