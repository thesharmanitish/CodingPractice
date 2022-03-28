package com.interview.google.stack;

import java.util.Deque;
import java.util.LinkedList;

public class DirectoryPath {
	public static  String simplifyPath(String A) {
        Deque<String> stack  = new LinkedList<>();
        String[] st = A.split("/");
        for(int i=1;i<st.length;i++){
            if(st[i].equals("..")){
                if(!stack.isEmpty()) 
                    stack.removeLast();
            }else if(!st[i].equals(".")){
                if(st[i]!="" && !st[i].isEmpty())
                    stack.add(st[i]);

            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append('/');
            sb.append(stack.pop());
        }
        
        return sb.length()==0?"/":sb.toString();
    }
	public static void main(String[] args) {
		simplifyPath("/./.././ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/./qbd/./../pir/dhu/./../../wrm/grm/ach/jsy/dic/ggz/smq/"
				+ "mhl/./../yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/./pzo/../llb/./tud/olc/zns/fiv/./eeu/fex/rhi/pnm/../../"
				+ "kke/./eng/bow/uvz/jmz/hwb/./././ids/dwj/aqu/erf/./koz/..");
	}
}
