package HashFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MakeReciepe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] recipes = {"xevvq","izcad","p","we","bxgnm","vpio","i","hjvu","igi","anp","tokfq","z","kwdmb","g","qb","q","b","hthy"};
		String[][] ingredients = {{"wbjr"},{"otr","fzr","g"},{"fzr","wi","otr","xgp","wbjr","igi","b"},{"fzr","xgp","wi","otr","tokfq","izcad","igi","xevvq","i","anp"},{"wi","xgp","wbjr"},{"wbjr","bxgnm","i","b","hjvu","izcad","igi","z","g"},{"xgp","otr","wbjr"},{"wbjr","otr"},{"wbjr","otr","fzr","wi","xgp","hjvu","tokfq","z","kwdmb"},{"xgp","wi","wbjr","bxgnm","izcad","p","xevvq"},{"bxgnm"},{"wi","fzr","otr","wbjr"},{"wbjr","wi","fzr","xgp","otr","g","b","p"},{"otr","fzr","xgp","wbjr"},{"xgp","wbjr","q","vpio","tokfq","we"},{"wbjr","wi","xgp","we"},{"wbjr"},{"wi"}};
		String[] supplies = {"wi","otr","wbjr","fzr","xgp"};
		solve(recipes, ingredients, supplies);
	}
	
	public static List<String> solve(String[] recipes,String[][] ingredients,String[] supplies){
		HashSet<String>suppliesSet=(HashSet<String>) Arrays.stream(supplies).collect(Collectors.toSet());
		List<String>ans = new ArrayList<>();
		HashMap<String,String[]>notPrepared=new HashMap<>();
		for(int i=0;i<recipes.length;i++) {
			String[] reqIngredient=ingredients[i];
			boolean prepared=true;
			for(String req:reqIngredient) {
				if(!suppliesSet.contains(req)) {
					prepared=false;
					break;
				}
			}
			if(prepared) {
				suppliesSet.add(recipes[i]); 
				ans.add(recipes[i]);
			}else {
				notPrepared.put(recipes[i],reqIngredient);
			}
			
		}
		System.out.println(ans);
		return ans;
	}

}
