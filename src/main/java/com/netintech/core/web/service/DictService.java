package com.netintech.core.web.service;

import com.netintech.common.utils.security.ShiroUtils;
import com.netintech.core.web.domain.ParamEntity;
import com.netintech.enterprise.service.IEnterpriseService;
import com.netintech.park.service.ISmallParkService;
import com.netintech.project.system.dept.service.IDeptService;
import com.netintech.project.system.dict.domain.DictData;
import com.netintech.project.system.dict.service.IDictDataService;
import com.netintech.project.system.user.domain.User;
import com.netintech.project.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * html调用 thymeleaf 实现字典读取
 *
 * @author admin
 */
@Service("dict")
public class DictService
{
    @Autowired
    private IDictDataService dictDataService;

    @Autowired
    private IUserService userService;

    @Value("${deptid}")
    private String configdeptId ;

    @Autowired
    private ISmallParkService smallParkService;

    @Autowired
    private IEnterpriseService enterpriseService;

    @Autowired
    private IDeptService deptService;

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<DictData> getType(String dictType)
    {
        return dictDataService.selectDictDataByType(dictType);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String getLabel(String dictType, String dictValue)
    {
        return dictDataService.selectDictLabel(dictType, dictValue);
    }

    /**
     * 小微园下拉
     * @return
     */
    public List<ParamEntity> getParkList(){
        Long dept= null;
        User user = ShiroUtils.getSysUser();
        //大屏判断
        if (user == null) {
            return  dictDataService.getParkList(null);
        }
        if(user.getUserLevel().equals("2")){
            dept= smallParkService.getParkId(user.getDeptId());
        }else if(user.getUserLevel().equals("3")){
            dept= enterpriseService.getEnterpriseId(user.getDeptId());
            dept =  deptService.selectParentById(dept);
        }
        return  dictDataService.getParkList(dept);
    }

    /**
     * 政策大类
     */
    public List<ParamEntity>  getCatagoryList(){
        return dictDataService.getCatagoryList();
    }

    /**
     * 政策小类
     */
    public List<ParamEntity>  getTypeList(){
        return dictDataService.getTypeList();
    }

    /**
     * 园区下的企业
     * **/
    public  List<ParamEntity> getCompanyList(){
        Long deptId = ShiroUtils.getSysUser().getDeptId();
        return dictDataService.getCompanyList(String.valueOf(deptId));
    }

    public List<ParamEntity> getCompanyListByCreateBy(){
        return dictDataService.getCompanyListByCreateBy();
    }

    public List<ParamEntity> getDeptList(){
        return dictDataService.getDeptList();
    }

    public  List<ParamEntity> getAreaList(){

        return dictDataService.getAreaList();
    }

    public List<ParamEntity> getDeptList(String deptId ) {
        Map map = new HashMap();
        if(deptId.equals(configdeptId)){
            deptId = "100";
        }
        map.put("deptId",userService.getUserDeptId(Long.valueOf(deptId)).toString());
        map.put("configdeptId",configdeptId);
        return dictDataService.getDeptListByParentId(map);
    }


    //通知公告
    public List<DictData> getNoticeType(String type)
    {
        return dictDataService.getNoticeType(type);
    }

    //智能设备类型
    public List<ParamEntity> getSmartDeviceType(){
        return dictDataService.getSmartDeviceType();
    };
}
