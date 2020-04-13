package com.tgt.igniteplus;

import java.util.*;

public class Department {
    Scanner in=new Scanner(System.in);
    private int totalDepartments=0;

    // <deptName, IgniteMemberList>
    Map<String,List<IgniteMembers>> mem = new HashMap<>();
    private ArrayList<String> departmentList =new ArrayList<String>();



    protected void createDepartment(){
        System.out.println("enter department name : ");
        departmentList.add(in.nextLine());

    }
    protected void displayDepartments(){
        for (int i = 0; i <departmentList.size() ; i++) {
            System.out.println((i+1)+". "+departmentList.get(i));
        }

    }
    public void deleteDepartment() {
        System.out.println("Enter dept name : ");
        departmentList.remove(in.nextLine());
        displayDepartments();
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentList=" + departmentList +
                '}';
    }
}
