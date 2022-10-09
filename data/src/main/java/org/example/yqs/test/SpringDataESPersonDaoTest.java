package org.example.yqs.test;

import org.example.yqs.entity.Person;
import org.example.yqs.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESPersonDaoTest {

    @Autowired
    private PersonRepository personRepository;
    /**
     * 新增
     */
    @Test
    public void save(){
        Person person = new Person();
        person.setId(1L);
        person.setName("张三");
        person.setAge(21);
        person.setAddress("北京市海淀区");
        personRepository.save(person);
    }
    /**
     * 修改
     */
    @Test
    public void update(){
        Person person = new Person();
        person.setId(1L);
        person.setName("张三");
        person.setAge(21);
        person.setAddress("北京市朝阳区");
        personRepository.save(person);
    }

    /**
     * 根据 id 查询
     */
    @Test
    public void findById(){
        Person person = personRepository.findById(1L).get();
        System.out.println(person);
    }
    /**
     * 查询所有
     */
    @Test
    public void findAll(){
        Iterable<Person> persons = personRepository.findAll();
        for (Person person : persons) {
            System.out.println(person);
        }
    }
    /**
     * 删除
     */
    @Test
    public void delete(){
        Person person = new Person();
        person.setId(1L);
        personRepository.delete(person);
    }
    /**
     * 批量新增
     */
    @Test
    public void saveAll(){
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            person.setId(Long.valueOf(i));
            person.setName("["+i+"]张三");
            person.setAge(21+i);
            person.setAddress("北京市海淀区");
            personList.add(person);
        }
        personRepository.saveAll(personList);
    }

    /**
     * 分页查询
     */
    @Test
    public void findByPageable(){
        //设置排序(排序方式，正序还是倒序，排序的 id)
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        int currentPage=0;//当前页，第一页从 0 开始， 1 表示第二页
        int pageSize = 2;//每页显示多少条
        //设置查询分页
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize,sort);
        //分页查询
        Page<Person> personPage = personRepository.findAll(pageRequest);
        for (Person person : personPage.getContent()) {
            System.out.println(person);
        }
    }

}
