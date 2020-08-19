package AbstractExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Alist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,4,7));
		System.out.println(list.get(1));
		
		Set set=new HashSet();
		set.add(list);
		System.out.println(set);
		list.clear();
		list.addAll(set);
		System.out.println(list);
		
		}

}
