package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import controller.Aplikacija;
import model.Tura;

public class ProzorPrikazTura extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	JScrollPane skrol;
	JButton odaberi_turu;
	JButton deselektuj_ture;
	
	@SuppressWarnings("null")
	public ProzorPrikazTura(ArrayList<Tura> ture){
		super();
		setSize(700,700);
		
	
		
		Vector<String> imena_kolona = new Vector<String>();
		imena_kolona.add("id ture");
		imena_kolona.add("ocena");
		imena_kolona.add("minimalan broj mesta");
		imena_kolona.add("kreator ture");
		
		Vector<Vector<String>> podaci = new Vector<Vector<String>>();
		for (int i = 0;i<ture.size();i++){
			Vector<String> objekat = new Vector<String>();
			objekat.add(ture.get(i).getIdTure());
			objekat.add(""+ture.get(i).getOcena());
			objekat.add(""+ture.get(i).getMinBrojMesta());
			objekat.add(""+ture.get(i).getKreatorTure().getKorIme());
			podaci.add(objekat);
		}
			
		JTable tabela = new JTable(podaci, imena_kolona);
		skrol = new JScrollPane(tabela);
		skrol.setSize(650, 650);
		this.add(skrol);
			
		
		odaberi_turu = new JButton("Odaberi turu");
		this.add(odaberi_turu);
		
		deselektuj_ture = new JButton("deselektuj ture");
		this.add(deselektuj_ture);
		
		this.setVisible(true);
		
		/*tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String idTure = (String) tabela.getModel().getValueAt(tabela.getSelectedRow(), 0);
				
				for (int i = 0;i<ture.size();i++){
					if (ture.get(i).getIdTure().equals(idTure.trim())){
						TuraProzor tp = new TuraProzor(ture.get(i), Aplikacija.trenutnoAktivan);
						tp.show();
						break;
					}
				}
				tabela.getSelectionModel().clearSelection();
				
			}
		});*/
		
		odaberi_turu.addActionListener(new ActionListener() {
			
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
		});
	}
}