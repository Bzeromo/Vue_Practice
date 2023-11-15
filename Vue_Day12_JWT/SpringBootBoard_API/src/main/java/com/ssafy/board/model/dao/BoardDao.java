package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;

public interface BoardDao {
	// ID에 해당하는 게시글 하나 가져오기
	public Board selectOne(int id);

	// 게시글 등록
	public void insertBoard(Board board);

	// 게시글 삭제
	public int deleteBoard(int id);

	// 게시글 수정
	public int updateBoard(Board board);

	// 조회수 증가
	public void updateViewCnt(int id);

	// 검색 기능
	public List<Board> search(SearchCondition condition);

}
