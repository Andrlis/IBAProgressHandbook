package edu.iba.sh.bean;

public class Group {
	private String groupNumber;
	private double avgMark;

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
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
		Group other = (Group) obj;
		if (Double.doubleToLongBits(avgMark) != Double
				.doubleToLongBits(other.avgMark))
			return false;
		if (groupNumber == null) {
			if (other.groupNumber != null)
				return false;
		} else if (!groupNumber.equals(other.groupNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Group [groupNumber=" + groupNumber + ", avgMark=" + avgMark
				+ "]";
	}
}
