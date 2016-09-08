package com.sri.api;

import com.google.common.base.Predicate;
import com.sri.DTO.IssueResponseDTO;
import com.sri.DTO.Result;
import com.sri.utilities.TimeUtility;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by srinidhis on 22/08/16.
 */
//A custom result generator which splits the issues based on time and returns the result object
  @Configuration
public class ResultGenerator {
 //Get the issue count split on basis of time frames ,format it to result object
    public Result getIssuesBasedOnTime(List<IssueResponseDTO> issueResponseDTOs){
        Result result = new Result();
        int totalIssues=issueResponseDTOs.size();
        result.setDayIssuesCount(getIssuesCountForTerm(issueResponseDTOs,1));
        result.setWeekIssuesCount(getIssuesCountForTerm(issueResponseDTOs,7)-result.getDayIssuesCount());
        result.setLongtermIssuesCount(totalIssues-result.getDayIssuesCount()-result.getWeekIssuesCount());
        return result;
    }
//get the count of issues for the term specified in the paramater
    private int getIssuesCountForTerm(List<IssueResponseDTO> issueResponseDTOs, int i) {
        return (issueResponseDTOs.stream().filter(issueResponseDTO -> (System.currentTimeMillis() - TimeUtility.getUTCTimeStamp(issueResponseDTO.getCreated_at())) <= 86400000 * i).collect(Collectors.toList())).size();
    }
}

