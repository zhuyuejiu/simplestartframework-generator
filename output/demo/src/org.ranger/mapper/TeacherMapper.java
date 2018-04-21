package org.ranger.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteBuilder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertBuilder;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectBuilder;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateBuilder;
import org.apache.ibatis.session.RowBounds;
import org.simplestartframwork.context.annotation.component.Persistent;
import org.simplestartframwork.data.annotation.SQL;
import org.simplestartframwork.data.annotation.SQLBuilder;
import org.simplestartframwork.data.annotation.SQL.SQLType;
import org.springframework.stereotype.Repository;

import com.gb.mapper.Builder.ModularBuilder;

import org.ranger.mapper.Builder.TeacherBuilder;

/**
 * tb_teacher表操作映射接口
 * @author ranger
 *
 */
@Persistent
public interface TeacherMapper {
	
	/**
	 * @Description 插入记录
	 * @param entity -->(tea_name,tea_password) 
	 * 
	 * @return
	 */
	@SQL(type=SQLType.INSERT,value="INSERT INTO tb_teacher(tea_name,tea_password)  VALUES (#{tea_name},#{tea_password})")
	@Options(backfillParmaryKey=true,columnName="tea_id",propteryName="tea_id")
	int insert(Map<String,Object> entity);
	
	 /**
	  * @Description 批量插入记录 
	  * @param entitis -->(tea_name,tea_password) 
	  * @return
	  */
	@SQLBuilder(type=TeacherBuilder.class,method="batchInsert")
	int batchInsert(List<Map<String,Object>> entitis);
	
	/**
	 * @Description 根据一组ID删除记录
	 * @param entity -->(tea_name,tea_password) 
	 * @return
	 */
	@SQLBuilder(type=TeacherBuilder.class,method="deleteByIds")
	int deleteByIds(Object[] ids);
	
	/**
	 * @Description 根据ID删除记录
	 * @param id
	 * @return
	 */
	@SQL(type=SQLType.DELETE,value="DELETE FROM tb_teacher WHERE tea_id=#{id}")
	int deleteById(Object id);
	
	 /**
	  * @Description 更新记录
	  * @param entity -->(tea_name,tea_password) 
	  * @return
	  */
	@SQL(type=SQLType.UPDATE,value="UPDATE tb_teacher SET tea_name= #{tea_name},tea_password= #{tea_password} WHERE tea_id=#{tea_id} ")
	int update(Map<String,Object> entity);
	
	 /**
	  * @Description 批量更新记录
	  * @param entitis -->(tea_name,tea_password) 
	  * @return
	  */
	@SQLBuilder(type=TeacherBuilder.class,method="batchUpdate")
	int batchUpdate(List<Map<String,Object>> entitis);
	
	 /**
	  * @Description 查询所有记录 
	  * @return
	  */
	@SQL(type=SQLType.SELECT,value="SELECT * FROM tb_teacher")
	List<Map<String,Object>> findByAll();
	
	/**
	 * @Description 根据id查询数据记录
	 * 
	 * @param id
	 * @return
	 */
	@SQL(type=SQLType.SELECT,value="SELECT * FROM tb_teacher WHERE tea_id=#{id}")
	Map<String,Object> findById(Object id);
	
	/**
	 *  @Description 通过一组Id查询记录
	 * @param ids
	 * @return
	 */
	@SQL(type=SQLType.SELECT,type=TeacherBuilder.class,method="findByIds")
	List<Map<String,Object>>  findByIds(Object... ids);
	

	/**
	 * @Description  根据传入的实体查询记录
	 * @param entity
	 * @return
	 */
	@SQLBuilder(type=TeacherBuilder.class,method="findByEntity")
	List<Map<String, Object>> findByEntity(Map<String, Object> entity);
	/**
	 * 
	 * @Description  根据传入的实体获取到符合的记录数
	 * @param entity
	 * @return
	 */
	@SQLBuilder(type=TeacherBuilder.class,method="count")
	int count(Map<String, Object> entity);
	/**
	 * 
	 *@Description  根据传入的实体模糊匹配获取对应分页的记录
	 * @param entity
	 * @return
	 */
	@SQLBuilder(type=TeacherBuilder.class,method="findByEntityLikePage")
	List<Map<String, Object>> findByEntityLikePage(Map<String, Object> entity);
	/**
	 * 
	 * @Description  根据传入的实体获取记录
	 * @param entity
	 * @return
	 */
	@SQLBuilder(type=TeacherBuilder.class,method="findByEntityLike")
	List<Map<String, Object>> findByEntityLike(Map<String, Object> entity);
	

}