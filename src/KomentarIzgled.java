import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class KomentarIzgled extends JPanel {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	Komentar komentar;
	
	private void podesiIzgledKomentara(){
		this.setLayout(new BorderLayout());
		SimpleDateFormat smdf = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
		JPanel gornji = new JPanel();
		gornji.setLayout(new GridLayout(1,2));
		JLabel autorKomentara = new JLabel(komentar.getAutor().getKorisnickoIme());
		autorKomentara.setFont(new Font("Serif", Font.ITALIC, 18));
		gornji.add(autorKomentara);
		gornji.add(new JLabel(smdf.format(komentar.getDatumPostavljanja())));
		this.add(gornji,BorderLayout.PAGE_START);
		JLabel sadrzaj = new JLabel("<html><p>"+this.komentar.getSadrzina()+"</p></html>");
		this.add(sadrzaj, BorderLayout.CENTER);
		this.add(new JLabel("	"), BorderLayout.PAGE_END);
	}
	
	
	KomentarIzgled(Komentar komentar){
		this.komentar = komentar;
		podesiIzgledKomentara();
		
	}
	
	
}
