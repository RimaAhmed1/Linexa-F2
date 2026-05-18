package om.feedback.feedbackticketf2.services;
import om.feedback.feedbackticketf2.models.Feedback;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    //view all feedbacks
    public HashMap<Long, Feedback> getAllFeedbacks() {
        return feedbackStore;
    }

    //updating Feedback
    public Feedback updateFeedback(Long id, Feedback modifidedFeedback) {

        Feedback createdFeedback = feedbackStore.get(id);
        if (createdFeedback == null) {
            return null;
        }
        createdFeedback.setContent(modifidedFeedback.getContent());
        feedbackStore.put(id, createdFeedback);
        return createdFeedback;
    }
     //deleting feedback by id
    public Feedback deleteFeedback(Long id) {
      return feedbackStore.remove(id);
    }
}