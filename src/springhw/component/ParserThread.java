package springhw.component;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springhw.beans.Characters;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;


public class ParserThread extends Thread {
    public String FileName;
    public ArrayList<Characters[]> arrayList;
    public ArrayList<String> GoNames;
    Semaphore sem;

    public ParserThread(String FileName, ArrayList<Characters[]> arrayList, ArrayList<String> GoNames, Semaphore sem) {
        this.arrayList = arrayList;
        this.FileName = FileName;
        this.GoNames = GoNames;
        this.sem = sem;
    }

    /*@Override
    public Characters[] call() throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        Parser parser = ctx.getBean("Parser", Parser.class);
        ctx.close();
        parser.setFilename(FileName);
        Characters[] data = parser.parse();
        System.out.println(FileName+" done");
        return data;
    }*/

    public void run()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        Parser parser = ctx.getBean("Parser", Parser.class);
        ctx.close();
        parser.setFilename(FileName);
        Characters[] data = parser.parse();
        //Printer.print_all(data);
        try {
            sem.acquire();
            GoNames.add(FileName);
            arrayList.add(data);
            System.out.println(FileName + " done");
            //Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem.release();
    }
}