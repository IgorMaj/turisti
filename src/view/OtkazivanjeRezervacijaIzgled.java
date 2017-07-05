package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Korisnik;
import model.Rezervacija;

public class OtkazivanjeRezervacijaIzgled extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Korisnik ulogovaniKorisnik;


	private TabelaRezervacija tabelaRezervacija;


	private JButton dugmeOtkazi;


	private JButton dugmeOsvezi;
	
	public OtkazivanjeRezervacijaIzgled(Korisnik ulogovaniKorisnik){
		super();
		this.ulogovaniKorisnik = ulogovaniKorisnik;
		this.setTitle("Rezervacije");
		podesiTabelu();
		podesiIzgled();
		podesiVelicinu();
		podesiDugmad();
	}
	
	private void podesiDugmad() {
		dugmeOsvezi.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				tabelaRezervacija.azurirajTabelu();	
			}});
		
		dugmeOtkazi.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int trenutniIndex = tabelaRezervacija.getSelectedRow();
				if(trenutniIndex == -1){
					JOptionPane.showMessageDialog(OtkazivanjeRezervacijaIzgled.this, "Nije odabrana rezervacija!");
					return;
				}
				ulogovaniKorisnik.otkaziTuru(trenutniIndex);
				tabelaRezervacija.azurirajTabelu();
			}});
		
	}

	private void podesiVelicinu(){
		Dimension velicinaEkrana = Toolkit.getDefaultToolkit().getScreenSize();
		int sirina = (int)velicinaEkrana.getWidth();
		int visina = (int)velicinaEkrana.getHeight();
		this.setSize(sirina/2, visina/2);
	}

	private void podesiIzgled() {
		JScrollPane jscroll = new JScrollPane(tabelaRezervacija);
		BorderLayout komform = new BorderLayout();
		this.setLayout(komform);
		this.add(jscroll,BorderLayout.CENTER);
		dugmeOtkazi = new JButton("Otkazi");
		dugmeOsvezi = new JButton("Osvezi");
		FlowLayout donji = new FlowLayout();
		JPanel donjiPanel = new JPanel();
		donjiPanel.setLayout(donji);
		donjiPanel.add(dugmeOtkazi);
		donjiPanel.add(dugmeOsvezi);
		this.add(donjiPanel,BorderLayout.PAGE_END);
		
	}

	private void podesiTabelu() {
		ArrayList<Rezervacija> rezervacije = this.ulogovaniKorisnik.getRezervacije();
		tabelaRezervacija = new TabelaRezervacija(rezervacije);
	}
	
}
