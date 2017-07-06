package view;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Korisnik;
import model.Tura;
import model.Vodic;

public class TuraProzor extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Tura tura;
	Korisnik ulogovaniKorisnik;
	
	private void podesiVelicinu(){
		Dimension velicinaEkrana = Toolkit.getDefaultToolkit().getScreenSize();
		int sirina = (int)velicinaEkrana.getWidth();
		int visina = (int)velicinaEkrana.getHeight();
		this.setSize(sirina/2, visina/2);
	}
	
	
	
	private void podesiInformacije(){
		JLabel ocenaLabela = new JLabel("\tOcena: "+this.tura.getOcena());
		ocenaLabela.setFont(new Font("Serif", Font.BOLD, 24));
		String vodiciImena = "";
		for(Vodic v:this.tura.getVodici()){
			vodiciImena += v+", ";
		}
		JLabel vodicLabela = new JLabel("\tVodici: "+vodiciImena);
		vodicLabela.setFont(new Font("Serif", Font.BOLD, 24));
		JPanel panel = new JPanel();
		BoxLayout form = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(form);
		panel.add(ocenaLabela);
		panel.add(vodicLabela);
		this.add(panel);
	}
	
	private void podesiKomentare(){
		KomPanel kompanel = new KomPanel(this.tura,this.ulogovaniKorisnik);
			this.add(kompanel);
		}
	
	
	private void podesiOpisTure(){
		JPanel panel = new JPanel();
		BoxLayout form = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(form);
		JLabel lab = new JLabel("Opis ture\n");
		lab.setFont(new Font("Serif", Font.BOLD, 24));
		panel.add(lab);
		panel.add(new JLabel("<html><p>"+this.tura.getOpis()+"</p></html>"));
		this.add(panel);
	}
	
	private void podesiTermine(){
		TerminIzgled terminIzgled = new TerminIzgled(ulogovaniKorisnik,tura.getTermini());
		this.add(terminIzgled);
	}
	
	private void podesiMesta(){
		MestoIzgled mi = new MestoIzgled(tura.getGradovi());
		this.add(mi);
	}
	

	public TuraProzor(Tura tura,Korisnik ulogovaniKorisnik){
		this.tura = tura;
		this.ulogovaniKorisnik = ulogovaniKorisnik;
		this.setTitle(tura.getIdTure());
		podesiVelicinu();
		this.setLayout(new GridLayout(2,2));

		podesiOpisTure();
		podesiInformacije();
		podesiKomentare();
		podesiTermine();
		podesiMesta();
	}
	
	
}
