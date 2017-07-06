package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.Aplikacija;
import model.Tura;
import model.Vodic;

public class BrisanjeTuraPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTable tabela;
	BrisanjeTuraPanel() {
		JPanel p1 = new JPanel(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.anchor = GridBagConstraints.NORTHWEST;
		g.insets = new Insets(2, 1, 2, 1);

		ArrayList<Tura> tureKojeVodi = ((Vodic)Aplikacija.trenutnoAktivan).getTure();
		if (!tureKojeVodi.isEmpty()) {
			Object[] naziviKolona = new String[4];
			naziviKolona[0] = "ID Ture";
			naziviKolona[1] = "Opis";
			naziviKolona[2] = "Ocena";
			naziviKolona[3] = "Broj mesta";

			tabela = new JTable(new DefaultTableModel(naziviKolona, 0)) {
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				};

			};
			for (Tura tura : tureKojeVodi) {
				DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
				dtm.addRow(new Object[] { tura.getIdTure(), tura.getOpis(), tura.getOcena(), tura.getMinBrojMesta() });
			}
			tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tabela.getSelectionModel().addSelectionInterval(0, 0);
			JScrollPane s = new JScrollPane(tabela);
			tabela.setPreferredSize(new Dimension(800, 18 * (tabela.getRowCount() + 1)));
			s.setPreferredSize(new Dimension(800, 18 * (tabela.getRowCount() + 1)));
			s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

			tabela.setMaximumSize(new Dimension(800, 500));
			s.setMaximumSize(new Dimension(800, 500));

			JLabel l1 = new JLabel("Selektujte turu koju zelite da obrisete");
			l1.setFont(new Font("Serif", Font.BOLD, 18));
			g.gridx = 0;
			g.gridy = 0;
			g.ipady = 50;
			p1.add(l1, g);

			g.gridy = 1;
			g.ipady = 0;
			p1.add(s, g);

			JButton obrisi = new JButton("Obrisi");
			obrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabela.getSelectedRow() == -1) {
				        JOptionPane.showMessageDialog(null, "Nije selektovana ni jedna tura.", "Greska", JOptionPane.ERROR_MESSAGE);
					} else {
						int potvrdaBrisanja = JOptionPane.showConfirmDialog(null,
								"Da li ste sigurni da zelite da obrisete turu?", "Potvrda", JOptionPane.YES_NO_OPTION);
						if (potvrdaBrisanja == JOptionPane.YES_OPTION) {
							DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
							String id = (String) dtm.getValueAt(tabela.getSelectedRow(), 0);
							for (Tura t : Aplikacija.ture) {
								if (t.getIdTure().equals(id)) {
									Aplikacija.ture.remove(t);
									
									try {
										Aplikacija.obrisiTuru(t);
									} catch (IOException e) {
										e.printStackTrace();
									}
									dtm.removeRow(tabela.getSelectedRow());
									tabela.setPreferredSize(new Dimension(800, 18 * (tabela.getRowCount() + 1)));
									s.setPreferredSize(new Dimension(800, 18 * (tabela.getRowCount() + 1)));
									if (tabela.getRowCount() > 0) {
										tabela.getSelectionModel().addSelectionInterval(0, 0);
									}
									
									revalidate();
									repaint();
									break;
								}
							}
						}
					}
				}
			});

			g.gridy = 2;
			g.anchor = GridBagConstraints.EAST;
			p1.add(obrisi, g);
		} else {
			JLabel l1 = new JLabel("Nemate tura za brisanje!");
			l1.setFont(new Font("Serif", Font.BOLD, 18));
			g.gridx = 0;
			g.gridy = 0;
			g.ipady = 50;
			p1.add(l1, g);
		}

		add(p1);

	}
}
