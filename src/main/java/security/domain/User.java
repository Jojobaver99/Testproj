package security.domain;

import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name="usr")
public class User {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String username;
private String surname;
private String fathername;
private String password;
private String email;
private String fileName;
private boolean active;
@ElementCollection(targetClass=Role.class,fetch=FetchType.EAGER)
@CollectionTable(name="user_role",joinColumns=@JoinColumn(name="user_id"))
@Enumerated(EnumType.STRING)
private Set<Role> roles;
@OneToOne
@JoinColumn(name = "rating", referencedColumnName = "id")
private Rating rating;
@OneToOne
@JoinColumn(name = "cert", referencedColumnName = "id")
private Certificate certificate;
@OneToOne
@JoinColumn(name = "userfac", referencedColumnName = "id")
private UserFac userfac;

public UserFac getUserfac() {
	return userfac;
}
public void setUserfac(UserFac userfac) {
	this.userfac = userfac;
}
public Long getId() {
	return id;
}
public String getEmail() {
	return email;
}
public Certificate getCertificate() {
	return certificate;
}
public void setCertificate(Certificate certificate) {
	this.certificate = certificate;
}
public void setEmail(String email) {
	this.email = email;
}
public void setId(Long id) {
	this.id = id;
}
public Rating getRating() {
	return rating;
}
public void setRating(Rating rating) {
	this.rating = rating;
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
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
public Set<Role> getRoles() {
	return roles;
}
public void setRoles(Set<Role> roles) {
	this.roles = roles;
}
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getFathername() {
	return fathername;
}
public void setFathername(String fathername) {
	this.fathername = fathername;
}
}
