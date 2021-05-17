package com.example.comercio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity // Representacion de la tabla
@Table(name = "comercios") //Nombre de la tabla
public class Comercios {

	@Id // Id llave primaria
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nom_comercio") // Columna
	@NotBlank(message = "El nombre es obligatorio")
	private String nomcomercio;
	
	@Column(name = "afprp_maximo")
	 @NotBlank(message = "Campo es obligatorio")
	private String 	afprpmaximo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomcomercio() {
		return nomcomercio;
	}

	public void setNomcomercio(String nomcomercio) {
		this.nomcomercio = nomcomercio;
	}

	public String getAfprpmaximo() {
		return afprpmaximo;
	}

	public void setAfprpmaximo(String afprpmaximo) {
		this.afprpmaximo = afprpmaximo;
	}

	public Comercios() {}
	public Comercios(long id, String nomcomercio, String afprpmaximo) {
		super();
		this.id = id;
		this.nomcomercio = nomcomercio;
		this.afprpmaximo = afprpmaximo;
	}
	
	 @Override
	    public String toString() {
	        return "Comercios{" + "id=" + id + ", name=" + nomcomercio + ", afprpmaximo=" + afprpmaximo + '}';
	    }
	    
}
