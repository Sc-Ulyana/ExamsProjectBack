package com.example.examsprojectback.service;

import com.example.examsprojectback.domain.Role;
import com.example.examsprojectback.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getRoleById(int id) {
        return roleMapper.selectRoleByRoleId(id);
    }
}
