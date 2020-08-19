
class SubClass extends SuperClass
{
  public void test()
  {
	  System.out.println("SubClass method");
  }
  
  public void add(int a,int b)
  {
	  int sum=a+b;
	  System.out.println("Sum of add1 method" +sum);
  }
  public void add(int a,float b)
  {
	  float sum=a+b;
	  System.out.println("Sum of add2 method" +sum);
  }
  public static void main(String args[])
  {
	  SuperClass object1=new SuperClass();
	  object1.test();
	  
	  SuperClass object2=new SubClass();
	  object2.test();
	  
	  SubClass object3=new SubClass();
	  //object3.add(10, 20);
	  //object3.add(10, 2.5);
	  
	  
	  
	  
  }
} 
