package org.windwant.rest.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.windwant.rest.model.Student;
import org.windwant.rest.model.StudentExample;

public interface StudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbg.generated Wed Dec 20 10:25:19 CST 2017
     */
    long countByExample(StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbg.generated Wed Dec 20 10:25:19 CST 2017
     */
    int deleteByExample(StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbg.generated Wed Dec 20 10:25:19 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbg.generated Wed Dec 20 10:25:19 CST 2017
     */
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbg.generated Wed Dec 20 10:25:19 CST 2017
     */
    int insertSelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbg.generated Wed Dec 20 10:25:19 CST 2017
     */
    List<Student> selectByExample(StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbg.generated Wed Dec 20 10:25:19 CST 2017
     */
    Student selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbg.generated Wed Dec 20 10:25:19 CST 2017
     */
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbg.generated Wed Dec 20 10:25:19 CST 2017
     */
    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbg.generated Wed Dec 20 10:25:19 CST 2017
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table students
     *
     * @mbg.generated Wed Dec 20 10:25:19 CST 2017
     */
    int updateByPrimaryKey(Student record);
}