/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_8.analytics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lab_8.entities.Comment;
import lab_8.entities.Post;
import lab_8.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {
    
    
    public void userWithMostLikes(){
        Map<Integer,Integer> userLikecount = new HashMap<Integer,Integer>();
        Map<Integer,User> users = DataStore.getInstance().getUsers();
        
        for(User user : users.values()){
            for(Comment c : user.getComments()){
                int likes = 0;
                if(userLikecount.containsKey(user.getId()))
                    likes = userLikecount.get(user.getId());
                likes += c.getLikes();
                userLikecount.put(user.getId(), likes);
            }
        }
        
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(userLikecount.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        
        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        System.out.println("User with most likes");
        System.out.println(sortedMap);
        System.out.println(sortedMap.values().toArray()[0]+"\n");
        System.out.println(sortedMap.keySet().toArray()[0]);


    }
    
    public void getFiveMostLikedComment(){
        
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        
        Collections.sort(commentList, new Comparator<Comment>(){
        
            @Override
            public int compare(Comment o1, Comment o2){
               return o2.getLikes() - o1.getLikes();

            }
        });
        
        System.out.println("5 most liked comments : ");
        for(int i = 0;i < commentList.size() && i<5; i++){
            System.out.println(commentList.get(i));
        }
        
        System.out.println("\n");
    }
    
    public void getMostLikedComment(){
        
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        
        Collections.sort(commentList, new Comparator<Comment>(){
        
            @Override
            public int compare(Comment o1, Comment o2){
               return o2.getLikes() - o1.getLikes();

            }
        });
        
        System.out.println("Most liked comments : ");
        for(int i = 0;i < commentList.size() && i<1; i++){
            System.out.println(commentList.get(i)+"\n");
        }
    }
    
    public void getMostComments(){
        
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        
        Collections.sort(commentList, new Comparator<Comment>(){
        
            @Override
            public int compare(Comment o1, Comment o2){
               return o2.getPostId()- o1.getPostId();

            }
        });
        
        System.out.println("Most Posted comments : ");
        for(int i = 0;i < commentList.size() && i<1; i++){
            System.out.println(commentList.get(i)+"\n");
        }
    }
    
    public void getAverageLikesComments(){
        
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        
//        Collections.sort(commentList, new Comparator<Comment>(){
//        
//            @Override
//            public int compare(Comment o1, Comment o2){
//               return o2.getPostId()- o1.getPostId();
//
//            }
//        });
        
        System.out.println("\nAverage likes per comment : ");
        for(int i = 0;i < commentList.size(); i++){
            if(comments.get(i).getPostId()!=0){
                //int avg = comments.get(i).getLikes() / comments.get(i).getPostId() ;
                System.out.println(commentList.get(i)+" Average likes :"+ comments.get(i).getLikes() / comments.get(i).getPostId());
            }
            else {
                System.out.println(commentList.get(i)+" Average likes cannot be calculated");
            }
            
        }
    }
    
    public void getFiveInactiveUsersOnPosts(){
        
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        
        Collections.sort(commentList, new Comparator<Comment>(){
        
            @Override
            public int compare(Comment o1, Comment o2){
               return o1.getPostId()- o2.getPostId();

            }
        });
        
        System.out.println("Inactive user based on posts : ");
        for(int i = 0;i < commentList.size() && i<10; i++){
            System.out.println(commentList.get(i));
        }

    }
    
    public void getFiveInactiveUsersOnComments(){
        
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        
        Collections.sort(commentList, new Comparator<Comment>(){
        
            @Override
            public int compare(Comment o1, Comment o2){
               return o1.getId()- o2.getId();

            }
        });
        
        System.out.println("Inactive user based on comments : ");
        for(int i = 0;i < commentList.size() && i<10; i++){
            System.out.println(commentList.get(i));
        }

    
    }
    
    public void getFiveInactiveUsersOverall(){
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        Map<Integer,Integer> posts = new HashMap<Integer, Integer>();
        
        for(int i = 0;i < commentList.size(); i++){
            Integer count = posts.get(comments.get(i).getPostId());
            if(count == null){
                posts.put(commentList.get(i).getPostId(), 1);        
           }
            else{
                posts.put(commentList.get(i).getPostId(), count+1);                       
            }
        }
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(posts.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        
        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        System.out.println("Inactive User Overall :");
        System.out.println(sortedMap);
        //for(int i = 0; i<sortedMap.size() && i<5; i++){
        //System.out.println(sortedMap.get(i));       
    } 
    
    public void getProactiveUsersOverall(){
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        Map<Integer,Integer> posts = new HashMap<Integer, Integer>();
        
        for(int i = 0;i < commentList.size(); i++){
            Integer count = posts.get(comments.get(i).getPostId());
            if(count == null){
                posts.put(commentList.get(i).getPostId(), 1);        
           }
            else{
                posts.put(commentList.get(i).getPostId(), count+1);                       
            }
        }
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(posts.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        
        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        System.out.println("Proactive User Overall :");
        System.out.println(sortedMap);
        //for(int i = 0; i<sortedMap.size() && i<5; i++){
        //System.out.println(sortedMap.get(i));       
    } 
}
