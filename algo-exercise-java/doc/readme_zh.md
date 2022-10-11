# 项目介绍

leetcode 刷题记录; 典型算法实现记录

对应的 leetcode 题目链接记录在注释中

提供一批工具函数,方便本地调试时构造输入

# 包含工具函数

leetcode 相关的几个工具介绍:

在 com.helipy.leetcodecn 包里

ListNode: 单向链表

- ListNode ListNode.parseListNodeFromJsonStr(String jsonString) : 从 json 数组构造单向列表
- ListNode ListNode.parseListNodeFromList(List<Integer> valList) : 从 List<Integer> 构造单向列表
- List<Integer> ListNode.convertToList(ListNode head) : 把单向链表转化为 List
- String ListNode.convertToJson(ListNode head) : 把单向链表转化为 json 字符串

TreeNode: 二叉树

- String TreeNode.convertToLeetCodeJson(TreeNode root) : 把二叉树转化为 leetcode 表示形式的字符串
- TreeNode TreeNode.parseTreeFromLeetCodeJsonStr(String jsonStr) : 把 leetcode 表示形式的字符串转化为二叉树
- TreeNode TreeNode.parseTreeFromFullBinaryJsonStr(String jsonStr) : 从完全二叉树的 json 字符串构造树
- TreeNode TreeNode.parseTreeFromFullBinaryTree(List<Integer> itemList) : 从数组形式的完全二叉树构造二叉树
- List<Integer> TreeNode.convertToFullBinaryTree(TreeNode root) : 把二叉树转换成数组形式的完全二叉树
- void TreeNode.printAsFullBinaryTree(TreeNode root) : 以完全二叉树的形式逐层打印二叉树,如遇空值,打印 null

Pair: 把两个值打包

LtcUtil: 一些工具函数

- int[][] LtcUtil.buildIntMatrix(String json) : 把 json 字符串表示的二维数组转变为二维数组

# 包

- com.helipy.common: 一些常用算法
- com.helipy.leetcodecn.jzof2: 剑指offer(第二版)对应的题目
- com.helipy.leetcodecn.main: leetcodecn主站对应的题目

