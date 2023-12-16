import java.io.*;
import java.util.*;
import java.util.Collections;

class Student {
    private int id;
    private String firstName;
    private double cgpa;

    public Student() {

    }

    public Student(int id, String firstName, double cgpa) {
        this.id = id;
        this.firstName = firstName;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class CustomComparator implements Comparator<Student> {
    @Override
    public int compare(Student st1, Student st2) {
        int cgpaSt1 = (int) (st1.getCgpa() * 1000);
        int cgpaSt2 = (int) (st2.getCgpa() * 1000);

        if (cgpaSt1 != cgpaSt2) {
            return (cgpaSt1 > cgpaSt2) ? -1 : 1;
        }

        String nameSt1 = st1.getFirstName();
        String nameSt2 = st2.getFirstName();
        if (!nameSt1.equals(nameSt2)) {
            return nameSt1.compareTo(nameSt2);
        }

        return (st1.getId() < st2.getId()) ? -1 : 1;

    }
}

public class PriorityQueueJava {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numOfQuery = Integer.parseInt(in.next());

        PriorityQueue <Student> StudentList = new PriorityQueue<Student>();
        for (int i = 0; i < numOfQuery; ++i) {
            String s = args[0];
            if ( s.equals("ENTER")){
                String firstName = args[1];
                double cgpa = in.nextFloat();
                int id = in.nextInt();   
//            System.out.printf("%d %s %f \n", id, firstName, cgpa);
                Student tmpStudent = new Student(id, firstName, cgpa);
                StudentList.add(tmpStudent);
            }
            else {
                StudentList.poll();
            }
        }
        for (Student st : StudentList) {
            System.out.println(st.getFirstName());
        }
        in.close();
    }
}