package it.polito.tdp.genes.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.genes.db.GenesDao;




public class Model {
	
	
	private Graph<String,DefaultWeightedEdge> grafo;
		
	Map<String,String> idMap;
	GenesDao dao;
	
	double migliore = 0.0;
	double peggiore = 0.0;
	
	public Model() {
		this.idMap= new HashMap<>();
		this.dao = new GenesDao();
	}
	
	public void creaGrafo() {
		
		
		
		idMap.clear();
		for(String s : dao.getVertici()) {
			idMap.put(s,s);
		}
		
		
		this.grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(grafo, this.dao.getVertici());
		
		for (Adiacenza a : dao.getAdiacenze()) {
			
			if(idMap.containsKey(a.cromo1) && idMap.containsKey(a.cromo2)) {
			
				
				Graphs.addEdgeWithVertices(this.grafo, a.cromo1, a.cromo2, a.peso);
				
			if( a.peso > migliore) {
				migliore = a.peso;
			}
			if( a.peso < peggiore) {
				peggiore = a.peso;
			}
			}
			
		}
		
	
		
		
		
		
		
}
	
	public double getMigliore() {
		return migliore;
		
	}
	
	public double getPeggiore() {
		return peggiore;
	}
	public int getArchi() {
		return this.grafo.edgeSet().size();
	}
	public int getVertici() {
		return this.grafo.vertexSet().size();
	}

	public String getSoglia(Integer soglia) {
	
		int minore = 0;
		int maggiore = 0;
		String sol = "";
		
		for(Adiacenza a : dao.getAdiacenze()) {
			if(idMap.containsKey(a.cromo1) && idMap.containsKey(a.cromo2)) {
				
				if(a.peso > soglia) {
					maggiore = 1 + maggiore;
				}
				if (a.peso < soglia) {
					minore = 1 + minore;
				}
			}
			
			
		}
		
		sol = "maggiori: " + maggiore + "   minori: "+ minore ;
		
		return sol;
		
		
		// TODO Auto-generated method stub
		
	}	
}