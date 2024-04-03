package com.willCompany.socialmediaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.willCompany.socialmediaapi.model.UserPost;
import com.willCompany.socialmediaapi.utils.UserPostId;

import jakarta.transaction.Transactional;

@Repository
public interface UserPostRepository extends CrudRepository<UserPost, UserPostId>{
	
	final String upsertQuery = "INSERT INTO db_socialmedia.user_post (user_id, post_id, is_liked) "
	+ "VALUES (:userId, :postId, :isLiked) " 
	+ "ON DUPLICATE KEY UPDATE is_liked = VALUES(is_liked)";
	
	final String getAllPostsWithDetailsQuery = 
			  "SELECT p.id AS id, p.created_date as createdDate, p.image, p.text, "
			+ "CONCAT(u.first_name, ' ', u.last_name) AS userName, u.profil_image as profilImage, "
			+ "SUM(CASE WHEN up.is_liked = true THEN 1 ELSE 0 END) AS likeCount, "
			+ "CASE WHEN EXISTS ( "
			+ "		SELECT 1 "
			+ "     FROM db_socialmedia.user_post "
			+ "     WHERE post_id = p.id AND user_id = :userId AND is_liked = true "
			+ ") THEN true ELSE false END AS isLiked "
			+ "FROM db_socialmedia.posts p "
			+ "LEFT JOIN db_socialmedia.user_post up ON p.id = up.post_id "
			+ "JOIN db_socialmedia.users u ON p.user_id = u.id "
			+ "GROUP BY p.id;";
	
	@Transactional
	@Modifying
	@Query(value = upsertQuery, nativeQuery = true)
	void upsert(@Param("userId") Long userId, @Param("postId") Long postId, @Param("isLiked") boolean isLiked);
	
	@Query(value = getAllPostsWithDetailsQuery, nativeQuery = true)
	List<Object[]> getAllPostsWithDetails(@Param("userId") Long userId);
	

}