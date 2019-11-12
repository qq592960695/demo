package com.maven.demo;

import com.maven.demo.bean.QueryBean;
import com.maven.demo.doMain.TbStudent;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.db.parser.JdbcParser;
import net.atomarrow.domains.DomainUtil;
import net.atomarrow.filter.ConfigScanner;
import net.atomarrow.services.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;

@SpringBootTest
class DemoApplicationTests extends Service {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    DomainUtil domainUtil=new DomainUtil();
    @Autowired
    ConfigScanner configScanner=new ConfigScanner();
    @Test
    void contextLoads() {
        configScanner.scan();
        TbStudent student=new TbStudent();
        Conditions conditions=new Conditions(TbStudent.class);
       // conditions.setReturnClass(QueryBean.class);
        conditions.setSelectValue(" s.id, s.name,s.age,g.grade,r.result ");
        conditions.setJoin(" s join tbresult as r on s.id = r.studentid join tbgrade as g on s.gradeid = g.id ");
        conditions.putLIKE("name","于");
        conditions.putLIKE("grade","一年级");
        List<TbStudent> list = getList(conditions);
        System.out.println(list);
        System.out.println(JdbcParser.getInstance().getSelectHql(conditions));
    }

}
