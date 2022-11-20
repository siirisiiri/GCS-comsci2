import java.util.ArrayList;

public class Student { // the class to contain all the data about students
    public Student(String Name) { // constructor, takes only name as parameter
        this.Name = Name;
        this.Grades = new ArrayList<>(); // creates a new arraylist for the grades of the created student
    }

    public String getName () {
        return Name;
    } // name-getter

    public ArrayList<Integer> getGrades () {
        return Grades;
    } // grade-getter

    public void addGrade(ArrayList<Integer> gradesIP){ // adds grades to student object
        for (Integer g : gradesIP){
            Grades.add(g); // adds the given grade from the parameter arraylist of grades to the arraylist of grades of this object
        }
    }

    public double GPA() { // counts the GPA of the grades of this object
        double sum = 0;
        for (int s : Grades) {
            sum += s;
        }
        if (Grades.size() > 0) { // test to see if the number of grades in the list is sensible
            return sum / Grades.size();
        }
        else { // if there's no objects in the arraylist the number of objects is zero but one can't divide by zero and if it's smaller than zero there would also be something wrong
            return sum / 1;
        }
    }

    public String Name;
    public ArrayList<Integer> Grades;
}
