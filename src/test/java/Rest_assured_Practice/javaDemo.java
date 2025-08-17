package Rest_assured_Practice;

public class javaDemo {
public static void main(String[] args) {
	String org = "bhagvanta";
	String rev=" ";
	for (int i=org.length()-1;i>0;i--)
		{
			rev=rev+org.charAt(i);
		}
	System.out.println(rev);
	System.out.println(org);
	if (org.equals(rev))
	{
		System.out.println("is pallindrome");
	}
	else
	{
		System.out.println("not pallindrome");
	}
}
}
