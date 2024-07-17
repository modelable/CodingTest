import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Col> stack = new Stack<>();
        Col root = new Col(0);
        Col prev = root;
        Col iter = root;
        for(int i=1; i<n; i++){
            Col col = new Col(i);
            prev.next = col;
            col.prev = prev;
            prev = col;
            if(i==k) iter = col;
        }
        for(String query : cmd){
            char key = query.charAt(0);
            switch(key){
                case 'U':
                    for (int up = Integer.valueOf(query.substring(2)); up > 0; up--) {
                        iter = iter.prev;
                    }        
                    break;
                
                case 'D':{
                    int x = Integer.valueOf(query.substring(2));
                    while((x--)>0){
                        iter = iter.next;
                    }
                    break;
                }
                case 'C':{
                    stack.push(iter);
                    iter = iter.delete();
                    break;
                }
                case 'Z':{
                    stack.pop().restore();
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append('O');
        }
        while(!stack.isEmpty()) {
            Col col = stack.pop();
            sb.setCharAt(col.value,'X');
        }
        return sb.toString();
    }
    class Col{
        Col prev=null;
        Col next=null;
        int value;
        Col(int index){
            this.value = index;
        }
        void restore(){
            if(this.prev!=null) this.prev.next = this;
            if(this.next!=null) this.next.prev = this;
        }
        Col delete(){
            Col next = this.next;
            Col prev = this.prev;
            if(prev!=null){
                prev.next = this.next;
            }
            if(next!=null){
                next.prev = this.prev;
                return this.next;
            }
            return this.prev;
        }
    }
}