import javax.swing.JPanel;
import java.awt.Graphics; 
import java.awt.Color;
import java.awt.Dimension; 

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File; 
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.*;

public class Screen extends JPanel implements ActionListener
{
	SlotMachine sm;
	JButton spinButton; 
	JButton betButton;
	JButton bet5Button;
	JButton bet10Button;
	JButton allInButton;
	int RocketY;
	int x; 
	int y;

	
    public static void main(String[] args) {        
        
		try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("cartoon002.wav"));
            Clip test = AudioSystem.getClip();  

            test.open(ais);
            test.start();

            while (!test.isRunning())
                Thread.sleep(10);
            while (test.isRunning())
                Thread.sleep(10);

            test.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
	}
	public Screen()
	{
		this.setLayout(null); 
		int x = 400;
		int y = 450;
		spinButton = new JButton("Play"); 
		spinButton.setBounds(180,440,300,50); 
		spinButton.addActionListener(this); 
		this.add(spinButton); 
		
		betButton = new JButton("Bet 1"); 
		betButton.setBounds(170,340,100,50); 
		betButton.addActionListener(this); 
		this.add(betButton); 
		
		bet5Button = new JButton("Bet 5"); 
		bet5Button.setBounds(280,340,100,50); 
		bet5Button.addActionListener(this); 
		this.add(bet5Button);
		
		bet10Button = new JButton("Bet 10"); 
		bet10Button.setBounds(390,340,100,50); 
		bet10Button.addActionListener(this); 
		this.add(bet10Button);
		
		allInButton = new JButton("Go All In"); 
		allInButton.setBounds(209,270,250,50); 
		allInButton.addActionListener(this); 
		this.add(allInButton);
		
		sm = new SlotMachine(100); 
		this.setFocusable(true); 
	}
	public Dimension getPreferredSize()
	{
		return new Dimension(800,600);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		sm.drawMe(g); 
	}

	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource() == spinButton)
		{
			sm.play(); 
		}
		repaint(); 
		if(e.getSource() == betButton)
		{
			sm.bet(1); 
		}
		if(e.getSource() == bet5Button)
		{
			sm.bet(5); 
		}
		if(e.getSource() == bet10Button)
		{
			sm.bet(10); 
		}
		repaint();
		if(e.getSource() == allInButton )
		{
			sm.betAllIn(); 
		}
		repaint();
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
}