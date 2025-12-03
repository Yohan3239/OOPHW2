
public class Q1 {
    public class exampleClass {

        int Num;
        public exampleClass(int num) {
            Num = num;
        }
        public void exampleMethod() {
            Num += 1;
        }
    }

    public abstract class exampleAbstract {
        int hello;

        public abstract void abstractMethod(); //must be implemented in child class
        public void normalMethod() { 
            //must be implemented here
        }; 
    }
    public class Child extends exampleAbstract {
        public Child() {

        }
        @Override
        public void abstractMethod() {
            hello += 1;
        }
    }
    public interface exampleInterface {

        void interfaceMethod();

    }
    public class InterfaceChild implements exampleInterface {
        @Override
        public void interfaceMethod() {
            System.out.println("Hello");
        }
    }

}