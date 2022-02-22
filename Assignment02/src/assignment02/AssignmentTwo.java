package assignment02;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class AssignmentTwo {
	
	public static void main(String[] args)
	{	
		try (Scanner sc = new Scanner(System.in)) 
		{
			System.out.println("Problem01: How many strings u want to enter"); 
			int intg = Integer.parseInt(sc.nextLine()); 
			String[] a = new String[intg];
			System.out.println("Please enter " + intg + " Strings"); 
			for(int j = 0 ; j < a.length ; j++)
			{
				a[j] = sc.nextLine(); 
			}
			Problem01(a); 
			
			//----------------------------------------
			
			System.out.println("Problem02: How many strings u want to enter ?"); 
			int intg2 = Integer.parseInt(sc.nextLine()); 
			String[] b = new String[intg2];
			System.out.println("Please enter " + intg2 + " Strings"); 
			for(int j = 0 ; j < b.length ; j++) 
			{ 
				b[j] = sc.nextLine(); 
			}
			System.out.println(Problem02(b));
			
			//----------------------------------------
			
			
			System.out.println("Problem03: How many strings u want to enter ?");
			int intg3 = Integer.parseInt(sc.nextLine());
			Integer[] c = new Integer[intg3];
			System.out.println("Please enter " + intg3 + " numbers"); 
			for(int j = 0 ; j < c.length ; j++) 
			{	c[j] = Integer.parseInt(sc.nextLine());
			}
			System.out.println(Problem03(c));

			//----------------------------------------
			
			System.out.println("Problem04:How many strings u want to enter ?");
			int intg4 = Integer.parseInt(sc.nextLine()); 
			ArrayList<String> d = new ArrayList<>(); 
			System.out.println("Please enter " + d + " Strings");
			for(int j = 0 ; j < intg4 ; j++) 
			{
				d.add(sc.nextLine()); 
			}
			System.out.println(Problem04(d));
			
			//----------------------------------------
			  
			System.out.println("Problem05: How many strings u want to enter ?"); 
			int intg5 = Integer.parseInt(sc.nextLine());
			ArrayList<String> e = new ArrayList<>(); 
			System.out.println("Please enter " + intg5 + " Strings");
			for(int j = 0 ; j < intg5 ; j++) 
			{
				e.add(sc.nextLine()); 
			}
			System.out.println(Problem05(e));
			
			//----------------------------------------
			
			System.out.println("Problem06: How many strings u want to enter ?");
			int intg6 = Integer.parseInt(sc.nextLine()); 
			ArrayList<String> f = new ArrayList<>();
			System.out.println("Please enter " + intg6 + " Strings");
			for(int j = 0 ; j < intg6 ; j++) 
			{
				f.add(sc.nextLine());
			}
			System.out.println(Problem06(f));
		}
		catch (NumberFormatException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//-------------------------
	//Methods here 
	//-------------------------
	
	public static void Problem01(String[] S) 
	{
		Map<String,Integer> map = new HashMap<>();
		for(String items : S)
		{
			if(!map.containsKey(items) && !items.isEmpty())
			{
				map.put(items, 1);
			}
			else
			{
				map.computeIfPresent(items, (k, v) -> v + 1);
			}
		}
		
		System.out.println(map);
	}
	
	public static Map<String,String> Problem02(String[] S2)
	{
		Map<String,String> m = new HashMap<>();
		
		for(String items : S2) 
		{
			String value = "";
			for(int j=0;j<S2.length;j++)
			{
				if(items.charAt(0) == S2[j].charAt(0)) 
				{
					value = value + S2[j];
				}
			}
			if(!m.containsKey(items.charAt(0) + ""))
				m.put(items.charAt(0) + "", value);
		}
		
		return m;
	}
	
	public static Set<Integer> Problem03(Integer[] A) 
	{
		Set<Integer> S = new LinkedHashSet<>();
		for(int j=0 ; j < A.length ; j++) {
			if(!S.contains(A[j])) {
				S.add(A[j]);
			}
			else {
				S.add( A[j] + 1 );
			}
		}
		
		
		return S;
	}

	public static ArrayList<String> Problem04(ArrayList<String> q)
	{
		ArrayList<String> q1 = new ArrayList<>();
		for(String item : q) 
		{
			q1.add(removeDuplicates(item));
		}
		
		return q1;
	}
	
	static String removeDuplicates(String s)   
    {      
        LinkedHashSet<Character> set = new LinkedHashSet<>();   
        for(int j=0;j<s.length();j++)   
            set.add(s.charAt(j));   
        
        StringBuilder sb = new StringBuilder();
        for (Character character : set) {
            sb.append(character);
        }
        
        return sb.toString();
           
    } 

	public static Map<String,String> Problem05(ArrayList<String> v)
	{
		Map<String, String> A = new HashMap<>();
		
		for(String items : v)
		{
	        int m = items.length();
	        String first = "" + items.charAt(0);
	        String last = "" + items.charAt(m - 1); 
	        A.put(first, last);
		}
		return A;
	}
	
	public static Map<String,Boolean> Problem06(ArrayList<String> S1)
	{
		Map<String,Boolean> A1 = new HashMap<>();
		Map<String,Integer> M1 = new HashMap<>();
		
		for(String item : S1) 
		{
			if(!M1.containsKey(item)) 
			{
				M1.put(item, 1);
			}
			else
			{
				int value = M1.get(item);
				M1.put(item, value + 1);
			}
		}
		
		for (Map.Entry<String,Integer> item : M1.entrySet()) 
		{
			if(item.getValue() >= 2) 
			{
				A1.put(item.getKey(), true);
			}
			else
			{
				A1.put(item.getKey(), false);
			}
		}
		return A1;
	}
}