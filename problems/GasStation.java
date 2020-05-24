public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost){
		int n = gas.length;
		int canbeCompleted = 0;
		int visited = 0;
		int startingIndex = 0;
		for(int i = 0; i < n; i++){
			canbeCompleted += gas[i] - cost[i];
			visited += gas[i] -  cost[i];
			if(visited < 0){
				startingIndex = i + 1;
				visited = 0;
			}
		}
		return canbeCompleted >= 0? startingIndex : -1;
	}
}