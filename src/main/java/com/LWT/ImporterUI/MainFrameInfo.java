package com.LWT.ImporterUI;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Created by Badger on 15/7/15.
 */
public class MainFrameInfo {
    //初始化若干条件
    public boolean p_IsTestEnv;//测试服务器
    public boolean p_IsDateEnable;//正式服务器
    public boolean p_IsWriteBack;//回写数据库
    public boolean p_IsUnitCount;//指定条数
    public String p_UnitCount;//数目
    public String p_DateStart;//开始日期
    public String p_DateEnd;//结束日期

    public MainFrameInfo(){
        p_IsTestEnv = true;
        p_IsDateEnable = false;
        p_IsWriteBack = false;
        p_IsUnitCount = false;
        p_UnitCount = "";
        p_DateStart = "";
        p_DateEnd = "";
    }

    public static class IntNumberDocument extends PlainDocument{

        @Override
        public void insertString(int offset, String s, AttributeSet attrSet) throws BadLocationException {
            if (offset > 8) return;
            //将字符串解析成数字是否会抛出异常，抛出异常则说明该字符不为数字，返回，否则插入文本框中
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                return;
            }
            super.insertString(offset, s, attrSet);
        }
    }


    public static class IntDateDocument extends PlainDocument{

        @Override
        public void insertString(int offset, String s, AttributeSet attrSet) throws BadLocationException {
            if (offset > 7) return;
            //将字符串解析成数字是否会抛出异常，抛出异常则说明该字符不为数字，返回，否则插入文本框中
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                return;
            }
            super.insertString(offset, s, attrSet);
        }
    }
}
