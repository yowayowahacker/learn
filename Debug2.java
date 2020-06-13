import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;

public class Debug2
{
  public static void main(String[] args)throws IOException,Exception
  { 
    //テキストファイルを編集
    String filepath = "/home/nescal/JavaProgram/Hello.java";

    File file = new File(filepath);
    FileReader filereader = new FileReader(file);
    BufferedReader reader = new BufferedReader(filereader);
    String line = null;
    String A = "A";
    while((line = reader.readLine()) != null){
      System.out.println(line);
      line.replace(line,"System.out.println("+A+")");
    }
    reader.close();
  }
}
