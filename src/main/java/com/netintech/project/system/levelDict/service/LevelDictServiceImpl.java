package com.netintech.project.system.levelDict.service;

import com.netintech.common.constant.UserConstants;
import com.netintech.common.exception.BusinessException;
import com.netintech.common.utils.StringUtils;
import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.core.web.domain.Ztree;
import com.netintech.project.system.levelDict.domain.LevelDict;
import com.netintech.project.system.levelDict.mapper.LevelDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典管理 服务实现
 * 
 * @author admin
 */
@Service
public class LevelDictServiceImpl implements ILevelDictService
{
    @Autowired
    private LevelDictMapper dictMapper;

    /**
     * 查询字典管理数据
     * 
     * @param dept 字典信息
     * @return 字典信息集合
     */
    @Override
    public List<LevelDict> selectLevelDictList(LevelDict dept)
    {
        return dictMapper.selectLevelDictList(dept);
    }

    /**
     * 查询字典管理树
     * 
     * @param levelDict 字典信息
     * @return 所有字典信息
     */
    @Override
    public List<Ztree> selectDictTree(LevelDict levelDict)
    {
        List<LevelDict> dictList = dictMapper.selectLevelDictList(levelDict);
        List<Ztree> ztrees = initZtree(dictList);
        return ztrees;
    }

    /**
     * 对象转字典树
     *
     * @param dictList 字典列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<LevelDict> dictList)
    {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (LevelDict dict : dictList)
        {
            if (UserConstants.DICT_NORMAL.equals(dict.getStatus()))
            {
                Ztree ztree = new Ztree();
                ztree.setId(dict.getDictId());
                ztree.setpId(dict.getParentId());
                ztree.setName(dict.getDictLabel());
                ztree.setTitle(dict.getDictLabel());
                ztrees.add(ztree);
            }
        }
        return ztrees;
    }

    /**
     * 查询下级字典人数
     * 
     * @param parentId 字典ID
     * @return 结果
     */
    @Override
    public int selectDictCount(Long parentId)
    {
        LevelDict dict = new LevelDict();
        dict.setParentId(parentId);
        return dictMapper.selectDictCount(dict);
    }

    /**
     * 删除字典管理信息
     * 
     * @param dictId 字典ID
     * @return 结果
     */
    @Override
    public int deleteDictById(Long dictId)
    {
        return dictMapper.deleteDictById(dictId);
    }

    /**
     * 新增保存字典信息
     * 
     * @param dict 字典信息
     * @return 结果
     */
    @Override
    public int insertDict(LevelDict dict)
    {
        LevelDict info = dictMapper.selectDictById(dict.getParentId());
        // 如果父节点不为"正常"状态,则不允许新增子节点
        if (info!=null && !UserConstants.DICT_NORMAL.equals(info.getStatus()))
        {
            throw new BusinessException("字典停用，不允许新增");
        }
        if(null==info){
            dict.setAncestors(dict.getParentId()+"");
        }else{
            dict.setAncestors(info.getAncestors() + "," + info.getDictId());
        }
        dict.setCreateBy(ShiroUtils.getUserStringId());
        return dictMapper.insertDict(dict);
    }

    /**
     * 修改保存字典信息
     * 
     * @param dict 字典信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateDict(LevelDict dict)
    {
        LevelDict newParentDict = dictMapper.selectDictById(dict.getParentId());
        LevelDict oldDict = selectDictById(dict.getDictId());
        if (StringUtils.isNotNull(newParentDict) && StringUtils.isNotNull(oldDict))
        {
            String newAncestors = newParentDict.getAncestors() + "," + newParentDict.getDictId();
            String oldAncestors = oldDict.getAncestors();
            dict.setAncestors(newAncestors);
            updateDeptChildren(dict.getDictId(), newAncestors, oldAncestors);
        }
        dict.setUpdateBy(ShiroUtils.getUserStringId());
        int result = dictMapper.updateDict(dict);
        if (UserConstants.DICT_NORMAL.equals(dict.getStatus()))
        {
            // 如果该字典是启用状态，则启用该字典的所有上级字典
            this.updateParentDictStatus(dict);
        }
        return result;
    }

    /**
     * 修改该字典的父级字典状态
     * 
     * @param dict 当前字典
     */
    private void updateParentDictStatus(LevelDict dict)
    {
        String updateBy = dict.getUpdateBy();
        dict = dictMapper.selectDictById(dict.getDictId());
        dict.setUpdateBy(updateBy);
        dictMapper.updateDictStatus(dict);
    }

    /**
     * 修改子元素关系
     * 
     * @param dictId 被修改的字典ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateDeptChildren(Long dictId, String newAncestors, String oldAncestors)
    {
        List<LevelDict> children = dictMapper.selectChildrenDictById(dictId);
        for (LevelDict child : children)
        {
            child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0)
        {
            dictMapper.updateDictChildren(children);
        }
    }


    /**
     * 根据字典ID查询信息
     * 
     * @param dictId 字典ID
     * @return 字典信息
     */
    @Override
    public LevelDict selectDictById(Long dictId)
    {
        return dictMapper.selectDictById(dictId);
    }

    /**
     * 校验字典名称是否唯一
     * 
     * @param dict 字典信息
     * @return 结果
     */
    @Override
    public String checkDictLabelUnique(LevelDict dict)
    {
        Long dictId = StringUtils.isNull(dict.getDictId()) ? -1L : dict.getDictId();
        LevelDict info = dictMapper.checkDictLabelUnique(dict.getDictLabel(), dict.getParentId());
        if (StringUtils.isNotNull(info) && info.getDictId().longValue() != dictId.longValue())
        {
            return UserConstants.LEVEL_DICT_NAME_NOT_UNIQUE;
        }
        return UserConstants.LEVEL_DICT_NAME_UNIQUE;
    }
}
