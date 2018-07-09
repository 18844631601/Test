package com.smg.dao;

import java.util.List;

import com.smg.entity.Teacher;

public interface TeacherDao {

	
	/**
	 * <p>Title: selectTeacherList</p>
	 * <p>Description: 查询所有教师</p>
	 * @param teacherId
	 * @return List<Teacher>
	 */
	List<Teacher> selectTeacherList(String teacherId);

	/**
	 * <p>Title: delectTeacher</p>
	 * <p>Description: 根据id删除教师</p>
	 * @param teacherId
	 * @return Integer
	 */
	Integer deleteTeacherById(Integer teacherId);

	/**
	 * <p>Title: updateTeacher</p>
	 * <p>Description: 更新教师</p>
	 * @param teacherId
	 * @param teacherName
	 * @param teacherAge
	 * @param teacherAddress
	 * @return Integer
	 */
	Integer updateTeacher(Integer teacherId, String teacherName, Integer teacherAge, String teacherAddress);

	/**
	 * <p>Title: addTeacher</p>
	 * <p>Description: 添加教师</p>
	 * @param teacherName
	 * @param teacherAge
	 * @param teacherAddress
	 * @return Integer
	 */
	Integer addTeacher(String teacherName, Integer teacherAge, String teacherAddress);

}