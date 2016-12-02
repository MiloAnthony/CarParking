package Car;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class carpark extends JFrame implements ActionListener {
	 private JPanel imagePanel;
	 private ImageIcon background;
		Color back_color=new Color(89,89,89);
	
	SeqQueue another=new SeqQueue(10);//��������ͣ��10������
	//ͣ��λ˳�����,���5��
	SeqQueue park=new SeqQueue(5);
	SeqStack lingshi=new SeqStack(5);
	
	JButton jb1=new JButton("�Ǽ�");
	JButton jb2=new JButton("��λ");
	JButton jb3=new JButton("״̬");
	JButton jb4=new JButton("�շ�");
	JButton jb5=new JButton("˵��");
	//JLabel jl=new JLabel("",welcome,JLabel.CENTER);
	
	JTextArea jtext=new JTextArea();
	
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	public carpark(){
		super("ͣ��������ϵͳ");
		setSize(1090,646);
		JFrameBackground();
		Dimension   screenSize = Toolkit.getDefaultToolkit().getScreenSize();   
    	Dimension   frameSize  = this.getSize();
		setLocation((screenSize.width - frameSize.width) / 2,     
  				  (screenSize.height - frameSize.height) / 2);

		this.setLayout(null);
		jb1.setBounds(630, 20, 70, 30);
		jb2.setBounds(710, 20, 70, 30);
		jb3.setBounds(790, 20, 70, 30);
		jb4.setBounds(870, 20, 70, 30);
		jb5.setBounds(997, 20, 70, 30);
		jb1.setForeground(Color.white);
		jb2.setForeground(Color.white);
		jb3.setForeground(Color.white);
		jb4.setForeground(Color.white);
		jb5.setForeground(Color.white);
		jb1.setOpaque(false);
		jb2.setOpaque(false);
		jb3.setOpaque(false);
		jb4.setOpaque(false);
		jb5.setOpaque(false);
		jb1.setContentAreaFilled(false);
		jb2.setContentAreaFilled(false);
		jb3.setContentAreaFilled(false);
		jb4.setContentAreaFilled(false);
		jb5.setContentAreaFilled(false);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);

		jb1.setFont(new Font("����",Font.PLAIN,16));
		jb2.setFont(new Font("����",Font.PLAIN,16));
		jb3.setFont(new Font("����",Font.PLAIN,16));
		jb4.setFont(new Font("����",Font.PLAIN,16));
		jb5.setFont(new Font("����",Font.PLAIN,16));
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		try {
			//����ͣ��λ��Ϣ
			new come().getcar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		
		carpark cp=new carpark();
		cp.setVisible(true);
		cp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			try {
				come cm=new come();
				cm.setTitle("ͣ���Ǽ�");
				cm.setBounds(260, 200,500, 400);
				cm.setVisible(true);
			} catch (Exception e1) {e1.printStackTrace();}			
		}
		if(e.getSource()==jb2){
			leave lv=new leave();
			lv.setTitle("�����뿪��¼");
			lv.setBounds(200,50,1000,580);
			lv.setVisible(true);
		}
		if(e.getSource()==jb3){
			viewcar v=new viewcar();
			v.setTitle("�鿴ͣ����״̬");
			v.setBounds(200,100,500,400);
			v.setVisible(true);
		}
		if(e.getSource()==jb4){
			parkingfee v=new parkingfee();
			v.setTitle("�鿴ͣ���շѷ���");
			v.setBounds(200,100,600,400);
			v.setVisible(true);
		}
		if(e.getSource()==jb5){
			help v=new help();
			v.setTitle("�鿴˵��");
			v.setBounds(200,100,716,538);
			v.setVisible(true);
		}
	}
	//��������ͣ��λ�Ĺ���ģ��
	class come extends JDialog implements ActionListener{
		JLabel name=new JLabel("��������");
		JLabel ph=new JLabel("������ϵ��ʽ");
		JLabel classify=new JLabel("����");
		JLabel number=new JLabel("���ƺ�");
		
		JTextField t1=new JTextField(10);
		JTextField t2=new JTextField(10);
		JTextField t3=new JTextField(10);
		JTextField t4=new JTextField(10);
		
		JTextArea  jta=new JTextArea();
		
		JButton jb1=new JButton("ͣ��ȷ��");
		JButton jb2=new JButton("ȡ��");
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		public come(){
			p1.setBackground(back_color);

			name.setForeground(Color.white);
			ph.setForeground(Color.white);
			classify.setForeground(Color.white);
			number.setForeground(Color.white);
			p1.setLayout(new GridLayout(4,2));
			p1.add(name);
			p1.add(t1);
			p1.add(ph);
			p1.add(t2);
			p1.add(classify);
			p1.add(t3);
			p1.add(number);
			p1.add(t4);
			jta.setBackground(back_color);
			jta.setForeground(Color.white);
			
			p2.setBackground(back_color);
			jta.setEditable(false);
			p2.add(jta);
			jta.setFont(new Font("����",Font.PLAIN,15));
			
			p3.setLayout(new FlowLayout(FlowLayout.CENTER));
			p3.add(jb1);
			p3.add(jb2);
			add(p1,BorderLayout.NORTH);
			add(p2,BorderLayout.CENTER);
			add(p3,BorderLayout.SOUTH);
			jb1.addActionListener(this);
			jb2.addActionListener(this);		
		}
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==jb1){
				if(t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")){
					JOptionPane.showMessageDialog(null, "�����복�������Ϣ", "����", JOptionPane.ERROR_MESSAGE);
				}else{
					try {
						//getcar();
						if(another.count==another.maxSize){
							JOptionPane.showMessageDialog(null, "������޷��������ɳ���", "ע��", JOptionPane.WARNING_MESSAGE);
						}else{
							confirmcar();
						}
						//new leave().check();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
			if(e.getSource()==jb2){
				this.dispose();
			}
		}
		//��������ݿ����
		public void register() throws Exception{
			connection control=new connection();
			Connection con = null;
			Statement stmt = null;
			ResultSet rs=null;
			try {
				con=control.getConn();
				stmt=con.createStatement();
				//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
				String indate = df.format(new Date());
				String sql="insert into car (name,phone,type,number,indate) values ('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+indate+"')";
				//System.out.println(sql);
				stmt.execute(sql);
			} catch (Exception e) {
				System.out.print(" "+e.getMessage());
			}finally{
				control.closeAll(rs, stmt, con);
			}
			park();
			//JOptionPane.showMessageDialog(null, "������λ�ɹ�", "�ɹ�", JOptionPane.INFORMATION_MESSAGE);
		}
		//����ϵ����ݿ����
		public void road() throws Exception{
			connection control=new connection();
			Connection con = null;
			Statement stmt = null;
			ResultSet rs=null;
			try {
				con=control.getConn();
				stmt=con.createStatement();
				//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
				String indate = df.format(new Date());
				String sql="insert into roadcar (name,phone,type,number,indate) values ('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+indate+"')";
				stmt.execute(sql);
				//System.out.println(sql);
			} catch (Exception e) {
				System.out.print(" "+e.getMessage());
			}finally{
				control.closeAll(rs, stmt, con);
			}
			jta.setText("����Ϊ"+t4.getText()+"������������");
			another.append(t4.getText());
		}
		//��ȡͣ��λ�ϵĳ���
		public void confirmcar(){
			connection control=new connection();
			Connection con = null;
			Statement stmt = null;
			ResultSet rs=null;
			try {
				con=control.getConn();
				stmt=con.createStatement();
				//�������ݿ�ĳ�
				String sql="select count(number) from car";
				rs=stmt.executeQuery(sql);
				if(rs.next()){
					int s=rs.getInt(1);
					//System.out.println(s);
					if(s==park.maxSize){
						JOptionPane.showMessageDialog(null, "��ǰͣ��λȫ��������������ڱ���ϵȺ�", "ͣ��״̬", JOptionPane.INFORMATION_MESSAGE);
						road();
					}else{
						register();
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally{control.closeAll(rs, stmt, con);}
		}
		public void getcar() throws Exception{
			for(int i=0;i<park.count;i++){
				park.delete();
			}
			for(int i=0;i<another.count;i++){
				another.delete();
			}
			connection control=new connection();
			Connection con1 = null;
			Connection con2 = null;
			Statement stmt1 = null;
			ResultSet rs1=null;
			Statement stmt2= null;
			ResultSet rs2=null;
			try {
				con1=control.getConn();
				stmt1=con1.createStatement();
				//������ͣ����ʱ������
				String sql1="select number from car order by indate asc;";
				String sql2="select number from roadcar order by indate asc;";
				rs1=stmt1.executeQuery(sql1);
				while(rs1.next()){
					park.append(rs1.getString("number"));
				}
				con2=control.getConn();
				stmt2=con2.createStatement();
				rs2=stmt2.executeQuery(sql2);
				while(rs2.next()){
					another.append(rs2.getString("number"));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally{control.closeAll(rs1, stmt1, con1);
					 control.closeAll(rs2, stmt2, con2);}
		}
		public void park() throws Exception{
			String s1,s2;
			if(!park.notEmpty()){
				s1="��ǰ����"+(park.maxSize-park.count-1)+"��ͣ��λ";
//				System.out.println("park.maxSize="+park.maxSize
//						+",park.count="+park.count);
				s2="����Ϊ"+t4.getText()+"����������ͣ��λ"+(park.count+1);
				park.append(t4.getText());
			}else{
				s1="��ǰ����"+(park.maxSize-park.count-1)+"��ͣ��λ";
//				System.out.println("park.maxSize="+park.maxSize
//						+",park.count="+park.count);
				s2="����Ϊ"+t4.getText()+"����������ͣ��λ"+(park.count+1);
				park.append(t4.getText());
			}
			jta.setText(s1+"\r\n"+s2);
		}
	}
	//�����뿪ͣ��λ�Ĺ���ģ��
	class leave extends JDialog implements ActionListener{

		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JTextArea jt=new JTextArea();
		JLabel j1=new JLabel(new ImageIcon("1.png"));
		JLabel j2=new JLabel(new ImageIcon("2.png"));
		JLabel j3=new JLabel(new ImageIcon("3.png"));
		JLabel j4=new JLabel(new ImageIcon("4.png"));
		JLabel j5=new JLabel(new ImageIcon("5.png"));
		
		JButton b[]=new JButton[5];
		public leave(){
			j1.setBounds(100,100,70,60);
			j2.setBounds(100,100,70,60);
			j3.setBounds(100,100,70,60);
			j4.setBounds(100,100,70,60);
			j5.setBounds(100,100,70,60);
			


			jp1.setBackground(back_color);
			jt.setBackground(back_color);
			jt.setForeground(Color.white);
			jp1.setLayout(new GridLayout(2,5));
			jp1.add(j1);jp1.add(j2);
			jp1.add(j3);jp1.add(j4);
			jp1.add(j5);
			for(int i=0;i<5;i++){
				b[i]=new JButton(new ImageIcon("c_2.jpg"));
				b[i].addActionListener(this);
				b[i].setVisible(false);
			}
			jp1.add(b[0]);
			jp1.add(b[1]);jp1.add(b[2]);	
			jp1.add(b[3]);jp1.add(b[4]);
			jp2.setBackground(back_color);
			jp2.add(jt);
			jt.setFont(new Font("����",Font.PLAIN,15));
			add(jp1,BorderLayout.NORTH);
			add(jp2,BorderLayout.CENTER);
			try {
				check();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void actionPerformed(ActionEvent e) {
			for(int i=0;i<5;i++){
				if(e.getSource()==b[i]){
					try {
						carleave(i+1);
					} catch (Exception e1) {e1.printStackTrace();}
				}
			}
		}
		//ʵʱ�۲�ͣ��λ��״��
		public void check() throws Exception{
			int n=park.count;
			for(int i=0;i<n;i++){
				b[i].setVisible(true);
				b[i].setToolTipText(String.valueOf(park.getWant(i)));
			}
		}
		//�����뿪������ϵĳ�����ͣ��λ
		public void carleave(int i) throws Exception{
			String s="";
			int k=park.count;
//			System.out.println("park.count="+k);
//			System.out.println("i="+k);
			String s1[]=new String[k-i];
			String s2[]=new String[k-i];
			String string="";
			for(int m=0;m<s1.length;m++){
				s1[m]="����Ϊ"+b[k-1].getToolTipText()+"��������ʱ�뿪ͣ��λ"+"\r\n";
				lingshi.push(b[k-1].getToolTipText());
				b[k-1].setVisible(false);
				k--;
			}
			for(int m=0;m<s1.length;m++){
				string+=s1[m];
			}
			string+="����Ϊ"+b[i-1].getToolTipText()+"�뿪ͣ����\r\n";
			park.deleteWant(b[i-1].getToolTipText());
			delete("car",b[i-1].getToolTipText());
			b[i-1].setVisible(false);
			for(int m=0;m<s2.length;m++){
				s2[m]="����Ϊ"+lingshi.pop()+"����������ͣ��λ"+i+"\r\n";
				b[i-1].setToolTipText(b[i].getToolTipText());
				b[i-1].setVisible(true);
				i+=1;
			}
			if(another.notEmpty()){
				String s3=String.valueOf(another.delete());
				s="�������Ϊ"+s3+"����������ͣ��λ5";
				insert(s3);
				park.setObject(4,s3);
				b[4].setVisible(true);
				b[4].setToolTipText(s3);
				delete("roadcar",s3);
			}else{
				s="�����û�г�";
			}
			for(int m=0;m<s2.length;m++){
				string+=s2[m];
			}
			string+=s;
			jt.setText(string);
		}
		//ɾ�����ݿ�������
		public void delete(String s1,String s){
			connection control=new connection();
			Connection con = null;
			Statement stmt = null;
			ResultSet rs=null;
			try {
				con=control.getConn();
				stmt=con.createStatement();
				String sql="delete from "+s1+" where number='"+s+"'";
				stmt.executeUpdate(sql);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}finally{
				control.closeAll(rs, stmt, con);
			}
		}
		//���ݲ������ݿ�
		public void insert(String s){
			connection control=new connection();
			Connection con = null;
			Statement stmt = null;
			ResultSet rs=null;
			Connection con1 = null;
			Statement stmt1 = null;
			ResultSet rs1=null;
			String name = null,phone = null,type=null,number=null;
			try {
				con=control.getConn();
				stmt=con.createStatement();
				String sql="select name,phone,type,number from roadcar where number='"+s+"'";
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					name=rs.getString("name");
					phone=rs.getString("phone");
					type=rs.getString("type");
					number=rs.getString("number");
				}
				con1=control.getConn();
				stmt1=con1.createStatement();
				//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
				String indate = df.format(new Date());
				String sql1="insert into car (name,phone,type,number,indate) values ('"+name+"','"+phone+"','"+type+"','"+number+"','"+indate+"')";
				stmt1.executeUpdate(sql1);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}finally{
				control.closeAll(rs, stmt, con);control.closeAll(rs1, stmt1, con1);
			}
		}
	}
	//�鿴״̬ģ��
	class viewcar extends JDialog{
		JPanel j1=new JPanel();
		JPanel j2=new JPanel();
		JPanel j3=new JPanel();
		JPanel j4=new JPanel();
		JPanel j5=new JPanel();
		JLabel l1=new JLabel("ͣ��λ״��");
		JLabel l2=new JLabel("���״��");
		JLabel hao_1 = new JLabel("1�ų�λ");
		JLabel hao_2 = new JLabel("2�ų�λ");
		JLabel hao_3 = new JLabel("3�ų�λ");
		JLabel hao_4 = new JLabel("4�ų�λ");
		JLabel hao_5 = new JLabel("5�ų�λ");
		JLabel hao_11 = new JLabel("1�ų�λ");
		JLabel hao_21 = new JLabel("2�ų�λ");
		JLabel hao_31 = new JLabel("3�ų�λ");
		JLabel hao_41 = new JLabel("4�ų�λ");
		JLabel hao_51 = new JLabel("5�ų�λ");
		JLabel hao_12 = new JLabel("1�ų�λ");
		JLabel hao_22 = new JLabel("2�ų�λ");
		JLabel hao_32 = new JLabel("3�ų�λ");
		JLabel hao_42 = new JLabel("4�ų�λ");
		JLabel hao_52 = new JLabel("5�ų�λ");
		
		JTextField jt1=new JTextField(8);
		JTextField jt2=new JTextField(8);
		JTextField jt3=new JTextField(8);
		JTextField jt4=new JTextField(8);
		JTextField jt5=new JTextField(8);
		JTextField jt6=new JTextField(8);
		JTextField jt7=new JTextField(8);
		JTextField jt8=new JTextField(8);
		JTextField jt9=new JTextField(8);
		JTextField jt10=new JTextField(8);
		JTextField jt11=new JTextField(8);
		JTextField jt12=new JTextField(8);
		JTextField jt13=new JTextField(8);
		JTextField jt14=new JTextField(8);
		JTextField jt15=new JTextField(8);
		//��λ��Ϣ������
		public viewcar(){
			
			j1.setLayout(new GridLayout(1,2));
			j2.add(l1,BorderLayout.NORTH);l1.setFont(new Font("����",Font.PLAIN,20));
			j2.add(j3,BorderLayout.CENTER);l2.setFont(new Font("����",Font.PLAIN,20));

			l1.setForeground(Color.white);
			l2.setForeground(Color.white);
			
			j2.setBackground(back_color);
			
			j3.setLayout(new GridLayout(5,2));

			j3.setBackground(back_color);
			j3.setForeground(Color.white);
			hao_1.setForeground(Color.white);
			hao_2.setForeground(Color.white);
			hao_3.setForeground(Color.white);
			hao_4.setForeground(Color.white);
			hao_5.setForeground(Color.white);

			hao_11.setForeground(Color.white);
			hao_21.setForeground(Color.white);
			hao_31.setForeground(Color.white);
			hao_41.setForeground(Color.white);
			hao_51.setForeground(Color.white);
			hao_12.setForeground(Color.white);
			hao_22.setForeground(Color.white);
			hao_32.setForeground(Color.white);
			hao_42.setForeground(Color.white);
			hao_52.setForeground(Color.white);
			j3.add(hao_1);j3.add(jt1);jt1.setEditable(false);
			j3.add(hao_2);j3.add(jt2);jt2.setEditable(false);
			j3.add(hao_3);j3.add(jt3);jt3.setEditable(false);
			j3.add(hao_4);j3.add(jt4);jt4.setEditable(false);
			j3.add(hao_5);j3.add(jt5);jt5.setEditable(false);
			
			
			j4.add(l2,BorderLayout.NORTH);
			j4.add(j5,BorderLayout.CENTER);
			j5.setLayout(new GridLayout(10,2));

			j4.setBackground(back_color);
			j5.setBackground(back_color);
			
			j5.add(hao_11);j5.add(jt6);jt6.setEditable(false);
			j5.add(hao_21);j5.add(jt7);jt7.setEditable(false);
			j5.add(hao_31);j5.add(jt8);jt8.setEditable(false);
			j5.add(hao_41);j5.add(jt9);jt9.setEditable(false);
			j5.add(hao_51);j5.add(jt10);jt10.setEditable(false);
			j5.add(hao_12);j5.add(jt11);jt11.setEditable(false);
			j5.add(hao_22);j5.add(jt12);jt12.setEditable(false);
			j5.add(hao_32);j5.add(jt13);jt13.setEditable(false);
			j5.add(hao_42);j5.add(jt14);jt14.setEditable(false);
			j5.add(hao_52);j5.add(jt15);jt15.setEditable(false);
			j1.add(j2);j1.add(j4);
			add(j1);
			try {
				ting();
				biandao();
			} catch (Exception e) {	}
		}
		//ͣ���ı�����
		public void ting() throws Exception{
			jt1.setText((String) park.getWant(0));
			jt2.setText((String) park.getWant(1));
			jt3.setText((String) park.getWant(2));
			jt4.setText((String) park.getWant(3));
			jt5.setText((String) park.getWant(4));
		}
		//����ı�����
		public void biandao() throws Exception{
			jt6.setText((String)another.getWant(0));
			jt7.setText((String)another.getWant(1));
			jt8.setText((String)another.getWant(2));
			jt9.setText((String)another.getWant(3));
			jt10.setText((String)another.getWant(4));
			jt11.setText((String)another.getWant(5));
			jt12.setText((String)another.getWant(6));
			jt13.setText((String)another.getWant(7));
			jt14.setText((String)another.getWant(8));
			jt15.setText((String)another.getWant(9));
		}
	}
	
	class parkingfee extends JDialog{
		JPanel j1=new JPanel();
		JPanel j2=new JPanel();
		JPanel j3=new JPanel();
		JPanel j4=new JPanel();
		JPanel j5=new JPanel();
		JLabel l1=new JLabel("ͣ��λ״��");
		JLabel l2=new JLabel("ͣ��ʱ���Լ��������");
		JLabel hao_1 = new JLabel("1�ų�λ");
		JLabel hao_2 = new JLabel("2�ų�λ");
		JLabel hao_3 = new JLabel("3�ų�λ");
		JLabel hao_4 = new JLabel("4�ų�λ");
		JLabel hao_5 = new JLabel("5�ų�λ");
		JTextField jt1=new JTextField(8);
		JTextField jt2=new JTextField(8);
		JTextField jt3=new JTextField(8);
		JTextField jt4=new JTextField(8);
		JTextField jt5=new JTextField(8);
		JTextField jt1_1=new JTextField(8);
		JTextField jt1_2=new JTextField(8);
		JTextField jt1_3=new JTextField(8);
		JTextField jt1_4=new JTextField(8);
		JTextField jt1_5=new JTextField(8);
		JTextField jt2_1=new JTextField(8);
		JTextField jt2_2=new JTextField(8);
		JTextField jt2_3=new JTextField(8);
		JTextField jt2_4=new JTextField(8);
		JTextField jt2_5=new JTextField(8);
		public parkingfee(){
			j1.setLayout(new GridLayout(1,2));
			j2.add(l1,BorderLayout.NORTH);l1.setFont(new Font("����",Font.PLAIN,20));
			j2.add(j3,BorderLayout.CENTER);l2.setFont(new Font("����",Font.PLAIN,20));
			l1.setForeground(Color.white);
			l2.setForeground(Color.white);
			j2.setBackground(back_color);
			j3.setLayout(new GridLayout(5,2));
			j3.setBackground(back_color);
			
			hao_1.setForeground(Color.white);
			hao_2.setForeground(Color.white);
			hao_3.setForeground(Color.white);
			hao_4.setForeground(Color.white);
			hao_5.setForeground(Color.white);
			j3.add(hao_1);j3.add(jt1);jt1.setEditable(false);
			j3.add(hao_2);j3.add(jt2);jt2.setEditable(false);
			j3.add(hao_3);j3.add(jt3);jt3.setEditable(false);
			j3.add(hao_4);j3.add(jt4);jt4.setEditable(false);
			j3.add(hao_5);j3.add(jt5);jt5.setEditable(false);
			j4.add(l2,BorderLayout.NORTH);
			j4.add(j5,BorderLayout.CENTER);
			j4.setBackground(back_color);
			j5.setLayout(new GridLayout(5,2));
			j5.add(jt1_1);jt1_1.setEditable(false);j5.add(jt2_1);jt2_1.setEditable(false);
			j5.add(jt1_2);jt1_2.setEditable(false);j5.add(jt2_2);jt2_2.setEditable(false);
			j5.add(jt1_3);jt1_3.setEditable(false);j5.add(jt2_3);jt2_3.setEditable(false);
			j5.add(jt1_4);jt1_4.setEditable(false);j5.add(jt2_4);jt2_4.setEditable(false);
			j5.add(jt1_5);jt1_5.setEditable(false);j5.add(jt2_5);jt2_5.setEditable(false);
			

			j1.add(j2);j1.add(j4);
			add(j1);
			try {
				ting();
				fee();
			} catch (Exception e) {	}
			
		}
		//ͣ���ı�����
		public void ting() throws Exception{
			jt1.setText((String) park.getWant(0));
			jt2.setText((String) park.getWant(1));
			jt3.setText((String) park.getWant(2));
			jt4.setText((String) park.getWant(3));
			jt5.setText((String) park.getWant(4));
		}		
		//���ü���
		public void fee() throws Exception{
			jt1_1.setText("07-09 11:35:50");
			jt1_2.setText("07-09 12:35:50");
			jt1_3.setText("07-09 13:35:50");
			jt1_4.setText("07-09 14:35:50");
			jt1_5.setText("07-09 15:35:50");
			jt2_1.setText("10.0Ԫ");
			jt2_2.setText("12.0Ԫ");
			jt2_3.setText("14.0Ԫ");
			jt2_4.setText("16.0Ԫ");
			jt2_5.setText("18.0Ԫ");
			
		}
	}
	class help extends JDialog{
		JPanel j1=new JPanel();
		public  help(){
			ImageIcon help_bg;
			help_bg = new ImageIcon("help.png");// ����ͼƬ
			JLabel label = new JLabel(help_bg);// �ѱ���ͼƬ��ʾ��һ����ǩ����
			label.setBounds(0, 0, help_bg.getIconWidth(),
					help_bg.getIconHeight());
			add(label);
			//this.setResizable(false);
			  this.setVisible(true);
		}
	}
	 public void JFrameBackground() {
		  background = new ImageIcon("background.png");// ����ͼƬ
		  JLabel label = new JLabel(background);// �ѱ���ͼƬ��ʾ��һ����ǩ����
		  // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
		  label.setBounds(0, 0, background.getIconWidth(),
		    background.getIconHeight());
		  // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
		  imagePanel = (JPanel) this.getContentPane();
		  imagePanel.setOpaque(false);
		  // ���ݴ���Ĭ�ϵĲ��ֹ�����ΪBorderLayout
		  imagePanel.setLayout(new FlowLayout());

		  this.getLayeredPane().setLayout(null);
		  // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		  this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		  //this.setResizable(false);
		  this.setVisible(true);
		 }
}
