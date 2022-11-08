package AttendanceSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Label;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TotalInfoFrame {
	public TotalInfoFrame(ArrayList<String> x)
	{
		//create a frame, container,set ImageIcone  
		JFrame f=new JFrame();
		Container c=f.getContentPane();
		c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
		Image frmIcon=Toolkit.getDefaultToolkit().getImage("ProgramIcon1.PNG");
		f.setIconImage(frmIcon);
		//--------------------------------------------------------------------------
	/*	Point centerPoint=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int frmWidth=340;
		int frmHeight=600;
		f.setBounds(centerPoint.x-frmWidth/2, centerPoint.y-frmHeight/2, frmWidth,frmHeight);*/
		Color color = c.getBackground();
		c.setBackground(color.CYAN);
		JLabel infoLabel1=new JLabel("                                        INFORMATION                         ");
		infoLabel1.setForeground(color.RED);
		infoLabel1.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(10,0,0,0,color.CYAN),infoLabel1.getBorder()));
		JLabel infoLabel2=new JLabel("-----------------------------------------------------------------------------------");
		JLabel infoLabel3=new JLabel("FistName*LastName*Id*Entrytime:");
		infoLabel3.setForeground(color.MAGENTA);
		infoLabel3.setFont(new Font("Tahoma", Font.BOLD, 14));
		infoLabel3.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0,10,5,0,color.CYAN),infoLabel3.getBorder()));
		c.add(infoLabel1);
		c.add(infoLabel2);
		c.add(infoLabel3);
		//create label from each element  ArrayList
		for(int i=0;i<x.size();i++)
		{
			String[] s=x.get(i).split(" ");
			JLabel label=new JLabel(s[0]+"*"+s[1]+"*"+s[2]+"*"+s[3]);
			label.setFont(new Font("Tahoma", Font.BOLD, 14));
			label.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createMatteBorder(5,10,5,5,color.CYAN),label.getBorder()));
			c.add(label);
		}
		//set location of frame
		f.setLocation(650,200);
		//determine the size according to the component
		f.pack();
		//fixing size and visible frame
		f.setResizable(false);
		f.setVisible(true);
	}
}
