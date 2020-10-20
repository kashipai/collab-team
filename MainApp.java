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
      
      System.out.println("Records Creation:" );
      studentJDBCTemplate.create("Student1", 11);
      studentJDBCTemplate.create("student2", 2);
      studentJDBCTemplate.create("student3", 15);

      System.out.println("Records Display:" );
      List<Student> students = studentJDBCTemplate.listStudents();
      
      for (Student record : students) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Name : " + record.getName() );
         System.out.println(", Age : " + record.getAge());
      }  
   }
}
