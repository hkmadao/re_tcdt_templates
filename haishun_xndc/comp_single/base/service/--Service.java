package com.haishun.kyy.xndc.up.service;

import com.bytejz.commons.beans.wrapper.PagedList;
import com.haishun.kyy.xndc.up.advanquery.AqCondition;
import com.haishun.kyy.xndc.up.advanquery.AqPageInfoInput;
import com.haishun.kyy.xndc.up.db.domain.{{ rootInfo.className }};
import com.haishun.kyy.xndc.up.dto.request.{{ rootInfo.className }}Request;
import com.haishun.kyy.xndc.up.dto.vo.{{ rootInfo.className }}.{{ rootInfo.className }}VO;

import java.util.List;

public interface {{ rootInfo.className }}Service {

    /**
     * 转换入参为实体
     * @param {{ rootInfo.camelCaseName }}Request 入参
     * @return 实体
     */
    {{ rootInfo.className }} covertEntity({{ rootInfo.className }}Request {{ rootInfo.camelCaseName }}Request);

    /**
     * 转换实体为出参实体
     * @param {{ rootInfo.camelCaseName }} 实体
     * @return 返回实体
     */
    {{ rootInfo.className }}VO covertVO({{ rootInfo.className }} {{ rootInfo.camelCaseName }});

    /**
     * 转换实体集合为出参实体集合
     * @param {{ rootInfo.camelCaseName }}List 实体集合
     * @return 返回实体集合
     */
    List<{{ rootInfo.className }}VO> batchCovertVO(List<{{ rootInfo.className }}> {{ rootInfo.camelCaseName }}List);

    /**
     * 实体的id由系统自动生成
     * @param {{ rootInfo.camelCaseName }}Request 实体参数
     * @return 添加后的实体
     */
    {{ rootInfo.className }}VO addNoPK({{ rootInfo.className }}Request {{ rootInfo.camelCaseName }}Request);

    /**
     * 实体的id由调用方生成
     * @param {{ rootInfo.camelCaseName }}Request 实体参数
     * @return 添加后的实体
     */
    {{ rootInfo.className }}VO addForPK({{ rootInfo.className }}Request {{ rootInfo.camelCaseName }}Request);

    /**
     * 更新实体
     * @param {{ rootInfo.camelCaseName }}Request 实体参数
     * @return 更新后的实体
     */
    {{ rootInfo.className }}VO update({{ rootInfo.className }}Request {{ rootInfo.camelCaseName }}Request);

    /**
     * 删除实体
     * @param {{ rootInfo.camelCaseName }}Request 实体参数
     */
    void remove({{ rootInfo.className }}Request {{ rootInfo.camelCaseName }}Request);

    /**
     * 根据id获取实体
     * @param id 实体id
     * @return 实体
     */
    {{ rootInfo.className }}VO getById(Integer id);

    /**
     * 根据条件查询实体集合
     * @param aqCondition 查询条件
     * @return 实体集合
     * @throws Exception
     */
    List<{{ rootInfo.className }}VO> aq(AqCondition aqCondition) throws Exception;

    /**
     * 分页查询实体集合
     * @param aqPageInfoInput 分页查询条件
     * @return 分页实体集合
     * @throws Exception
     */
    PagedList<{{ rootInfo.className }}VO> aqPage(AqPageInfoInput aqPageInfoInput) throws Exception;
}
