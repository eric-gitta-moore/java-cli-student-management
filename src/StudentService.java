import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StudentService {

    static String pathPrefix;
    static String inputFile;

    static {
        try {
            pathPrefix = Paths.get(StudentService.class.getClassLoader().getResource(".").toURI()).toString();
            inputFile = pathPrefix + "./input-student.txt";

            if (!Files.exists(Paths.get(inputFile))) {
                Files.createFile(Paths.get(inputFile));
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addStudent() throws Exception {
        List<Student> list = new ArrayList<Student>();
        if (new File(inputFile).length() > 0) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile));
            list.addAll((List<Student>) ois.readObject());
            ois.close();
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(inputFile));
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要添加的学号：");
        String id = sc.nextLine();
        System.out.println("请输入要添加的姓名：");
        String name = sc.nextLine();
        System.out.println("请输入要添加的年龄：");
        int age = sc.nextInt();
        System.out.println("请输入要添加的语文成绩：");
        int language = sc.nextInt();
        System.out.println("请输入要添加的数学成绩：");
        int math = sc.nextInt();
        System.out.println("请输入要添加的英语成绩：");
        int english = sc.nextInt();
        Student student = new Student(id, name, age, language, math, english);
        if (student != null) {
            list.add(student);
            System.out.println("添加成功");
        }
        oos.writeObject(list);
        oos.close();
    }

    public static void delete() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile));
        List<Student> list = (List<Student>) ois.readObject();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生学号");
        String id = sc.nextLine();
        Iterator<Student> iterator = list.iterator();
        int num = 0;
        while (iterator.hasNext()) {
            Student stu = iterator.next();
            if (stu.getId().equals(id)) {
                iterator.remove();
                num++;
            }
        }
        if (num > 0) {
            System.out.println("恭喜你删除成功！");
        } else {
            System.out.println("删除失败没有找到你输入的学号，请重新选择");
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(inputFile));
        oos.writeObject(list);
        oos.flush();
        oos.close();
        ois.close();
    }

    public static void updateStudent() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile));
        List<Student> list = (List<Student>) ois.readObject();
        ArrayList<Student> list1 = new ArrayList<>();
        int num = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的学生的学号");
        String id = sc.nextLine();
        for (Student student : list) {
            // System.out.println(student.getId());
            if (id.equals(student.getId())) {
                num++;
                System.out.println("你是否需要修改该学生的姓名？是：1 否：0");
                int i = sc.nextInt();
                if (i == 1) {
                    System.out.println("请输入该学生的姓名：");
                    String newName = sc.nextLine();
                    student.setName(newName);
                }
                System.out.println("你是否需要修改该学生的年龄？是：1 否：0");
                int j = sc.nextInt();
                if (j == 1) {
                    System.out.println("请输入该学生的年龄：");
                    int newAge = sc.nextInt();
                    student.setAge(newAge);
                }
                System.out.println("你是否需要修改该学生的语文成绩？是：1 否：0");
                int k = sc.nextInt();
                if (k == 1) {
                    System.out.println("请输入该学生的语文成绩：");
                    int newLanguage = sc.nextInt();
                    student.setLanage(newLanguage);
                }
                System.out.println("你是否需要修改该学生的数学成绩？是：1 否：0");
                int l = sc.nextInt();
                if (l == 1) {
                    System.out.println("请输入该学生的数学成绩：");
                    int newMath = sc.nextInt();
                    student.setMath(newMath);
                }
                System.out.println("你是否需要修改该学生的英语成绩？是：1 否：0");
                int m = sc.nextInt();
                if (m == 1) {
                    System.out.println("请输入该学生的英语成绩：");
                    int newEnglish = sc.nextInt();
                    student.setEnglish(newEnglish);
                }
                list1.add(student);
            } else {
                list1.add(student);
            }


        }
        if (num > 0) {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(inputFile));
            oos.writeObject(list1);
            oos.flush();
            oos.close();
            ois.close();
        } else {
            System.out.println("对不起你输入的学号不存在，请重新输入");
            updateStudent();
        }
        System.out.println("恭喜你修改成功，是否继续修改？是：1 否：0");
        int n = sc.nextInt();
        if (n == 1) {
            updateStudent();
        } else {
            System.out.println("感谢你的使用，再见！");
        }
    }

    public static void findStudent() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile));
        List<Student> list = (List<Student>) ois.readObject();
        for (Student student : list) {
            System.out.println(student);
        }
        ois.close();
    }

    public static void findStudentById() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile));
        List<Student> list = (List<Student>) ois.readObject();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查找的学生学号");
        String id = sc.nextLine();
        for (Student student : list) {
            if (student.getId().equals(id)) {
                System.out.println(student);
            }
        }
        ois.close();
    }

    public static void findStudentByName() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile));
        List<Student> list = (List<Student>) ois.readObject();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查找的学生姓名");
        String name = sc.nextLine();
        for (Student student : list) {
            if (student.getName().equals(name)) {
                System.out.println(student);
            }
        }
        ois.close();
    }

    public static void sortBySum() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFile));
        List<Student> list = (List<Student>) ois.readObject();
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num = s2.getSum() - s1.getSum();//总分从高到低
                int num2 = num == 0 ? s1.getLanage() - s2.getLanage() : num;
                int num3 = num2 == 0 ? s1.getMath() - s2.getMath() : num2;
                int num4 = num3 == 0 ? s1.getName().compareTo(s2.getName()) : num3;
                return num4;
            }
        });
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(inputFile));
        oos.writeObject(list);
        oos.flush();
        oos.close();
        ois.close();

    }


    public static void viewMain() {
        System.out.println("\t\t\t\t\t\t********************************************************");
        System.out.println("\t\t\t\t\t\t*              请选择以下功能                             *");
        System.out.println("\t\t\t\t\t\t*              ①添加学生成绩                             *");
        System.out.println("\t\t\t\t\t\t*              ②修改学生成绩                             *");
        System.out.println("\t\t\t\t\t\t*              ③删除学生成绩                             *");
        System.out.println("\t\t\t\t\t\t*              ④查看全部学生成绩                          *");
        System.out.println("\t\t\t\t\t\t*              ⑤按学号查看学生成绩                        *");
        System.out.println("\t\t\t\t\t\t*              ⑥按姓名查看学生成绩                        *");
        System.out.println("\t\t\t\t\t\t*              ⑦按总成绩降序排列学生成绩                   *");
        System.out.println("\t\t\t\t\t\t*              ⑧退出                                   *");
        System.out.println("\t\t\t\t\t\t********************************************************");
    }

}
