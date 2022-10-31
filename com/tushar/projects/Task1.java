package com.tushar.projects;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class Task1 {

    public static void main(String[] args)
    {
        String account_name = "Tushar dhawas";
        String branchname = "Pune";
        String branchaddress = "near taboda jungle aty ycc 89 road";
        String branchIFSC = "AIT070526";
        int account_number = 123457278;
        int balance = 0;
        int password = 3333;
        int minimum_bal = 1000;
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        int currattempt = 0;
        int paper = 0;
        int attempt = 5;

        LocalDate date = LocalDate.now(); // Declaring the date format
        String dateStr =date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        LocalTime dt = LocalTime.now(); // Declaring the time format
        String timeStr = dt.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));

        ArrayList<String> trans = new ArrayList<>(); // Dectscing a new arry
        Scanner sc = new Scanner(System.in);   // Importing the scanner class


// Limiting the number of attempts for entering correct password
        while (currattempt < attempt)
        {
            System.out.println("Enter your pin");
            int pass = sc.nextInt();
            if (pass == password)  // Checking if entered pin is same as the acccount pin
            {
                System.out.println("Do you want paper receipt"); // Asking if user wants to pri…
                System.out.println("1. Yes"); // Asking if user wants to pri…
                System.out.println("2. No"); // Asking if user wants to pri…
                paper = sc.nextInt();
                break;
            }
            else
            {
                System.out.println("You have entered wrong pin");
                currattempt = currattempt + 1;
            }}
            if (currattempt < 5) // Executing the main task if users enters correct password within limited attempts
            {
                while(flag1) {


                    System.out.println("**********");
                    System.out.println("1. Transaction History");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Transfer");
                    System.out.println("5. Quit");


                    System.out.println("What would to like to do today");
                    int option = sc.nextInt();


                    switch (option) {
                        case 1: // Option for transaction history
                        {
                            System.out.println("Your Transaction History");
                            for (String q : trans) {
                                System.out.println(q);
                            }
                            break;
                        }

                        case 2: // Option for withdrawl
                        {
                            while (true) {
                                System.out.println("Enter the withdrawl amount");
                                int withdraw = sc.nextInt();
                                if ((withdraw % 10) == 0) {
                                    if (withdraw <= balance) {
                                        if ((balance - withdraw) < 1000) {
                                            System.out.println("Minimum balance has to Rs 1000");
                                        } else {

                                            balance = balance - withdraw;

                                            String sf2 = String.format("You bave successfully withdrawl Rs %d", withdraw);
                                            String sf3 = String.format("Your balance is Rs %d", balance);
                                            System.out.println(sf2);
                                            System.out.println(sf3);

                                            String wt = String.format("Withdrawl Rs %d", withdraw);
                                            trans.add(wt);
                                            break;
                                        }
                                    } else {
                                        System.out.println("Insufficient balance");
                                    }

                                } else
                                    System.out.println("Enter the withdram amount in multiples of 100");
                            }
                            break;

                        }

                        case 3:// Option for deposit
                        {
                            while (true) {
                                System.out.println("Enter the deposit amount");

                                int deposit = sc.nextInt();

                                if ((deposit % 10) == 0) {

                                    balance = balance + deposit;

                                    String sf1 = String.format("You have successfully deposited Rs %d", deposit);
                                    String sf4 = String.format("Your balance is Rs %d", balance);
                                    System.out.println(sf1);
                                    System.out.println(sf4);
                                    String dp = String.format("Deposit Rs %d", deposit);
                                    trans.add(dp);

                                    break;

                                } else {
                                    System.out.println("Enter the amount in multiples of 100");
                                }
                            }
                            break;
                        }


                        case 4:          // Option for transfer
                        {
                            while (true) {
                                System.out.println("Enter the account number of the beneficiary");

                                account_number = sc.nextInt();

                                System.out.println("Enter the IFSC code of the bank of the beneficiary");
                                String ifsc = sc.next();

                                System.out.println(account_number);

                                System.out.println("Please confirm the account number of the beneficiary");

                                System.out.println("1. Correct");
                                System.out.println("2. Incorrect");
                                int conf = sc.nextInt();
                                if (conf == 1) {
                                    System.out.println("Enter the amount you want to transfer");
                                    int transfamount = sc.nextInt();
                                    if ((transfamount % 10) == 0) {
                                        if (transfamount <= balance) {
                                            if ((balance - transfamount) < 1000) {
                                                System.out.println("minimum balance has to be 1000");
                                            } else {
                                                balance = balance - transfamount;
                                                String sf2 = String.format("You have successfully transfered Rs %d to %d", transfamount, account_number);
                                                String sf3 = String.format("Your balance is Rs %d", balance);
                                                System.out.println(sf2);
                                                System.out.println(sf3);
                                                String tf = String.format("Transfer -  Rs %d", transfamount);
                                                trans.add(tf);
                                                break;
                                            }
                                        } else {
                                            System.out.println("Insufficient balance");
                                        }
                                    } else
                                        System.out.println("Enter the amount in multiple of 100");
                                } else
                                    System.out.println("You entered incorrect account number");
                            }
                            break;
                        }

                        case 5:           //option for end
                        {
                            System.out.println("thank you for banking with with us ");
                            flag1 = false;
                            break;
                        }

                        default:
                            System.out.println("please enter aaporiate option");
                            break;
                    }


                    System.out.println("make another transaction? Select 1 or 2 accordingly ");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int df = sc.nextInt();

                    if (df == 1){
                        flag1 = true;}
                    else{
                        flag1 = false;}
                }
                        if (paper == 1)
                        {
                            String sf6 = String.format("Date: %s", dateStr); // Printing the receipt
                            String sf7 = String.format("Tine: %s", timeStr);

//string sfs String.format("M s", LocalDate.now().toString(), LocalTine.now().toString());

                            String sf9 = String.format("Account Holder Name: %s", account_name);
                            String sf10 = String.format("Branch Name: %s", branchname);
                            String sf11 = String.format("Branch Address: %s", branchaddress);
                            String sf12 = String.format("Branch IFSC code: %s", branchIFSC);
                            String sf13 = String.format("Account Number: %d", account_number);
                            String sf14 = String.format("Your account balance is Rs %d", balance);

                            System.out.println(sf6);
                            System.out.println(sf7);
                            System.out.println(sf9);
                            System.out.println(sf10);
                            System.out.println(sf11);
                            System.out.println(sf12);
                            System.out.println(sf13);
                            System.out.println(sf14);

                        }
                        System.out.println("thankyou for banking with us !!!");
                }
                else{
                System.out.println("you have enterd a wrong pin too many times");
                }
    }
        }
