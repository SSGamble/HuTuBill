package com.td.service;

import com.td.dao.RecordDAO;
import com.td.entity.Category;
import com.td.entity.Record;
import java.util.Date;

/**
 * 消费记录业务类
 */
public class RecordService {
    RecordDAO recordDao = new RecordDAO();
    public void add(int spend, Category c, String comment, Date date){
        Record r = new Record();
        r.spend = spend;
        r.cid = c.id;
        r.comment = comment;
        r.date = date;
        recordDao.add(r);
    }
}
