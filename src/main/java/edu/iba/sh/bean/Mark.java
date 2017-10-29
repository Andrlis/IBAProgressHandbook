package edu.iba.sh.bean;

import java.util.Date;

public class Mark {

	private int id;
	private int studentId;
	private String date;
	private int professorId;
	private int mark;
	private int studyId;
	private String comments;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}


	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}


	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mark other = (Mark) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (mark != other.mark)
			return false;
		if (professorId != other.professorId)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mark [id=" + id + ", studentId=" + studentId + ", date=" + date
				+ ", professorId=" + professorId + ", mark=" + mark
				+ ", comments=" + comments + "]";
	}
	
	
}
