package dao_sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javaDB_conectaBanco.ConexaoBanco;
import modelo_classesBase.Senha;

public class MedicoS {
	
private Connection con;
	public MedicoS() throws SQLException{ 
		this.con =  ConexaoBanco.getConnection();
	}
	
	public boolean getMedicobyId(int id) throws SQLException {
		String sql = "SELECT * FROM medico WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rset = stmt.executeQuery();
		
		if (rset.next()) {
			return true;
		}
		return false;
	}
}