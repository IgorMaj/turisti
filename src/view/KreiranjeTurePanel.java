package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.Aplikacija;
import model.Destinacija;
import model.Komentar;
import model.Kreiran;
import model.Mesto;
import model.Rezervacija;
import model.Termin;
import model.Tura;
import model.Vodic;

public class KreiranjeTurePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Tura novaTura = new Tura();
	public ArrayList<Mesto> mesta = new ArrayList<Mesto>();
	public ArrayList<Destinacija> destinacije = new ArrayList<Destinacija>();
	public ArrayList<Termin> termini = new ArrayList<Termin>();

	KreiranjeTurePanel(BrisanjeTuraPanel btp) {
		JPanel p1 = new JPanel(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.anchor = GridBagConstraints.NORTHWEST;
		g.insets = new Insets(2, 1, 2, 1);
		TitledBorder tb1 = new TitledBorder("Unesite osnovne podatke ture");
		p1.setBorder(tb1);

		JLabel l1 = new JLabel("ID ture: ");
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		p1.add(l1, g);

		JTextField inIdTure = new JTextField();
		inIdTure.setPreferredSize(new Dimension(200, 20));
		g.gridx = 1;
		g.gridy = 0;
		p1.add(inIdTure, g);

		JLabel l2 = new JLabel("Opis ture: ");
		g.gridx = 0;
		g.gridy = 1;
		g.gridheight = 2;
		p1.add(l2, g);

		JTextArea inOpisTure = new JTextArea();
		JScrollPane sOpisture = new JScrollPane(inOpisTure);
		sOpisture.setPreferredSize(new Dimension(400, 50));
		g.gridx = 1;
		g.gridy = 1;
		g.gridheight = 2;
		p1.add(sOpisture, g);

		JLabel l3 = new JLabel("Potreban broj prijavljenih: ");
		g.gridx = 0;
		g.gridy = 3;
		g.gridheight = 1;
		p1.add(l3, g);

		JTextField inMinBrojMesta = new JTextField();
		inMinBrojMesta.setPreferredSize(new Dimension(50, 20));
		g.gridx = 1;
		g.gridy = 3;
		g.gridheight = 1;
		p1.add(inMinBrojMesta, g);
		// levo gradovi
		JPanel p2 = new JPanel(new BorderLayout());
		TitledBorder tb2 = new TitledBorder("Popunite listu gradova ture");
		p2.setBorder(tb2);

		JPanel levi1 = new JPanel(new GridBagLayout());
		JLabel l4 = new JLabel("Naziv grada: ");
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		levi1.add(l4, g);

		JTextField inNazivGrada = new JTextField();
		inNazivGrada.setPreferredSize(new Dimension(200, 20));
		g.gridx = 1;
		g.gridy = 0;
		g.gridheight = 1;
		levi1.add(inNazivGrada, g);

		JLabel l5 = new JLabel("PTT: ");
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 1;
		levi1.add(l5, g);

		JTextField inPTT = new JTextField();
		inPTT.setPreferredSize(new Dimension(50, 20));
		g.gridx = 1;
		g.gridy = 1;
		levi1.add(inPTT, g);

		JButton bDodajGrad = new JButton("Dodaj Grad");
		bDodajGrad.setPreferredSize(new Dimension(100, 20));
		g.gridx = 0;
		g.gridwidth = 2;
		g.gridy = 2;
		levi1.add(bDodajGrad, g);
		// desno gradovi
		JPanel desni1 = new JPanel(new GridBagLayout());
		JLabel l6 = new JLabel("Lista dodatih gradova: ");
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		desni1.add(l6, g);

		JComboBox<String> cListaDodatihGradova = new JComboBox<String>();
		cListaDodatihGradova.setPreferredSize(new Dimension(200, 20));
		g.gridx = 1;
		g.gridy = 0;
		desni1.add(cListaDodatihGradova, g);

		JButton bUkloniGrad = new JButton("Ukloni iz liste");
		bUkloniGrad.setPreferredSize(new Dimension(150, 20));
		g.gridx = 0;
		g.gridwidth = 2;
		g.gridy = 1;
		desni1.add(bUkloniGrad, g);

		p2.add(levi1, BorderLayout.WEST);
		p2.add(desni1, BorderLayout.EAST);

		// unos destinacija
		JPanel p3 = new JPanel(new BorderLayout());
		TitledBorder tb3 = new TitledBorder("Popunite listu destinacija ture");
		p3.setBorder(tb3);

		JPanel levi2 = new JPanel(new GridBagLayout());
		JLabel l7 = new JLabel("Naziv: ");
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		levi2.add(l7, g);

		JTextField inNazivDestinacije = new JTextField();
		inNazivDestinacije.setPreferredSize(new Dimension(200, 20));
		g.gridx = 1;
		g.gridy = 0;
		g.gridheight = 1;
		levi2.add(inNazivDestinacije, g);

		JLabel l8 = new JLabel("Opis: ");
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 1;
		g.gridheight = 2;
		levi2.add(l8, g);

		JTextArea inOpisDestinacije = new JTextArea();
		JScrollPane sOpisDestinacije = new JScrollPane(inOpisDestinacije);
		sOpisDestinacije.setPreferredSize(new Dimension(300, 50));
		g.gridx = 1;
		g.gridy = 1;
		levi2.add(sOpisDestinacije, g);

		JLabel l9 = new JLabel("Mesto: ");
		g.gridheight = 1;
		g.gridx = 0;
		g.gridy = 3;
		levi2.add(l9, g);

		JComboBox<String> cMestoDestinacija = new JComboBox<String>();
		cMestoDestinacija.setPreferredSize(new Dimension(200, 20));
		g.gridx = 1;
		g.gridy = 3;
		levi2.add(cMestoDestinacija, g);

		JButton bDodajDestinaciju = new JButton("Dodaj");
		bDodajDestinaciju.setPreferredSize(new Dimension(100, 20));
		g.gridx = 0;
		g.gridwidth = 2;
		g.gridy = 4;
		levi2.add(bDodajDestinaciju, g);
		// desno unos
		JPanel desni2 = new JPanel(new GridBagLayout());
		JLabel l10 = new JLabel("Lista dodatih destinacija: ");
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		desni2.add(l10, g);

		JComboBox<String> cListaDodatihDestinacija = new JComboBox<String>();
		cListaDodatihDestinacija.setPreferredSize(new Dimension(200, 20));
		g.gridx = 1;
		g.gridy = 0;
		desni2.add(cListaDodatihDestinacija, g);

		JButton bUkloniDestinaciju = new JButton("Ukloni iz liste");
		bUkloniDestinaciju.setPreferredSize(new Dimension(150, 20));
		g.gridx = 0;
		g.gridwidth = 2;
		g.gridy = 1;
		desni2.add(bUkloniDestinaciju, g);

		p3.add(levi2, BorderLayout.WEST);
		p3.add(desni2, BorderLayout.EAST);
		// termini unos
		JPanel p4 = new JPanel(new BorderLayout());
		TitledBorder tb4 = new TitledBorder("Popunite termine ture");
		p4.setBorder(tb4);

		JPanel levi3 = new JPanel(new GridBagLayout());

		JLabel l11 = new JLabel("Datum pocetka: ");
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		levi3.add(l11, g);

		JTextField inDatumPocetka = new JTextField();
		inDatumPocetka.setPreferredSize(new Dimension(100, 20));
		g.gridx = 1;
		g.gridy = 0;
		levi3.add(inDatumPocetka, g);

		JLabel l12 = new JLabel("Datum zavrsetka: ");
		g.gridx = 2;
		g.gridy = 0;
		levi3.add(l12, g);

		JTextField inDatumZavrsetka = new JTextField();
		inDatumZavrsetka.setPreferredSize(new Dimension(100, 20));
		g.gridx = 3;
		g.gridy = 0;
		levi3.add(inDatumZavrsetka, g);

		JLabel l13 = new JLabel("Broj mesta: ");
		g.gridx = 0;
		g.gridy = 1;
		levi3.add(l13, g);

		JTextField inBrojMestaTermina = new JTextField();
		inBrojMestaTermina.setPreferredSize(new Dimension(50, 20));
		g.gridx = 1;
		g.gridy = 1;
		levi3.add(inBrojMestaTermina, g);

		JLabel l14 = new JLabel("Cena: ");
		g.gridx = 0;
		g.gridy = 2;
		levi3.add(l14, g);

		JTextField inCenaTermina = new JTextField();
		inCenaTermina.setPreferredSize(new Dimension(50, 20));
		g.gridx = 1;
		g.gridy = 2;
		levi3.add(inCenaTermina, g);

		JButton bDodajTermin = new JButton("Dodaj");
		bDodajTermin.setPreferredSize(new Dimension(100, 20));
		g.gridx = 0;
		g.gridwidth = 2;
		g.gridy = 3;
		levi3.add(bDodajTermin, g);

		// desno termini
		JPanel desni3 = new JPanel(new GridBagLayout());
		JLabel l15 = new JLabel("Lista dodatih termina: ");
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		desni3.add(l15, g);

		JComboBox<String> cListaDodatihTermina = new JComboBox<String>();
		cListaDodatihTermina.setPreferredSize(new Dimension(200, 20));
		g.gridx = 1;
		g.gridy = 0;
		desni3.add(cListaDodatihTermina, g);

		JButton bUkloniTermin = new JButton("Ukloni iz liste");
		bUkloniTermin.setPreferredSize(new Dimension(150, 20));
		g.gridx = 0;
		g.gridwidth = 2;
		g.gridy = 1;
		desni3.add(bUkloniTermin, g);

		p4.add(levi3, BorderLayout.WEST);
		p4.add(desni3, BorderLayout.EAST);

		// dugmad

		JPanel p5 = new JPanel(new BorderLayout());
		JPanel levi4 = new JPanel();
		JPanel desni4 = new JPanel(new FlowLayout());

		JButton bSacuvajTuru = new JButton("Sacuvaj");
		desni4.add(bSacuvajTuru);

		JButton bOdustani = new JButton("Odustani");
		desni4.add(bOdustani);

		p5.add(levi4, BorderLayout.WEST);
		p5.add(desni4, BorderLayout.EAST);

		// prazne labele da sve bude gore levo
		g.weightx = 1;
		g.weighty = 1;
		p1.add(new JLabel(" "), g);
		levi1.add(new JLabel(" "), g);
		desni1.add(new JLabel(" "), g);
		levi2.add(new JLabel(" "), g);
		desni2.add(new JLabel(" "), g);
		levi3.add(new JLabel(" "), g);
		desni3.add(new JLabel(" "), g);

		// paneli
		setLayout(new GridBagLayout());
		g.fill = GridBagConstraints.HORIZONTAL;
		g.gridx = 0;
		g.gridy = 0;
		g.weightx = 0;
		g.weighty = 0;
		g.gridwidth = 2;
		g.gridheight = 2;
		add(p1, g);

		g.gridx = 0;
		g.gridy = 3;
		g.gridheight = 1;
		add(p2, g);

		g.gridx = 0;
		g.gridy = 4;
		add(p3, g);

		g.gridx = 0;
		g.gridy = 5;
		add(p4, g);
		g.gridx = 0;
		g.gridy = 6;
		add(p5, g);

		// prazna labela da pocne od gornjeg levog ugla
		g.weightx = 1;
		g.weighty = 1;
		add(new JLabel(" "), g);

		bDodajDestinaciju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean unos = true;
				if (!inNazivDestinacije.getText().isEmpty() && inNazivDestinacije.getText() != null) {
					inNazivDestinacije.setBackground(Color.white);
				} else {
					unos = false;
					inNazivDestinacije.setBackground(Color.RED);
				}
				if (!inOpisDestinacije.getText().isEmpty() && inNazivDestinacije.getText() != null) {
					inOpisDestinacije.setBackground(Color.white);
				} else {
					unos = false;
					inOpisDestinacije.setBackground(Color.RED);
				}
				if (cMestoDestinacija.getSelectedItem() != null && !cMestoDestinacija.getSelectedItem().equals("")) {
					cMestoDestinacija.setBackground(Color.white);
				} else {
					unos = false;
					cMestoDestinacija.setBackground(Color.RED);
				}
				if (unos) {
					Destinacija destinacija = new Destinacija();
					destinacija.setNaziv(inNazivDestinacije.getText());
					destinacija.setOpis(inOpisDestinacije.getText());
					for (Mesto mesto : mesta) {
						if (mesto.getNaziv().equals(cMestoDestinacija.getSelectedItem()))
							destinacija.setMesto(mesto);
						break;
					}
					cListaDodatihDestinacija.addItem(destinacija.getNaziv());
					destinacije.add(destinacija);
				} else {
					JOptionPane.showMessageDialog(null, "Niste uneli sva polja.", "Greska", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		bUkloniDestinaciju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Destinacija zaBrisanje = new Destinacija();
				for (Destinacija destinacija : destinacije) {
					if (destinacija.getNaziv().equals(cListaDodatihDestinacija.getSelectedItem())) {
						zaBrisanje = destinacija;
						cListaDodatihDestinacija.removeItemAt(cListaDodatihDestinacija.getSelectedIndex());
						break;
					}
				}
				destinacije.remove(zaBrisanje);

			}
		});

		bDodajGrad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean unos = true;
				if (!inNazivGrada.getText().isEmpty() && inNazivGrada.getText() != null) {
					inNazivGrada.setBackground(Color.white);
				} else {
					unos = false;
					inNazivGrada.setBackground(Color.RED);
				}
				if (!inPTT.getText().isEmpty() && inPTT.getText() != null) {
					inPTT.setBackground(Color.white);
				} else {
					unos = false;
					inPTT.setBackground(Color.RED);
				}
				if (unos) {
					Mesto grad = new Mesto();
					grad.setNaziv(inNazivGrada.getText());
					grad.setPtt(Integer.parseInt(inPTT.getText()));

					cListaDodatihGradova.addItem(grad.getNaziv());
					cMestoDestinacija.addItem(grad.getNaziv());
					mesta.add(grad);
				} else {
					JOptionPane.showMessageDialog(null, "Niste uneli sva polja.", "Greska", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		bUkloniGrad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mesto zaBrisanje = new Mesto();
				for (Mesto mesto : mesta) {
					if (mesto.getNaziv().equals(cListaDodatihGradova.getSelectedItem())) {
						zaBrisanje = mesto;
						cListaDodatihGradova.removeItemAt(cListaDodatihGradova.getSelectedIndex());
						for (int i = 0; i < cMestoDestinacija.getItemCount(); i++) {
							if (cMestoDestinacija.getItemAt(i).equals(mesto.getNaziv())) {
								cMestoDestinacija.removeItemAt(i);
								break;
							}
						}
					}
				}
				mesta.remove(zaBrisanje);
			}
		});

		bDodajTermin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean unos = true;
				if (!inDatumPocetka.getText().isEmpty() && inDatumPocetka.getText() != null) {
					inDatumPocetka.setBackground(Color.white);
				} else {
					unos = false;
					inDatumPocetka.setBackground(Color.RED);
				}
				if (!inDatumZavrsetka.getText().isEmpty() && inDatumZavrsetka.getText() != null) {
					inDatumZavrsetka.setBackground(Color.white);
				} else {
					unos = false;
					inDatumZavrsetka.setBackground(Color.RED);
				}
				if (!inBrojMestaTermina.getText().isEmpty() && inBrojMestaTermina.getText() != null) {
					inBrojMestaTermina.setBackground(Color.white);
				} else {
					unos = false;
					inBrojMestaTermina.setBackground(Color.RED);
				}
				if (!inCenaTermina.getText().isEmpty() && inCenaTermina.getText() != null) {
					inCenaTermina.setBackground(Color.white);
				} else {
					unos = false;
					inCenaTermina.setBackground(Color.RED);
				}

				if (unos) {
					Termin termin = new Termin();

					termin.setAktivan(false);
					termin.setAktivnoStanje(new Kreiran(termin));
					termin.setBrojSlobodnihMesta(Integer.parseInt(inBrojMestaTermina.getText()));
					termin.setCena(Double.parseDouble(inCenaTermina.getText()));
					termin.setKrajTure(inDatumZavrsetka.getText());
					termin.setPocetakTure(inDatumPocetka.getText());
					termin.setRezervacije(new ArrayList<Rezervacija>());
					termin.setTura(novaTura);

					cListaDodatihTermina.addItem(termin.getPocetakTure());
					termini.add(termin);
				} else {
					JOptionPane.showMessageDialog(null, "Niste uneli sva polja.", "Greska", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		bUkloniTermin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Termin zaBrisanje = new Termin();
				for (Termin termin : termini) {
					if(termin.getPocetakTure().equals(cListaDodatihTermina.getSelectedItem())){
						zaBrisanje = termin;
						cListaDodatihTermina.removeItemAt(cListaDodatihTermina.getSelectedIndex());
						break;
					}
				}
				termini.remove(zaBrisanje);
				return;
			}
		});

		bSacuvajTuru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean unos = true;
				if (!inIdTure.getText().isEmpty() && inIdTure.getText() != null) {
					inIdTure.setBackground(Color.white);
				} else {
					unos = false;
					inIdTure.setBackground(Color.RED);
				}
				if (!inOpisTure.getText().isEmpty() && inOpisTure.getText() != null) {
					inOpisTure.setBackground(Color.white);
				} else {
					unos = false;
					inOpisTure.setBackground(Color.RED);
				}
				if (!inMinBrojMesta.getText().isEmpty() && inMinBrojMesta.getText() != null) {
					inMinBrojMesta.setBackground(Color.white);
				} else {
					unos = false;
					inMinBrojMesta.setBackground(Color.RED);
				}
				if(unos){
					if(!termini.isEmpty() && !destinacije.isEmpty()){
						novaTura.setDestinacije(destinacije);
						novaTura.setGradovi(mesta);
						novaTura.setIdTure(inIdTure.getText());
						novaTura.setKomentari(new ArrayList<Komentar>());
						novaTura.setKreatorTure((Vodic)Aplikacija.trenutnoAktivan);
						novaTura.setMinBrojMesta(Integer.parseInt(inMinBrojMesta.getText()));
						novaTura.setOcena(-1);
						novaTura.setOpis(inOpisTure.getText());
						novaTura.setTermini(termini);
						novaTura.setVodici(new ArrayList<Vodic>(){{add((Vodic)Aplikacija.trenutnoAktivan);}});
						try {
							Aplikacija.dodajTuru(novaTura);
						} catch (IOException e) {
							e.printStackTrace();
						}
						DefaultTableModel dtm = (DefaultTableModel) btp.tabela.getModel();
						dtm.addRow(new Object[] {novaTura.getIdTure(), novaTura.getOpis(), novaTura.getOcena(), novaTura.getMinBrojMesta()});
						
						btp.tabela.setPreferredSize(new Dimension(800, 18 * (btp.tabela.getRowCount() + 1)));
						btp.s.setPreferredSize(new Dimension(800, 18 * (btp.tabela.getRowCount() + 1)));
						
						btp.revalidate();
						btp.repaint();
						
						termini = new ArrayList<Termin>();
						mesta = new ArrayList<Mesto>();
						destinacije = new ArrayList<Destinacija>();
						novaTura = new Tura();
						
						inBrojMestaTermina.setText("");
						inCenaTermina.setText("");
						inDatumPocetka.setText("");
						inDatumZavrsetka.setText("");
						inIdTure.setText("");
						inMinBrojMesta.setText("");
						inNazivDestinacije.setText("");
						inNazivGrada.setText("");
						inOpisDestinacije.setText("");
						inOpisTure.setText("");
						inPTT.setText("");
						cListaDodatihDestinacija.removeAllItems();
						cListaDodatihGradova.removeAllItems();
						cListaDodatihTermina.removeAllItems();
						cMestoDestinacija.removeAllItems();
					}else{
				        JOptionPane.showMessageDialog(null, "Potrebno je uneti bar jedan termin i destinaciju!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}else{
			        JOptionPane.showMessageDialog(null, "Niste uneli sve podatke!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		bOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				termini = new ArrayList<Termin>();
				mesta = new ArrayList<Mesto>();
				destinacije = new ArrayList<Destinacija>();
				novaTura = new Tura();
				
				inBrojMestaTermina.setText("");
				inCenaTermina.setText("");
				inDatumPocetka.setText("");
				inDatumZavrsetka.setText("");
				inIdTure.setText("");
				inMinBrojMesta.setText("");
				inNazivDestinacije.setText("");
				inNazivGrada.setText("");
				inOpisDestinacije.setText("");
				inOpisTure.setText("");
				inPTT.setText("");
				cListaDodatihDestinacija.removeAllItems();
				cListaDodatihGradova.removeAllItems();
				cListaDodatihTermina.removeAllItems();
				cMestoDestinacija.removeAllItems();
			}
		});

	}
	private void ocistiProzor(){
		
	}
	
	private void add(GridLayout g) {
		// TODO Auto-generated method stub

	}

}
