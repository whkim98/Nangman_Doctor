package com._6bitcampers.nangman_doctor.servingPackage.jangwoo.login.loginEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Alias("userEntity")
public class userEntity {
    //not null
    private String user_name;
    private String user_email;
    private String user_role;
    private String user_type;

    //null
    private String user_password;
    private String user_gender;
    private String user_addr;
    private String user_hp;
    private String user_age;
    private String user_nickname;
    private String user_interest;
}
