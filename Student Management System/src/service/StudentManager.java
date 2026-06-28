package service;

import entities.Student;

import java.util.ArrayList;

public class StudentManager {
   private final ArrayList<Student> studentList = new ArrayList<>();

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student  s){
        if(s.getAge() <= 0){
            System.out.println("Wrong parameter");
            return;
        }
        else if(s.getGrade() < 0 || s.getGrade()> 100){
            System.out.println("Wrong Parameters for Grade");
            return;
        }
        for(Student student : studentList){
            if(student.getId() == s.getId()){
                System.out.println("Student ID already exists!");
                return;
            }
        }
        studentList.add(s);
        System.out.println("Added Successfully");

    }
    public void viewAllStudents() {

        if(studentList.isEmpty()){
            System.out.println("No records found");
            return;
        }

        System.out.println("\n================ STUDENT RECORDS ================\n");

        System.out.printf(
                "%-10s %-20s %-10s %-10s %-30s%n",
                "ID", "NAME", "AGE", "GRADE", "SUBJECTS"
        );

        System.out.println(
                "--------------------------------------------------------------------------------"
        );

        for(Student s : studentList){

            System.out.printf(
                    "%-10d %-20s %-10d %-10.2f %-30s%n",
                    s.getId(),
                    s.getName(),
                    s.getAge(),
                    s.getGrade(),
                    s.getSubjects()
            );
        }
    }
    public void searchStudentByID(int id){
        boolean found = false;
        for (Student s:studentList){
            if(id == s.getId()) {
                found = true;
                System.out.println(s);
                break;
            }
        }
        if(!found){
            System.out.println("No record found");
        }

    }
    public void update(int id, double grade, ArrayList<String> subjects ){
        boolean found=false;
       for(Student s : studentList){
           if(id == s.getId()){
               found = true;
               s.setGrade(grade);
               s.setSubjects(subjects);
           break;
           }

       }
       if(found)
       { System.out.println("Updated Successfully");}
       else{
           System.out.println("Students Not Found");
       }


    }

    public void deleteStudentData(int studID){

        boolean removed = studentList.removeIf(student -> student.getId() == studID);

        if (removed) {
            System.out.println("Successfully Deleted");
        }
        else
            System.out.println("Students not found");
    }

    public double calculateClassAvg(){
        if(studentList.isEmpty()){
            return 0;
        }
        double sum = 0, avg = 0;
        for(Student student:studentList){
            sum = sum + student.getGrade();
        }
        avg = sum / studentList.size();
        return avg;

    }


    public void searchStudentByName(String stdName) {
        boolean found = false;
        for (Student s:studentList){
            if(stdName.equalsIgnoreCase(s.getName())) {
                found = true;
                System.out.println(s);
                break;
            }
        }
        if(!found){
            System.out.println("No record found");
        }
    }
}
