package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Aplikacija;
import model.Tura;

public class GlavniProzor extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	public GlavniProzor() {

		setSize(800, 600);
		
		setTitle("Turisticka agencija");

		ImageIcon i = new ImageIcon("images/ikonica.png");
		setIconImage(i.getImage());

		setLayout(new BorderLayout());

		meni();
		panelPretrage();
		pozadinaProzora();
		omoguciIzlaz();

	}
	
	//samo za test, uklanjamo ga posle
		private void omoguciIzlaz(){
			this.addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
		            System.exit(0);
		         }        
		      });
		}

	public void meni() {

		JMenuBar menubar = new JMenuBar();

		JMenuItem log = new JMenuItem("Prijava");
		log.setMaximumSize(new Dimension(80, 50));
		log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// onaj ko bude radio logovanje nek doda poziv za prikaz prozora
				// za logovanje
				new ProzorZaLogovanje(Aplikacija.korisnici);
			}
		});

		JMenuItem reg = new JMenuItem("Registracija");
		reg.setMaximumSize(new Dimension(80, 50));
		reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// isto za registrovanje
				new ProzorZaRegistraciju(Aplikacija.korisnici);
			}
		});

		menubar.add(log);
		menubar.add(reg);

		setJMenuBar(menubar);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void panelPretrage() {

		JPanel imp = new JPanel();
		imp.setLayout(new BorderLayout());
		JLabel labela = new JLabel("Parametar pretrage: ");
		JTextField text = new JTextField(10);
		JButton trazi = new JButton("Trazi");
	
		trazi.setMinimumSize(new Dimension(40,40));
		
			
		JComboBox opcijePretrage = new JComboBox();
		opcijePretrage.addItem("termin");
		opcijePretrage.addItem("ocena");
		opcijePretrage.addItem("cena");
		opcijePretrage.addItem("vodic");
		opcijePretrage.addItem("grad");

		JPanel leviP = new JPanel();
		JPanel srednjiP = new JPanel();
		JPanel desniP = new JPanel();
		
		
		imp.add(leviP, BorderLayout.WEST);
		imp.add(srednjiP, BorderLayout.CENTER);
		imp.add(desniP, BorderLayout.EAST);

		desniP.add(new JLabel("Tip pretrage: "));
		desniP.add(opcijePretrage);
		
		
		desniP.add(labela);
		desniP.add(text);
		
		desniP.add(trazi);
		
		add(imp, BorderLayout.NORTH);
		
		
		
		trazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tip=(String)opcijePretrage.getSelectedItem();
				String parametar = (String) text.getText();
				
				ArrayList<Tura> ture=Aplikacija.pretraziTure(tip, parametar);
				if(ture.size()==0){
			        JOptionPane.showMessageDialog(null, "Nije pronadjena ni jedna tura.", "Informacija: ", JOptionPane.INFORMATION_MESSAGE);
				}else{
					RezultatPretrageProzor rp = new RezultatPretrageProzor(ture, Aplikacija.trenutnoAktivan);
					rp.setVisible(true);
				}
				
				
			}
		});
		
		

	}

	public void pozadinaProzora() {

		JPanel imp = new JPanel();

		ImageIcon im = new ImageIcon("images/image.jpg");
		Image image = im.getImage();
		Image newimg = image.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH);
		im = new ImageIcon(newimg);

		JLabel labela = new JLabel();
		labela.setIcon(im);

		imp.add(labela);
		add(imp, BorderLayout.SOUTH);

	}

}
