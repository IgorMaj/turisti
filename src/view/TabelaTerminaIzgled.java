package view;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.Termin;

public class TabelaTerminaIzgled extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Termin> termini;
	private Vector<String> zaglavlje;
	private Vector<Vector<String>> teloTabele;
	
	
	
	TabelaTerminaIzgled(ArrayList<Termin> termini){
		super();
		this.termini = termini;
		zaglavlje = new Vector<String>();
		teloTabele = new Vector<Vector<String>>();
		podesiTabelu(zaglavlje,teloTabele);
		this.setDefaultEditor(Object.class,null);
	}
	
	private void podesiTabelu(Vector<String> zaglavlje, Vector<Vector<String>> teloTabele) {
		zaglavlje.addElement("Pocetak");
		zaglavlje.addElement("Zavrsetak");
		zaglavlje.addElement("Broj slobodnih mesta");
	
		Vector<String> trenutniRed;
		for(Termin t:this.termini){
			trenutniRed = new Vector<String>();
			teloTabele.addElement(trenutniRed);
			trenutniRed.addElement(t.getPocetakTure());
			trenutniRed.addElement(t.getKrajTure());
			trenutniRed.addElement(t.getBrojSlobodnihMesta()+"");
		}
		DefaultTableModel modelTabele = new DefaultTableModel(teloTabele,zaglavlje);
		this.setModel(modelTabele);
		
	}

	public void azurirajPrikazSlobodnihMesta(int trenutniIndex) {
		int trenutnaVrednost = Integer.parseInt(teloTabele.get(trenutniIndex).get(2));
		trenutnaVrednost -= 1;
		teloTabele.get(trenutniIndex).set(2, trenutnaVrednost+"");
		((AbstractTableModel) this.getModel()).fireTableDataChanged();
	}
	
}
