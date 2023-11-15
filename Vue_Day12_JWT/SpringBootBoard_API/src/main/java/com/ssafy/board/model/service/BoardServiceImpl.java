package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	@Transactional
	@Override
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
	}

	@Override
	public Board getBoard(int id) {
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Transactional
	@Override
	public boolean modifyBoard(Board board) {
		return boardDao.updateBoard(board) > 0;
	}

	@Transactional
	@Override
	public boolean removeBoard(int id) {
		return boardDao.deleteBoard(id) == 1;
	}

	@Override
	public List<Board> search(SearchCondition condition) {
		return boardDao.search(condition);
	}

}
