package security.domain;

import javax.persistence.*;

@Entity
@Table(name="fac")
public class Fac {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String name;
private int math;
private int physics;
private int history;
private int ukrainean;
private int english;
private int average;

public int getAverage() {
	return average;
}
public void setAverage(int average) {
	this.average = average;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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

}
