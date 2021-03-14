package com.valtech.talent.program;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ValtechTalentProgram {

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ValtechTalentProgram (count="+count+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValtechTalentProgram that = (ValtechTalentProgram) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    public static void main(String[] args) {
        ValtechTalentProgram vtp = new ValtechTalentProgram();
        vtp.setCount(1);

        ValtechTalentProgram vtp2 = new ValtechTalentProgram();
        vtp2.setCount(1);


        HashSet<ValtechTalentProgram> set = new HashSet<>();
        set.add(vtp);
        set.add(vtp2);


        System.out.println(vtp);

        System.out.println(set);

        System.out.println(vtp.equals(vtp2));


    }

    //protected void finalize() throws Throwable {  }

}
