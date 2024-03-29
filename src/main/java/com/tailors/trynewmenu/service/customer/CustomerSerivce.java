package com.tailors.trynewmenu.service.customer;

import com.tailors.trynewmenu.domain.customer.Customer;
import com.tailors.trynewmenu.domain.customer.CustomerRepository;
import com.tailors.trynewmenu.service.customer.exception.CustomerNotFoundException;
import com.tailors.trynewmenu.service.customer.exception.EmailUsedException;
import com.tailors.trynewmenu.service.customer.exception.RemoveCustomerException;
import com.tailors.trynewmenu.ui.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerSerivce {
    @Autowired
    CustomerRepository customerRepository;

    public Customer getById(UUID customerId) {
        return customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
    }

    public Customer createNewCustomer(Customer customer) {
        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
            throw new EmailUsedException();
        }

        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.findById(customer.getAccountId()).map(c -> {
            c.update(customer);
            return customerRepository.save(c);
        }).orElseThrow(CustomerNotFoundException::new);
    }

    public void deleteCustomer(UUID customerId) {
        try {
            customerRepository.deleteById(customerId);
        } catch (Exception e) {
            throw new RemoveCustomerException(e);
        }
    }
}
