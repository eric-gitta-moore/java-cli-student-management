import java.util.Scanner;

public class StudentMain {

    public static void main(String[] args) throws Exception {
        System.out.println("\t\t\t\t\t\t********************************************************");
        System.out.println("\t\t\t\t\t\t*                                                      *");
        System.out.println("\t\t\t\t\t\t*              欢迎使用学生成绩管理系统                     *");
        System.out.println("\t\t\t\t\t\t*                                                      *");
        StudentService.viewMain();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你要选择的功能序号：");
        int i = sc.nextInt();
        while (1 == 1) {
            switch (i) {
                case 1:
                    StudentService.addStudent();
                    break;
                case 2:
                    StudentService.updateStudent();
                    break;
                case 3:

                    StudentService.delete();
                    break;
                case 4:
                    StudentService.findStudent();
                    break;
                case 5:
                    StudentService.findStudentById();
                    break;
                case 6:
                    StudentService.findStudentByName();
                    break;
                case 7:
                    StudentService.sortBySum();
                    break;
                case 8:
                    System.out.println("谢谢使用，再见!");
                    System.exit(0);

                default:
                    System.out.println("你输入的序号不正确，请重新输入");
                    break;
            }
            StudentService.viewMain();
            System.out.print("请输入你要选择的功能序号：");
            i = sc.nextInt();


        }
    }
}