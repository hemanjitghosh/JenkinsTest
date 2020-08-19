package Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashMApTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List linkedlist=new ArrayList();
		  linkedlist.add("Mango");
		    linkedlist.add("Banana"); 
		    linkedlist.add("Pear");
		    linkedlist.add("Apple");
		    linkedlist.add("Orange");
		    
		    List ll=new LinkedList();
		    for(int i=0;i<linkedlist.size();i++)
		    {
		    	ll.add(linkedlist.get(i));
		    	System.out.println(ll.get(i));
		    }
		
		
		

	}

}
