package springhw;

import springhw.beans.Characters;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static int chose (int size)
    {
        int choose;
        do {
            System.out.print("> ");
            try {
                Scanner in = new Scanner(System.in);
                choose = in.nextByte();
            } catch (InputMismatchException e) {
                //System.out.println("Please enter the number that corresponds to the menu item");
                choose = 0;
            }
        } while (choose < 0 || choose > size);
        return choose;
    }
    public static void second_menu (Characters[] data)
    {
        int choose=0;
        do {
            System.out.println("|       List objects        - 1|");
            System.out.println("|     Number of objects     - 2|");
            System.out.println("|Display object with number - 3|");
            System.out.println("|           Back            - 4|");
            do {
                System.out.print("> ");
                try {
                    Scanner in = new Scanner(System.in);
                    choose = in.nextByte();
                } catch (InputMismatchException e) {
                    //System.out.println("Please enter the number that corresponds to the menu item");
                    choose = 0;
                }
            } while (choose < 1 || choose > 4);
            switch (choose) {
                case 1:
                    Printer.print_all(data);
                    break;
                case 2:
                    Counter.count(data);
                    break;
                case 3:
                    Printer.ptint_for_user(data);
                    break;
                case 4:
                    break;
            }
        } while (choose != 4);
    }
    public static void  first_menu (ArrayList<Characters[]> arrayList, ArrayList<String> FileName)
    {
        int choose;
        do {
            System.out.println("| All objects in the files  - 1|");
            System.out.println("| Select a group of objects - 2|");
            System.out.println("|     Number of objects     - 3|");
            System.out.println("|           Exit            - 4|");
            do {
                System.out.print("> ");
                try {
                    Scanner in = new Scanner(System.in);
                    choose = in.nextByte();
                } catch (InputMismatchException e) {
                    //System.out.println("Please enter the number that corresponds to the menu item");
                    choose = 0;
                }
            } while (choose < 1 || choose > 4);
            if (choose == 1) {
                for (int i = 0; i < arrayList.size(); i++) {
                    System.out.println("Position "+(i+1)+":");
                    System.out.println("---"+ FileName.get(i) +"---");
                    Printer.print_all(arrayList.get(i));
                }
            }
            if (choose == 2) {
                int amr = chose(arrayList.size());
                second_menu(arrayList.get(amr-1));
            }
            if (choose == 3) {
                Counter.countAll(arrayList);
            }
            if (choose == 4) {
                System.out.println("Close the program");
            }
        } while (choose != 4);
    }
}
