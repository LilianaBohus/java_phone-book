import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	JPanel pFelso;
	JButton bUj, bTorol, bMentes, bBetoltes, bRendezes;
	JTextField tKereso;
	JTable tabla;
	Telefonkonyv telefonkonyv;
	Frame frame;
	
	public static void main(String[] args) {
		Frame ablak = new Frame();
		ablak.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public Frame() {
		this.frame = this;
		setSize(1000, 500);
		
		this.setTitle("Telefonkönyv alkalmazás");
		
		JPanel pFelso = new JPanel();

		bUj = new JButton("Új");
		bUj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Form(telefonkonyv);
			}
		});
		
		
		bTorol = new JButton("Törlés");
		bMentes = new JButton("Mentés");
		bBetoltes = new JButton("Betöltés");
		
		tKereso = new JTextField();
		tKereso.setColumns(20);
		
		pFelso.add(bUj);
		pFelso.add(bTorol);
		pFelso.add(tKereso);
		pFelso.add(bBetoltes);
		pFelso.add(bMentes);
		
		this.add(pFelso, BorderLayout.NORTH);
		telefonkonyv = new Telefonkonyv();
		tabla = new JTable(telefonkonyv);
		
		JScrollPane scroll = new JScrollPane(tabla);
		this.add(scroll, BorderLayout.CENTER);

		tabla.setFillsViewportHeight(true);

		
		TableRowSorter<Telefonkonyv> sorter = new TableRowSorter<Telefonkonyv>((Telefonkonyv) tabla.getModel());
		tabla.setRowSorter(sorter);

		bMentes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					try {
						telefonkonyv.lement(file);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		
		bBetoltes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					telefonkonyv.betolt(file);
					telefonkonyv.fireTableDataChanged();
				}
				
			}
		});
		
		// TODO fuggvenyek atirasa!!!
		tKereso.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				int eredmeny = 0;
				if (telefonkonyv.keresNevSzerint(tKereso.getText())!=-1) {
					tabla.setRowSelectionInterval(eredmeny, eredmeny);
					// TODO 
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				int eredmeny = telefonkonyv.keresNevSzerint(tKereso.getText());
				// TODO 
				if (eredmeny!=-1) {
					tabla.setRowSelectionInterval(eredmeny, eredmeny);
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				int eredmeny = 0;
				if (telefonkonyv.keresNevSzerint(tKereso.getText())!=-1){
					tabla.setRowSelectionInterval(eredmeny, eredmeny);
					// TODO 
		}
				
			}
		});
		
		bTorol.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tabla.getSelectedRow()!=-1) {
					telefonkonyv.torol(tabla.convertRowIndexToModel(tabla.getSelectedRow()));
				}
				
			}
		});
		
	setVisible(true);
	}
}
