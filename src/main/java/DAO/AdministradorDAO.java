package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Conexao.Conexao;
import Modelo.Administrativo;

public class AdministradorDAO {
	
	public void cadastrarAdministrativo(Administrativo administrativo ) {
		
		String sql = "INSERT INTO administrativos " +
                "(Nome, TipoDePessoa, Documento, Endereco, ComplementoEndereco, " +
                "Bairro, CEP, Cidade, Estado, Telefone, CodigoSetor, DataAdmissao, " +
                "DataDesligamento, SalarioBruto, PercentualImpostos, SalarioLiquidoCalculado, " +
                "DataCalculoSalario, AjudaCusto) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = null;
   		Connection conn = null;
   		try {
            conn = Conexao.getConexao(); 

            ps = conn.prepareStatement(sql);

            ps.setString(1, administrativo.getNome());
            ps.setString(2, administrativo.getTipoPessoa().name());
            ps.setString(3, administrativo.getDocumento());
            ps.setString(4, administrativo.getEndereco());
            ps.setString(5, administrativo.getComplementoEndereco());
            ps.setString(6, administrativo.getBairro());
            ps.setString(7, administrativo.getCEP());
            ps.setString(8, administrativo.getCidade());
            ps.setString(9, administrativo.getEstado().name());
            ps.setString(10, administrativo.getTelefone());
            ps.setInt(11, administrativo.getCodigoSetor());
            ps.setObject(12, administrativo.getDataAdmissao());
            ps.setObject(13, administrativo.getDataDesligamento());
            ps.setDouble(14, administrativo.getSalarioBruto());
            ps.setDouble(15, administrativo.getPercentualImpostos());
            ps.setDouble(16, administrativo.getSalarioLiquidoCalculado());
            ps.setObject(17, administrativo.getDataCalculoSalario());
            ps.setDouble(18, administrativo.getAjudaCusto());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
	}

}
	
}
