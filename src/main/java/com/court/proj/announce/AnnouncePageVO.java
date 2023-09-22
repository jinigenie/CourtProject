package com.court.proj.announce;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.court.proj.aplcn.util.Criteria;

import lombok.Data;

@Data
public class AnnouncePageVO {

	private int start; //시작페이지 번호 (시작페이지 네이션)
	private int end; //끝 페이지 네이션
	private boolean prev; //이전버튼 활성화 여부
	private boolean next; //다음버튼 활성화 여부
	private int realEnd; //실제 보여지는 끝번호
	
	private int total; //전체 게시글 개수
	private int page; //cri에 있는 현재 조회하는 페이지
	private int amount; //cri에 있는 데이터 개수
	private AnnounceCriteria cri; //페이지 기준
	
	
	private int pnCount = 10; //페이지네이션 개수 (화면에 보여지는 페이지 칸 수들)
	
	private List<Integer> pageList; //페이지네이션을 리스트로 저장 
	
	//페이지 네이션 클래스는 cri와 total을 매개변수로 받음 
	public AnnouncePageVO(AnnounceCriteria cri, int total) {
	    this.cri = cri;
	    this.page = cri.getPage();
	    this.amount = cri.getAmount();
	    this.total = total;

	    // end 페이지 계산
	    this.end = (int) Math.ceil((double) this.page / this.pnCount) * this.pnCount;

	    // start 페이지 계산
	    this.start = this.end - this.pnCount + 1;
	    if (this.start < 1) {
	        this.start = 1;
	    }

	    // 실제 끝번호의 계산
	    this.realEnd = (int) Math.ceil((double) this.total / this.amount);

	    // end 페이지 재결정
	    if (this.end > this.realEnd) {
	        this.end = this.realEnd;
	    }

	    // prev 활성화 여부
	    this.prev = this.start > 1;

	    // next 활성화 여부
	    this.next = this.realEnd > this.end;

	    // 타임리프 - 리스트에 페이지네이션을 담는다. (람다식)
	    this.pageList = IntStream.rangeClosed(this.start, this.end).boxed().collect(Collectors.toList());

	    // 페이지 번호를 수정하여 1번부터 10번까지의 페이지가 출력되도록 조정
	    if (this.end >= 10) {
	        this.start = 1;
	        this.end = 10;
	    }
	    
	    // 페이지 안의 공고문 수를 1부터 10까지로 제한
	    this.amount = 10;
	}

	
}
