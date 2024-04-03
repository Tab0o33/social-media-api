package com.willCompany.socialmediaapi.utils;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class UserPostId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long user;
    private Long post;
    
    public UserPostId() {
		// Constructeur sans arguments requis par Hibernate
	}

    public UserPostId(Long userId, Long postId) {
        this.user = userId;
        this.post = postId;
    }

}
