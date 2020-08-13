class CombinationIterator {
    
    List<String> list;
    int indexOfReturned = 0;
    
    public CombinationIterator(String characters, int combinationLength) {
        list = new ArrayList<>();
        generatePerms(characters.toCharArray(), combinationLength, 0, new StringBuffer());
        Collections.sort(list);
    }
    
    public String next() {
        return (list.get(indexOfReturned++));
    }
    
    public boolean hasNext() {
        if(list.size() == indexOfReturned)
            return false;
        return true;
    }
    
    private void generatePerms(char[] arr, int lengthRequired, int currIndexAdded, StringBuffer sb)
    {
        if(sb.length() == lengthRequired)
        {
            System.out.println("HERE");
            list.add(sb.toString());
            return;
        }
        
        for(int i = currIndexAdded; i < arr.length; i++)
        {
            sb.append(arr[i]);
            generatePerms(arr, lengthRequired, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */