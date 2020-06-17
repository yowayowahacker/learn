import java.io.*;
import java.util.Random;

public class Cal
{
  //足し算
  public static int ADD(int x, int y)
  {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int P = 0;
    int ans = 0;
    String UANS = "";
    int uans = 0;
    int i = 0;

    while(i == 0)
    {
      try{
        System.out.print(x+" + "+y+" = ");
        UANS = reader.readLine();
        uans = Integer.parseInt(UANS);
        i = 1;
      }catch(IOException e){
        System.out.println(e);
      }catch(NumberFormatException e){
        System.out.println("数字で解答してください\n ");
        i = 0;
      }
    }

    ans = x + y;
    if(ans == uans){
      System.out.println("正解！");
    }else{
      System.out.println("不正解！");
      P = 1;
    }
    System.out.println("");

    return P;
  }

  //引き算
  public static int SUB(int x,int y)
  {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int P = 0;
    int ans = 0;
    String UANS = "";
    int uans = 0;
    int i = 0;

    while(i == 0)
    {
      try{
        System.out.print(x+" - "+y+" = ");
        UANS = reader.readLine();
        uans = Integer.parseInt(UANS);
        i = 1;
      }catch(IOException e){
        System.out.println(e);
      }catch(NumberFormatException e){
        System.out.println("数字で解答してください。\n ");
        i = 0;
      }
    }

    ans = x - y;
    if(ans == uans){
      System.out.println("正解！");
    }else{
      System.out.println("不正解！");
      P = 1;
    }
    System.out.println("");

    return P;
  }

  //掛け算
  public static int MUL(int x,int y)
  {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int P = 0;
    int ans = 0;
    String UANS = "";
    int uans = 0;
    int i = 0;

    while(i == 0)
    {
      try{
        System.out.print(x+" × "+y+" = ");
        UANS = reader.readLine();
        uans = Integer.parseInt(UANS);
        i = 1;
      }catch(IOException e){
        System.out.println(e);
      }catch(NumberFormatException e){
        System.out.println("数字で解答してください\n ");
        i = 0;
      }
    }

    ans = x * y;
    if(ans == uans){
      System.out.println("正解！");
    }else{
      System.out.println("不正解！");
      P = 1;
    }
    System.out.println("");

    return P;
  }

  /*public static int DIV(int x,int y)
  {
    BufferedReader Reader = new BufferedReader(new InputStreamReader(System.in));
    int P = 0;
    int ans = 0;
    String UANS = "";
    int uans = 0;
    int i = 0;

    while(i == 0)
    {
      try{
        System.out.print(x+" ÷ "+y+" = ");
        UANS = reader.readLine();
        uans = Integer.parseInt(UANS);
        i = 1;
      }catch(IOException e){
        System.out.println(e);
      }catch(NumberFormatException e){
        System.out.println("数字で解答してください\n ");
      }
    }

    ans = x / y;
  }*/

  //乱数生成
  public static int RANDOM()
  {
    Random random = new Random();
    int rand = random.nextInt(101);
    return rand;
  }

  public static void main(String[] args)
  {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    while(true)
    {
      //演算の種類を設定
      String strk = "";
      int k = 0;
      System.out.println("-----------------------------------設　定-----------------------------------");
      while(k == 0 || k > 4)
      {
        try{
          System.out.println("「１．足し算　２．引き算　３．掛け算　４．割り算」数字で入力してください。\n終了の場合はexitと入力");
          strk = reader.readLine();
          System.out.println("");
          k = Integer.parseInt(strk);
          if(k == 0 || k > 4)
          {
            System.out.println("１から４の数字で入力してください\n ");
          }
        }catch(IOException e){
          System.out.println(e);
        }catch(NumberFormatException e){
          if(strk.equals("exit")){
            System.exit(0);
          }else{
            System.out.println("数字で入力してください\n ");
          }
        }
      }

      //出題数を設定
      String NOQ = "";
      int noq = 0;
      while(noq == 0)
      {
        try{
          System.out.println("出題数を入力してください。");
          NOQ = reader.readLine();
          noq = Integer.parseInt(NOQ);
          System.out.println("");
        }catch(IOException e){
          System.out.println(e);
        }catch(NumberFormatException e){
          System.out.println("数字で入力してください。");
        }
      }

      //出題
      System.out.println("-----------------------------------問　題-----------------------------------");
      int p = 0;
      int i = 0;
      int corr = 0;
      int inco = 0;
      while(noq > i)
      {
        int rand1 = RANDOM();
        int rand2 = RANDOM();
        System.out.println("第"+(i+1)+"問");
        
        switch(k)
        {
          case 1:
            p = ADD(rand1,rand2);
            if(p == 0){
              corr += 1;
            }else{
              inco += 1;
            }
            break;
          case 2:
            p = SUB(rand1,rand2);
            if(p == 0){
              corr += 1;
            }else{
              inco += 1;
            }
            break;
          case 3:
            p = MUL(rand1,rand2);
            if(p == 0){
              corr += 1;
            }else{
              inco += 1;
            }
            break;
        }

        /*if(p == 0){
          corr += 1;
        }else{
          inco += 1;
        }*/
        i++;
      }

      //結果
      System.out.println("-----------------------------------結　果-----------------------------------");
      System.out.println("出題数　："+noq+"問");
      System.out.println("正解数　："+corr+"問");
      System.out.println("不正解数："+inco+"問");
      System.out.println("正答率　： ％");
      System.out.println("");
    }
  }
}
