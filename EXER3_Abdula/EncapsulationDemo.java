public class EncapsulationDemo {
    public static void main(String[] args) {
        Person person = new Person();

        // Using setter methods to set values
        person.setName("Alice");
        person.setAge(30);

        // Using getter methods to retrieve values
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}
