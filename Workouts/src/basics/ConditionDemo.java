package basics;

public class ConditionDemo {
	public static void main(String[] args) {
		/*
		 * if-else-if ladder
		 * switch case
		 * ternary
		 */
		for(int i=0;i<10;i++) {
			if(i%2==0) {
				continue;
			}
			System.out.println(i);
		}
		String day="sunday";
		boolean holiday=true;
		if(holiday && day.equals("sunday")) {
			System.out.println("normal holiday....");
		}
		else if(day.equals("saturday") && holiday) {
			System.out.println("yet to follow narayana murthy....");
		}
		else {
			System.out.println("normal working day...");
		}
		
		//Ternary Operator - ?
		String result=(!day.equals("saturday"))?"for true":"for false";
		System.out.println(result);
		result=(day.equals("saturday"))?holiday?"hurray holiday..":"working day...":"its not a saturday....";
		System.out.println(result);
		
		//switch case
		//an alternate for if-else-if and ternary
		//switch case started supporting string and enum from jdk5
		//prior to that we had support only for int, char etc
		
		switch(day) {
		case "sunday":{
			System.out.println("its sunday...");
			break;
		}
		case "saturday":{
			System.out.println("its saturday...");
			break;
		}
		default:{
			System.out.println("not a sat nor sun..");
		}
		}
		
		MyEnum me=MyEnum.uiux;
		switch(me){
		case uiux:{
			
		}
		case java:{
			
		}
		}
	}
}