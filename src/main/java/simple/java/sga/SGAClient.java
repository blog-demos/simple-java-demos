package simple.java.sga;

public class SGAClient {

    public static void main(String[] args) {
        SGA sga = new SGA();
        BestGene gene = sga.execute(10000);
        System.out.println("方程最小值：" + gene.getFitness() + ", 存在于第" + gene.getGenerations() + "个染色体上.");
    }
}
