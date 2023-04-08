package myApp;

import java.util.List;
import java.util.Scanner;

import dao.DAO;
import dao.CarroDAO;
import model.Carro;

public class MyAplicacao {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		
		CarroDAO carroDAO = new CarroDAO();
		
		String marca, modelo;
		
		int codigo, ano, op, resp;
		
		op = 0;
		
		while (op != 5) {
			System.out.print("\n\nEscolha uma opcao:\n\n 1 - Listar\n 2 - Inserir\n 3 - Excluir\n 4 - Atualizar\n 5 - Sair\n\nSua escolha: ");
			op = sc.nextInt();
			
			if (op == 1) {
				System.out.print("Como deseja listar?\n\n1 - Ordenar por código\n2 - Ordenar por marca\nou\n3 - Ordenar por ano\n: ");
				resp = sc.nextInt();
				if (resp == 1) {
					System.out.println("\n\n==== Carros ordenados por código === ");
					List<Carro> carros = carroDAO.getOrderByCodigo();
					for (Carro c: carros) {
						System.out.println(c.toString());
					}
				} else if (resp == 2) {
					System.out.println("\n\n==== Carros ordenados por marca === ");
					List<Carro> carros = carroDAO.getOrderByMarca();
					for (Carro c: carros) {
						System.out.println(c.toString());
					}
				} else if (resp == 3) {
					System.out.println("\n\n==== Carros ordenados por ano === ");
					List<Carro> carros = carroDAO.getOrderByAno();
					for (Carro c: carros) {
						System.out.println(c.toString());
					}
				}
				else {
					System.out.println("\n\n!!! Opção inválida !!! ");
				}
			}
			else if (op == 2) {
				System.out.println("\n\n==== Inserir carro === ");
				System.out.println("Código: ");
				codigo = sc.nextInt();
				System.out.println("Marca: ");
				marca = sc.next();
				System.out.println("Modelo: ");
				modelo = sc.next();
				System.out.println("Ano: ");
				ano = sc.nextInt();
				Carro carro = new Carro(codigo, marca, modelo, ano);
				if(carroDAO.insert(carro) == true) {
					System.out.println("Inserção com sucesso -> " + carro.toString());
				}
			}
			else if (op == 3) {
				System.out.println("\n\n==== Excluir carro === ");
				System.out.println("Código: ");
				codigo = sc.nextInt();
				carroDAO.delete(codigo);
				System.out.println("\n\n==== Carro excluído ====\n\n");
			}
			else if (op == 4) {
				
				System.out.print("\n\n==== Atualizar carro ====\n\nInforme as informações do carro\n\n");
				System.out.println("Código: ");
				codigo = sc.nextInt();
				System.out.println("Marca: ");
				marca = sc.next();
				System.out.println("Modelo: ");
				modelo = sc.next();
				System.out.println("Ano: ");
				ano = sc.nextInt();
				Carro carro = new Carro(codigo, marca, modelo, ano);
				carroDAO.update(carro);
			}
			else if (op == 5) {
				System.out.print("==== ENCERRADO ====");
			}
			else {
				System.out.println("\n\n!!! Opção inválida !!! ");
			}
		}
	}
}