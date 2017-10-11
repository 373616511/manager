package com.asyf.manager.test;

/**
 * Created by Administrator on 2017/10/11.
 * new Sub();在创造派生类的过程中首先创建基类对象，然后才能创建派生类。
 * 创建基类即默认调用Base()方法，在方法中调用callName()方法，由于派生类中存在此方法，则被调用的callName()方法是派生类中的方法，此时派生类还未构造，所以变量baseName的值为null
 * <p>
 * 先成员变量再构造方法，先父类再子类
 * 多态表现：有同名方法执行子类的
 * <p>
 * 执行 Base b = new Sub();时，由于多态 b编译时表现为Base类特性，运行时表现为Sub类特性，
 * Base b = new Sub()；不管是哪种状态都会调用Base构造器执行 callName()方法；
 * 执行方法时，由于多态表现为子类特性，所以会先在子类是否有 callName()；
 * 而此时子类尚未初始化（执行完父类构造器后才会开始执行子类），如果有 就 执行(此时， 因为还没有调用子类构造函数， 所以子类的 baseName 输出为 null)，没有再去父类寻找。
 */
public class Base {
    private String baseName = "base";

    public Base() {
        System.out.println("Constructor Base : " + baseName);

        System.out.println("before Base callName() -----");

        callName();

        System.out.println("after Base callName() -----");
    }

    public void callName() {
        System.out.println("& " + baseName);
    }

    static class Sub extends Base {
        private String baseName = "sub";

        public Sub() {
            System.out.println("Constructor Sub : " + baseName);
        }

        @Override
        public void callName() {
            System.out.println("# " + baseName);
        }
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.callName();
    }

}
