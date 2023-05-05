package com.example.codingtest1.controller;

import com.example.codingtest1.service.BoardService;
import com.example.codingtest1.vo.Board;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.example.codingtest1.service.BoardService.BOARD_LIST;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @RequestMapping(value="/search" , produces ="application/json")
    public ResponseEntity<?> search(@RequestBody String filter) throws JsonProcessingException {
        // 여튼 보드리스트
        List<Board> returnBoardList = new ArrayList<Board>();
        String filterString =  filter.replaceAll("\"","");

        //1. front에서 가져온 search filter 제대로 가져오는지(O)
        System.out.println("프론트에서 가져온 값 : " + filterString);

        //2. BoardService 를 불러오는 것만으로 모든 기존 DB 가져오는지(O)
        System.out.println(BOARD_LIST.toString());

        //3. 해당 Board name 과 일치하는 board 데이터를 찾아옴
        for(Board board : BOARD_LIST){
            if(board.getCategory_nm().equals(filterString) || board.getChild_id().equals(filterString)){
                returnBoardList.add(board);
            }
        }

        //남자 검색하면 남자 한건만 나옴
        System.out.println("데이터 중간정산 ~~ : " + returnBoardList.toString());

        //해당 데이터의 child_id를 뽑아내어 해당 child_id가 parent_idx 인 데이터를 뽑아옴
        //이 작업은 재귀로 진행되며 계속 타고내려감

        for(int i=0;i<returnBoardList.size();i++){
            for(int j=0;j<BOARD_LIST.size();j++){
                if(BOARD_LIST.get(j).getParent_idx().equals(returnBoardList.get(i).getChild_id())){
                    returnBoardList.add(BOARD_LIST.get(j));
                }
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("데이터 최종정산 ~~ : " + returnBoardList.toString());
        String json = mapper.writeValueAsString(returnBoardList);
        //front에 넘겨줌
        System.out.println("json화 : " + json);
        ResponseEntity res = new ResponseEntity<>(json, HttpStatus.OK);
        return res;
    }

}
