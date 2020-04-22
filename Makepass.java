import java.util.Scanner;
import java.util.Random;

public class Makepass
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.println("パスワードの桁数を入力");
		String passlen = "";
		passlen = scan.next();
		scan.close();

		int len = Integer.parseInt(passlen);
		int i = 0;

		if(len == 8){
			while(i < 8){
				Random random = new Random();
				int rand = random.nextInt(122)+48;  //乱数を発生

				if(rand >= 48 && rand <= 57 || rand >= 65 && rand <= 90 || rand >= 97 && rand <= 122){  //パスワードに変換
					byte asciicodes = (byte)rand;
					System.out.println(asciicodes);

					i++;
				}
			}
		}else{
			while(i < len){
				Random random = new Random();
				int rand = random.nextInt(122)+48;  //乱数を発生

				if(rand >= 48 && rand <= 57 || rand >= 65 && rand <= 90 || rand >= 97 && rand <= 122){  //パスワードに変換
					byte asciicodes = (byte)rand;
					System.out.println(asciicodes);

					i++;
				}
			}
		}
	}
}