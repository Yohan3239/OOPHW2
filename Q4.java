public class Q4 {
    public class Device {
        public void initialise() {
            System.out.println("Device");
        }

    
    }
    public class Phone extends Device {
        @Override
        public void initialise() {
            System.out.println("Phone");
        }
    }
    
}