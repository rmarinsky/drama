package com.gsmserver.common.data;

import com.gsmserver.web.data.UserDto;

public class UserData {

//    private Faker faker = new Faker();


    public static UserDto getUser() {
        return UserDto.builder()
//                .email(faker.internet().emailAddress())
                .password("test")
                .address("test")
                .birthday("test")
                .city("test")
                .company("test")
                .country("test")
                .name("test")
                .build();
    }

}
