import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Student {
   private String firstname;
   private String lastname;
   private List<Integer> grade;

   public Student() {
   }

   public Student(String firstname, String lastname, List<Integer> grade) {
      this.firstname = firstname;
      this.lastname = lastname;
      this.grade = grade;
   }

   public String getFirstname() {
      return firstname;
   }

   public void setFirstname(String firstname) {
      this.firstname = firstname;
   }

   public String getLastname() {
      return lastname;
   }

   public void setLastname(String lastname) {
      this.lastname = lastname;
   }

   public List<Integer> getGrade() {
      return grade;
   }

   public void setGrade(List<Integer> grade) {
      this.grade = grade;
   }

   @Override
   public String toString() {
      return "Student{" +
              "firstname='" + firstname + '\'' +
              ", lastname='" + lastname + '\'' +
              ", grade=" + grade +
              '}';
   }

   public static List makeStudent() {
      Student student1 = new Student("Pavel","Volya", new ArrayList<Integer>(List.of(2,4,5,5,3)));
      Student student2 = new Student("Denis","Sorokin", new ArrayList<Integer>(List.of(3,3,5,4,4)));
      Student student3 = new Student("Garik","Kharlamov", new ArrayList<Integer>(List.of(5,4,5,2,4)));
      Student student4 = new Student("Misha","Galystyan", new ArrayList<Integer>(List.of(4,4,3,2,4)));
      Student student5 = new Student("Vasya","Rogov", new ArrayList<Integer>(List.of(5,4,4,3,5)));
      Storage.listStudents.add(student1);
      Storage.listStudents.add(student2);
      Storage.listStudents.add(student3);
      Storage.listStudents.add(student4);
      Storage.listStudents.add(student5);
      return Storage.listStudents;
   }

   public static void printInfoStudents(){
      ObjectMapper objectMapper = new ObjectMapper();
      try {
         for (Student allStudents : Storage.listStudents) {
            String json = objectMapper.writeValueAsString(allStudents);
            System.out.println(json);
         }
      } catch (JsonProcessingException e) {
         e.printStackTrace();
      }
   }

//дичь
   public static void printRatingStudents(){
      for (Student value : Storage.listStudents) {
         double ratingStudent = 0;
         value.grade = value.getGrade();
         List<Integer> gradeStudent = value.grade;
         OptionalDouble srRating = gradeStudent.stream()
                 .mapToInt(value1 -> value1)
                 .average();
         if (srRating.isPresent()) {
            ratingStudent = srRating.getAsDouble();
            System.out.println(value.getFirstname() + " " + value.getLastname() + " рейтинг = " + ratingStudent);
         }
      }
   }



//   Рейтинг реализовывать следующим образом:
//   Извлекаешь студентов, запускаешь stream и метод sorted
//
//   Приводишь к листу и выводить)








}

