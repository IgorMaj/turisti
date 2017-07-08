package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Aplikacija;
import model.Tura;

public class PridruzivanjeTuriPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Tura> ture;
	private JTable tabela;

	private String[] naziviKolona;
	
	PridruzivanjeTuriPanel(){
		ture = Aplikacija.vratiTureUKojimaNeUcestvuje();
		
		JPanel p1 = new JPanel(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.anchor = GridBagConstraints.NORTHWEST;
		g.insets = new Insets(2, 1, 2, 1);

		if (!ture.isEmpty()) {
			naziviKolona = new String[4];
			naziviKolona[0] = "ID Ture";
			naziviKolona[1] = "Opis";
			naziviKolona[2] = "Ocena";
			naziviKolona[3] = "Broj mesta";

			tabela = new JTable();
			tabela.setDefaultEditor(Object.class,null);
			
			azurirajTabelu();
			
			JScrollPane s = new JScrollPane(tabela);
			tabela.setPreferredSize(new Dimension(800, 18 * (tabela.getRowCount() + 1)));
			s.setPreferredSize(new Dimension(800, 18 * (tabela.getRowCount() + 1)));

			tabela.setMaximumSize(new Dimension(800, 500));
			s.setMaximumSize(new Dimension(800, 500));
			s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

			JLabel l1 = new JLabel("Selektujte turu kojoj zelite da se pridruzite");
			l1.setFont(new Font("Serif", Font.BOLD, 18));
			g.gridx = 0;
			g.gridy = 0;
			g.ipady = 50;
			p1.add(l1, g);

			g.gridy = 1;
			g.ipady = 0;
			p1.add(s, g);

			JButton pridruziSeDugme = new JButton("Pridruzi se");
			pridruziSeDugme.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					int odabraniIndex;
					if((odabraniIndex = tabela.getSelectedRow())==-1){
						JOptionPane.showMessageDialog(null, "Tura nije selektovana.", "Greska", JOptionPane.ERROR_MESSAGE);
						return;
					}
					Aplikacija.pridruziVodicaTuri(ture.get(odabraniIndex));
					ture.remove(odabraniIndex);
					azurirajTabelu();
				}});
			

			g.gridy = 2;
			g.anchor = GridBagConstraints.EAST;
			p1.add(pridruziSeDugme, g);
		} else {
			JLabel l1 = new JLabel("Nemate tura za pridruzivanje!");
			l1.setFont(new Font("Serif", Font.BOLD, 18));
			g.gridx = 0;
			g.gridy = 0;
			g.ipady = 50;
			p1.add(l1, g);
		}

		add(p1);
	}

	private void azurirajTabelu() {
		tabela.setModel(new DefaultTableModel(naziviKolona,0));
		DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
		dtm.setRowCount(0);
		for (Tura tura : ture) {
			dtm.addRow(new Object[] { tura.getIdTure(), tura.getOpis(), tura.getOcena(), tura.getMinBrojMesta() });
		}
		tabela.revalidate();
		tabela.repaint();
		
	}
	
}
