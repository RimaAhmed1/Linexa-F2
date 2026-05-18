package om.feedback.feedbackticketf2.services;

import om.feedback.feedbackticketf2.models.Feedback;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FeedbackService {
    private final HashMap<Long, Feedback> feedbackStore = new HashMap<>();

    // generating uniq id
    private final AtomicLong counter = new AtomicLong();

    //getting all feedback
    public List<Feedback> getAllFeedbacks() {
        return new ArrayList<>(feedbackStore.values());
    }

    //getting specific feedback by id
    public Feedback getFeedback(Long id) {
        return feedbackStore.get(id);
    }

    // creating a new feedback
    public Feedback createFeedback(Feedback givenFeedback) {
        Long generatedId = counter.incrementAndGet();
        givenFeedback.setId(generatedId);
        feedbackStore.put(generatedId, givenFeedback);
        return givenFeedback;
    }
    // delete feedback
    public Feedback removeFeedback(Long id) {
        return feedbackStore.remove(id);
    }
}