package org.example.treebuilding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class BuildTree {
    private static void validateRecords(ArrayList<Record> records) throws InvalidRecordsException {
        records.sort(Comparator.comparing(Record::getRecordId));

        for (int i = 0; i < records.size(); i++) {
            Record record = records.get(i);
            if (record.getRecordId() != i) throw new InvalidRecordsException("Invalid Records");

            if (record.getParentId() == record.getRecordId() && record.getRecordId() != 0)
                throw new InvalidRecordsException("Invalid Records");

            if (record.getParentId() > record.getRecordId()) throw new InvalidRecordsException("Invalid Records");
        }
    }

    TreeNode buildTree(ArrayList<Record> records) throws InvalidRecordsException {
        validateRecords(records);

        Map<Integer, TreeNode> treeNodeMap = new HashMap<>(records.size());
        records.forEach(record -> treeNodeMap.put(record.getRecordId(), new TreeNode(record.getRecordId())));
        for (Record record : records) {
            TreeNode treeNode = treeNodeMap.get(record.getRecordId());
            TreeNode parentTreeNode = treeNodeMap.get(record.getParentId());
            if (treeNode.getNodeId() != 0) parentTreeNode.getChildren().add(treeNode);
        }
        return treeNodeMap.getOrDefault(0, null);
    }
}