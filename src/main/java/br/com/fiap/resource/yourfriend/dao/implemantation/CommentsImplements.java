package br.com.fiap.resource.yourfriend.dao.implemantation;

import br.com.fiap.resource.yourfriend.ConfigSql;
import br.com.fiap.resource.yourfriend.dao.CommentsDao;
import br.com.fiap.resource.yourfriend.domain.Comments;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CommentsImplements implements CommentsDao {

    private List<Comments> comments;
    ConfigSql config = new ConfigSql();


    @Override
    public List<Comments> getAllComments() {
        comments = null;
        try {
            String query = "SELECT * FROM comments";
            Connection conn = config.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if (comments == null) {
                comments = new ArrayList<Comments>();
                while (rs.next()) {
                    Comments newComments = new Comments();
                    newComments.setId(rs.getInt("comments_id"));
                    newComments.setComments(rs.getString("comments_user"));
                    newComments.setDate(rs.getDate("comments_date").toString());
                    newComments.setHours(rs.getTime("comments_date").toString());
                    newComments.setUserId(rs.getInt("user_id"));
                    comments.add(newComments);
                }
            }
            stm.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }

    @Override
    public void insertComments(Comments comments) {
        try {
            String query = "INSERT INTO  COMMENTS(COMMENTS_USER,USER_ID) VALUES(?,?)";
            Connection conn = config.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, comments.getComments());
            ps.setInt(2, comments.getUserId());
            ps.execute();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editComments(Comments comments, int commentsId) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(timestamp.getTime());
            String query = "UPDATE comments SET comments_user=?,comments_date=?  WHERE user_id=? AND comments_id=? ";
            Connection conn = config.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, comments.getComments());
            ps.setString(2, date);
            ps.setInt(3, comments.getUserId());
            ps.setInt(4, commentsId);
            ps.execute();
            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteComments(int id) {
        try {
            String query = "DELETE FROM comments WHERE comments_id=?";
            Connection coon = config.getConnection();
            PreparedStatement ps = coon.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
            coon.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
