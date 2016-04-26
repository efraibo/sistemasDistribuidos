package com.fg.socket.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.fg.socket.model.Servidor;

/**
 * 
 * @author evandro.nascimento
 *
 * Classe que implementa interface grafica do servidor, implementa ActionListener, com um parametro this,
 *  sendo que o componente ir� chamar o m�todo da interface de escuta, ActionListener.
 */
public class ServidorGUI implements ActionListener{	
	
	JFrame janela = new JFrame();
	JPanel painel = new JPanel();
	JLabel lbPorta = new JLabel("Porta: ");
	JTextField txtPorta = new JTextField("8080", 5);
	JButton btnOk = new JButton("OK");
	JButton btnSair = new JButton("SAIR");
	
	ServidorGUI() {
		janela.setTitle("Servidor");
		janela.setSize(361, 95);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		//retringindo o usuario para que n�o consiga redimencionar a janela.
		janela.setResizable(false);
		painel.add(lbPorta);
		painel.add(txtPorta);
		painel.add(btnOk);
		painel.add(btnSair);
		janela.add(painel);
		janela.setVisible(true);
		btnOk.addActionListener(this);
		btnSair.addActionListener(this);
	}	

	/**
	 * M�todo que implementa as a��es dos bot�es da tela de servidor. 
	 */
	public void actionPerformed(ActionEvent e) {		
		
		//Implementa��o da a��o do bot�o "OK".
		if ((e.getSource() == btnOk) && (!txtPorta.getText().equals(""))) {
			try {
				new Servidor(Integer.valueOf(txtPorta.getText()).intValue());
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Algum erro Ocorreu...");
			}
		}
		
		//Implementa��o da a��o do bot�o "SAIR".
		if (e.getSource() == btnSair) {
			System.out.println("Servidor Errado..");			
			System.exit(0);
		}		
	}
	
	/**
	 * Medodo principal do servidor.
	 * @param args
	 */
	public static void main(String[] args) {
		new ServidorGUI();
	}		
	
}
