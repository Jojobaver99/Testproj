package security.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rating")
public class Rating {
	@Id
	
	private Long id ;
	private int math;
	private int physics;
	private int history;
	private int ukrainean;
	Rating () {
	}
	public Rating(int math,int physics, int history,int ukrainean,int english){
		this.english=english;
		this.history=history;
		this.math=math;
		this.physics=physics;
		this.ukrainean=ukrainean;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getPhysics() {
		return physics;
	}
	public void setPhysics(int physics) {
		this.physics = physics;
	}
	public int getHistory() {
		return history;
	}
	public void setHistory(int history) {
		this.history = history;
	}
	public int getUkrainean() {
		return ukrainean;
	}
	public void setUkrainean(int ukrainean) {
		this.ukrainean = ukrainean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	private int english; 
}
