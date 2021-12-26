/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Cliente;
import dominio.Transaccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yaco
 */
public class TransaccionDAO {
    
    private static final String SQL_SELECT = "SELECT * FROM transacciones";
    private static final String SQL_FILTER_SELECT = "SELECT * FROM transacciones WHERE cliente_id = ?";
    private static final String SQL_SELECT_ONE = "SELECT * FROM transacciones WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO transacciones(cliente_id, fecha, tipo, monto) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE transacciones  SET cliente_id = ?, fecha = ?, tipo = ?, monto = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM transacciones WHERE id = ?";
    
    
    
    public List<Transaccion> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Transaccion transaccion = null;
        List<Transaccion> transacciones = new ArrayList<>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int clienteId = rs.getInt("cliente_id");
                String fecha = rs.getString("fecha");
                String tipo = rs.getString("tipo");
                double monto = rs.getDouble("monto");
                
                transaccion = new Transaccion(id, clienteId, fecha, tipo, monto );
                transacciones.add(transaccion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return transacciones;
    }
    
    public List<Transaccion> filtrar(int cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Transaccion transaccion = null;
        List<Transaccion> transacciones = new ArrayList<>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_FILTER_SELECT);
            stmt.setInt(1,  cliente);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int clienteId = rs.getInt("cliente_id");
                String fecha = rs.getString("fecha");
                String tipo = rs.getString("tipo");
                double monto = rs.getDouble("monto");
                
                transaccion = new Transaccion(id, clienteId, fecha, tipo, monto );
                transacciones.add(transaccion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return transacciones;
    }
    
    
    
    
    
    public Transaccion seleccionar_uno(int idTransaccion){
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Transaccion transaccion = null;

    try {
        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_SELECT_ONE);
        stmt.setInt(1,  idTransaccion);
        rs = stmt.executeQuery();
        System.out.println(rs.toString());
        while(rs.next()){
        int id = rs.getInt("id");
        int clienteId = rs.getInt("cliente_id");
        String fecha = rs.getString("fecha");
        String tipo = rs.getString("tipo");
        double monto = rs.getDouble("monto");
        transaccion = new Transaccion(id, clienteId, fecha, tipo, monto);
        }

    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    }finally{
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return transaccion;
    }
   
        
        
        public int insertar(Transaccion transaccion){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,transaccion.getClienteId());
            stmt.setString(2, transaccion.getFecha());
            stmt.setString(3, transaccion.getTipo());
            stmt.setDouble(4, transaccion.getMonto());
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
    
        public int actualizar(Transaccion transaccion){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, transaccion.getClienteId() );
            stmt.setString(2,transaccion.getFecha() );
            stmt.setString(3,transaccion.getTipo());
            stmt.setDouble(4,transaccion.getMonto());
            stmt.setInt(5, transaccion.getId());
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
    
        
    public int eliminar(Transaccion transaccion){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,transaccion.getId());
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
