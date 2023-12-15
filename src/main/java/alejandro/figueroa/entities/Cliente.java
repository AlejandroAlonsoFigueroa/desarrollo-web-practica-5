package alejandro.figueroa.entities;
import javax.persistence.Entity;

import javax.persistence.Table;
import java.io.Serializable; 
import java.util.List;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
  
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "cliente_idcliente_seq", strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private Long idCliente;
    
    @Column(name = "nombre")
    private String nombre;
    @Column (name = "rfc")
    private String rfc;
    
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
    private List<Venta> ventas;    

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", rfc=" + rfc + ", ventas=" + ventas + "]";
	}
    
    
}
