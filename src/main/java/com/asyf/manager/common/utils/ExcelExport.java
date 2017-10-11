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
import java.util.*;

/**
 * Created by Administrator on 2017/9/28.
 */
public class ExcelExport {

    //方法+注解
    private List<Object[]> annotationList = new ArrayList();

    //sheetname
    private String sheetname;

    //构造函数--获得注解的方法和注解
    public ExcelExport(Class cls, String sheetname) {
        this.sheetname = sheetname;
        //获得所有的方法
        Method[] methods = cls.getDeclaredMethods();
        for (Method m : methods) {
            System.err.println(m.getName());
            //获得方法上的注解
            ExcelField ef = m.getAnnotation(ExcelField.class);
            if (ef != null) {
                System.err.println(ef);
                Object[] objects = new Object[2];
                objects[0] = m;
                objects[1] = ef;
                annotationList.add(objects);
            }
        }
        // Field sorting
        Collections.sort(annotationList, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                return new Integer(((ExcelField) o1[1]).sort()).compareTo(
                        new Integer(((ExcelField) o2[1]).sort()));
            }
        });
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
        user.setPhone("15335852588");
        user.setName("name222");
        user.setEmail("2326356@qq.com");
        List<User> list = new ArrayList<User>();
        list.add(user);
        list.add(user);
        list.add(user);

        ExcelExport excelExport = new ExcelExport(User.class, "sheetname");
        excelExport.exportExcel(list);

        /*Class<User> cls = User.class;
        Method m = cls.getMethod("getName", null);
        Object o = m.invoke(user, null);
        System.err.println(o);*/
        System.err.println("poi_test-----------------------------");
    }

    public <E> void exportExcel(List<E> list) {
        try {
            // 第一步，创建一个webbook，对应一个Excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet = wb.createSheet(sheetname);
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            HSSFRow row = sheet.createRow((int) 0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

            //第5步，设置表头
            int a = 0;
            for (Object[] objects : annotationList) {
                HSSFCell cell = row.createCell(a++);
                ExcelField ef = (ExcelField) objects[1];
                String value = ef.value();
                cell.setCellValue(value);
                cell.setCellStyle(style);
            }

            // 第6步，写入实体数据 实际应用中这些数据从数据库得到
            for (int i = 0; i < list.size(); i++) {
                row = sheet.createRow((int) i + 1);
                E e = list.get(i);
                a = 0;
                for (Object[] objects : annotationList) {
                    Method m = (Method) objects[0];
                    HSSFCell cell = row.createCell(a++);
                    Object obj = m.invoke(e, null);
                    cell.setCellValue(obj == null ? null : obj.toString());
                }
                //  row.createCell(0).setCellValue(user.getId());
                //row.createCell((short) 1).setCellValue(user.getName());
            }
            // 第7步，将文件存到指定位置(方法传一个输出流，写到相应的输出流)

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

}
