package ru.savinov.stepik;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D,C,B,A, temp, count;
        D=C=B=A=0;
        count = sc.nextInt();
        while(count > 0){
            temp = sc.nextInt();
            switch(temp){
                case 2:D++;break;
                case 3:C++;break;
                case 4:B++;break;
                case 5:A++;break;
            }
            count--;
        }
        System.out.print(D+" "+C+" "+B+" "+A);
    }
}