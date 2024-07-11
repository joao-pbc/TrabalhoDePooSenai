package muitobommuitobom;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String dataAdmissaoStr;

        String dataDesligamentoStr;

        String dataCalculoSalarioStr;

        int opcao = -1;
        Scanner scan = new Scanner(System.in);

        while(true){

            System.out.println(
                """
                insira as opcoes desejadas:
                
                1. criar operario
                2. criar vendedor
                3. criar administrador
                0. encerrar
                """
            );
            opcao = scan.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Digite o código do setor:");
                    Operario operario = new Operario();

                    operario.codigoSetor = scan.nextInt();
                    scan.nextLine(); // Consumir a quebra de linha após o nextInt()

                    System.out.println("Digite a data de admissão (AAAA-MM-DD):");
                    dataAdmissaoStr = scan.nextLine();
                    operario.dataAdmissao = LocalDate.parse(dataAdmissaoStr);

                    System.out.println("Digite a data de desligamento (AAAA-MM-DD, deixe em branco se não houver):");
                    dataDesligamentoStr = scan.nextLine();
                    if (!dataDesligamentoStr.isEmpty()) {
                        operario.dataDesligamento = LocalDate.parse(dataDesligamentoStr);
                    }

                    System.out.println("Digite o salário bruto:");
                    operario.salarioBruto = scan.nextDouble();
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Digite o percentual de impostos:");
                    operario.percentualImpostos = scan.nextDouble();
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Digite o salário líquido calculado:");
                    operario.salarioLiquidoCalculado = scan.nextDouble();
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Digite a data do cálculo do salário (AAAA-MM-DD HH:mm:ss):");
                    dataCalculoSalarioStr = scan.nextLine();
                    operario.dataCalculoSalario = LocalDateTime.parse(dataCalculoSalarioStr);

                    System.out.println("Digite o ID:");
                    operario.setID(scan.nextInt());
                    scan.nextLine(); // Consumir a quebra de linha após o nextInt()

                    System.out.println("Digite o nome:");
                    operario.setNome(scan.nextLine());

                    System.out.println("Digite o tipo de pessoa:");
                    operario.setTipoPessoa(TipoPessoa.valueOf(scan.next()));

                    System.out.println("Digite o documento:");
                    operario.setDocumento(scan.nextLine());

                    System.out.println("Digite o endereço:");
                    operario.setEndereco(scan.nextLine());

                    System.out.println("Digite o complemento do endereço:");
                    operario.setComplementoEndereco(scan.nextLine());

                    System.out.println("Digite o bairro:");
                    operario.setBairro(scan.nextLine());

                    System.out.println("Digite o CEP:");
                    operario.setCEP(scan.nextLine());

                    System.out.println("Digite a cidade:");
                    operario.setCidade(scan.nextLine());

                    System.out.println("Digite o estado:");
                    operario.setEstado(Estado.valueOf(scan.nextLine()));

                    System.out.println("Digite o telefone:");
                    operario.setTelefone(scan.nextLine());

                    System.out.println("Digite o valor mínimo de gatilho:");
                    operario.valorMinimoGatilho = scan.nextDouble();
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Digite o percentual de comissão:");
                    operario.percentualComissao = scan.nextDouble();
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Digite a produção mensal:");
                    operario.producaoMensal = scan.nextDouble();
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Informou a produção mensal? (true/false):");
                    operario.informouProducaoMensal = scan.nextBoolean();
                    scan.nextLine(); // Consumir a quebra de linha após o nextBoolean()
                    scan.close();

                    OperarioDAO dao = new OperarioDAO();
                    dao.cadastrarOperario(operario, BancoDeDadosManager.getConexao());

                    break;
                case 2:
                    System.out.println("Digite o código do setor:");
                    Vendedor ve = new Vendedor();
                    ve.codigoSetor = scan.nextInt();
                    scan.nextLine(); // Consumir a quebra de linha após o nextInt()

                    System.out.println("Digite a data de admissão (AAAA-MM-DD):");
                    dataAdmissaoStr = scan.nextLine();
                    ve.dataAdmissao = LocalDate.parse(dataAdmissaoStr);

                    System.out.println("Digite a data de desligamento (AAAA-MM-DD, deixe em branco se não houver):");
                    dataDesligamentoStr = scan.nextLine();
                    if (!dataDesligamentoStr.isEmpty()) {
                        ve.dataDesligamento = LocalDate.parse(dataDesligamentoStr);
                    }

                    System.out.println("Digite o salário bruto:");
                    ve.salarioBruto = scan.nextDouble();
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Digite o percentual de impostos:");
                    ve.percentualImpostos = scan.nextDouble();
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Digite o salário líquido calculado:");
                    ve.salarioLiquidoCalculado = scan.nextDouble();
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Digite a data do cálculo do salário (AAAA-MM-DD):");
                    dataCalculoSalarioStr = scan.nextLine();
                    ve.dataCalculoSalario = LocalDateTime.parse(dataCalculoSalarioStr);

                    System.out.println("Digite o ID:");
                    ve.setID(scan.nextInt());
                    scan.nextLine(); // Consumir a quebra de linha após o nextInt()

                    System.out.println("Digite o nome:");
                    ve.setNome(scan.nextLine());

                    System.out.println("Digite o tipo de pessoa:");
                    ve.setTipoPessoa(TipoPessoa.valueOf(scan.nextLine()));

                    System.out.println("Digite o documento:");
                    ve.setDocumento(scan.nextLine());

                    System.out.println("Digite o endereço:");
                    ve.setEndereco(scan.nextLine());

                    System.out.println("Digite o complemento do endereço:");
                    ve.setComplementoEndereco(scan.nextLine());

                    System.out.println("Digite o bairro:");
                    ve.setBairro(scan.nextLine());

                    System.out.println("Digite o CEP:");
                    ve.setCEP(scan.nextLine());

                    System.out.println("Digite a cidade:");
                    ve.setCidade(scan.nextLine());

                    System.out.println("Digite o estado:");
                    ve.setEstado(Estado.valueOf(scan.nextLine()));

                    System.out.println("Digite o telefone:");
                    ve.setTelefone(scan.nextLine());

                    System.out.println("Digite o valor mínimo de bônus:");
                    ve.setValorMinimoBonus(scan.nextDouble());
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Digite o percentual de premiação:");
                    ve.setPercentualPremiacao(scan.nextDouble());
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Digite as vendas do mês:");
                    ve.setVendasMes(scan.nextDouble());
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Digite as vendas do último mês:");
                    ve.setVendasUltimoMes(scan.nextDouble());
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Digite as vendas do penúltimo mês:");
                    ve.setVendasPenultimoMes(scan.nextDouble());
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Informou as vendas deste mês? (true/false):");
                    ve.setInformouVendasMes(scan.nextBoolean());
                    scan.nextLine(); // Consumir a quebra de linha após o nextBoolean()

                    VendedorDAO daoVendedor = new VendedorDAO();
                    daoVendedor.cadastrarVendedor(ve, BancoDeDadosManager.getConexao());

                break;
                case 3:
                    System.out.println("Digite o ID:");
                    Administrativo adm = new Administrativo();
                    adm.setID(scan.nextInt());
                    scan.nextLine(); // Consumir a quebra de linha após o nextInt()

                    System.out.println("Digite o nome:");
                    adm.setNome(scan.nextLine());

                    System.out.println("Digite o tipo de pessoa:");
                    adm.setTipoPessoa(TipoPessoa.valueOf(scan.nextLine()));

                    System.out.println("Digite o documento:");
                    adm.setDocumento(scan.nextLine());

                    System.out.println("Digite o endereço:");
                    adm.setEndereco(scan.nextLine());

                    System.out.println("Digite o complemento do endereço:");
                    adm.setComplementoEndereco(scan.nextLine());

                    System.out.println("Digite o bairro:");
                    adm.setBairro(scan.nextLine());

                    System.out.println("Digite o CEP:");
                    adm.setCEP(scan.nextLine());

                    System.out.println("Digite a cidade:");
                    adm.setCidade(scan.nextLine());

                    System.out.println("Digite o estado:");
                    adm.setEstado(Estado.valueOf(scan.nextLine()));

                    System.out.println("Digite o telefone:");
                    adm.setTelefone(scan.nextLine());

                    System.out.println("Digite o código do setor:");
                    adm.codigoSetor = scan.nextInt();
                    scan.nextLine(); // Consumir a quebra de linha após o nextInt()

                    System.out.println("Digite a data de admissão (AAAA-MM-DD):");
                    dataAdmissaoStr = scan.nextLine();
                    adm.dataAdmissao = LocalDate.parse(dataAdmissaoStr);

                    System.out.println("Digite a data de desligamento (AAAA-MM-DD, deixe em branco se não houver):");
                    dataDesligamentoStr = scan.nextLine();
                    if (!dataDesligamentoStr.isEmpty()) {
                        adm.dataDesligamento = LocalDate.parse(dataDesligamentoStr);
                    }

                    System.out.println("Digite o salário bruto:");
                    adm.salarioBruto = scan.nextDouble();
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Digite o percentual de impostos:");
                    adm.percentualImpostos = scan.nextDouble();
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Digite o salário líquido calculado:");
                    adm.salarioLiquidoCalculado = scan.nextDouble();
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    System.out.println("Digite a data do cálculo do salário (AAAA-MM-DD:HH.MM.SS.MMM):");
                    dataCalculoSalarioStr = scan.nextLine();
                    adm.dataCalculoSalario = LocalDateTime.parse(dataCalculoSalarioStr);

                    System.out.println("Digite a ajuda de custo:");
                    adm.ajudaCusto = scan.nextDouble();
                    scan.nextLine(); // Consumir a quebra de linha após o nextDouble()

                    AdministrativosDAO administrativosDAO = new AdministrativosDAO();
                    administrativosDAO.cadastrarAdministrativo(adm, BancoDeDadosManager.getConexao());
                    break;

                case 0:
                    return;

                default:
                    System.out.println("insira uma opcao valida");

            }
        }


    }
}
