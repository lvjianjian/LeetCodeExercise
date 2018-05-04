import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by zhongjianlv on 18-1-18.
 * <p>
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */
public class Simplify_Path_71 {

    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        String[] paths = path.split("/");
        for(int i = 1;i < paths.length; ++i){
            String p = paths[i];
            if(p.equals(".") || p.trim().equals("")) continue;
            else if(p.equals("..")) {
                if(!stack.isEmpty()) stack.removeLast();
            }
            else stack.add(p);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stack.size();++i){
            sb.append("/");
            sb.append(stack.get(i));
        }
        if(sb.length() == 0) return "/";
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        String x = "/a/./b/../../c/";
        System.out.println(Arrays.toString(x.split("/")));
        System.out.println(x.split("/").length);
    }
}
