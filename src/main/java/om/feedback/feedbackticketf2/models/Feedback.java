package om.feedback.feedbackticketf2.models;

public class Feedback {
    private Long id;
    private String content;

    public Feedback() {
    }

    public Feedback(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}