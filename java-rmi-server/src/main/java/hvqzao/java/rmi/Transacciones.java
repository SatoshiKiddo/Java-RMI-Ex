package hvqzao.java.rmi;

import java.util.Date;

public class Transacciones {
	
	public int id_transaccion;
	public Double monto;
	public Date fecha;
	public Date description;
	public int id_cuenta_origen;
	public int id_cuenta_destino;
	
	public Transacciones(int id_transaccion, Double monto, Date fecha, Date description, int id_cuenta_origen, int id_cuenta_destino) {
		this.id_transaccion= id_transaccion;
		this.monto = monto;
		this.fecha = fecha;
		this.description = description;
		this.id_cuenta_destino = id_cuenta_destino;
		this.id_cuenta_origen = id_cuenta_origen;
	}

}
