package hvqzao.java.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import hvqzao.java.rmi.Cuenta;
import hvqzao.java.rmi.IProto;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Scanner;

public class RmiClient {

    public static void main(String[] args) throws RemoteException, NotBoundException, IOException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, KeyManagementException, CertificateException {
        //System.setProperty("java.security.policy", "all.policy");
        //System.setSecurityManager(new SecurityManager());

        //Registry registry = LocateRegistry.getRegistry("127.0.0.1", 4000);
    	Scanner lector = new Scanner(System.in);
        SslClientSocketFactory csf = new SslClientSocketFactory("client", "clientpw");
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 4000, csf);

        IProto proto = (IProto) registry.lookup("proto");
        System.out.println("Received: " + proto.hello("RMI"));
        int flag = -1;
        String username;
        String password;
        String documento_id;
        String nombre;
        int num_cuenta;
        int num_cuenta2;
        double monto;
        while (true) {
        	System.out.println("\nBienvenido al ATM");
        	System.out.println("=================");
        	System.out.println("1-Apertura de cuenta");
        	System.out.println("2-Consulta de cuenta");
        	System.out.println("3-Deposito a cuenta");
        	System.out.println("4-Transferencia a cuenta");
        	System.out.println("5-Retiro de cuenta");
        	while (!lector.hasNextInt()) {
        		flag = lector.nextInt();
        	}
        	if (flag == 0)
    			break;
        	switch(flag) {
        		case 1:
                	System.out.println("Ingrese nombre de usuario\n");
        			username = lector.nextLine();
        			System.out.println("Ingrese password\n");
        			password = lector.nextLine();
        			System.out.println("Ingrese el id de su documento\n");
        			documento_id = lector.nextLine();
        			System.out.println("Ingrese su nombre\n");
        			nombre = lector.nextLine();
        			System.out.println("Cuenta creada: " + proto.apertura_cuenta(documento_id, nombre, username, password).get());
        			lector.nextLine();
        			break;
        		case 2: 
        			System.out.println("Ingrese nombre de usuario\n");
        			username = lector.nextLine();
        			System.out.println("Ingrese password\n");
        			password = lector.nextLine();
        			if (proto.login(username, password).get()) {
            			documento_id = lector.nextLine();
        				List<Cuenta> cuentas = proto.consulta_cuenta(documento_id).get();
        				for( int i = 0; i < cuentas.size(); i++) {
        					System.out.println("\nCuenta " + cuentas.get(i).numero + " - monto: " + cuentas.get(i).monto);
        				}
        				lector.nextLine();
        			}
        			break;
        		case 3: 
        			System.out.println("Ingrese nombre de usuario\n");
        			username = lector.nextLine();
        			System.out.println("Ingrese password\n");
        			password = lector.nextLine();
        			if (proto.login(username, password).get()) {
            			System.out.println("Ingrese su numero de id documento a realizar el deposito\n");
            			documento_id = lector.nextLine();
        				List<Cuenta> cuentas = proto.consulta_cuenta(documento_id).get();
        				for( int i = 0; i < cuentas.size(); i++) {
        					System.out.println("\nCuenta " + cuentas.get(i).numero + " - monto: " + cuentas.get(i).monto);
        				}
        				System.out.println("Ingrese el numero de cuenta para retirar el dinero");
        				num_cuenta = lector.nextInt();
        				System.out.println("Ingrese el monto a depositar");
        				monto = lector.nextDouble();
            			if (!proto.deposito(num_cuenta, monto).get()) {
            				System.out.println("Error...");
            			}
            			else {
            				System.out.println("Datos invalidos...");
            				break;
            			}
        			}
        			break;
        		case 4: 
        			System.out.println("Ingrese nombre de usuario\n");
        			username = lector.nextLine();
        			System.out.println("Ingrese password\n");
        			password = lector.nextLine();
        			if (proto.login(username, password).get()) {
            			System.out.println("Ingrese su numero de id documento para realizar la transferencia\n");
            			documento_id = lector.nextLine();
        				List<Cuenta> cuentas = proto.consulta_cuenta(documento_id).get();
        				for( int i = 0; i < cuentas.size(); i++) {
        					System.out.println("\nCuenta " + cuentas.get(i).numero + " - monto: " + cuentas.get(i).monto);
        				}
        				System.out.println("Ingrese el numero de cuenta para retirar el dinero");
        				num_cuenta = lector.nextInt();
        				System.out.println("Ingrese el numero de cuenta a cual transferir");
        				num_cuenta2 = lector.nextInt();
        				System.out.println("Ingrese el monto a transferir");
        				monto = lector.nextDouble();
            			if (!proto.transferencia(num_cuenta, num_cuenta2, monto).get()) {
            				System.out.println("Error...");
            			}
            			else {
            				System.out.println("Datos invalidos...");
            				break;
            			}
        			}
        			break;
        		case 5: 
        			System.out.println("Ingrese nombre de usuario\n");
        			username = lector.nextLine();
        			System.out.println("Ingrese password\n");
        			password = lector.nextLine();
        			if (proto.login(username, password).get()) {
            			System.out.println("Ingrese su numero de id documento a realizar el deposito\n");
            			documento_id = lector.nextLine();
        				List<Cuenta> cuentas = proto.consulta_cuenta(documento_id).get();
        				for( int i = 0; i < cuentas.size(); i++) {
        					System.out.println("\nCuenta " + cuentas.get(i).numero + " - monto: " + cuentas.get(i).monto);
        				}
        				System.out.println("Ingrese el numero de cuenta para retirar el dinero");
        				num_cuenta = lector.nextInt();
        				System.out.println("Ingrese el monto a retirar");
        				monto = lector.nextDouble();
            			if (!proto.retiro(num_cuenta, monto).get()) {
            				System.out.println("Error...");
            			}
            			else {
            				System.out.println("Datos invalidos...");
            				break;
            			}
        			}
        			break;
        	}
        }
    }

}
