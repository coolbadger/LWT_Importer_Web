package com.LWT.Details;

import java.util.List;

/**
 * Created by ThinkPad on 2017-04-25.
 */
public class TreeMapDetail {

    private String root;//父id
    private TreeDetail treeDetail;//父节点对象
    private List<TreeDetail> brotherList;//兄弟节点列表
    private List<TreeDetail> sonList;//子节点列表

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public TreeDetail getTreeDetail() {
        return treeDetail;
    }

    public void setTreeDetail(TreeDetail treeDetail) {
        this.treeDetail = treeDetail;
    }

    public List<TreeDetail> getBrotherList() {
        return brotherList;
    }

    public void setBrotherList(List<TreeDetail> brotherList) {
        this.brotherList = brotherList;
    }

    public List<TreeDetail> getSonList() {
        return sonList;
    }

    public void setSonList(List<TreeDetail> sonList) {
        this.sonList = sonList;
    }
}
