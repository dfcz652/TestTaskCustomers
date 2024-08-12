package com.example.TestTaskCustomers.objects.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UpdateCustomerDto {

    private Long id;

    private String fullName;

    private String phone;
}
