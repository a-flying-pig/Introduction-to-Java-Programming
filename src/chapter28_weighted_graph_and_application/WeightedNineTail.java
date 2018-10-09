package chapter28_weighted_graph_and_application;

import java.util.List;
import java.util.Scanner;

import chapter27_graph_and_application.NineTailModel;

public class WeightedNineTail {
	public static void main(String[] args) {
		// Prompt the user to enter nine coin H's and T's
		System.out.print("Enter an initial nine coin H's and T's: ");
		Scanner input = new Scanner(System.in);
		String string = input.nextLine();
		char[] initialNode = string.toCharArray();
		input.close();
		
		WeightedNineTailModel model = new WeightedNineTailModel();
		List<Integer> path = model.getShortestPath(NineTailModel.getIndex(initialNode));
		
		System.out.println("The steps to flip the coins are ");
		for (int i = 0; i < path.size(); i++)
			NineTailModel.printNode(NineTailModel.getNode(path.get(i).intValue()));
		
		System.out.println("The number of flips is " + 
		    model.getNumberOfFlips(NineTailModel.getIndex(initialNode)));
	}
}
