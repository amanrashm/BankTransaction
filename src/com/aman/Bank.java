package com.aman;

import java.util.Scanner;

class InsufficientFundsException extends Exception
{

    InsufficientFundsException(String str)
    {
        super(str);
    }
}

class Bank
{
    int amt=1000;

    void deposit(int damt)
    {
        amt=amt+damt;
        System.out.println("after deposit the amt is::"+amt);
    }

    void withdraw(int wamt) throws InsufficientFundsException
    {
        if(wamt > amt)
            throw new InsufficientFundsException("no sufficient funds");
        else
            amt=amt-wamt;
    }

    void balanceCheck()
    {
        System.out.println("balance amt::"+amt);
    }


    public static void main(String [] args)throws InsufficientFundsException
    {

        Bank b=new Bank();

        System.out.println("1.depsit"+"\n"+"2.withdraw"+"\n"+"3.balanceCheck");

        Scanner s=new Scanner(System.in);

        System.out.println("Enter your choice");
        int ch=s.nextInt();

        switch(ch)
        {
            case 1:
                System.out.println("Enter deposit amt");
                int damt=s.nextInt();
                b.deposit(damt);
                break;

            case 2:
                System.out.println("enter withdraw amt");
                int wamt=s.nextInt();
                b.withdraw(wamt);
                break;

            case 3:
                b.balanceCheck();

            default:
                System.out.println("Invalid choice");
        }

    }
}