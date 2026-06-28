
import entities.Student;
import service.StudentManager;
import util.FileHandler;

import java.util.*;
public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      StudentManager studentManager = new StudentManager();
      int choice;


      do{
          System.out.println("--STUDENT MANAGEMENT SYSTEM--");
          System.out.println("1. Add Student");
          System.out.println("2. View Students");
          System.out.println("3. Search Student");
          System.out.println("4. Update Student");
          System.out.println("5. Delete Student");
          System.out.println("6.Display Class Average");

          System.out.println("7. Exit");

          System.out.print("Enter your Choice: ");
          choice = sc.nextInt();
          sc.nextLine();

          switch (choice){
              case 1:
                  System.out.print("Enter Student ID Number: ");
                  int studID = sc.nextInt();
                  sc.nextLine();

                  System.out.print("Enter Student Name: ");
                  String name = sc.nextLine();

                  System.out.print("Enter Student Age: ");
                  int age = sc.nextInt();
                  sc.nextLine();

                  System.out.print("Enter Student Grade: ");
                  double grade = sc.nextDouble();
                  sc.nextLine();

                  System.out.println("How many subjects are there?");
                  int x = sc.nextInt();
                  sc.nextLine();
                  System.out.println("Add Subjects: ");

                  ArrayList<String> subjects = new ArrayList<>();
                  for(int i=1;i<=x;i++){
                      String s = sc.nextLine();
                      subjects.add(s);
                  }

                  Student student = new Student(studID,name,age,grade,subjects);
                  studentManager.addStudent(student);

                  break;

              case 2:
                  studentManager.viewAllStudents();
                  break;

              case 3:
                  System.out.println("Press 1. To search Student by ID");
                  System.out.println("Press 2. To search Student by Name");
                  int ch = sc.nextInt();
                  sc.nextLine();
                  if(ch == 1){
                  System.out.print("Enter Student ID Number: ");
                  int id = sc.nextInt();
                  sc.nextLine();
                  studentManager.searchStudentByID(id);}
                  else if(ch == 2){
                      System.out.print("Enter Student Name: ");
                     String stdName = sc.nextLine();

                      studentManager.searchStudentByName(stdName);
                  }
                  break;

              case 4:

                  System.out.print("Enter ID Number of the Student: ");
                  int ID = sc.nextInt();
                  sc.nextLine();

                  System.out.println("Update the Grade and Subjects of the Student: ");



                  System.out.print("Enter updated grade: ");
                  double updatedGrade = sc.nextDouble();
                  sc.nextLine();

                  System.out.println("How many subjects are there?");
                  int xx = sc.nextInt();
                    sc.nextLine();
                  ArrayList<String> updatedSubjects = new ArrayList<>();
                  System.out.println("Enter Updated subjects: ");
                  for(int i = 1;i<=xx;i++){
                      String sub = sc.nextLine();
                      updatedSubjects.add(sub);
                  }

                  studentManager.update(ID,updatedGrade,updatedSubjects);
                  break;

              case 5:
                  System.out.print("Enter Student ID for the deletion of Student record: ");
                  int id2 = sc.nextInt();
                  sc.nextLine();
                  System.out.println("Are you sure Y/N?");
                  String ch1 = sc.nextLine();
                  if(ch1.equalsIgnoreCase("Y"))
                  {studentManager.deleteStudentData(id2);}
                  break;
              case 6:
                  System.out.println("The class average is "+studentManager.calculateClassAvg());
                  break;
              case 7:
                  FileHandler.save(studentManager.getStudentList());
                  System.out.println("Saved in the file successfully");
                  System.out.println("Exiting.......");
                  break;
              default:
                  System.out.println("Invalid Choice");


          }

      }while(choice !=7);
      sc.close();

    }
}