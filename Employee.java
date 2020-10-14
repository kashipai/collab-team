public class Employee {
    private String name;
    private int age;
    private Address addrs;

    public Employee(String name, int age,Address addrs){
        this.name = name;
        this.age = age;
        this.addrs=addrs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddrs() {
        return addrs;
    }

    public void setAddrs(Address addrs) {
        this.addrs = addrs;
    }
}
