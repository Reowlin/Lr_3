package springhw;

import springhw.beans.Characters;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Printer {
    public static void print_all (Characters[] data){
        for (int i = 0; i < data.length; i++)
        {
            System.out.println(i + ". " + data[i]);
        }
        System.out.println();
    }

    public static void print (Characters[] data, int pos_number){
        System.out.println(data[pos_number]);
        System.out.println();
    }

    public static void ptint_for_user (Characters[] data){
        System.out.println("Specify the position from 0 to " + (data.length - 1));
        System.out.print("> ");
        Scanner in = new Scanner(System.in);
        Byte pos_number;
        try {
            pos_number = in.nextByte();
        } catch (InputMismatchException e) {
            pos_number = -1;
        }
        try {
            System.out.println(data[pos_number]);
            System.out.println();
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("There is no such object");
            System.out.println();
        }

    }
}
