package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given a list accounts, each element accounts[i] is a list of strings, where
 * the first element accounts[i][0] is a name, and the rest of the elements are
 * emails representing emails of the account.
 * 
 * Now, we would like to merge these accounts. Two accounts definitely belong to
 * the same person if there is some email that is common to both accounts. Note
 * that even if two accounts have the same name, they may belong to different
 * people as people could have the same name. A person can have any number of
 * accounts initially, but all of their accounts definitely have the same name.
 * 
 * After merging the accounts, return the accounts in the following format: the
 * first element of each account is the name, and the rest of the elements are
 * emails in sorted order. The accounts themselves can be returned in any order.
 * 
 * Example 1: 
 * 
 * Input: accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], 
 * ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", 
 * "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com',
 * 'johnsmith@mail.com'], ["John", "johnnybravo@mail.com"], ["Mary",
 * "mary@mail.com"]] 
 * 
 * Explanation: The first and third John's are the same person
 * as they have the common email "johnsmith@mail.com". The second John and Mary
 * are different people as none of their email addresses are used by other
 * accounts. 
 * 
 * We could return these lists in any order, for example the answer
 * [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], ['John',
 * 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would
 * still be accepted. 
 * 
 * Note:
 * The length of accounts will be in the range [1, 1000]. 
 * The length of accounts[i] will be in the range [1, 10]. 
 * The length of accounts[i][j] will be in the range [1, 30].
 * 
 * @author Ellinx
 *
 */
public class AccountsMerge {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<Integer>> nameMap = new HashMap<>();
        //put same name together
        for (int i=0;i<accounts.size();i++) {
            if (!nameMap.containsKey(accounts.get(i).get(0)))
                nameMap.put(accounts.get(i).get(0), new HashSet<Integer>());
            nameMap.get(accounts.get(i).get(0)).add(i);  
        }
        List<List<String>> ret = new ArrayList<>();
        //process emails with same name
        for (String name:nameMap.keySet()) {
            //union&find
            Map<String,String> roots = new HashMap<>();
            for (int index:nameMap.get(name)) {
                String indexStr = Integer.toString(index);
                roots.put(indexStr, indexStr);
                for (int i=1;i<accounts.get(index).size();i++) {
                    if (!roots.containsKey(accounts.get(index).get(i)))
                        roots.put(accounts.get(index).get(i), indexStr);
                    else {
                        String preRoot = findRoot(roots, accounts.get(index).get(i));
                        roots.put(preRoot, indexStr);
                    }
                }
            }
            //organize emails based on their roots
            Map<String,Set<String>> temp = new HashMap<>();
            for (int index:nameMap.get(name)) {
                for (int i=1;i<accounts.get(index).size();i++) {
                    String email = accounts.get(index).get(i);
                    String k = findRoot(roots, email);
                    if (!temp.containsKey(k))
                        temp.put(k, new HashSet<String>());
                    temp.get(k).add(email);
                }
            }
            for (Set<String> emails:temp.values()) {
                List<String> nameEmails = new ArrayList<>();
                nameEmails.add(name);
                List<String> emailsList = new ArrayList<>(emails);
                Collections.sort(emailsList);
                nameEmails.addAll(emailsList);
                ret.add(nameEmails);
            }
        }
        return ret;
    }
    
    private String findRoot(Map<String,String> roots, String node) {
        while (!node.equals(roots.get(node)))
            node = roots.get(node);
        return node;
    }
}
