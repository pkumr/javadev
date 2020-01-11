class _71_SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        Set<String> skip = new HashSet<>();
        skip.add(".."); //-- (..) --> this makes to go one directory up
        skip.add("."); // (.) --> this will let user remain in current directory
        skip.add(""); // () --> no space to handle scenarios // or /a types
                    // because path.split will generated like
                    // // -> (blank) <-> blanks
                    // /a/ -> (blank) <-> a
        
        for(String directory : path.split("/")){
            //if (..) then we have to move one level up, so remove
            // directory from the stack
            if(directory.equals("..") && !stack.isEmpty()){
                stack.pop();
            }
            //Else if we don't have directory then add in stack.
            //we will add only those result from path.split,
            //that are not there in HashSet. i.e( don't add "",".", "..")
            else if (!skip.contains(directory)){
                stack.push(directory);
            }
        }
        String result = "";
        StringBuilder sb = new StringBuilder();
        for(String s : stack){
            sb.append("/").append(s);
        }

        result = sb.toString();
        return result.isEmpty() ? "/" : result;
        
    }
}