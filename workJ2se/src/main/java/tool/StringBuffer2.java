package tool;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * 
 * 封裝了一下StringBuffer，主要是加入了一個換行寫入的method<br/>
 * 注意的是要寫入時才換行再append String，而不是寫入String之後馬上換行<br>
 * @author ai
 *
 */
public class StringBuffer2 {

	private StringBuffer sb = new StringBuffer();

	public StringBuffer2() {

	}

	public StringBuffer2(String seq) {
		this.sb = new StringBuffer(seq);
	}

	public StringBuffer2(CharSequence seq) {
		this.sb = new StringBuffer(seq);
	}

	public static void main(String args[]) throws IOException {
		StringBuffer2 sb = new StringBuffer2();
		sb.appendln("這是測試換行");
		sb.appendln("okok");
		sb.appendlnLinux("ddd");
		sb.appendlnLinux("ddd");
		sb.appendlnWin("qqqq");
		sb.appendlnWin("qqqq");
		System.out.println(sb.toString());
		FileUtils.write(new File("z:/abc.txt"), sb.toString());
		System.out.println("end");
	}

	public StringBuffer2 appendln(Object o, String line) {
		boolean isLine = false;
		if (sb.length() > 0) {
			isLine = true;
		}
		if (isLine) {
			sb.append(line);
		}
		sb.append(o);
		return this;
	}

	public StringBuffer2 appendln(Object o) {
		return appendln(o, System.getProperty("line.separator"));
	}

	public StringBuffer2 appendlnWin(Object o) {
		return appendln(o, "\r\n");
	}

	public StringBuffer2 appendlnLinux(Object o) {
		return appendln(o, "\n");
	}

	public StringBuffer getStringBuffer() {
		return sb;
	}

	@Override
	public String toString() {
		return sb.toString();
	}

}
