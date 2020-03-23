package com.network.api.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TUser implements Serializable {

    private Integer userId;
    private String userName;
    private String password;
    private String address;
    private String userPhone;
    private String IDcard;
    private Integer power;
    private Date birthday;
    private String status;
    private String picture;
    private String school;
    private String major;




}
