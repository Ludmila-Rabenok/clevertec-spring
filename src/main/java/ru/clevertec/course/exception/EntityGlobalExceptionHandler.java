package ru.clevertec.course.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class EntityGlobalExceptionHandler {

    public ResponseEntity<EntityIncorrectData> handlerException(NoSuchEntityException e) {
        EntityIncorrectData data = new EntityIncorrectData();
        data.setInfo(e.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<EntityIncorrectData> handlerException(Exception e) {
        EntityIncorrectData data = new EntityIncorrectData();
        data.setInfo(e.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
