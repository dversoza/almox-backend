package dvtech.dev.almoxcontrol.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Barraca não encontrada pelo ID especificado")
public class BarracaNotFoundException extends RuntimeException {
    public BarracaNotFoundException(String message) {
        super(message);
    }
}
