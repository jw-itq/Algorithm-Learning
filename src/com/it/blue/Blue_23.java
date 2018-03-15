package com.it.blue;

import java.util.Scanner;
import java.util.Stack;

/**
 * ��Ȩ����ͼ������ͼ�Ĺ����Լ�ʵ����ͼ��BFS������DFS����
 * 1>.ʹ�ö���Queueʵ��ͼ��BFS����
 * 2>.�ݹ�ʵ��ͼ��DFS����
 * 3>.ʹ��ջStack����ʵ��ͼ��DFS����
 * @author Administrator
 */
public class Blue_23 {
	int time = 0;
	Stack<Vertex1> stackVertex = new Stack<Vertex1>();
	
	public static void main(String[] args) {
		Graph1 graph = new Graph1();
		Blue_23 createGraph = new Blue_23();
		createGraph.initialGraph(graph);
		createGraph.outputGraph(graph);
		System.out.println("DFS����·��Ϊ���ݹ�ʵ�֣�");
		createGraph.DFS(graph);
	}
	
	/**
	 * �����û������string���͵Ķ��㷵�ظö���
	 * @param graph ͼ
	 * @param str ��������
	 * @return ����һ������
	 */
	public Vertex1 getVertex(Graph1 graph,String str){
		for(int i = 0;i<graph.verNum;i++){
			if(graph.vertexArray[i].verName.equals(str)){
				return graph.vertexArray[i];
			}
		}
		return null;
	}
	
	/**
	 * �����û���������ݳ�ʼ��һ��ͼ�����ڽӱ����ʽ����
	 * @param graph ���ɵ�ͼ
	 */
	public void initialGraph(Graph1 graph){

		Scanner scan = new Scanner(System.in);
		System.out.println("�����붥�����ͱ���");
		graph.verNum=scan.nextInt();
		graph.edgeNum=scan.nextInt();
		
		System.out.println("���������붥������");
		for(int i = 0;i<graph.verNum;i++){
			Vertex1 vertex = new Vertex1();
			String name = scan.next();
			vertex.verName= name;
			vertex.color = "white";
			vertex.discoverTime=0;
			vertex.finishTime=0;
			vertex.nextNode=null;
			graph.vertexArray[i]=vertex;
		}
		
		System.out.println("����������ͼ�ı�");
		for(int i = 0;i<graph.edgeNum;i++){
			String preV = scan.next();
			String folV = scan.next();
			
			Vertex1 v1 =getVertex(graph, preV);
			if(v1 == null){
				System.out.println("������ߴ���ͼ��û�еĶ���!");
			}
			Vertex1 v2 = new Vertex1();
			v2.verName = folV;
			v2.nextNode = v1.nextNode;
			v1.nextNode = v2;
		}
	}
	
	/**
	 * ����ͼ����ӱ�
	 * @param graph �������ͼ
	 */
	public void outputGraph(Graph1 graph){
		System.out.println("���ͼ���ڽӱ�Ϊ��");
		for(int i = 0;i<graph.verNum;i++){
			Vertex1 vertex = graph.vertexArray[i];
			System.out.print(vertex.verName);
			
			Vertex1 current = vertex.nextNode;
			while(current!=null){
				System.out.print("-->"+current.verName);
				current = current.nextNode;
			}
			System.out.println();
		}
	}
	
	/**
	 * DFS�������������������ɫ�Ǹ����������ݶ��㷵�����±�
	 * @param vertex ����
	 * @param graph ͼ
	 * @return �����±�
	 */
	public int index(Vertex1 vertex,Graph1 graph){
		for(int i = 0;i<graph.verNum;i++){
			if(vertex.verName.equals(graph.vertexArray[i].verName)){
				return i ;
			}
		}
		return -1;
	}
	
	/**
	 * DFS������ȱ�����ʼ��
	 * @param graph ͼ
	 */
	public void DFS(Graph1 graph){
		for(int i = 0;i<graph.verNum;i++ ){
			if(graph.vertexArray[i].color.equals("white")){
				DfsVisit(graph.vertexArray[i], graph);
				System.out.println();
			}
		}
	}
	
	/**
	 * DFS�ݹ麯��
	 * @param vertex ����
	 * @param graph ͼ
	 */
	public void DfsVisit(Vertex1 vertex,Graph1 graph){
		vertex.color="gray";
		time = time+1;
		vertex.discoverTime=time;
		System.out.print(vertex.verName+"-->");
		
		Vertex1 current = vertex.nextNode;
		while(current!=null){
			Vertex1 currentNow = getVertex(graph, current.verName);
			if(currentNow.color.equals("white")){
				DfsVisit(currentNow, graph);
			}
			current = current.nextNode;
		}
		vertex.color = "black";
		time = time+1;
		vertex.finishTime=time;
	}
	
	/**
	 * Ѱ��һ���ڵ���ڽӵ����Ƿ��а�ɫ�ڵ�
	 * @param graph ����
	 * @param vertex ͼ
	 * @return ���ذ�ɫ�ڵ����null
	 */
	public Vertex1 getAdj(Graph1 graph,Vertex1 vertex){
		Vertex1 ver = getVertex(graph, vertex.verName);
		Vertex1 current = ver.nextNode;
		if(current==null){
			return null;
		}else{
			Vertex1 cur = getVertex(graph, current.verName);
			while(current!=null && cur.color.equals("gray")){
				current = current.nextNode;
			}
			if(cur.color.equals("white")){
				Vertex1 currentNow = getVertex(graph, current.verName);
				return currentNow;
			}else{
				return null;
			}
		}
	}
	
	/**
	 * ͨ��ջʵ��dfs����
	 * @param graph ͼ
	 * @param vertex ����
	 */
	public void stackOperator(Graph1 graph,Vertex1 vertex){
		vertex.color="gray";
		stackVertex.push(vertex);
		System.out.print(vertex.verName+"-->");
		
		while(!stackVertex.isEmpty()){
			Vertex1 ver = stackVertex.peek();
			Vertex1 current = getAdj(graph, ver);
			if(current!=null){
				stackVertex.push(current);
				current.color="gray";
				System.out.print(current.verName+"-->");
			}else{
				stackVertex.pop();
			}
		}
	}
	
	public void stackMain(Graph1 graph){
		for(int i = 0;i<graph.verNum;i++){
			if(graph.vertexArray[i].color.equals("white")){
				stackOperator(graph, graph.vertexArray[i]);
				System.out.println();
			}
		}
	}
}
class Vertex1{
	String verName;
	String color;
	int discoverTime;
	int finishTime;
	Vertex1 nextNode;
}
class Graph1{
	Vertex1[] vertexArray = new Vertex1[100];
	int verNum = 0;
	int edgeNum = 0;
}