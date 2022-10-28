package com.iot.sec_yr.iot_jdbc_templete.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trip {
    private Integer id;
    private String name;
    private Integer userId;
}
