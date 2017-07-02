package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Korisnik;
import model.Termin;

public class TerminIzgled extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Korisnik ulogovaniKorisnik;
	private ArrayList<Termin> termini;

	private JButton odaberiTerminDugme;
	
	TerminIzgled(Korisnik ulogovaniKorisnik,ArrayList<Termin>termini){
		super();
		this.ulogovaniKorisnik = ulogovaniKorisnik;
		this.termini = termini;
		
		
		BoxLayout komform = new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setLayout(komform);
		JLabel terminLabela = new JLabel("Termini");
		terminLabela.setFont(new Font("Serif", Font.BOLD, 24));
		odaberiTerminDugme = new JButton("Odaberi termin");
		TabelaTerminaIzgled tabela = new TabelaTerminaIzgled(this.termini);
		
		odaberiTerminDugme.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int trenutniIndex = tabela.getSelectedRow();
				if(trenutniIndex == -1){
					JOptionPane.showMessageDialog(TerminIzgled.this, "Nije odabran termin!");
					return;
				}
				if(termini.get(trenutniIndex).getBrojSlobodnihMesta()==0){
					JOptionPane.showMessageDialog(TerminIzgled.this, "Nema slobodnih mesta za taj termin!");
					return;
				}
				ulogovaniKorisnik.rezervisiTuru(termini.get(trenutniIndex));
				tabela.azurirajPrikazSlobodnihMesta(trenutniIndex);
				JOptionPane.showMessageDialog(TerminIzgled.this, "Termin rezervisan!");
				
			}});
		
		GridLayout red = new GridLayout(1,2);
		JPanel gornjiPanel = new JPanel();
		gornjiPanel.setLayout(red);
		gornjiPanel.add(terminLabela);
		
		if(this.ulogovaniKorisnik !=null){
			gornjiPanel.add(odaberiTerminDugme);
		}
		this.add(gornjiPanel);
		
		
		JScrollPane jscroll = new JScrollPane(tabela);
		this.add(jscroll);
		
	}
	
	

}
