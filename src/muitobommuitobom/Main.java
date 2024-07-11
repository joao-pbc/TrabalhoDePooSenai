package muitobommuitobom;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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
                    String dataAdmissaoStr = scan.nextLine();
                    operario.dataAdmissao = LocalDate.parse(dataAdmissaoStr);

                    System.out.println("Digite a data de desligamento (AAAA-MM-DD, deixe em branco se não houver):");
                    String dataDesligamentoStr = scan.nextLine();
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
                    String dataCalculoSalarioStr = scan.nextLine();
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

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("insira uma opcao valida");

            }
        }


    }
}
