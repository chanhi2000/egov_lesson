package egovframework.example.pan.service.impl;

import egovframework.example.pan.service.PanVO;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PanDAO extends EgovAbstractDAO {

    private static final String ID_DAO = "panDAO";
    public static final String ID_INSERT = ID_DAO+".insertPan";
    public static final String ID_UPDATE = ID_DAO+".updatePan";
    public static final String ID_DELETE = ID_DAO+".deletePan";
    public static final String ID_SELECT = ID_DAO+".selectPan";
    public static final String ID_SELECT_LIST_PAGED = ID_DAO+".selectPanListPaged";
    public static final String ID_SELECT_MULTIPLE = ID_DAO+".selectPanList";
    public static final String ID_TOTAL_COUNT = ID_DAO+".selectPanListTotCnt";

    /**
     * 글을 등록한다.
     * @param vo - 등록할 정보가 담긴 PanVO
     * @return 등록 결과
     * @exception Exception
     */
    public String insertPan(PanVO vo) throws Exception { return (String) insert(ID_INSERT, vo); }

    /**
     * 글을 수정한다.
     * @param vo - 수정할 정보가 담긴 PanVO
     * @return void형
     * @exception Exception
     */
    public int updatePan(PanVO vo) throws Exception { return update(ID_UPDATE, vo); }

    /**
     * 글을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 PanVO
     * @return void형
     * @exception Exception
     */
    public int deletePan(PanVO vo) throws Exception { return delete(ID_DELETE, vo); }

    /**
     * 글을 조회한다.
     * @param vo - 조회할 정보가 담긴 SampleVO
     * @return 조회한 글
     * @exception Exception
     */
    public PanVO selectPan(PanVO vo) throws Exception { return (PanVO) select(ID_SELECT, vo); }

    /**
     * 페이징이 된 글 목록을 조회한다.
     * @param searchVO- 조회할 정보가 담긴 Map
     * @return 글 목록
     * @exception Exception
     */
    public List<?> selectPanListPaged(SampleDefaultVO searchVO) throws Exception { return list(ID_SELECT_LIST_PAGED, searchVO); }

    /**
     * 글 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return 글 목록
     * @exception Exception
     */
    public List<?> selectPanList(SampleDefaultVO searchVO) throws Exception { return list(ID_SELECT_MULTIPLE, searchVO); }

    /**
     * 글 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return 글 총 갯수
     * @exception
     */
    public int selectPanListTotCnt(SampleDefaultVO searchVO) { return (Integer) select(ID_TOTAL_COUNT, searchVO); }

}