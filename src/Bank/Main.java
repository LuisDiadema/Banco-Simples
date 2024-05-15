package Bank;

import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank diademaBank =  new Bank("0001");

        //C = Criar conta
        //E = Sair (Exit)
        while (true) {
            System.out.println("O que deseja fazer ? |C = Criar conta|-|E = Sair do programa");
            String op = scanner.nextLine();

            if (op.equals("C")){
                System.out.println("Digite seu nome:");
                String name = scanner.nextLine();
                Account account = diademaBank.generateAccount(name);
                diademaBank.insertAccount(account);

                operationAccount(account);
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando invalido");continue;
            }
        }

        List<Account> accountList = diademaBank.getAccoutns();
        for (Account cc : accountList){
            System.out.println(cc);
        }

        diademaBank.outputTotal();
    }

        static void operationAccount (Account account) {
            Scanner scanner = new Scanner(System.in);

            while (true){
                System.out.println("O que deseja fazer ? |D = Deposito|-|S = Saque|-|E = Sair da conta|");
                String op = scanner.nextLine();

                if (op.equals("D")){
                    System.out.println("Qual valor deseja depositar");
                    double value = scanner.nextDouble();
                    account.deposit(value);
                } else if (op.equals("S")){
                    System.out.println("Qual valor deseja Sacar ?");
                    double value = scanner.nextDouble();
                    if (!account.whithDraw(value)) {
                        System.out.println("Saldo indisponivel");
                    }
                } else if (op.equals("E")) {
                    break;
                } else {
                    System.out.println("Comando desconhecido, tente novamente");
                }
                scanner = new Scanner(System.in);
        }
    }
}