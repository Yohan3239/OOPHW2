public class Q5 {
    public static void main(String[] args) {
        NinjaEmployee ne = new NinjaEmployee(3, "Yohan", new Ninja());

        ne.attack();     
        ne.showId();
    }
    public static class Employee {
        int id;
        String name;
        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public void showId() {
            System.out.println("Employee ID: " + id);
        }
    }

    public static interface NinjaActions {
        void attack();
    }
    public static class Ninja implements NinjaActions {
        public void attack() {
            System.out.println("Attack");
        }
    }
    public static class NinjaEmployee extends Employee implements NinjaActions {
        Ninja N;
        public NinjaEmployee(int id, String name, Ninja ninja) {
            super(id, name);
            this.N = ninja;
        }
        @Override
        public void attack() {
            N.attack();
        }
    }

}
