package hvqzao.java.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

public interface IProto extends Remote {

	public String hello(String name) throws RemoteException;
	
	public Boolean login(String username, String password);
    
    public Integer apertura_cuenta(String documento_id, String nombre, String username, String password);
    
    public List<Cuenta> consulta_cuenta(String documento_id);
    
    public List<Transacciones> consulta_transacciones(Double numero, Double limite);
    
    public String consulta_deposito(String documento_id, int password);
    
    public Boolean deposito(int num_cuenta, Double monto);
    
    public Boolean retiro(int num_cuenta, Double monto);
    
    public Boolean transferencia(int cuenta1, int cuenta2, double password);
	
}
