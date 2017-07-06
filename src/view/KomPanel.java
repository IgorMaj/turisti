package view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Komentar;
import model.Korisnik;
import model.Tura;

public class KomPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private Tura tura;
	private Korisnik ulogovaniKorisnik;
	private JButton dodajKomentarDugme;
	private JPanel panel;



	private JLabel nemaKomentaraLabela;
	
	
	private void pokreniDodajKomentarDialog(){
		DodajKomDialog  komDialog = new DodajKomDialog(this);
		komDialog.setVisible(true);
		
	}
	
	
	public void azurirajPanel() {
		panel.removeAll();
		if(this.getTura().getKomentari().size()==0 ||this.getTura().getKomentari() == null){
			panel.add(nemaKomentaraLabela);
		}
		else{
			for(Komentar kom:this.getTura().getKomentari()){
				panel.add(new KomentarIzgled(kom));
			}
			
	}
		panel.setVisible(false);
		panel.repaint();
		panel.setVisible(true);
	}


	KomPanel(Tura tura,Korisnik ulogovaniKorisnik){
		this.tura = tura;
		this.ulogovaniKorisnik = ulogovaniKorisnik;
		nemaKomentaraLabela = new JLabel("Nema komentara!");
		
		BoxLayout komform = new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setLayout(komform);
		JLabel komLabela = new JLabel("Komentari");
		komLabela.setFont(new Font("Serif", Font.BOLD, 24));
		
		if(this.getUlogovaniKorisnik() !=null){
			this.dodajKomentarDugme = new JButton("Dodaj komentar");
			FlowLayout pomocniGornji = new FlowLayout(FlowLayout.LEFT,20,0);
			JPanel pomocniGornjiPanel = new JPanel();
			pomocniGornjiPanel.setLayout(pomocniGornji);
			pomocniGornjiPanel.add(komLabela);
			pomocniGornjiPanel.add(this.dodajKomentarDugme);
			this.add(pomocniGornjiPanel);
			
			
			this.dodajKomentarDugme.addActionListener(new ActionListener() { 
			    public void actionPerformed(ActionEvent e) { 
			       pokreniDodajKomentarDialog();
			    }
			});
			
		}
		else{
			this.add(komLabela);
		}
		
		this.panel = new JPanel();
		azurirajPanel();
		BoxLayout form = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(form);
		JScrollPane jscroll = new JScrollPane(panel);
		jscroll.setMinimumSize(new Dimension(this.getWidth()/2,this.getHeight()/4));
		this.add(jscroll);
		
		
		
	}


	public Tura getTura() {
		return tura;
	}




	public Korisnik getUlogovaniKorisnik() {
		return ulogovaniKorisnik;
	}


	


	
	
}
	
	
