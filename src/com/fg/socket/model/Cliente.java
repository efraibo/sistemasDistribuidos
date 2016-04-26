package com.fg.socket.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * 
 * @author evandro.nascimento
 * Classe Cliente onde estende da classe básica ClienteModelo.
 */

public class Cliente extends ClienteModelo {
	
	private FileInputStream in;

	/**construtor da classe onde contém dois parametros	 * 
	 * @param ipServidor
	 * @param porta
	 */
	public Cliente(String ipServidor, int porta) {
		super(ipServidor, porta);		
	}


	/**
	 * A classe ClienteModelo contém um metodo Abstract onde força a classe que estender dela inplementar ela. 
	 * Conceito de polimorfismo Orientação Objeto.
	 * */	
	@Override
	public void enviarArquivo(String path) {
		//instancia um file do tipo File que é do java.io
		File file = new File(path);
		
		try {
			//passando dois paramentros para o objeto do tipo sockt sendo eles o ip e a porta.
			Socket socket = new Socket(this.getIpServidor(), this.getPorta());
			
			//esse metodo "getOutputStream()" retorna um "OutputStream" onde os dados podem ser escritos e lança a exceção apropriada, se não puder fazê-lo.
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			JOptionPane.showMessageDialog(null, "Transferindo Arquivo: " + file.getName());			
			System.out.println("Transferindo arquivo: " + file.getName());
			JOptionPane.showMessageDialog(null, "Aguarde um Momento...");
			out.writeUTF(file.getName());
			out.writeLong(file.length());			
			in = new FileInputStream(file);
			byte[] buf = new byte[4096];
			
			while (true) {
				int len = in.read(buf);
				if (len == -1) break;				
				out.write(buf, 0, len);
			}
			out.close();
			socket.close();
			System.out.println("Tranferencia Concluida");
			JOptionPane.showMessageDialog(null, "Transferencia Concluida");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
		
}
