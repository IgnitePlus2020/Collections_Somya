package com.tgt.igniteplus;

import java.util.*;

public class Department {
    Scanner in=new Scanner(System.in);


    // <deptName, IgniteMemberList>
    Map<String,List<IgniteMembers>> mem = new HashMap<>();
    private ArrayList<String> departmentList =new ArrayList<>();
    List<IgniteMembers> departmentMembersList=new LinkedList<>();



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

    protected void addNewMember(){

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
            String temp;
            while (in.hasNextLine()) {
                temp = in.nextLine();
                if (temp.isEmpty()) {
                    member.setSkillSet(SkillSet);
                    break;
                }
                SkillSet.add(temp);
            }

        System.out.println(member.toString());

            //adding new member to a department
            System.out.println("Add the member to the following dept:\n");
            displayDepartments();
            //get the list of members in that department using key==dept name....then add to this list our new member

/*nullPointerException
        String dept=in.nextLine();

           departmentMembersList=mem.get(dept);
           departmentMembersList.add(member);
        for(IgniteMembers i: mem.get(dept))
            System.out.println(i.toString());
*/



        }



    @Override
    public String toString() {
        return "Department{" +
                "departmentList=" + departmentList +
                '}';
    }
}
