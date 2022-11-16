import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Choose operation: [Q to quit, A to add a student, G to add a grade, P to print GPAs] ");
            String operation = scanner.next();
            if (operation.equals("Q")) {
                System.out.println("Thank you for using GCS. Bye!");
                break;
            }
            if (operation.equals("A")) {
                // constructor, luo uusi oppilas-olio
            }
            if (operation.equals("G")) {
                System.out.print("Please give the name of the student: ");
                // lisää uusi arvosana oppilas olioon
            }
            if (operation.equals("P")) {
                // print all students and their GPAs
            }
        }
    }
}
/*
    class Student {
        public Student (String Name, LinkedList<Integer> Grades){
            this.Name = Name;
            this.Grades = Grades;
        }
        public double GPA () {
            int sum = 0;
            for (int s : Grades){
                sum += s;
            }
            return double (sum / Grades.size())
        }
        LinkedList<Integer> Grades;
        public String Name;
    }

}

 */