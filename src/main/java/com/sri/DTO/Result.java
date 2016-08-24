package com.sri.DTO;

/**
 * Created by srinidhis on 22/08/16.
 */
//A custom result class to obtain the result
public class Result {
    private int dayIssuesCount;
    private int weekIssuesCount;
    private int longtermIssuesCount;

    public int getDayIssuesCount() {
        return dayIssuesCount;
    }

    public void setDayIssuesCount(int dayIssuesCount) {
        this.dayIssuesCount = dayIssuesCount;
    }

    public int getWeekIssuesCount() {
        return weekIssuesCount;
    }

    public void setWeekIssuesCount(int weekIssuesCount) {
        this.weekIssuesCount = weekIssuesCount;
    }

    public int getLongtermIssuesCount() {
        return longtermIssuesCount;
    }

    public void setLongtermIssuesCount(int longtermIssuesCount) {
        this.longtermIssuesCount = longtermIssuesCount;
    }
}
