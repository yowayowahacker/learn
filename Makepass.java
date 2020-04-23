import java.util.Scanner;
import java.util.Random;

public class Makepass
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		//入力を受ける
		System.out.println("パスワードの桁数を入力");
		String passlen = "";
		passlen = scan.next();
		scan.close();

		int len = Integer.parseInt(passlen);
		int i = 0;
		int passint[] = new int[len];
		
		while(i < len){  //乱数を発生
			Random random = new Random();
			int rand = random.nextInt(122)+48;

			try{
				if(rand >= 48 && rand <= 57 || rand >= 65 && rand <= 90 || rand >= 97 && rand <= 122){
					passint[i] = rand;

					i++;
				}
			}catch(Exception e){  //例外処理
				e.printStackTrace();
			}
		}
		
		//int to byte
		byte passbyte[] = new byte[len];
		for(i = 0; i < len; i++){
			passbyte[i] = (byte)passint[i];
		}
		
		//byte to String
		String pass = "";
		try {
            pass = new String(passbyte, "US-ASCII");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
		
		System.out.println(pass);
	}
}