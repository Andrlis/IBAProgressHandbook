package edu.iba.sh.bean;

public class Study {

	private int id;
	private String name;
	private int hours;
	private int professorId;
	private double avgMark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getProfessorId() {
		return professorId;
	}
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	public double getAvgMark() {
		return avgMark;
	}
	public void setAvgMark(double avgMark) {
		this.avgMark = avgMark;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Study other = (Study) obj;
		if (Double.doubleToLongBits(avgMark) != Double
				.doubleToLongBits(other.avgMark))
			return false;
		if (hours != other.hours)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (professorId != other.professorId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Study [id=" + id + ", name=" + name + ", hours=" + hours
				+ ", professorId=" + professorId + ", avgMark=" + avgMark + "]";
	}
}
