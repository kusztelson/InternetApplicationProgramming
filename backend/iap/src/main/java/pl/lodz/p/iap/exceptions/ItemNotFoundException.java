package pl.lodz.p.iap.exceptions;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

public abstract class ItemNotFoundException extends ErrorResponseException {

    public ItemNotFoundException(String message, String path, String title) {
        super(HttpStatus.NOT_FOUND, problemDetailForm(message, path, title), null);
    }

    private static ProblemDetail problemDetailForm(String message, String path, String title) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, message);
        problemDetail.setType(URI.create("http://localhost:8080/errors/not-found"));
        problemDetail.setTitle(title);
        problemDetail.setInstance(URI.create(path));
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }


}
