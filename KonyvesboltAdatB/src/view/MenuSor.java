package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 * @author SZLXAGT.SZE Sz�rszab� Levente  h669845
 */


/**
 * @author Highborn_Hellest
 *
 */
public class MenuSor extends JMenuBar implements ActionListener
{

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	private Frame gui;
	@Override
	public void actionPerformed(ActionEvent e) //itt vanakka a ki�r�sok a t�bl�zatba!
	{
	    String actionCommand = e.getActionCommand();
		System.out.println(actionCommand);
		
		
	/*	if (actionCommand.equals("konyv"))
		{
			System.out.println("K�nyv");
			
		}*/
		switch(actionCommand)
		{
			case "Konyv":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Album":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Alkalmazott":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Aruhaz":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Film":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Kedvezmeny":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Raktar":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Rendeles":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Termek":
			{
				System.out.println(actionCommand);
				break;
			}
			case "Vasarlo":
			{
				System.out.println(actionCommand);
				break;
			}
			default:
			{
				System.out.println("Valami el van baszva mert ez nem futhat le");
				break;
			}
		
		}
		
		/* ezelapj�n k�ne megcisn�lni de ehhez kell a DAO-s cucc ameddig az nincs meg �n nem tudom folytatni
		 * 
		 *  List<Customer> customers = gui.getController().getCustomers();

            // Csin�lunk egy t�bl�zatot, a CustomerTableModel alapjan, ami
            // megkapja a controltol a customereket
            JTable table = new JTable(new CustomerTableModel(customers));

            // A t�blazatot r�rakjuk egy ScrollPane-re, �gy ha az t�l nagy lenne
            // az ablak m�ret�hez k�pest, akkor is g�rgetheto lesz
            JScrollPane container = new JScrollPane(table);
		 * 
		 * */
		
		
		
		
		
	}
	
	public MenuSor(Frame gui)
	{
		super();
		this.gui = gui;
        /*createMenuPoint(Labels.konyv, "list_books");
        createMenuPoint("placeholder for Almbum","placeholder" );
        createMenuPoint("placeholder for Alkalmazott","placeholder" );
        createMenuPoint("placeholder  for Aruhaz","placeholder" );
        createMenuPoint("placeholder for Film","placeholder" );
        createMenuPoint("placeholder for Kedvezmeny","placeholder" );
        createMenuPoint("placeholder for Raktar","placeholder" );
        createMenuPoint("placeholder for Rendeles","placeholder" );
        createMenuPoint("placeholder for Termek","placeholder" );
        createMenuPoint("placeholder for Vasarlo","placeholder" );*/
        createMenuPoint(
        		"Lekerdezesek","Konyv","Almbum" ,"Alkalmazott",
        		"Aruhaz", "Film", "Kedvezmeny",
        		"Raktar", "Rendeles", "Termek", "Vasarlo");

        
	}
    private void createMenuPoint(String name, String... subnames)
    {
        // L�trehozunk egy menupontot az els� param�ter alapj�n
        JMenu menu = new JMenu(name);

        // A menupontot hozz�adjuk a BookShopMenuBar-hoz
        this.add(menu);

        // Az egyes menu itemeket a marad�k param�ter �rt�keivel hozzuk l�tre
        for (String subname : subnames) {
            JMenuItem menuItem = new JMenuItem(subname);

            menu.add(menuItem);

            // Minden egyes menu itemet figyel�nk
            // A menu itemek eset�n a megfigyel�st az ActionListener interf�sz
            // biztos�tja, ez�rt a menubar implement�lja ezt az interf�szt �s
            // fel�l�rja az actionPerformed met�dust
            menuItem.addActionListener(this);
        }
    }
    

	

}
