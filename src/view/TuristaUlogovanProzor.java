package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import controller.Aplikacija;
import model.Korisnik;
import model.Vodic;


public class TuristaUlogovanProzor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TuristaUlogovanProzor(Korisnik ulogovani) throws IOException {
		this.setSize(850, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JTabbedPane jtp = new JTabbedPane();
		JToolBar jtb = new JToolBar();
		jtb.setPreferredSize(new Dimension(800, 20));
		
		JButton bIzlogujSe = new JButton("Odjava");
		jtb.setLayout(new BorderLayout());
		jtb.add(bIzlogujSe, BorderLayout.EAST);
		
		TabProfil tp = new TabProfil(ulogovani);
		jtp.addTab("Profil", tp);
		
		PretragaIRezervacijaTure pirt = new PretragaIRezervacijaTure();
		jtp.addTab("Pretraga, rezervacija i ocena", pirt);
		
		
		if(ulogovani instanceof Vodic){
			BrisanjeTuraPanel btp = new BrisanjeTuraPanel();
			KreiranjeTurePanel ktp = new KreiranjeTurePanel(btp);
			TabAktivacijaDeaktivacijaTure tadt = new TabAktivacijaDeaktivacijaTure((Vodic)ulogovani);
			PridruzivanjeTuriPanel ptp = new PridruzivanjeTuriPanel();
			
			jtp.addTab("Kreiraj turu", ktp);
			jtp.addTab("Brisanje ture", btp);
			jtp.addTab("Aktivacija/deaktivacija ture", tadt);
			jtp.addTab("Pridruzivanje turi", ptp);

		}
		
		bIzlogujSe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Aplikacija.trenutnoAktivan = null;
			}
		});
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(jtb, BorderLayout.NORTH);
		this.getContentPane().add(jtp, BorderLayout.CENTER);
		this.setVisible(true);
	}
}
