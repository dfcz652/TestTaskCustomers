package com.example.TestTaskCustomers.objects.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CustomerDto {

    private String fullName;

    private String email;

    private String phone;
}
