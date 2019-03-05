package com.kwanhon.dao;

import com.kwanhon.common.db.BaseDao;
import com.kwanhon.model.NewsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
@Component
public class NewsTypeDao extends BaseDao<NewsType> {
    @Autowired
    protected JdbcTemplate jdbcTemplate;
    /**
     * 无条件查询
     * @return list<Map<String, Object>>
     */
    public List queryAll(){
        String sql = "select * from t_type";
        List list = this.jdbcTemplate.queryForList(sql);

        return list;
    }
}
