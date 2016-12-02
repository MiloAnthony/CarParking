package Car;
/*
 * ������ ������� �͹ر�����
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
	

	
	public Connection getConn(){ //�������
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","123456");
				//JOptionPane.showMessageDialog(null,"���ӳɹ�");

				createDatabase(con);
			}catch(SQLException sqle){
			           JOptionPane.showMessageDialog(null,sqle.toString(),"���ӳ���!",JOptionPane.ERROR_MESSAGE );
			    }catch(ClassNotFoundException e) {
			           JOptionPane.showMessageDialog(null,e.toString(),"���ӳ���!",JOptionPane.ERROR_MESSAGE );
			    }catch(Exception e){
			           JOptionPane.showMessageDialog(null,e.toString(),"���ӳ���!",JOptionPane.ERROR_MESSAGE );
			    }	
			return con;
	}
	
	public static void createDatabase(Connection con){
        if(con==null){
        	JOptionPane.showMessageDialog(null,"���ݿ�δ����");
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
             System.out.println("�������ݿ�ʧ��");
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
        System.out.println("����car��ʧ��");

    }

}



public static void deleteDatabase(Statement state){
		try {
			state.executeUpdate("drop database car;");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
            System.out.println("ɾ�����ݿ�ʧ��");
		}

}
	
	public void closeAll(ResultSet rs,Statement stmt,Connection con){ //�Ͽ�����
		try{if(rs!=null)rs.close();}catch(Exception ex){}
	    try{if(stmt!=null)stmt.close();}catch(Exception ex){}
	    try{if(con!=null)con.close();}catch(Exception ex){}	
	}
}
