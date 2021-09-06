package entities;

public class Maquina {
	
	private Integer pontos = 0;
	
	public int getPontos() {
		return pontos;
	}
	
	public void jogada() {
		int resultado = Dado.resultDado();
		addPontos(resultado);
		System.out.println("A maquina tirou " + resultado);
	}	
	
	public void addPontos(int pontos) {
		this.pontos += pontos;
	}
	
	public boolean prosseguir(boolean entrada, Voce voce) {
		if (!entrada && pontos > voce.getPontos())	{
			return false;
		}
		else if (!entrada && pontos < voce.getPontos()) {
			return true;
		}
		else {
			if ((21 - pontos) < 10) {
				if (Math.round(Math.random() * (50) + 25) >= 50) {
					return false;
				}else {
					return true;
				}
			}
			else {
				return true;
			}
		}
	  }
	
	@Override
	public String toString() {
		return "A maquina fez: "
				+ pontos
				+ ".";
	}

}
