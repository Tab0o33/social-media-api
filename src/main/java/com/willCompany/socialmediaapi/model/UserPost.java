package com.willCompany.socialmediaapi.model;

import com.willCompany.socialmediaapi.utils.UserPostId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@IdClass(UserPostId.class)
@Table(name = "user_post")
public class UserPost {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "is_liked")
    private boolean isLiked;

}
