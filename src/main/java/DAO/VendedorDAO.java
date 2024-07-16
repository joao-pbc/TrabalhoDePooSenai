package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Conexao.Conexao;
import Modelo.Vendedor;

public class VendedorDAO {

	public void cadastrarVendedor(Vendedor vendedor) {
		String sql = "INSERT INTO Vendedores " +
                "(Nome, TipoDePessoa, Documento, Endereco, ComplementoEndereco, " +
                "Bairro, CEP, Cidade, Estado, Telefone, CodigoSetor, DataAdmissao, " +
                "DataDesligamento, SalarioBruto, PercentualImpostos, SalarioLiquidoCalculado, " +
                "DataCalculoSalario, valorMinimoBonus, percentualPremiacao, vendasMes, vendasUltimoMes, vendasPenultimoMes, informouVendasMes) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = null;
		Connection conn = null;

		try {
			conn = Conexao.getConexao();


			ps = conn.prepareStatement(sql);
            ps.setString(1, vendedor.getNome());
            ps.setString(2, vendedor.getTipoPessoa().name());
            ps.setString(3, vendedor.getDocumento());
            ps.setString(4, vendedor.getEndereco());
            ps.setString(5, vendedor.getComplementoEndereco());
            ps.setString(6, vendedor.getBairro());
            ps.setString(7, vendedor.getCEP());
            ps.setString(8, vendedor.getCidade());
            ps.setString(9, vendedor.getEstado().name());
            ps.setString(10, vendedor.getTelefone());
            ps.setInt(11, vendedor.getCodigoSetor());
            ps.setObject(12, vendedor.getDataAdmissao());
            ps.setObject(13, vendedor.getDataDesligamento());
            ps.setDouble(14, vendedor.getSalarioBruto());
            ps.setDouble(15, vendedor.getPercentualImpostos());
            ps.setDouble(16, vendedor.getSalarioLiquidoCalculado());
            ps.setObject(17, vendedor.getDataCalculoSalario());
			ps.setDouble(18, vendedor.getValorMinimoBonus());
			ps.setDouble(19, vendedor.getPercentualPremiacao());
			ps.setDouble(20, vendedor.getVendasMes());
			ps.setDouble(21, vendedor.getVendasUltimoMes());
			ps.setDouble(22, vendedor.getVendasPenultimoMes());
			ps.setBoolean(23, vendedor.isInformouVendasMes());
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
