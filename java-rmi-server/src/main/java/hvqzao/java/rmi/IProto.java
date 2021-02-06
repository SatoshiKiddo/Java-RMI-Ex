package hvqzao.java.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

public interface IProto extends Remote {

	public String hello(String name) throws RemoteException;
	
	public Boolean login(String username, String password) throws RemoteException;
    
    public Integer apertura_cuenta(String documento_id, String nombre, String username, String password) throws RemoteException;
    
    public List<Cuenta> consulta_cuenta(String documento_id) throws RemoteException;
    
    public List<Transacciones> consulta_transacciones(Double numero, Double limite) throws RemoteException;
    
    public String consulta_deposito(String documento_id, int password) throws RemoteException;
    
    public Boolean deposito(int num_cuenta, Double monto) throws RemoteException;
    
    public Boolean retiro(int num_cuenta, Double monto) throws RemoteException;
    
    public Boolean transferencia(int cuenta1, int cuenta2, double password) throws RemoteException;
	
}
