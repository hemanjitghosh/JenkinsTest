package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ListToArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list=new ArrayList<String>();
		list.add("2");
		list.add("6");
		list.add("9");
		list.add("8");
		list.add("6");
		
String val[]=new String[list.size()];
Arrays.asList(val);
		
		for(int i=0;i<list.size();i++)
		{
			val[i]=list.get(i);
			System.out.println(val[i]);
		}
	}
}
