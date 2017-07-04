package view;
import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import model.Korisnik;


public class TuristaUlogovanProzor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TuristaUlogovanProzor(Korisnik ulogovani) throws IOException {
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JTabbedPane jtp = new JTabbedPane();
		JToolBar jtb = new JToolBar();
		jtb.setPreferredSize(new Dimension(800, 40));
		
		JButton bIzlogujSe = new JButton("Odjava");
		jtb.setLayout(new BorderLayout());
		jtb.add(bIzlogujSe, BorderLayout.EAST);
		
		TabProfil tp = new TabProfil(ulogovani);
		jtp.addTab("Profil", tp);
		
		/*Ovde dodavati nove tabove, praviti tabove kao JPanel klase*/
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(jtb, BorderLayout.NORTH);
		this.getContentPane().add(jtp, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
