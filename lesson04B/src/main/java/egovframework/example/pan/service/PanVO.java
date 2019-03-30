package egovframework.example.pan.service;

import egovframework.example.sample.service.SampleDefaultVO;

import java.util.Objects;

public class PanVO extends SampleDefaultVO {

    private static final long serialVersionUID = 3209520320590238271L;

    private String cmID;            // 회원ID
    private String name;            // 이름
    private String password;        // 비밀번호
    private String useYn;           // 사용여부
    private String levels;          // 등급
    private String login;           // 로그인횟수
    private String recommend;       // 추천수
    private String email;           // 이메일
    private String regDate;         // 등록일

    public PanVO() {}

    public PanVO(String cmID,
                 String name,
                 String password,
                 String useYN,
                 String levels,
                 String login,
                 String recommend,
                 String email) {
        this.cmID = cmID;
        this.name = name;
        this.password = password;
        this.useYn = useYN;
        this.levels = levels;
        this.login = login;
        this.recommend = recommend;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PanVO panVO = (PanVO) o;
        return cmID.equals(panVO.cmID) &&
                name.equals(panVO.name) &&
                password.equals(panVO.password) &&
                useYn.equals(panVO.useYn) &&
                levels.equals(panVO.levels) &&
                login.equals(panVO.login) &&
                recommend.equals(panVO.recommend) &&
                email.equals(panVO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cmID, name, password, useYn, levels, login, recommend, email);
    }

    public String getCmID() { return cmID; }
    public void setCmID(String cmID) { this.cmID = cmID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getUseYN() { return useYn; }
    public void setUseYN(String useYN) { this.useYn = useYN; }

    public String getLevels() { return levels; }
    public void setLevels(String levels) { this.levels = levels; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getRecommend() { return recommend; }
    public void setRecommend(String recommend) { this.recommend = recommend; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRegDate() { return regDate; }
    public void setRegDate(String regDate) { this.regDate = regDate; }

    @Override
    public String toString() {
        return "PanVO [cmID="+this.cmID+", name="+this.name+", password="+this.password+", useYn="+this.useYn +
                ", level="+this.useYn +", levels="+this.levels+", login="+this.login+", recommend="+this.recommend+
                ", email="+this.email+", regDate="+this.regDate;
    }
}
