package com.job5156.util.option;

/**
 * <p>选项类</p>
 * Date: 2015/6/5 10:00
 *
 * @version 1.0
 * @autor: Lu Weibiao
 */
public class BaseOption<K,T> {
    public final K code;
    public final T name;

    public BaseOption(K code, T name){
        this.code = code;
        this.name = name;
    }

    public K getCode() {
        return code;
    }

    public T getName() {
        return name;
    }

}
