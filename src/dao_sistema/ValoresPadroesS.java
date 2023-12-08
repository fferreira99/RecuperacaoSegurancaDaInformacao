package dao_sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javaDB_conectaBanco.ConexaoBanco;
import modelo_classesBase.ProteinaTotal;
import seguranca.Hash;

public class ValoresPadroesS {
	
private Connection con;
	
	public ValoresPadroesS() throws SQLException{
		this.con =  ConexaoBanco.getConnection();
	}
	
	public void adiciona( double limiteInferior, double limiteSuperior, 
			String unidade, String valorReferencia) throws SQLException {
		
		String sql = "INSERT INTO valorespadroes (limite_inferior,limite_superior,"
				+ "unidade, valor_referencia) VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setDouble(1,limiteInferior);
		stmt.setDouble(2,limiteSuperior);
		stmt.setString(3, unidade);
		stmt.setString(4, valorReferencia);
		stmt.execute();
		stmt.close();
		con.close();
	}
}
