package hvqzao.java.rmi;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

public class Proto implements IProto {

        @Override
	public String hello(String name) throws RemoteException {
		String result = "Hello " + name + "!";
		System.out.println("Sending: " + result);
		return result;
	}
        
        public Boolean login(String username, String password) throws RemoteException{
        	return PostgreSQLDAO.login(username, password).get();
        }
        
        public Integer apertura_cuenta(String documento_id, String nombre, String username, String password) throws RemoteException {
            return PostgreSQLDAO.apertura_cuenta(documento_id, nombre, username, password).get();
        }
        
        public List<Cuenta> consulta_cuenta(String documento_id) throws RemoteException{
            return PostgreSQLDAO.consulta_cuenta(documento_id).get();
        }
        
        public List<Transacciones> consulta_transacciones(Double numero, Double limite) throws RemoteException{
            return PostgreSQLDAO.consulta_transacciones(numero, limite).get();
        }
        
        public String consulta_deposito(String documento_id, int password) throws RemoteException{
            return PostgreSQLDAO.consulta_deposito(documento_id, password).get();
        }
        
        public Boolean deposito(int num_cuenta, Double monto) throws RemoteException{
            return PostgreSQLDAO.deposito(num_cuenta, monto).get();
        }
        
        public Boolean retiro(int num_cuenta, Double monto) throws RemoteException{
            return PostgreSQLDAO.retiro(num_cuenta, monto).get();
        }
        
        public Boolean transferencia(int cuenta1, int cuenta2, double monto) throws RemoteException{
            return PostgreSQLDAO.transferencia(cuenta1, cuenta2, monto).get();
        }

}
