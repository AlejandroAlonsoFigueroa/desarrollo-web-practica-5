package alejandro.figueroa.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.sql.*;
import java.math.*;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name="venta")
public class Venta implements Serializable {
    @Id
    @GeneratedValue(generator = "cliente_idcliente_seq", strategy = GenerationType.IDENTITY)
    //@GeneratedValue(generator = "venta_idventa_seq", strategy = GenerationType.SEQUENCE)
    //@SequenceGenerator(name = "venta_idventa_seq", sequenceName = "venta_idventa_seq", 
    //        initialValue = 1, allocationSize = 1)
    @Column(name = "idventa")
    private Long idventa;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "total")
    private Integer total;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getIdventa() {
        return idventa;
    }

    public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setIdventa(Long idventa) {
        this.idventa = idventa;
    }

   
//    public Long getIdCliente() {
//        return idCliente;
//    }
//
//    public void setIdCliente(Long idCliente) {
//        this.idCliente = idCliente;
//    }
    
    
}