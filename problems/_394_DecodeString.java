import java.util.Stack;
public class _394_DecodeString{
	public String decodeString(String s){
		Stack<Integer> counts = new Stack<>();
		Stack<String> result = new Stack<>();
		int index = 0;
		String res = "";

		while(index < s.length()){
			if(Character.isDigit(s.charAt(index))){
				int count = 0;
				while(Character.isDigit(s.charAt(index))){
					count = count * 10 + s.charAt(index) - '0';
					index++;
				}
				counts.push(count);
			}else if (s.charAt(index) == '['){
				result.push(res);
				res = "";
				index++;
			}else if (s.charAt(index) == ']'){
				int count = counts.pop();
				StringBuilder sb = new StringBuilder(result.pop());
				for(int i = 0; i < count; i++){
					sb.append(res);
				}
				res = sb.toString();
				index++;
			}else{
				res += s.charAt(index);
				index++;
			}
		}
		return res;
	}
}