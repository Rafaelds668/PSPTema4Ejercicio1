import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote {
    int suma(int x, int y) throws RemoteException;

    int resta(int x, int y) throws RemoteException;

    int multiplicacion(int x, int y) throws RemoteException;

    double division(int x, int y) throws RemoteException;

    double porcentaje(int x, int y) throws RemoteException;

    int resto(int x, int y) throws RemoteException;

    double media(int[] x) throws RemoteException;
}
