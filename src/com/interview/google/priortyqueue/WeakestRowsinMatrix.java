package com.interview.google.priortyqueue;

import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/submissions/
 * 
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and
 * 0's (representing civilians). The soldiers are positioned in front of the
 * civilians. That is, all the 1's will appear to the left of all the 0's in
 * each row.
 * 
 * A row i is weaker than a row j if one of the following is true:
 * 
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * 
 * @author nisharma
 *
 */
public class WeakestRowsinMatrix {

	class Pair {
		int count;
		int row;

		public Pair() {
		}

		public Pair(int count, int row) {
			this.count = count;
			this.row = row;
		}

	}

	public int[] kWeakestRows(int[][] mat, int k) {

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((o1, o2) -> {
			return o1.count == o2.count ? o1.row - o2.row : o1.count - o2.count;
		});

		for (int i = 0; i < mat.length; i++) {
			int count = 0;
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 1)
					count++;
			}
			pq.offer(new Pair(count, i));
		}
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = pq.poll().row;
		}
		
//		ObjectMapper mapper = new ObjectMapper();
//		Map obj = mapper.readValue(data.toString(), Rec.class);

		/*
		 * List<Object> recs = (List<Object>) obj.get("data"); Object[] data = recs
		 * .stream() .filter(student ->
		 * ((Map)student).get("City").equals("Delhi")).filter(s->s.get(timestamp).)
		 * .toArray(); Date d = new Date(); // d.getMonth() - d.getYear()
		 */		return res;
	}
}


class Rec{
    long id;
    long userId;
    String userName;
    Date timestamp;
    String txnType;
    double amount;
    String location;
    String ip;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Rec(long id, long userId, String userName, Date timestamp, String txnType, double amount, String location,
			String ip) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.timestamp = timestamp;
		this.txnType = txnType;
		this.amount = amount;
		this.location = location;
		this.ip = ip;
	}
    
    

}