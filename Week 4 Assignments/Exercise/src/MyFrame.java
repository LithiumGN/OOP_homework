import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class MyFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String titolo = "Esercitazione 4";
	
	/// COSTRUISCO I PULSANTI
	private static final JButton uno = new JButton ("1");
	private static final JButton due = new JButton ("2");
	private static final JButton tre = new JButton ("3");
	private static final JButton quattro = new JButton ("4");
	private static final JButton cinque = new JButton ("5");
	private static final JButton sei = new JButton ("6");
	private static final JButton sette = new JButton ("7");
	private static final JButton otto = new JButton ("8");
	private static final JButton nove = new JButton ("9");
	private static final JButton zero= new JButton ("0");
	private static final JButton show= new JButton ("MOSTRA");
	private static final JButton cancel= new JButton ("C");
	
	//COSTRUISCO I PANNELLI E GLI ELEMENTI
	private static final JPanel leftPnl =new JPanel(new BorderLayout());
	private static final JPanel grid =new JPanel(new GridLayout(4,3));
	private static final JPanel rightPnl= new JPanel(new BorderLayout());
	static final JTextArea testo = new JTextArea ();
	static final JPasswordField pass= new JPasswordField();

	
	public MyFrame(){
		
		super.setTitle(titolo);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,400);
		Container frmContentPane = this.getContentPane();
		frmContentPane.setLayout(new FlowLayout());
		
		// AGGIUNGO I JBUTTON ALLA GRID
		grid.add(sette);
		grid.add(otto);
		grid.add(nove);
		grid.add(quattro);
		grid.add(cinque);
		grid.add(sei);
		grid.add(uno);
		grid.add(due);
		grid.add(tre);
		grid.add(cancel);
		grid.add(zero);
		grid.add(show);
		
		// CONFIGURO GLI ACTION COMMAND
		uno.setActionCommand("1");
		due.setActionCommand("2");
		tre.setActionCommand("3");
		quattro.setActionCommand("4");
		cinque.setActionCommand("5");
		sei.setActionCommand("6");
		sette.setActionCommand("7");
		otto.setActionCommand("8");
		nove.setActionCommand("9");
		cancel.setActionCommand("cancel");
		show.setActionCommand("mostra");
		
		// AGGIUNGO I LISTENER
		uno.addActionListener(new MyActionListener(this));
		due.addActionListener(new MyActionListener(this));
		tre.addActionListener(new MyActionListener(this));
		quattro.addActionListener(new MyActionListener(this));
		cinque.addActionListener(new MyActionListener(this));
		sei.addActionListener(new MyActionListener(this));
		sette.addActionListener(new MyActionListener(this));
		otto.addActionListener(new MyActionListener(this));
		nove.addActionListener(new MyActionListener(this));
		zero.addActionListener(new MyActionListener(this));
		cancel.addActionListener(new MyActionListener(this));
		show.addActionListener(new MyActionListener(this));
		
		//POSIZIONO I BUTTON
		leftPnl.add(grid, BorderLayout.SOUTH);
		leftPnl.add(pass, BorderLayout.NORTH);
		rightPnl.add(new JLabel("Codice digitato:"), BorderLayout.NORTH);
		testo.setBorder(BorderFactory.createLineBorder(Color.black));
		rightPnl.add(testo, BorderLayout.CENTER);
		
		//AGGIUNGO I PANNELLI AL FRAME
		frmContentPane.add(leftPnl);
		frmContentPane.add(rightPnl);
		
		//CAMBIO LE PROPRIETA'
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
		testo.setEditable(false);
		pass.setEditable(false);
	}
	
}
