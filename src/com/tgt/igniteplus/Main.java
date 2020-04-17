package com.tgt.igniteplus;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Department department = new Department();
        Scanner in = new Scanner(System.in);



        do {
            System.out.println("----------------------------------------------------------");
            System.out.println("Press the option (Menu):\n1.\tTo display all the Departments\n2.\tCreate a new Department\n3.\tDelete a Department\n4.\tDisplay all the Members as per Department\n5.\tCreate a Member and add the member to the department\n6.\tAdd new skill to a department's members\n7.\tSearch members by skill\n8.\tSwap dept of a member");
            System.out.println("----------------------------------------------------------");


            int op = in.nextInt();
            switch (op) {
                case 1:
                    department.displayDepartments();
                    break;
                case 2:
                    department.createDepartment();
                    break;
                case 3:
                    department.deleteDepartment();
                    break;
                    case 4:department.displayMembersPerDepartment();
                        break;
                    case 5:
                        department.addNewMember();
                        break;
                case  6: department.addSkillToDepartmentMembers();
                        break;
                case  7: department.searchMembersBySkill();
                    break;
                case  8:
                    System.out.println(department.swapDepartment());
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + op);
            }
            if (in.nextLine().equals("quit"))
                return;

        } while (true);


    }
}