package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSetItr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    // Declaring a HashSet
	    Set<String> hashset = new HashSet<String>();
	    // Add elements to HashSet
	    hashset.add("Pear");
	    hashset.add("Apple");
	    hashset.add("Orange");
	    hashset.add("Papaya");
	    hashset.add("Banana"); 
	    
	    
	    Iterator<String> itr=hashset.iterator();
	    
	    while(itr.hasNext())
	    {
	    	if(itr.next()=="Apple")
	    	{
	    		System.out.println("Aplle found");
	    	}
	    }
	}
}
