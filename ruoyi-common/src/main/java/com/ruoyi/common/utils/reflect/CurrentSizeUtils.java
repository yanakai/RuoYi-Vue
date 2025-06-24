package com.ruoyi.common.utils.reflect;

import java.lang.reflect.Method;

/**
 * 反射工具类. 提供调用getter/setter方法, 对页码页大小进行修改
 */
public class CurrentSizeUtils {

    /**
     * 条件性设置字段值（先检查当前值是否不同）
     * @param obj 目标对象
     * @param getName 字段名，如 getCurrent、 getSize
     * @param setName 字段名，如 setCurrent、 setSize
     * @param defaultValue 新值
     */
    public static void currentAndSize(Object obj, String getName, String setName, Integer defaultValue) {
        try {
            // 1. 获取getter方法
            Method getter = obj.getClass().getMethod(getName);
            // 2. 调用getter获取当前值
            Object currentValue = getter.invoke(obj);

            // 3. 比较当前值和新值
            if (null == currentValue || (int)currentValue < 1) {
                // 4. 获取setter方法并设置新值
                Method setter = obj.getClass().getMethod(setName, getter.getReturnType());
                setter.invoke(obj, defaultValue);
            }
        } catch (Exception e) {
            throw new RuntimeException("反射调用失败", e);
        }
    }
}
