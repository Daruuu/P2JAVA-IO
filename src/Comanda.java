import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    private static double[] ivaTipos = new double[3];
    private static double precioTotal = 0.0;
    private Product p;
    private String date;

    public void loadComanda(String fileName) throws Exception {
        Scanner scReadLinesCSV = new Scanner(new File(fileName));
        // nos saltamos la primera línea porque es la cabecera
        scReadLinesCSV.nextLine();
        while (scReadLinesCSV.hasNextLine()){
            String line = scReadLinesCSV.nextLine();
            addProduct(line);
        }
        setDate(p.getDate());
        scReadLinesCSV.close();
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void writeComanda(int numeroComanda) throws IOException {
        String newFilename = "comanda" + numeroComanda + ".txt";
        System.out.println("El archivo de salida es: " + newFilename);
        FileWriter file = new FileWriter(newFilename);
        PrintWriter writer = new PrintWriter(file);

        // Escribimos en el archivo
        writer.println("Fecha: " + getDate());
        writer.printf("%s %.2f\n", "TOTAL IVA 4%: ", ivaTipos[0]);
        writer.printf("%s %.2f\n", "TOTAL IVA 10%: ", ivaTipos[1]);
        writer.printf("%s %.2f\n", "TOTAL IVA 21%: ", ivaTipos[2]);
        writer.printf("%s %.2f\n", "Total: ", precioTotal);
        writer.println("Listado de productos: ");
        writeProducts(writer);

        writer.close();
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

            procesarProducto(p);    // Calculamos los diferentes tipos de iva y el precio total
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

    public void showComanda() {
        System.out.printf("%s %.2f\n", "Total: ", precioTotal);
        System.out.println("Fecha: " + getDate());
        System.out.printf("%s %.2f\n", "TOTAL IVA 4%: ", ivaTipos[0]);
        System.out.printf("%s %.2f\n", "TOTAL IVA 10%: ", ivaTipos[1]);
        System.out.printf("%s %.2f\n", "TOTAL IVA 21%: ", ivaTipos[2]);
        System.out.println("Productos: ");
        showProducts();
    }

    public void showProducts(){ for (Product p : productos){
            System.out.println(p);
        }
    }

    public void writeProducts(PrintWriter writer) {
        for (Product p: productos) {
            writer.println(p);
        }
    }

    public ArrayList<Product> getProducts() {
        return productos;
    }

    public static double getPrecioTotal() {
        return precioTotal;
    }

    public static void setPrecioTotal(double precioTotal) {
        Comanda.precioTotal = precioTotal;
    }

    public static double[] getIvaTipos() {
        return ivaTipos;
    }

    public static void setIvaTipos(double[] ivaTipos) {
        Comanda.ivaTipos = ivaTipos;
    }
}
