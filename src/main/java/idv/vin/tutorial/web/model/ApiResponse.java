package idv.vin.tutorial.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import idv.vin.tutorial.web.model.enums.ResultCode;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ApiResponse<T> {
    private String message;
    private String description;
    private boolean successful;
    private T data;

    public ApiResponse(ResultCode resultCode) {
        this.successful = resultCode.isSuccessful();
        this.message = resultCode.getMessage();
    }

    public ApiResponse(ResultCode resultCode, T data) {
        this(resultCode);
        this.data = data;
    }

    public ApiResponse(ResultCode resultCode, T data, String description) {
        this(resultCode, data);
        this.description = description;
    }

    public ApiResponse<T> setResultCode(ResultCode resultCode) {
        this.successful = resultCode.isSuccessful();
        this.message = resultCode.getMessage();
        return this;
    }
}
