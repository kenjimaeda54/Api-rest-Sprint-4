package br.com.fiap.resource.yourfriend.service;

import br.com.fiap.resource.yourfriend.dao.CommentsDao;
import br.com.fiap.resource.yourfriend.dao.implemantation.CommentsImplements;
import br.com.fiap.resource.yourfriend.domain.Comments;

import java.util.List;

public class CommentsService {
    CommentsImplements commentsDao = new CommentsImplements();


    public List<Comments> getAllComments() {
        return commentsDao.getAllComments();
    }

    public void insertComments(Comments comments) {
        commentsDao.insertComments(comments);
    }

    public void editComments(Comments comments, Integer commentsId) {
        commentsDao.editComments(comments, commentsId);
    }

    public void deleteComments(Integer id) {
        commentsDao.deleteComments(id);
    }
}
