package springhw;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springhw.beans.*;
import springhw.*;

import java.util.ArrayList;
import java.util.Scanner;



public class App {
	public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the path to the files: ");
        String path = in.next();
        String[] Names = FileList.ReadName(path);
        ArrayList<String> GoNames = new ArrayList<>();
        ArrayList<Characters[]> arrayList = new ArrayList<>();
        //Characters[][] bob;
        for(int i = 0;i< Names.length; i++){
                ParserThread myThread = new ParserThread(Names[i],arrayList, GoNames);
                myThread.start();
        }
        Thread.sleep(1000);
        Menu.first_menu(arrayList,GoNames);
    }

}
