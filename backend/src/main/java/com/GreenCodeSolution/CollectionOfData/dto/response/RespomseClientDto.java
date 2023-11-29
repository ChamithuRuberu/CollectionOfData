package com.GreenCodeSolution.CollectionOfData.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespomseClientDto {
    private Long id;
    private String fullName;
    private String nic;
    private String birthOfDate;
    private String phone;
    private String address;
    private String gender;
    private String school;
}
