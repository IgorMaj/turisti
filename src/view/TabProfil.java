package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.Korisnik;

public class TabProfil extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TabProfil(Korisnik k) throws IOException{
		
		this.setLayout(new GridLayout(2,0));
	
		BufferedImage profilnaSlika = ImageIO.read(new File("images/User-blue-icon.png"));
		JLabel lSlika = new JLabel(new ImageIcon(profilnaSlika));
	
		JPanel licniPodaciPanel = new JPanel();
		Border okvirLicniPodaciBoja = BorderFactory.createLineBorder(Color.black);
		TitledBorder okvirLicniPodaci = BorderFactory.createTitledBorder(okvirLicniPodaciBoja, "Licni podaci");
	
		licniPodaciPanel.setBorder(okvirLicniPodaci);
		licniPodaciPanel.setLayout(new GridBagLayout());
	
		this.add(licniPodaciPanel);
	
		GridBagConstraints gbc = new GridBagConstraints();
	
		JLabel lIme = new JLabel("Ime:");
		lIme.setFont(new Font(lIme.getFont().getFontName(), Font.ITALIC, 18));
		
		JLabel lPrezime = new JLabel("Prezime:");
		lPrezime.setFont(new Font(lIme.getFont().getFontName(), Font.ITALIC, 18));
		
		JLabel lTelefon = new JLabel("Telefon:");
		lTelefon.setFont(new Font(lIme.getFont().getFontName(), Font.ITALIC, 18));
		
		JLabel lKorisnickoIme = new JLabel("Korisnicko ime:");
		lKorisnickoIme.setFont(new Font(lIme.getFont().getFontName(), Font.ITALIC, 18));
	
		JLabel lImePrikaz = new JLabel(k.getIme());
		lImePrikaz.setFont(new Font(lIme.getFont().getFontName(), Font.PLAIN, 18));
		
		JLabel lPrezimePrikaz = new JLabel(k.getPrezime());
		lPrezimePrikaz.setFont(new Font(lIme.getFont().getFontName(), Font.PLAIN, 18));
		
		JLabel lTelefonPrikaz = new JLabel(k.getTelefon());
		lTelefonPrikaz.setFont(new Font(lIme.getFont().getFontName(), Font.PLAIN, 18));
		
		JLabel lKorisnickoImePrikaz = new JLabel(k.getKorIme());
		lKorisnickoImePrikaz.setFont(new Font(lIme.getFont().getFontName(), Font.PLAIN, 18));
	
		JButton bIzmeniSliku = new JButton("Odaberi sliku");
		JButton bIzmeniPodatke = new JButton("Izmeni");
	
	
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.insets = new Insets(2, 1, 2, 1);
		gbc.anchor = GridBagConstraints.CENTER;
	
		gbc.gridx = 0;
		gbc.gridy = 0;
		licniPodaciPanel.add(lSlika, gbc);
	
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		licniPodaciPanel.add(bIzmeniSliku, gbc);
	
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		licniPodaciPanel.add(lIme, gbc);
	
		gbc.gridx = 2;
		gbc.gridy = 2;
		licniPodaciPanel.add(lImePrikaz, gbc);
	
		gbc.gridx = 0;
		gbc.gridy = 4;
		licniPodaciPanel.add(lPrezime, gbc);
	
		gbc.gridx = 2;
		gbc.gridy = 4;
		licniPodaciPanel.add(lPrezimePrikaz, gbc);
	
		gbc.gridx = 0;
		gbc.gridy = 6;
		licniPodaciPanel.add(lTelefon, gbc);
	
		gbc.gridx = 2;
		gbc.gridy = 6;
		licniPodaciPanel.add(lTelefonPrikaz, gbc);
	
		gbc.gridx = 0;
		gbc.gridy = 8;
		licniPodaciPanel.add(lKorisnickoIme, gbc);
	
		gbc.gridx = 2;
		gbc.gridy = 8;
		licniPodaciPanel.add(lKorisnickoImePrikaz, gbc);
	
		gbc.gridx = 4;
		gbc.gridy = 10;
		licniPodaciPanel.add(bIzmeniPodatke, gbc);
	}
}
