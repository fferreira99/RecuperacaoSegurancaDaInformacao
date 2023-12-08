package testes;

import java.util.List;
import java.util.Scanner;
import dao_sistema.ProteinaTotalS;
import dao_sistema.SenhaS;
import dao_sistema.UsuarioS;
import modelo_classesBase.ProteinaTotal;
import modelo_classesBase.Senha;
import modelo_classesBase.Usuario;
import seguranca.Criptografia;

public class TesteBuscaEDecriptografia {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			
			int id = 1;
			String senhaUsuario = "2019fla2022";
			
			UsuarioS SUsuario = new UsuarioS();
			Usuario usuario = SUsuario.getusuariobyId(id);
			System.out.println("Hash da senha do Usuario (banco de dados): " + usuario.getSenha());
			
			ProteinaTotalS SExame = new ProteinaTotalS();
			SenhaS SSenha = new SenhaS();
			
			Senha senha = SSenha.getSenhabyId(id);
			System.out.println("Chave criptografada da tabela senha (banco de dados): " + senha.getChaveSecreta());
			String senhaCriptografia = Criptografia.decriptografa(
					senha.getChaveSecreta(), 
					Criptografia.criarChaveSecreta(senhaUsuario));
			System.out.println("Chave decriptografada: " + senhaCriptografia);
			
			List<ProteinaTotal> exames = SExame.getLista();
			
			for (ProteinaTotal exame : exames) {
				System.out.println("-----------------------------------------------------------");
				System.out.println("Resultado do exame de proteína total do paciente: " + exame.getPaciente() + " solicitado "
						+ "pelo médico: " + exame.getMedico());
				System.out.println("Resultado do exame criptografado (banco de dados): " + exame.getResultado());
				String nomeDoExame = Criptografia.decriptografa(
						exame.getResultado(), 
						Criptografia.criarChaveSecreta(senhaCriptografia));
				System.out.println("Resultado do exame decriptografado: " + nomeDoExame);
			}
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}
