package com.yunhua;
import java.nio.charset.Charset;
import java.sql.*;
/*
 * 测试原生jdbc使用，注意数据库驱动jar包要手动下载，添加导入到项目中
 * */
public class TestJdbc {
	
	public static final  String URL="jdbc:mysql://localhost:3306/s36peixun"+"?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    
	public static void main(String[] args) {
		Connection conn=null;
	    Statement  stmt=null;
	    System.out.println("采用的字符集"+ Charset.defaultCharset().name());
		System.out.println("hello world");
		try {
			//1.加载驱动程序
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        //2. 获得数据库连接
	        conn = DriverManager.getConnection(URL, USER, PASSWORD);
	         //3.操作数据库，实现增删改查
	        stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT title,author FROM yu_news");
	        //如果有数据，rs.next()返回true
	        while(rs.next()){
	            System.out.println(rs.getString("title")+" 作者: "+rs.getString("author"));
	        }
		}catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	try {
        		if(stmt!=null)
        			stmt.close();
        		
        	}catch(SQLException se) {
        		
        	}
        	try {
        		if(conn!=null)
        			conn.close();
        		
        	}catch(SQLException se2) {
        		se2.printStackTrace();
        		
        	}
        }
		
	}

}
