package dao;

import java.util.List;
import model.CreditCardCase;
import model.CreditCardCaseExample;
import org.apache.ibatis.annotations.Param;

public interface CreditCardCaseMapper {
    int countByExample(CreditCardCaseExample example);

    int deleteByExample(CreditCardCaseExample example);

    int deleteByPrimaryKey(String caseNo);

    int insert(CreditCardCase record);

    int insertSelective(CreditCardCase record);

    List<CreditCardCase> selectByExample(CreditCardCaseExample example);

    CreditCardCase selectByPrimaryKey(String caseNo);

    int updateByExampleSelective(@Param("record") CreditCardCase record, @Param("example") CreditCardCaseExample example);

    int updateByExample(@Param("record") CreditCardCase record, @Param("example") CreditCardCaseExample example);

    int updateByPrimaryKeySelective(CreditCardCase record);

    int updateByPrimaryKey(CreditCardCase record);
}