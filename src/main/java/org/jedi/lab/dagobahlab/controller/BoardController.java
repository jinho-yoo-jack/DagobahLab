package org.jedi.lab.dagobahlab.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jedi.lab.dagobahlab.dto.BoardRequestDto;
import org.jedi.lab.dagobahlab.dto.BoardResponseDto;
import org.jedi.lab.dagobahlab.service.IBoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController implements IBoardController {

    private final IBoardService boardService;

    @Override
    @PostMapping
    public ResponseEntity<BoardResponseDto> createBoard(
            @Valid @RequestBody BoardRequestDto requestDto) {
        BoardResponseDto response = boardService.createBoard(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<BoardResponseDto> getBoard(@PathVariable Long id) {
        BoardResponseDto response = boardService.getBoard(id);
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> getAllBoards() {
        List<BoardResponseDto> response = boardService.getAllBoards();
        return ResponseEntity.ok(response);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<BoardResponseDto> updateBoard(
            @PathVariable Long id,
            @Valid @RequestBody BoardRequestDto requestDto) {
        BoardResponseDto response = boardService.updateBoard(id, requestDto);
        return ResponseEntity.ok(response);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping("/search")
    public ResponseEntity<List<BoardResponseDto>> searchByTitle(@RequestParam String keyword) {
        List<BoardResponseDto> response = boardService.searchByTitle(keyword);
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/author/{author}")
    public ResponseEntity<List<BoardResponseDto>> getByAuthor(@PathVariable String author) {
        List<BoardResponseDto> response = boardService.getByAuthor(author);
        return ResponseEntity.ok(response);
    }
}
