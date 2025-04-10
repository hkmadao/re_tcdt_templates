package com.haishun.kyy.xndc.up.controller;

import com.bytejz.commons.beans.wrapper.PagedList;
import com.haishun.kyy.xndc.up.advanquery.AqCondition;
import com.haishun.kyy.xndc.up.advanquery.AqPageInfoInput;
import com.haishun.kyy.xndc.up.dto.request.{{ rootInfo.className }}Request;
import com.haishun.kyy.xndc.up.dto.vo.{{ rootInfo.className }}.{{ rootInfo.className }}VO;
import com.haishun.kyy.xndc.up.service.{{ rootInfo.className }}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/{{ rootInfo.camelCaseName }}")
public class {{ rootInfo.className }}Controller {

    @Autowired
    private {{ rootInfo.className }}Service {{ rootInfo.camelCaseName }}Service;

    @PostMapping("/add")
    public {{ rootInfo.className }}VO add(@RequestBody {{ rootInfo.className }}Request {{ rootInfo.camelCaseName }}Request) throws Exception {
        return {{ rootInfo.camelCaseName }}Service.addNoPK({{ rootInfo.camelCaseName }}Request);
    }

    @PostMapping("/update")
    public {{ rootInfo.className }}VO update(@RequestBody {{ rootInfo.className }}Request {{ rootInfo.camelCaseName }}Request) throws Exception {
        return {{ rootInfo.camelCaseName }}Service.update({{ rootInfo.camelCaseName }}Request);
    }

    @PostMapping("/remove")
    public void remove(@RequestBody {{ rootInfo.className }}Request {{ rootInfo.camelCaseName }}Request) throws Exception {
        {{ rootInfo.camelCaseName }}Service.remove({{ rootInfo.camelCaseName }}Request);
    }

    @PostMapping("/view/{id}")
    public {{ rootInfo.className }}VO view(@PathVariable("id") Integer id) throws Exception {
        return {{ rootInfo.camelCaseName }}Service.getById(id);
    }

    @PostMapping("/aq")
    public List<{{ rootInfo.className }}VO> aq(@RequestBody AqCondition query) throws Exception {
        return {{ rootInfo.camelCaseName }}Service.aq(query);
    }

    @PostMapping("/aqPage")
    public PagedList<{{ rootInfo.className }}VO> aqPage(@RequestBody AqPageInfoInput query) throws Exception {
        return {{ rootInfo.camelCaseName }}Service.aqPage(query);
    }

}
