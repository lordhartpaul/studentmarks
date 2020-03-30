package com.studentproject.studentmarks.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;


import com.studentproject.studentmarks.model.studentmarks;



@Service
public class studentmarksDAO {
	
	
	JdbcTemplate template;
	
	
	@Autowired
	public void SetDataSource(DataSource datasource)
	{
		template = new JdbcTemplate(datasource);
	}
	
	public void save(studentmarks p)
	{
		
		String sql = "insert into studentmarks(name,marks) values ('"+p.getName()+"',"+p.getMarks()+")";
	
	    template.update(sql);
	
	}
	
public List<studentmarks> getAllstudentmarkss(){
		
		return template.query("select * from studentmarks", new ResultSetExtractor<List<studentmarks>>() {
			
			public List<studentmarks> extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				List<studentmarks> list = new ArrayList<studentmarks>();
				while(rs.next())
				{
					studentmarks e = new studentmarks();
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setMarks(rs.getInt(3));
					list.add(e);
					
					}
				
				return list;
			}
			
		});
	}


public List<studentmarks> getstudentmarkssByPage(int pageid, int total){
	
	
	String sql = "select * from studentmarks limit "+(pageid-1)+","+total;
	
	return template.query(sql, new ResultSetExtractor<List<studentmarks>>() {
			
			public List<studentmarks> extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				List<studentmarks> list = new ArrayList<studentmarks>();
				while(rs.next())
				{
					studentmarks e = new studentmarks();
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setMarks(rs.getInt(3));
					
					list.add(e);
					}
				return list;
			}
			
		});
	}

public studentmarks getstudentmarksById(int id)
{
	   return template.query("select * from studentmarks where ID="+id,new ResultSetExtractor<studentmarks>() {
			
			public studentmarks extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				studentmarks e = new studentmarks();
				while(rs.next())
				{
					
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setMarks(rs.getInt(3));
					
					}
				return e;
			}
			
		});
	}

public void update(studentmarks p)
{
	String sql="update studentmarks set Name ='"+p.getName()+"',Marks="+p.getMarks()+" where ID="+p.getId()+"";
    template.update(sql);

}

public void delete(int id) {
	
	String sql="delete from studentmarks where ID="+id+"";
	template.update(sql);
}

public void delete() {
	
	String sql = "delete from studentmarks where ID>0";
	template.update(sql);
}

public int count() {
	String sql ="select count(*) from studentmarks";
	int count = template.queryForObject(sql, Integer.class);
	return count;
}
	

}
