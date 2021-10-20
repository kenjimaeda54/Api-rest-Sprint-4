package br.com.fiap.resource.yourfriend.dao;

import br.com.fiap.resource.yourfriend.domain.Comments;

import java.util.List;

public interface CommentsDao {
    List<Comments> getAllComments();
    void   insertComments(Comments comments);
    void   editComments(Comments comments,int id);
    void   deleteComments(int id);

}
