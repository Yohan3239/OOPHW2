public class Q7 {
    public static class Person {
        String f;
        String l;

        public Person(String firstName, String lastName) {
            this.f = firstName;
            this.l = lastName;
        }
        @Override
        public String toString() {
            return f + " " + l;
        }

    }
    public static void testOutput() {
        Person p = new Person("Joe", "Bloggs");
        System.out.println("Person details: " + p);
    }
    public static void main(String[] args) {
        testOutput();
    }
}
