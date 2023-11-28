package com.GreenCodeSolution.CollectionOfData.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    private long id;
    private String fullName;
    private String nic;
    private String birthOfDate;
    private String phone;
    private String address;
    private String gender;
    private String school;


    }
