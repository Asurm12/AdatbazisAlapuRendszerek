package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;



public class Label extends JLabel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3953341392855886653L;
	MouseListener m1;
	MouseAdapter lis;
	
	
	public Label()
	{


		m1 = new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
			  //ide tegyétek az adatbázis eventeket
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		};

	}
	public Label(String a)
	{
		this.setText(a);
		
		m1 = new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
			  //ide tegyétek az adatbázis eventeket
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		};
	
	}

}
