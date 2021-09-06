package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Maquina;
import entities.Voce;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Voce voce = new Voce();
		Maquina maquina = new Maquina();
		
		char x;
		boolean resposta, entrada;
		resposta = true;
		
		System.out.print("Pressione \"J\" para jogar o dado! ");
		x = sc.next().charAt(0);
		entrada = voce.prosseguir(x);
		
		if(entrada) {
			voce.jogada();
			
		}
		if(resposta) {
			maquina.jogada();
			
		}
		atual(voce, maquina);
		
		do {
			System.out.println();
			if(entrada) {
				System.out.print("Pressione \"J\" para continuar ou qualque outra tecla para parar: ");
				x = sc.next().charAt(0);
				entrada = voce.prosseguir(x);
				if(entrada) {
					voce.jogada();
				}
				else {
					System.out.println();
					System.out.println("Voce parou!");
				}
			}
			if(resposta) {
				resposta = maquina.prosseguir(entrada, voce);
				if(resposta) {
					maquina.jogada();
				}
				else {
					System.out.println("A maquina parou!");
					
				}
			}
			
			atual(voce, maquina);
			
		} while (voce.getPontos() < 21 && maquina.getPontos() < 21 && (entrada || resposta));
		
		System.out.println();
		System.out.println("---------------------");
		System.out.println();
		
		if (voce.getPontos() == maquina.getPontos()) {
			if (voce.getPontos() > 21 ) {
				System.out.println("Ambos perderam!");
			}
			else {
				System.out.println("Empate!");	
			}
		}
		else {
			if (voce.getPontos() <= 21) {
				if (maquina.getPontos() < 21) {
					if (voce.getPontos() > maquina.getPontos())
						System.out.println("Voce ganhou!");	
					else {
						System.out.println("Voce perdeu!");	
					}
				}
				else {
					System.out.println("Voce ganhou!");	
				}	
			}
			else if (maquina.getPontos() <= 21){
				System.out.println("Voce perdeu!");	
			}
			else {
				System.out.println("Ambos perderam!");		
			}			
		}
		sc.close();
	}
	
	public static void atual(Voce voce, Maquina maquina) {
		System.out.println();
		System.out.println(voce);
		System.out.println(maquina);
	}
}
