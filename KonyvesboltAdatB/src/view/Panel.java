package view;
/**
 * @author SZLXAGT.SZE Szűrszabó Levente  h669845
 */

import java.awt.*;
import view.MenuSor;
import java.awt.GraphicsConfiguration;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.JLabel;

public class Panel extends JPanel
{
	MouseListener m1;
	MouseAdapter lis;
	
	public Panel()
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
	public Panel(String a)
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
		
		this.setToolTipText(a);
	}
	
}
