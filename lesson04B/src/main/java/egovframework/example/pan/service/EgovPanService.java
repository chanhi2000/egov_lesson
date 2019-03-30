package egovframework.example.pan.service;

import java.util.List;

public interface EgovPanService {

    /**
     * 글을 등록한다.
     * @param vo - 등록할 정보가 담긴 PanVO
     * @return 등록 결과
     * @exception Exception
     */
    String insertPan(PanVO vo) throws Exception;

    /**
     * 글을 수정한다.
     * @param vo - 수정할 정보가 담긴 PanVO
     * @return void형
     * @exception Exception
     */
    void updatePan(PanVO vo) throws Exception;

    /**
     * 글을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 PanVO
     * @return void형
     * @exception Exception
     */
    void deletePan(PanVO vo) throws Exception;

    /**
     * 글을 조회한다.
     * @param vo - 조회할 정보가 담긴 PanVO
     * @return 조회한 글
     * @exception Exception
     */
    PanVO selectPan(PanVO vo) throws Exception;

    /**
     * 글 목록을 조회한다.
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return 글 목록
     * @exception Exception
     */
    List<?> selectPanList(PanVO searchVO) throws Exception;

    /**
     * 글 총 갯수를 조회한다.
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return 글 총 갯수
     * @exception
     */
    int selectSampleListTotCnt(PanVO searchVO);

}