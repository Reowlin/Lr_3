package springhw;

import java.io.File;

public class FileList {
    public static String[] ReadName(String args) {
        File file = new File(args);
        String[] list = file.list();
        for(int d = 0; d<list.length; d++)
        {
            list[d]=args+"\\"+list[d];
        }
        return list;
    }

}