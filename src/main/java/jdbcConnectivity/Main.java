package jdbcConnectivity;

public class Main {

public static void main(String[] args) {
	try {
	final MysqlCon dbCon=new MysqlCon();
	//Entering Project
	System.out.println("Welcome to jdbc connectivity project! displaying table userEntries.... ");
	Thread t1= new Thread(new Runnable() {
		public void run() {
			try {
			dbCon.showTable();}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	});
	t1.start();
	t1.join();
	
	//Inserting new Record
	System.out.println("\n Insert new record in table ");
	Thread t2= new Thread(new Runnable() {
		public void run() {
			try {
			dbCon.insertRecord(8, "Isha", "9414312249", "Jammu");
			}
			catch(Exception e)
			{
				e.printStackTrace();		
				}
		}
	});
	t2.start();
	t2.join();
	Thread t3= new Thread(new Runnable() {
		public void run() {
			try {
			dbCon.showTable();}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	});
    t3.start();
    t3.join();
    
	//Deleting the Record
	System.out.println("\n Deleting record by id with ID=1 ");
	Thread t4= new Thread(new Runnable() {
		public void run() {
			try {
			dbCon.deleteRecordById(1);}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	});
	
    t4.start();
    t4.join();
    Thread t5= new Thread(new Runnable() {
		public void run() {
			try {
			dbCon.showTable();}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	});
    t5.start();
    t5.join();
    //	Updating the record 
	System.out.println("\n Updating the record by ID Setting name=Raj where id=1 ");
	 Thread t6= new Thread(new Runnable() {
			public void run() {
				try {
				 dbCon.updateNameById(1, "Raj");}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	    t6.start();
	    t6.join();
	    Thread t7= new Thread(new Runnable() {
			public void run() {
				try {
				dbCon.showTable();}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	    t7.start();
	    t7.join();
  
    //Fetching the Record 
    System.out.println("\n Fetching the record by ID with id=8");
    Thread t8= new Thread(new Runnable() {
		public void run() {
			try {
			dbCon.getRecordById(8);}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	});
    t8.start();
    t8.join();

}
catch (Exception e)
	{System.out.print(e);}
	
}}
