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
        
        public Optional<Boolean> login(String username, String password) {
        	return PostgreSQLDAO.login(username, password);
        }
        
        public Optional<Integer> apertura_cuenta(String documento_id, String nombre, String username, String password) {
            return PostgreSQLDAO.apertura_cuenta(documento_id, nombre, username, password);
        }
        
        public Optional<List<Cuenta>> consulta_cuenta(String documento_id) {
            return PostgreSQLDAO.consulta_cuenta(documento_id);
        }
        
        public Optional<List<Transacciones>> consulta_transacciones(Double numero, Double limite) {
            return PostgreSQLDAO.consulta_transacciones(numero, limite);
        }
        
        public Optional<String> consulta_deposito(String documento_id, int password) {
            return PostgreSQLDAO.consulta_deposito(documento_id, password);
        }
        
        public Optional<Boolean> deposito(int num_cuenta, Double monto) {
            return PostgreSQLDAO.deposito(num_cuenta, monto);
        }
        
        public Optional<Boolean> retiro(int num_cuenta, Double monto) {
            return PostgreSQLDAO.retiro(num_cuenta, monto);
        }
        
        public Optional<Boolean> transferencia(int cuenta1, int cuenta2, double monto) {
            return PostgreSQLDAO.transferencia(cuenta1, cuenta2, monto);
        }

}
