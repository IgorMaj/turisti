package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class KreiranjeTurePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	KreiranjeTurePanel(BrisanjeTuraPanel btp) {
		JPanel p1 = new JPanel (new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.anchor = GridBagConstraints.NORTHWEST;
		g.insets = new Insets(2, 1, 2, 1);
		TitledBorder tb1 = new TitledBorder("Unesite osnovne podatke ture");
		p1.setBorder(tb1);

		JLabel l1 = new JLabel("ID ture: ");
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		p1.add(l1, g);

		JTextField t1 = new JTextField();
		t1.setPreferredSize(new Dimension(200, 20));
		g.gridx = 1;
		g.gridy = 0;
		p1.add(t1, g);

		JLabel l2 = new JLabel("Opis ture: ");
		g.gridx = 0;
		g.gridy = 1;
		g.gridheight = 2;
		p1.add(l2, g);

		JTextArea t2 = new JTextArea();
		JScrollPane s2 = new JScrollPane(t2);
		s2.setPreferredSize(new Dimension(400, 50));
		g.gridx = 1;
		g.gridy = 1;
		g.gridheight = 2;
		p1.add(s2, g);

		JLabel l3 = new JLabel("Potreban broj prijavljenih: ");
		g.gridx = 0;
		g.gridy = 3;
		g.gridheight = 1;
		p1.add(l3, g);
		
		JTextField t3 = new JTextField();
		t3.setPreferredSize(new Dimension(50, 20));
		g.gridx = 1;
		g.gridy = 3;
		g.gridheight = 1;
		p1.add(t3, g);
		//levo gradovi
		JPanel p2 = new JPanel (new BorderLayout());
		TitledBorder tb2 = new TitledBorder("Popunite listu gradova ture");
		p2.setBorder(tb2);
		
		JPanel levi1 = new JPanel(new GridBagLayout());
		JLabel l4 = new JLabel("Naziv grada: ");
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		levi1.add(l4, g);
		
		JTextField t4 = new JTextField();
		t4.setPreferredSize(new Dimension(200, 20));
		g.gridx = 1;
		g.gridy = 0;
		g.gridheight = 1;
		levi1.add(t4, g);
		
		JLabel l5 = new JLabel("PTT: ");
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 1;
		levi1.add(l5, g);
		
		JTextField t5 = new JTextField();
		t5.setPreferredSize(new Dimension(50, 20));
		g.gridx = 1;
		g.gridy = 1;
		levi1.add(t5, g);
		
		JButton dodaj1 = new JButton("Dodaj Grad");
		dodaj1.setPreferredSize(new Dimension(100, 20));
		g.gridx = 0;
		g.gridwidth = 2;
		g.gridy = 2;
		levi1.add(dodaj1, g);
		//desno gradovi
		JPanel desni1 = new JPanel(new GridBagLayout());
		JLabel l6 = new JLabel("Lista dodatih gradova: ");
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		desni1.add(l6, g);
		
		JComboBox<String> c1 = new JComboBox<String>();
		c1.setPreferredSize(new Dimension(200,20));
		g.gridx = 1;
		g.gridy = 0;
		desni1.add(c1, g);
		
		JButton ukloni1 = new JButton("Ukloni iz liste");
		ukloni1.setPreferredSize(new Dimension(150, 20));
		g.gridx = 0;
		g.gridwidth = 2;
		g.gridy = 1;
		desni1.add(ukloni1, g);
		
		
		p2.add(levi1,BorderLayout.WEST);
		p2.add(desni1,BorderLayout.EAST);
		
		//unos destinacija
		JPanel p3= new JPanel(new BorderLayout());
		TitledBorder tb3= new TitledBorder("Popunite listu destinacija ture");
		p3.setBorder(tb3);
		
		JPanel levi2 = new JPanel(new GridBagLayout());
		JLabel l7 = new JLabel("Naziv: ");
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		levi2.add(l7, g);
		
		JTextField t6 = new JTextField();
		t6.setPreferredSize(new Dimension(200, 20));
		g.gridx = 1;
		g.gridy = 0;
		g.gridheight = 1;
		levi2.add(t6, g);
		
		JLabel l8 = new JLabel("Opis: ");
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 1;
		g.gridheight = 2;
		levi2.add(l8, g);
		
		JTextArea t7 = new JTextArea();
		JScrollPane s7 = new JScrollPane(t7);
		s7.setPreferredSize(new Dimension(300, 50));
		g.gridx = 1;
		g.gridy = 1;
		levi2.add(s7, g);
		
		JLabel l9 = new JLabel("Mesto: ");
		g.gridheight = 1;
		g.gridx = 0;
		g.gridy = 3;
		levi2.add(l9, g);
		
		JComboBox<String> c2 = new JComboBox<String>();
		c2.setPreferredSize(new Dimension(200,20));
		g.gridx = 1;
		g.gridy = 3;
		levi2.add(c2, g);
		
		JButton dodaj2 = new JButton("Dodaj");
		dodaj2.setPreferredSize(new Dimension(100, 20));
		g.gridx = 0;
		g.gridwidth = 2;
		g.gridy = 4;
		levi2.add(dodaj2, g);
		//desno unos
		JPanel desni2 = new JPanel(new GridBagLayout());
		JLabel l10 = new JLabel("Lista dodatih destinacija: ");
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		desni2.add(l10, g);
		
		JComboBox<String> c3 = new JComboBox<String>();
		c3.setPreferredSize(new Dimension(200,20));
		g.gridx = 1;
		g.gridy = 0;
		desni2.add(c3, g);
		
		JButton ukloni2 = new JButton("Ukloni iz liste");
		ukloni2.setPreferredSize(new Dimension(150, 20));
		g.gridx = 0;
		g.gridwidth = 2;
		g.gridy = 1;
		desni2.add(ukloni2, g);
		
		p3.add(levi2,BorderLayout.WEST);
		p3.add(desni2,BorderLayout.EAST);
		//termini unos
		JPanel p4= new JPanel(new BorderLayout());
		TitledBorder tb4= new TitledBorder("Popunite termine ture");
		p4.setBorder(tb4);
		
		JPanel levi3 = new JPanel(new GridBagLayout());
		
		JLabel l11 = new JLabel("Datum pocetka: ");
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		levi3.add(l11, g);
		
		JTextField t8 = new JTextField();
		t8.setPreferredSize(new Dimension(100, 20));
		g.gridx = 1;
		g.gridy = 0;
		levi3.add(t8, g);
		
		JLabel l12 = new JLabel("Datum zavrsetka: ");
		g.gridx = 2;
		g.gridy = 0;
		levi3.add(l12, g);
		
		JTextField t9 = new JTextField();
		t9.setPreferredSize(new Dimension(100, 20));
		g.gridx = 3;
		g.gridy = 0;
		levi3.add(t9, g);
		
		JLabel l13 = new JLabel("Broj mesta: ");
		g.gridx = 0;
		g.gridy = 1;
		levi3.add(l13, g);
		
		JTextField t10 = new JTextField();
		t10.setPreferredSize(new Dimension(50, 20));
		g.gridx = 1;
		g.gridy = 1;
		levi3.add(t10, g);
		
		JLabel l14 = new JLabel("Cena: ");
		g.gridx = 0;
		g.gridy = 2;
		levi3.add(l14, g);
		
		JTextField t11 = new JTextField();
		t11.setPreferredSize(new Dimension(50, 20));
		g.gridx = 1;
		g.gridy = 2;
		levi3.add(t11, g);
		
		JButton dodaj3 = new JButton("Dodaj");
		dodaj3.setPreferredSize(new Dimension(100, 20));
		g.gridx = 0;
		g.gridwidth = 2;
		g.gridy = 3;
		levi3.add(dodaj3, g);
		
		//desno termini
		JPanel desni3 = new JPanel(new GridBagLayout());
		JLabel l15 = new JLabel("Lista dodatih termina: ");
		g.gridx = 0;
		g.gridy = 0;
		g.gridwidth = 1;
		g.gridheight = 1;
		desni3.add(l15, g);
		
		JComboBox<String> c4 = new JComboBox<String>();
		c4.setPreferredSize(new Dimension(200,20));
		g.gridx = 1;
		g.gridy = 0;
		desni3.add(c4, g);
		
		JButton ukloni3 = new JButton("Ukloni iz liste");
		ukloni3.setPreferredSize(new Dimension(150, 20));
		g.gridx = 0;
		g.gridwidth = 2;
		g.gridy = 1;
		desni3.add(ukloni3, g);
		
		p4.add(levi3,BorderLayout.WEST);
		p4.add(desni3,BorderLayout.EAST);
		
		//dugmad
		
		JPanel p5 = new JPanel(new BorderLayout());
		JPanel levi4 = new JPanel();
		JPanel desni4 = new JPanel(new FlowLayout());
		
		JButton sacuvaj = new JButton("Sacuvaj");
		desni4.add(sacuvaj);
		
		JButton odustani = new JButton("Odustani");
		desni4.add(odustani);
		
		p5.add(levi4, BorderLayout.WEST);
		p5.add(desni4, BorderLayout.EAST);
		
		// prazne labele da sve bude gore levo
		g.weightx = 1;
		g.weighty = 1;
		p1.add(new JLabel(" "), g);
		levi1.add(new JLabel(" "), g);
		desni1.add(new JLabel(" "), g);
		levi2.add(new JLabel(" "), g);
		desni2.add(new JLabel(" "), g);
		levi3.add(new JLabel(" "), g);
		desni3.add(new JLabel(" "), g);
		
		// paneli
		setLayout(new GridBagLayout());
		g.fill = GridBagConstraints.HORIZONTAL;
		g.gridx = 0;
		g.gridy = 0;
		g.weightx = 0;
		g.weighty = 0;
		g.gridwidth = 2;
		g.gridheight = 2;
		add(p1,g);
		
		g.gridx = 0;
		g.gridy = 3;
		g.gridheight=1;
		add(p2,g);
		
		g.gridx = 0;
		g.gridy = 4;
		add(p3,g);
		
		g.gridx = 0;
		g.gridy = 5;
		add(p4,g);
		g.gridx = 0;
		g.gridy = 6;
		add(p5,g);
		
		

		//prazna labela da pocne od gornjeg levog ugla
		g.weightx = 1;
		g.weighty = 1;
		add(new JLabel(" "), g);

	}

	private void add(GridLayout g) {
		// TODO Auto-generated method stub

	}

}
