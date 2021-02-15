package javau;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {

    ArrayList<Cliente> clientes = new ArrayList<>();

    public Banco() {

        Scanner s = new Scanner(System.in);
        int escolha;

        do {

            System.out.println("|------------------------------------------------|");
            System.out.println("|         ESCOLHA UMA OPERACAO A SER FEITA       |");
            System.out.println("|------------------------------------------------|");
            System.out.println("|1.CADASTRAR                                     |");
            System.out.println("|2.MOSTRAR CLIENTES                              |");
            System.out.println("|3.MOSTRAR CONTAS                                |");
            System.out.println("|------------------------------------------------|");
            System.out.println("|               AREA DO CLIENTE                  |");
            System.out.println("|------------------------------------------------|");
            System.out.println("|4.DEPOSITO                                      |");
            System.out.println("|5.TRANSFERENCIA                                 |");
            System.out.println("|6.SAQUE                                         |");
            System.out.println("|0.SAIR                                          |");
            System.out.println("|------------------------------------------------|");
            escolha = s.nextInt();

            switch (escolha) {

                case 1 -> {
                    Cliente novoCliente = new Cliente ();

                    System.out.println("|----------PREECHA OS DADOS DO CLIENTE-----------|");
                    System.out.println("|NOME: ");
                    String nome = s.nextLine();
                    s.nextLine();
                    System.out.println("|CPF: ");
                    String cpf = s.next();
                    System.out.println("|IDADE: ");
                    int idade = s.nextInt();
                    System.out.println("|SEXO: ");
                    char sexo = s.next().charAt(0);

                    novoCliente.setNome(nome);
                    novoCliente.setIdade(idade);
                    novoCliente.setSexo(sexo);
                    novoCliente.setCpf(cpf);

                    System.out.println("|---------------------CONTATO--------------------|");

                    System.out.println("|E-MAIL: ");
                    String email = s.next();
                    System.out.println("|TELEFONE: ");
                    String telefone = s.next();
                    System.out.println("|CELULAR: ");
                    String celular = s.next();
                    s.nextLine();

                    novoCliente.setContato(email,telefone,celular);

                    System.out.println("|-------------------ENDERECO---------------------|");

                    System.out.println("|CIDADE: ");
                    String cidade = s.nextLine();
                    System.out.println("|BAIRRO: ");
                    String bairro = s.nextLine();
                    System.out.println("|RUA: ");
                    String rua = s.nextLine();
                    System.out.println("|NUMERO DA RESIDENCIA: ");
                    int numero = s.nextInt();

                    novoCliente.setEndereco(cidade, bairro, rua, numero);

                    System.out.println("|------------------DADOS DA CONTA----------------|");
                    System.out.println("|AGENCIA: ");
                    int agencia = s.nextInt();
                    System.out.println("|CONTA: ");
                    int conta = s.nextInt();
                    s.nextLine();
                    System.out.println("|SALDO: ");
                    double saldo = s.nextDouble();

                    novoCliente.setConta(agencia, conta, saldo);
                    
                    clientes.add(novoCliente);
                }

                case 2 -> {
                    if (clientes.size() > 0) {
                        System.out.println("CLIENTES CADASTRADOS");
                        for (int i=0; i < clientes.size(); i++) {
                            System.out.println("|------------------------------------------------|");
                            System.out.println("|NOME: " +clientes.get(i).getNome());
                            System.out.println("|CPF: " +clientes.get(i).getCpf());
                            System.out.println("|------------------------------------------------|");
                        }
                    } else {
                        System.out.println("NENHUM CLIENTE CADASTRADO");
                    }
                }

                case 3 -> {
                    System.out.println("INSIRA O CPF DO CLIENTE QUE DESEJA ACESSAR A CONTA: ");
                    String buscaCpf = s.next();
                    for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i).getCpf().equals(buscaCpf)) {
                            System.out.println("AGENCIA: " + clientes.get(i).getConta().getAgencia());
                            System.out.println("CONTA: " + clientes.get(i).getConta().getConta());
                            System.out.println("SALDO: " + clientes.get(i).getConta().getSaldo());
                            
                        } 
                    }
                }

                case 4 -> {
                    System.out.println("CPF DO DESTINATARIO: ");
                    String cpfDestinatario = s.next();
                    System.out.println("VALOR DO DEPOSITO: ");
                    double deposito = s.nextDouble();
                    for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i).getCpf().equals(cpfDestinatario)) {
                            double saldoAtual = clientes.get(i).getConta().getSaldo() + deposito;
                            clientes.get(i).getConta().setSaldo(+saldoAtual);
                            
                        }
                    }
                }

                case 5 -> {
                    System.out.println("INSIRA SEU CPF: ");
                    String cpfTransferencia = s.next();
                    for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i).getCpf().equals(cpfTransferencia)){
                            System.out.println("SALDO EM CONTA: "+clientes.get(i).getConta().getSaldo());
                            System.out.print("VALOR DA TRANSFERENCIA: ");
                            double valorTransferencia = s.nextDouble();
                            System.out.println("CPF DO BENEFICIARIO: ");
                            String cpfBeneficiario = s.next();
                            double saldoAtual = clientes.get(i).getConta().getSaldo() - valorTransferencia;
                            clientes.get(i).getConta().setSaldo(+saldoAtual);
                            System.out.println("NOVO SALDO EM CONTA: "+clientes.get(i).getConta().getSaldo());
                            
                            
                            for (int ind = 0; ind < clientes.size(); ind++){
                                if (clientes.get(ind).getCpf().equals(cpfBeneficiario)) {
                                    double saldoAtualBeneficario = clientes.get(ind).getConta().getSaldo() + valorTransferencia;
                                    clientes.get(ind).getConta().setSaldo(+saldoAtualBeneficario);
                                    
                                }
                            }
                        }
                    }               }

                case 6 -> {
                    System.out.println("CPF DO CLIENTE PARA REALIZAR SAQUE: ");
                    String cpfSaque = s.next();
                    for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i).getCpf().equals(cpfSaque)) {
                            System.out.println("SALDO EM CONTA: "+clientes.get(i).getConta().getSaldo());
                            System.out.print("VALOR DO SAQUE: ");
                            double valorSaque = s.nextDouble();
                            double saldoAtual = clientes.get(i).getConta().getSaldo() - valorSaque;
                            clientes.get(i).getConta().setSaldo(+saldoAtual);    
                            System.out.println("NOVO SALDO EM CONTA: "+clientes.get(i).getConta().getSaldo());
                        }
                    }
                }

                default -> {
                    if (escolha > 6 || escolha < 0) {
                        System.out.println("OPCAO INVALIDA");

                    }
                }
            }

        } while (escolha != 0);

    }
}
