import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;
import java.security.MessageDigest;	

public class Makepass
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		//定数を宣言（Asciiコード）
		final int Asc_exc = 33;
		final int Asc_0 = 48;
		final int Asc_9 = 57;
		final int Asc_A = 65;
		final int Asc_Z = 90;
		final int Asc_a = 97;
		final int Asc_z = 122;
		final int Asc_til = 126;

		//入力を受ける
		int len = 0;
		String mark = "";
		while(true)
		{
			try {
				System.out.println("パスワードの桁数を入力");
				len = Integer.parseInt(scan.next());
				break;
			}catch(NumberFormatException e) {
				System.out.println("数字で入力してください");
				continue;
			}
		}
		
		System.out.println("記号：有_y   無_n");
		mark = scan.next();
		scan.close();

		int i = 0;
		char[] pass = new char[len];
		
		Random random = new Random();
		if(mark.equals("y") || mark.equals("Y")){
			while(i < len){
				int rand = random.nextInt(Asc_til) + Asc_exc;
					pass[i] = (char)rand;
					i++;
				}
		}else if(mark.equals("n") || mark.equals("N")){
			while(i < len) {
				int rand = random.nextInt(Asc_z) + Asc_0;
				if(rand >= Asc_0 && rand <= Asc_9 || rand >= Asc_A && rand <= Asc_Z || rand >= Asc_a && rand <= Asc_z) {
					pass[i] = (char)rand;

					i++;
				}
			}
		}
		
		System.out.println(pass);
		
		String pastr = String.valueOf(pass);
        	String pasha = "";
		
		try {
            		MessageDigest digest = MessageDigest.getInstance("SHA-1");
           		byte[] result = digest.digest(pastr.getBytes());
           		 pasha = String.format("%040x", new BigInteger(1, result));
        	} catch (Exception e){
            		e.printStackTrace();
        	}
		System.out.println(pasha);
	}
}
