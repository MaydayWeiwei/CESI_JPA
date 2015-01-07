package eu.telecom_bretagne.CESI.data.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the employe database table.
 * 
 */
@Entity
@NamedQuery(name="Employe.findAll", query="SELECT e FROM Employe e")
public class Employe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLOYE_ID_GENERATOR", sequenceName="EMPLOYE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYE_ID_GENERATOR")
	private Integer id;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to Service
	@ManyToOne
	@JoinColumn(name="service_fk")
	private Service service;

	public Employe() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

}