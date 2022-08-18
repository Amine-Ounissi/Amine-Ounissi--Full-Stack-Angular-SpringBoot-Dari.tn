package tn.Dari.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Resource extends RuntimeException{

	private static final long serialVersUID= 1L;
	public Resource(String message ) {
		super(message);
	}
}
