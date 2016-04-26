package com.fg.socket.model;

/**
 * Classe básica de cliente.
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

	//Usando conceito de Orintação Objetos "Encapsulamento"
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
	 * Metodo abstrato onde quem herdar essa classe é obrigado a implementar este método.
	 * @param path
	 */
	public abstract void enviarArquivo(String path);
	
}
