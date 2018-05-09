package ellinx.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able to see the 10 most recent tweets in
 * the user's news feed. Your design should support the following methods:
 * 
 * postTweet(userId, tweetId): Compose a new tweet. getNewsFeed(userId):
 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
 * the news feed must be posted by users who the user followed or by the user
 * herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee. Example:
 * 
 * Twitter twitter = new Twitter();
 * 
 * // User 1 posts a new tweet (id = 5). twitter.postTweet(1, 5);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * 
 * // User 1 follows user 2. twitter.follow(1, 2);
 * 
 * // User 2 posts a new tweet (id = 6). twitter.postTweet(2, 6);
 * 
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. //
 * Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * 
 * // User 1 unfollows user 2. twitter.unfollow(1, 2);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5], // since
 * user 1 is no longer following user 2. twitter.getNewsFeed(1);
 * 
 * @author Ellinx
 *
 */

class Twitter {
	private List<int[]> m_tweetList;
	private Map<Integer, Set<Integer>> m_userMap;
    /** Initialize your data structure here. */
    public Twitter() {
        m_tweetList = new ArrayList<int[]>();
        m_userMap = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        int[] userTweet = {userId, tweetId};
        m_tweetList.add(userTweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        for (int i=m_tweetList.size()-1;i>=0;i--) {
        	if (m_tweetList.get(i)[0]==userId) {
        		res.add(m_tweetList.get(i)[1]);
        	} else {
        		if (m_userMap.containsKey(userId)) {
            		if (m_userMap.get(userId).contains(m_tweetList.get(i)[0])) {
                		res.add(m_tweetList.get(i)[1]);
                	}
            	}
        	}
        	if (res.size()==10) break;
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (m_userMap.containsKey(followerId)) {
        	m_userMap.get(followerId).add(followeeId);
        } else {
        	Set<Integer> followSet = new HashSet<Integer>();
        	followSet.add(followeeId);
        	m_userMap.put(followerId, followSet);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if (m_userMap.containsKey(followerId)) {
        	m_userMap.get(followerId).remove(followeeId);
        }
    }
    
    public static void main(String[] args) {
    	Twitter obj = new Twitter();
    	obj.postTweet(1,1);
    	List<Integer> param_2 = obj.getNewsFeed(1);
    	obj.follow(1,2);
    	obj.unfollow(1,2);
	}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */


