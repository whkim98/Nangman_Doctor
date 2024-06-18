package com._6bitcampers.nangman_doctor.woohyeong.Service;

import com._6bitcampers.nangman_doctor.woohyeong.Mapper.reservationMapperW;
import com._6bitcampers.nangman_doctor.woohyeong.dto.ReservationDTOW;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("reservationServiceW")
public class reservationServiceW {
    private final reservationMapperW reservationMapper;

    public reservationServiceW(reservationMapperW reservationMapper) {
        this.reservationMapper = reservationMapper;
    }

    public void insertSurvey(ReservationDTOW dto){
        reservationMapper.insertSurvey(dto);
    }

    public void updateSurvey(Map<String, Object> map){
        reservationMapper.updateSurvey(map);
    }

    public int getEmployeeNo(String employee_email){
        return reservationMapper.getEmployeeNo(employee_email);
    }
}
