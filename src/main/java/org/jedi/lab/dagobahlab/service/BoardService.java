package org.jedi.lab.dagobahlab.service;

import lombok.RequiredArgsConstructor;
import org.jedi.lab.dagobahlab.dto.BoardRequestDto;
import org.jedi.lab.dagobahlab.dto.BoardResponseDto;
import org.jedi.lab.dagobahlab.entity.Board;
import org.jedi.lab.dagobahlab.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService implements IBoardService {

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public BoardResponseDto createBoard(BoardRequestDto requestDto) {
        Board board = Board.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .author(requestDto.getAuthor())
                .viewCount(0L)
                .build();

        Board savedBoard = boardRepository.save(board);
        return BoardResponseDto.from(savedBoard);
    }

    @Override
    @Transactional
    public BoardResponseDto getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다. ID: " + id));

        // 조회수 증가
        board.setViewCount(board.getViewCount() + 1);
        Board updatedBoard = boardRepository.save(board);

        return BoardResponseDto.from(updatedBoard);
    }

    @Override
    public List<BoardResponseDto> getAllBoards() {
        return boardRepository.findAll().stream()
                .map(BoardResponseDto::from)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BoardResponseDto updateBoard(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다. ID: " + id));

        board.setTitle(requestDto.getTitle());
        board.setContent(requestDto.getContent());
        board.setAuthor(requestDto.getAuthor());

        Board updatedBoard = boardRepository.save(board);
        return BoardResponseDto.from(updatedBoard);
    }

    @Override
    @Transactional
    public void deleteBoard(Long id) {
        if (!boardRepository.existsById(id)) {
            throw new IllegalArgumentException("게시글을 찾을 수 없습니다. ID: " + id);
        }
        boardRepository.deleteById(id);
    }

    @Override
    public List<BoardResponseDto> searchByTitle(String keyword) {
        return boardRepository.findByTitleContaining(keyword).stream()
                .map(BoardResponseDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<BoardResponseDto> getByAuthor(String author) {
        return boardRepository.findByAuthor(author).stream()
                .map(BoardResponseDto::from)
                .collect(Collectors.toList());
    }
}
