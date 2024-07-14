package com.example.multiple;
// Programmer: Pepper Berry
// Date: 5/30/2023
// Purpose: binary tree dictonary of customers
import java.util.*;
public class Test {

    static Node root;
    static int l;
    public static void main(String[] args) {


        root = null;



        boolean is_Changing = true;
        int n = 0;
        while (is_Changing) {

            System.out.println("\n1.Add new member\n2.look up a member in order\n3.look up a member by post order\n" +
                    "4.look up a member by pre order\n5.number of members" +
                    "\n6.Delete a member\n7.modify a member's info\n8.Exit");
            Scanner input = new Scanner(System.in);
            String action = input.next();
            switch (action) {
                case "1":// Add a new member
                    ++n;
                    Object person = newContact();


                    root = insert(person);
                    System.out.print("the added member information reads: [");
                    findInOrder(root, (person.firstName+person.lastName));
                    System.out.println("]");

                    break;

                case "2":// in order
                    if (n == 0) {
                        System.out.println("there are no members to view");
                        break;
                    }
                    Scanner inputIn = new Scanner(System.in);
                    System.out.println("type in the members name to view in order");
                    System.out.println("What is the first name of the member you want to view?");
                    String firstNameIn = inputIn.nextLine();
                    System.out.println("What is the last name of the member you want to view?");
                    String lastNameIn = inputIn.nextLine();
                    System.out.print("the member information reads: [");
                    findInOrder(root, (firstNameIn+lastNameIn));
                    System.out.println("]");

                    break;
                case "3":// post order
                    if (n == 0) {
                        System.out.println("there are no members to view");
                        break;
                    }
                    Scanner inputPost = new Scanner(System.in);
                    System.out.println("type in the members name to view by post order");
                    System.out.println("What is the first name of the member you want to view?");
                    String firstNamePost = inputPost.nextLine();
                    System.out.println("What is the last name of the member you want to view?");
                    String lastNamePost = inputPost.nextLine();
                    System.out.print("the member information reads: [");
                    findInPostOrder(root, (firstNamePost+lastNamePost));
                    System.out.println("]");

                    break;
                case "4":// pre order
                    if (n == 0) {
                        System.out.println("there are no members to view");
                        break;
                    }
                    Scanner inputPre = new Scanner(System.in);
                    System.out.println("type in the members name to view by pre order");
                    System.out.println("What is the first name of the member you want to view?");
                    String firstNamePre = inputPre.nextLine();
                    System.out.println("What is the last name of the member you want to view?");
                    String lastNamePre = inputPre.nextLine();
                    System.out.print("the member information reads: [");
                    findInPreOrder(root, (firstNamePre+lastNamePre));
                    System.out.println("]");

                    break;
                case "5":// num of members

                    int x = findAll(root);
                    l = 0;
                    System.out.print("there are "+x+" members");

                    break;
                case "6"://delete
                    if (n == 0) {
                        System.out.println("there are no members to delete");
                        break;
                    }
                    Scanner inputDelete = new Scanner(System.in);
                    System.out.println("type in the members name to delete");
                    System.out.println("What is the first name of the member you want to delete?");
                    String firstNameDelete = inputDelete.nextLine();
                    System.out.println("What is the last name of the member you want to delete?");
                    String lastNameDelete = inputDelete.nextLine();
                    System.out.print("the member you want to delete reads: [");
                    findInOrder(root, (firstNameDelete+lastNameDelete));
                    System.out.println("]\ndo you still want to delete this member?");
                    String deleteYes = inputDelete.nextLine();
                    if (deleteYes.toLowerCase().charAt(0) == 'y') {
                        delete(firstNameDelete + lastNameDelete);
                    }
                    break;
                case "7"://modify
                    if (n == 0) {
                        System.out.println("there are no members to modify");
                        break;
                    }
                    Scanner inputMod = new Scanner(System.in);
                    System.out.println("type in the members name to view in order");
                    System.out.println("What is the first name of the member you want to monify?");
                    String firstNameMod = inputMod.nextLine();
                    System.out.println("What is the last name of the member you want to modify?");
                    String lastNameMod = inputMod.nextLine();
                    System.out.print("the member information reads: [");
                    findInOrder(root, (firstNameMod+lastNameMod));
                    System.out.println("]\ndo you still want to modify this member?");
                    String modifyYes = inputMod.nextLine();
                    if (modifyYes.toLowerCase().charAt(0) == 'y') {
                        modify(root, (firstNameMod+lastNameMod));
                    }
                    break;
                case "8":// To exit
                    is_Changing = false;
                    break;
                default:// if they get it wrong
                    System.out.println("oops that is not a choice!\n");
            }
        }
    }
    public static Node insert(Object person) {
        root = insertNode(root, person);
        return root;
    }

    protected static Node insertNode(Node root, Object person) {
        if (root == null) {
            root = new Node(person);
            return root;
        }

        int i = 0;
        boolean equals = true;
        while (equals) {
            char x = Node.key.charAt(i);
            char y = (person.firstName + person.lastName ).charAt(i);
            if (x > y) {
                root.left = insertNode(root.left, person);
                equals = false;
            } else if (Node.key.charAt(i) < (person.firstName + person.lastName).charAt(i)) {
                root.right = insertNode(root.right, person);
                equals = false;
            } else if (Node.key.charAt(i) == (person.firstName + person.lastName ).charAt(i)) {
                ++i;
            }
        }

        return root;
    }

    public static int findAll(Node root) {


        if (root != null) {
            findAll(root.left);

            ++l;
            findAll(root.right);
        }

        return l;

    }
    public static Node findInOrder(Node root, String realPerson) {

        Node rootPerson = null;
        if (root != null) {
            findInOrder(root.left, realPerson);
            if ((root.person.firstName + root.person.lastName).equals(realPerson)){
                rootPerson = root;//this needs to be the root
                System.out.print(root.person);
            }
            findInOrder(root.right, realPerson);

        }
        return rootPerson;
    }
    public static Node findInPreOrder(Node root, String realPerson) {
        Node rootPerson = null;
        if (root != null) {
            if ((root.person.firstName + root.person.lastName).equals(realPerson)){
                rootPerson = root;//this needs to be the root
                System.out.print(root.person);
            }
            findInPreOrder(root.left, realPerson);
            findInPreOrder(root.right, realPerson);
        }
        return rootPerson;
    }
    public static Node findInPostOrder(Node root, String realPerson) {
        Node rootPerson = null;
        if (root != null) {
            findInPostOrder(root.left, realPerson);
            findInPostOrder(root.right, realPerson);
            if ((root.person.firstName + root.person.lastName).equals(realPerson)){
                rootPerson = root;//this needs to be the root
                System.out.print(root.person);
            }
        }
        return rootPerson;
    }
    public static void delete(String key) {
        root = deleteNode(root, key);
    }
    public static Node deleteNode(Node root, String realPerson) {
        Node rootPerson = null;
        if (root != null) {
            deleteNode(root.left, realPerson);
            if ((root.person.firstName + root.person.lastName).equals(realPerson)){
                rootPerson = root;//this needs to be the root
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }
                root.key = minValue(root.right);
                root.right = deleteNode(root.right, root.key);
            }
            deleteNode(root.right, realPerson);

        }
        return root;
    }
    private static String minValue(Node root){
        String minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    public static void modify(Node root, String realPerson) {
        Node rootPerson = null;
        if (root != null) {
            modify(root.left, realPerson);
            if ((root.person.firstName + root.person.lastName).equals(realPerson)) {
                rootPerson = root;//this needs to be the root
                modifyNode(root);
            }
            modify(root.right, realPerson);

        }
    }
    public static void modifyNode(Node root) {
        Scanner input = new Scanner(System.in);
        boolean is_Changing = true;
        while (is_Changing) {
            System.out.println("\n1.Modify the first name\n2.Modify the last name\n3.Modify the address\n4.Modify the city\n5.Modify the phone number\n6.Exit");
            String add = input.nextLine();
            is_Changing = false;
            switch (add) {
                case "1":// change first name
                    System.out.println("What is the new first name of the contact?");
                    root.person.firstName = input.nextLine();
                    break;
                case "2"://change last name
                    System.out.println("What is the new last name of the contact?");
                    root.person.lastName = input.nextLine();
                    break;
                case "3":// change address
                    System.out.println("What is the new address of the contact?");
                    root.person.address = input.nextLine();
                    break;
                case "4":// change city
                    System.out.println("What is the new city of the contact?");
                    root.person.city = input.nextLine();
                    break;
                case "5":// change phone number
                    System.out.println("What is the new phone number of the contact?");
                    root.person.phoneNumber = (input.nextLine());
                    break;
                case "6":// To exit
                    break;
                default:// if they get it wrong
                    System.out.println("oops that is not a choice!\n");
                    is_Changing = true;

            }
        }



    }


    static Object newContact() {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the first name of the new member?");
        String newFirstName = input.nextLine();
        System.out.println("What is the last name of the new member?");
        String newLastName = input.nextLine();
        System.out.println("What is the address of the new member?");
        String newAddress = input.nextLine();
        System.out.println("What is the city of the new member?");
        String newCity = input.nextLine();
        System.out.println("What is the state of the new member?");
        String newState = input.nextLine();
        System.out.println("What is the zip code of the new member?");
        String newZip = input.nextLine();
        System.out.println("What is the email of the new member?");
        String newEmail = input.nextLine();
        System.out.println("What is the phone number of the new member?");
        String newPhoneNumber = input.nextLine();


        return new Object(newFirstName, newLastName, newAddress, newCity, newState, newZip, newEmail,newPhoneNumber);
    }



}


class Object {

    String firstName;
    String lastName;
    String address;
    String phoneNumber;
    String city;
    String state;
    String zip;
    String email;


    Object(String firstName, String lastName, String address, String city, String state, String zip, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.state = state;
        this.zip = zip;
        this.email = email;
    }



    public String toString() {
        return firstName + ", " + lastName + ", "+address+ ", "+city+ ", "+state+", "+zip+", "+email+ ", "+phoneNumber;
    }


}
class Node{
    Object person;
    Node left;
    Node right;
    static String key;
    public Node(Object tempPerson) {
        person = tempPerson;
        left = null;
        right = null;
        key = person.firstName+person.lastName;

    }
}










