package br.com.fiap.resource.yourfriend.domain;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Comments {
     int id;
     String comments;
     String date;
     String hours;
     int  userId;

     public String getHours() {
          return hours;
     }

     public void setHours(String hours) {
          this.hours = hours;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getComments() {
          return comments;
     }

     public void setComments(String comments) {
          this.comments = comments;
     }

     public String getDate() {
          return date;
     }

     public void setDate(String date) {
          this.date = date;
     }

     public int getUserId() {
          return userId;
     }

     public void setUserId(int userId) {
          this.userId = userId;
     }
}
