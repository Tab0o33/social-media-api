package com.willCompany.socialmediaapi.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PostWithDetailsDTO {

    private Long id;
    private String userName;
    private LocalDateTime createdDate;
    private String profilImage;
    private String image;
    private String text;
    private Long likeCount;

    @JsonProperty("isLiked")
    private boolean isLiked;

    public PostWithDetailsDTO(Object[] row) {
        this.id = (Long) row[0];
        this.userName = (String) row[4];
        this.createdDate = (LocalDateTime) ((Timestamp) row[1]).toLocalDateTime();
        this.profilImage = (String) row[5];
        this.image = (String) row[2];
        this.text = (String) row[3];
        this.likeCount = (Long) ((BigDecimal) row[6]).longValue();
        this.isLiked = (Integer) row[7] == 0 ? false : true;
    }

}
