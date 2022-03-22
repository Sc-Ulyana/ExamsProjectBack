package com.example.examsprojectback.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.examsprojectback.domain.Result;
import java.util.ArrayList;

@Mapper
public interface ResultMapper {
    ArrayList<Result> selectAllResults();

    ArrayList<Result> selectResultsByUserId(int id);

    ArrayList<Result> selectResultsByApplicantId(int id);

    Result selectResultById(int id);

    int selectCountOfApplicantResults(int id);

    double selectApplicantAvgMark(int id);

    void insertResult(Result result);

    void updateResult(Result result);

    void deleteResult(int id);
}
