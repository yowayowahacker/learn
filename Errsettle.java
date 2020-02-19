import java.io.*;
import java.lang.Runtime.*;

public class Errsettle
{
	public static Process COMMAND(String com) throws IOException,Exception
	{
		//外部プロセスを実行
  		Process p;
		p = Runtime.getRuntime().exec(com); 
        return p;
	}

	public static String ErrGet(Process p) throws IOException, Exception
	{
		//エラー内容を取得
		InputStream is = p.getErrorStream();
		String LINE_SEPA = System.getProperty("line.separator");
		BufferedReader br = null;
		String Err = new String();
		try{
			StringBuffer err = new StringBuffer();
			br = new BufferedReader(new InputStreamReader(is));
			String line;
			while((line = br.readLine()) != null){
				err.append(line + LINE_SEPA);
			}
			Err = err.toString();
		}catch(IOException ex){
		}
		return Err;
	}

	public static void main(String[] args) throws IOException, Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//コマンドの入力
		String c = reader.readLine();
		Process pro;
		pro = COMMAND(c);

		//終了ステータスを受け取る
		int code = pro.waitFor();
		System.out.println("終了ステータス："+code);

		if(code == 1)
		{
			//エラー内容を解析
			String Error;
			Error = ErrGet(pro);
			char[] error = Error.toCharArray();
			if(error[0] == 'm'){
				c = "rmdir A";
			}else if(error[0] == 'r'){
				c = "mkdir A";
			}

			//実行許可を受ける
			System.out.println("エラー解決のため："+c+"を実行します\nY/n");
			String h = reader.readLine();
			if(h.equals("y")){
				//エラー解決の処理
				pro = COMMAND(c);
				System.out.println("エラーを解決しました\nもう一度コマンドを実行してください");
			}
		}else if(code == 0){
			//標準出力
			String so = "";
        		String LINE_SEPA = System.getProperty("line.separator");
        		InputStream is = null;
        		BufferedReader br = null;

        		try{
            			is = pro.getInputStream();
            			StringBuffer out = new StringBuffer();
            			br = new BufferedReader(new InputStreamReader(is));

            			String line;
            			while((line = br.readLine()) != null){
                			out.append(line + LINE_SEPA);
            			}
            			so = out.toString();
        		}catch(IOException ex){
        		}
			System.out.println(so);
		}
		System.exit(0);
	}
}
