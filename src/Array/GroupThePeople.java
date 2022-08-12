package Array;

import Common.PrintUtils;

import java.util.*;

/**
 * [1282] Group the People Given the Group Size They Belong To
 *
 * @author huangrui
 * @date 2022/8/12
 */
public class GroupThePeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        Map<Integer, List<Integer>> sizeToPeople = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (sizeToPeople.containsKey(groupSizes[i])) {
                sizeToPeople.get(groupSizes[i]).add(i);
            } else {
                List<Integer> people = new ArrayList<>();
                people.add(i);
                sizeToPeople.put(groupSizes[i], people);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Integer size : sizeToPeople.keySet()) {
            List<Integer> people = sizeToPeople.get(size);
            List<Integer> group = new ArrayList<>();
            for (Integer person : people) {
                group.add(person);
                if (group.size() == size) {
                    result.add(group);
                    group = new ArrayList<>();
                }
            }
        }
        return result;
    }

    public List<List<Integer>> groupThePeople2(int[] groupSizes) {

        Map<Integer, List<List<Integer>>> sizeToGroup = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<List<Integer>> groupList;
            List<Integer> group;
            if (sizeToGroup.containsKey(groupSizes[i])) {
                groupList = sizeToGroup.get(groupSizes[i]);
                group = groupList.get(groupList.size() - 1);
            } else {
                groupList = new ArrayList<>();
                group = new ArrayList<>();
                groupList.add(group);
                sizeToGroup.put(groupSizes[i], groupList);
            }
            group.add(i);
            if (group.size() == groupSizes[i]) {
                result.add(group);
                groupList.add(new ArrayList<>());
            }
        }
        return result;
    }

    public List<List<Integer>> groupThePeople3(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList[] hash = new ArrayList[500];
        for (int i = 0; i < groupSizes.length; i++) {
            if (hash[groupSizes[i]] == null) {
               hash[groupSizes[i]] = new ArrayList(groupSizes[i]);
            }
            hash[groupSizes[i]].add(i);
            if (hash[groupSizes[i]].size() == groupSizes[i]) {
                result.add(new ArrayList<>(hash[groupSizes[i]]));
                hash[groupSizes[i]].clear();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GroupThePeople groupThePeople = new GroupThePeople();
        PrintUtils.print(groupThePeople.groupThePeople3(new int[]{3, 3, 3, 3, 3, 1, 3}));
        PrintUtils.print(groupThePeople.groupThePeople3(new int[]{2, 1, 3, 3, 3, 2}));
    }
}
