package org.fyr;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static Converter converter = new Converter();


    public static void main(String[] args) throws InputMismatchException{

        Scanner scan = new Scanner(System.in);

        Currency usd = new Currency("USD", 1.149179);
        Currency eur = new Currency("EUR", 0.870189);
        Currency sek = new Currency("SEK", 11.055313);


        while(true){
            printMenu();

            int choice = scan.nextInt();


            if(choice < 0 || choice > 6){
                System.out.println("Enter a number from 0 --> 6 according to the options available in the menu");
                continue;
            }

            if(choice == 0) {
                System.out.println("Exiting the program.");
                break;
            }

            System.out.println("Please enter the amount that you would like to convert");
            double amount = scan.nextDouble();



            switch (choice){
                case 1:
                    convertUsdToSek(amount,usd, sek);
                    break;
                case 2:
                    convertSekToUsd(amount, sek, usd);
                    break;
                case 3:
                    convertUsdToEur(amount, usd, eur);
                    break;
                case 4:
                    convertEurToUsd(amount, eur, usd);
                    break;
                case 5:
                    convertEurToSek(amount, eur, sek);
                    break;
                case 6:
                    convertSekToEur(amount, sek, eur);
                    break;
            }

        }

        scan.close();

    }

    private static void printMenu() {
        System.out.println("1. Convert USD to SEK");
        System.out.println("2. Convert SEK to USD");

        System.out.println("3. Convert USD to EUR");
        System.out.println("4. Convert EUR to USD");

        System.out.println("5. Convert EUR to SEK");
        System.out.println("6. Convert SEK to EUR");

        System.out.println("0. Exit");
    }


    private static void printResult(double amount, double result, Currency fromCurrency, Currency convertedCurrency) {

        LocalDateTime ldt = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        String formattedString = String.format("%s %.2f is %s %.2f",fromCurrency.getCurrency().toUpperCase(), amount, convertedCurrency.getCurrency().toUpperCase(), result );
        System.out.println(formattedString);
        System.out.println("Conversion occurred at " + ldt.toLocalDate() + " " +ldt.toLocalTime());
        System.out.println("---------------");
    }


    private static void convertUsdToSek(double amount, Currency usd, Currency sek) {
        double result = converter.convert(amount, sek.getRate());

        printResult(amount, result, usd, sek);
    }

    private static void convertSekToUsd(double amount, Currency sek, Currency usd) {
        double result = converter.convert(amount, usd.getRate());

        printResult(amount, result, sek, usd);
    }
    private static void convertUsdToEur(double amount, Currency usd, Currency eur) {
        double result = converter.convert(amount, eur.getRate());
        printResult(amount, result, usd, eur);

    }

    private static void convertEurToUsd(double amount, Currency eur, Currency usd) {
        double result = converter.convert(amount, usd.getRate());
        printResult(amount, result, eur, usd);
    }
    private static void convertEurToSek(double amount, Currency eur, Currency sek) {
        double result = converter.convert(amount, sek.getRate());
        printResult(amount, result, eur, sek);
    }
    private static void convertSekToEur(double amount, Currency sek, Currency eur) {
        double result = converter.convert(amount, eur.getRate());
        printResult(amount, result, sek, eur);
    }



}
