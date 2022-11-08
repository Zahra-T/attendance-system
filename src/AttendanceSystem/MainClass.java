package AttendanceSystem;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.lang.model.type.ErrorType;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class MainClass implements ActionListener{
	//Definition of components
	static Seminar seminar;
	JButton menu_btn1,menu_btn2,menu_btn3,menu_btn4,ok_btn,clear_btn,search_btn;
	Container container;
	CardLayout layout;
	JPanel CardPanel;
	JPanel SubPanel1,buttonPanel,entryPanel,searchPanel,listPanel;
	JTextField firstNameField,lastNameField,idNumberField,searchField;
	JLabel firstNameLabel,lastNameLabel,idNumberLabel,listLabel;
	JList nameList;
	//------------------------------------------------------------------------------
	public MainClass(){
		//Definition frame
		JFrame frm=new JFrame("Attendance System");
		//find center point of screen and set jframe to that location
		Point centerPoint=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int frmWidth=600;
		int frmHeight=400;
		frm.setBounds(centerPoint.x-frmWidth/2, centerPoint.y-frmHeight/2, frmWidth,frmHeight);
		//-------------------------------
		//changing jframIcon
		Image frmIcon=Toolkit.getDefaultToolkit().getImage("ProgramIcon1.PNG");
		frm.setIconImage(frmIcon);
		//-------------------------------
		//container and add layout
		Container c=frm.getContentPane();
		BorderLayout myLayout=new BorderLayout();
		c.setLayout(myLayout);
		//-------------------------------
		//create a Jpanel with cardLayout for put other panel
		layout = new CardLayout();
		CardPanel = new JPanel();
		CardPanel.setLayout(layout);
		//---------------------------------
		//create first subpanel wiht Image for first page
		SubPanel1= new JPanel();
		SubPanel1.setLayout(new BorderLayout());
		BufferedImage myPicture;
		JLabel picLabel;
		try {
			myPicture = ImageIO.read(new File("i5.PNG"));
			picLabel = new JLabel(new ImageIcon(myPicture));
			SubPanel1.add(picLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SubPanel1.setBackground(Color.LIGHT_GRAY);
		//-------------------------------------------
		//create  menu Button and set borders
		Color color = c.getBackground();
		menu_btn1=new JButton("Entry to the seminar");
		menu_btn1.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(30,0,30,30,color.blue),menu_btn1.getBorder()));
		menu_btn2=new JButton("See participants information");
		menu_btn2.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(30,0,30,30,color.white),menu_btn2.getBorder()));
		menu_btn3=new JButton("Check for presence or absence");
		menu_btn3.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(30,0,30,30,color.blue),menu_btn3.getBorder()));
		menu_btn4=new JButton("See list of attendees");
		menu_btn4.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(30,0,30,30,color.white),menu_btn4.getBorder()));
		//set menu button font
		menu_btn1.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu_btn2.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu_btn3.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu_btn4.setFont(new Font("Tahoma", Font.BOLD, 14));
		menu_btn1.setBackground(new Color(211, 211, 211));
		menu_btn2.setBackground(new Color(211, 211, 211));
		menu_btn3.setBackground(new Color(211, 211, 211));
		menu_btn4.setBackground(new Color(211, 211, 211));
		//-----------------------------------------------------------
		//set same size for buttons
		menu_btn1.setMaximumSize(new Dimension(300,100));
		menu_btn2.setMaximumSize(new Dimension(300,100));
		menu_btn3.setMaximumSize(new Dimension(300,100));
		menu_btn4.setMaximumSize(new Dimension(300,100));
		//-----------------------------------------------------------
		//set menu button to  buttonpanel, and set action etc
		buttonPanel = new JPanel();
		BoxLayout boxLayout1=new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
		buttonPanel.setLayout(boxLayout1);
		buttonPanel.add(menu_btn1);
		menu_btn1.addActionListener(this);
		buttonPanel.add(menu_btn2);
		menu_btn2.addActionListener(this);
		buttonPanel.add(menu_btn3);
		menu_btn3.addActionListener(this);
		buttonPanel.add(menu_btn4);
		menu_btn4.addActionListener(this);
		//----------------------------------------------------------------------
		//create a panle for entry 
		entryPanel=new JPanel();
		BoxLayout boxLayout2=new BoxLayout(entryPanel,BoxLayout.Y_AXIS);
		entryPanel.setBackground(color.LIGHT_GRAY);
		//------------------------------------------------------------------
		//like previous part creat necessary components and adding some attributes like borders,color,...
		firstNameField=new JTextField(20);
		firstNameField.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(50,0,10,0,color.LIGHT_GRAY),firstNameField.getBorder()));
		lastNameField=new JTextField(20);
		lastNameField.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0,0,10,0,color.LIGHT_GRAY),lastNameField.getBorder()));
		idNumberField=new JTextField(20);
		firstNameLabel=new JLabel("FirstName:");
		firstNameLabel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(50,0,10,0,color.LIGHT_GRAY),firstNameLabel.getBorder()));
		lastNameLabel=new JLabel("LastName:");
		lastNameLabel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0,0,10,0,color.LIGHT_GRAY),lastNameLabel.getBorder()));
		idNumberLabel=new JLabel("IdNumber:");
		firstNameField.setMaximumSize(new Dimension(400,25));
		lastNameField.setMaximumSize(new Dimension(400,25));
		idNumberField.setMaximumSize(new Dimension(400,25));
		ok_btn=new JButton("OK");
		clear_btn=new JButton("clear");
		ok_btn.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(10,0,10,0,color.LIGHT_GRAY),ok_btn.getBorder()));
		ok_btn.setBackground(new Color(0, 255, 0));
		clear_btn.setBackground(new Color(255, 0, 0));
		clear_btn.addActionListener(this);
		ok_btn.addActionListener(this);
		//------------------------------------------------------------------------------------------
		//add components to panle
		entryPanel.add(firstNameLabel);
		entryPanel.add(firstNameField);
		entryPanel.add(lastNameLabel);
		entryPanel.add(lastNameField);
		entryPanel.add(idNumberLabel);
		entryPanel.add(idNumberField);
		entryPanel.add(ok_btn);
		entryPanel.add(clear_btn);
		//--------------------------------------------------
		//create a panle for search with necessary components
		searchPanel=new JPanel();
		searchPanel.setBackground(color.LIGHT_GRAY);
		searchField=new JTextField("Type a name or Id",20);
		search_btn=new JButton("Search");
		search_btn.setBackground(new Color(255, 140, 0));
		search_btn.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(10,0,10,0,color.LIGHT_GRAY),search_btn.getBorder()));
		searchField.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(10,0,10,0,color.LIGHT_GRAY),searchField.getBorder()));
		search_btn.addActionListener(this);
		searchPanel.add(searchField);
		searchPanel.add(search_btn);
		//----------------------------------------------------------
		//a panle for list of attendees
		listPanel=new JPanel();
		BoxLayout boxLayout3=new BoxLayout(listPanel,BoxLayout.Y_AXIS);
		listPanel.setLayout(boxLayout3);
		listPanel.setBackground(color.LIGHT_GRAY);
		listLabel=new JLabel("click to see information:");
		nameList=new JList();
		nameList.setLayoutOrientation(nameList.VERTICAL);
		//nameList.setVisibleRowCount(10);
		nameList.setFixedCellWidth(100);
		listLabel.setHorizontalAlignment(listLabel.LEFT);
		listLabel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(50,0,10,0,color.LIGHT_GRAY),listLabel.getBorder()));
		nameList.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0,100,0,0,color.LIGHT_GRAY),nameList.getBorder()));
		nameList.setBackground(new Color(255, 192, 203));
		Color color1=null;
		nameList.setSelectionBackground(color1.YELLOW);
		nameList.setSelectionForeground(color1.RED);
		listPanel.add(listLabel);
		listPanel.add(nameList);
		//--------------------------------------------------------------
		//add panels to cardPanel and set them to container
		CardPanel.add(SubPanel1,"1");
		CardPanel.add(entryPanel,"3");
		CardPanel.add(searchPanel,"4");
		CardPanel.add(listPanel,"5");
		c.add(buttonPanel,BorderLayout.LINE_START);
		c.add(CardPanel,BorderLayout.CENTER);
		//--------------------------------------
		//set close mood ,fixing size and visibling frame
		frm.setResizable(false);
		frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
	/////////////this method is for action of components///////////////////
	public void actionPerformed(ActionEvent e) {
		//--------action of menu button 1------------
		if( e.getSource()== menu_btn1)
		{
			//show entry panel
			layout.show(CardPanel,"3");
		}
		//--------action of menu button 2----------------
		else if( e.getSource()== menu_btn2)
		{
			if(new File("TotalInformation.txt").exists())
			{
				//create a ArrayList of student information
				ArrayList<String> informationList=new ArrayList<String>();
				BufferedReader br;
				String line=null;
				try {
					br = new  BufferedReader(new FileReader(
							"TotalInformation.txt"));
					while((line=br.readLine())!=null)
					{
						informationList.add(line);
					}
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace(); 
				}
				//get an TotalInfoFrame object 
				new TotalInfoFrame(informationList);
			}
			else 
			{
				//show Message
				JOptionPane.showMessageDialog(null, "No Information yet.");
			}
		}
		//--------------------action of menu button 3------------------
		else if( e.getSource()== menu_btn3)
		{
			layout.show(CardPanel,"4");
		}
		//-----------------action of menu button 4---------------------
		else if( e.getSource()== menu_btn4)
		{
			if(new File("nameFile.txt").exists())
			{
				DefaultListModel<String> l = new DefaultListModel<>();
				BufferedReader br;
				String line=null;
				try {
					br = new  BufferedReader(new FileReader(
							"nameFile.txt"));
					while((line=br.readLine())!=null)
					{
						l.addElement(line);
					}
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				nameList.setModel(l);
				layout.show(CardPanel,"5");
				nameList.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
					}
					@Override
					public void mousePressed(MouseEvent e) {
					}
					@Override
					public void mouseExited(MouseEvent e) {
					}
					@Override
					public void mouseEntered(MouseEvent e) {
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						String[] sarray=new String[4];
						if (nameList.getSelectedIndex() != -1)
						{
							BufferedReader br;
							String line;
							int i=0;
							if(new File("TotalInformation.txt").exists())
							{
								try 
								{
									br= new BufferedReader(new FileReader(new File("TotalInformation.txt"))); 
									while((line=br.readLine())!=null)
									{
										sarray=line.split(" ");
										if(nameList.getSelectedValue().equals(sarray[0]+" "+sarray[1]))
										{
											break;
										}
									}

								}
								catch (IOException e1)
								{
									e1.printStackTrace();
								}
								//get an PersonInfoFram object
								PersonInfoFrame newFram=new PersonInfoFrame(sarray[0],sarray[1],sarray[2],sarray[3]);
							}
							
						}
					}
				});
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"No one entered yet.");
			}
		}
		//-------------------action of OK button-----------------------
		if( e.getSource()== ok_btn)
		{
			//-------check for true information-------
			int i=Check_NumberOfMembers();
			boolean b1=Check_name_members(firstNameField.getText(),lastNameField.getText());
			boolean b2=Check_Id_members(idNumberField.getText());
			if(i==seminar.participant_number)
				JOptionPane.showMessageDialog(null,"sorry!the seminar is full");
			else if(b1==true)
				JOptionPane.showMessageDialog(null, "This name has been entred before!","Error",JOptionPane.ERROR_MESSAGE);
			else if(idNumberField.getText().toCharArray().length!=10)
				JOptionPane.showMessageDialog(null, "Wrog id, please try again.","Error",JOptionPane.ERROR_MESSAGE);
			else if(b2==true)
				JOptionPane.showMessageDialog(null, "This id has been used before!","Error",JOptionPane.ERROR_MESSAGE);
			else
			{
				//add icon , show Message
				ImageIcon icon=new ImageIcon("successeIcon.PNG");
				JOptionPane.showMessageDialog(null,"Successful:)",null,
						JOptionPane.INFORMATION_MESSAGE,icon);
				//create new Student
				Student st=new Student();
				st.setInfo(firstNameField.getText(), lastNameField.getText(), idNumberField.getText());
				//---------set information to overloaded method------
				seminar.addRecorde(st.first_name,st.last_name);
				seminar.addRecorde(st.id);
				seminar.addRecorde(st.first_name,st.last_name,st.id,st.login_time);
			}
		}
		//--------------action of clear button-----------------
		if(clear_btn==e.getSource())
		{
			firstNameField.setText(null);lastNameField.setText(null);idNumberField.setText(null);
		}
		//-----------action of search button-------------------
		if(search_btn==e.getSource())
		{
			boolean b=Search(searchField.getText());
			if(b==true)
			{
				ImageIcon icon=new ImageIcon("i1.PNG");
				JOptionPane.showMessageDialog(null,"Present:)",null,
						JOptionPane.INFORMATION_MESSAGE,icon);
			}
			else
			{
				ImageIcon icon=new ImageIcon("i2.PNG");
				JOptionPane.showMessageDialog(null,"Absent:(",
						null,JOptionPane.INFORMATION_MESSAGE,icon); 
			}
		}
	}
	//************************************************
	//////////////////main method/////////////////////
	//************************************************
	public static void main(String args[]) {
		seminar=new Seminar();
		new MainClass();
	}
	//----------------------------------------------------------
	//------method for check capacity of seminar is full or not-------
	public static int Check_NumberOfMembers()
	{
		BufferedReader br;
		int i=0;
		if(new File("nameFile.txt").exists())
		{
			try 
			{
				br= new BufferedReader(new FileReader(new File("nameFile.txt"))); 
				while(br.readLine()!=null)
				{
					i++;
				}
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		return i;
	}
	//------------------------------------------------------------------
	//-----method for check name ------------
	public static boolean Check_name_members(String s1,String s2) {
		boolean result=false;
		BufferedReader br;
		String line=null;
		if(new File("nameFile.txt").exists())
		{
			try {
				br = new  BufferedReader(new FileReader(
						"nameFile.txt"));
				while((line=br.readLine())!=null)
				{
					if(line.equalsIgnoreCase(s1+" "+s2))
					{
						result=true;
						break;
					}
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	//-----------method for check id------------
	public static boolean Check_Id_members(String s) {
		boolean result=false;
		BufferedReader br;
		String line=null;
		if(new File("idFile.txt").exists())
		{
			try {
				br = new  BufferedReader(new FileReader(
						"idFile.txt"));
				while((line=br.readLine())!=null)
				{
					if(line.equals(s))
					{
						result=true;
						break;
					}
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	//method for search in attendees
	private static boolean Search(String s) {
		boolean result=false;
		BufferedReader br;
		String line=null;
		try {
			br = new  BufferedReader(new FileReader(
					"nameFile.txt"));
			while((line=br.readLine())!=null)
			{
				if(line.equalsIgnoreCase(s))
				{
					result=true;
					break;
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(result==false)
		{
			try {
				br = new  BufferedReader(new FileReader(
						"idFile.txt"));
				while((line=br.readLine())!=null)
				{
					if(line.equals(s))
					{
						result=true;
						break;
					}
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
