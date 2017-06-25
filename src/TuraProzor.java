import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TuraProzor extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Tura tura;
	
	private void podesiVelicinu(){
		Dimension velicinaEkrana = Toolkit.getDefaultToolkit().getScreenSize();
		int sirina = (int)velicinaEkrana.getWidth();
		int visina = (int)velicinaEkrana.getHeight();
		this.setSize(sirina/2, visina/2);
	}
	
	//samo za test, uklanjamo ga posle
	private void omoguciIzlaz(){
		this.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });
	}
	
	private void podesiInformacije(){
		JLabel cenaLabela = new JLabel("\tCena: "+this.tura.cena);
		cenaLabela.setFont(new Font("Serif", Font.BOLD, 24));
		JLabel ocenaLabela = new JLabel("\tOcena: "+this.tura.ocena);
		ocenaLabela.setFont(new Font("Serif", Font.BOLD, 24));
		JLabel vodicLabela = new JLabel("\tVodic: "+this.tura.vodic.getIme());
		vodicLabela.setFont(new Font("Serif", Font.BOLD, 24));
		JPanel panel = new JPanel();
		BoxLayout form = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(form);
		panel.add(cenaLabela);
		panel.add(ocenaLabela);
		panel.add(vodicLabela);
		this.add(panel);
	}
	
	private void podesiKomentare(){
		JPanel kompanel = new JPanel();
		BoxLayout komform = new BoxLayout(kompanel,BoxLayout.Y_AXIS);
		kompanel.setLayout(komform);
		JLabel komLabela = new JLabel("Komentari");
		komLabela.setFont(new Font("Serif", Font.BOLD, 24));
		kompanel.add(komLabela);
		
		JPanel panel = new JPanel();
		BoxLayout form = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(form);
		JScrollPane jscroll = new JScrollPane(panel);
		if(this.tura.komentari.size()==0){
			panel.add(new JLabel("Nema komentara!"));
		}
		else{
			for(Komentar kom:this.tura.komentari){
				panel.add(new KomentarIzgled(kom));
			}
			kompanel.add(jscroll);
			this.add(kompanel);
		}
	}
	
	private void podesiOpisTure(){
		JPanel panel = new JPanel();
		BoxLayout form = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(form);
		JLabel lab = new JLabel("Opis ture\n");
		lab.setFont(new Font("Serif", Font.BOLD, 24));
		panel.add(lab);
		panel.add(new JLabel("<html><p>"+this.tura.opisTure+"</p></html>"));
		this.add(panel);
	}
	
	private void podesiTermine(){
		JPanel terminPanel = new JPanel();
		BoxLayout komform = new BoxLayout(terminPanel,BoxLayout.Y_AXIS);
		terminPanel.setLayout(komform);
		JLabel terminLabela = new JLabel("Termini");
		terminLabela.setFont(new Font("Serif", Font.BOLD, 24));
		terminPanel.add(terminLabela);
		Vector<String> zaglavlje = new Vector<String>();
		Vector<Vector<String>> teloTabele = new Vector<Vector<String>>();
		podesiTabelu(zaglavlje,teloTabele);
		JTable tabela = new JTable(teloTabele,zaglavlje);
		tabela.setCellSelectionEnabled(false);
		JScrollPane jscroll = new JScrollPane(tabela);
		terminPanel.add(jscroll);
		this.add(terminPanel);
	}
	
	private void podesiTabelu(Vector<String> zaglavlje, Vector<Vector<String>> teloTabele) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		zaglavlje.addElement("Pocetak");
		zaglavlje.addElement("Zavrsetak");
		zaglavlje.addElement("Broj slobodnih mesta");
	
		Vector<String> trenutniRed;
		for(Termin t:this.tura.termini){
			trenutniRed = new Vector<String>();
			teloTabele.addElement(trenutniRed);
			trenutniRed.addElement(sdf.format(t.getDatumPocetka()));
			trenutniRed.addElement(sdf.format(t.getDatumZavrsetka()));
			trenutniRed.addElement(t.getBrojSlobodnihMesta()+"");
		}
		
	}

	TuraProzor(Tura tura){
		this.tura = tura;
		this.setTitle(tura.naslovTure);
		podesiVelicinu();
		omoguciIzlaz();
		this.setLayout(new GridLayout(2,2));
		podesiOpisTure();
		podesiInformacije();
		podesiKomentare();
		podesiTermine();
	}
	
	
	
}
