package ex02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastroAlunos {

	private static final int NUMERO_MAXIMO_ALUNOS = 5;

	private String[] nomes;
	private int[] idades;
	private double[] notas;
	private int contador;

	public CadastroAlunos() {
		nomes = new String[NUMERO_MAXIMO_ALUNOS];
		idades = new int[NUMERO_MAXIMO_ALUNOS];
		notas = new double[NUMERO_MAXIMO_ALUNOS];
		contador = 0;
	}

	public void cadastrarAluno() {
		if (contador >= NUMERO_MAXIMO_ALUNOS) {
			System.out.println("Número máximo de alunos cadastrados alcançado!");
			return;
		}

		try (Scanner scanner = new Scanner(System.in)) {
			try {
				System.out.print("Digite o nome do aluno: ");
				String nome = scanner.nextLine();
				nomes[contador] = nome;

				System.out.print("Digite a idade do aluno: ");
				int idade = scanner.nextInt();
				idades[contador] = idade;

				System.out.print("Digite a nota do aluno: ");
				double nota = scanner.nextDouble();
				notas[contador] = nota;

				contador++;
				System.out.println("Aluno cadastrado com sucesso!");
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida! Certifique-se de digitar os dados corretamente.");
				scanner.nextLine(); // Limpa o buffer do scanner
			}
		}
	}

	public void exibirAlunosCadastrados() {
		if (contador == 0) {
			System.out.println("Nenhum aluno cadastrado.");
			return;
		}

		System.out.println("Alunos cadastrados:");
		for (int i = 0; i < contador; i++) {
			System.out.println("Nome: " + nomes[i]);
			System.out.println("Idade: " + idades[i]);
			System.out.println("Nota: " + notas[i]);
			System.out.println("-------------------------");
		}
	}

	public static void main(String[] args) {
		CadastroAlunos cadastro = new CadastroAlunos();

		cadastro.cadastrarAluno();
		cadastro.exibirAlunosCadastrados();
	}
}
