package egovframework.example.pan.service.impl;

import egovframework.example.pan.service.PanVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PanDAO extends EgovAbstractDAO {

    /**
     * 글을 등록한다.
     * @param vo - 등록할 정보가 담긴 PanVO
     * @return 등록 결과
     * @exception Exception
     */
    public String insertPan(PanVO vo) throws Exception {
        return (String) insert("panDAO.insertPan", vo);
    }

    /**
     * 글을 수정한다.
     * @param vo - 수정할 정보가 담긴 PanVO
     * @return void형
     * @exception Exception
     */
    public void updatePan(PanVO vo) throws Exception {
        update("panDAO.updatePan", vo);
    }

    /**
     * 글을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 PanVO
     * @return void형
     * @exception Exception
     */
    public void deletePan(PanVO vo) throws Exception {
        delete("panDAO.deletePan", vo);
    }

    /**
     * 글을 조회한다.
     * @param vo - 조회할 정보가 담긴 SampleVO
     * @return 조회한 글
     * @exception Exception
     */
    public PanVO selectPan(PanVO vo) throws Exception {
        return (PanVO) select("panDAO.selectPan", vo);
    }

    /**
     * 글 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return 글 목록
     * @exception Exception
     */
    public List<?> selectPanList(PanVO searchVO) throws Exception {
        return list("panDAO.selectPanList", searchVO);
    }

    /**
     * 글 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return 글 총 갯수
     * @exception
     */
    public int selectSampleListTotCnt(PanVO searchVO) {
        return (Integer) select("panDAO.selectPanListTotCnt", searchVO);
    }

}