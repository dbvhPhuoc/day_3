package repository;

import entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository  extends CrudRepository<BookEntity, Integer> {
    // Get all books where author= Roger
    List<BookEntity> findByAuthor (String author);
    // Get all books where author Roger and price = 100
    List<BookEntity> findByAuthorAndPrice (String author, double price);
    // Get all books where price= 100 or number of page = 150
    List<BookEntity> findByPriceOrNumberOfPage(double price, int numOfPage);
    // Get all books where price < 100
    List<BookEntity> findByPriceLessThan (double price);
    // Get all books where price >= 120
    List<BookEntity> findByPriceGreaterThanEqual (double price);
    // Get all books where book name containing "ja"
    List<BookEntity> findByNameContaining (String searchWords);
    // Get book where isbn = 121131212
    BookEntity findByIsbn (String isbn);
    // Get all books where publish date is after 2015-12-12
    List<BookEntity> findByPublishDateAfter (LocalDate date);

    @Query("select b from BookEntity b where b.name like ?1%") //?1: param 1, ?2: param 2
    List<BookEntity> getBookNameStartWith (String name);

    @Query(value = "select from book b where b.price < ?1 and b.numberPage >= ?2", nativeQuery = true)
    List<BookEntity> getBookWherePriceLessThanAndNumOfPageGreaterThan (double price, int numOfPage);
}
