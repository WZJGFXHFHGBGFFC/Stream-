package org.wzj;

public class Actor {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Actor() {
    }

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }


    /*
    当打印输出 org.wzj.Actor@34c45dca 这样的内容时，说明没有重写 Actor 类的 toString() 方法。
    默认情况下，toString() 方法会打印出对象的类名和哈希码值。
    要解决这个问题，你可以在 Actor 类中重写 toString() 方法，以便打印出更有意义的信息。
     */
    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
