package com.smg.entity;

/**
 * <p>Title: Teacher</p>
 * <p>Description: 教师类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年7月2日 下午12:30:08
 * @version 1.0
 */
public class Teacher {
	private Integer teacherId;
	private String teacherName;
	private Integer teacherAge;
	private String teacherAddress;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (teacherAddress == null) {
			if (other.teacherAddress != null)
				return false;
		} else if (!teacherAddress.equals(other.teacherAddress))
			return false;
		if (teacherAge == null) {
			if (other.teacherAge != null)
				return false;
		} else if (!teacherAge.equals(other.teacherAge))
			return false;
		if (teacherId == null) {
			if (other.teacherId != null)
				return false;
		} else if (!teacherId.equals(other.teacherId))
			return false;
		if (teacherName == null) {
			if (other.teacherName != null)
				return false;
		} else if (!teacherName.equals(other.teacherName))
			return false;
		return true;
	}
	public String getTeacherAddress() {
		return teacherAddress;
	}
	public Integer getTeacherAge() {
		return teacherAge;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teacherAddress == null) ? 0 : teacherAddress.hashCode());
		result = prime * result + ((teacherAge == null) ? 0 : teacherAge.hashCode());
		result = prime * result + ((teacherId == null) ? 0 : teacherId.hashCode());
		result = prime * result + ((teacherName == null) ? 0 : teacherName.hashCode());
		return result;
	}
	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}
	public void setTeacherAge(Integer teacherAge) {
		this.teacherAge = teacherAge;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherAge=" + teacherAge
				+ ", teacherAddress=" + teacherAddress + "]";
	}
}
