/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parttwo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Message {
    
    ArrayList<String> messageIds = new ArrayList<>();
    ArrayList<String> recipientNumber = new ArrayList<>();
    ArrayList<String> messages = new ArrayList<>();
    ArrayList<String> msgHash = new ArrayList<>();
    ArrayList<String> messageStatus = new ArrayList<>();
    
    Scanner input = new Scanner("System.in");
    Random random = new Random();
    
    int numMessageSent = 0;
    
    public void sendingMessage(){
        
        System.out.println("How many messages do you want to send");
        int numberOfMessage = input.nextInt();
        
        input.nextLine();
        for(int i = 1; i <= numberOfMessage; i++){
            
            System.out.println("MESSAGE:" + i);
            
            String messageID = generateMessageID();
            
            System.out.println("Enter recipient cell number!!");
            String recipient = input.nextLine();
            
            String recipientResult = checkRecipientCell(recipient);
            
            if(recipientResult.equals("Valid number")){
                System.out.println(recipientResult);
                i = 1 - 1;
                continue;
            }
            
            recipientNumber.add(recipient);
            
            System.out.println("Enter you message!!");
            String messageText = input.nextLine();
            
            if(messageText.length() > 250 || messageText.trim().isEmpty()){
                
            System.out.println("Your massage length should be between 1 to 250");
            i--;
            continue;
            
            }
            
            messages.add(messageText);
            
            String messageHash = createMessageHash(messageID, messages.size(), messageText);
            
            msgHash.add(messageHash);
            
            String status = SentMessage();
            
            messageStatus.add(status);
            
            if(status.equals("Sent")){
                numMessageSent++;
            }
        }
        
        PrintMessages();
        
    }
    
    public String generateMessageID(){
        
         String messageID;
      
         do{
             long number = 10000000000L + random.nextLong(90000000000L);
             
             messageID = String.valueOf(number);
             
         }while(messageIds.contains(messageID));
         
         messageIds.add(messageID);
         
         return messageID;
    }
    public String checkRecipientCell(String cellphone){
        if (cellphone.matches(".*\\+27[0-9]{9}")
                || cellphone.matches(".*^0[0-9]{9}")){
            
            return "Valid number";
            
        }else
            
            return "Invalid number";
    } 
    
    public String createMessageHash(String messageID, int messageNumber, String messageText){
        
        String firstTwoNumbers = messageID.substring(0, 2);
        
        String trimmedMessage = messageText.trim();
        String[] words = trimmedMessage.split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
        String hash = firstTwoNumbers
                + ":"
                +messageNumber
                + ":"
                + firstWord
                + lastWord;
        
        return hash.toUpperCase();
    }
    
    public String SentMessage(){
        
       System.out.println("\nChoose what you want to do with this message!");
       
       System.out.println("1. Send Message");
       System.out.println("2. Disregard Message");
       System.out.println("3. Store Message to senf later");
       
       System.out.println("Enter your choice:");
       int choice = input.nextInt();
       
       switch(choice){
           
           case 1 -> {
               System.out.println("Message successfully sent");
               return "Send";
           }
           
           case 2 -> {
               System.out.println("Press 0 to delete the message");
               int deleteChoice = input.nextInt();
               
               input.nextLine();
               
               if(deleteChoice == 0){
                   System.out.println("Message deletec");
                   
                   int lastIndex = messages.size() - 1;
                   
                   messageIds.remove(lastIndex);
                   recipientNumber.remove(lastIndex);
                   messages.remove(lastIndex);
                   msgHash.remove(lastIndex);
                   
                   return "Disregarded";
               }else{
                   System.out.println("Invalid option!");
                   return "Disregarded";
                }
           }
           
           case 3 -> {
               System.out.println("Message succesfully stored");
               return "Stored";
               
           }
           
           default -> {
               System.out.println("Invalid option");
               return "Disregarded";
           }
        }
     } 
    
    public String PrintMessages(){
        
        StringBuilder allMessages = new  StringBuilder();
      System.out.println("n===== All Messages =====");
       
        for(int i = 0; i < messages.size(); i++){
            allMessages.append("\nMessage Number: ").append(i + 1);
            allMessages.append("\nMessage ID: ").append(messageIds.get(i));
            allMessages.append("\nRecipient: ").append(recipientNumber.get(i));
            allMessages.append("\nMessage: ").append(messages.get(i));
            allMessages.append("\nMessage Hash: ").append(msgHash.get(i));
            allMessages.append("\nStatus: ").append(messageStatus.get(i));
           
            System.out.println("\n===========================");
           
            System.out.println("\nMessage Number: "+ (i + 1));
            System.out.println("Message ID: " + messageIds.get(i));
            System.out.println("Recipient: " + recipientNumber.get(i));
            System.out.println("Message: " + messages.get(i));
            System.out.println("Message Hash: " + messageStatus.get(i));
            System.out.println("Status: " + messageStatus.get(i));
           
        }
       
        return allMessages.toString();  
    }
}//end of class message
