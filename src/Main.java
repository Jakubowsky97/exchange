import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);

        int[] groszamount = {50000,20000,10000,5000,2000,1000,500,200,100,50,20,10,5,2,1};
        System.out.println("Cena produktu");
        double productPrice = scaner.nextDouble();
        scaner.nextLine();
        System.out.println("Kwota dana przez klienta ");
        double clientAmount = scaner.nextDouble();

        double change = clientAmount - productPrice;

        System.out.println("Reszta do wydania: "+ change);
        int[] amountMoneyArray = exchangeMoney(change,groszamount);
        System.out.println("Wydano banknoty/monety");
        for(int i = 0; i < groszamount.length; i++){
            if(amountMoneyArray[i] != 0){
                if (groszamount[i] % 100 == 0){
                    System.out.println("{"+groszamount[i]/100+" zl}" +" - " + amountMoneyArray[i]+" sztuk");
                }
                else System.out.println("{"+groszamount[i]+" gr}" +" - " + amountMoneyArray[i]+" sztuk");
            }
        }
    }
    public static int[] exchangeMoney(double exchange, int[] groszamount){
        int size = groszamount.length;
        int[] amountOfBills = new int[size];
        int restInGroszes = (int) (exchange * 100);

        for(int i = 0; i < size;i++){
            amountOfBills[i] = 0;
        }

        for(int i = 0; i < size; i++){
            if(restInGroszes >= groszamount[i]){
                amountOfBills[i]  = restInGroszes/groszamount[i];
                restInGroszes -= groszamount[i] * amountOfBills[i];
            }
        }
        return amountOfBills;
    }
}