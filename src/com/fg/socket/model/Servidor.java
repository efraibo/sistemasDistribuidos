package com.fg.socket.model;

import java.net.ServerSocket;
import javax.swing.JOptionPane;

import com.fg.socket.controller.TrataCliente;

/** 
 * @author Evandro
 *
 * Esta classe implementa a interface runnable pois serve para criar uma thread, onde sou obrigado a implementa o metodo "run"
 */
public class Servidor implements Runnable{
	
	ServerSocket serv;
	private int porta;
	
	TrataCliente trataCliente;

	/**
	 * 
	 * @param porta
	 * @throws Exception
	 * 
	 * criando um construtor para carregar o atributo porta,
	 * onde digo que o atributo serv vai receber uma instacia do serverSocket com a porta como parametro.
	 */
	
	public Servidor(int porta) throws Exception {
		this.porta = porta;
		serv = new ServerSocket(porta);
		//iniciando a thread
		new Thread(this).start();
		//uso o JOptionPane para exibir uma mensagem ao usuario.
		JOptionPane.showMessageDialog(null, "Servidor aguardando conexão na porta: " + porta);
		//já o printe exibe apenas no console
		System.out.println("Servidor aguardando conexão na porta: " + porta);
	}

	/**
	 * Encapsulando o atributo porta
	 * @return
	 */
	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}
	
	/**
	 * Metodo startando uma outra thred dessa vez a "TrataCliente"
	 */
	@Override
	public void run() {
		try {
			while (true) {
				new TrataCliente(serv.accept()).start();				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
		
}
