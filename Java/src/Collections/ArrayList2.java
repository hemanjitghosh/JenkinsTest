package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArrayList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list=new ArrayList<String>();
		list.add("2");
		list.add("6");
		list.add("9");
		list.add("8");
		list.add("6");
		
		Set<String> set=new HashSet<String>();
		
		for(int i=0;i<list.size();i++)
		{
			set.add(list.get(i));
		}
		
	
	
	for(String str:set)
	{
		System.out.println(str);
	}
		
		
	}
	
}
