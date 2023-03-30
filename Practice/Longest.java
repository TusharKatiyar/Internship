
//write optimized java code 

import java.util.Scanner;

public class Longest {
static int palindrome(String str)
{
int size = str.length();
int maxLen = 1,start=0;
int low, high;
for (int i = 0; i < size; i++) {
low = i - 1;
high = i + 1;
while ( high < size && str.charAt(high) == str.charAt(i)) //check for even length palindrome
high++;
while ( low >= 0 && str.charAt(low) == str.charAt(i)) //check for odd length palindrome
low--;
while (low >= 0 && high < size && str.charAt(low) == str.charAt(high) ){ 
low--;
high++;
}

int length = high - low - 1;
if (maxLen < length){
maxLen = length;
start=low+1;
}
}
System.out.println(str.substring(start, start + maxLen ));
return maxLen;
}


public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
String str = input.nextLine();
palindrome(str);
input.close();
}
}