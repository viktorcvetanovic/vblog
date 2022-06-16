package com.viktor.vblog.api.data;

import lombok.Data;

@Data
public class TimeApi {
    private String abbreviation;
    private String clientIp;
    private String datetime;
    private Integer dayOfWeek;
    private Integer dayOfYear;
    private Boolean dst;
    private String dstFrom;
    private Integer dstOffset;
    private String dstUntil;
    private Integer rawOffset;
    private String timezone;
    private Integer unixtime;
    private String utcDatetime;
    private String utcOffset;
    private Integer weekNumber;

}
