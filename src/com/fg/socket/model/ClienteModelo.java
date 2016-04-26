package com.fg.socket.model;

/**
 * Classe b�sica de cliente.
 * @author evandro.nascimento
 *
 */
public abstract class ClienteModelo {
	
	private String ipServidor;
	private int porta;
	
	//Construtor carregando todos os atributos da classe.
	public ClienteModelo(String ipServidor, int porta) {
		this.ipServidor = ipServidor;
		this.porta = porta;
	}

	//Usando conceito de Orinta��o Objetos "Encapsulamento"
	public String getIpServidor() {
		return ipServidor;
	}

	public void setIpServidor(String ipServidor) {
		this.ipServidor = ipServidor;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}
	
	/**
	 * Metodo abstrato onde quem herdar essa classe � obrigado a implementar este m�todo.
	 * @param path
	 */
	public abstract void enviarArquivo(String path);
	
}
