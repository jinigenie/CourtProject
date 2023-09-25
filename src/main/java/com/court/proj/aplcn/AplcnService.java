package com.court.proj.aplcn;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.court.proj.announce.AnnounceVO;
import com.court.proj.aplcn.util.Criteria;

public interface AplcnService {

	// 신청자 리스트
	public ArrayList<ListVO> getList(Criteria cri);

	// 전체 게시글 수
	public int getTotal(Criteria cri);

	// 신청자 상세정보 (복수값)
	public ArrayList<ListVO> getDetails(int aplcn_dtls_proper_num);

	// 신청자 상세정보 (단수값)
	// public ListVO getDetail(int aplcn_dtls_proper_num);
	public ListVO getDetail(int aplcn_dtls_proper_num);

	// 신청자 상태변환 (서류반려)
	public int aplcnReject(ListVO vo);

	// 신청자 상태변환 (평가완료)
	public int aplcnCompleted(ListVO vo);

	// 신청자 평가
	public int aplcnEvaluate(ListVO vo);

	// 신청자 평가 평균점수
	public ListVO getScore(int aplcn_dtls_proper_num);

	// 파일 다운로드
	public ArrayList<ListVO> aplcnFiles(int aplcn_dtls_proper_num);

	// 신청자 학력 상세
	public ArrayList<ListVO> getEdctnList(int aplcn_dtls_proper_num);

	// 신청자 경력 상세
	public ArrayList<ListVO> getCarerList(int aplcn_dtls_proper_num);

	// 신청자 자격증 상세
	public ArrayList<ListVO> getCrtfcList(int aplcn_dtls_proper_num);

	// 신청자 서류 다운로드
	public ArrayList<FileVO> getFileList(int aplcn_dtls_proper_num);
	
	//신청자 상태 업데이트 (신청완료 -> 심사중)
	public int updateSts(String aplcn_dtls_proper_num);
}
