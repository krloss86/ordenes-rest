package ar.com.educacionit.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", 
		joinColumns = @JoinColumn(name = "users_id"), 
		inverseJoinColumns = @JoinColumn(name = "roles_id")
			)
	private Set<Roles> roles;

	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "users_id")
	private Socios socio;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	
	public Socios getSocio() {
		return socio;
	}

	public void setSocio(Socios socio) {
		this.socio = socio;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + username + ", password=" + password + ", roles=" + roles + "]";
	}
	
}
