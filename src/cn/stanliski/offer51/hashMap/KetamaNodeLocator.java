package cn.stanliski.offer51.hashMap;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


public final class KetamaNodeLocator {
	
	private TreeMap<Long, Node> ketamaNodes;
	private HashAlgorithm hashAlg;
	private int numReps = 160;
	
    public KetamaNodeLocator(List<Node> nodes, HashAlgorithm alg, int nodeCopies) {
		hashAlg = alg;
		ketamaNodes=new TreeMap<Long, Node>();
		
        numReps= nodeCopies;
        
		for (Node node : nodes) {
			for (int i = 0; i < numReps / 4; i++) {
				byte[] digest = hashAlg.computeMd5(node.getName() + i);
				for(int h = 0; h < 4; h++) {
					long m = hashAlg.hash(digest, h);
					ketamaNodes.put(m, node);
				}
			}
		}
    }

	public Node getPrimary(final String k) {
		byte[] digest = hashAlg.computeMd5(k);
		Node rv=getNodeForKey(hashAlg.hash(digest, 0));
		return rv;
	}
	
	Node getNodeForKey(long hash) {
		final Node rv;
		Long key = hash;
		if(!ketamaNodes.containsKey(key)) {
			// 在环上顺时针查找，如果找到某个节点，就返回那个节点;如果没有找到，则取整个环的第一个节点。 
			SortedMap<Long, Node> tailMap=ketamaNodes.tailMap(key);
			if(tailMap.isEmpty()) {
				// 没有找到符合条件的节点，则取整个环的第一个节点。
				key=ketamaNodes.firstKey();
			} else {
				// 大于当前key的那个子Map，然后从中取出第一个key，就是大于且离它最近的那个key 
				key=tailMap.firstKey();
			}
			//For JDK1.6 version
//			key = ketamaNodes.ceilingKey(key);
//			if (key == null) {
//				key = ketamaNodes.firstKey();
//			}
		}
		
		
		rv=ketamaNodes.get(key);
		return rv;
	}
}
