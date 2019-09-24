package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by zhangzhe on 24/9/19.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoUserFoundException extends RuntimeException {
}
