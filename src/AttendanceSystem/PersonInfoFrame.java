package AttendanceSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PersonInfoFrame
{
	public PersonInfoFrame(String fname,String lname,String id,String time)
	{
		//create a frame
		JFrame f=new JFrame();
		//create a container and set frame layout to the container
		Container c=f.getContentPane();
		c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
		//find center point of screen and set jfram to that location
		Point centerPoint=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int frmWidth=200;
		int frmHeight=200;
		f.setBounds(centerPoint.x-frmWidth/2, centerPoint.y-frmHeight/2, frmWidth,frmHeight);
		//change frame icon
		Image frmIcon=Toolkit.getDefaultToolkit().getImage("ProgramIcon1.PNG");
		f.setIconImage(frmIcon);
		//create label 1,2,3,4
		JLabel l1=new JLabel("FirstName: "+fname);
		JLabel l2=new JLabel("LastName: "+lname);
		JLabel l3=new JLabel("Id: "+id);
		JLabel l4=new JLabel("EntryTime: "+time);
		//--------------------------------------------------
		//set borders and put in the right position
		Color color = c.getBackground();
		l1.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(5,5,5,5,color.green),l1.getBorder()));
		l2.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(5,5,5,5,color.green),l2.getBorder()));
		l3.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(5,5,5,5,color.green),l3.getBorder()));
		l4.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(5,5,5,5,color.green),l4.getBorder()));
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		//----------------------------------------------------------------------------
		JLabel infoLabel1=new JLabel("                          Info               ");
		JLabel infoLabel2=new JLabel("+++++++++++++++++++++++++++");
		infoLabel2.setForeground(color.RED);
		c.setBackground(color.green);
		//add components to container
		c.add(infoLabel1);
		c.add(infoLabel2);
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		//------------------------------
		//fixing size and visible frame
		f.setResizable(false);
		f.setVisible(true);
	}
}
