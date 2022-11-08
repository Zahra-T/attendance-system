package AttendanceSystem;

import java.io.PrintStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Student {
	//define necessary attribute
	protected String first_name;
	protected String last_name;
	protected String id;
	protected String login_time;
	//-----------------------------------
	//set student Information
	public void setInfo(String first_name,String last_name,String id)
	{
		this.first_name=first_name;
		this.last_name=last_name;
		this.id=id;
		//set entry time
		LocalTime time;
		DateTimeFormatter myFormatObj;
		time= LocalTime.now();
		//format time to HH:mm:ss and set to a string type
		myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
		this.login_time =time.format(myFormatObj);
	}
}
