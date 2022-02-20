import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1>Comanda</h1>
 * La clase Comanda tiene diferentes productos que pertenecen a mas de una comanda.
 * @author Daruny SC
 * @version 1.0.0
 * @since 2021-02-19
 */

public class Comanda {

    private final ArrayList<Product> productos = new ArrayList<>();
    private static final double[] ivaTipos = new double[3];
    static double precioTotal = 0.0;
    private Product p;

    public void loadComanda(String fileName) throws Exception {
        Scanner scReadLinesCSV = new Scanner(new File(fileName));
        // nos saltamos la primera linea
        scReadLinesCSV.nextLine();
        while (scReadLinesCSV.hasNextLine()){
            String line = scReadLinesCSV.nextLine();
            addProduct(line);
        }
        scReadLinesCSV.close();
    }

    public void addProduct(String line){
        Scanner sc = new Scanner(line).useDelimiter(";");
        while (sc.hasNext()) {
            int productId = sc.nextInt();
            String name = sc.next();
            String description = sc.next();
            int operator = sc.nextInt();
            String date = sc.next();
            int cartId = sc.nextInt();
            int quantity = sc.nextInt();
            double ivaPercent = sc.nextInt();
            double unitPrice = sc.nextDouble();

            p = new Product(productId, name, description, operator, date, cartId, quantity, ivaPercent, unitPrice);

            procesarProducto(p);    // Calculamos el iva total
            productos.add(p);
            // System.out.println("Add " + p);
        }
        sc.close();
    }

    static void procesarProducto(Product p) {
        double precioSinIva = p.getQuantity() * p.getUnitPrice();
        if (p.getIvaPercent() == 4) {
                ivaTipos[0] += precioSinIva;

        } else if (p.getIvaPercent() == 10) {
            ivaTipos[1] += precioSinIva;

        } else if (p.getIvaPercent() == 21) {
            ivaTipos[2] += precioSinIva;
        }
        double precioConIva = precioSinIva * (p.getIvaPercent()/100 + 1.00);
        precioTotal += precioConIva;
    }

    /*
    public void showProducts(){
        for (Product producto : productos) {
            System.out.println(producto.toString());
        }
    }
     */

    public void showComanda() {
        System.out.println("Total: " + precioTotal);
        System.out.println("Fecha: " + p.getDate());
        System.out.println("TOTAL IVA 4%: " + ivaTipos[0]);
        System.out.println("TOTAL IVA 10%: " + ivaTipos[1]);
        System.out.println("TOTAL IVA 21%: " + ivaTipos[2]);
        System.out.println("Productos: ");
        showProducts();
    }

    public void showProducts(){
        for (Product p : productos){
            System.out.println(p);
        }
    }

    public double datosCooperativa2(){
        double totalPedido = 0.0;
        for (int i = 0; i < productos.size(); i++) {
            totalPedido += productos.get(i).getQuantity();
        }
        System.out.println("Total de comandas: ");
        return totalPedido;
    }

    public ArrayList<Product> getProducts() {
        return productos;
    }
    public void datosComanda(){

    }
}
