package com.bjpowernode;

import com.bjpowernode.mapper.ProductInfoMapper;
import com.bjpowernode.pojo.ProductInfo;
import com.bjpowernode.pojo.vo.ProductInfoVo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class Test {

    @Autowired
    ProductInfoMapper mapper;
    @org.junit.Test
    public void testSelectCondition() {
        ProductInfoVo vo = new ProductInfoVo();
//        vo.setPname("4");
//        vo.setTypeid(3);
        vo.setLprice(3000.0);
        vo.setHprice(3299.0);
        List<ProductInfo> list = mapper.selectCondition(vo);
        list.forEach(productInfo -> System.out.println(productInfo));
    }
}
