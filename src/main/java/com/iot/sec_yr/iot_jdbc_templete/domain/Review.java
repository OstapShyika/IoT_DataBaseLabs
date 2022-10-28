package com.iot.sec_yr.iot_jdbc_templete.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Review {
    private Integer id;
    private Integer rating;
    private String description;
    private Integer userId;
    private Integer placeId;
}
