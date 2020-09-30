class Solution {
    
    class Node {
        String key;
        double value;
        
        Node(String k, double v) {
            key = k;
            value = v;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = buildGraph(equations, values);
        double[] answer = new double[queries.size()];
        
        for(int i = 0; i < queries.size(); i++) {
            answer[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }
        return answer;
    }
    
    private double dfs(String src, String dest, Set<Node> visited, Map<String, List<Node>> graph) {
        
        if(!(graph.containsKey(src) && graph.containsKey(dest))) {
            return -1.0;
        }
        
        
        if(src.equals(dest)) {
            return 1.0;
        }
        
        for(Node node: graph.get(src)) {
            if(!visited.contains(node)) {
                visited.add(node);
                double res = dfs(node.key, dest, visited, graph);
                if(res != -1.0) {
                    return res * node.value;
                }
            }
        }
        
        return -1.0;
        
    }
    
    private Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {
        
        Map<String, List<Node>> graph = new HashMap<>();
        
        for(int i = 0; i < equations.size(); i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            List<Node> temp1 = graph.getOrDefault(src, new ArrayList<>());
            List<Node> temp2 = graph.getOrDefault(dest, new ArrayList<>());
            temp1.add(new Node(dest, values[i]));
            temp2.add(new Node(src, 1 / values[i]));
                      
            graph.put(src, temp1);
            graph.put(dest, temp2);
        }
        
        return graph;
        
    }
    
}