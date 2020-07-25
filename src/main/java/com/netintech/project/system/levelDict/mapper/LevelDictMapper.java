package com.netintech.project.system.levelDict.mapper;

import com.netintech.project.system.levelDict.domain.LevelDict;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 字典管理 数据层
 * 
 * @author admin
 */
@Repository
public interface LevelDictMapper
{
    /**
     * 查询字典数
     * 
     * @param dict 字典信息
     * @return 结果
     */
    int selectDictCount(LevelDict dict);

    /**
     * 查询字典管理数据
     * 
     * @param dict 字典信息
     * @return 字典信息集合
     */
    List<LevelDict> selectLevelDictList(LevelDict dict);

    /**
     * 删除字典管理信息
     * 
     * @param dictId 字典ID
     * @return 结果
     */
    int deleteDictById(Long dictId);

    /**
     * 新增字典信息
     * 
     * @param levelDict 字典信息
     * @return 结果
     */
    int insertDict(LevelDict levelDict);

    /**
     * 修改字典信息
     * 
     * @param levelDict 字典信息
     * @return 结果
     */
    int updateDict(LevelDict levelDict);

    /**
     * 修改子元素关系
     * 
     * @param levelDicts 子元素
     * @return 结果
     */
    int updateDictChildren(@Param("dicts") List<LevelDict> levelDicts);

    /**
     * 根据字典ID查询信息
     * 
     * @param deptId 字典ID
     * @return 字典信息
     */
    LevelDict selectDictById(Long deptId);

    /**
     * 校验字典名称是否唯一
     * 
     * @param dictLabel 字典名称
     * @param parentId 父字典ID
     * @return 结果
     */
    LevelDict checkDictLabelUnique(@Param("dictLabel") String dictLabel, @Param("parentId") Long parentId);

    /**
     * 修改所在字典的父级字典状态
     * 
     * @param dict 字典
     */
    void updateDictStatus(LevelDict dict);

    /**
     * 根据ID查询所有子字典
     * 
     * @param dictId 字典ID
     * @return 字典列表
     */
    List<LevelDict> selectChildrenDictById(Long dictId);
}
