package com.zhang.learn.chapter2023.chapter08.chapter0822;

import java.util.*;

/**
 * 5
 * 4            6
 * 1    2
 *
 * @author zhangjiwei1
 * @description
 * @create 2023-08-22 12:14
 */
public class BinaryNodeDemo {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node5.left = node4;
        node5.right = node6;
        node4.left = node1;
        node4.right = node2;
        TreeNodeUtil util = new TreeNodeUtil(node5);
//        List<Integer> preLists = util.preOrder(node5);
//        System.out.println("前序遍历:" + preLists);//5,4,1,2,6
//        List<Integer> infixLists = util.infixOrder(node5);
//        System.out.println("中序遍历:" + infixLists);// 1,4,2,5,6
//        List<Integer> postLists = util.postOrder(node5);
//        System.out.println("后序遍历:" + postLists); // 1,2,4,6,5
//        List<List<Integer>> lists = util.levelOrder(node5);
//        System.out.println(lists);
//        System.out.println("------bfs--------");
//        util.bfs(node5);
//        System.out.println(util.levelOrderList);
//        System.out.println("-------右视图---------");
//        List<Integer> list = util.rightSideView(node5);
//        System.out.println(list);
//        System.out.println("------层级平均值--------");
//        List<Double> doubles = util.averageOfLevel(node5);
//        System.out.println(doubles);
//        System.out.println("------层级最大值-------");
//        List<Integer> list = util.largestOfLevel(node5);
//        System.out.println(list);
//        System.out.println("-----最大深度--------");
//        int maxDeep = util.maxDeep(node5);
//        System.out.println(maxDeep);
//        System.out.println("-----最小深度--------");
//        int minDeep = util.minDeep(node5);
//        System.out.println(minDeep);
//        TreeNode treeNode = util.reverseTree(node5);
//        util.bfs(treeNode);
//        System.out.println(util.levelOrderList);
//        System.out.println("------是否是对称二叉树------");
//        System.out.println(util.isSymmetric(node5));
//        System.out.println("--------所有路径----------");
//        System.out.println(util.binaryTreePaths(node5));
//        System.out.println("--------有序数组构建平衡二叉树-----------");
//        int[] arr = {-10, -3, 0, 5, 9};
//        TreeNode treeNode = util.sortArrayToBst(arr);
//        util.bfs(treeNode);
//        System.out.println(util.levelOrderList);
//        System.out.println("------路径之和-------");
//        // 这个5 是总数减去root的val
//        System.out.println(util.roadSum(node5, 5));
//        System.out.println("-----最大二叉树------");
//        TreeNode node = util.maxBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
//        System.out.println(node);
        System.out.println("-------求众数---------");
        TreeNode node55 = new TreeNode(55);
        TreeNode node45 = new TreeNode(45);
        TreeNode node452 = new TreeNode(45);
        node55.right = node45;
        node45.left = node452;
        int[] mode = util.findMode(node55);
        System.out.println(Arrays.toString(mode));
    }
}

class TreeNodeUtil {
    private TreeNode root;

    public TreeNodeUtil(TreeNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    /**
     * 中序遍历
     */
    public List<Integer> infixOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        infixOrder(root, result);
        return result;
    }

    /**
     * 后序遍历
     */
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private void preOrder(TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    private void infixOrder(TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        infixOrder(root.left, result);
        result.add(root.val);
        infixOrder(root.right, result);
    }

    private void postOrder(TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

    public List<List<Integer>> levelOrderList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun01(root, 0);
        return levelOrderList;
    }

    // DFS - 递归方式，层序遍历
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null) {
            return;
        }
        deep++;
        if (levelOrderList.size() < deep) {
            // 当层次增加时，list中的item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<>();
            levelOrderList.add(item);
        }
        levelOrderList.get(deep - 1).add(node.val);
        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }

    // BFS ,借助队列
    public void bfs(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode tmpNode = queue.poll();
                itemList.add(tmpNode.val);
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
                len--;
            }
            levelOrderList.add(itemList);
        }
    }

    // 右视图
    public List<Integer> rightSideView(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(node);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.pollFirst();
                if (tmp.left != null) {
                    queue.offerLast(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offerLast(tmp.right);
                }
                if (i == len - 1) {
                    list.add(tmp.val);
                }
            }
        }
        return list;
    }

    public List<Double> averageOfLevel(TreeNode node) {
        List<Double> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int size = len;
            int level = 0;
            while (len > 0) {
                TreeNode poll = queue.poll();
                level += poll.val;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                len--;
            }
            list.add(level * 1.0 / size);
        }
        return list;
    }

    public List<Integer> largestOfLevel(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int len = queue.size();
            while (len > 0) {
                TreeNode poll = queue.poll();
                if (poll.val > max) {
                    max = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                len--;
            }
            list.add(max);
        }
        return list;
    }

    public int maxDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int deep = 0;
        queue.offer(node);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                len--;
            }
            deep++;
        }
        return deep;
    }

    public int minDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int deep = 0;
        queue.offer(node);
        while (!queue.isEmpty()) {
            int len = queue.size();
            deep++;
            while (len > 0) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return deep;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                len--;
            }

        }
        return deep;
    }

    public TreeNode reverseTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        reverseTree(node.left);
        reverseTree(node.right);
        swapChild(node);
        return node;
    }

    private void swapChild(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }

    public boolean isSymmetric(TreeNode node) {
        return compare(node.left, node.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean compareOutside = compare(left.left, right.right);
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }

    public List<String> binaryTreePaths(TreeNode node) {
        List<String> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(node, paths, res);
        return res;
    }

    private void traversal(TreeNode node, List<Integer> paths, List<String> res) {
        paths.add(node.val);
        //
        if (node.left == null && node.right == null) {
            // 输出
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }
        // 递归和回溯同时进行
        if (node.left != null) {
            traversal(node.left, paths, res);
            paths.remove(paths.size() - 1);
        }
        if (node.right != null) {
            traversal(node.right, paths, res);
            paths.remove(paths.size() - 1);
        }
    }

    public TreeNode sortArrayToBst(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }

    public boolean roadSum(TreeNode node, int count) {
        if (node.left == null && node.right == null && count == 0) {
            return true;
        }
        if (node.left == null && node.right == null && count != 0) {
            return false;
        }
        if (node.left != null) {
            count -= node.left.val;
            if (roadSum(node.left, count)) {
                return true;
            }
            count += node.left.val;
        }
        if (node.right != null) {
            count -= node.right.val;
            if (roadSum(node.right, count)) {
                return true;
            }
            count += node.right.val;
        }
        return false;
    }

    // 从中序与后序遍历序列构造二叉树
    // 中序   左中右 9 3 15 20 7
    // 后序   左右中 9 15 7 20 3
    Map<Integer, Integer> map;

    public TreeNode build(int[] inOrder, int[] postOrder) {
        map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return findNode(inOrder, 0, inOrder.length, postOrder, 0, postOrder.length);
    }

    public TreeNode findNode(int[] inOrder, int inBegin, int inEnd, int[] postOrder, int postBegin, int postEnd) {
        // 参数里面的范围都是前闭后开
        if (inBegin >= inEnd || postBegin >= postEnd) {
            return null;
        }
        int rootIndex = map.get(postOrder[postEnd - 1]); // 找到后序遍历的最后一个元素，在中序遍历中的位置
        TreeNode root = new TreeNode(inOrder[rootIndex]);// 构造节点
        int lenOfLeft = inBegin - rootIndex; // 保存中序左子数个数，用来确定后序数列的个数
        root.left = findNode(inOrder, inBegin, rootIndex, postOrder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inOrder, rootIndex + 1, inEnd, postOrder, postBegin + 1, postEnd - 1);
        return root;
    }

    public TreeNode maxBinaryTree(int[] arr) {
        if (arr.length == 1) {
            return new TreeNode(arr[0]);
        }
        int maxVal = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
                index = i;
            }
        }
        // 构建 中间节点
        TreeNode node = new TreeNode(maxVal);
        // 构建左节点
        if (index > 0) {
            int[] newArr = new int[index];
            for (int i = 0; i < index; i++) {
                newArr[i] = arr[i];
            }
            node.left = maxBinaryTree(newArr);
        }
        if (index < arr.length - 1) {
            int[] newArr = new int[arr.length - 1 - index];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = arr[index + i + 1];
            }
            node.right = maxBinaryTree(newArr);
        }
        return node;
    }

    // 合并两个二叉树
    public TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = merge(t1.left, t2.left);
        t1.right = merge(t1.right, t2.right);
        return t1;
    }

    public TreeNode findTreeNode(TreeNode node, int target) {
        if (node == null) {
            return null;
        }
        if (node.val == target) {
            return node;
        }
        if (node.val > target) {
            return findTreeNode(node.left, target);
        } else {
            return findTreeNode(node.right, target);
        }
    }

    // 验证是否是二叉搜索树
    List<Integer> list = new ArrayList<>();

    public boolean verifyBinaryTree(TreeNode node) {
        if (node == null) {
            return true;
        }
        verifyBinaryTree(node.left);
        list.add(node.val);
        verifyBinaryTree(node.right);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 找出众数，出现频率最高的数
    List<Integer> list2 = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int maxCnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list2.size(); i++) {
            int count = map.getOrDefault(list2.get(i), 0) + 1;
            maxCnt = Math.max(maxCnt, count);
            map.put(list2.get(i), count);
        }
        List<Integer> result = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == maxCnt) {
                result.add(key);
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list2.add(root.val);
        dfs(root.right);
    }

    // 求p和q的公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        // 后序遍历

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 处理 中 的逻辑
        if (left != null && right != null) {// 说明找到了p，q
            return root;
        } else if (left != null && right == null) {// 只找到了一个节点
            return left;
        } else if (left == null && right != null) {// 只找到了一个节点
            return right;
        } else {
            return null;
        }
    }

    // 求p和q的公共祖先，针对二叉搜索树，二叉搜索树，左节点小于根节点，右节点大于根节点
    public TreeNode binaryTreeLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            TreeNode left = binaryTreeLowestCommonAncestor(root.left, p, q);
            if (left != null) {
                return left;
            }
        }
        if (root.val < p.val && root.val < q.val) {
            TreeNode right = binaryTreeLowestCommonAncestor(root.right, p, q);
            if (right != null) {
                return right;
            }
        }
        return root;
    }

    // 二叉搜索树插入
    public TreeNode binaryTreeInsert(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        if (val < root.val) {
            root.left = binaryTreeInsert(root.left, val);
        }
        if (val > root.val) {
            root.right = binaryTreeInsert(root.right, val);
        }
        return root;
    }

    // 删除二叉搜索树中的节点
    public TreeNode binaryTreeDel(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.val == val) {
            // 左子树为空
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // 左右子树都不为空
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        if (root.val > val) {
            root.left = binaryTreeDel(root.left, val);
        }
        if (root.val < val) {
            root.right = binaryTreeDel(root.right, val);
        }
        return root;
    }

    // 修建二叉树，将不在low - high 之间的节点删除
    public TreeNode xiujian(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }
        if (root.val < low) {
            return xiujian(root.right, low, high);
        }
        if (root.val > high) {
            return xiujian(root.left, low, high);
        }
        root.left = xiujian(root.left, low, high);
        root.right = xiujian(root.right, low, high);
        return root;
    }

    int pre = 0;

    public void leijiashu(TreeNode cur) {
        if (cur == null) {
            return;
        }
        leijiashu(cur.right); // 右节点
        cur.val += pre; // 中间节点
        pre = cur.val;
        leijiashu(cur.left); // 左节点
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
