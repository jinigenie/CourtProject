package com.court.proj.aplcn;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.court.proj.aplcn.util.Criteria;

@Mapper
public interface AplcnMapper {

	// 신청자 리스트
	public ArrayList<ListVO> getList(@Param("cri") Criteria cri);

	public int getTotal(@Param("cri") Criteria cri); // 전체게시글수

	// 신청자 상태변환 (서류반려)
	public int aplcnReject(ListVO vo);

	// 신청자 상태변환 (평가완료)
	public int aplcnCompleted(ListVO vo);

	// 신청자 상세정보
	public ArrayList<ListVO> getDetails(@Param("aplcn_dtls_proper_num") int aplcn_dtls_proper_num);

	public ListVO getDetail(@Param("aplcn_dtls_proper_num") int aplcn_dtls_proper_num);

	// 신청자 평가
	public int aplcnEvaluate(ListVO vo);

	// 파일 다운로드
	public ListVO aplcnFiles(@Param("aplcn_dtls_proper_num") int aplcn_dtls_proper_num);

}
