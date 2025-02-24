public class CuentaBancaria {
    private String fullName;
    private double balance = 100;

    public double Deposit(double amount){
        return this.balance + amount;
    }

    public double Widraw(double amount){
        double canWidraw = this.balance - amount;
        if (canWidraw > 0){
            return canWidraw;
        }

        else return 0;
    }

    public double getBalance() {
        return this.balance;
    }
}
