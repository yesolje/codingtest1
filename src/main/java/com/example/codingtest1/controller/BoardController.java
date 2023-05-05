package com.example.codingtest1.controller;

import com.example.codingtest1.service.BoardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @RequestMapping(value="/search" , produces ="application/json")
    public ResponseEntity<?> search(@RequestBody String filter) throws JsonProcessingException {

        //따옴표 제거
        String filterString =  filter.replaceAll("\"","");
        
        //검색결과 및 하위 데이터까지 반환
        String resultJson = boardService.SearchBoardByNameOrId(filterString);

        ResponseEntity res = new ResponseEntity<>(resultJson, HttpStatus.OK);
        return res;
    }

}
