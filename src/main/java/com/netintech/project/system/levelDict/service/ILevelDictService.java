package com.netintech.project.system.levelDict.service;

import com.netintech.core.web.domain.Ztree;
import com.netintech.project.system.levelDict.domain.LevelDict;

import java.util.List;

/**
 * 级联字典管理 服务层
 * 
 * @author admin
 */
public interface ILevelDictService
{
    /**
     * 查询字典管理数据
     * 
     * @param dict 字典信息
     * @return 字典信息集合
     */
    List<LevelDict> selectLevelDictList(LevelDict dict);

    /**
     * 查询字典管理树
     * 
     * @param dict 字典信息
     * @return 所有字典信息
     */
    List<Ztree> selectDictTree(LevelDict dict);

    /**
     * 查询字典是否存在子元素
     * 
     * @param parentId 父字典ID
     * @return 结果
     */
    int selectDictCount(Long parentId);

    /**
     * 删除字典管理信息
     * 
     * @param dictId 字典ID
     * @return 结果
     */
    int deleteDictById(Long dictId);

    /**
     * 新增保存字典信息
     * 
     * @param dict 字典信息
     * @return 结果
     */
    int insertDict(LevelDict dict);

    /**
     * 修改保存字典信息
     * 
     * @param dict 字典信息
     * @return 结果
     */
    int updateDict(LevelDict dict);

    /**
     * 根据字典ID查询信息
     * 
     * @param dictId 字典ID
     * @return 字典信息
     */
    LevelDict selectDictById(Long dictId);

    /**
     * 校验字典名称是否唯一
     * 
     * @param dict 字典信息
     * @return 结果
     */
    String checkDictLabelUnique(LevelDict dict);
}
