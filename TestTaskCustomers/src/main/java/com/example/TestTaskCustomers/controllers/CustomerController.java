package com.example.TestTaskCustomers.controllers;

import com.example.TestTaskCustomers.entities.Customer;
import com.example.TestTaskCustomers.objects.dtos.CustomerDto;
import com.example.TestTaskCustomers.objects.responses.CustomerResponse;
import com.example.TestTaskCustomers.objects.dtos.UpdateCustomerDto;
import com.example.TestTaskCustomers.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
@RequestMapping("api")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<CustomerResponse> create(@RequestBody CustomerDto customerDto) {

        CustomerResponse response = customerService.checkIsDataValidAndCreate(customerDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/customers")
    public ResponseEntity<ArrayList> readAll() {

        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> readOne(@PathVariable Long id) {

        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody UpdateCustomerDto updateCustomerDto) {

        return ResponseEntity.ok(customerService.updateCustomerById(id, updateCustomerDto));
    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable Long id) {

        customerService.deleteCustomerButLeaveHisData(id);
    }
}
