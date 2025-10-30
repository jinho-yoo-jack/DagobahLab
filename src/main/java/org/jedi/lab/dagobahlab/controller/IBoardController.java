package org.jedi.lab.dagobahlab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.jedi.lab.dagobahlab.dto.BoardRequestDto;
import org.jedi.lab.dagobahlab.dto.BoardResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "게시판 API", description = "게시판 CRUD API")
public interface IBoardController {

    @Operation(summary = "게시글 생성", description = "새로운 게시글을 생성합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "게시글 생성 성공",
            content = @Content(schema = @Schema(implementation = BoardResponseDto.class))),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 데이터")
    })
    ResponseEntity<BoardResponseDto> createBoard(
        @Valid @RequestBody BoardRequestDto requestDto);

    @Operation(summary = "게시글 조회", description = "ID로 게시글을 조회합니다. 조회 시 조회수가 1 증가합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "조회 성공",
            content = @Content(schema = @Schema(implementation = BoardResponseDto.class))),
        @ApiResponse(responseCode = "404", description = "게시글을 찾을 수 없음")
    })
    ResponseEntity<BoardResponseDto> getBoard(
        @Parameter(description = "게시글 ID", example = "1")
        @PathVariable Long id);

    @Operation(summary = "게시글 목록 조회", description = "모든 게시글 목록을 조회합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "조회 성공",
            content = @Content(schema = @Schema(implementation = BoardResponseDto.class)))
    })
    ResponseEntity<List<BoardResponseDto>> getAllBoards();

    @Operation(summary = "게시글 수정", description = "ID로 게시글을 수정합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "수정 성공",
            content = @Content(schema = @Schema(implementation = BoardResponseDto.class))),
        @ApiResponse(responseCode = "400", description = "잘못된 요청 데이터"),
        @ApiResponse(responseCode = "404", description = "게시글을 찾을 수 없음")
    })
    ResponseEntity<BoardResponseDto> updateBoard(
        @Parameter(description = "게시글 ID", example = "1")
        @PathVariable Long id,
        @Valid @RequestBody BoardRequestDto requestDto);

    @Operation(summary = "게시글 삭제", description = "ID로 게시글을 삭제합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "삭제 성공"),
        @ApiResponse(responseCode = "404", description = "게시글을 찾을 수 없음")
    })
    ResponseEntity<Void> deleteBoard(
        @Parameter(description = "게시글 ID", example = "1")
        @PathVariable Long id);

    @Operation(summary = "게시글 제목 검색", description = "제목에 키워드가 포함된 게시글을 검색합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "검색 성공",
            content = @Content(schema = @Schema(implementation = BoardResponseDto.class)))
    })
    ResponseEntity<List<BoardResponseDto>> searchByTitle(
        @Parameter(description = "검색 키워드", example = "안녕")
        @RequestParam String keyword);

    @Operation(summary = "작성자별 게시글 조회", description = "특정 작성자의 모든 게시글을 조회합니다.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "조회 성공",
            content = @Content(schema = @Schema(implementation = BoardResponseDto.class)))
    })
    ResponseEntity<List<BoardResponseDto>> getByAuthor(
        @Parameter(description = "작성자명", example = "홍길동")
        @PathVariable String author);
}
