package com.practice;

import java.io.Serializable;

public class Employee implements Serializable, Cloneable {
    private static final long serialVersionUID = 3276917082079041629L;
    String name;
    transient int age;
    int rollNo;
    public Child child;

    public Employee(String name, int age, int rollNo) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.child = new Child();
    }

    public Employee() {

    }

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

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }


    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", rollNo=" + rollNo + ", child=" + child + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((child == null) ? 0 : child.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + rollNo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (age != other.age)
            return false;
        if (child == null) {
            if (other.child != null)
                return false;
        } else if (!child.equals(other.child))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (rollNo != other.rollNo)
            return false;
        return true;
    }

/*    @Override
    public Object clone() {
        Employee clone = new Employee();
        clone.setAge(this.age);
        clone.setName(this.name);
        clone.setRollNo(this.rollNo);
        clone.setChild(this.child);
        return clone;
    }
*/
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
