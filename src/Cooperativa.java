import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1>Cooperativa</h1>
 * La clase Cooperativa es donde se crean tantas comandas como se necesiten y es donde se ejecuta el programa.
 * @author Daruny SC
 * @version 1.0.0
 * @since 2021-02-19
 */

public class Cooperativa {
    static int numeroComandes = 2;
    static int numIvaTipos = 3;
    static ArrayList<Comanda> comandas = new ArrayList<>(numeroComandes);

    private static double totalPrecioComandas = 0.0;
    private static final double[] ivaTiposTotales = new double[3];


    public static void main(String[] args) throws Exception {
        loadComandes();
        procesarComandes();    // Calcularemos el precio total de las comandas y sus iva.
        startProgram();

    }

    public static void writeCooperativa() throws IOException {
        String newFilename = "cooperativa.txt";
        System.out.println("El archivo de salida es: " + newFilename);
        FileWriter file = new FileWriter(newFilename);
        PrintWriter writer = new PrintWriter(file);

        // Escribimos en el archivo
        writer.printf("%s %.2f\n", "Total comandas: ", totalPrecioComandas);
        writer.printf("%s %.2f\n", "TOTAL IVA 4%: ", ivaTiposTotales[0]);
        writer.printf("%s %.2f\n", "TOTAL IVA 10%: ", ivaTiposTotales[1]);
        writer.printf("%s %.2f\n", "TOTAL IVA 21%: ", ivaTiposTotales[2]);

        writer.close();
    }

    public static void procesarComandes() {
        for (int i = 0; i < comandas.size(); ++i) {
            Comanda c = comandas.get(i);
            totalPrecioComandas += c.getPrecioTotal();
            for (int j = 0; j < numIvaTipos; ++j) {
                ivaTiposTotales[j] += c.getIvaTipos()[j];
            }
        }
    }

    public static void loadComandes() throws Exception {
        for (int i = 0; i < numeroComandes; ++i) {
            Comanda c = new Comanda();
            String filename = "comanda_" + (i+1) + ".csv";
            c.loadComanda(filename);
            comandas.add(i, c);
        }
    }

    public static void showCooperativa() {
        System.out.printf("%s %.2f\n", "Total comandes", totalPrecioComandas);
        System.out.printf("%s %.2f\n", "TOTAL IVA 4%: ", ivaTiposTotales[0]);
        System.out.printf("%s %.2f\n", "TOTAL IVA 10%: ", ivaTiposTotales[1]);
        System.out.printf("%s %.2f\n", "TOTAL IVA 21%: ", ivaTiposTotales[2]);
    }

    public static void showComanda() {
        for (int i = 0; i < comandas.size(); ++i) {
            System.out.println("Comanda numero " + (i+1));
            comandas.get(i).showComanda();
        }
    }

    static int requestNumberComanda() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Introduce numero de comanda (1 o %d): ", numeroComandes);
        return sc.nextInt();
    }

    static int menuProgram() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nMenu de opciones:");
        System.out.println("[1] - Ver datos de una comanda");
        System.out.println("[2] - Ver datos de la cooperativa");
        System.out.println("[3] - Exportar datos de una comanda");
        System.out.println("[4] - Exportar datos de la cooperativa");
        System.out.println("[5] - Termina programa");
        System.out.print("Opcion: ");
        return sc.nextInt();
    }

    static void startProgram() throws IOException {
        Scanner sc = new Scanner(System.in);
        int numeroComanda = 0;
        int option = menuProgram();
        while (option != 5) {
            switch (option) {
                case 1:
                    numeroComanda = requestNumberComanda();
                    comandas.get(numeroComanda-1).showComanda();
                    System.out.println();
                    break;
                case 2:
                    showCooperativa();
                    System.out.println();
                    break;
                case 3:
                    numeroComanda = requestNumberComanda();
                    comandas.get(numeroComanda-1).writeComanda(numeroComanda);
                    System.out.println();
                    break;
                case 4:
                    writeCooperativa();
                    System.out.println();
                    break;
                default:
                    System.out.println("el programa ha terminado");
                    sc.close();
                    break;
            }
            option = menuProgram();
        }
    }

    public static int getNumeroComandas() {
        return numeroComandes;
    }

    public static void setNumeroComandas(int numeroComandas) {
        Cooperativa.numeroComandes = numeroComandas;
    }

    public static ArrayList<Comanda> getComandas() {
        return comandas;
    }

    public static void setComandas(ArrayList<Comanda> comandas) {
        Cooperativa.comandas = comandas;
    }

    public static double getTotalPrecioComandas() {
        return totalPrecioComandas;
    }

    public void setTotalPrecioComandas(double totalPrecioComandas) {
        Cooperativa.totalPrecioComandas = totalPrecioComandas;
    }

}


