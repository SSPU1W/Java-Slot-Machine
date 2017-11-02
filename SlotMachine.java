import java.awt.Graphics; 
import java.awt.Color; 
import java.awt.Font;
import javax.swing.JPanel;
public class SlotMachine extends JPanel
{
	int num1; 
	int num2;
	int num3;
	int bet; 
	int balance; 
	int points; 
	boolean checkwin = false;
	boolean ifwin = false; 
	int RocketY;
	int x; 
	int y;
	public SlotMachine(int b)
	{
		num1 = 0;
		num2 = 0;
		num3 = 0;
		bet = 0;
		balance = b; 
		int x = 400;
		int y = 450;
	}
	public void drawMe(Graphics g)
	{
		
		Color Blue = new Color(240,10,0,70);
		Color white = new Color(255,255,255); 
		Color orange = new Color(0,0,0);
		
		g.setColor(orange);
		g.fillRect(0,0,800,600); 
		
		g.setColor(Blue);
		g.fillRect(100,50,500,500); 
		
		g.setColor(white);
		Font myFont = new Font ("Courier New", 1, 35);
		Font myFont1 = new Font ("Courier New", 1, 20);
		g.setFont(myFont1);
		g.setColor(white);
		g.drawString(" " + num1,300,150); 
		g.setColor(white);
		g.drawString( " " + num2,325,150); 
		g.setColor(white);
		g.drawString(" " + num3,345,150); 
		g.setColor(white);
		g.drawString("Your Current Balance is: " + balance ,200,182);
		g.setColor(white);
		g.drawString("Your Current Bet is: " + bet ,212,204); 
		g.setFont(myFont);
		g.drawString("Welcome to the Casino!",120,100); 

		Color Black = new Color(0,0,0);
		g.setColor(Black);
		g.fillRect(x-400,RocketY,60,200);
		Color White = new Color(255,255,255); 
		g.setColor(White);
		g.fillOval(x-400,RocketY,60,60);
		if (balance <= 0)
		{
			g.setFont(myFont1);
			g.setColor(white);
			g.drawString("You are Broke! No Longer Allowed to Bet!",170,225); 
			bet = 0;
		}
		if(checkwin && bet > 0)
		{
			g.setFont(myFont);
			g.setColor(white);
			g.drawString("You Win Nothing!",230,520); 
		}
			
	}
	public void animate()
	{
		RocketY = -100;
		while( true ) 
		{
				RocketY = -100;
				if(RocketY < 600)
				{
					RocketY ++;
				}
				else
				{
					RocketY = -100;
				}
	
			try{
				Thread.sleep(10);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			repaint();

		}
	}
	public void play()
	{
		if(balance > 0 && bet > 0)
		{
			num1 = (int)(Math.random()*9+1); 
			num2 = (int)(Math.random()*9+1); 
			num3 = (int)(Math.random()*9+1); 
		}
		
		if(num1 == num2 || num1 == num3 || num2 == num3)
		{
			balance = balance + bet * 2; 
			checkwin = false; 
			ifwin = true;
		}
		else if (num1 == 7 && num2 == 7 && num3 == 7)
		{
			balance = balance + bet * 100; 
			checkwin = false;
			ifwin = true;
		}
		else if (num1 == num2 && num2 == num3 && num1 != 7)
		{
			balance = balance + bet * 5; 
			checkwin = false;
			ifwin = true;
		}
		else
		{
			balance = balance - bet;
			checkwin = true;
			ifwin  = false;
		}
	}
	public void bet(int a)
	{
		bet = a;
		balance = balance - bet;
	}



	public void betAllIn()
	{
		bet = balance;
	}	

	
}