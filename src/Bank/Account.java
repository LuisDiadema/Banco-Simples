package Bank;

public class Account {

    private String name;
    private String ag;
    private String cc;

    private double balance;
    //Variavel para subString
    private static final int MAX_NAME = 12;
    private static final int MAX_AG = 8;
    private static final int MAX_CC = 12;

    private Log logger;

    public Account (String ag, String cc, String name) {
        setAg(ag);
        setCc(cc);
        setName(name);
        logger = new Log();
    }

    public void setCc(String cc) {
        if (cc.length() > MAX_CC) {
            this.cc = cc.substring(0, MAX_CC);
        } else {
            this.cc = cc;
        }
        System.out.println(this.cc);
    }
    public void setAg(String ag) {
        if (ag.length() > MAX_AG){
        this.ag = ag.substring(0, MAX_AG);
        } else {
            this.ag = ag;
        }
        System.out.println(this.ag);
    }

    public void setName (String name) {
        if (name.length() > MAX_NAME) {
            this.name = name.substring(0, MAX_NAME);
        } else {
            this.name = name;
        }
        System.out.println(this.name);
    }

    public void deposit (double value) {
        balance += value;
        logger.out("DEPOSITO: R$ " + value + " saldo atual de R$ " + balance);

    }

    public boolean whithDraw (double value) {
        if (balance < value) {
            logger.out("SAQUE: Tentavida de saque no valor de R$ " + value + " não efetuado seu saldo é: " + balance);
            return false;
        } else {
            balance -= value;
            logger.out("SAQUE: R$ " + value + " saldo atual de R$ " + balance);
            return true;
        }
    }

    public double getbalance () {
        return balance;
    }


    @Override
    public String toString() {
        return "A conta " + this.name + " - " + this.ag + " / " + this.cc + " possui: R$ "  + balance;
    }
}
