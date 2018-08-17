package com.example.springboot2.dao;


import com.example.springboot2.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface UserDao {
    @Select({"select * from user where id =#{id}"})
    User queryUserById(int id);

    @Insert("insert into user (name,age,nice_name,address) values(#{name,},#{age},#{niceName},#{address})")
    int add(User user);

    @Select({"<script>" +
            "select * from user where 1=1 " +
            "<if test='name !=null '> and name like concat('%',#{name},'%')</if>" +
            "<if test='age !=null '> and  age = #{age}</if>" +
            "<if test='id !=null '> and id = #{id})</if>" +
            "</script>"})
    List<User> queryUsersWithCondi(User user);

    @Update({"update user set name=#{name},age =#{age} where id =#{id}"})
    int update(User user);

    @Delete({"delete from user where id =#{id}"})
    int delete(User user);


    @SelectProvider(type = UserMapperProvider.class,method = "queryUserMapById")
    Map<String,Object> queryUserMapById(Map<String,Object> paramMap);

    @DeleteProvider(type = UserMapperProvider.class,method = "deleteAll")
    int deleteAll(@Param("list")List<User> userList);

    @InsertProvider(type = UserMapperProvider.class,method = "insertAll")
    int insertAll(@Param("list") List<User> userList);

    class UserMapperProvider{

        public String insertAll(Map<String,List<User>> map){
            List<User> list = map.get("list");
            StringBuffer buffer = new StringBuffer("insert into  user (name,age,nice_name,address) values ");
            String vals= "(#'{'list[{0}].name},#'{'list[{0}].age},#'{'list[{0}].niceName},#'{'list[{0}].address})";

            for (int i =0,length=list.size();i<length;i++){
                User user = list.get(i);
                String valueStr = MessageFormat.format(vals, new Object[]{i,i,i,i});
                buffer.append(valueStr);
                if(i<length-1){
                    buffer.append(",");
                }
            }
            return buffer.toString();
        }


        public String deleteAll(Map<String,List<User>> map){
            List<User> list = map.get("list");
            StringBuffer buffer = new StringBuffer("delete from user where id in (");

            Iterator<User> iterator = list.iterator();
            if(iterator.hasNext()){
                buffer.append(iterator.next().getId());
                while (iterator.hasNext()){
                    User next = iterator.next();
                    buffer.append(", ").append(next.getId());
                }
            }

            buffer.append(")");

            return buffer.toString();
        }


        public String queryUserMapById(){
            String sql = "select * from user where id = #{id} ";
            return  sql;
        }
    }


}
