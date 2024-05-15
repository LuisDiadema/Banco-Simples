package Bank;

import java.util.List;
import java.util.ArrayList;

public class Bank {

    private String Ag;
    private List<Account> accoutns;

    private int lastAccount = 000001;

    public Bank (String ag){
        this.Ag = ag;
        this.accoutns = new ArrayList<>();
    }

    public List<Account> getAccoutns () {
        return accoutns;
    }

    public void insertAccount (Account account) {
        accoutns.add(account);
    }

    public Account generateAccount(String name) {
        Account account = new Account(Ag, " " + lastAccount,  name);
        lastAccount++;
        return account;
    }

    public void outputTotal() {
        double total = 0;
        for (Account account : accoutns){
            double balance = account.getbalance();
            total += balance;
        }
        System.out.println("Banco tem um total de: R$ " + total);
    }
}
