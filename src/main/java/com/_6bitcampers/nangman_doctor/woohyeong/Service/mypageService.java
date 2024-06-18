package com._6bitcampers.nangman_doctor.woohyeong.Service;

import com._6bitcampers.nangman_doctor.woohyeong.Mapper.mypageMapper;
import com._6bitcampers.nangman_doctor.woohyeong.dto.EmployeeDTO;
import com._6bitcampers.nangman_doctor.woohyeong.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mypageService {
    private final mypageMapper mypageMapper;

    @Autowired
    public mypageService(mypageMapper mypageMapper) {
        this.mypageMapper = mypageMapper;
    }

    public UserDTO getUser(String user_email){
        return mypageMapper.getUser(user_email);
    }

    public EmployeeDTO getEmployee(String user_email){
        return mypageMapper.getEmployee(user_email);
    }
}