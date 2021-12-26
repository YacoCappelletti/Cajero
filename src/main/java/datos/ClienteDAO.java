
package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteDAO {
    
    private static final String SQL_SELECT = "SELECT * FROM Clientes";
    private static final String SQL_SELECT_ONE = "SELECT * FROM Clientes WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO Clientes(usuario, contraseña, saldo) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE clientes SET usuario = ?, contraseña = ?, saldo = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE id = ?";
    
    
    public List<Cliente> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                double saldo = rs.getDouble("saldo");
                cliente = new Cliente(id, usuario, contraseña, saldo);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return clientes;
    }
    
    public Cliente seleccionar_uno(int idCliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ONE);
            stmt.setInt(1,  idCliente);
            rs = stmt.executeQuery();
            System.out.println(rs.toString());
            while(rs.next()){
            int id = rs.getInt("id");
            String usuario = rs.getString("usuario");
            String contraseña = rs.getString("contraseña");
            double saldo = rs.getDouble("saldo");
            cliente = new Cliente(id, usuario, contraseña, saldo);
            }
                    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return cliente;
    }
    
    
    public int insertar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getUsuario());
            stmt.setString(2, cliente.getContraseña());
            stmt.setString(3,String.valueOf(cliente.getSaldo()));
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return registros;
    }
    
    
    public int actualizar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getUsuario());
            stmt.setString(2, cliente.getContraseña());
            stmt.setString(3,String.valueOf(cliente.getSaldo()));
            stmt.setString(4,String.valueOf(cliente.getId()));
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return registros;
    }
    public int eliminar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,cliente.getId());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return registros;
    }
    
    
    
}
