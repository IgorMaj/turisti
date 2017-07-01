import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.omg.CORBA.TRANSACTION_MODE;

public class RegistrationWindow extends JDialog {
	JLabel text;
	JLabel name;
	JLabel surname;
	JLabel phone_number;
	JLabel username;
	JLabel password;
	JLabel tip_korisnika;
	JComboBox<String> tip;
	JTextField text_name;
	JTextField text_surname;
	JTextField text_phone_number;
	JTextField user;
	JPasswordField pass;
	
	JButton potvrda;
	JButton odustanak;
	
	ArrayList<Korisnik> korisnici;
	
	public RegistrationWindow(ArrayList<Korisnik> k){
		super();
		k = korisnici;
		setSize(395,380);
		setTitle("REGISTRACIJA");
		
		
		JPanel p1 = new JPanel(new BorderLayout());
		p1.setSize(400, 25);
		
		
		text = new JLabel("Dobrodosli, ovdje mozete napraviti svoj nalog.");
		text.setFont(new Font("Serif",Font.BOLD,20));
		p1.add(text,BorderLayout.NORTH);
		
		this.add(p1);
		
		JPanel p2 = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;
		
		
		name = new JLabel("Unesite svoje ime");
		cs.gridx = 0;
	    cs.gridy = 0;
	    cs.gridwidth = 1;
	    p2.add(name,cs);
	    
	    text_name = new JTextField(15);
		cs.gridx = 1;
	    cs.gridy = 0;
	    cs.gridwidth = 2;
	    p2.add(text_name,cs);
	    
		
		surname = new JLabel("Unesite svoje prezime");
		cs.gridx = 0;
	    cs.gridy = 1;
	    cs.gridwidth = 1;
	    p2.add(surname,cs);
	    
	    text_surname = new JTextField(15);
		cs.gridx = 1;
	    cs.gridy = 1;
	    cs.gridwidth = 2;
	    p2.add(text_surname,cs);
	    
		
		phone_number = new JLabel("Unesite svoj broj telefona");
		cs.gridx = 0;
	    cs.gridy = 2;
	    cs.gridwidth = 1;
	    p2.add(phone_number,cs);

		text_phone_number = new JTextField(15);
		cs.gridx = 1;
	    cs.gridy = 2;
	    cs.gridwidth = 2;
	    p2.add(text_phone_number,cs);
	    
	    
		username = new JLabel("Unesite korisnicko ime za svoj nalog");
		cs.gridx = 0;
	    cs.gridy = 3;
	    cs.gridwidth = 1;
	    p2.add(username,cs);
		
	    user = new JTextField(15);
	    cs.gridx = 1;
	    cs.gridy = 3;
	    cs.gridwidth = 2;
	    p2.add(user,cs);
	    
	    password = new JLabel("Unesite lozinku za svoj nalog");
	    cs.gridx = 0;
	    cs.gridy = 4;
	    cs.gridwidth = 1;
	    p2.add(password,cs);
	    
	    pass = new JPasswordField(15);
	    cs.gridx = 1;
	    cs.gridy = 4;
	    cs.gridwidth = 2;
	    p2.add(pass,cs);

	    tip_korisnika = new JLabel("tip korisnika");
	    cs.gridx = 0;
	    cs.gridy = 5;
	    cs.gridwidth = 1;
	    p2.add(tip_korisnika,cs);
	    
	    
	    String[] tipovi_korisnika = {"turista","vodic"};
	    tip = new JComboBox<String>(tipovi_korisnika);
	    tip.setVisible(true);
	    cs.gridx = 1;
	    cs.gridy = 5;
	    cs.gridwidth = 2;
	    p2.add(tip,cs);
	    this.add(p2);
	    
		setVisible(true);
		setResizable(false);
		
		potvrda = new JButton("Potvrda");
		odustanak = new JButton("Odustanak");
	    JPanel oc = new JPanel();
	    oc.add(potvrda);
	    oc.add(odustanak);
	    
	    getContentPane().add(p2, BorderLayout.CENTER);
        getContentPane().add(oc, BorderLayout.PAGE_END);
	    
     
		int w = getContentPane().getWidth();
		int h = getContentPane().getHeight();
		int[] koordinate = this.centriraj_prozor(w, h);
		setLocation(koordinate[0], koordinate[1]);
		
		
		potvrda.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (text_name.getText().trim().equals("")|| text_surname.getText().trim().equals("") || text_phone_number.getText().trim().equals("") || user.getText().trim().equals("") || pass.getText().trim().equals("")){
					JOptionPane.showMessageDialog(RegistrationWindow.this, "Sva polja moraju biti popunjena!!!");
				}
				
				try {
					if (Korisnik.korisnik_vec_postoji(user.getText().trim())){
						JOptionPane.showMessageDialog(RegistrationWindow.this,"Korisnicko ime koje ste unijeli vec postoji!!!");
						user.setText("");
						pass.setText("");
					}else{
						Korisnik k;
						/*if (tip.getSelectedItem().equals("vodic")){
							k = new Vodic(text_name.getText().trim(),text_surname.getText().trim(),text_phone_number.getText().trim(),user.getText().trim(),pass.getText().trim());
						}else{
							k = new Turista(text_name.getText().trim(),text_surname.getText().trim(),text_phone_number.getText().trim(),user.getText().trim(),pass.getText().trim());
						}*/
						HashMap<String, Korisnik> korisnici = new HashMap<String,Korisnik>();
						//Korisnik.ucitaj_korisnike(korisnici);
						//korisnici.put(k.getKorisnicko_ime(), k);
						Korisnik.snimi_korisnike_u_fajl(korisnici);
						JOptionPane.showMessageDialog(RegistrationWindow.this, "Cestitamo, upravo ste napravili svoj nalog :)");
					}
				} catch (HeadlessException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		odustanak.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
				
			}
		});
	}
	
	public static int[] centriraj_prozor(int w,int h) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    
	    int x = (int) ((dimension.getWidth() - w )/ 2);
	    int y = (int) ((dimension.getHeight() - h) / 2);
	    
	    int[] niz = {x,y};
	    return niz;
	}
	
	

	public static void main(String[] args) {
		//new RegistrationWindow();

	}

}