package springhw;
import java.io.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springhw.beans.*;

public class Parser {
    private String filename;
    public Parser() {
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Characters[] parse(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        try
        {
            FileReader reader = new FileReader(this.filename);
            BufferedReader breader = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            int i = 0;
            String line = breader.readLine();
            while (line != null){
                sb.append(line + ' ');
                line = breader.readLine();
                i = i + 1;
            }
            Characters[] mass = new Characters[i];
            String data = sb.toString();
            String[] md = data.split(" ");
            for (int j = 0; j < i; j++) {
                if(md[1 + j * 4].equals("tank")){
                    Characters chars = ctx.getBean("Tank", Characters.class);
                    chars.setName(md[3 + j * 4]);
                    mass[j] = chars;
                } else {
                    if (md[1 + j * 4].equals("melee")) {
                        Characters chars = ctx.getBean("Melee", Characters.class);
                        chars.setName(md[3 + j * 4]);
                        mass[j] = chars;
                    } else {
                        if (md[1 + j * 4].equals("range")) {
                            Characters chars = ctx.getBean("Range", Characters.class);
                            chars.setName(md[3 + j * 4]);
                            mass[j] = chars;
                        } else {
                            mass[j] = null;
                        }
                    }
                }
            }
            ctx.close();
            return mass;

        }catch (FileNotFoundException e) {
            ctx.close();
            System.out.println("File does not exist");
            return null;
        } catch (IOException e) {
            ctx.close();
            System.out.println("IOException");
            return null;
        }
    }
}
