package DefiningClasses.OpinionPoll;

public class Person {
    //полета
    private String name;
    private int age;


    //конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //методи
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

