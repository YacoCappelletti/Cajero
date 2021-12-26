
package dominio;

public class Cliente {
    
    private int id;
    private String usuario;
    private String contraseña;
    private double saldo;
    
    Cliente(){
        
    }

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(String usuario, String contraseña, double saldo) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.saldo = saldo;
    }

    public Cliente(int id, String usuario, String contraseña, double saldo) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + ", saldo=" + saldo + '}';
    }
    
    
    
    
    
}
