package com.example.TestTaskCustomers.objects.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private String fullName;

    private String email;

    private String phone;

    @JsonIgnore
    private boolean isActive;

}
