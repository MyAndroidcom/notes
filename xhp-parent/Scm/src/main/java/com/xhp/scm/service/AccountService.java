package com.xhp.scm.service;

import com.xhp.scm.entity.Account;

/**
 * Created by xhp on 2016/9/30.
 */

public interface AccountService extends BaseService<Account> {


    public Account doLogin(Account account);

}
