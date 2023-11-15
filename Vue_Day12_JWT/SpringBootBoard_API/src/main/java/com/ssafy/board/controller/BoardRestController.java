package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.BoardService;


@RestController
@RequestMapping("/api")
public class BoardRestController {
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private BoardService boardService;

	// 1. 목록
	@GetMapping("/board")
	public ResponseEntity<?> list(SearchCondition condition) {
		List<Board> list = boardService.search(condition);
		
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	// 2. 상세보기
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable int id) {
		Board board = boardService.getBoard(id);
		if (board != null)
			return new ResponseEntity<Board>(board, HttpStatus.OK);
		return new ResponseEntity<Board>(HttpStatus.NOT_FOUND);
	}

	// 3. 등록
	@PostMapping("/board")
	public ResponseEntity<Board> write(@RequestBody Board board) {
		boardService.writeBoard(board);
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}

	// 4. 삭제
	@DeleteMapping("/board/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if (boardService.removeBoard(id))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

	// 5. 수정
	@PutMapping("/board")
	public ResponseEntity<String> update(@RequestBody Board board) {
		if (boardService.modifyBoard(board))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

}
