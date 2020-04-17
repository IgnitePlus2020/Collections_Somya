package com.tgt.igniteplus;

import java.util.*;

public class Department {
    Scanner in=new Scanner(System.in);

    // <deptName, IgniteMemberList>
    HashMap<String,List<IgniteMembers>> departmentMembers = new HashMap<>();
    private ArrayList<String> departmentList =new ArrayList<>();

//****************************************************************************************
    protected void createDepartment(){
        System.out.println("enter department name : ");
        String dept=in.nextLine();
        //to access dept by order
        departmentList.add(dept);
        departmentMembers.put(dept,null);
    }

//******************************************************************************************

    protected void displayDepartments(){
         for (int i = 0; i <departmentList.size() ; i++) {
            System.out.println(i+1+") "+departmentList.get(i));
        }
        System.out.println();
    }

//**********************************************************************************************8
    public void deleteDepartment() {
        System.out.println("Enter option to delete : ");
        int delIndex=Integer.parseInt(in.nextLine());
        String dep=departmentList.get(delIndex-1);
        departmentList.remove(delIndex-1);
        departmentMembers.remove(dep);
       System.out.println("dept status after deletion");    displayDepartments();
    }
//*****************************************************************************************
    protected void addNewMember() {

        //entry of details of a new member and adding them to particular dept
        IgniteMembers member = new IgniteMembers();
        Set<String> SkillSet = new HashSet<>();


        System.out.print("Enter the Name of the Member: ");
        member.setName(in.nextLine());
        System.out.print("Enter the Age of the Member: ");
        member.setAge(Integer.parseInt(in.nextLine()));
        System.out.print("Enter the College Name: ");
        member.setCollege(in.nextLine());

        System.out.print("Enter the SkillSet: ");
        String skill;
        while (in.hasNextLine()) {
            skill = in.nextLine();
            if (skill.isEmpty()) {
                member.setSkillSet(SkillSet);
                break;
            }
            SkillSet.add(skill);
        }

        //adding new member to a department
        System.out.println("Add the member to the following dept:\n");
        displayDepartments();

        //get the list of members in that department using key==dept name....then add to this list our new member


        String dept=in.nextLine();
        addToDept(member,dept);

    }
//*************************************************************************************************

    private void deleteFromDepartment(IgniteMembers member, String prevDept) {
        departmentMembers.get(prevDept).remove(member);
    }

//**************************************************************************************************

protected void addToDept(IgniteMembers member,String dept){

            if(departmentMembers.get(dept)==null){
                List<IgniteMembers> deptMember = new ArrayList<>();
                deptMember.add(member);

                departmentMembers.put(dept,deptMember);
            }
            else departmentMembers.get(dept).add(member);

        }
//*********************************************************************************

    protected void displayMembersPerDepartment(){

        System.out.println("----------------dept members-------------------------------");

        Set<Map.Entry<String,List<IgniteMembers>>> set=departmentMembers.entrySet();
        for (Map.Entry<String,List<IgniteMembers>> mem:set){
            if(mem.getValue()==null)
                System.out.println(mem.getKey()+" : "+"no members ");
            else{
                    System.out.println(mem.getKey());
                    for (IgniteMembers member:mem.getValue()
                         ) {
                        System.out.println(member.toString());
                    }
            }
        }
    }
//****************************************************************************************
    //add a new skill to skillSet of members of a particular department
    protected void addSkillToDepartmentMembers(){
        Set<String> SkillSet = new HashSet<>();
        System.out.println("enter department name : ");
        String dept=in.nextLine();
        System.out.println("enter skill to be added : ");
        String newSkill=in.nextLine();
        for (IgniteMembers member:departmentMembers.get(dept)
             ) {
            member.getSkillSet().add(newSkill);

        }
        displayMembersPerDepartment();
    }


//**********************************************************************************

    protected void searchMembersBySkill(){
        System.out.println("Enter the skill : ");
        String skill=in.nextLine();
        for (String dept:departmentMembers.keySet()
             ) {
            for (IgniteMembers mem: departmentMembers.get(dept)
                 ) {
                if(mem.getSkillSet().contains(skill))
                    System.out.println(dept+" ("+mem.toString()+")");
            }
        }
    }
//************************************************************************************

    protected  boolean swapDepartment(){
        displayMembersPerDepartment();
        System.out.println("enter member name");
        String memberName=in.nextLine();
        System.out.println("enter new Department name");
        String newDept=in.nextLine();

        String prevDept;
        for (String dept:departmentMembers.keySet()
        ) {
            for (IgniteMembers mem: departmentMembers.get(dept)
            ) {
                if(mem.getName().equals(memberName))
                {
                    addToDept(mem,newDept);
                    deleteFromDepartment(mem,dept);
                    return true;
                }
            }
        }
        return false;
    }

}//Department Class
