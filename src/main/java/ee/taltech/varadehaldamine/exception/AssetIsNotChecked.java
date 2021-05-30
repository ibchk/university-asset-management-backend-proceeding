package ee.taltech.varadehaldamine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AssetIsNotChecked extends RuntimeException {

    public AssetIsNotChecked(String message) { super(message); }
}
