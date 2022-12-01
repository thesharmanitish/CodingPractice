package com.interview.hybrid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/accounts-merge/description/
 * 
 * 
 * 721. Accounts Merge Medium 5K 872 company Amazon company Uber company
 * Facebook
 * 
 * Given a list of accounts where each element accounts[i] is a list of strings,
 * where the first element accounts[i][0] is a name, and the rest of the
 * elements are emails representing emails of the account.
 * 
 * Now, we would like to merge these accounts. Two accounts definitely belong to
 * the same person if there is some common email to both accounts. Note that
 * even if two accounts have the same name, they may belong to different people
 * as people could have the same name. A person can have any number of accounts
 * initially, but all of their accounts definitely have the same name.
 * 
 * After merging the accounts, return the accounts in the following format: the
 * first element of each account is the name, and the rest of the elements are
 * emails in sorted order. The accounts themselves can be returned in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: accounts =
 * [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Output:
 * [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Explanation: The first and second John's are the same person as they have the
 * common email "johnsmith@mail.com". The third John and Mary are different
 * people as none of their email addresses are used by other accounts. We could
 * return these lists in any order, for example the answer [['Mary',
 * 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], ['John',
 * 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would
 * still be accepted.
 * 
 * Example 2:
 * 
 * Input: accounts =
 * [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 * Output:
 * [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 * 
 * @author nisharma
 *
 */
class AccoutnMerge {
	int[] root;
	int[] rank;

	// The find function here is the same as that in the disjoint set with path
	// compression.
	public int find(int x) {
		while (root[x] != x) {
			root[x] = root[root[x]];
			x = root[x];
		}
		return root[x];
	}

	// The union function with union by rank
	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			if (rank[rootX] > rank[rootY]) {
				root[rootY] = rootX;
			} else if (rank[rootX] < rank[rootY]) {
				root[rootX] = rootY;
			} else {
				root[rootY] = rootX;
				rank[rootX] += 1;
			}
		}
	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		root = new int[accounts.size()];
		rank = new int[accounts.size()];

		for (int i = 0; i < root.length; i++) {
			root[i] = i;
			rank[i] = 1;
		}
		Map<String, Integer> map = new HashMap<>();
		int i = 0;
		for (List<String> account : accounts) {
			for (int j = 1; j < account.size(); j++) {
				String email = account.get(j);
				if (!map.containsKey(email))
					map.put(email, i);
				else {
					union(map.get(email), i);
				}
			}
			i++;
		}
		List<List<String>> result = new ArrayList<>();

		Map<Integer, List<String>> resultMap = new HashMap<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			resultMap.computeIfAbsent(find(entry.getValue()), ArrayList::new).add(entry.getKey());
		}

		for (Map.Entry<Integer, List<String>> entry : resultMap.entrySet()) {
			List<String> ll = new ArrayList<>();

			ll.addAll(entry.getValue());
			Collections.sort(ll);
			ll.add(0, accounts.get(entry.getKey()).get(0));
			result.add(ll);
		}
		return result;

	}
}