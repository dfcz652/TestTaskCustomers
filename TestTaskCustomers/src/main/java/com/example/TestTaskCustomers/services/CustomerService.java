package com.example.TestTaskCustomers.services;

import com.example.TestTaskCustomers.entities.Customer;
import com.example.TestTaskCustomers.objects.dtos.CustomerDto;
import com.example.TestTaskCustomers.objects.responses.CustomerResponse;
import com.example.TestTaskCustomers.objects.dtos.UpdateCustomerDto;

import java.util.ArrayList;

public interface CustomerService {

    CustomerResponse checkIsDataValidAndCreate(CustomerDto customerDto);

    ArrayList getAllCustomers();

    Customer getCustomerById(Long id);

    Customer updateCustomerById(Long id, UpdateCustomerDto updateCustomerDto);

    void deleteCustomerButLeaveHisData(Long id);
}
