import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 55L;
    private String id;
    private String name;
    private int age;
    private int lanage;
    private int math;
    private int english;

    public Student() {
    }

    public Student(String id, String name, int age, int lanage, int math, int english) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.lanage = lanage;
        this.math = math;
        this.english = english;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLanage() {
        return lanage;
    }

    public void setLanage(int lanage) {
        this.lanage = lanage;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getSum() {
        return this.lanage + this.math + this.english;
    }

    @Override
    public String toString() {
        return "学号：" + id + "\t" + "姓名：" + name + "\t" + "年龄：" + age + "\t" + "语文成绩：" + lanage + "\t"
            + "数学成绩：" + math + "\t" + "英语成绩：" + english;
    }


}