package pe.edu.uni.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="FAT_PREFACTURA_AGRUPADO_201212")
public class invoceModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String numeroOtorgante;
	private int cve_netsuite;
	private int  consultas;
	private Double precio;

	public invoceModel() {
		
	}


}
