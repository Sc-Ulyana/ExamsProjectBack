package com.example.examsprojectback.mapper;

import com.example.examsprojectback.domain.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface RoleMapper {
    ArrayList<Role> selectAllRoles();

    Role selectUserRoleByUserId(int userId);

    Role selectRoleByRoleId(int id);

    void updateRole(Role role);

    void insertRole(Role role);

    void deleteRole(int id);
}
