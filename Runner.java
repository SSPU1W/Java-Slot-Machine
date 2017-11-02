import javax.swing.JFrame; 
public class Runner
{
	public static void main(String [] args)
	{
		JFrame frame = new JFrame("Slot Machine"); 
		Screen sc = new Screen(); 
		SlotMachine sm = new SlotMachine(100); 
		frame.add(sc); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack(); 
		frame.setVisible(true);
		sc.animate();
		
	}
}