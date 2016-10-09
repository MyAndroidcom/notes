package com.xhp.scm.service.impl;


import com.xhp.scm.entity.Account;
import com.xhp.scm.service.AccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

	public Account doLogin(Account account) {
		return this.accountMapper.selectOne(account);
	}

	/*@Autowired
	private AccountMapper accountMapper;

	@Override
	public int insert(Account entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Account entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Account entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Account select(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Page<Account> selectPage(Page<Account> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Account> selectPageUseDyc(Page<Account> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteList(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

*/

}
