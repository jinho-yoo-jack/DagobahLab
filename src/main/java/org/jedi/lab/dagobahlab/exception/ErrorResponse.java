package org.jedi.lab.dagobahlab.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "에러 응답 DTO")
public class ErrorResponse {

    @Schema(description = "에러 발생 시각", example = "2025-10-30T14:30:00")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    @Schema(description = "HTTP 상태 코드", example = "400")
    private Integer status;

    @Schema(description = "에러 타입", example = "Validation Failed")
    private String error;

    @Schema(description = "에러 메시지", example = "입력값 검증에 실패했습니다.")
    private String message;

    @Schema(description = "필드별 에러 상세 정보")
    private Map<String, String> errors;
}
