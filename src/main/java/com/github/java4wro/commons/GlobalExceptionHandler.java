package com.github.java4wro.commons;

import com.github.java4wro.event.EventNotFoundException;
import com.github.java4wro.ticket.TicketNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EventNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleEventNotFoundException(EventNotFoundException e){
        return new ResponseEntity<>
                (String.format("Ticket with uuid: %s doesn't exist",e.getEventUuid()),
                        HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TicketNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleTicketNotFoundException(TicketNotFoundException e){
        return new ResponseEntity<>
                (String.format("Event with uuid: %s doesn't exist",e.getTicketUuid()),
                        HttpStatus.BAD_REQUEST);
    }
}
