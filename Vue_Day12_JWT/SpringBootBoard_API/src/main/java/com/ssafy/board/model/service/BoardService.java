package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;

//사용자 친화적으로 작성
public interface BoardService {
	// 게시글 등록
	void writeBoard(Board board);

	// 게시글 상세 조회
	Board getBoard(int id);

	// 게시글 수정
	boolean modifyBoard(Board board);

	// 게시글 삭제
	boolean removeBoard(int id);

	// 검색 버튼을 눌렀을 때 처리할 메서드
	List<Board> search(SearchCondition condition);
}
