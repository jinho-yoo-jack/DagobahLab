package org.jedi.lab.dagobahlab.service;

import org.jedi.lab.dagobahlab.dto.BoardRequestDto;
import org.jedi.lab.dagobahlab.dto.BoardResponseDto;

import java.util.List;

public interface IBoardService {

    BoardResponseDto createBoard(BoardRequestDto requestDto);

    BoardResponseDto getBoard(Long id);

    List<BoardResponseDto> getAllBoards();

    BoardResponseDto updateBoard(Long id, BoardRequestDto requestDto);

    void deleteBoard(Long id);

    List<BoardResponseDto> searchByTitle(String keyword);

    List<BoardResponseDto> getByAuthor(String author);
}
