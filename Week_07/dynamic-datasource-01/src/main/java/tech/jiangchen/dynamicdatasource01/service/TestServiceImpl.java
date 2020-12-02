package tech.jiangchen.dynamicdatasource01.service;

import org.springframework.stereotype.Service;
import tech.jiangchen.dynamicdatasource01.config.DS;
import tech.jiangchen.dynamicdatasource01.config.DataSourceContextHolder;

@Service
public class TestServiceImpl implements TestService {

    @DS(DS.SLAVE)
//    @DS
    @Override
    public String doSth() {
        String db = DataSourceContextHolder.getDB();
        return db;
    }
}
