package com.example.codingtest1.service;

import com.example.codingtest1.vo.Board;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    public static ArrayList<Board> BOARD_LIST = new ArrayList<>();

    public BoardService() { //BoardService 선언 시에 초기 게시판 데이터 넣기
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
        BOARD_LIST.add(new Board("4","14","익명게시판"));
        BOARD_LIST.add(new Board("5","14","익명게시판"));
    }

    //SearchBoardByNameOrId
    //검색 String 을 받아 검색 결과와 일치하는 Board 및 하위 카테고리 JSON 형태로 반환
    public String SearchBoardByNameOrId(String filterString) throws JsonProcessingException {

        List<Board> returnBoardList = new ArrayList<Board>();
        ObjectMapper mapper = new ObjectMapper();
        
        //검색결과와 일치하는 결과건 출력
        for(Board board : BOARD_LIST){
            if(board.getCategory_nm().equals(filterString) || board.getChild_id().equals(filterString)){
                returnBoardList.add(board);
            }
        }
        System.out.println("검색결과와 일치하는 결과건 출력: " + returnBoardList.toString());

        //재귀작업 - 하위 카테고리 탐색
        for(int i=0;i<returnBoardList.size();i++){
            for(int j=0;j<BOARD_LIST.size();j++){
                if(BOARD_LIST.get(j).getParent_idx().equals(returnBoardList.get(i).getChild_id())){
                    returnBoardList.add(BOARD_LIST.get(j));
                }
            }
        }
        System.out.println("검색결과 및 하위 데이터까지 출력: " + returnBoardList.toString());
        
        //json 변환
        String json = mapper.writeValueAsString(returnBoardList);
        return json;
    }
}
