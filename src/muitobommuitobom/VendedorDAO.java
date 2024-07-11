package muitobommuitobom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VendedorDAO {

    public void cadastrarVendedor(Vendedor vendedor, Connection connection) {
        String sql = "INSERT INTO vendedor " +
                "(codigoSetor, dataAdmissao, dataDesligamento, salarioBruto, percentualImpostos, " +
                "salarioLiquidoCalculado, dataCalculoSalario, Nome, TipoPessoa, Documento, " +
                "Endereco, ComplementoEndereco, Bairro, CEP, Cidade, Estado, Telefone, " +
                "valorMinimoBonus, percentualPremiacao, vendasMes, vendasUltimoMes, " +
                "vendasPenultimoMes, informouVendasMes) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;

        try {

            ps = connection.prepareStatement(sql);
            ps.setInt(1, vendedor.getCodigoSetor());
            ps.setObject(2, vendedor.getDataAdmissao());
            ps.setObject(3, vendedor.getDataDesligamento());
            ps.setDouble(4, vendedor.getSalarioBruto());
            ps.setDouble(5, vendedor.getPercentualImpostos());
            ps.setDouble(6, vendedor.getSalarioLiquidoCalculado());
            ps.setObject(7, vendedor.getDataCalculoSalario());
            ps.setString(8, vendedor.getNome());
            ps.setString(9, vendedor.getTipoPessoa().name());
            ps.setString(10, vendedor.getDocumento());
            ps.setString(11, vendedor.getEndereco());
            ps.setString(12, vendedor.getComplementoEndereco());
            ps.setString(13, vendedor.getBairro());
            ps.setString(14, vendedor.getCEP());
            ps.setString(15, vendedor.getCidade());
            ps.setString(16, vendedor.getEstado().name());
            ps.setString(17, vendedor.getTelefone());
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
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
