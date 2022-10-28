package com.iot.sec_yr.iot_jdbc_templete.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Owner {
    private Integer id;
    private String name;
    private String surname;
}
