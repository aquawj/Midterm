package midterm;

import java.util.*;

public class MidTerm {

	public static <E> void reverse(ArrayList<E> list) {
		int origSize = list.size();
		for (int i = origSize - 1; i >= 0; i--) {
			list.add(list.get(i));
		}
		for (int i = 0; i < origSize; i++) {
			list.remove(list.get(0));
		}
		System.out.print("Reverse list: ");
		for (int i = 0; i < origSize; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println("");
	}

	public static String generateStrings(String s1, String s2) {
		String str = "";

		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				String combination = Character.toString(s1.charAt(i)) + Character.toString(s2.charAt(j));
				if (!str.contains(combination)) {
					str += combination + " ";
				}
			}
		}

		return str;
	}

	public static int singleNumber(int[] nums) {
		int missingLocation = 0;
		ArrayList<Integer> location = new ArrayList<Integer>();
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (location.contains(i)) {
					break;
				}
				if (nums[i] == nums[j]) {
					location.add(i);
					location.add(j);
				} else
					continue;
			}
		}
		for (int i = 0; i < location.size(); i++) {
			if (!location.contains(i)) {
				missingLocation = i;
			}
		}
		return nums[missingLocation];
	}

	public int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] indices = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			}
		}
		for (int i = 0; i < nums.length; i++) {
			int another = target - nums[i];
			if (map.containsKey(another)) {
				indices[0] = map.get(nums[i]);
				indices[1] = map.get(another);
				break;
			}
		}
		return indices;
	}

	public List<Integer> getRow(int rowIndex) {
		List<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= rowIndex; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
				for (int j = 0; j < i; j++) {
					if ((j == 0) || (j == i - 1)) {
						row.add(1);
					} else {
						row.add(triangle.get(i - 2).get(j - 1) + triangle.get(i - 2).get(j));
					}
				}
			
			triangle.add(row);
		}
		return triangle.get(rowIndex-1);
	}

	public static void main(String[] args) {
		MidTerm md = new MidTerm();
		ArrayList<Integer> ls = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			ls.add(i);
		}
		reverse(ls);

		String s1 = "ABCD";
		String s2 = "EFGH";
		System.out.println("Generate String: " + generateStrings(s1, s2));

		s1 = "ACDC";
		s2 = "ABBA";
		System.out.println("Generate String: " + generateStrings(s1, s2));

		int[] nums = { 2, 2, 5, 4, 5, 6, 4 };
		System.out.println("Single number: " + singleNumber(nums));

		int[] nums2 = { 2, 7, 11, 15 };
		System.out.println("indices: [" + md.twoSum(nums2, 9)[0] + " " + md.twoSum(nums2, 9)[1] + "]");

		System.out.println("1st row of Pascal's triangle: " + md.getRow(1));
		System.out.println("2nd row of Pascal's triangle: " + md.getRow(2));
		System.out.println("3th row of Pascal's triangle: " + md.getRow(3));
		System.out.println("4th row of Pascal's triangle: " + md.getRow(4));

	}

}
