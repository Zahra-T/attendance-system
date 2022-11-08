package AttendanceSystem;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
public class Seminar  {
	final int participant_number=10;//this number is for example, can be more
	//-------------------------------------------------------
	//--------------overloaded methods----------------------
	//-------------------------------------------------------
	public void addRecorde(String fname,String lname)
	{
		//write name student to a File by BufferedWriter
		BufferedWriter outputWriter;
        try 
        {
        	outputWriter = new BufferedWriter(new FileWriter(new File("nameFile.txt"),true)); 
        	outputWriter.write(fname+" "+lname);
        	outputWriter.newLine();
        	outputWriter.close();
        } 
        catch (IOException e)
        {
        	 System.out.println("An error occurred.");
             e.printStackTrace();
        }
	}
	public void addRecorde(String id)
	{
		//write name student id to a File by BufferedWriter
		BufferedWriter outputWriter;
        try 
        {
        	outputWriter = new BufferedWriter(new FileWriter(new File("idFile.txt"),true)); 
        	outputWriter.write(id+"");
        	outputWriter.newLine();
        	outputWriter.close();
        } 
        catch (IOException e)
        {
        	 System.out.println("An error occurred.");
             e.printStackTrace();
        }
	}
	public void addRecorde(String fname,String lname,String id,String loginTime)
	{
		//write name student Information to a File by BufferedWriter
		BufferedWriter outputWriter;
        try 
        { 
        	outputWriter = new BufferedWriter(new FileWriter(new File("TotalInformation.txt"),true)); 
        	outputWriter.write(fname+" "+lname+" "+id+" "+loginTime);
        	outputWriter.newLine();
        	outputWriter.close();
        } 
        catch (IOException e)
        {
        	 System.out.println("An error occurred.");
             e.printStackTrace();
        }
	}
	
}
