package net.andy.customer.repository;

import net.andy.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author edward
 * @date 2017/11/12
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
