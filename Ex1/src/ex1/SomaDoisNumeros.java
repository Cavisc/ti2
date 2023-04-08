package ex1;

import java.util.*;

class SomaDoisNumeros {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		// Declarar variaveis
		int num1, num2, soma;
		
		// Ler num1
		System.out.println("Digite um numero: ");
		num1 = sc.nextInt();
		
		// Ler num2
		System.out.println("Digite outro numero: ");
		num2 = sc.nextInt();
		
		//Somar
		soma = num1 + num2;
		
		//Resultado
		System.out.println("Soma: " + soma);
		
		sc.close();
	}
}
