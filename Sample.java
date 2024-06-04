package iodemo;

import java.util.LinkedList;
import java.util.List;
@FunctionalInterface
interface Method
{
  void callMethod(String str);
}
 class AClass {

	  private List<Method> methods = new LinkedList<>();
	  {
	  methods.add( new Method()
	  {
	    public void callMethod(String str){
	      System.out.println("method A " + str);
	    }
	  });

	  methods.add( new Method()
	  {
	    public void callMethod(String str){
	      System.out.println("method B "+str);
	    }
	  });

	  methods.add( new Method()
	  {
	    public void callMethod(String str){
	      System.out.println("method C "+str);
	    }
	  });
	  }
	  //50 more methods. 
	  //method call the rest
	  public void callAll(String[] parts)
	  {
		  int index = 0;
	     for (Method method : methods) {
	        method.callMethod(parts[index]);
	        index++;
	     }
	  }
	}

public class Sample {
public static void main(String[] args) {
	String line = "first/second/third";
	String[] parts = line.split("/");
AClass obj = new AClass();
obj.callAll(parts);


}
}
