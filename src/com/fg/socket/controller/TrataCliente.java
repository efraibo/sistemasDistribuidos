package com.fg.socket.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.URI;

import javax.swing.JOptionPane;

import com.fg.socket.model.JLayer;




public class TrataCliente extends Thread{
	private Socket client;
	
	String fileName;
	
	public TrataCliente(Socket s){
		client = s;
	}
	
	@Override
	public void run() {
		try {
			
			
			System.out.println("Conectado ao Cliente...");			
			
			// O "ObjectInputStream" é usado para passar objetos entre hosts usando um fluxo de soquete.			
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			//Bytes para esta operação são lidos a partir do fluxo de entrada contido.
			fileName =  in.readUTF();
			//verifica o tamanho do arquivo
			long size = in.readLong();
			System.out.println("Processando arquivo: " + fileName + " - " + size + " bytes. ");
			
			//Cria um fluxo de saída de arquivo.
			FileOutputStream fos = new FileOutputStream(fileName);
			byte[] buf = new byte[4096];
			
			while (true) {
				int len = in.read(buf);
				if(len == -1) break;				
				fos.write(buf, 0, len);				
			}
			
			fos.flush();
			fos.close();
			System.out.println("Transferencia concluída com sucesso");
			
		    client.close();  
		    
		  //implementação para tocar a musica
            JLayer l = new JLayer();
			l.execeutarMidia(fileName);
			
			File file = new File("");
			URI fileUri = file.toURI();
			
			//Runtime.getRuntime().exec("cmd /c start \"%programfiles%\\Windows Media Player\\wmplayer.exe\" \"C:/Users/Evandro/workspace/SocketInterface\\" + fileName);
			//Runtime.getRuntime().exec("cmd /c start \"%programfiles%\\Windows Media Player\\wmplayer.exe\"" + this.getClass().getResource(fileName));
			Runtime.getRuntime().exec("cmd /c start \"%programfiles%\\Windows Media Player\\wmplayer.exe\"" + fileUri + fileName);
			System.out.println(fileUri);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Algum erro Ocorreu");
			e.printStackTrace();
			System.exit(1);
		}	
		
	}
	
}

