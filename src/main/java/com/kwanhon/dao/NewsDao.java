package com.kwanhon.dao;

import com.kwanhon.common.db.BaseDao;
import com.kwanhon.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
@Component
public class NewsDao extends BaseDao<News> {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    /**
     * 无条件查询
     *
     * @param currentpage
     * @param pagesize
     * @param isasc
     * @return list<Map<String, Object>>
     */
    public List queryAll(Integer currentpage, Integer pagesize, boolean isasc) {

        String asc = isasc == true ? "asc" : "desc";
        String sql = "select * from t_news order by news_id " + asc + " limit " + ((currentpage - 1) * pagesize) + "," +
                "" + (pagesize);

        List list = this.jdbcTemplate.queryForList(sql);

        return list;
    }

    /**
     * 获取总数据
     *
     * @return Long
     */
    public Long queryCount(String whereparams) {
        String sql = "select count(*) from t_news " + whereparams;
        Long count = this.jdbcTemplate.queryForObject(sql, new Object[]{}, Long.class);
        return count;
    }

    /**
     * 条件查询
     *
     * @param currentpage
     * @param pagesize
     * @param isasc
     * @param whereparms
     * @return list<Map<String, Object>>
     */
    public List<Map> queryWhere(Integer currentpage, Integer pagesize, boolean isasc, String whereparms) {
        String asc = isasc == true ? "asc" : "desc";
        String sql = "select * from t_news " + whereparms + " order by news_id " + asc + " limit " + ((currentpage -
                1) * pagesize) + "," + (pagesize);

        List list = this.jdbcTemplate.queryForList(sql);

        return list;
    }

    public Map queryNewsContent(Integer id) {
        String sql = "select a.news_id,source,content,create_time,title,image_url,summary,type_name,type_id from " +
                "t_news as a,t_news_content as b where a.news_id = b.news_id and a.news_id="+id;

        Map map = null;
        try {
            map=(Map)jdbcTemplate.queryForMap(sql);
        }catch (Exception e){

        }
        return map;
    }
}
