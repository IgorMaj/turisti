package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Aplikacija;
import model.Korisnik;;

public class ProzorZaLogovanje extends JDialog{
	JLabel l_korisnicko_ime;
	JLabel l_lozinka;
	JTextField polje_korisnicko_ime;
	JPasswordField polje_lozinka;
	JButton ok;
	JButton cancel;
	
	ArrayList<Korisnik> korisnici;
	
	public ProzorZaLogovanje(ArrayList<Korisnik> k){
		super();
		korisnici = k;
		setSize(235,200);
		setTitle("PRIJAVA");
		
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();
		cs.fill = GridBagConstraints.HORIZONTAL;
		
		
		l_korisnicko_ime = new JLabel("Korisnicko ime");
		cs.gridx = 0;
	    cs.gridy = 0;
	    cs.gridwidth = 1;
	    p.add(l_korisnicko_ime,cs);
		
	    polje_korisnicko_ime = new JTextField(11);
	    cs.gridx = 1;
	    cs.gridy = 0;
	    cs.gridwidth = 2;
	    p.add(polje_korisnicko_ime,cs);
	    
	    l_lozinka = new JLabel("Lozinka");
	    cs.gridx = 0;
	    cs.gridy = 1;
	    cs.gridwidth = 1;
	    p.add(l_lozinka,cs);
	    
	    polje_lozinka = new JPasswordField(11);
	    cs.gridx = 1;
	    cs.gridy = 1;
	    cs.gridwidth = 2;
	    p.add(polje_lozinka,cs);
	    
	    this.add(p);

		setVisible(true);
		setResizable(false);
		
		ok = new JButton("Ok");
		cancel = new JButton("Cancel");
	    JPanel oc = new JPanel();
	    oc.add(ok);
	    oc.add(cancel);
	    
	    getContentPane().add(p, BorderLayout.CENTER);
        getContentPane().add(oc, BorderLayout.PAGE_END);
	    
        
        
		int w = getContentPane().getWidth();
		int h = getContentPane().getHeight();
		int[] koordinate = this.centriraj_prozor(w, h);
		setLocation(koordinate[0], koordinate[1]);
        
        
        
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					if (getUsername().trim().equals("") || getPassword().trim().equals("")){
						JOptionPane.showMessageDialog(ProzorZaLogovanje.this, "Sva polja se moraju popuniti!!!");
						return;
					}
					
					
					if (Aplikacija.provjeraKorisnika(getUsername(), getPassword())){
						JOptionPane.showMessageDialog(ProzorZaLogovanje.this, "Uspjesno logovanje :)");
						
					}else{
						JOptionPane.showMessageDialog(ProzorZaLogovanje.this, "Kombinacija unijetog korisnickog imena i sifre ne postoji!!!");
						polje_korisnicko_ime.setText("");
						polje_lozinka.setText("");
					}
				} catch (HeadlessException e1) {
				
					e1.printStackTrace();
				}
				
			}

		});
		
		cancel.addActionListener(new ActionListener() {
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
	
	
	
	public String getUsername() {
        return polje_korisnicko_ime.getText().trim();
    }
 
    public String getPassword() {
        return new String(polje_lozinka.getPassword());
    }
	
	
	public static void main(String[] args) {
		new ProzorZaLogovanje(new ArrayList<Korisnik>());

	}


}