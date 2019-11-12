package bald.base.controller;

import entities.PageResult;
import entities.Result;
import entities.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import bald.base.pojo.TbLabel;
import bald.base.service.TbLabelService;


import java.util.List;
import java.util.Map;

/**
 * @author 13548943514.
 * @date 2019/11/7.
 * @time 17:06.
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class BaseController {

    @Autowired
    private TbLabelService tbLabelService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return  new Result(true, StatusCode.OK,"查询成功",tbLabelService.findAll());
    }

    @RequestMapping(value = "/{labeId}",method = RequestMethod.GET)
    public Result findById(@PathVariable ("labeId") String labeId){
        return new Result(true,StatusCode.OK,"查询成功",tbLabelService.findById(labeId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody TbLabel label){
        tbLabelService.save(label);
        return new Result(true,StatusCode.OK,"添加成功",null);
    }

    @RequestMapping(value = "/{labeId}",method = RequestMethod.PUT)
    public Result update(@PathVariable String labeId,@RequestBody TbLabel label){
        label.setId(labeId);
        tbLabelService.save(label);
        return new Result(true,StatusCode.OK,"添加成功",null);
    }

    @RequestMapping(value = "/{labeId}",method = RequestMethod.DELETE)
    public Result DeleteById(@PathVariable ("labeId") String labeId){
        tbLabelService.deleteById(labeId);
        return new Result(true,StatusCode.OK,"查询成功",null);
    }
    @RequestMapping(value = "/serch",method = RequestMethod.POST )
    public Result findSearch(@RequestBody TbLabel tblabel){
        List<TbLabel> list = tbLabelService.findSearch(tblabel);
        return new Result(true,StatusCode.OK,"查询成功",null);
    }
    @RequestMapping(value = "/serch/{page}/{size}",method = RequestMethod.POST )
    public Result pageQuery(@RequestBody TbLabel tblabel,@PathVariable int page,@PathVariable int size){
        Page<TbLabel> pageData = tbLabelService.pageQuery(tblabel,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<>(pageData.getTotalElements(),pageData.getContent() ));
    }
}
