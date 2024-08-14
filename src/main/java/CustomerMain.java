import config.SpringConfig;
import entity.CustomerEntity;
import repository.CustomerRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CustomerMain {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static CustomerRepository customerRepository = (CustomerRepository) context.getBean("customerRepository");
    public static void main(String[] args) {
        addCustomer("Huu Phuoc", LocalDate.of(1998,05,24), "Male", "phuoccdoan240598@gmail.com", "0822965598", "DN");
        listAllCustomers();
        findCustomerById(1);
        findCustomersByName("Huu Phuoc");
        findCustomersByPhoneOrEmail("0822965598", "phuoccdoan240598@gmail.com");
        listMenAgedBetween20And30();

    }
    private static void addCustomer(String name, LocalDate birthdate, String sex, String email, String phone, String address) {
        CustomerEntity customer = new CustomerEntity();
        customer.setName(name);
        customer.setBirthdate(birthdate);
        customer.setSex(sex);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);
//        customerRepository.save(customer);
        System.out.println("Add customer: " + customer);
    }
    private static void listAllCustomers() {
        List<CustomerEntity> customers = (List<CustomerEntity>) customerRepository.findAll();
        for (CustomerEntity customer : customers) {
            System.out.println(customer);
        }
    }
    private static void findCustomerById(int id) {
        Optional<CustomerEntity> customers = customerRepository.findByID(id);
        if (customers.isPresent()) {
            System.out.println(customers);
        } else {
            System.out.println("Customer not found with ID: " + id);
        }
    }
    private static void findCustomersByName(String name) {
        List<CustomerEntity> customers = customerRepository.findByName(name);
        for (CustomerEntity customer : customers) {
            System.out.println(customer);
        }
    }
    private static void findCustomersByPhoneOrEmail(String phone, String email) {
        List<CustomerEntity> customers = customerRepository.findByPhoneOrEmail(phone, email);
        for (CustomerEntity customer : customers) {
            System.out.println(customer);
        }
    }
    private static void listMenAgedBetween20And30() {
        List<CustomerEntity> customers = customerRepository.findMenAgedBetween20And30();
        for (CustomerEntity customer : customers) {
            System.out.println(customer);
        }
    }
}
