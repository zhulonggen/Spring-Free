package com.santi.serivce;

import com.santi.mapper.FreeMapper;
import com.santi.pojo.Free;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreeService {

    @Autowired
    private FreeMapper freeMapper;

    public List<Free> getFreeAll() {
        return freeMapper.getFreeAll();
    }

    public int addFreePid(Integer pid) {
        return freeMapper.addFreePid(pid);
    }

    public Free getNewId() {
        return freeMapper.getNewId();
    }

    public int updateTitle(String title, Integer id) {
        return freeMapper.updateTitle(title, id);
    }

    public int del(Integer id) {
        return freeMapper.del(id);
    }

    public Free isPid(Integer id){
     return freeMapper.isPid(id);
    }
}
