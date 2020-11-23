import java.lang.Runtime;
import java.util.stream.*;
import java.io.*;

public class Linux_Debug{



  public static void main(String[] args)throws IOException, Exception{
    
    Text_Edit(Command_Locate());

  }



  public static String Command_String(Process P)throws IOException, Exception{
    
    String lise_sepa = System.getProperty("line.separator");
    InputStream is = null;
    BufferedReader reader = null;

    is = P.getInputStream();
    StringBuffer out = new StringBuffer();
    reader = new BufferedReader(new InputStreamReader(is));

    String line;
    while((line = reader.readLine()) != null){
      out.append(line);
    }

    reader.close();
    return out.toString();
  
  }

  
  public static String Command_Locate()throws IOException, Exception{

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    System.out.println("Please input filename");
    String filename = reader.readLine();
    
    Process p;
    p = Runtime.getRuntime().exec("locate " + filename);

    int code = p.waitFor();
    if(code != 0){
      System.out.println("Please install Command 'locate'");
      System.exit(0);
    }

    reader.close();
    return Command_String(p);

  }


  public static void Text_Edit(String file_path)throws IOException, Exception{
    
    BufferedReader reader = new BufferedReader(new FileReader(new File(file_path)));

    char[] ALPHABET = IntStream.rangeClosed('A', 'Z').mapToObj(c -> "" + (char) c).collect(Collectors.joining()).toCharArray();
    char[] alphabet = IntStream.rangeClosed('a', 'z').mapToObj(c -> "" + (char) c).collect(Collectors.joining()).toCharArray();

    String line = "";
    Process p;
    while((line = reader.readLine()) != null){
      
      if(line.matches(" *//[d,D][0-9]{2}")){
        
        char[] line_array = line.toCharArray();
        int len = line_array.length - 2;

        String number_str = String.valueOf(line_array[len]);
        number_str += String.valueOf(line_array[len+1]);

        String line_str = String.valueOf(line_array[len-1]);
        line_str += number_str;

        int number = Integer.parseInt(number_str);
        int code = 0;


        if(number > 0 && number <= 26){

          p = Runtime.getRuntime()
            .exec("sed -i s/\\/\\/" + line_str + "/" + "System.out.println(\"" + ALPHABET[number-1] + "\");" + "/ " + file_path);

          code = p.waitFor();
        
        }else if(number >= 27 && number < 53){

          p = Runtime.getRuntime()
            .exec("sed -i s/\\/\\/" + line_str + "/" + "System.out.println(\"" + alphabet[number-27] + "\");" + "/ " + file_path);
        
          code = p.waitFor();
        }else{
          System.out.println("Please input in the following format! \n //dn  n:01-52");
          System.exit(0);
        }


        if(code != 0){
          System.out.println("Not ready to debug");
          System.exit(0);
        }
      }
    
    }

    System.out.println("Ready to debug");
    
    reader.close();
  
  }

}


