
package dominio;


public class Transaccion {
    
    private int id;
    private int clienteId;
    private String fecha;
    private String tipo;
    private double monto;

    public Transaccion() {
    }

    public Transaccion(int id) {
        this.id = id;
    }

    public Transaccion(int clienteId, String fecha, String tipo, double monto) {
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
    }

    public Transaccion(int id, int clienteId, String fecha, String tipo, double monto) {
        this.id = id;
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "id=" + id + ", clienteId=" + clienteId + ", fecha=" + fecha + ", tipo=" + tipo + ", monto=" + monto + '}';
    }
    
    
    
}
