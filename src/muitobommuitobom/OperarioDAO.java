package muitobommuitobom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperarioDAO {
    public void cadastrarOperario(Operario operario, Connection connection) {
        String sql = "INSERT INTO operario " +
                "(codigoSetor, dataAdmissao, dataDesligamento, salarioBruto, percentualImpostos, " +
                "salarioLiquidoCalculado, dataCalculoSalario, Nome, TipoPessoa, Documento, " +
                "Endereco, ComplementoEndereco, Bairro, CEP, Cidade, Estado, Telefone, " +
                "valorMinimoGatilho, percentualComissao, producaoMensal, informouProducaoMensal) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;

        try {

            ps = connection.prepareStatement(sql);
            ps.setInt(1, operario.getCodigoSetor());
            ps.setObject(2, operario.getDataAdmissao());
            ps.setObject(3, operario.getDataDesligamento());
            ps.setDouble(4, operario.getSalarioBruto());
            ps.setDouble(5, operario.getPercentualImpostos());
            ps.setDouble(6, operario.getSalarioLiquidoCalculado());
            ps.setObject(7, operario.getDataCalculoSalario());
            ps.setString(8, operario.getNome());
            ps.setString(9, operario.getTipoPessoa().name());
            ps.setString(10, operario.getDocumento());
            ps.setString(11, operario.getEndereco());
            ps.setString(12, operario.getComplementoEndereco());
            ps.setString(13, operario.getBairro());
            ps.setString(14, operario.getCEP());
            ps.setString(15, operario.getCidade());
            ps.setString(16, operario.getEstado().name());
            ps.setString(17, operario.getTelefone());
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
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
