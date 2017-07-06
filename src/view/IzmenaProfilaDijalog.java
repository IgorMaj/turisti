package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Aplikacija;

public class IzmenaProfilaDijalog extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IzmenaProfilaDijalog(JLabel ime, JLabel prezime, JLabel broj, JLabel korIme){
		
		this.setSize(450, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Izmena podataka na profilu");
		
		JLabel lNovoIme = new JLabel("Ime:");
		JLabel lNovoPrezime = new JLabel("Prezime:");
		JLabel lNoviTelefon = new JLabel("Telefon:");
		JLabel lNovoKorIme = new JLabel("Korisnicko ime:");
		JLabel lNovaLozinka = new JLabel("Lozinka:");
		
		JTextField taNovoIme = new JTextField(15);
		JTextField taNovoPrezime = new JTextField(15);
		JTextField taNoviTelefon = new JTextField(15);
		JTextField taNovoKorIme = new JTextField(15);
		JPasswordField pfNovaLozinka = new JPasswordField(15);
		
		JButton bIzmeni = new JButton("Izmeni");
		JButton bOdustani = new JButton("Odustani");
		
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.insets = new Insets(2, 1, 2, 1);
		gbc.anchor = GridBagConstraints.LINE_START;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.getContentPane().add(lNovoIme, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.getContentPane().add(taNovoIme, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.getContentPane().add(lNovoPrezime, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		this.getContentPane().add(taNovoPrezime, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.getContentPane().add(lNoviTelefon, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		this.getContentPane().add(taNoviTelefon, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.getContentPane().add(lNovoKorIme, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.CENTER;
		this.getContentPane().add(taNovoKorIme, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.getContentPane().add(lNovaLozinka, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.CENTER;
		this.getContentPane().add(pfNovaLozinka, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.LINE_END;
		this.getContentPane().add(bIzmeni, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.CENTER;
		this.getContentPane().add(bOdustani, gbc);
		
		bIzmeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(Aplikacija.IzmeniKorisnika(taNovoIme.getText().trim(), taNovoPrezime.getText().trim(),
							taNoviTelefon.getText().trim(), taNovoKorIme.getText().trim(),
							pfNovaLozinka.getText().trim()) == true){
						
						ime.setText(Aplikacija.trenutnoAktivan.getIme());
						prezime.setText(Aplikacija.trenutnoAktivan.getPrezime());
						broj.setText(Aplikacija.trenutnoAktivan.getTelefon());
						korIme.setText(Aplikacija.trenutnoAktivan.getKorIme());
						
						dispose();
					}else{
						JOptionPane.showMessageDialog(IzmenaProfilaDijalog.this, "Uneto korisnicko ime vec postoji!","Upozorenje", JOptionPane.WARNING_MESSAGE);
					}
				} catch (HeadlessException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		bOdustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		this.setVisible(true);
	}
}
