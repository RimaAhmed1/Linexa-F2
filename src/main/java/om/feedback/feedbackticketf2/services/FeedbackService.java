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
    //view all feedbacks
    public HashMap<Long, Feedback> getAllFeedback() {
        return feedbackStore;
    }
}
//    public  Feedback getFeedback(String id) {
//        for (Feedback currFeedbackObj : feedbackStore) {
//            if (currFeedbackObj.id.equals(id)) {
//                return currFeedbackObj;
//            }
//    }
//        return null;
    }
}