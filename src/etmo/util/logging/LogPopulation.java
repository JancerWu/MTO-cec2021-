package etmo.util.logging;

import etmo.core.ProblemSet;
import etmo.core.Solution;
import etmo.core.SolutionSet;

import java.io.File;

public class LogPopulation {
    // Single Population
    public static void LogPopulation(String algoName, SolutionSet population, ProblemSet problemSet, int eval, boolean isMulTask){
        File folder = new File("D:\\_r\\EA\\ETMO\\MTO-cec2021-\\datas\\" + algoName);
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
        }

        if (isMulTask) {
            int taskNum = problemSet.size();
            SolutionSet[] resPopulation = new SolutionSet[taskNum];
            for (int i = 0; i < taskNum; i++)
                resPopulation[i] = new SolutionSet();

            for (int i = 0; i < population.size(); i++) {
                Solution sol = population.get(i);

                int pid = sol.getSkillFactor();

                int start = problemSet.get(pid).getStartObjPos();
                int end = problemSet.get(pid).getEndObjPos();

                Solution newSolution = new Solution(end - start + 1);

                for (int k = start; k <= end; k++)
                    newSolution.setObjective(k - start, sol.getObjective(k));

                resPopulation[pid].add(newSolution);
            }
            for (int k = 0; k < taskNum; k++)
                resPopulation[k].printObjectivesToFile(algoName + "\\" + algoName + "_" + problemSet.get(k).getNumberOfObjectives() + "Obj_" +
                        problemSet.get(k).getName() + "_" + problemSet.get(k).getNumberOfVariables() + "D" + eval + ".txt");
        }
        else{
            population.printObjectivesToFile(algoName + "\\" + algoName + "_"+problemSet.get(0).getNumberOfObjectives()+"Obj_"+
                    problemSet.get(0).getName()+ "_" + problemSet.get(0).getNumberOfVariables() + "D" + eval + ".txt");
        }
    }

    // Sub-population
    public static void LogPopulation(String algoName, SolutionSet[] population, ProblemSet problemSet, int eval){
        File folder = new File("D:\\_r\\EA\\ETMO\\MTO-cec2021-\\datas\\" + algoName);
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
        }
        int taskNum = problemSet.size();
        SolutionSet resPopulation[] = new SolutionSet[taskNum];
        for (int k = 0; k < taskNum; k++) {
            resPopulation[k] = new SolutionSet();
            for (int i = 0; i < population[k].size(); i++) {
                Solution sol = population[k].get(i);

                int start = problemSet.get(k).getStartObjPos();
                int end = problemSet.get(k).getEndObjPos();

                Solution newSolution = new Solution(end - start + 1);

                for (int kk = start; kk <= end; kk++)
                    newSolution.setObjective(kk - start, sol.getObjective(kk));

                resPopulation[k].add(newSolution);
            }
            resPopulation[k].printObjectivesToFile(algoName + "\\" + algoName + "_"+problemSet.get(k).getNumberOfObjectives()+"Obj_"+
                    problemSet.get(k).getName()+ "_" + problemSet.get(k).getNumberOfVariables() + "D" + eval + ".txt");
        }
    }
}
