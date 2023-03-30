import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = input.next();
        }
        System.out.println(longestCommonSubstring(words));
    }

    public static String longestCommonSubstring(String[] words) {
        int n = words.length;

		String s = words[0];
		int len = s.length();

		String res = "";

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
 
				String stem = s.substring(i, j);
				int k = 1;
				for (k = 1; k < n; k++){
                    if (!words[k].contains(stem))
                        break;
                }

				if (k == n && res.length() <= stem.length())
                    if(res.length()==stem.length()){
                        if(res.compareTo(stem)>0)
                            res = stem;
                    }
                    else
					    res = stem;
			}
		}

        if(res.length() == 0)
            res+="No common substring";
		return res;
    }
}

//complexity: O(n^2)
