package springhw;

import springhw.beans.*;
import springhw.component.FileList;
import springhw.component.Menu;
import springhw.component.ParserThread;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;



public class App {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the path to the files: ");
        String path = in.next();
        Semaphore sem = new Semaphore(1);
        String[] Names = FileList.ReadName(path);
        ArrayList<String> GoNames = new ArrayList<>();
        ArrayList<Characters[]> arrayList = new ArrayList<>();
        //Characters[][] bob;
        for(int i = 0;i< Names.length; i++){
            ParserThread myThread = new ParserThread(Names[i],arrayList, GoNames, sem);
            myThread.start();
        }
        while (arrayList.size()<Names.length) {
            Thread.sleep(100);
        }
        Menu.first_menu(arrayList,GoNames);
    }

}