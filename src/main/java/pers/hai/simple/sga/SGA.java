package pers.hai.simple.sga;

/**
 * <p>
 * 遗传算法主程序
 * </p>
 * 2016年2月2日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class SGA {

    private static final int GENE_COUPLE = 22; // 基因数
    private static final int CHROMOSOME_COUPLE = 10; // 染色体数
    
    /**
     * 对外提供的执行遗传算法的接口
     * 
     * @param cycles
     *      遗传的代数
     * @return
     */
    public BestGene execute(int cycles) {
        if (cycles <= 0) {
            return null;
        }
        
        BestGene gene = new BestGene();
        String[] chromosomes = initChromosomes();
        
        for (int i = 0; i < cycles; i++) {
            core(chromosomes, gene);
            gene.setGenerations(i);
        }
        
        return gene;
    }
    
    /*
     * 算法核心逻辑
     * 
     * @param gene
     */
    private void core(String[] chromosomes, BestGene gene) {
        select(chromosomes);
        cross(chromosomes);
        mutation(chromosomes);
    }
    
    private void select(String[] chromosomes) {
        // TODO
    }
    
    private void cross(String[] chromosomes) {
        // TODO
    }
    
    private void mutation(String[] chromosomes) {
        // TODO
    }
    
    // --------------------------------------------------------------------------
    
    /*
     * 随机生成一条染色体的二进制表示
     * 
     * @return
     *      染色体的二进制表示
     */
    private String initChromosome() {
        StringBuffer buffer = new StringBuffer();
        
        for (int i = 0; i < GENE_COUPLE; i++) {
            if (Math.random() > 0.5) {
                buffer.append("0");
            } else {
                buffer.append("1");
            }
        }
        
        return buffer.toString();
    }

    /*
     * 随机生成一组染色体的二进制表示
     * 
     * @return
     *      染色体组
     */
    private String[] initChromosomes() {
        String[] chromosomes = new String[CHROMOSOME_COUPLE];
        for (int i = 0; i < CHROMOSOME_COUPLE; i++) {
            chromosomes[i] = initChromosome();
        }
        return chromosomes;
    }
}
