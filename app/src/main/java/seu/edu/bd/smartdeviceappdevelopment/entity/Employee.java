package seu.edu.bd.smartdeviceappdevelopment.entity;

public class Employee {
    private String id;
    private String name;
    private String salary;
    private String age;
    private String pic;

    public Employee(String id, String name, String salary, String age, String pic) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.pic = pic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
