package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Conexao.Conexao;
import Modelo.Operario;

public class OperarioDAO {

	public void cadastrarOperario(Operario operario) {
		String sql = "INSERT INTO Operarios " +
                "(ID, Nome, TipoDePessoa, Documento, Endereco, ComplementoEndereco, " +
                "Bairro, CEP, Cidade, Estado, Telefone, CodigoSetor, DataAdmissao, " +
                "DataDesligamento, SalarioBruto, PercentualImpostos, SalarioLiquidoCalculado, " +
                "DataCalculoSalario, ValorMinimoGatilho, PercentualComissao, ProducaoMensal, InformouProducaoMensal) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = null;
		Connection conn = null;

		try {
			conn = Conexao.getConexao();

			ps = conn.prepareStatement(sql);
			ps.setInt(1,operario.getID());
            ps.setString(2, operario.getNome());
            ps.setString(3, operario.getTipoPessoa().name());
            ps.setString(4, operario.getDocumento());
            ps.setString(5, operario.getEndereco());
            ps.setString(6, operario.getComplementoEndereco());
            ps.setString(7, operario.getBairro());
            ps.setString(8, operario.getCEP());
            ps.setString(9, operario.getCidade());
            ps.setString(10, operario.getEstado().name());
            ps.setString(11, operario.getTelefone());
            ps.setInt(12, operario.getCodigoSetor());
            ps.setObject(13, operario.getDataAdmissao());
            ps.setObject(14, operario.getDataDesligamento());
            ps.setDouble(15, operario.getSalarioBruto());
            ps.setDouble(16, operario.getPercentualImpostos());
            ps.setDouble(17, operario.getSalarioLiquidoCalculado());
            ps.setObject(18, operario.getDataCalculoSalario());
			ps.setDouble(19, operario.getValorMinimoGatilho());
			ps.setDouble(20, operario.getPercentualComissao());
			ps.setDouble(21, operario.getProducaoMensal());
			ps.setBoolean(22, operario.isInformouProducaoMensal());

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
