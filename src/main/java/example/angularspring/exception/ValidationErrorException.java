package example.angularspring.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ValidationErrorException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6614525495041548677L;

	public ValidationErrorException(String message){
		 super(message);
	}

}
