package org.jedi.lab.dagobahlab.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jedi.lab.dagobahlab.entity.Board;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "게시판 응답 DTO")
public class BoardResponseDto {

    @Schema(
            description = "게시글 고유 식별자",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            description = "게시글 제목",
            example = "Spring Boot 게시판 만들기",
            maxLength = 200
    )
    private String title;

    @Schema(
            description = "게시글 본문 내용",
            example = "Spring Boot와 JPA를 활용한 게시판 CRUD 구현 방법에 대해 알아봅니다."
    )
    private String content;

    @Schema(
            description = "작성자 이름",
            example = "홍길동",
            maxLength = 50
    )
    private String author;

    @Schema(
            description = "게시글 조회수 (자동 증가)",
            example = "42",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long viewCount;

    @Schema(
            description = "게시글 최초 작성 일시",
            example = "2025-10-30T14:30:00",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(
            description = "게시글 최종 수정 일시",
            example = "2025-10-30T15:45:00",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;

    public static BoardResponseDto from(Board board) {
        return BoardResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .author(board.getAuthor())
                .viewCount(board.getViewCount())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }
}
