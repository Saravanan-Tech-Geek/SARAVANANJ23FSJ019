package string_revision;

import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StringDemo3 {
	public static void main(String[] args) {
		String st = "Hello world,program";
		StringTokenizer str = new StringTokenizer(st);
		while(str.hasMoreTokens()) {
			System.out.println(str.nextToken());
		}
//		while(str.hasMoreElements()) {
//			System.out.println(str.nextElement());
//		}
		String stp = ",";
		StringJoiner sj = new StringJoiner(stp);
		sj.add("hi");
		sj.add("dude");
		sj.add("welcome");
		System.out.println(sj);
	}
}
