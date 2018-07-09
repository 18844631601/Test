package com.smg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.smg.dao.TeacherDao;
import com.smg.dao.impl.TeacherDaoImpl;
import com.smg.entity.Teacher;

public class TeacherServlet extends HttpServlet{

	/**
	 * afafas
	 */
	private static final long serialVersionUID = 1L;
	
	private TeacherDao teacherDao = null;
	
	//用实现类来初始化接口
	@Override
	public void init() throws ServletException {
		super.init();
		teacherDao = new TeacherDaoImpl();
	}
	
	/**(non-Javadoc)
	 * <p>Title: service</p>
	 * <p>Description: 所有方法处理集合</p>
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("进来了");
		//参数获取用Papameter，属性用Attribute
		String method = req.getParameter("method");
		System.out.println(method);
		switch(method) {
			case "GET":doGet(req, resp);break;
			case "POST":doPost(req, resp);break;
			case "PUT":doPut(req, resp);break;
			case "DELETE":doDelete(req, resp);
		}
	}
	
	/**(non-Javadoc)
	 * <p>Title: doGet</p>
	 * <p>Description: GET方法查询教师</p>
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchId = req.getParameter("searchId");
		System.out.println(searchId);
		List<Teacher> teacherList = teacherDao.selectTeacherList(searchId);
		req.setAttribute("teacherList", teacherList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");    // 使用req对象获取RequestDispatcher对象
        dispatcher.forward(req, resp);
	}

	/**(non-Javadoc)
	 * <p>Title: doPost</p>
	 * <p>Description: POST方法添加教师</p>
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf8");
		String teacherName = req.getParameter("teacherName");
		teacherName = new String(teacherName.getBytes("ISO-8859-1"), "UTF-8");
		String teacherAge = req.getParameter("teacherAge");
		String teacherAddress = req.getParameter("teacherAddress");
		teacherAddress = new String(teacherAddress.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println(teacherName+"=="+teacherAge+"=="+teacherAddress);
		Integer result = teacherDao.addTeacher(teacherName, Integer.parseInt(teacherAge), teacherAddress);
		req.setAttribute("result", result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");    // 使用req对象获取RequestDispatcher对象
        dispatcher.forward(req, resp);
	}
	

	/**(non-Javadoc)
	 * <p>Title: doPut</p>
	 * <p>Description: PUT方法修改教师</p>
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPut(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf8");
		String teacherId = req.getParameter("teacherId");
		String teacherName = req.getParameter("teacherName");
		teacherName = new String(teacherName.getBytes("ISO-8859-1"), "UTF-8");
		String teacherAge = req.getParameter("teacherAge");
		String teacherAddress = req.getParameter("teacherAddress");
		teacherAddress = new String(teacherAddress.getBytes("ISO-8859-1"), "UTF-8");
		Integer result = teacherDao.updateTeacher(Integer.parseInt(teacherId), teacherName, Integer.parseInt(teacherAge), teacherAddress);
		req.setAttribute("result", result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");    // 使用req对象获取RequestDispatcher对象
        dispatcher.forward(req, resp);
	}

	/**(non-Javadoc)
	 * <p>Title: doDelete</p>
	 * <p>Description: DELETE方法根据id删除教师</p>
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doDelete(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String teacherId = req.getParameter("teacherId");
		Integer result = teacherDao.deleteTeacherById(Integer.parseInt(teacherId));
		req.setAttribute("result", result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");    // 使用req对象获取RequestDispatcher对象
        dispatcher.forward(req, resp);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}
