import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Flight extends Applet implements ActionListener,ItemListener

{
	TextField na, ln, am, nr, ag, ph;
	TextArea t;
	Choice choice, from, to;
	Checkbox meal;
	Button b, clear;
	int c;
	String myString="", check="";
	Image picture, picture2, picture3, picture4;  
 
	public void init()
	{
		setBackground(Color.white);
		setForeground(Color.black);
		setLayout(new FlowLayout());
		
		picture = getImage(getDocumentBase(),"sunwing.jpg");
		picture2 = getImage(getDocumentBase(),"bgpic4.jpg");
		picture3 = getImage(getDocumentBase(),"main1.jpg");
		picture4 = getImage(getDocumentBase(),"deals.jpg");

		na = new TextField(15);
		ln = new TextField(15);
		am = new TextField(15);
		nr = new TextField(15);
		ag = new TextField(15);
		ph = new TextField(15);

		meal = new Checkbox();

		choice = new Choice();
		choice.add("Premium");
		choice.add("Business");
		choice.add("Economy");
		
		from = new Choice();
		from.add("Hyderabad");
		from.add("Bengaluru");
		from.add("Chennai");

		to = new Choice();
		to.add("Hyderabad");
		to.add("Bengaluru");
		to.add("Chennai");

		t = new TextArea(70,60);

		b = new Button("BOOK NOW");
		clear = new Button("CLEAR");

		Font myFont = new Font("Forte",Font.BOLD,18);
		Font myFont1 = new Font("Forte",Font.BOLD,22);
		na.setFont(myFont);
		ln.setFont(myFont);
		ag.setFont(myFont);
		ph.setFont(myFont);
		nr.setFont(myFont);
		choice.setFont(myFont);
		from.setFont(myFont);
		to.setFont(myFont);
		b.setFont(myFont);
		am.setFont(myFont);
		t.setFont(myFont1);
		clear.setFont(myFont);

		add(na);
		add(ln);
		add(ag);
		add(ph);
		add(nr);
		add(choice);
		add(from);
		add(to);
		add(meal);
		add(b);
		add(am);
		add(t);
		add(clear);

		choice.addItemListener(this);
		from.addItemListener(this);
		to.addItemListener(this);
		meal.addItemListener(this);
		b.addActionListener(this);
		clear.addActionListener(this);
	}

	public void paint(Graphics g) 
	{   
		int height = picture.getHeight(this);
		int scaleHeight = (int) (height * 0.25);
		g.drawImage(picture, 500, 200, 1000, scaleHeight, this);
		g.drawImage(picture2, 0, 0, 500, scaleHeight, this);
		g.drawImage(picture3, 500, 0, 1000, 200, this);
		g.drawImage(picture4, 500, 755, 1000, 200, this);
		
		Font textFont2 = new Font("Arial",Font.BOLD,50);
		Font textFont3 = new Font("Arial",Font.BOLD,24);

		String s2 = "Passenger Details ";
		g.setColor(Color.white);
		g.setFont(textFont2);
		g.drawString(s2,40,95);

		String s3 = "First Name: ";
		g.setColor(Color.white);
		g.setFont(textFont3);
		g.drawString(s3,40,150);

		String s4 = "Last Name: ";
		g.setColor(Color.white);
		g.setFont(textFont3);
		g.drawString(s4,260,150);

		this.na.setLocation(40, 175);
		this.ln.setLocation(260, 175);

		String s5 = "Age: ";
		g.setColor(Color.white);
		g.setFont(textFont3);
		g.drawString(s5,40,275);

		String s6 = "Phone Number: ";
		g.setColor(Color.white);
		g.setFont(textFont3);
		g.drawString(s6,260,275);

		this.ag.setLocation(40, 300);
		this.ph.setLocation(260, 300);

		String s7 = "No. of Seats: ";
		g.setColor(Color.white);
		g.setFont(textFont3);
		g.drawString(s7,40,400);

		String s8 = "Type of Travel: ";
		g.setColor(Color.white);
		g.setFont(textFont3);
		g.drawString(s8,260,400);

		this.nr.setLocation(40, 425);
		this.choice.setLocation(260, 425);

		String s9 = "From: ";
		g.setColor(Color.white);
		g.setFont(textFont3);
		g.drawString(s9,40,525);

		String s10 = "To: ";
		g.setColor(Color.white);
		g.setFont(textFont3);
		g.drawString(s10,260,525);

		this.from.setLocation(40, 550);
		this.to.setLocation(260, 550);

		String s11 = "Include Meals: ";
		g.setColor(Color.white);
		g.setFont(textFont3);
		g.drawString(s11,40,650);

		this.meal.setLocation(260, 630);

		String s12 = "Confirm Booking: ";
		g.setColor(Color.white);
		g.setFont(textFont3);
		g.drawString(s12,40,715);

		this.b.setLocation(260, 695);

		String s13 = "Amount: ";
		g.setColor(Color.white);
		g.setFont(textFont3);
		g.drawString(s13,40,775);

		this.am.setLocation(40, 800);

		String s14 = "Reset Booking: ";
		g.setColor(Color.white);
		g.setFont(textFont3);
		g.drawString(s14,40,900);

		this.clear.setLocation(260, 880);

		this.t.setLocation(1500, 0);
	}

	public void actionPerformed(ActionEvent ae)
	{

		if(b.getActionCommand().equals("BOOK NOW"))
		{
			if(choice.getSelectedItem().equals("Premium"))
				{
					am.setText("4000");
				}
			else if(choice.getSelectedItem().equals("Business"))
				{
					am.setText("2500");
				}
			else
				{
					am.setText("1000");
				}
		}

		c=((Integer.parseInt(am.getText()))*(Integer.parseInt(nr.getText())));

		String x = myString;

		myString = "Name: "+na.getText()+" "+ln.getText()+"\nAge: "+ag.getText()+" years"+"\nPhoneNumber: +91 "+ph.getText()+
			"\nNo.of seats: "+nr.getText()+"\nDeparture: "+from.getSelectedItem()+"\nArrival: "+to.getSelectedItem()+
			"\nType: "+choice.getSelectedItem()+"\nAmount: Rs."+c+"\nExtras: "+check+"\n";

		t.setText("Current booking:\n"+"\n"+myString+"\nPrevious bookings:\n"+"\n"+x+"\n");
		myString = myString+"\n"+x+"\n";

		if(ae.getSource() == clear)
		{ 
			na.setText(null);
        	ln.setText(null);
			nr.setText(null);
			am.setText(null);
			ag.setText(null);
			ph.setText(null);
			meal.setState(false);
			t.setText("\n                ...Booking Cleared...\n"+"\n            Thank you for choosing\n                     our services!\n"+"\n        Please visit us again for your\n                     future travels.");
			repaint();
		}
	}
	public void itemStateChanged(ItemEvent ie)
    {
		Checkbox ch =(Checkbox)ie.getItemSelectable();
		if(ch.getState()==true)
		{
			check="Meals included";
		}
		else
		{
			check="Not applicable";
		}
    }

}
