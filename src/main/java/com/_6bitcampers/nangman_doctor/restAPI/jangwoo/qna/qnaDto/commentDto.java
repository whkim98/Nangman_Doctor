package com._6bitcampers.nangman_doctor.restAPI.jangwoo.qna.qnaDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Alias("commentDto")
public class commentDto {
    private String comment_comment;
    private String employee_nickname;
    private int qna_no;
}
