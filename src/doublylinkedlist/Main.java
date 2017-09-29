package doublylinkedlist;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Main {
    public static Writer output;
    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        output=new FileWriter("output.txt");
        File file=new File("input.txt");
        scan = new Scanner(file);
        doublylinkedlist ob=new doublylinkedlist();
        while(scan.hasNextLine()){    
            String a = scan.nextLine();
            String var[]=a.split("\\s+");
            
            if(var[0].equals("2")){
                    for(int i=0;i<(Integer.parseInt(var[1]));i++){
                        ob.insertAtanyPos(var[i+2]);   
            }
       }
            if(var[0].equals("3")){
               ob.deleteAnyData(var[1]);
            }
            if(var[0].equals("1")){
               ob.print();
            }

    }
      output.flush();
      output.close();   
}

}
