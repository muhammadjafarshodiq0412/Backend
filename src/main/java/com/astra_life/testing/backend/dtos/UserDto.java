package com.astra_life.testing.backend.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@Data
public class UserDto {

//    private Long id;
    private String user;
//    @Temporal(TemporalType.DATE)
//    private Date created;
    private String status;
}
