package view;

import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import controller.Aplikacija;
import model.Tura;

public class ProzorPrikazTura extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	JScrollPane skrol;

	
	@SuppressWarnings("null")
	public ProzorPrikazTura(ArrayList<Tura> ture){
		super();
		setSize(550,550);
		setTitle("Prikaz tura");
		
		
		JPanel p1 = new JPanel(new GridBagLayout());
		p1.setSize(300,300);
		
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
			objekat.add(""+ture.get(i).getKreatorTure());
			podaci.add(objekat);
		}
			
		JTable tabela = new JTable(podaci, imena_kolona);
		skrol = new JScrollPane(tabela);
		this.add(skrol);
		this.setVisible(true);
		
		tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
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
				
			}
		});
		
		
	}
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		Aplikacija.ucitavanjeTura();
		new ProzorPrikazTura(Aplikacija.ture);
	}

}