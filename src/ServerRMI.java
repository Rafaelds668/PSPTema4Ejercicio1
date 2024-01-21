import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI extends UnicastRemoteObject implements RMI {
    protected ServerRMI() throws RemoteException {
        super();
    }

    @Override
    public int suma(int x, int y) throws RemoteException {
        return x + y;
    }

    @Override
    public int resta(int x, int y) throws RemoteException {
        return x - y;
    }

    @Override
    public int multiplicacion(int x, int y) throws RemoteException {
        return x * y;
    }

    @Override
    public double division(int x, int y) throws RemoteException {
        if (y != 0) {
            return (double) x / y;
        } else {
            throw new RemoteException("No se puede dividir por cero");
        }
    }

    @Override
    public double porcentaje(int x, int y) throws RemoteException {
        return (x * y) / 100.0;
    }

    @Override
    public int resto(int x, int y) throws RemoteException {
       return x % y;
    }

    @Override
    public double media(int[] x) throws RemoteException {
        // Controlar que el array no este vacio
        if (x.length == 0) {
            throw new RemoteException("El array no puede estar vacío.");
        }

        int suma = 0;
        // Bucle para sumar todos los numeros
        for (int num : x) {
            suma += num;
        }

        return (double) suma / x.length;
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(7777);
            registry.rebind("RemotoRMI", new ServerRMI());
            System.out.println("Servidor activo");
        } catch (RemoteException e) {
           System.out.println(e.getMessage());
        }
    }
}
