package Student;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);

      StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate)
         context.getBean("BeanTemplate",StudentJDBCTemplate.class);
      
      Student student=new Student();
      student.setName("Student1");
      student.setAge(23);
      
      System.out.println("Records Creation:" );
      studentJDBCTemplate.create(student);
   

      System.out.println("Records Display:" );
      List<Student> students = studentJDBCTemplate.listStudents();
      
      for (Student record : students) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Name : " + record.getName() );
         System.out.println(", Age : " + record.getAge());
      }  
   }
}

