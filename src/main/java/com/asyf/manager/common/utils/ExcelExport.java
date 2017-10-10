package com.asyf.manager.common.utils;

import com.asyf.manager.common.annotation.ExcelField;
import com.asyf.manager.modules.sys.entity.User;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.formula.functions.T;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2017/9/28.
 */
public class ExcelExport {

    //private List<>
    //构造函数--获得注解的方法和注解
    public ExcelExport(Class cls) {
        Method[] methods = cls.getDeclaredMethods();
        for (Method m : methods) {
            System.err.println(m.getName());
        }
    }

    public void exportExcel(List<User> list) {
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("学生表一");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("学号");
        cell.setCellStyle(style);
        cell = row.createCell((short) 1);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，

        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow((int) i + 1);
            User user = (User) list.get(i);
            // 第四步，创建单元格，并设置值
            row.createCell(0).setCellValue(user.getId());
            row.createCell((short) 1).setCellValue(user.getName());
        }
        // 第六步，将文件存到指定位置
        try {
            File file = new File("D:/test");
            if (!file.exists()) {
                file.mkdir();
            }
            FileOutputStream out = new FileOutputStream("D:/test/user.xls");
            wb.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取注解的列名，遍历数据，每一条的数据通过反射调用注解的getter获得每列的数据，存储到cell
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.err.println("poi_test-----------------------------");
        User user = new User();
        user.setId("s");
        user.setName("name");
        List<User> list = new ArrayList<User>();
        ExcelExport excelExport = new ExcelExport(User.class);

        System.err.println("poi_test-----------------------------");
    }
}
