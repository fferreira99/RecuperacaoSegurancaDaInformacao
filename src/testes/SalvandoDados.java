package testes;

import java.util.Scanner;

import dao_sistema.ProteinaTotalS;
import dao_sistema.SenhaS;
import dao_sistema.UsuarioS;
import dao_sistema.ValoresPadroesS;

public class SalvandoDados {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			String login = "Francisco";
			System.out.print("login: " + login);
			String senhaUsuario = "2019fla2022";
			System.out.print("\nsenha: " + senhaUsuario );
			UsuarioS S = new UsuarioS();
			S.adiciona(login, senhaUsuario);
			System.out.println("\nGravação do usuario e senha feita no banco de dados!");
			
			String senhaCriptografia = "fla1981uru";
			System.out.print("Senha para criptografar a tabela Exame: " + senhaCriptografia);
			SenhaS SSenha = new SenhaS();
			SSenha.adiciona(senhaCriptografia, senhaUsuario);
			System.out.println("\nGravação da senha para criptografar feita no banco de dados!");
			
			ProteinaTotalS SExame = new ProteinaTotalS();
			SExame.adiciona("28 mg/dL", 1, 1, senhaCriptografia);
			System.out.println("\nGravação do exame de proteína total feita no banco de dados!");
			SExame.adiciona("26 mg/dL", 2, 1, senhaCriptografia);
			System.out.println("\nGravação do exame de proteína total feita no banco de dados!");
			SExame.adiciona("30 mg/dL", 3, 2, senhaCriptografia);
			System.out.println("\nGravação do exame de proteína total feita no banco de dados!");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}

