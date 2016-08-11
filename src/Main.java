import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.parse(args);
	// write your code here
    }

    public void parse(String[] paths) {
        for (String path : paths) {
        File file = new File(path);
        BufferedReader bf = null;

        try {
            bf = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> al = new ArrayList<>();
        String str;

        try {
            while ((str = bf.readLine()) != null) {
                al.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ListIterator<String> it = al.listIterator();
        StringBuffer sb = new StringBuffer();

        while(it.hasNext()) {
            String s = it.next();
            s = s.replaceAll("^　", "");
            s = s.replaceAll("！　", "！");
            s = s.replaceAll("？　", "？");
            s = s.replaceAll("！？", "!?");
            s = s.replaceAll("？！", "?!");
            sb.append(s + System.getProperty("line.separator"));
        }

        System.out.println(sb.toString());

        File newFile = new File(path);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(newFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    }
}
