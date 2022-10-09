package org.example.yqs.test;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.example.yqs.entity.Person;
import org.example.yqs.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESSearchTest {
    @Autowired
    private PersonRepository personRepository;
    /**
     * term 查询
     * search(termQueryBuilder) 调用搜索方法，参数查询构建器对象
     */
    //@Test
    /*public void termQuery(){
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "[8]张三");
        Iterable<Person> persons = personRepository.search(termQueryBuilder);
        for (Person person : persons) {
            System.out.println(person);
        }
    }*/

    /**
     * 按aame名字查询,按照SpringDataES的规则命名方法
     */
    @Test
    public void personQuery(){
        Iterable<Person> persons = personRepository.findALLByname("[3]张三");
        for (Person person : persons) {
            System.out.println(person);
        }
    }

}
