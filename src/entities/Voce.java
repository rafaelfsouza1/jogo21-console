package entities;

public class Voce {
	
	private Integer pontos = 0;
	
	public int getPontos() {
		return pontos;
	}
	
	public void jogada() {
		System.out.println();
		int resultado = Dado.resultDado();
		addPontos(resultado);
		System.out.println("Voce tirou " + resultado);		
	}	
	
	public void addPontos(int pontos) {
		this.pontos += pontos;
	}
	
	public boolean prosseguir(char entrada) {
		if(entrada == 'J' || entrada == 'j') {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Voce fez: "
				+ pontos
				+ ".";
	}

}
