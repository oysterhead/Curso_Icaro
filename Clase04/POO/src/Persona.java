public class Persona {
    private String fullName;
    private int age;

    public Persona(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "fullName='" + this.fullName + '\'' +
                ", age=" + this.age +
                '}';
    }

}
