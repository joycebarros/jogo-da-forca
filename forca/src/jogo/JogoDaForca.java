package jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {

	public static void main(String[] args) {

		System.out.println("BEM-VINDO AO JOGO DA FORCA!!!");
		System.out.println("DESCUBRA QUAL É O **ANIMAL**, VOCÊ PODE TER ATÉ 6 (SEIS) ERROS!");
		System.out.println("=============================================================");

		int contador = 0;
		String palavraSorteada = sortearPalavra();
		String palavraEscondida = "";
		StringBuilder palavraEscondidaBuilder = new StringBuilder();

		for (int i = 0; i < palavraSorteada.length(); i++) {
			palavraEscondida = palavraEscondida + "-";
		}
				
		palavraEscondidaBuilder.append(palavraEscondida);

		Scanner scan = new Scanner(System.in);
		String entrada = " ";

		while (!entrada.equals("SAIR") && contador < 6) {

			boolean palavraEncontrada = true;
			
			for (int i = 0; i < palavraEscondidaBuilder.length(); i++) {
				if(palavraEscondidaBuilder.charAt(i) == '-') 
					palavraEncontrada = false;
				
			}
			if(palavraEncontrada) {
				System.out.println("Você encontrou a palavra!!! PARABÉNS!!!");
				break;
			}
			
			System.out.println("A Palavra é: " + palavraEscondidaBuilder);
			System.out.println("ESCOLHA UMA LETRA OU ESCREVA A PALAVRA (PARA DESISTIR DIGITE 'SAIR')");
			entrada = scan.next();
			entrada = entrada.toUpperCase();
			
			

			if (!entrada.matches("[A-Z]*")) {
				System.out.println("Digite apenas letras");
				continue;
			}

			if (palavraSorteada.equals(entrada)) {
				System.out.println("Você acertou! PARABÉNS!!!");
				break;
			} else if (palavraSorteada.contains(entrada)) {
				for (int i = 0; i < palavraSorteada.length(); i++) {
					char letra = palavraSorteada.charAt(i);
					if (entrada.charAt(0) == letra) {
						palavraEscondidaBuilder.setCharAt(i, entrada.charAt(0));
					}
				}
				
			} else
				contador++;
			int chances = 6 - contador;
			if(chances == 0) {
				System.out.println("Você não tem mais chances!FIM!!");
			}
			System.out.println("Você tem mais " + chances + " chances!");

			System.out.println("Você digitou: " + entrada);
		}
		scan.close();
	}

	private static String sortearPalavra() {
		String palavra = " ";

		List<String> dicionario = new ArrayList<>();
		dicionario.add(0, "CACHORRO");
		dicionario.add(1, "GALINHA");
		dicionario.add(2, "POMBO");
		dicionario.add(3, "GIRAFA");
		dicionario.add(4, "GATO");
		dicionario.add(5, "VACA");
		dicionario.add(6, "CAVALO");
		dicionario.add(7, "PORCO");
		dicionario.add(8, "PAPAGAIO");
		dicionario.add(9, "OVELHA");

		Random aleatorio = new Random();
		int valor = aleatorio.nextInt(10) + 0;
		palavra = dicionario.get(valor);

		return palavra;

	}
}
