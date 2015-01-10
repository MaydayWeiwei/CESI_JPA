package eu.telecom_bretagne.CESI.data.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the service database table.
 * 
 */
@Entity
@NamedQuery(name="Service.findAll", query="SELECT s FROM Service s")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SERVICE_ID_GENERATOR", sequenceName="SERVICE_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SERVICE_ID_GENERATOR")
	private Integer id;

	private String nom;

	@Column(name="responsable_fk")
	private Integer responsableFk;

	//bi-directional many-to-one association to Employe
	@OneToMany(mappedBy="service")
	private Set<Employe> employes;

	//bi-directional many-to-one association to Service
	@ManyToOne
	@JoinColumn(name="service_rattache_fk")
	private Service service;

	//bi-directional many-to-one association to Service
	@OneToMany(mappedBy="service")
	private Set<Service> services;

	public Service() {
		employes = new HashSet<Employe> ();
		services = new HashSet<Service> ();
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

	public Integer getResponsableFk() {
		return this.responsableFk;
	}

	public void setResponsableFk(Integer responsableFk) {
		this.responsableFk = responsableFk;
	}

	public Set<Employe> getEmployes() {
		return this.employes;
	}

	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}

	public Employe addEmploye(Employe employe) {
		getEmployes().add(employe);
		employe.setService(this);

		return employe;
	}

	public Employe removeEmploye(Employe employe) {
		getEmployes().remove(employe);
		employe.setService(null);

		return employe;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Set<Service> getServices() {
		return this.services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	public Service addService(Service service) {
		getServices().add(service);
		service.setService(this);

		return service;
	}

	public Service removeService(Service service) {
		getServices().remove(service);
		service.setService(null);

		return service;
	}

}