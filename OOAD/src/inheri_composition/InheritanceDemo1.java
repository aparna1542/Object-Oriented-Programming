package inheri_composition;

/**
 * @(#)InheritanceDemo1.java
 *
 *
 * @author 
 * @version 1.00 2012/6/13
 */

class UniversityPerson{
   protected String name;
   private String ssn;

   public UniversityPerson(String name,String ssn){
      this.name = name;
      this.ssn = ssn;
   }
   public UniversityPerson(){
   // Calling the constructor with two arguments
      this ("Not set","Not set"); //passing this to constructor with argument
   }
   public void print() 
   {
	   System.out.println("Name: "+name);
		System.out.println("SSN: "+ssn); 
   }
}

////////////////////////////////////////////////////////
class Student extends UniversityPerson  {
    private String major;

    public Student(String name,String ssn,String major){
    	//referring to super class instance,this has to be the first call inside this constructor
    	super (name,ssn); 
      this.major = major; 
   }
    public Student(){
      this("Not set","Not set","Not set");
   }
   // Overrides and extends the method print () in the base class
   @Override
   public void print() {

   /*The following statement will not compile because, a private variable of
   the base class cannot be accessed in the derived class
   System.out.println("SSN: "+ssn); }
   Call the print () of base class to print the base class members */
 
   	super.print(); //without the keyword super the print() function is going to become recursive endless
	
   	System.out.println("Major: "+major);
   	System.out.println("Name is " + name);
}
}



public class InheritanceDemo1 {
        
    public static void main(String[] args) {
            Student s1 = new Student("Mary Jones","111409999","Computer Engineering");
    		UniversityPerson s2= new UniversityPerson();
           // s1.print();
            s2.print();

    }
}
