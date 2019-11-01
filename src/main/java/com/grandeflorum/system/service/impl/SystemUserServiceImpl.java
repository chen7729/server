package com.grandeflorum.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grandeflorum.common.domain.Page;
import com.grandeflorum.common.domain.PagingEntity;
import com.grandeflorum.common.domain.ResponseBo;
import com.grandeflorum.common.service.impl.BaseService;
import com.grandeflorum.common.util.GuidHelper;
import com.grandeflorum.system.dao.SystemUserMapper;
import com.grandeflorum.system.domain.SystemUser;
import com.grandeflorum.system.service.SystemUserRoleService;
import com.grandeflorum.system.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 13260 on 2019/11/1.
 */
@Service("SystemUserService")
public class SystemUserServiceImpl extends BaseService<SystemUser> implements SystemUserService {

    @Autowired
    private SystemUserMapper userMapper;

    @Autowired
    private SystemUserRoleService userRoleService;

    @Override
    public int addUser(SystemUser user) {
        user.setId(GuidHelper.getGuid());
        try {
            userMapper.insert(user);
            userRoleService.insertUserRoleByRole(user);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int modifyUser(SystemUser userWithRole) {
        try {
            userMapper.updateByPrimaryKey(userWithRole);
            userRoleService.deleteUserRoleByUserId(userWithRole.getId());
            userRoleService.insertUserRoleByRole(userWithRole);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int deleteUserById(String id) {
        try {
            userMapper.deleteByPrimaryKey(id);
            userRoleService.deleteUserRoleByUserId(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public SystemUser getUserWithRoleByUserId(String userId) {
        return userMapper.getUserDetailByUserId(userId);
    }

    @Override
    public List<String> getAllPermissionByUserId(String userId) {
        List<String> result = userMapper.getPermissionByUserId(userId);
        return result;
    }

    @Override
    public ResponseBo getUserList(Page page) {
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        Map<String, Object> map = page.getQueryParameter();
        List<SystemUser> list = userMapper.getUserList(map);

        PageInfo<SystemUser> pageInfo = new PageInfo<SystemUser>(list);

        PagingEntity<SystemUser> result = new PagingEntity<>(pageInfo);

        return ResponseBo.ok(result);
    }

    @Override
    public SystemUser login(Map<String, String> map) {

        return userMapper.login(map);

    }

    @Override
    public SystemUser findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public int changePassword(SystemUser user) {
        return userMapper.changePassword(user);
    }
}