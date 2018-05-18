package per.owisho.learn.test;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTest {

	
	/**
	 * 获取树的下一级所有节点
	 * @param list
	 * @return
	 */
	private List<BinaryTreeNode> getNextLevelNodes(List<BinaryTreeNode> list){
		if(list==null||list.isEmpty())
			return null;
		List<BinaryTreeNode> result = new ArrayList<>();
		for(BinaryTreeNode node:list) {
			List<BinaryTreeNode> childs = node.childs();
			if(childs!=null&&!childs.isEmpty()) {
				result.addAll(childs);
			}
		}
		if(result.isEmpty()) {
			return null;
		}else {
			return result;
		}
	}
	
}

class BinaryTreeNode{
	
	private BinaryTreeNode leftTreeNode;
	
	private BinaryTreeNode rightTreeNode;
	
	public BinaryTreeNode(BinaryTreeNode leftTreeNode,BinaryTreeNode rightTreeNode) {
		this.leftTreeNode = leftTreeNode;
		this.rightTreeNode = rightTreeNode;
	}

	public List<BinaryTreeNode> childs(){
		List<BinaryTreeNode> list = new ArrayList<>();
		if(leftTreeNode!=null) {
			list.add(leftTreeNode);
		}
		if(rightTreeNode!=null) {
			list.add(rightTreeNode);
		}
		if(list.isEmpty()) {
			return null;
		}else {
			return list;
		}
	}
	
	public BinaryTreeNode getLeftTreeNode() {
		return leftTreeNode;
	}

	public void setLeftTreeNode(BinaryTreeNode leftTreeNode) {
		this.leftTreeNode = leftTreeNode;
	}

	public BinaryTreeNode getRightTreeNode() {
		return rightTreeNode;
	}

	public void setRightTreeNode(BinaryTreeNode rightTreeNode) {
		this.rightTreeNode = rightTreeNode;
	}

}