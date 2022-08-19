package jdbcConnectivity;

import java.sql.*;

public class MysqlCon{  	
	
Connection con;
Statement stmt;

public MysqlCon()
{
	try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		 con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/USERINFO?allowPublicKeyRetrieval=true&useSSL=false","root","tushar123");    
		 stmt=con.createStatement();  
		
		}catch(Exception e){ System.out.println(e);}  
		} 

public void showTable () throws InterruptedException
{   
	synchronized (this) {
		Thread.sleep(2000);

	try {
	ResultSet rs=stmt.executeQuery("select * from userEntries");  
	while(rs.next())  
	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4));  
	
}
catch(Exception e)
{
System.out.print(e);
}}

}
public void getRecordById(int id) throws InterruptedException
{   
	synchronized (this) {Thread.sleep(2000);
	try {
		String query="Select * from userEntries where id="+id;
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)); 
			
	}

catch(Exception e)
	{
	System.out.print(e);
	}}
}

public void updateNameById(int id,String newName)throws InterruptedException
{  
	 synchronized (this) {
		 Thread.sleep(2000);

	try {
		String query="update userEntries set username='"+ newName+ "' where id="+id;
		int recordAffected=stmt.executeUpdate(query);
		System.out.println(recordAffected+" Records affected ....");
	}
	catch(Exception e)
	{
		System.out.print(e);
	}}
}

public void deleteRecordById(int id ) throws InterruptedException{
	
	synchronized (this) { Thread.sleep(2000);
		
	
try {
	String query="delete from userEntries where id="+id;
	int recordAffected=stmt.executeUpdate(query);
	System.out.println(recordAffected +" Record deleted....");
}
catch(Exception e)
{
	System.out.println(e);
}}
}

public void insertRecord(int id,String name,String mobile,String place) throws InterruptedException
{ synchronized (this) {
	
   Thread.sleep(2000);
	try {
		String query="insert into userEntries values('"+id+"','"+name+"','"+mobile+"','"+place+"')";
		int recordAffected=stmt.executeUpdate(query);
		System.out.println(recordAffected+" Record Inserted....");
	}
	catch(Exception e)
	{
		System.out.print(e);
	}}
}


}
