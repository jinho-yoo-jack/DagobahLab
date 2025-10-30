package org.jedi.lab.dagobahlab.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "게시판 작성/수정 요청 DTO")
public class BoardRequestDto {

    @Schema(
            description = "게시글 제목",
            example = "Spring Boot 게시판 만들기",
            required = true,
            maxLength = 200
    )
    @NotBlank(message = "제목은 필수 입력 항목입니다.")
    @Size(max = 200, message = "제목은 200자를 초과할 수 없습니다.")
    private String title;

    @Schema(
            description = "게시글 내용",
            example = "Spring Boot와 JPA를 활용한 게시판 CRUD 구현 방법에 대해 알아봅니다.",
            required = true
    )
    @NotBlank(message = "내용은 필수 입력 항목입니다.")
    private String content;

    @Schema(
            description = "작성자 이름",
            example = "홍길동",
            required = true,
            maxLength = 50
    )
    @NotBlank(message = "작성자는 필수 입력 항목입니다.")
    @Size(max = 50, message = "작성자명은 50자를 초과할 수 없습니다.")
    private String author;
}
