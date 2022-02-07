import java.util.Scanner;

public class Bank {

    private double rate;


    public void deposit(Account a, double amount){
        double balance;
        balance = a.getBalance();
        balance += amount;
        a.setPrevious(amount);
        a.setBalance(balance);
    }

    public void withdraw(Account a, double amount){
        double balance;
        balance = a.getBalance();
        balance -= amount;
        a.setPrevious(-amount);
        a.setBalance(balance);
    }

    public double calculateInterest(Account a, int years){
        double simpleInterest;
        simpleInterest = a.getBalance()*years*rate*0.01;
        return simpleInterest;
    }
    public static void main(String[] args) {
       Bank b = new Bank();
       Account a = new Account("A01", "Swadib");
       double d;
       int s;
       Scanner scanner = new Scanner(System.in);
       boolean flag = true;
       do{
           System.out.println("Enter your option");
           s = scanner.nextInt();

           switch(s){
               case 0:
                   System.out.println("Your current balance is " + a.getBalance());
                   break;
               case 1:
                   System.out.println("Enter the amount you want to deposit?");
                   d = scanner.nextDouble();
                   b.deposit(a,d);
                   break;
               case 2:
                   System.out.println("Enter the amount you want to withdraw?");
                   d = scanner.nextDouble();
                   b.withdraw(a,d);
                   break;
               case 3:
                   System.out.println("Your previous transaction is " + a.getPrevious());
                   break;
               case 4:
                   System.out.println("Exited");
                   flag = false;
                   break;
               default:
                   System.out.println("Error");
                   break;
           }
       }while(flag);

    }

}