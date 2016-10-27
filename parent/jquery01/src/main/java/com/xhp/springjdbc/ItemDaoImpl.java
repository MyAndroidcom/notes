package com.xhp.springjdbc;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by xhp on 2016/9/27.
 */
public class ItemDaoImpl extends JdbcDaoSupport implements ItemDao {

    @Override
    public List<Item> findAll() {
        String sql = "select *from tb_item";
        return this.getJdbcTemplate().query(sql, new RowMapper<Item>() {
            @Override
            public Item mapRow(ResultSet resultSet, int i) throws SQLException {
                    Item item = new Item();
                    item.setId(resultSet.getLong("id"));
                    item.setCid(resultSet.getLong("cid"));
                item.setTitle(resultSet.getString("title"));
                item.setPrice(resultSet.getLong("price"));
                item.setNum(resultSet.getInt("num"));
                    return item;
            }
        });
    }
}
