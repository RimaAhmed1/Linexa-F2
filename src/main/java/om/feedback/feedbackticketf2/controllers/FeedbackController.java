package om.feedback.feedbackticketf2.controllers;
import om.feedback.feedbackticketf2.models.Feedback;
import om.feedback.feedbackticketf2.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(path="/coffefeedbacks")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    // create feedback
    @PostMapping
    public ResponseEntity<Feedback> storeIncomingFeedback(
            @RequestBody Feedback incomingFeedback) {
        Feedback createdFeedback = feedbackService.createFeedback(incomingFeedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFeedback);
    }

    //deleting feedback endpoint
    @DeleteMapping("/{id}")
    public ResponseEntity<Feedback> deleteSpecificFeedback(@PathVariable Long id) {
        Feedback deletedFeedback = feedbackService.deleteFeedback(id);
         if (deletedFeedback == null) {
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.status(HttpStatus.OK).body(deletedFeedback);
    }
}

