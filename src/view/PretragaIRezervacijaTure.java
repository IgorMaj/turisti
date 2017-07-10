package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import controller.Aplikacija;
import model.Aktivan;
import model.Kreiran;
import model.Otkazan;
import model.Tura;
import model.Vodic;

public class PretragaIRezervacijaTure extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	JScrollPane skroluj;
	JButton rezervisiTuru;
	JButton oceniTuru;
	
	JLabel lpocetniTermin = new JLabel("pocetni termin:");
	JLabel lkrajnjiTermin = new JLabel("krajnji termin:");
	JLabel lminimalnaOcena = new JLabel("minimalna ocena:");
	JLabel lmaksimalnaOcena = new JLabel("maksimalna ocena:");
	JLabel lVodic = new JLabel("vodic:");
	JLabel lmesto = new JLabel("mesto:");
	JLabel lopisTure = new JLabel("opis ture:");
	
	
	JTextField tfpocetniTermin = new JTextField(8);
	JTextField tfkrajnjiTermin = new JTextField(8);
	JComboBox tfminimalnaOcena = new JComboBox();
	JComboBox tfmaksimalnaOcena = new JComboBox();
	JTextField tfVodic = new JTextField(15);
	JTextField tfmesto = new JTextField(15);
	JTextField tfopisTure = new JTextField(15);
	
	JButton bprikaziRezultate = new JButton("Prikazi");
	
	
	public PretragaIRezervacijaTure(){	
		
		Vector<String> kolone = new Vector<String>();
		kolone.add("id ture");
		kolone.add("minimalni broj mesta");
		kolone.add("pocetak ture");
		kolone.add("zavrsetak ture");
		kolone.add("stanje");
		
		ArrayList<Tura> aktivneTure = Aplikacija.ture;
		
		Vector<Vector<String>> podaci = new Vector<Vector<String>>();
		
		for (int i = 0;i<aktivneTure.size();i++){
			for (int termini = 0; termini < aktivneTure.get(i).getTermini().size(); termini++) {
				if(aktivneTure.get(i).getTermini().get(termini).getAktivnoStanje() instanceof Aktivan){
					Vector<String> redTabele = new Vector<String>();
					redTabele.add(aktivneTure.get(i).getIdTure());
					redTabele.add(""+aktivneTure.get(i).getMinBrojMesta());
					redTabele.add(""+aktivneTure.get(i).getTermini().get(termini).getPocetakTure());
					redTabele.add(""+aktivneTure.get(i).getTermini().get(termini).getKrajTure());
					if(aktivneTure.get(i).getTermini().get(termini).getAktivnoStanje() instanceof Aktivan ){
						redTabele.add("aktivan");
					}
					podaci.add(redTabele);
				}	
			}
		}
		this.setLayout(new GridLayout(2,0));
		
		JPanel gornjiPanel = new JPanel();
		gornjiPanel.setLayout(new GridBagLayout());
		JPanel donjiPanel = new JPanel();
		donjiPanel.setLayout(new GridBagLayout());
			
		JTable tabela = new JTable(podaci, kolone);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.getSelectionModel().addSelectionInterval(0, 0);
		skroluj = new JScrollPane(tabela);
		//tabela.setPreferredSize(new Dimension(800, 18 * (tabela.getRowCount() + 1)));
		//skroluj.setPreferredSize(new Dimension(800, 18 * (tabela.getRowCount() + 1)));
		skroluj.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

		//tabela.setMaximumSize(new Dimension(800, 500));
		//skroluj.setMaximumSize(new Dimension(800, 500));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.insets = new Insets(2, 1, 2, 1);
		gbc.gridwidth = 4;
		gbc.gridheight =1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx = 800;
		gbc.ipady = 100;
		gornjiPanel.add(skroluj, gbc);
		
		rezervisiTuru = new JButton("Rezervisi");
		gbc.gridwidth = 1;
		gbc.gridheight =1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbc.anchor = GridBagConstraints.EAST;
		gornjiPanel.add(rezervisiTuru, gbc);
		
		oceniTuru = new JButton("Oceni");
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gornjiPanel.add(oceniTuru, gbc);
		this.add(gornjiPanel);
		//---------------------------------------
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(2, 1, 2, 1);
		gbc.gridwidth = 2;
		gbc.gridheight =2;
		gbc.weightx =0.5;
		gbc.weighty =0.5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		gbc1.anchor = GridBagConstraints.WEST;
		donjiPanel.add(lpocetniTermin, gbc1);
		
		gbc1.gridx = 2;
		gbc1.gridy = 0;
		gbc1.anchor = GridBagConstraints.WEST;
		donjiPanel.add(tfpocetniTermin, gbc1);
		
		gbc1.gridx = 0;
		gbc1.gridy = 2;
		gbc1.anchor = GridBagConstraints.WEST;
		donjiPanel.add(lkrajnjiTermin, gbc1);
		
		gbc1.gridx = 2;
		gbc1.gridy = 2;
		gbc1.anchor = GridBagConstraints.WEST;
		donjiPanel.add(tfkrajnjiTermin, gbc1);
		
		gbc1.gridx = 0;
		gbc1.gridy = 4;
		gbc1.anchor = GridBagConstraints.WEST;
		donjiPanel.add(lminimalnaOcena, gbc1);
		
		gbc1.gridx = 2;
		gbc1.gridy = 4;
		gbc1.anchor = GridBagConstraints.WEST;
		donjiPanel.add(tfminimalnaOcena, gbc1);
		
		gbc1.gridx = 0;
		gbc1.gridy = 6;
		gbc1.anchor = GridBagConstraints.WEST;
		donjiPanel.add(lmaksimalnaOcena, gbc1);
		
		gbc1.gridx = 2;
		gbc1.gridy = 6;
		gbc1.anchor = GridBagConstraints.WEST;
		donjiPanel.add(tfmaksimalnaOcena, gbc1);
		
		gbc1.gridx = 0;
		gbc1.gridy = 8;
		gbc1.anchor = GridBagConstraints.WEST;
		donjiPanel.add(lVodic, gbc1);
		
		gbc1.gridx = 2;
		gbc1.gridy = 8;
		gbc1.anchor = GridBagConstraints.WEST;
		donjiPanel.add(tfVodic, gbc1);
		
		gbc1.gridx = 0;
		gbc1.gridy = 10;
		gbc1.anchor = GridBagConstraints.WEST;
		donjiPanel.add(lmesto, gbc1);
		
		gbc1.gridx = 2;
		gbc1.gridy = 10;
		gbc1.anchor = GridBagConstraints.WEST;
		donjiPanel.add(tfmesto, gbc1);
		
		gbc1.gridx = 0;
		gbc1.gridy = 12;
		gbc1.anchor = GridBagConstraints.WEST;
		donjiPanel.add(lopisTure, gbc1);
		
		gbc1.gridx = 2;
		gbc1.gridy = 12;
		gbc1.anchor = GridBagConstraints.WEST;
		donjiPanel.add(tfopisTure, gbc1);
		
		gbc1.gridx = 4;
		gbc1.gridy = 12;
		gbc1.anchor = GridBagConstraints.EAST;
		donjiPanel.add(bprikaziRezultate, gbc1);
		//----------------------------------------
		this.add(donjiPanel);
		
		rezervisiTuru.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		oceniTuru.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				
			}
		});
		
		
	}
}
