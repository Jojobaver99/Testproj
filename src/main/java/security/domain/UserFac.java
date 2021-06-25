package security.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userfac")
public class UserFac {
	@Id
	private Long id;
	Fac [] fac=new Fac[5];
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Fac[] getFac() {
		return fac;
	}
	public void setFac(Fac fac,int index) {
		this.fac[index] = fac;
	}
	
	
}

