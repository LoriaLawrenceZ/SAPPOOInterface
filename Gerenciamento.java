import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Gerenciamento {
    Scanner sc = new Scanner(System.in, "latin1");

    private List<Conta> contas;
    private String escolha = "";
    private String numeroConta = "";
    private String nome = "";
    private String cpfCnpj = "";
    private double saque;
    private double deposito;
    private double emprestimo;
    private int tempo;

    public Gerenciamento() {
        contas = new ArrayList<>();
        PessoaJuridica contaOriginal = new PessoaJuridica("0", "Original", "123.456.789-12", 1000);
        contas.add(contaOriginal);
    }

    public void CriarConta() {
        System.out.println(
                "------------------------------------------------\n[A] - Pessoa Física | [B] - Pessoa Jurídica");
        escolha = sc.next().toLowerCase();

        while (!escolha.equalsIgnoreCase("A") & !escolha.equalsIgnoreCase("B")) {
            System.out.println("\nInsira um valor válido\n[A] - Pessoa Física | [B] - Pessoa Jurídica");
            escolha = sc.next().toLowerCase();
        }

        if (escolha.equalsIgnoreCase("A")) {
            numeroConta = String.valueOf(Integer.parseInt(contas.get(contas.size() - 1).getNumeroConta()) + 1);

            System.out.println("------------------------------\nNome:");
            nome = sc.next();

            System.out.println("------------------------------\nCPF:         [xxxxxxxxxxx]");
            cpfCnpj = sc.next();
            while (cpfCnpj.length() != 11) {
                System.out.println("Atente-se à escrita. O CPF é um documento de 11 números\nCPF:   [xxxxxxxxxxx]");
                cpfCnpj = sc.next();
            }

            for (Conta conta : contas) {
                if (cpfCnpj.equals(conta.cpfCnpj)) {
                    System.out.println(
                            "-----------------------------------------------------------------\nJá existe uma conta cadastrada nesse CPF\nInsira um novo CPF");
                    cpfCnpj = sc.next();

                    break;
                }
            }

            PessoaFisica conta = new PessoaFisica(numeroConta, nome, cpfCnpj, 100);

            contas.add(conta);

            System.out.println("Conta criada!\nNúmero da conta: " + conta.getNumeroConta());
        } else {
            numeroConta = String.valueOf(Integer.parseInt(contas.get(contas.size() - 1).getNumeroConta()) + 1);

            System.out.println("------------------------------\nNome:");
            nome = sc.next();

            System.out.println("------------------------------\nCNPJ:       [xxxxxxxx0001xx]");
            cpfCnpj = sc.next();
            while (cpfCnpj.length() != 15) {
                System.out.println("Atente-se à escrita. O CNPJ é um documento de 15 números\nCPF:  [xxxxxxxxx0001xx]");
                cpfCnpj = sc.next();
            }

            for (Conta conta : contas) {
                if (cpfCnpj.equals(conta.cpfCnpj)) {
                    System.out.println(
                            "-----------------------------------------------------------------\nJá existe uma conta cadastrada nesse CNPJ\nInsira um novo CNPJ");
                    cpfCnpj = sc.next();

                    break;
                }
            }

            PessoaJuridica conta = new PessoaJuridica(numeroConta, nome, cpfCnpj, 100);

            contas.add(conta);

            System.out.println("Conta criada!\nNúmero da conta: " + conta.getNumeroConta());
        }
    }

    public boolean Validacao(String login) {
        for (Conta conta : contas) {
            if (login.equals(conta.getCpfCnpj()) | login.equals(conta.getNumeroConta())) {
                return true;
            }
        }
        return false;
    }

    public void AcessarConta(Conta conta) {
        do {
            System.out.println(
                    "\n----------------------------------------------------------------------\n[1] - Saldo | [2] - Saque | [3] - Depósito | [4] - Empréstimo | [S] - Sair da Conta");
            escolha = sc.next().toLowerCase();

            switch (escolha) {
                case "1":
                    ExibirSaldo(conta);
                    break;
                case "2":
                    FazerSaque(conta);
                    break;
                case "3":
                    FazerDeposito(conta);
                    break;
                case "4":
                    FazerEmprestimo(conta);
                    break;
                case "s":
                    System.out.println("-----===SAINDO DA CONTA===-----");
                    escolha = "S";
                    break;
                default:
                    System.out.println("Insira um valor válido da próxima vez");
                    escolha = "";
                    break;
            }
        } while (!escolha.equalsIgnoreCase("S"));
    }

    public void ExibirSaldo(Conta conta) {
        System.out
                .println("\n------------------------------------------------------------------------------\nSaldo: R$ "
                        + conta.getSaldo());
    }

    public void FazerSaque(Conta conta) {
        System.out.println(
                "\n------------------------------------------------------------------------------\nSaldo:    R$"
                        + conta.getSaldo() + "\nQuanto deseja sacar?");
        saque = sc.nextDouble();

        if (saque <= conta.getSaldo()) {
            conta.setSaldo(conta.getSaldo() - saque);
            System.out.println(
                    "-------------------------------------------------------\nSaque efetuado com sucesso!\nSaldo: R$ "
                            + conta.getSaldo());
        } else {
            System.out.println(
                    "Você não possue dinheiro suficiente. Insira um valor mais baixo ou procure por um empréstimo.");
        }
    }

    public void FazerDeposito(Conta conta) {
        System.out.println(
                "\n------------------------------------------------------------------------------\nSaldo:    R$"
                        + conta.getSaldo() + "\nQuanto deseja depositar?");
        deposito = sc.nextDouble();

        if (deposito <= 10000) {
            conta.setSaldo(conta.getSaldo() + deposito);
            System.out.println(
                    "-------------------------------------------------------\nDepósito efetuado com sucesso!\nSaldo: R$ "
                            + conta.getSaldo());
        } else {
            System.out.println("Valor muito alto. Insira um valor mais baixo ou procure negociar.");
        }
    }

    public void FazerEmprestimo(Conta conta) {
        System.out.println(
                "\n------------------------------------------------------------------------------\nSaldo:    R$"
                        + conta.getSaldo() + "\nQual o valor do empréstimo?");
        emprestimo = sc.nextDouble();
        tempo = (int) Math.ceil(emprestimo / (conta.getSaldo() * 0.25));

        if (emprestimo <= 50000) {
            System.out.println(
                    "-------------------------------------------------------\nEmpréstimo fechado com sucesso!\nSaldo: R$ "
                            + (conta.getSaldo() * 0.25) + "\nSuas parcelas serão de " + conta.getSaldo()
                            + " [25% de seu saldo], à uma taxa de 2% a.m., por " + tempo + " meses");
            conta.setSaldo(conta.getSaldo() + emprestimo);
        } else {
            System.out.println("Valor muito alto. Insira um valor mais baixo ou procure negociar presencialmente.");
        }
    }

    public String FormatarCpfCnpj(String cpfCnpj, String tipo) {
        StringBuilder sb = new StringBuilder(cpfCnpj);

        if (tipo.equalsIgnoreCase("CPF")) {
            sb.insert(3, ".");
            sb.insert(7, ".");
            sb.insert(11, "-");

            return sb.toString();
        } else {
            sb.insert(2, ".");
            sb.insert(6, ".");
            sb.insert(10, "/");
            sb.insert(15, "-");

            return sb.toString();
        }
    }
    /*
     * void exibirSaldo();
     * void realizarSaque(double valor);
     * void realizarDeposito(double valor);
     * void solicitarEmprestimo(double valor);
     * void sairDaConta();
     */
}