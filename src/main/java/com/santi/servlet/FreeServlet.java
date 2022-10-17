package com.santi.servlet;

import com.santi.msg.MsgResult;
import com.santi.pojo.Free;
import com.santi.serivce.FreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/freeServlet")
@CrossOrigin
public class FreeServlet {

    @Autowired
    private FreeService freeService;

    @RequestMapping("/getFreeAll")
    public MsgResult getFreeAll() {
        System.out.println("进来了");
        List<Free> list = freeService.getFreeAll();
        //字典map，用于后面的遍历好查找
        Map<Integer, Free> nodeMap = new HashMap<>();
        //转换成map，key --> id , value -->node对象
        for (Free node : list) {
            nodeMap.put(node.getId(), node);
        }
        List<Free> result = new ArrayList<Free>();
        for (Free node : list) {
            if (node.getPid().equals(0)) {
                //根目录
                result.add(node);
            } else {
                //找到父节点
                Free pNode = nodeMap.get(node.getPid());
                List<Free> child = pNode.getChildren();
                if (child == null) {
                    child = new ArrayList<Free>();
                }
                child.add(node);
                pNode.setChildren(child);
            }
        }
//        System.out.println(JSON.toJSONString(result));
        MsgResult msgResult = new MsgResult();
        msgResult.setData(result);
        return msgResult;
    }

    @RequestMapping("/addFree")
    public Integer addFree(@RequestParam(value = "id", required = false) Integer id) {
        if (id != null) {
            int i = freeService.addFreePid(id);
        }
        Free ids = freeService.getNewId();

        System.out.println(id);
        return ids.getId();
    }

    @GetMapping("/update")
    public void update(@RequestParam(value = "title", required = false) String title) {
        Integer integer = addFree(null);
        //        修改title
        int i = freeService.updateTitle(title, integer);
        System.out.println(i);
    }

    @RequestMapping("/del")
    public void del(HttpServletRequest request) {
        String id = request.getParameter("id");
        String children = request.getParameter("children");
//        String id = request.getParameter("id");
//        @RequestParam(value = "id", required = false) String id,@RequestParam("children") List<Free> children
        System.out.println("我是iddel" + id);
        System.out.println("data.children"+children);
//        children.forEach(System.out::println);

//        if ("undefined".equals(id)||id==null) {
//            Integer integer = addFree(null);
////            freeService.isPid(integer)
//            int i = freeService.del(integer);
//        }else{
//            int i1 = Integer.parseInt(id);
//            int i = freeService.del(i1);
//        }
    }

}
