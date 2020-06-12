public class Representative implements Comparable 
{
	private String district;
	private String firstName;
	private String lastName;
	private int birthMonth;
	private int birthDay;
	private int birthYear;
	private String party;
	private int firstElected;
	
	public Representative(String d, String f, String l, int bm, int bd, int by, String p, int e) 
	{
		district = d;
		firstName = f;
		lastName = l;
		birthMonth = bm;
		birthDay = bd;
		birthYear = by;
		party = p;
		firstElected = e;
	}
	
	public int compareTo(Object other) 
	{
		Representative rep = (Representative) other;
		int num = birthYear - rep.birthYear;
		if(num == 0) num = birthMonth - rep.birthMonth;
		if(num == 0) num = birthDay - rep.birthDay;
		return num;
	}
	
	public String getName()
	{
		return firstName + " " + lastName;
	}
	
	public String getLastName ( )
	{
		return lastName;
	}
	
	public String toString() 
	{
		return String.format("  %-20s%-25s  %2d  %2d%6d  %-14s%6d",district,firstName + " " + lastName,birthMonth,birthDay,birthYear,party,firstElected);
	}
}