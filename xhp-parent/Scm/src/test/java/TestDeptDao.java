import com.xhp.scm.entity.Account;
import com.xhp.scm.entity.Dept;
import com.xhp.scm.mapper.AccountMapper;
import com.xhp.scm.mapper.DeptMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xhp on 2016/9/30.
 */
public class TestDeptDao {

    private DeptMapper deptMapper;
    private AccountMapper accountMapper;
    @Before
    public void setUpBeforeClass(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext*.xml");
//        this.deptMapper = (DeptMapper) context.getBean("deptMapper");
            this.accountMapper = (AccountMapper) context.getBean("accountMapper");
    }


//    @Test
    public void testSelectDept() {
        System.out.println(deptMapper.selectDept(1));
    }

//    @Test
    public void testInsertDept(){
        Dept dept = new Dept();
        dept.setDeptId(12);
        dept.setDeptName("大智");
        dept.setDeptAddress("重庆");
        System.out.print("受影响的行数:"+deptMapper.insertDept(dept));
    }

    @Test
    public void testAccountMapper(){
//        Account account = accountMapper.selectByPrimaryKey(1);
//        System.out.print(account);
    }



}
