package com._6bitcampers.nangman_doctor.baedongwoo.data.mapper;

import com._6bitcampers.nangman_doctor.baedongwoo.data.dto.ReviewDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewInter {
    @Select("select * from hospital_review order by review_no desc limit #{startnum},#{perPage}")
    public List<ReviewDto> getPagenationedReviews(Map<String,Integer> pagination);
    @Select("select count(*) from hospital_review")
    public int getAllReviewsCount();
    @Select("select * from hospital_review where review_no=#{review_no}")
    public ReviewDto getReviewBySeq(int review_no);
    @Insert("insert into hospital_review (review_title,review_content,review_writeday,employee_no,user_no,review_likecount) values (#{review_title},#{review_content},now(),#{employee_no},#{user_no},#{review_likecount})")
    public void addReview(ReviewDto reviewDto);
    @Update("update hospital_review set review_title=#{review_title}, review_content=#{review_content},review_likecount=#{review_likecount} where review_no=#{review_no}")
    public void updateReview(ReviewDto reviewDto);
    @Delete("delete from hospital_review where review_no=#{review_no}")
    public void deleteReview(int review_no);
    @Update("update hospital_review set review_viewcount=review_viewcount+1 where review_no=#{review_no}")
    public void updateViewcount(int review_no);
}
