package com.smg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smg.dao.TeacherDao;
import com.smg.entity.Teacher;
import com.smg.util.DBUtil;

/**
 * <p>Title: TeacherDaoImpl</p>
 * <p>Description: 教师业务接口实现</p>
 * <p>Company: www.ssmmgg.com</p>
 * @author 曾辉
 * @date 2018年7月2日 下午1:03:54
 * @version 1.0
 */
public class TeacherDaoImpl implements TeacherDao {
	
	/**(non-Javadoc)
	 * <p>Title: selectTeacherList</p>
	 * <p>Description: 查找所有教师</p>
	 * @param teacherId
	 * @return List<Teacher>
	 * @see com.smg.dao.TeacherDao#selectTeacherList(java.lang.String)
	 */
	@Override
	public List<Teacher> selectTeacherList(String teacherId){
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		List<Teacher> teacherList = null;
		String sql = "SELECT teacher.* FROM teacher";
		if(teacherId != null) {
			sql = sql + " WHERE teacher_id = "+teacherId;
		}
		try {
			connection = DBUtil.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			rs = prepareStatement.executeQuery();
			if(rs != null) {
				teacherList = new ArrayList<Teacher>();
			}
			while(rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacherId(rs.getInt("teacher_id"));
				teacher.setTeacherName(rs.getString("teacher_name"));
				teacher.setTeacherAge(rs.getInt("teacher_age"));
				teacher.setTeacherAddress(rs.getString("teacher_address"));
				teacherList.add(teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(prepareStatement != null) prepareStatement.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return teacherList; 
	}
	
	/**(non-Javadoc)
	 * <p>Title: deleteTeacherById</p>
	 * <p>Description: 通过id删除教师</p>
	 * @param teacherId
	 * @return Integer
	 * @see com.smg.dao.TeacherDao#deleteTeacherById(java.lang.Integer)
	 */
	@Override
	public Integer deleteTeacherById(Integer teacherId) {
		if(teacherId == null) {
			return 0;
		}
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String sql = "DELETE FROM teacher WHERE teacher_id = ?";
		int result = 0;
		try {
			connection = DBUtil.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, teacherId);
			result = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(prepareStatement != null) prepareStatement.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	/**(non-Javadoc)
	 * <p>Title: updateTeacher</p>
	 * <p>Description: 更新教师</p>
	 * @param teacherId
	 * @param teacherName
	 * @param teacherAge
	 * @param teacherAddress
	 * @return Integer
	 * @see com.smg.dao.TeacherDao#updateTeacher(java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String)
	 */
	@Override
	public Integer updateTeacher(Integer teacherId, String teacherName, Integer teacherAge, String teacherAddress) {
		if(teacherId == null && teacherName == null && teacherName == "" && teacherAge == null &&
				teacherAddress == null && teacherAddress == ""){
			return 0;
		}
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String sql = "UPDATE teacher SET teacher_name = ?, teacher_age = ?, teacher_address = ? WHERE teacher_id = ?";
		int result = 0;
		try {
			connection = DBUtil.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, teacherName);
			prepareStatement.setInt(2, teacherAge);
			prepareStatement.setString(3, teacherAddress);
			prepareStatement.setInt(4, teacherId);
			result = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(prepareStatement != null) prepareStatement.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**(non-Javadoc)
	 * <p>Title: addTeacher</p>
	 * <p>Description: 添加教师</p>
	 * @param teacherName
	 * @param teacherAge
	 * @param teacherAddress
	 * @return Integer
	 * @see com.smg.dao.TeacherDao#addTeacher(java.lang.String, java.lang.Integer, java.lang.String)
	 */
	@Override
	public Integer addTeacher(String teacherName, Integer teacherAge, String teacherAddress) {
		if(teacherName == null && teacherName == "" && teacherAge == null &&
				teacherAddress == null && teacherAddress == "") {
			return 0;
		}
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		int result = 0;
		String sql = "INSERT INTO teacher(teacher_name, teacher_age, teacher_address) VALUES (?, ?, ?)";
		try {
			connection = DBUtil.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, teacherName);
			prepareStatement.setInt(2, teacherAge);
			prepareStatement.setString(3, teacherAddress);
			result = prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(prepareStatement != null) prepareStatement.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl(); 
		System.out.println(teacherDaoImpl.delectTeacherById(5));
	}*/

}
