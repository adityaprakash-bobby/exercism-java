package org.example.satellite;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Satellite {

    private Node recursiveBuildTreeUtil(int preIdx, List<Character> preorder, List<Character> inorder, int inStartIdx, int inEndIdx) {
        if (inStartIdx > inEndIdx) return null;

        Node localRoot = new Node(preorder.get(preIdx));

        if (inStartIdx == inEndIdx) return localRoot;

        int localRootIdx = inStartIdx;
        for (int i = inStartIdx; i <= inEndIdx; i++)
            if (localRoot.value == inorder.get(i)) localRootIdx = i;

        localRoot.left = recursiveBuildTreeUtil(++preIdx, preorder, inorder, inStartIdx, localRootIdx - 1);
        localRoot.right = recursiveBuildTreeUtil(++preIdx, preorder, inorder, localRootIdx + 1, inEndIdx);

        return localRoot;
    }

    public Tree treeFromTraversals(List<Character> preorderInput, List<Character> inorderInput) {
        if (preorderInput.size() != inorderInput.size())
            throw new IllegalArgumentException("traversals must have the same length");


        if (preorderInput.stream().distinct().count() != preorderInput.size())
            throw new IllegalArgumentException("traversals must contain unique items");


        if (Stream.of(preorderInput, inorderInput).flatMap(Collection::stream).distinct().count() != preorderInput.size())
            throw new IllegalArgumentException("traversals must have the same elements");

        return new Tree(recursiveBuildTreeUtil(0, preorderInput, inorderInput, 0, preorderInput.size() - 1));
    }
}
