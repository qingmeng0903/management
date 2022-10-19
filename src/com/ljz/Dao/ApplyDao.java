package com.ljz.Dao;

import com.ljz.Model.ActType;
import com.ljz.Model.Activity;
import com.ljz.Util.StringUtil;
import com.ljz.Model.Apply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ApplyDao {
    //  申请人姓名
    public  int applyname(Connection con, Apply apply) throws Exception {
        String sql="insert into applyname values(0,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,apply.getApplyName());
        return pstmt.executeUpdate();
    }
    //社团名称
    public int  acttypename(Connection con, Apply apply) throws Exception {
        String sql="insert into  acttypename values(0,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, apply.getActtypename());
        return pstmt.executeUpdate();
    }
    //申请理由
    public int applydesc(Connection con,Apply apply) throws Exception {
        String sql="insert into applydesc values(0,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,apply.getApplyDesc());
        return pstmt.executeUpdate();
    }
    //申请时间
    public int applytime(Connection con,Apply apply) throws Exception {
        String sql="insert into applytime values(0,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,apply.getApplytime());
        return pstmt.executeUpdate();
    }


    //查询社团
    public ResultSet listApp(Connection con, Apply apply) throws Exception {
        StringBuffer sb=new StringBuffer("select * from apply");
        if(StringUtil.isNotEmpty(apply.getApplyName())) {
            sb.append(" and actTypeName like '%"+ apply.getApplyName()+"%'");
        }
        PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and","where"));
        return pstmt.executeQuery();
    }
}