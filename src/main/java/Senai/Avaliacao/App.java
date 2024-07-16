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
        while(menuAPP!=5) {

            System.out.println(
                    "Menu" +
                            "1 - Criar_Usuario "+
                            "0 - Sair"
            );

            menuAPP = scanner.nextInt();

            switch (menuAPP){
                case 1:
                    while(menuAPP!=0){
                        System.out.println(
                                "Menu/Criar_Usuário"+
                                        "1 - Vendedor"+
                                        "2 - Operario"+
                                        "3 - Administrativo"+
                                        "0 - Sair"
                        );
                        menuAPP = scanner.nextInt();

                        switch (menuAPP){
                            case 1:
                                CadastrarVendedor();

                        }
                    }



        }


    }
    }

    public static void CadastrarVendedor(){

        VendedorDAO insereV = new VendedorDAO();


        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o tipo de pessoa (PessoaFisica/PessoaJuridica): ");
        TpPessoa tipoPessoa = TpPessoa.valueOf(scanner.nextLine());

        System.out.print("Digite o CNPJ: ");
        String documento = scanner.nextLine();


        System.out.print("Digite o endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Digite o complemento do endereço: ");
        String complementoEndereco = scanner.nextLine();

        System.out.print("Digite o bairro: ");
        String bairro = scanner.nextLine();

        System.out.print("Digite o CEP: ");
        String CEP = scanner.nextLine();

        System.out.print("Digite a cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Digite o estado (sigla): ");
        Estado estado = Estado.valueOf(scanner.nextLine());

        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();


        System.out.print("Digite o DDD: (00)");
        String DDD = scanner.nextLine();

        System.out.print("Digite a comissão: ");
        double comissao = scanner.nextDouble();

        System.out.print("Digite a data de contratação (yyyy-MM-ddT00:00:00.000): ");
        LocalDate dataAdmissao = LocalDate.now();

        System.out.print("Digite a data de desligamento (yyyy-MM-ddT00:00:00.000): ");
        LocalDate dataDesligamento = LocalDate.now();

        System.out.print("Digite o salário: ");
        double salarioBruto = scanner.nextDouble();

        System.out.print("Digite o codigo do Setor: ");
        int codigoSetor = scanner.nextInt();

        System.out.print("Digite o percentual de imposto: ");
        double percentualImpostos = scanner.nextDouble();

        System.out.print("Digite o percentual de imposto: ");
        double valorMinimoBonus = scanner.nextDouble();

        System.out.print("Digite o percentual de imposto: ");
        double percentualPremiacao = scanner.nextDouble();


        Vendedor  christian = new Vendedor(nome, tipoPessoa, documento, endereco, complementoEndereco, bairro, CEP, cidade, estado,DDD, telefone, codigoSetor, salarioBruto, dataAdmissao, dataDesligamento, percentualImpostos,valorMinimoBonus,percentualPremiacao);


       /*Vendedor christian = new Vendedor("Christian",TpPessoa.PessoaJuridica,"22.209.954/0001-41","MynhaCasa", "Rui Barbosa", "Progresso", "89026600", "Blumenau", Estado.SC, "47", "988264845",12,1.234, LocalDate.now(),LocalDate.now(),8.00,2.00,1.234);

        */
       insereV.cadastrarVendedor(christian);

    }




}
