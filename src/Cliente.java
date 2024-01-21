import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.connectServer();
    }

    private void connectServer() {
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 7777);
            RMI interfaz = (RMI) registro.lookup("RemotoRMI");

            // Realiza operaciones matematicas con los numeros que les pasamos
            int suma = interfaz.suma(5, 10);
            int resta = interfaz.resta(15, 4);
            int multiplicacion = interfaz.multiplicacion(3, 3);
            double division = interfaz.division(8, 2);
            double porcentaje = interfaz.porcentaje(20, 150);
            int resto = interfaz.resto(15, 7);
            double media = interfaz.media(new int[]{5, 10, 15, 20, 25});

            // Imprime resultados
            System.out.println("Suma: " + suma);
            System.out.println("Resta: " + resta);
            System.out.println("Multiplicación: " + multiplicacion);
            System.out.println("División: " + division);
            System.out.println("Porcentaje: " + porcentaje);
            System.out.println("Resto: " + resto);
            System.out.println("Media: " + media);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
