package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Mesto;

public class MestoIzgled extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Mesto> mesta;
	
	
	public MestoIzgled(ArrayList<Mesto> mesta){
		super();
		this.mesta = mesta;
		
		BoxLayout komform = new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setLayout(komform);
		JLabel mestaLabela = new JLabel("Mesta");
		mestaLabela.setFont(new Font("Serif", Font.BOLD, 24));
		
		JTable tabela = new JTable();
		
		Vector<String> imena_kolona = new Vector<>();
		imena_kolona.add("naziv");
		imena_kolona.add("ptt");
		
		
		Vector<Vector<String>> podaci = new Vector<Vector<String>>();
		for (int i = 0;i<this.mesta.size();i++){
			Vector<String> objekat = new Vector<String>();
			objekat.add(this.mesta.get(i).getNaziv());
			objekat.add(""+this.mesta.get(i).getPtt());
			podaci.add(objekat);
		}
		
		
		GridLayout red = new GridLayout(1,2);
		JPanel gornjiPanel = new JPanel();
		gornjiPanel.setLayout(red);
		gornjiPanel.add(mestaLabela);
		this.add(gornjiPanel);
		
		
		
		tabela = new JTable(podaci, imena_kolona);
		JScrollPane skrol = new JScrollPane(tabela);
		this.add(skrol,new BorderLayout().SOUTH);
		
	
	}
	
	
}