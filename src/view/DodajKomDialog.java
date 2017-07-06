package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Komentar;
import model.Korisnik;

public class DodajKomDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Komentar> komentari;
	private JTextArea tekstualnoPolje;
	private JButton dodajDugme;
	private JButton otkaziDugme;
	private Korisnik autor;

	
	
	public DodajKomDialog(KomPanel komP){
		super();
		this.komentari = komP.getKomentari();
		BorderLayout layout = new BorderLayout();
		this.autor = komP.getUlogovaniKorisnik();
		this.setLayout(layout);
		this.tekstualnoPolje = new JTextArea();
		this.tekstualnoPolje.setEditable(true);
		this.tekstualnoPolje.setPreferredSize(new Dimension(100, tekstualnoPolje.getHeight()));
		
		this.setTitle("Upisite Vas komentar");
		this.add(this.tekstualnoPolje, BorderLayout.CENTER);
		this.setSize(200,100);
		dodajDugme = new JButton("Dodaj");
		otkaziDugme = new JButton("Otkazi");
		dodajDugme.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				prihvatiDialog(komP);
				
			}});
		otkaziDugme.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				odbijDialog();
				
			}});
		
		GridLayout donji = new GridLayout(1,2);
		JPanel donjiPanel = new JPanel();
		donjiPanel.setLayout(donji);
		
		donjiPanel.add(dodajDugme);
		donjiPanel.add(otkaziDugme);
		this.add(donjiPanel,BorderLayout.PAGE_END);
	}


	private void odbijDialog() {
		this.dispose();
		
	}


	private void prihvatiDialog(KomPanel komP) {
		String sadrzina = this.tekstualnoPolje.getText();
		if(sadrzina.length()==0){
			JOptionPane.showMessageDialog(DodajKomDialog.this, "Komentar ne moze biti prazan!");
			return;
		}
		else{
			this.komentari.add(new Komentar(new Date(),sadrzina,this.autor));
			
		}
		komP.azurirajPanel();
		this.dispose();
		
	}
	
}
