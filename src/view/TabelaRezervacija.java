package view;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Rezervacija;

public class TabelaRezervacija extends JTable {
	
	private ArrayList<Rezervacija> rezervacije;
	private Vector<String> zaglavlje;
	private Vector<Vector<String>> teloTabele;
	public TabelaRezervacija(ArrayList<Rezervacija> rezervacije) {
		super();
		this.rezervacije = rezervacije;
		this.podesiTabelu();
		this.podesiModel();
		this.azurirajTabelu();
		
	}
	
	private void podesiModel() {
		TableModel modelTabele = new DefaultTableModel(teloTabele,zaglavlje);
		this.setModel(modelTabele);
		
	}

	public void azurirajTabelu() {
		teloTabele.clear();
		Vector<String> trenutniRed;
		for(Rezervacija r:rezervacije){
			trenutniRed = new Vector<String>();
			teloTabele.addElement(trenutniRed);
			trenutniRed.addElement(r.getTermin().getPocetakTure());
			trenutniRed.addElement(r.getTermin().getKrajTure());
			String jePotvrdjena = "ne";
			String jePlacena = "ne";
			if(r.isPotvrdjena()){
				jePotvrdjena = "da";
			}
			if(r.isPlacena()){
				jePlacena = "da";
			}
			trenutniRed.addElement(jePotvrdjena);
			trenutniRed.addElement(jePlacena);
		}
		
		((AbstractTableModel) this.getModel()).fireTableDataChanged();
		
	}

	private void podesiTabelu() {
		zaglavlje = new Vector<String>();
		zaglavlje.addElement("Pocetak");
		zaglavlje.addElement("Zavrsetak");
		zaglavlje.addElement("Potvrdjena");
		zaglavlje.addElement("Placena");
		teloTabele = new Vector<Vector<String>>();
		this.setDefaultEditor(Object.class,null);
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
