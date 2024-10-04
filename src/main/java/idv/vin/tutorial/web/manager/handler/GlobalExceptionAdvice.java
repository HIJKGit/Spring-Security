package idv.vin.tutorial.web.manager.handler;


import idv.vin.tutorial.web.model.ApiResponse;
import idv.vin.tutorial.web.model.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Object> nullPointerException(NullPointerException e) {
        log.error(e.getMessage(), e);
        return new ApiResponse<>(ResultCode.SYSTEM_ERROR);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Object> missingServletRequestParamException(MissingServletRequestParameterException e) {
        log.error(e.getMessage(), e);
        return new ApiResponse<>(ResultCode.VALIDATE_ERROR);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Object> noResourceFoundException(NoResourceFoundException e) {
        log.error(e.getMessage(), e);
        return new ApiResponse<>(ResultCode.RESOURCE_ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Object> exception(Exception e) {
        log.error(e.getMessage(), e);
        return new ApiResponse<>(ResultCode.SYSTEM_ERROR);
    }
}
