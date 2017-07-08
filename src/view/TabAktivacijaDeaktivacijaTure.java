package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import controller.Aplikacija;
import model.Korisnik;
import model.Tura;
import model.Vodic;

public class TabAktivacijaDeaktivacijaTure extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	JScrollPane skroluj;
	JButton aktivirajTuru;
	JButton deaktivirajTuru;
	
	public TabAktivacijaDeaktivacijaTure(Vodic v){	
		
		Vector<String> kolone = new Vector<String>();
		kolone.add("id ture");
		kolone.add("minimalni broj mesta");
		kolone.add("pocetak ture");
		kolone.add("zavrsetak ture");
		
		ArrayList<Tura> tureKorisnika = v.getTure();
		
		Vector<Vector<String>> podaci = new Vector<Vector<String>>();
		
		for (int i = 0;i<tureKorisnika.size();i++){
			for (int termini = 0; termini < tureKorisnika.get(i).getTermini().size(); termini++) {
				Vector<String> redTabele = new Vector<String>();
				redTabele.add(tureKorisnika.get(i).getIdTure());
				redTabele.add(""+tureKorisnika.get(i).getMinBrojMesta());
				redTabele.add(""+tureKorisnika.get(i).getTermini().get(termini).getPocetakTure());
				redTabele.add(""+tureKorisnika.get(i).getTermini().get(termini).getKrajTure());
				podaci.add(redTabele);
			}
		}
		this.setLayout(new GridLayout(2,0));
		
		JLabel gornjiPanel = new JLabel();
		gornjiPanel.setLayout(new GridBagLayout());
			
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
		
		aktivirajTuru = new JButton("Aktiviraj");
		gbc.gridwidth = 1;
		gbc.gridheight =1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbc.anchor = GridBagConstraints.EAST;
		gornjiPanel.add(aktivirajTuru, gbc);
		
		deaktivirajTuru = new JButton("Deaktiviraj");
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gornjiPanel.add(deaktivirajTuru, gbc);
		
		this.add(gornjiPanel);
		/*odaberi_turu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String idTure = (String) tabela.getModel().getValueAt(tabela.getSelectedRow(), 0);
				
				for (int i = 0;i<ture.size();i++){
					if (ture.get(i).getIdTure().equals(idTure.trim())){
						TuraProzor tp = new TuraProzor(ture.get(i), Aplikacija.trenutnoAktivan);
						tp.show();
						break;
					}
				}
			}
		});
		
		deselektuj_ture.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tabela.getSelectionModel().clearSelection();
				
			}
		});*/
		
		
	}

}
