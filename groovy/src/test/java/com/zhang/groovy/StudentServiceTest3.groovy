package com.zhang.groovy

import com.zhang.groovy.dao.StudentDao
import com.zhang.groovy.dto.StudentDTO
import com.zhang.groovy.service.impl.StudentServiceImpl
import com.zhang.groovy.util.PhoneDesensitizedUtil
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate
import spock.lang.Specification
import spock.lang.Unroll

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnitPlatform.class)
@PrepareForTest([PhoneDesensitizedUtil.class])
class StudentServiceTest3 extends Specification {

    def dao = Mock(StudentDao)
    def service = new StudentServiceImpl(studentDao: dao)


    void setup() {
        PowerMockito.mockStatic(PhoneDesensitizedUtil.class)
    }

    @Unroll
    def "input 学生id：#id,返回的邮编：#postCodeResult,返回的省份简称:#abbreviationResult，手机号为:#phone"() {
        given: "设置请求参数"
        dao.getStudentInfo() >> students
        def desenPhone = "151****3963"
        and: "mock静态方法返回值"
        PowerMockito.when(PhoneDesensitizedUtil.desensitized(Mockito.any())).thenReturn(desenPhone)

        when: "获取学生信息"
        def response = service.getStudentById(id)

        then: "验证结果"
        with(response) {
            postCode == postCodeResult
            abbreviation == abbreviationResult
            telephone == phone
        }
        where: "经典之处：表格方式验证学生信息的分支场景"
        id | students                                 || postCodeResult | abbreviationResult | phone
        1  | getStudent(1, "张三", "北京", "15136963963") || "100000"       | "京"                | "151****3963"
        2  | getStudent(2, "李四", "上海", null)          || "200000"       | "沪"                | null
    }

    static def getStudent(def id, def name, def province, def phone) {
        return [new StudentDTO(id: id, name: name, province: province, phone: phone)]
    }
}
