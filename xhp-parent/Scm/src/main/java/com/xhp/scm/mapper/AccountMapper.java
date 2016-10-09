package com.xhp.scm.mapper;

import com.xhp.scm.entity.Account;

public interface AccountMapper extends BaseMapper<Account>{

    public Account selectOne(Account account);
}
