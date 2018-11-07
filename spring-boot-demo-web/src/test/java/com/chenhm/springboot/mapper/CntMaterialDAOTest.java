package com.chenhm.springboot.mapper;

import com.chenhm.springboot.BaseControllerTest;
import com.chenhm.springboot.common.PageListFilter;
import com.chenhm.springboot.mapper.holiday.domain.CntMaterialDO;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chen-hongmin
 * @date 2018/9/20 16:32
 * @since V1.0
 */
public class CntMaterialDAOTest extends BaseControllerTest {

    @Resource
    private CntMaterialDAO cntMaterialDAO;

    @Test
    public void insert() {

        CntMaterialDO cntMaterialDO = new CntMaterialDO();
        cntMaterialDO.setCategory(1);
        cntMaterialDO.setFileId("ss");
        cntMaterialDO.setOperator("chenhm");
        cntMaterialDO.setOperatorId(111L);
        cntMaterialDO.setMaterialCode("ssssssad");
        cntMaterialDO.setTitle("title");
        cntMaterialDO.setSource(1);
        cntMaterialDO.setStatus(1);
        cntMaterialDAO.insert(cntMaterialDO);

    }

    @Test
    public void update() {
        CntMaterialDO cntMaterialDO = new CntMaterialDO();
        cntMaterialDO.setCategory(1);
        cntMaterialDO.setFileId("ss");
        cntMaterialDO.setOperator("chenhm");
        cntMaterialDO.setOperatorId(111L);
        cntMaterialDO.setMaterialCode("ssssssad");
        cntMaterialDO.setTitle("title");
        cntMaterialDO.setSource(1);
        cntMaterialDO.setStatus(1);
        cntMaterialDAO.update(cntMaterialDO);
    }

    @Test
    public void getById() {

    }

    @Test
    public void delById() {

    }

    @Test
    public void list() {

        CntMaterialDO cntMaterialDO = new CntMaterialDO();
        cntMaterialDO.setCategory(1);
        cntMaterialDO.setFileId("ss");
        cntMaterialDO.setOperator("chenhm");
        cntMaterialDO.setOperatorId(111L);
        cntMaterialDO.setMaterialCode("ssssssad");
        cntMaterialDO.setTitle("title");
        cntMaterialDO.setSource(1);
        cntMaterialDO.setStatus(1);

        PageListFilter<CntMaterialDO> filter = new PageListFilter<>();
        filter.setData(cntMaterialDO);

        List<CntMaterialDO> list = cntMaterialDAO.list(filter);
    }
}