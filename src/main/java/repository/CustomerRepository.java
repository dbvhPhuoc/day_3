package repository;
import entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerRepository {
    List<CustomerEntity> findAll();

    List<CustomerEntity> findByName(String name);

    List<CustomerEntity> findByPhoneOrEmail(String phone, String email);

    @Query("SELECT c FROM customer c WHERE c.id = ?1")
    List<CustomerEntity> findByIdAsList(Integer id);

    @Query("SELECT c FROM customer c WHERE c.sex = 'Male' AND YEAR(CURRENT_DATE) - YEAR(c.birdate) BETWEEN 20 AND 30")
    List<CustomerEntity> findMenAgedBetween20And30();
}
