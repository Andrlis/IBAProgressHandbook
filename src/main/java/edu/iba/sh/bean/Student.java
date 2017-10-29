package edu.iba.sh.bean;

public class Student {
	
	private int id;
	private String firstName;
	private String secondName;
	private double avgMark;
	private String groupNumber;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	public double getAvgMark() {
		return avgMark;
	}
	
	public void setAvgMark(double avgMark) {
		this.avgMark = avgMark;
	}
	
	public String getGroupNumber() {
		return groupNumber;
	}
	
	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName
				+ ", secondName=" + secondName + ", avgMark=" + avgMark
				+ ", groupNumber=" + groupNumber + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Double.doubleToLongBits(avgMark) != Double
				.doubleToLongBits(other.avgMark))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (groupNumber == null) {
			if (other.groupNumber != null)
				return false;
		} else if (!groupNumber.equals(other.groupNumber))
			return false;
		if (id != other.id)
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		return true;
	}

}
