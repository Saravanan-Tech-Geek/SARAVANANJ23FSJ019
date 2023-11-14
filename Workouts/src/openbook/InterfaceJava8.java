package openbook;

//Functional Interface with a single abstract method
@FunctionalInterface
interface MyFunctionalInterface {
 void abstractMethod();

 // Default method (introduced in Java 8)
 default void defaultMethod() {
     System.out.println("Default method implementation");
 }

 // Static method (introduced in Java 8)
 static void staticMethod() {
     System.out.println("Static method in interface");
 }
}

//Another interface with a default method
interface AnotherInterface {
 default void anotherDefaultMethod() {
     System.out.println("Another default method implementation");
 }
}

//A class implementing the interfaces
class MyClass implements MyFunctionalInterface, AnotherInterface {
 @Override
 public void abstractMethod() {
     System.out.println("Abstract method implementation");
 }
}

public class InterfaceJava8 {
 public static void main(String[] args) {
     MyClass myClass = new MyClass();
     
     // Call abstract method
     myClass.abstractMethod();
     
     // Call default methods from both interfaces
     myClass.defaultMethod();
     myClass.anotherDefaultMethod();
     
     // Call static method from the interface
     MyFunctionalInterface.staticMethod();
 }
}

