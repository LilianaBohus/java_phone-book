import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Form extends JFrame {
	
	JTextField tNev, tTelefonszam, tFoglalkozas, tLakcim, tEmail;
	JButton bOk;
	Telefonkonyv telefonkonyv;
	Form form;
	
	public Form(Telefonkonyv t) {
		this.setTitle("Új névjegy hozzáadása");
		this.telefonkonyv = t;
		this.form = this;
		build();
		this.setVisible(true);
	}
	
	public void build() {
		setSize(320, 190);
		setResizable(false);
		setLayout(new FlowLayout());
		
		JLabel lNev = new JLabel("Név:");
		tNev = new JTextField();
		tNev.setColumns(20);
		
		JLabel lTelefonszam = new JLabel("Telefonszám:");
		tTelefonszam = new JTextField();
		tTelefonszam.setColumns(20);
		
		JLabel lFoglalkozas = new JLabel("Foglalkozás:");
		tFoglalkozas = new JTextField();
		tFoglalkozas.setColumns(20);
		
		JLabel lLakcim = new JLabel("Lakcím:");
		tLakcim = new JTextField();
		tLakcim.setColumns(20);
		
		JLabel lEmail = new JLabel("Email:");
		tEmail = new JTextField();
		tEmail.setColumns(20);
		
		bOk = new JButton("OK");
		
		add(lNev);
		add(tNev);
		
		add(lTelefonszam);
		add(tTelefonszam);
		
		add(lFoglalkozas);
		add(tFoglalkozas);
		
		add(lLakcim);
		add(tLakcim);
		
		add(lEmail);
		add(tEmail);
		
		add(bOk);
		
		bOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Nevjegy ujNevjegy = new Nevjegy(tNev.getText(),
											tTelefonszam.getText(),
											tFoglalkozas.getText(),
											tLakcim.getText(),
											tEmail.getText());
				try {
					telefonkonyv.addNevjegy(ujNevjegy);
				} catch (OverrideException e) {
					// TODO: handle exception
				}
				form.dispatchEvent(new WindowEvent(form,  WindowEvent.WINDOW_CLOSING));
			}
		});
	}
}
