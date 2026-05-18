package om.feedback.feedbackticketf2.services;

import om.feedback.feedbackticketf2.models.Feedback;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FeedbackService {
    private final HashMap<Long, Feedback> feedbackStore = new HashMap<>();
    // generating uniq id
    private final AtomicLong counter = new AtomicLong();

    // creating a new feedback
    public Feedback createFeedback(Feedback givenFeedback) {
        Long generatedId = counter.incrementAndGet();
        givenFeedback.setId(generatedId);
        feedbackStore.put(generatedId, givenFeedback);
        return givenFeedback;
    }
}