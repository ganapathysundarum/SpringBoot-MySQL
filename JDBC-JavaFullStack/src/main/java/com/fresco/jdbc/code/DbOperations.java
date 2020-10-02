package com.fresco.jdbc.code;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fresco.jdbc.code.util.DbUtil;

public class DbOperations {
	Connection con;
	public DbOperations() {
		con = DbUtil.getConnection();
	}
	public boolean insertSubject(String name) throws SQLException {		
		String sql = "insert into subject(name) values(?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);		
		int rows = ps.executeUpdate();		
		return (rows>0?true:false);
	}
	public ArrayList getSubjectById(int id) throws SQLException {
		ArrayList names = new ArrayList();
		String sql = "select id,name from subject where id="+id+"";
		Statement ps = con.createStatement();
		ResultSet rs = ps.executeQuery(sql);
		while(rs.next()){
			names.add(rs.getInt(1));
			names.add(rs.getString(2));
		}
		return names;
	}
	public ResultSet getAllSubjects() throws SQLException {
		String sql = "select id,name from subject";
		Statement ps = con.createStatement();
		ResultSet rs = ps.executeQuery(sql);
		return rs;
	}
	public boolean insertStudent(String student_name, float score, String name) throws SQLException {
		String sql1 = "select id,name from subject where name='"+name+"'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql1);
		int subj_id = 0;
		while(rs.next()){
			subj_id = rs.getInt(1);
		}
		String sql = "insert into student(student_name,score,subject_id) values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, student_name);
		ps.setFloat(2, score);
		ps.setInt(3, subj_id);
		int rows = ps.executeUpdate();		
		return (rows>0?true:false);
		
	}
	public ArrayList getStudentyId(int id) throws SQLException {
		ArrayList names = new ArrayList();
		String sql = "select id,student_name,score,subject_id from student where id="+id+"";
		Statement ps = con.createStatement();
		ResultSet rs = ps.executeQuery(sql);
		while(rs.next()){
			names.add(rs.getInt(1));
			names.add(rs.getString(2));
			names.add(rs.getFloat(3));
			names.add(rs.getInt(4));
		}
		return names;
	}
	public ResultSet getAllStudents() throws SQLException {
		
		ArrayList names = new ArrayList();
		String sql = "select id,student_name,score,subject_id from student";
		Statement ps = con.createStatement();
		ResultSet rs = ps.executeQuery(sql);
		
		return rs;
	}
	
}