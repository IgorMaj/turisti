package view;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.Korisnik;


public class TuristaUlogovanProzor extends JFrame {

	public TuristaUlogovanProzor(Korisnik ulogovani) throws IOException {
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JTabbedPane jtp = new JTabbedPane();
		JToolBar jtb = new JToolBar();
		jtb.setPreferredSize(new Dimension(800, 40));
		
		JButton bIzlogujSe = new JButton("Odjava");
		jtb.setLayout(new BorderLayout());
		jtb.add(bIzlogujSe, BorderLayout.EAST);
		
		TabProfil tp = new TabProfil(ulogovani);
		jtp.addTab("Profil", tp);
		
		/*String status;
		if(daLiJeVodic){
			status = "Status: vodic";
		}
		else{
			status = "Status: turista";
		}
		
		JLabel statusKorisnika = new JLabel(status);
		statusKorisnika.setFont(new Font(statusKorisnika.getFont().getFontName(), Font.PLAIN, 16));
		jtb.add(statusKorisnika, BorderLayout.WEST);*/
		
		
		
		/*JPanel rezervisaneTurePanel = new JPanel();
		Border okvirRezervisaneTureBoja = BorderFactory.createLineBorder(Color.black);
		TitledBorder okvirRezervisaneTure = BorderFactory.createTitledBorder(okvirRezervisaneTureBoja, "Rezervisane ture");
		rezervisaneTurePanel.setBorder(okvirRezervisaneTure);
		rezervisaneTurePanel.setLayout(new GridLayout(2,0));
		tab1Panel.add(rezervisaneTurePanel);
		
		String[] tKoloneRezervisano = {"ID TURE", "OPIS", "TERMIN", "PLACENA"};
		Object[][] podaciRezervisano = {
			    {"NS1", "Tura po Novom Sadu", "24.08.2017", "jeste"},
			    {"BG2", "Tura po Beogradu", "24.08.2017", "nije"}
			};
		
		JTable tPrikazRezervisanihTura = new JTable(podaciRezervisano, tKoloneRezervisano);
		Dimension dPrikazRezervisanihTura = tPrikazRezervisanihTura.getPreferredSize();
		JScrollPane spPrikazRezervisanihTura = new JScrollPane(tPrikazRezervisanihTura);
		spPrikazRezervisanihTura.setPreferredSize(new Dimension(dPrikazRezervisanihTura.width,
				tPrikazRezervisanihTura.getRowHeight()*4));
		rezervisaneTurePanel.add(spPrikazRezervisanihTura);
		
		JPanel panelDugmiciRTure = new JPanel();
		panelDugmiciRTure.setLayout(new GridBagLayout());
		GridBagConstraints gbcDugmiciRTure = new GridBagConstraints();
		gbcDugmiciRTure.gridwidth = 2;
		gbcDugmiciRTure.gridheight = 2;
		gbcDugmiciRTure.weightx = 0.5;
		gbcDugmiciRTure.weighty = 0.5;
		gbcDugmiciRTure.insets = new Insets(2, 1, 2, 1);
		gbcDugmiciRTure.anchor = GridBagConstraints.CENTER;
		
		gbcDugmiciRTure.gridx = 0;
		gbcDugmiciRTure.gridy = 0;
		JButton bOtkaziRezervaciju = new JButton("Otkazi rezervaciju");
		panelDugmiciRTure.add(bOtkaziRezervaciju, gbcDugmiciRTure);
		
		gbcDugmiciRTure.gridx = 2;
		gbcDugmiciRTure.gridy = 0;
		JButton bPlatiTuru = new JButton("Plati turu");
		panelDugmiciRTure.add(bPlatiTuru, gbcDugmiciRTure);
		
		rezervisaneTurePanel.add(panelDugmiciRTure);
		
		
		tab2Panel.setLayout(new GridLayout(3,0));
		
		String[] tKolone = {"ID TURE", "OPIS", "OCENA", "BROJ MESTA"};
		Object[][] podaci = {
			    {"NS1", "Tura po Novom Sadu", "5", "30"},
			    {"BG2", "Tura po Beogradu", "4", "20"},
			    {"P3", "Tura po Petrovaradinu", "4", "15"},
			    {"D4", "Tura po Dunavu", "5", "11"}
			};
		
		JTable tPrikazTura = new JTable(podaci, tKolone);
		Dimension dPrikazTura = tPrikazTura.getPreferredSize();
		JScrollPane spPrikazTura = new JScrollPane(tPrikazTura);
		spPrikazTura.setPreferredSize(new Dimension(dPrikazTura.width,tPrikazTura.getRowHeight()*4));
		tab2Panel.add(spPrikazTura);
		
		JPanel pretragaPanel = new JPanel();
		Border okvirPretrageBoja = BorderFactory.createLineBorder(Color.black);
		TitledBorder okvirPretrage = BorderFactory.createTitledBorder(okvirPretrageBoja, "Pretraga");
		pretragaPanel.setBorder(okvirPretrage);
		pretragaPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		
		JTextField tfMinOcena = new JTextField(10);
		JTextField tfMaksOcena = new JTextField(10);
		JLabel lMinOcena = new JLabel("Minimalna ocena:");
		JLabel lMaksOcena = new JLabel("Maksimalna ocena:");
		
		JTextField tfMinBrMesta = new JTextField(10);
		JTextField tfMaksBrMesta = new JTextField(10);
		JLabel  lMinBrMesta = new JLabel("Minimalno mesta:");
		JLabel lMaksBrMesta = new JLabel("Maksimalno mesta:");
		
		JTextField tfKljucnaRec = new JTextField(30);
		JLabel  lKljucnaRec = new JLabel("Kljucna rec opisa:");
		JTextField tfSifra = new JTextField(15);
		JLabel  lSifra = new JLabel("Sifra ture:");
		
		JButton bPrikazRez = new JButton("Prikaz rezultata");
		
		gbc1.gridwidth = 2;
		gbc1.gridheight = 2;
		gbc1.weightx = 0.5;
		gbc1.weighty = 0.5;
		gbc1.insets = new Insets(2, 1, 2, 1);
		gbc1.anchor = GridBagConstraints.FIRST_LINE_START;
		
		gbc1.gridx = 0;
		gbc1.gridy = 0;
		pretragaPanel.add(lMinOcena, gbc1);
		
		gbc1.gridx = 2;
		gbc1.gridy = 0;
		pretragaPanel.add(tfMinOcena, gbc1);
		
		gbc1.gridx = 4;
		gbc1.gridy = 0;
		pretragaPanel.add(lMaksOcena, gbc1);
		
		gbc1.gridx = 6;
		gbc1.gridy = 0;
		pretragaPanel.add(tfMaksOcena, gbc1);
		
		gbc1.gridx = 0;
		gbc1.gridy = 2;
		pretragaPanel.add(lMinBrMesta, gbc1);
		
		gbc1.gridx = 2;
		gbc1.gridy = 2;
		pretragaPanel.add(tfMinBrMesta, gbc1);
		
		gbc1.gridx = 4;
		gbc1.gridy = 2;
		pretragaPanel.add(lMaksBrMesta, gbc1);
		
		gbc1.gridx = 6;
		gbc1.gridy = 2;
		pretragaPanel.add(tfMaksBrMesta, gbc1);
		
		gbc1.gridx = 0;
		gbc1.gridy = 4;
		pretragaPanel.add(lKljucnaRec, gbc1);
		
		gbc1.gridx = 2;
		gbc1.gridy = 4;
		pretragaPanel.add(tfKljucnaRec, gbc1);
		
		gbc1.gridx = 0;
		gbc1.gridy = 6;
		pretragaPanel.add(lSifra, gbc1);
		
		gbc1.gridx = 2;
		gbc1.gridy = 6;
		pretragaPanel.add(tfSifra, gbc1);
		
		gbc1.gridx = 4;
		gbc1.gridy = 6;
		pretragaPanel.add(bPrikazRez, gbc1);
		
		tab2Panel.add(pretragaPanel);
		
		JPanel rezervacijaPanel = new JPanel();
		Border okvirRezervacijeBoja = BorderFactory.createLineBorder(Color.black);
		TitledBorder okvirRezervacije = BorderFactory.createTitledBorder(okvirRezervacijeBoja, "Rezervacija");
		rezervacijaPanel.setBorder(okvirRezervacije);
		rezervacijaPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc2 = new GridBagConstraints();
		
		JLabel lSifraRez = new JLabel("Sifra ture:");
		JTextField tfSifraRez = new JTextField(15);
		JLabel lTermini = new JLabel("Dostupni termini:");
		JButton bRezervisi = new JButton("Rezervisi");
		
		String[] datumi = { "01.05.2018", "03.07.2018", "24.08.2017", "13.06.2017", "14.09.2017" };
		JComboBox cbTermini = new JComboBox(datumi);
		
		JTextArea taKomentarisi = new JTextArea(5, 60);
		JScrollPane spKomentarisi = new JScrollPane(taKomentarisi);
		spKomentarisi.setPreferredSize(new Dimension(40, 40));
		
		JButton bKomentarisi = new JButton("Komentarisi turu");
		JButton bKomentari = new JButton("Komentari - prikaz");
		JButton bDetalji = new JButton("Detalji ture");
		
		gbc2.gridwidth = 1;
		gbc2.gridheight = 1;
		gbc2.weightx = 0.5;
		gbc2.weighty = 0.5;
		gbc2.insets = new Insets(2, 1, 2, 1);
		gbc2.anchor = GridBagConstraints.FIRST_LINE_START;
		
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		rezervacijaPanel.add(lSifraRez, gbc2);
		
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		rezervacijaPanel.add(tfSifraRez, gbc2);
		
		gbc2.gridx = 2;
		gbc2.gridy = 0;
		rezervacijaPanel.add(lTermini, gbc2);
		
		gbc2.gridx = 3;
		gbc2.gridy = 0;
		rezervacijaPanel.add(cbTermini, gbc2);
		
		gbc2.gridx = 4;
		gbc2.gridy = 0;
		rezervacijaPanel.add(bRezervisi, gbc2);
		
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		gbc2.gridwidth = 5;
		gbc2.gridheight = 3;
		rezervacijaPanel.add(taKomentarisi, gbc2);
		
		gbc2.gridx = 0;
		gbc2.gridy = 5;
		gbc2.gridwidth = 1;
		gbc2.gridheight = 1;
		gbc2.anchor = GridBagConstraints.CENTER;
		rezervacijaPanel.add(bKomentarisi, gbc2);
		
		gbc2.gridx = 1;
		gbc2.gridy = 5;
		rezervacijaPanel.add(bKomentari, gbc2);
		
		gbc2.gridx = 2;
		gbc2.gridy = 5;
		rezervacijaPanel.add(bDetalji, gbc2);
		
		tab2Panel.add(rezervacijaPanel);
		
		if(daLiJeVodic == true){
			ImageIcon tab3Ikonica = new ImageIcon("images/check-icon.png");
			JPanel tab3Panel = new JPanel();
			jtp.addTab("", tab3Ikonica, tab3Panel, "dodavanje, brisanje i aktiviranje tura");
			
			tab3Panel.setLayout(new GridLayout(2,0));
			
			JLabel lDodavanjeSifre = new JLabel("Sifra ture:");
			JTextField tfDodavanjeSifre = new JTextField(10);
			JLabel lDodavanjeOpisa = new JLabel("Opis ture:");
			JTextField tfDodavanjeOpisa = new JTextField(20);
			JLabel lDodavanjeOcene = new JLabel("Ocena ture:");
			JTextField tfDodavanjeOcene = new JTextField(5);
			JLabel lDodavanjeBrojaMesta = new JLabel("Broj mesta:");
			JTextField tfDodavanjeBrojaMesta = new JTextField(10);
			
			JButton bDodajTuru = new JButton("Dodaj turu");
			
			JPanel panelDodavanjeTure = new JPanel();
			Border okvirDodavanjeTureBoja = BorderFactory.createLineBorder(Color.black);
			TitledBorder okvirDodavanjeTure = 
					BorderFactory.createTitledBorder(okvirDodavanjeTureBoja, "Dodavanje ture");
			panelDodavanjeTure.setBorder(okvirDodavanjeTure);
			panelDodavanjeTure.setLayout(new GridBagLayout());
			GridBagConstraints gbc3 = new GridBagConstraints();
			
			gbc3.gridwidth = 2;
			gbc3.gridheight = 2;
			gbc3.weightx = 0.5;
			gbc3.weighty = 0.5;
			gbc3.insets = new Insets(2, 1, 2, 1);
			gbc3.anchor = GridBagConstraints.LINE_START;
			
			gbc3.gridx = 0;
			gbc3.gridy = 0;
			panelDodavanjeTure.add(lDodavanjeSifre, gbc3);
			
			gbc3.gridx = 2;
			gbc3.gridy = 0;
			panelDodavanjeTure.add(tfDodavanjeSifre, gbc3);
			
			gbc3.gridx = 0;
			gbc3.gridy = 2;
			panelDodavanjeTure.add(lDodavanjeOpisa, gbc3);
			
			gbc3.gridx = 2;
			gbc3.gridy = 2;
			panelDodavanjeTure.add(tfDodavanjeOpisa, gbc3);
			
			gbc3.gridx = 0;
			gbc3.gridy = 4;
			panelDodavanjeTure.add(lDodavanjeOcene, gbc3);
			
			gbc3.gridx = 2;
			gbc3.gridy = 4;
			panelDodavanjeTure.add(tfDodavanjeOcene, gbc3);
			
			gbc3.gridx = 0;
			gbc3.gridy = 6;
			panelDodavanjeTure.add(lDodavanjeBrojaMesta, gbc3);
			
			gbc3.gridx = 2;
			gbc3.gridy = 6;
			panelDodavanjeTure.add(tfDodavanjeBrojaMesta, gbc3);
			
			gbc3.gridx = 2;
			gbc3.gridy = 8;
			panelDodavanjeTure.add(bDodajTuru, gbc3);
			
			tab3Panel.add(panelDodavanjeTure);
			
			
			JLabel lSifraTerGrDes = new JLabel("Sifra ture:");
			JTextField tfSifraTerGrDes = new JTextField(10);
			JLabel lDodavanjeTermina = new JLabel("Termin:");
			JTextField tfDodavanjeTermina = new JTextField(10);
			JButton bDodavanjeTermina = new JButton("Dodaj termin");
			JLabel lDodavanjeGrada = new JLabel("Grad:");
			JTextField tfDodavanjeGrada = new JTextField(10);
			JButton bDodavanjeGrada = new JButton("Dodaj grad");
			JLabel lDodavanjeDestinacije = new JLabel("Destinacija:");
			JTextField tfDodavanjeDestinacije = new JTextField(10);
			JButton bDodavanjeDestinacije = new JButton("Dodaj destinaciju");
			
			JButton bObrisiTuru = new JButton("Obrisi turu");
			JButton bAktivirajTuru = new JButton("Aktiviraj turu");
			
			JPanel panelModifikacijaBrisanjeTure = new JPanel();
			Border okvirModifikacijaBrisanjeTureBoja = BorderFactory.createLineBorder(Color.black);
			TitledBorder okvirModifikacijaBrisanjeTure = 
					BorderFactory.createTitledBorder(okvirModifikacijaBrisanjeTureBoja, "Modifikacija i brisanje ture");
			panelModifikacijaBrisanjeTure.setBorder(okvirModifikacijaBrisanjeTure);
			panelModifikacijaBrisanjeTure.setLayout(new GridBagLayout());
			GridBagConstraints gbc4 = new GridBagConstraints();
			
			gbc4.gridwidth = 1;
			gbc4.gridheight = 1;
			gbc4.weightx = 0.5;
			gbc4.weighty = 0.5;
			gbc4.insets = new Insets(2, 1, 2, 1);
			gbc4.anchor = GridBagConstraints.LINE_START;
			
			gbc4.gridx = 0;
			gbc4.gridy = 0;
			panelModifikacijaBrisanjeTure.add(lSifraTerGrDes, gbc4);
			
			gbc4.gridx = 1;
			gbc4.gridy = 0;
			panelModifikacijaBrisanjeTure.add(tfSifraTerGrDes, gbc4);
			
			gbc4.gridx = 0;
			gbc4.gridy = 1;
			panelModifikacijaBrisanjeTure.add(lDodavanjeTermina, gbc4);
			
			gbc4.gridx = 1;
			gbc4.gridy = 1;
			panelModifikacijaBrisanjeTure.add(tfDodavanjeTermina, gbc4);
			
			gbc4.gridx = 2;
			gbc4.gridy = 1;
			panelModifikacijaBrisanjeTure.add(bDodavanjeTermina, gbc4);
			
			gbc4.gridx = 0;
			gbc4.gridy = 2;
			panelModifikacijaBrisanjeTure.add(lDodavanjeGrada, gbc4);
			
			gbc4.gridx = 1;
			gbc4.gridy = 2;
			panelModifikacijaBrisanjeTure.add(tfDodavanjeGrada, gbc4);
			
			gbc4.gridx = 2;
			gbc4.gridy = 2;
			panelModifikacijaBrisanjeTure.add(bDodavanjeGrada, gbc4);
			
			gbc4.gridx = 0;
			gbc4.gridy = 3;
			panelModifikacijaBrisanjeTure.add(lDodavanjeDestinacije, gbc4);
			
			gbc4.gridx = 1;
			gbc4.gridy = 3;
			panelModifikacijaBrisanjeTure.add(tfDodavanjeDestinacije, gbc4);
			
			gbc4.gridx = 2;
			gbc4.gridy = 3;
			panelModifikacijaBrisanjeTure.add(bDodavanjeDestinacije, gbc4);
			
			gbc4.gridx = 0;
			gbc4.gridy = 4;
			panelModifikacijaBrisanjeTure.add(bObrisiTuru, gbc4);
			
			gbc4.gridx = 1;
			gbc4.gridy = 4;
			panelModifikacijaBrisanjeTure.add(bAktivirajTuru, gbc4);
			
			tab3Panel.add(panelModifikacijaBrisanjeTure);
		}*/
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(jtb, BorderLayout.NORTH);
		this.getContentPane().add(jtp, BorderLayout.CENTER);
		this.setVisible(true);
	}
	

	/*public static void main(String[] args) throws IOException {
		TuristaUlogovanProzor tup = new TuristaUlogovanProzor(true);

	}*/

}
