package com.example.TestTaskCustomers.services.implementations;

import com.example.TestTaskCustomers.entities.Customer;
import com.example.TestTaskCustomers.objects.dtos.CustomerDto;
import com.example.TestTaskCustomers.objects.responses.CustomerResponse;
import com.example.TestTaskCustomers.objects.dtos.UpdateCustomerDto;
import com.example.TestTaskCustomers.repositories.CustomerRepository;
import com.example.TestTaskCustomers.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerResponse checkIsDataValidAndCreate(CustomerDto customerDto) {

        Customer customer = customerRepository.save(Customer.builder()
                .fullName(customerDto.getFullName())
                .email(customerDto.getEmail())
                .phone(customerDto.getPhone())
                .isActive(true)
                .build());

        return new CustomerResponse(customer.getFullName(), customer.getEmail(), customer.getPhone(), customer.getIsActive());
    }

    public ArrayList getAllCustomers() {

        return new ArrayList(customerRepository.findAll());
    }

    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer updateCustomerById(Long id, UpdateCustomerDto updateCustomerDto) {

        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

        BeanUtils.copyProperties(updateCustomerDto, customer);

        return customerRepository.save(customer);
    }

    public void deleteCustomerButLeaveHisData(Long id) {

        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setIsActive(false);

        customerRepository.save(customer);
    }
}
