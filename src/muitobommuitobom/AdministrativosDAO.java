package muitobommuitobom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdministrativosDAO {

    public void cadastrarAdministrativo(Administrativo administrativo, Connection connection) {
        String sql = "INSERT INTO administrativos " +
                "(ID, Nome, TipoDePessoa, Documento, Endereco, ComplementoEndereco, " +
                "Bairro, CEP, Cidade, Estado, Telefone, CodigoSetor, DataAdmissao, " +
                "DataDesligamento, SalarioBruto, PercentualImpostos, SalarioLiquidoCalculado, " +
                "DataCalculoSalario, AjudaCusto) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {

            ps = connection.prepareStatement(sql);
            ps.setInt(1, administrativo.getID());
            ps.setString(2, administrativo.getNome());
            ps.setString(3, administrativo.getTipoPessoa().name());
            ps.setString(4, administrativo.getDocumento());
            ps.setString(5, administrativo.getEndereco());
            ps.setString(6, administrativo.getComplementoEndereco());
            ps.setString(7, administrativo.getBairro());
            ps.setString(8, administrativo.getCEP());
            ps.setString(9, administrativo.getCidade());
            ps.setString(10, administrativo.getEstado().name());
            ps.setString(11, administrativo.getTelefone());
            ps.setInt(12, administrativo.getCodigoSetor());
            ps.setObject(13, administrativo.getDataAdmissao());
            ps.setObject(14, administrativo.getDataDesligamento());
            ps.setDouble(15, administrativo.getSalarioBruto());
            ps.setDouble(16, administrativo.getPercentualImpostos());
            ps.setDouble(17, administrativo.getSalarioLiquidoCalculado());
            ps.setObject(18, administrativo.getDataCalculoSalario());
            ps.setDouble(19, administrativo.getAjudaCusto());

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

