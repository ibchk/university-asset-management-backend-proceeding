package ee.taltech.varadehaldamine.Varadehaldamine.Service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCommentException  extends RuntimeException{
    public InvalidCommentException() {
    }

    public InvalidCommentException(String message) {
        super(message);
    }
}
