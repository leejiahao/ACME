package com.moriah.acme.ws.rs;

import java.util.List;
import java.util.ArrayList;

//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class TreeNode {
	private String id;
	private String text;
	private String state;
	
	private List<TreeNode> children = new ArrayList<TreeNode>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public void addChild(TreeNode treeNode) {
		children.add(treeNode);
	}
	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
}
