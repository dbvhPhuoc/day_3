import config.SpringConfig;
import entity.BookEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.BookRepository;

import java.time.LocalDate;

public class Main {
    static ApplicationContext context= new AnnotationConfigApplicationContext(SpringConfig.class);
    static BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");

    private static void createNewBook (){
        //prepare data
      BookEntity bookEntity = new BookEntity();
      bookEntity.setName("Java A-Z");
      bookEntity.setAuthor("Roger");
      bookEntity.setCategory("IT books");
      bookEntity.setIsbn("ISIBF1219323");
      bookEntity.setNumberOfPage (234);
      bookEntity.setPrice (20.5);
      bookEntity.setPublishDate(LocalDate.parse("2016-08-25"));

      BookEntity result = bookRepository.save(bookEntity);
      if (result != null) {
          System.out.println("A new book saved successfully, book ID = " + bookEntity.getId());
      }
    }
    public static void main(String[] args) {
        createNewBook ();
    }
}

