package view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Komentar;
import model.Komentari;
import model.Korisnik;

public class KomPanel extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private Komentari komentari;
	private Korisnik ulogovaniKorisnik;
	private JButton dodajKomentarDugme;
	private JPanel panel;



	private JLabel nemaKomentaraLabela;
	
	
	private void pokreniDodajKomentarDialog(){
		DodajKomDialog  komDialog = new DodajKomDialog(this.komentari,this.ulogovaniKorisnik);
		komDialog.setVisible(true);
	}
	
	
	KomPanel(ArrayList<Komentar> komentari2,Korisnik ulogovaniKorisnik){
		this.komentari = new Komentari(komentari2,ulogovaniKorisnik);
		this.komentari.addObserver(this);
		this.ulogovaniKorisnik = ulogovaniKorisnik;
		nemaKomentaraLabela = new JLabel("Nema komentara!");
		
		BoxLayout komform = new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setLayout(komform);
		JLabel komLabela = new JLabel("Komentari");
		komLabela.setFont(new Font("Serif", Font.BOLD, 24));
		
		if(this.ulogovaniKorisnik !=null){
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
		BoxLayout form = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(form);
		JScrollPane jscroll = new JScrollPane(panel);
		if(this.komentari.komentari.size()==0 ||this.komentari.komentari == null){
			panel.add(nemaKomentaraLabela);
		}
		else{
			for(Komentar kom:this.komentari.komentari){
				panel.add(new KomentarIzgled(kom));
			}
			
	}
		jscroll.setMinimumSize(new Dimension(this.getWidth()/2,this.getHeight()/4));
		this.add(jscroll);
		
		
		
	}


	@Override
	public void update(Observable arg0, Object arg1){
		ArrayList<Komentar> lista = ((Komentari)arg0).komentari;
		Komentar poslednji = lista.get(lista.size()-1);
		panel.remove(nemaKomentaraLabela);
		panel.add(new KomentarIzgled(poslednji));
		panel.revalidate();
		panel.repaint();
		
	}
	
}
	
	
