import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class graph {
    private LinkedList<Integer> adjacency[];
    graph(int v)
    {
        adjacency = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            adjacency[i]=  new LinkedList<Integer>();
        }
    }
    public void insert_edge(int s,int d)
    {
        adjacency[s].add(d);
        adjacency[d].add(s);
    }
    public void bfs(int source)
    {
        boolean visited_nodes [] = new boolean[adjacency.length];
        int parent_nodes [] = new int [adjacency.length];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(source);
        visited_nodes[source] = true;
        parent_nodes[source] = -1;
        
        while(!q.isEmpty())
        {
            int p = q.poll();
            System.out.println(p);
            
            for(int i:adjacency[p])
            {
                if(visited_nodes[i]!=true)
                {
                    visited_nodes[i] = true;
                    q.add(i);
                    parent_nodes[i] = p;
                }
                
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices and edges :: ");
        int v = sc.nextInt();
        int e = sc.nextInt();
        graph g = new graph(v);
        System.out.println("Enter the edges :: ");
        for(int i= 0;i<e;i++)
        {
            int s = sc.nextInt();
            int d = sc.nextInt();
            g.insert_edge(s,d);
        }
        System.out.println("Enter the source for bfs traversal :: ");
        int source = sc.nextInt();
        g.bfs(source);
    }
}
