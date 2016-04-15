package 執行;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import tool.Utils;

public class RuntimeExe {

	public static void main(String[] args) throws Exception {
		new RuntimeExe().$4執行程式僅用於windows();
	}

	public void $1最簡單的exec() throws Exception {
		Runtime rt = Runtime.getRuntime();
		// 這裡就是執行了
		Process proc = rt.exec("ipconfig");
		// 等待結束，所以這是同步程式
		int exitVal = proc.waitFor();
		System.out.println("Process exitValue: " + exitVal);
	}

	/**
	 * 這裡適合把error放後面，output放前面，因為通常error就結束了<br>
	 * 如果output在前面，output就會一條一條印，而在後面的話會一次印<br>
	 * @throws Exception
	 */
	public void $2取得sysout() throws Exception {
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec("java -cp " + Utils.getRootFile().getAbsolutePath() + " " + " 執行.TestThread error");
		String line = null;
		InputStream stdout = proc.getInputStream();
		InputStreamReader osr = new InputStreamReader(stdout, "ms950");
		BufferedReader obr = new BufferedReader(osr);
		System.out.println("<output>");
		while ((line = obr.readLine()) != null)
			System.out.println(line);
		System.out.println("</output>");

		InputStream stderr = proc.getErrorStream();
		InputStreamReader esr = new InputStreamReader(stderr, "ms950");
		BufferedReader ebr = new BufferedReader(esr);
		System.out.println("<error>");
		while ((line = ebr.readLine()) != null)
			System.out.println(line);
		System.out.println("</error>");

		int exitVal = proc.waitFor();
		System.out.println("Process exitValue: " + exitVal);
	}

	public void $3用參數執行加判斷os調整() throws Exception {
		String[] args = { "dir" };

		String osName = System.getProperty("os.name");
		System.out.println(osName);
		String[] cmd = new String[3];
		if (osName.startsWith("Windows")) {
			cmd[0] = "cmd.exe";
			cmd[1] = "/C";
			cmd[2] = args[0];
		} else if (osName.equals("Windows 95")) {
			cmd[0] = "command.com";
			cmd[1] = "/C";
			cmd[2] = args[0];
		}
		Runtime rt = Runtime.getRuntime();
		System.out.println("Execing " + cmd[0] + " " + cmd[1] + " " + cmd[2]);
		Process proc = rt.exec(cmd);
		// 把sysout的print用多執行緒去處理，好像是不錯的處理方式
		StreamConsumer errorConsumer = new StreamConsumer(proc.getErrorStream(), "error");
		StreamConsumer outputConsumer = new StreamConsumer(proc.getInputStream(), "output");

		// kick them off
		errorConsumer.start();
		outputConsumer.start();
		// any error???
		int exitVal = proc.waitFor();
		System.out.println("ExitValue: " + exitVal);
	}

	public void $4執行程式僅用於windows() throws Exception {
		//以下都能跑
		//跑pdf
		//Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler z:/mypd.pdf");
		//跑docx
		//Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL "+Utils.getResourceFromRoot("執行/mydoc.docx"));
		//跑pdf
		Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL "+Utils.getResourceFromRoot("執行/mypdf.pdf"));
		p.waitFor();
		System.out.println("Done.");
	}

	public static class StreamConsumer extends Thread {
		InputStream is;
		String type;

		StreamConsumer(InputStream is, String type) {
			this.is = is;
			this.type = type;
		}

		public void run() {
			try {
				InputStreamReader isr = new InputStreamReader(is, "ms950");
				BufferedReader br = new BufferedReader(isr);
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(type + ">" + line);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
