package com.gsmserver.web.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String city;
    private String zip;
    private String country;
    private String company;
    private String sex;
    private String birthday;

}
