package om.feedback.feedbackticketf2.controllers;

import om.feedback.feedbackticketf2.models.Feedback;
import om.feedback.feedbackticketf2.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="/coffefeedbacks")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    //get all feedbacks
    @GetMapping
    public ResponseEntity<List<Feedback>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(feedbackService.getAllFeedbacks());
    }

    // get the feedback by id
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getSpecificFeedback(@PathVariable Long id) {
        Feedback foundFeedback = feedbackService.getFeedback(id);
        if (foundFeedback == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(foundFeedback);
    }
    // create feedback
    @PostMapping
    public ResponseEntity<Feedback> storeIncomingFeedback(
            @RequestBody Feedback incomingFeedback) {
        Feedback createdFeedback = feedbackService.createFeedback(incomingFeedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFeedback);
    }
}
