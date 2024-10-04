package idv.vin.tutorial.web.model.enums;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(true, "請求成功"),
    FAILED(false, "請求失敗"),
    TIMEOUT(false, "系統連線逾時"),
    VALIDATE_ERROR(false, "資料驗證失敗"),
    SYSTEM_ERROR(false, "系統錯誤"),
    RESOURCE_ERROR(false, "查無資料"),
    JPA_OPTIMISTIC_LOCK_ERROR(false, "資料同步異常，請進行重試");

    ResultCode(boolean successful, String message) {
        this.successful = successful;
        this.message = message;
    }

    private final String message;
    private final boolean successful;
}
