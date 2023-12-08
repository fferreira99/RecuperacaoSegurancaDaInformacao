package dao_sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javaDB_conectaBanco.ConexaoBanco;
import modelo_classesBase.Senha;
import modelo_classesBase.Usuario;
import seguranca.Hash;

public class UsuarioS {
	
	private Connection con;
	
	public UsuarioS() throws SQLException{
		this.con =  ConexaoBanco.getConnection();
	}
	
	public void adiciona(String login, String senha) throws SQLException {
		
		String sql = "INSERT INTO usuario (login, senha) VALUES (?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, login);
		stmt.setString(2, Hash.gerarHash(senha));
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public Usuario getusuariobyId(int id) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rset = stmt.executeQuery();
		
		if (rset.next()) {
			Usuario usuario = new Usuario();
			usuario.setLogin(rset.getString("login"));
			usuario.setSenha(rset.getString("senha"));
			return usuario;
		}
		return null;
	}
	
	

}
