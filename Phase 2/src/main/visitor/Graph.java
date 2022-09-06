package main.visitor;

import java.util.HashMap;
import java.util.Map;

class Graph {

    private Map<String, String> map = new HashMap<>();
    private Map<String, Integer> visited = new HashMap<>();
    private Map<String, Integer> lines = new HashMap<>();

    public void addEdge(String source, String destination) {

        if (!map.containsKey(source))
            map.put(source, destination);
    }

    public void set_line(String className, Integer line) {
        if(!lines.containsKey(className))
            lines.put(className, line);

    }

    public void init_visited(String start) {
        for (String key : map.keySet()) {
            visited.put(key, 0);
        }
        visited.replace(start, 1);
    }


    public boolean print_inheritance() {

        Boolean cycle = Boolean.FALSE;
        for (String key : map.keySet()) {
            init_visited(key);
            String cur_par = map.get(key);
            while (map.containsKey(cur_par)) {
                visited.replace(cur_par, visited.get(cur_par) + 1);
                if (visited.get(key) == 2) {
                    System.out.println("Line:" + lines.get(key) + ":" + "Class " + key + " is in an inheritance cycle");
                    cycle = Boolean.TRUE;
                    break;
                }
                if (visited.get(cur_par) == 2)
                    break;
                cur_par = map.get(cur_par);

            }
        }
        return cycle;

    }
}