package springhw;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springhw.beans.Characters;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Callable;


public class ParserThread extends Thread {
    public String FileName;
    public ArrayList<Characters[]> arrayList;

    public ParserThread(String FileName, ArrayList<Characters[]> arrayList) {
        this.arrayList = arrayList;
        this.FileName = FileName;
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
        arrayList.add(data);
        System.out.println(FileName+" done");
    }
}
