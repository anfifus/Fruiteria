import java.sql.Struct;
import java.util.Scanner;

public class Main {

    private static final int BANANA = 1;
    private static final int ORANGE = 2;
    private static final int APPLE = 3;
    private static final int SHOWMONEY = 4;
    private static final int EXIT = 5;

    private static final int BANANAPRICE = 40;
    private static final int ORANGEPRICE = 30;
    private static final int APPLEPRICE = 20;


    public static void main(String[] args) {
        String name = nameBuyer();
        Buyer firstBuyer = newBuyer(name);
        int money = howMuchMoney();
        firstBuyer.setMoney(money);
        int op;
        do
        {
            System.out.println("1-Buy platan");
            System.out.println("2-Buy orange");
            System.out.println("3-Buy apple");
            System.out.println("4-Show money of the buyer");
            System.out.println("5-Exit program");

            op= whatBuy();
            switch (op)
            {
                case BANANA-> buyingFruit(firstBuyer.getMoney(), BANANAPRICE);
                case ORANGE-> buyingFruit(firstBuyer.getMoney(),ORANGEPRICE);
                case APPLE-> buyingFruit(firstBuyer.getMoney(),APPLEPRICE);
                case SHOWMONEY-> showMoney(firstBuyer);
                case EXIT-> System.out.println("Exiting program...");
            }
        }
        while(op != 5);
    }

    private static void showMoney(Buyer firstBuyer) {
        System.out.println("The money of the buyer is: "+firstBuyer.getMoney());
    }

    private static String nameBuyer() {
        System.out.println("The new buyer is here: ");
        return new Scanner(System.in).nextLine();
    }


    private static Buyer newBuyer(String name) {

        return new Buyer(name);
    }

    private static void buyingFruit(int money,int moneyFruit) {
        if(money >= moneyFruit){
            money -=moneyFruit;
            System.out.println("You have: "+money);
        }
        else{
            System.out.println("You don't have money");
        }
    }


    private static int whatBuy() {
        return new Scanner(System.in).nextInt();
    }

    private static int howMuchMoney() {
        return new Scanner(System.in).nextInt();
    }
}
