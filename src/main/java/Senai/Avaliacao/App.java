package Senai.Avaliacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import Enum.Estado;
import Enum.TpPessoa;
import Modelo.Administrativo;
import DAO.*;
import Modelo.Operario;
import Modelo.Vendedor;

public class App
{

    public static void main( String[] args )
    {

        Scanner scanner = new Scanner(System.in);

        int menuAPP = 0;
        
       /*AdministradorDAO insere = new AdministradorDAO();
        
       Administrativo joao = new Administrativo("Joao D", TpPessoa.PessoaJuridica,"22.209.954/0001-41" , "Casas", "aptsssss 12", "Garcsssssia", "89012134", "Blumenau", Estado.SC, "47", "99995566", 12,1900.00,LocalDate.now(),LocalDate.now(),8.00,9.00);
       
       insere.cadastrarAdministrativo(joao);
*/
       /*VendedorDAO insereV = new VendedorDAO();

       Vendedor christian = new Vendedor("Christian",TpPessoa.PessoaJuridica,"22.209.954/0001-41","MynhaCasa", "Rui Barbosa", "Progresso", "89026600", "Blumenau", Estado.SC, "47", "988264845",12,1.234, LocalDate.now(),LocalDate.now(),8.00,2.00,1.234);

       insereV.cadastrarVendedor(christian);*/


        /*OperarioDAO insereO = new OperarioDAO();

        Operario Bove = new Operario("J.Bove",TpPessoa.PessoaJuridica,"22.209.954/0001-41","CasaDele", "DoladoDoVizinhoDele","Progresso","89045500","Blumenau",Estado.SC,"47","988274845",12,1.234,LocalDate.now(),LocalDate.now(),2.00,8.00,1.234,2.123,true);

        insereO.cadastrarOperario(Bove);*/
        while(true) {

            System.out.println(
                    "Menu" +
                            "1 - Criar_Usuario "+
                            "0 - Sair"
            );

            menuAPP = scanner.nextInt();

            if (menuAPP == 1) {
                while (true) {
                    System.out.println(
                            "Menu/Criar_Usuário" +
                                    "1 - Vendedor" +
                                    "2 - Operario" +
                                    "3 - Administrativo" +
                                    "0 - Sair"
                    );
                    menuAPP = scanner.nextInt();

                    switch (menuAPP) {
                        case 1:
                            CadastrarVendedor();
                            break;
                        case 2:
                            CadastrarOperario();
                            break;
                        case 3:
                            CadastrarAdministrador();
                            break;
                        case 0:
                            return;

                    }
                }
            } else if (menuAPP == 0){
                return;
            }


    }
    }

    public static void CadastrarVendedor(){

        VendedorDAO insereV = new VendedorDAO();

        Vendedor  christian = new Vendedor();


        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome: ");
         christian.setNome(scanner.nextLine());

        System.out.print("Digite o tipo de pessoa (PessoaFisica/PessoaJuridica): ");
         christian.setTipoPessoa(TpPessoa.valueOf(scanner.nextLine()));

        System.out.print("Digite o CNPJ: ");
         christian.setDocumento(scanner.nextLine());

        System.out.print("Digite o endereço: ");
         christian.setEndereco(scanner.nextLine());

        System.out.print("Digite o complemento do endereço: ");
        christian.setComplementoEndereco(scanner.nextLine());

        System.out.print("Digite o bairro: ");
        christian.setBairro(scanner.nextLine());

        System.out.print("Digite o CEP: ");
        christian.setCEP(scanner.nextLine());

        System.out.print("Digite a cidade: ");
        christian.setCidade(scanner.nextLine());

        System.out.print("Digite o estado (sigla): ");
        christian.setEstado(Estado.valueOf(scanner.nextLine()));

        System.out.print("Digite o DDD: (00)");
        String ddd = scanner.nextLine();

        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();

        christian.setTelefone(ddd, telefone);
        christian.setDataAdmissao(LocalDate.now());
        christian.setDataDesligamento(LocalDate.now());

        System.out.print("Digite o salário: ");
        christian.setSalarioBruto(scanner.nextDouble());

        System.out.print("Digite o codigo do Setor: ");
         christian.setCodigoSetor(scanner.nextInt());

        System.out.print("Digite o percentual de imposto: ");
        christian.setPercentualImpostos(scanner.nextDouble());

        System.out.print("Digite o percentual de imposto: ");
        christian.setPercentualPremiacao(scanner.nextDouble());

        System.out.print("Digite o percentual de imposto: ");
        christian.setValorMinimoBonus(scanner.nextDouble());
        christian.calcularSalarioLiquido(christian.getSalarioBruto(), christian.getPercentualImpostos());

       insereV.cadastrarVendedor(christian);

    }

    public static void CadastrarOperario(){

        OperarioDAO insereV = new OperarioDAO();

        Operario  christian = new Operario();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        christian.setNome(scanner.nextLine());

        System.out.print("Digite o tipo de pessoa (PessoaFisica/PessoaJuridica): ");
        christian.setTipoPessoa(TpPessoa.valueOf(scanner.nextLine()));

        System.out.print("Digite o CNPJ: ");
        christian.setDocumento(scanner.nextLine());

        System.out.print("Digite o endereço: ");
        christian.setEndereco(scanner.nextLine());

        System.out.print("Digite o complemento do endereço: ");
        christian.setComplementoEndereco(scanner.nextLine());

        System.out.print("Digite o bairro: ");
        christian.setBairro(scanner.nextLine());

        System.out.print("Digite o CEP: ");
        christian.setCEP(scanner.nextLine());

        System.out.print("Digite a cidade: ");
        christian.setCidade(scanner.nextLine());

        System.out.print("Digite o estado (sigla): ");
        christian.setEstado(Estado.valueOf(scanner.nextLine()));

        System.out.print("Digite o DDD: (00)");
        String ddd = scanner.nextLine();

        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();

        christian.setTelefone(ddd, telefone);
        christian.setDataAdmissao(LocalDate.now());
        christian.setDataDesligamento(LocalDate.now());

        System.out.print("Digite o salário: ");
        christian.setSalarioBruto(scanner.nextDouble());

        System.out.print("Digite o codigo do Setor: ");
        christian.setCodigoSetor(scanner.nextInt());

        System.out.print("Digite o percentual de imposto: ");
        christian.setPercentualImpostos(scanner.nextDouble());

        System.out.print("Digite o percentual de imposto: ");
        christian.setPercentualImpostos(scanner.nextDouble());

        System.out.print("Digite o percentual de imposto: ");
        christian.setPercentualComissao(scanner.nextDouble());

        System.out.print("Digite o percentual de imposto: ");
        christian.setValorMinimoGatilho(scanner.nextDouble());

        christian.calcularSalarioLiquido(christian.getSalarioBruto(), christian.getPercentualImpostos());

        insereV.cadastrarOperario(christian);

    }

    public static void CadastrarAdministrador(){

        AdministradorDAO insereV = new AdministradorDAO();

        Administrativo  christian = new Administrativo();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        christian.setNome(scanner.nextLine());

        System.out.print("Digite o tipo de pessoa (PessoaFisica/PessoaJuridica): ");
        christian.setTipoPessoa(TpPessoa.valueOf(scanner.nextLine()));

        System.out.print("Digite o CNPJ: ");
        christian.setDocumento(scanner.nextLine());

        System.out.print("Digite o endereço: ");
        christian.setEndereco(scanner.nextLine());

        System.out.print("Digite o complemento do endereço: ");
        christian.setComplementoEndereco(scanner.nextLine());

        System.out.print("Digite o bairro: ");
        christian.setBairro(scanner.nextLine());

        System.out.print("Digite o CEP: ");
        christian.setCEP(scanner.nextLine());

        System.out.print("Digite a cidade: ");
        christian.setCidade(scanner.nextLine());

        System.out.print("Digite o estado (sigla): ");
        christian.setEstado(Estado.valueOf(scanner.nextLine()));

        System.out.print("Digite o DDD: (00)");
        String ddd = scanner.nextLine();

        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();

        christian.setTelefone(ddd, telefone);
        christian.setDataAdmissao(LocalDate.now());
        christian.setDataDesligamento(LocalDate.now());

        System.out.print("Digite o salário: ");
        christian.setSalarioBruto(scanner.nextDouble());

        System.out.print("Digite o codigo do Setor: ");
        christian.setCodigoSetor(scanner.nextInt());

        System.out.print("Digite o percentual de imposto: ");
        christian.setPercentualImpostos(scanner.nextDouble());

        System.out.print("Digite o percentual de imposto: ");
        christian.setPercentualImpostos(scanner.nextDouble());

        System.out.print("Digite o percentual de imposto: ");
        christian.setAjudaCusto(scanner.nextDouble());

        christian.calcularSalarioLiquido(christian.getSalarioBruto(), christian.getPercentualImpostos());

        insereV.cadastrarAdministrativo(christian);

    }




}
