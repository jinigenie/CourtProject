package com.court.proj.fcltt;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Data;

@Data
public class FclttPageVO {

	private int start;  //시작
	private int end;	//끝
	private boolean prev;	//이전버튼
	private boolean next;	//다음버튼
	private int realEnd;	//실제페이지끝번호

	private int total;	// 전체글수
	private int page;	//cri 현재 조회페이지
	private int amount; //cri  데이터 개수
	private FclttCriteria cri; //페이지기준

	private int pnCount =10;

	private List<Integer> pageList; //페이지네이션 리스트로 저장할변수

	public FclttPageVO(FclttCriteria cri, int total) {
		this.cri = cri;
		this.page= cri.getPage();
		this.amount = cri.getAmount();
		this.total = total;


		// 1. end페이지 계산  //현재 조회하는 패이지와 연관이 있따----------------------------------------------
		/*
		 *  if ) page == 1?  end = 10 
		 *  if ) page == 10? end = 20
		 * 	this.end = (int)(Math.올림함수( 현재조회하는 페이지 /( 페이지네이션 갯수 ))  ) * 페이지네이션 갯수 ; 
		 *  this.end = (int)(Math.ceil(this.pageNum / pnCount)  ) * pnCount; 
		 *
		 */


		// 페이지네이션 갯수 계산하기 (끝값)
		this.end = (int)( Math.ceil( this.page / (double)this.pnCount ) ) * this.pnCount;

		// 2. start 페이지 계산-------------------------------------------------------------------------
		// this.start = this.end - 페이지네이션갯수 + 1;

		this.start = this.end - this.pnCount + 1;

		// 3. 실제끝번호계산 (총 불러올 전체데이터의 끝번호)-----------------------------------------------------
		// 페이지당 10개씩 게시물을 불러온다면 
		// 총 게시글 수: 53 ?  마지막번호 == 6 ;
		// 총 게시글 수: 232 ?  마지막번호 == 24;
		// this.realEnd = (int)(Math.ceil( 전체게시글수 / 데이터갯수) );		
		this.realEnd = (int)(Math.ceil(this.total / (double)this.amount) );		

		// end페이지 재결정
		// ex) 총 데이터 25개 -> end =10, realEnd= 3 ( 10개씩 3페이지)  실제끝번호를 따라간다
		// ex) 총 데이터 153개-> end =20, realEnd= 16 (10개씩 16피이지) 실제끝번호를 따라간다
		// ex) 총 데이터 153개(3번페이지 조회시) -> end =10, realEnd = 16 (페이지네이션을 따라간다)
		//

		if(this.end > this.realEnd) {
			this.end = this.realEnd;
		}

		//4. prev활성화 여부 맨앞페이지 ----------------------------------------------------------------------
		// start 페이지는 1 , 11, 21, 31, 41 ....

		this.prev = this.start > 1;

		//5. next 버튼     ----------------------------------------------------------------------------
		// end =10, realEnd =16 이라고 할때 다음버튼이 있다는 의미
		this.next = this.realEnd > this.end;

		// 6. 타임리프 -  list에 페이지네이션담기 --------------------------------------------------------------------- 
		this.pageList = IntStream.rangeClosed(this.start, this.end).boxed().collect(Collectors.toList());  // 람다의 최종함수	








	}















}
