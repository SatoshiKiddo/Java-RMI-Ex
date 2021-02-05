package hvqzao.java.rmi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {

    private static final Logger LOGGER =
        Logger.getLogger(PostgreSQLDAO.class.getName());
    private static final Optional<Connection> connection = JdbcConnection.getConnection();

    public static Optional<Boolean> login(String username, String password) {
        return connection.flatMap(conn -> {
            Optional<Boolean> customer = Optional.empty();
            String sql = "SELECT login(" + username + ", " + password + ")";

            try (Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql)) {

                if (resultSet.next()) {
                    boolean resultado = resultSet.getBoolean(0);

                    customer = Optional.of((Boolean)resultado);

                    LOGGER.log(Level.INFO, "Found {0} in database", customer.get());
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }

            return customer;
        });
    }
    
    public static Optional<Integer> apertura_cuenta(String documento_id, String nombre, String username, String password) {
        return connection.flatMap(conn -> {
            Optional<Integer> customer = Optional.empty();
            String sql = "SELECT apertura_cuenta("+ documento_id + ", " + nombre + ", " + username + ", " + password + ")";

            try (Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql)) {

                if (resultSet.next()) {
                	int resultado = resultSet.getInt(0);
                	
                	customer = Optional.of(resultado);

                    LOGGER.log(Level.INFO, "Found {0} in database", customer.get());
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }

            return customer;
        });
    }
    
    public static Optional<List<Cuenta>> consulta_cuenta(String documento_id) {
        return connection.flatMap(conn -> {
            Optional<List<Cuenta>> customer = Optional.empty();
            String sql = "SELECT consulta_cuentas(" + documento_id + ")";

            try (Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql)) {

            	List<Cuenta> resultado = new ArrayList(); 
                while (resultSet.next()) {
                	resultado.add(new Cuenta(
                			resultSet.getInt(0),
                			resultSet.getDouble(1)
                			));

                    LOGGER.log(Level.INFO, "Found {0} in database", customer.get());
                }
                
                customer = Optional.of(resultado);
                
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }

            return customer;
        });
    }
    
    public static Optional<List<Transacciones>> consulta_transacciones(Double numero, Double limite) {
        return connection.flatMap(conn -> {
            Optional<List<Transacciones>> customer = Optional.empty();
            String sql = "SELECT consulta_transacciones(" + numero + ", " + limite + ")";

            try (Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql)) {
            	
            	List<Transacciones> resultado = new ArrayList(); 
                while (resultSet.next()) {
                	resultado.add(new Transacciones(
                			resultSet.getInt(0),
                			resultSet.getDouble(1),
                			resultSet.getDate(2),
                			resultSet.getDate(3),
                			resultSet.getInt(4),
                			resultSet.getInt(5)
                			));
                	
                    LOGGER.log(Level.INFO, "Found {0} in database", customer.get());
                }

            	customer = Optional.of(resultado);
            	
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }

            return customer;
        });
    }
    
    public static Optional<String> consulta_deposito(String documento_id, int password) {
        return connection.flatMap(conn -> {
            Optional<String> customer = Optional.empty();
            String sql = "SELECT consulta_deposito(" + documento_id + ", " + password + ")";

            try (Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql)) {

                if (resultSet.next()) {
                    String resultado = resultSet.getString(0);

                    customer = Optional.of(resultado);

                    LOGGER.log(Level.INFO, "Found {0} in database", customer.get());
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }

            return customer;
        });
    }
    
    public static Optional<Boolean> deposito(String username, String password) {
        return connection.flatMap(conn -> {
            Optional<Boolean> customer = Optional.empty();
            String sql = "SELECT login(" + username + ", " + password + ")";

            try (Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql)) {

                if (resultSet.next()) {
                    boolean resultado = resultSet.getBoolean(0);

                    customer = Optional.of(resultado);

                    LOGGER.log(Level.INFO, "Found {0} in database", customer.get());
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }

            return customer;
        });
    }
    
    public static Optional<Boolean> retiro(String username, String password) {
        return connection.flatMap(conn -> {
            Optional<Boolean> customer = Optional.empty();
            String sql = "SELECT login(" + username + ", " + password + ")";

            try (Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql)) {

                if (resultSet.next()) {
                    boolean resultado = resultSet.getBoolean(0);

                    customer = Optional.of(resultado);

                    LOGGER.log(Level.INFO, "Found {0} in database", customer.get());
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }

            return customer;
        });
    }
    
    public static Optional<Boolean> transferencia(String username, String password) {
        return connection.flatMap(conn -> {
            Optional<Boolean> customer = Optional.empty();
            String sql = "SELECT login(" + username + ", " + password + ")";

            try (Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql)) {

                if (resultSet.next()) {
                    boolean resultado = resultSet.getBoolean(0);

                    customer = Optional.of(resultado);

                    LOGGER.log(Level.INFO, "Found {0} in database", customer.get());
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }

            return customer;
        });
    }

    // Other methods of the interface which currently aren't implemented yet
}