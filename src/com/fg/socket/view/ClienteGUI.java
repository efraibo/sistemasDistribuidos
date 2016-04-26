package com.fg.socket.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.fg.socket.model.Cliente;

//https://www.youtube.com/watch?v=UHuN-yNn8-A

/** 
 * 
 * @author Evandro
 *
 * Esta classe usa o awt.FlowLayout para organizar a tela é um tipo de gerenciamento de layout, e swing
 * para manipular componentes de interface, 
 * implementa ActionListener, com um parametro this,
 * sendo que o componente irá chamar o método da interface de escuta ou seja trantando clique do mouse ou tecla enter por exemplo, ActionListener.* 
 * 
 */

public class ClienteGUI implements ActionListener{

	//Craindo uma instacia de seus componentes
	JFrame janela = new JFrame();
    JPanel painel = new JPanel();
    
    JLabel lbServidor = new JLabel("Servidor: ");
    JTextField txtServidor = new JTextField("127.0.0.1",10);
    
    JLabel lbPorta = new JLabel("Porta: ");
    JTextField txtPorta = new JTextField("8080",5);
    
    JLabel lbArquivo = new JLabel("Arquivo: ");
    JTextField txtArquivo = new JTextField("",10);
    
    JButton btnArquivo = new JButton("Selecionar");
    JButton btnEnviar = new JButton("Enviar");

    public ClienteGUI() {
    	
    	/**
    	 * Interface Gráfica    	 *  
    	 * */
        janela.setTitle("Cliente");
        janela.setSize(460, 135);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20)); 
        //retringindo o usuario para que não consiga redimencionar a janela
        janela.setResizable(false);
        
        painel.add(lbServidor);
        painel.add(txtServidor);
        
        painel.add(lbPorta);
        painel.add(txtPorta);
        
        painel.add(lbArquivo);
        painel.add(txtArquivo);
        
        painel.add(btnArquivo);
        painel.add(btnEnviar);
        
        janela.add(painel);
        janela.setVisible(true);
        
        btnArquivo.addActionListener(this);
        btnEnviar.addActionListener(this);
    }
    
    /**
     * Esse metódo implementa os botão de pesquisa do arquivo.
     * É um override do ActionListener
     * Implementando o botão enviar do cliente. 
     */
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnArquivo){
            JFileChooser fc = new JFileChooser();
            int res = fc.showOpenDialog(null);
            
            if(res == JFileChooser.APPROVE_OPTION){
                File arquivo = fc.getSelectedFile();
                txtArquivo.setText(arquivo.getAbsolutePath());
            }
            else JOptionPane.showMessageDialog(null,"Você não selecionou o arquivo");
        }
        //Programando botão enviar
        if((e.getSource() == btnEnviar)&&(!txtArquivo.getText().equals(""))){
            try{
                new Cliente(txtServidor.getText(),Integer.valueOf(txtPorta.getText()).intValue()).enviarArquivo(txtArquivo.getText());
            }
            catch(Exception el){
                el.printStackTrace();
            }
        }
    }
    
    /**
     * Metodo principal de cliente
     * @param args
     */
    public static void main(String[] args){
        new ClienteGUI();
    }
}
