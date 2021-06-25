package security.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table(name="cert")
public class Certificate {
	@Id
	private Long id;
	
	@Lob
	byte[] file;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		System.out.println(file.length);
	this.file=new byte[file.length];
	int i=0;
	for(Byte b:file) {
		this.file[i]=b;
	}
	}
	
}
