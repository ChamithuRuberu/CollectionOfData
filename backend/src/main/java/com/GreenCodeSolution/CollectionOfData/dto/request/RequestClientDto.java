package com.GreenCodeSolution.CollectionOfData.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestClientDto {

    private String fullName;
    private String nic;
    private String birthOfDate;
    private String phone;
    private String address;
    private String gender;
    private String school;
}
