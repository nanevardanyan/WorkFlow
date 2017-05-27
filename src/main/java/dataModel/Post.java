package dataModel;

import java.util.Date;

/**
 * Created by nane on 5/26/17.
 */
public class Post {
    private long postId;
    private long answerId;
    private long userId;
    private long appAreaId;
    private Date timestamp;
    private String title;
    private String content;
    private boolean isCorrect;

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAppAreaId() {
        return appAreaId;
    }

    public void setAppAreaId(long appAreaId) {
        this.appAreaId = appAreaId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
