package openbook;


abstract class AbstractParent {
    // Instance variable
    protected int instanceVariable;

    // Instance block
    {
        instanceVariable = 0;
        System.out.println("Instance block in AbstractParent executed.");
    }

    // Static block
    static {
        System.out.println("Static block in AbstractParent executed.");
    }

    // Constructor
    public AbstractParent(int value) {
        this.instanceVariable = value;
        System.out.println("AbstractParent constructor executed with value: " + value);
    }

    // Abstract method to be implemented by subclasses
    public abstract void abstractMethod();

    // Regular method
    public void nonAbstractMethod() {
        System.out.println("Non-abstract method in AbstractParent.");
    }
}

public class ChildClass extends AbstractParent {
    // Constructor for ChildClass
    public ChildClass(int value) {
        super(value);
        System.out.println("ChildClass constructor executed.");
    }

    // Implementation of the abstract method from the parent class
    @Override
    public void abstractMethod() {
        System.out.println("Abstract method implemented in ChildClass.");
    }

    // Additional method in ChildClass
    public void childMethod() {
        System.out.println("Additional method in ChildClass.");
    }

    public static void main(String[] args) {
        ChildClass child = new ChildClass(42);
        child.abstractMethod();
        child.nonAbstractMethod();
        child.childMethod();
    }
}
