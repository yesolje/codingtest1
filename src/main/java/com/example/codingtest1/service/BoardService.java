package com.example.codingtest1.service;

import com.example.codingtest1.vo.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BoardService {

    public static ArrayList<Board> BOARD_LIST = new ArrayList<>();

    public BoardService() { //BoardService 선언 시에 초기 게시판 데이터 넣기
        BOARD_LIST.add(new Board("0","0","익명게시판"));
        BOARD_LIST.add(new Board("0","1","남자"));
        BOARD_LIST.add(new Board("0","2","여자"));
        BOARD_LIST.add(new Board("1","3","엑소"));
        BOARD_LIST.add(new Board("1","4","방탄소년단"));
        BOARD_LIST.add(new Board("2","5","블랙핑크"));
        BOARD_LIST.add(new Board("3","6","공지사항"));
        BOARD_LIST.add(new Board("3","7","첸"));
        BOARD_LIST.add(new Board("3","8","백현"));
        BOARD_LIST.add(new Board("3","9","시우민"));
        BOARD_LIST.add(new Board("4","10","공지사항"));
        BOARD_LIST.add(new Board("4","11","뷔"));
        BOARD_LIST.add(new Board("5","12","공지사항"));
        BOARD_LIST.add(new Board("5","13","로제"));
    }

    public ArrayList<Board> searchByName(String boardName){
        return null;
    }

    public String searchByIdx(){
        return null;
    }
}
