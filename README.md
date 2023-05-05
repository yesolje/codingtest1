<h1>한터글로벌 코딩테스트 1번 문제</h1>
<h2>1.결과화면</h2>
<span>"남자" 검색 시</span>
<img src="https://user-images.githubusercontent.com/70881757/236487747-89a7b31c-d7dd-4901-927a-ae2047c5d26d.png">
<span>"방탄소년단" 검색 시</span>
<img src="https://user-images.githubusercontent.com/70881757/236487935-08bff420-e8ab-459d-995e-16b14624ea02.png">
<span>"로제" 검색 시</span>
<img src="https://user-images.githubusercontent.com/70881757/236488091-8b8326f3-4361-4dec-aabf-b6487f41e678.png">
<span>"공지사항" 검색 시</span>
<img src="https://user-images.githubusercontent.com/70881757/236488197-0c4f0985-3944-4916-9b72-cd57a6692392.png">
<span>"익명게시판" 검색 시</span>
<img src="https://user-images.githubusercontent.com/70881757/236488278-b6440f2a-cb26-4cb6-923b-101cbb0bc8e7.png">
  
<h2>2.코드 및 풀이</h2>  
BoardController에서는 RequestBody를 통해 클라이언트 단에서 검색 값(게시판 명 또는 id)를 받아 Service 단으로 전달하고<br/>
결과값을 클라이언트로 회신합니다<br/><br/>
<img src="https://user-images.githubusercontent.com/70881757/236490922-3e9d25e6-ccea-477f-941d-6cd037f399ea.png"><br/>
BoardService 는 크게 두가지 기능을 수행합니다.<br/>
첫번째는 게시판 샘플 데이터의 선언과 생성이고 두번째는 검색기능입니다.<br/>
해당 과제에서는 DB 없이 Java 자료형으로 게시판 데이터를 불러오기 때문에<br/>
static 변수로 게시판 정보가 담겨있는 ArrayList 를 선언하고, Constructor로 게시판 데이터를 입력하였습니다<br/><br/>
<img src="https://user-images.githubusercontent.com/70881757/236492906-304cc98b-a16c-4a93-8d1a-3c89e1e82d18.png"><br/>
게시판은 Board class 를 선언하여 객체화하였습니다.<br/>
Board 는 고유 id 인 child_id 와 자신의 부모 게시판 id를 가리키는 parent_idx , 게시판명인 category_nm으로 구성했습니다.<br/><br/>
<img src="https://user-images.githubusercontent.com/70881757/236494714-32265cfe-d477-42a5-a886-bcc9e53eb655.png"><br/>
BoardService 생성자에 선언한 초기 데이터는 다음과 같습니다<br/>
이름만 같은 공지사항 게시판은 parent_idx와 child_id 가 다르며<br/>
이름과 게시판 데이터가 동일한 익명게시판은 parent_idx 는 다르고 child_id 가 같도록 설계하였습니다<br/><br/>
<img src="https://user-images.githubusercontent.com/70881757/236495523-9e40cf17-4070-4292-9d3d-8ca3b96b72e9.png"><br/>
SearchBoardByNameOrId는 검색 String 을 받아 검색 결과와 일치하는 board 및 하위 카테고리 board 까지 검색하여 Json 형태로 반환합니다.<br/><br/>
<img src="https://user-images.githubusercontent.com/70881757/236497418-a1331e70-49f6-44a5-8acf-c52e8299310a.png"><br/>

