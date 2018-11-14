public class CC {
boolean[] marked;
int[] id;
int[] size;
int count;
public CC(Graph g)
{
	marked= new boolean[g.V()+1];
	id=new int[g.V()+1];
	size=new int[g.V()+1];
	for(int v=1;v<=g.V();v++)
	{
		if(!marked[v])
		{
			//System.out.println(v);
			dfs(g,v);
			count++;
		//System.out.println(count);
		}
	}
}
void dfs(Graph g,int v)
{
	marked[v]=true;
	id[v]=count;
	//System.out.println(id[v]);
	for(int w:g.adj(v))
	{
		//System.out.println(w);
		if(!marked[w])
		{
			dfs(g,w);
		}
	}
}
public int id(int v) {
    validatevertex(v);
    return id[v];
}
public int count() {
    return count;
}
public int size(int v) {
    validatevertex(v);
    return size[id[v]];
}

boolean connected(int v,int w)
{
	//System.out.println(v+"cc"+w);
	validatevertex(v);
	validatevertex(w);
	return id[v]==id[w];
}
void validatevertex(int v)
{
	int V=marked.length;
	if(v<0||v>=V)
		throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
}
void display()
{
	//System.out.println(count);
	if(count==1)
	{
		System.out.println("true");
	}
	else
		System.out.println("false");
}
}