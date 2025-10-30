package org.jedi.lab.dagobahlab.repository;

import org.jedi.lab.dagobahlab.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByTitleContaining(String keyword);

    List<Board> findByAuthor(String author);
}
