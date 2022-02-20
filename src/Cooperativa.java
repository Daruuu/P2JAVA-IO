import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1>Cooperativa</h1>
 * La clase Copperativa es donde se crean tantas comandas como se necesiten y es donde se ejecuta el programa.
 * @author Daruny SC
 * @version 1.0.0
 * @since 2021-02-19
 */

public class Cooperativa {
    static int numeroComandas = 2;
    static ArrayList<Comanda> comandas = new ArrayList<>(numeroComandas);

    public static void main(String[] args) throws Exception {
        loadComandes();
        startProgram();

    }

    public static void loadComandes() throws Exception {
        for (int i = 0; i < numeroComandas; ++i) {
            Comanda c = new Comanda();
            String filename = "comanda_" + (i+1) + ".csv";
            c.loadComanda(filename);
            comandas.add(i, c);
        }
    }
    public static void showComanda() {
        for (int i = 0; i < comandas.size(); ++i) {
            System.out.println("Comanda numero " + (i+1));
            comandas.get(i).showComanda();
        }
    }

    static int requestNumberComanda() {
        //Restamos uno porque utilizamos el resultado como indice del array comandas.
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce numero de comanda (1 o 2): ");
        return sc.nextInt()-1;
    }

    static int menuProgram() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nMenu de opciones:");
        System.out.println("[1] - Ver datos de una comanda: ");
        System.out.println("[2] - Ver datos de la cooperativa: ");
        System.out.println("[3] - Exportar datos de una comanda :");
        System.out.println("[4] - Exportar datos de la cooperativa: ");
        System.out.println("[5] - Termina programa");
        System.out.print("Opcion: ");
        return sc.nextInt();
    }

    static void startProgram() {
        Scanner sc = new Scanner(System.in);
        int option = menuProgram();
        while (option != 5) {
            switch (option) {
                case 1:
                    int indexComanda = requestNumberComanda();
                    comandas.get(indexComanda).showComanda();
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    break;
                case 4:
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

}


