package com.haishun.kyy.xndc.up.service.impl;

import com.bytejz.commons.beans.wrapper.PagedList;
import com.bytejz.querydsldao.query.PagedQueryBuilder;
import com.bytejz.querydsldao.query.QueryBuilder;
import com.haishun.kyy.xndc.up.advanquery.AqCondition;
import com.haishun.kyy.xndc.up.advanquery.AqLogicNode;
import com.haishun.kyy.xndc.up.advanquery.AqOrder;
import com.haishun.kyy.xndc.up.advanquery.AqPageInfoInput;
import com.haishun.kyy.xndc.up.db.dao.{{ rootInfo.className }}Dao;
import com.haishun.kyy.xndc.up.db.domain.{{ rootInfo.className }};
import com.haishun.kyy.xndc.up.db.query.Q{{ rootInfo.className }};
import com.haishun.kyy.xndc.up.dto.request.{{ rootInfo.className }}Request;
import com.haishun.kyy.xndc.up.dto.vo.{{ rootInfo.className | lower }}.{{ rootInfo.className }}VO;
import com.haishun.kyy.xndc.up.service.{{ rootInfo.className }}Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class {{ rootInfo.className }}ServiceImpl implements {{ rootInfo.className }}Service {

    @Autowired
    private {{ rootInfo.className }}Dao {{ rootInfo.camelCaseName }}Dao;

    @Override
    public {{ rootInfo.className }} covertEntity({{ rootInfo.className }}Request {{ rootInfo.camelCaseName }}Request) {
        {{ rootInfo.className }} {{ rootInfo.camelCaseName }} = new {{ rootInfo.className }}();
        BeanUtils.copyProperties({{ rootInfo.camelCaseName }}Request, {{ rootInfo.camelCaseName }});
        return {{ rootInfo.camelCaseName }};
    }

    @Override
    public {{ rootInfo.className }}VO covertVO({{ rootInfo.className }} {{ rootInfo.camelCaseName }}) {
        {{ rootInfo.className }}VO {{ rootInfo.camelCaseName }}VO = new {{ rootInfo.className }}VO();
        BeanUtils.copyProperties({{ rootInfo.camelCaseName }}, {{ rootInfo.camelCaseName }}VO);
        return {{ rootInfo.camelCaseName }}VO;
    }

    @Override
    public List<{{ rootInfo.className }}VO> batchCovertVO(List<{{ rootInfo.className }}> {{ rootInfo.camelCaseName }}List) {
        return {{ rootInfo.camelCaseName }}List.stream().map(this::covertVO).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public {{ rootInfo.className }}VO addNoPK({{ rootInfo.className }}Request {{ rootInfo.camelCaseName }}Request) {
        {{ rootInfo.className }} {{ rootInfo.camelCaseName }} = covertEntity({{ rootInfo.camelCaseName }}Request);
        {{ rootInfo.camelCaseName }}.setId(null);
        Integer id = {{ rootInfo.camelCaseName }}Dao.save({{ rootInfo.camelCaseName }});
        {{ rootInfo.className }} {{ rootInfo.camelCaseName }}Get = {{ rootInfo.camelCaseName }}Dao.get(id);
        return covertVO({{ rootInfo.camelCaseName }}Get);
    }

    @Override
    public {{ rootInfo.className }}VO addForPK({{ rootInfo.className }}Request {{ rootInfo.camelCaseName }}Request) {
        {{ rootInfo.className }} {{ rootInfo.camelCaseName }} = covertEntity({{ rootInfo.camelCaseName }}Request);
        Integer id = {{ rootInfo.camelCaseName }}Dao.save({{ rootInfo.camelCaseName }});
        {{ rootInfo.className }} {{ rootInfo.camelCaseName }}Get = {{ rootInfo.camelCaseName }}Dao.get(id);
        return covertVO({{ rootInfo.camelCaseName }}Get);
    }

    @Transactional
    @Override
    public {{ rootInfo.className }}VO update({{ rootInfo.className }}Request {{ rootInfo.camelCaseName }}Request) {
        {{ rootInfo.className }} {{ rootInfo.camelCaseName }} = covertEntity({{ rootInfo.camelCaseName }}Request);
        {{ rootInfo.camelCaseName }}Dao.update({{ rootInfo.camelCaseName }});
        {{ rootInfo.className }} {{ rootInfo.camelCaseName }}Get = {{ rootInfo.camelCaseName }}Dao.get({{ rootInfo.camelCaseName }}.getId());
        return covertVO({{ rootInfo.camelCaseName }}Get);
    }

    @Transactional
    @Override
    public void remove({{ rootInfo.className }}Request {{ rootInfo.camelCaseName }}Request) {
        {{ rootInfo.camelCaseName }}Dao.delete({{ rootInfo.camelCaseName }}Request.getId());
    }

    @Transactional
    @Override
    public {{ rootInfo.className }}VO getById(Integer id) {
        {{ rootInfo.className }} {{ rootInfo.camelCaseName }}Get = {{ rootInfo.camelCaseName }}Dao.get(id);
        return covertVO({{ rootInfo.camelCaseName }}Get);
    }

    @Transactional
    @Override
    public List<{{ rootInfo.className }}VO> aq(AqCondition aqCondition) throws Exception {
        QueryBuilder<Q{{ rootInfo.className }}> qMerchantQueryBuilder = PagedQueryBuilder.of(Q{{ rootInfo.className }}.{{ rootInfo.camelCaseName }});
        AqLogicNode.recursionNode(Q{{ rootInfo.className }}.{{ rootInfo.camelCaseName }}, qMerchantQueryBuilder, aqCondition.getLogicNode());
        AqOrder.buildOrders(Q{{ rootInfo.className }}.{{ rootInfo.camelCaseName }}, qMerchantQueryBuilder, aqCondition.getOrders());
        List<{{ rootInfo.className }}> list = {{ rootInfo.camelCaseName }}Dao.getList(qMerchantQueryBuilder);
        return list.stream().map(this::covertVO).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public PagedList<{{ rootInfo.className }}VO> aqPage(AqPageInfoInput aqPageInfoInput) throws Exception {
        QueryBuilder<Q{{ rootInfo.className }}> qMerchantQueryBuilder = PagedQueryBuilder.of(Q{{ rootInfo.className }}.{{ rootInfo.camelCaseName }});
        AqLogicNode.recursionNode(Q{{ rootInfo.className }}.{{ rootInfo.camelCaseName }}, qMerchantQueryBuilder, aqPageInfoInput.getLogicNode());
        AqOrder.buildOrders(Q{{ rootInfo.className }}.{{ rootInfo.camelCaseName }}, qMerchantQueryBuilder, aqPageInfoInput.getOrders());
        PagedQueryBuilder pagedQueryBuilder = qMerchantQueryBuilder.setPagination(aqPageInfoInput);
        PagedList<{{ rootInfo.className }}> {{ rootInfo.camelCaseName }}PagedList = {{ rootInfo.camelCaseName }}Dao.pagedQuery(pagedQueryBuilder);
        List<{{ rootInfo.className }}VO> flowMetaVOList = {{ rootInfo.camelCaseName }}PagedList.getRows().stream().map(this::covertVO).collect(Collectors.toList());
        return PagedList.of(flowMetaVOList, {{ rootInfo.camelCaseName }}PagedList.getTotal(), {{ rootInfo.camelCaseName }}PagedList.getPage(), {{ rootInfo.camelCaseName }}PagedList.getPageSize());
    }

}
