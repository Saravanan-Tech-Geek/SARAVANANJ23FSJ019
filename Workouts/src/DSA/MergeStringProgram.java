package DSA;

class MergeStringProgram {
	public String mergeAlternately(String word1, String word2) {
		int n1 = word1.length();
		int n2 = word2.length();
		String result = "";

		if (n1 == n2) {
			for (int i = 0; i < n1; i++) {
				result = result + Character.toString(word1.charAt(i)) + Character.toString(word2.charAt(i));
				System.out.println("same " + result);
			}
		} else if (n2 > n1) {
			for (int i = 0; i < n1; i++) {
				result = result + Character.toString(word1.charAt(i)) + Character.toString(word2.charAt(i));
				System.out.println("n2 > n1  " + result);
			}

			for (int j = n1; j < n2; j++) {
				result = result + (Character.toString(word2.charAt(j)));
				System.out.println(" second loop n2 > n1  " + result);
			}
		} else {
			for (int i = 0; i < n2; i++) {
				result = result + Character.toString(word1.charAt(i)) + Character.toString(word2.charAt(i));
				System.out.println("n1 >  " + result);
			}
			for (int j = n2; j < n1; j++) {
				result = result + Character.toString(word1.charAt(j));
				System.out.println("n1 > " + result);
			}
		}

		return result;
	}
}
