public class Test_Inheritance {
    public void methodOne(int i) {
    }
    public void methodTwo(int i) {
    }
    public static void methodThree(int i) {
    }
    public static void methodFour(int i) {
    }
}

//instance and static methods cant have same names..they cant hide each other
class ClassB extends Test_Inheritance {
  //Compile err
	//  public static void methodOne(int i) { }
    
    public void methodTwo(int i) {
    }
  //Compile err
   // public void methodThree(int i) { }
    public static void methodFour(int i) {
    }
}

