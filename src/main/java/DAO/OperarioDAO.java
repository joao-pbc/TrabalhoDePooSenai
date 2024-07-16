package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Conexao.Conexao;
import Modelo.Operario;

public class OperarioDAO {

	public void cadastrarOperario(Operario operario) {
		String sql = "INSERT INTO Operarios " +
                "(Nome, TipoDePessoa, Documento, Endereco, ComplementoEndereco, " +
                "Bairro, CEP, Cidade, Estado, Telefone, CodigoSetor, DataAdmissao, " +
                "DataDesligamento, SalarioBruto, PercentualImpostos, SalarioLiquidoCalculado, " +
                "DataCalculoSalario, ValorMinimoGatilho, PercentualComissao, ProducaoMensal, InformouProducaoMensal) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = null;
		Connection conn = null;

		try {
			conn = Conexao.getConexao();

			ps = conn.prepareStatement(sql);
            ps.setString(1, operario.getNome());
            ps.setString(2, operario.getTipoPessoa().name());
            ps.setString(3, operario.getDocumento());
            ps.setString(4, operario.getEndereco());
            ps.setString(5, operario.getComplementoEndereco());
            ps.setString(6, operario.getBairro());
            ps.setString(7, operario.getCEP());
            ps.setString(8, operario.getCidade());
            ps.setString(9, operario.getEstado().name());
            ps.setString(10, operario.getTelefone());
            ps.setInt(11, operario.getCodigoSetor());
            ps.setObject(12, operario.getDataAdmissao());
            ps.setObject(13, operario.getDataDesligamento());
            ps.setDouble(14, operario.getSalarioBruto());
            ps.setDouble(15, operario.getPercentualImpostos());
            ps.setDouble(16, operario.getSalarioLiquidoCalculado());
            ps.setObject(17, operario.getDataCalculoSalario());
			ps.setDouble(18, operario.getValorMinimoGatilho());
			ps.setDouble(19, operario.getPercentualComissao());
			ps.setDouble(20, operario.getProducaoMensal());
			ps.setBoolean(21, operario.isInformouProducaoMensal());

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
