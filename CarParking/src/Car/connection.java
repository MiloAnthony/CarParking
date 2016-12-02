package Car;
/*
 * 工具类 获得连接 和关闭连接
 * */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class connection {
	protected Connection con;
	

	
	public Connection getConn(){ //获得连接
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","123456");
				//JOptionPane.showMessageDialog(null,"连接成功");

				createDatabase(con);
			}catch(SQLException sqle){
			           JOptionPane.showMessageDialog(null,sqle.toString(),"连接出错!",JOptionPane.ERROR_MESSAGE );
			    }catch(ClassNotFoundException e) {
			           JOptionPane.showMessageDialog(null,e.toString(),"连接出错!",JOptionPane.ERROR_MESSAGE );
			    }catch(Exception e){
			           JOptionPane.showMessageDialog(null,e.toString(),"连接出错!",JOptionPane.ERROR_MESSAGE );
			    }	
			return con;
	}
	
	public static void createDatabase(Connection con){
        if(con==null){
        	JOptionPane.showMessageDialog(null,"数据库未连接");
        }	
        Statement state=null;
        try{
        	if(con!=null){
        		
            state=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
            state.executeUpdate("create database if not exists carpark");          
            state.execute("use carpark;");  
            createPersonsTable(state);
        	}
        	
        }catch(Exception e){ 
        	e.printStackTrace();
             System.out.println("创建数据库失败");
        }finally{
            try{
                state.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }

public static void createPersonsTable(Statement state) {
    String sql="create table if not exists car"
    		+ "( "
    		+ "name varchar(20) ,"
    		+ "phone varchar(12), "
    		+ "type varchar(20)  ,"
    		+ "number varchar(20)  ,"
    		+ "indate datetime  NULL "
			+ ")"
    		+"";
    String sql2="create table if not exists roadcar"
    		+ "( "
    		+ "name varchar(20) ,"
    		+ "phone varchar(12), "
    		+ "type varchar(20)  ,"
    		+ "number varchar(20)  ,"
    		+ "indate datetime NULL "
			+ ")"
    		+"";
//    System.out.println(sql);
    try{
         state.executeUpdate(sql); 
         state.executeUpdate(sql2); 
    }catch(Exception e){
    	e.printStackTrace();
        System.out.println("创建car表失败");

    }

}



public static void deleteDatabase(Statement state){
		try {
			state.executeUpdate("drop database car;");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
            System.out.println("删除数据库失败");
		}

}
	
	public void closeAll(ResultSet rs,Statement stmt,Connection con){ //断开连接
		try{if(rs!=null)rs.close();}catch(Exception ex){}
	    try{if(stmt!=null)stmt.close();}catch(Exception ex){}
	    try{if(con!=null)con.close();}catch(Exception ex){}	
	}
}
