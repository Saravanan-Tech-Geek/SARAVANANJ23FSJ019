package basics;

public class StringDemo {
	public static void main(String[] args) {
		//All data types are by default non-mutable
		
		int i=10;
		int temp=i;
		i=30;
		System.out.println(temp);
		
		String str="hello world";
		String tempstr=str;
		str="my world...";
		
		System.out.println(tempstr);
		
		String obj=new String("hello world...");//create two objects, one in heap and another in stack
		String tempobj=new String(obj);
		obj=obj+"my world...";
		obj=obj+"other world...";
		
		System.out.println(tempobj);
		
		StringBuilder sb=new StringBuilder("hello");//non synchronized methods - Not safe - data manipulation may be erroneous
		StringBuffer sbf=new StringBuffer("hello...");//synchronized methods - Thread safe - data is safe - performance take a back seat
		StringBuilder sbtemp=sb;
		sb.append("hai hai hai...");
		System.out.println(sb);
		System.out.println(sbtemp);
		
		//some methods of string
		
		System.out.println(sb.substring(0, 8));
		System.out.println(sb.charAt(0));
		System.out.println(sb.indexOf("h"));
		String str1="hello world...";
		String str2=new String("hello world...");
		System.out.println(str1.equals(str2));//this check only the values
		System.out.println(str1==str2);//checks the object - which may not same even though the value is same
		
		str1="a";//97
		str2="A";//98
		
		System.out.println(str1.compareTo(str2));
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equalsIgnoreCase(str2));//return true/false by ignoring the case sensitivity
	}
}
