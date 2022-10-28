package com.iot.sec_yr.iot_jdbc_templete.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transport {
    private Integer id;
    private String type;
    private String route;
    private Integer placeId;
}
